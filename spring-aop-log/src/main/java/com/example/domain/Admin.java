package com.example.domain;

/**
 * Created by tom on 2016/5/19.
 */
public class Admin extends IdEntity {

    private String nickname;//管理员帐号
    private String passwd;//管理员密码
    private String phoneno;//联系电话

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }
}
