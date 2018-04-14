1. spring boot结构
* pom文件为基本的依赖管理文件
statics 静态资源
templates 模板资源
application.yml 配置文件
* pom.xml的依赖
````
<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
 </dependency>
````
其中spring-boot-starter-web不仅包含spring-boot-starter,还自动开启了web功能。

###神奇之处：

你没有做任何的web.xml配置。
你没有做任何的sping mvc的配置; springboot为你做了。
你没有配置tomcat ;springboot内嵌tomcat.

2. 编译与运行
* 编译项目的jar
`mvn clean & mvn package`
* 启动
`mvn spring-boot:run`
* cd 到target目录，java -jar 项目.jar
````
cd target
java -jar spring-boot-first-0.0.1-SNAPSHOT.jar
````

3. 自定义属性的2种访问方式
\src\main\resources\application.yml
````
my:
  name: tom
  age: 12
````
````
@Value("${my.name}")
private String name;
````
````
@ConfigurationProperties(prefix = "my")
@Component
public class ConfigBean extends BaseObject{

    private String name;
    private int age;
}
用法:
@Autowired
ConfigBean configBean;
````

4. 多个环境配置文件
在现实的开发环境中，我们需要不同的配置环境；格式为application-{profile}.properties，其中{profile}对应你的环境标识，比如：

application-test.properties：测试环境
application-dev.properties：开发环境
application-prod.properties：生产环境
怎么使用？只需要我们在application.yml中加：
````
 spring:
  profiles:
    active: dev
````
其中application-dev.yml:
````
 server:
  port: 8082
```` 
启动工程，发现程序的端口不再是8080,而是8082。
http://localhost:8082/tom