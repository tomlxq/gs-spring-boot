##一、自动配置
Spring Boot 不单单从 application.properties 获取配置，所以我们可以在程序中多种设置配置属性。按照以下列表的优先级排列：
1. 命令行参数
2. java:comp/env 里的 JNDI 属性
3. JVM 系统属性
4. 操作系统环境变量
5. RandomValuePropertySource 属性类生成的 random.* 属性
6. 应用以外的 application.properties（或 yml）文件
7. 打包在应用内的 application.properties（或 yml）文件
8. 在应用 @Configuration 配置类中，用 @PropertySource 注解声明的属性文件
9. SpringApplication.setDefaultProperties 声明的默认属性

可见，命令行参数优先级最高。这个可以根据这个优先级，可以在测试或生产环境中快速地修改配置参数值，而不需要重新打包和部署应用。
还有第 6 点，根据这个在多 moudle 的项目中，比如常见的项目分 api 、service、dao 等 moudles，往往会加一个 deploy moudle 去打包该业务各个子 moudle，应用以外的配置优先。

##二、自定义属性
通过 @ConfigurationProperties(prefix = "home”) 注解，将配置文件中以 home 前缀的属性值自动绑定到对应的字段中。同是用 @Component 作为 Bean 注入到 Spring 容器中。
注意这里，就有一个坑了：
application.properties 配置中文值的时候，读取出来的属性值会出现乱码问题。但是 application.yml 不会出现乱码问题。原因是，Spring Boot 是以 iso-8859 的编码方式读取 application.properties 配置文件。
注意这里，还有一个坑：
如果定义一个键值对 user.name=xxx ,这里会读取不到对应写的属性值。为什么呢？Spring Boot 的默认 StandardEnvironment 首先将会加载 “systemEnvironment" 作为首个PropertySource. 而 source 即为System.getProperties().当 getProperty时,按照读取顺序,返回 “systemEnvironment" 的值.即 System.getProperty("user.name")

##三、random.* 属性
Spring Boot 通过 RandomValuePropertySource 提供了很多关于随机数的工具类。概括可以生成随机字符串、随机 int 、随机 long、某范围的随机数。
运行 springboot-properties 工程 org.spring.springboot.property.PropertiesTest 测试类

##四、多环境配置
很多场景的配置，比如数据库配置、Redis 配置、注册中心和日志配置等。在不同的环境，我们需要不同的包去运行项目。所以看项目结构，有两个环境的配置：
application-dev.yaml：开发环境
application-prod.yaml：生产环境
Spring Boot 是通过 application.yaml 文件中，设置 spring.profiles.active 属性，比如 ，配置了 dev ,则加载的是 application-dev.yaml 

根据优先级，顺便介绍下 jar 运行的方式，通过设置 -Dspring.profiles.active=prod 去指定相应的配置:
mvn package
java -jar -Dspring.profiles.active=prod springboot-properties-0.0.1-SNAPSHOT.jar

>小结
常用的样板配置在 Spring Boot 官方文档给出，我们常在 application.properties（或 yml）去配置各种常用配置：
http://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html

>感谢资料：
http://blog.didispace.com/springbootproperties/
https://docs.spring.io/spring-boot/docs