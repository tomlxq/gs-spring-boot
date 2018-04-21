package com.example;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/*import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJwtApplicationTests {

    @Test
    public void contextLoads() {
    }
    //公共密钥客户端不会知道
    public static String SECRET="FreeMaNong";

    public static  String  createToken() throws UnsupportedEncodingException {
        //签名发布时间
        Date iatDate=new Date();
        System.out.println(iatDate);//英文时间

        //设置签名过期时间  1分钟
        Calendar nowTime=Calendar.getInstance();
        nowTime.add(Calendar.MINUTE,1);
        Date expiresDate=nowTime.getTime();
        //System.out.println(expiresDate);

        Map<String,Object> map=new HashMap<String, Object>();
        map.put("alg","HS256");//设置算法 为HS256
        map.put("typ","JWT");//设置类型为JWT

        String token=Jwts.builder().setClaims(map).setExpiration(iatDate).signWith(SignatureAlgorithm.HS512, SECRET).compact();
        /*String token=JWT.create().withHeader(map)
                .withClaim("name","Free码农")
                .withClaim("age","28")
                .withClaim("org","今日头条")
                .withClaim("username","chenyu")
                .withIssuedAt(iatDate)//设置签发时间
                .withExpiresAt(expiresDate)//设置过去时间 过期时间大于签发时间
                .sign(Algorithm.HMAC256(SECRET));//用公共密钥加密
        //System.out.println(token);*/
        return token;
    }

    public static Claims/*Map<String,Claim>*/ verifyToken(String token) throws UnsupportedEncodingException {
        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();

        return claims;
       /* JWTVerifier verifier =JWT.require(Algorithm.HMAC256(SECRET)).build();//用公共密钥解密验证
        DecodedJWT jwt=null;
        try{
            jwt=verifier.verify(token);
        }catch (Exception e)
        {
            throw new RuntimeException("登录凭证已过去，请重新登录");
        }
        return jwt.getClaims();*/
    }


    @Test
    public void TestToken() throws UnsupportedEncodingException {
        String token=createToken();
        System.out.println("Token:"+token);
        Claims claims=verifyToken(token);
        System.out.println(claims.get("alg"));
        System.out.println(claims.get("typ"));

        //测试过期token
//        String GuoQiToken="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJhdXRoMCJ9.izVguZPRsBQ5Rqw6dhMvcIwy8_9lQnrO3vpxGwPCuzs";
//        Map<String,Claim> claims2=verifyToken(GuoQiToken);
    }



   /* @Test
    public void Test() throws UnsupportedEncodingException {
        Algorithm algorithm = Algorithm.HMAC256("secret");
        String token = JWT.create().withIssuer("auth0") .sign(algorithm);
        System.out.println(token);
    }*/
}
