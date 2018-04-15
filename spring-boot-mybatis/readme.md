#springboot下整合mybatis
1. 引入依赖

在pom文件引入mybatis-spring-boot-starter的依赖
````
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>1.3.2</version>
</dependency>
````
引入数据库连接依赖：
````
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.0.29</version>
</dependency>
````

###在springBoot+Mybatis日志显示SQL的执行情况的最简单方法就是在properties新增
````
logging.level.org.springframework=WARN
logging.level.com.example.dao=DEBUG
logging.file=spring-boot-mybatis/target/log/spring-boot-logging.log
````
logging.level.com.example.dao=DEBUG
注意：其中logging.level你的Mapper包=日志等级

###springboot中logback打印日志
springboot对logback的支持是非常好的，不需要任何配置，只需要在resource下加logback.xml就可以实现功能
\spring-boot-mybatis\src\main\resources\logback.xml
````
<?xml version="1.0" encoding="UTF-8"?>

<configuration scan="true" scanPeriod="60 seconds">
    <appender name="stdout" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{yyyy-M-d HH:mm:ss} %t %p %m%n</pattern>
        </encoder>
    </appender>
    <appender name="springboot"
              class="ch.qos.logback.core.rolling.RollingFileAppender">
        <!-- <Encoding>UTF-8</Encoding> -->
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <FileNamePattern>logs/logback/springboot_%d{yyyy-M-d}.log
            </FileNamePattern>
            <MaxHistory>10</MaxHistory>
        </rollingPolicy>
        <encoder>
            <pattern>%d{yyyy-M-d HH:mm:ss} %t %p %m%n</pattern>
        </encoder>
    </appender>
    <appender name="tom"
              class="ch.qos.logback.core.rolling.RollingFileAppender">
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <FileNamePattern>logs/logback/smile_%d{yyyy-M-d}.log
            </FileNamePattern>
            <MaxHistory>10</MaxHistory>
        </rollingPolicy>
        <encoder>
            <pattern>%d{yyyy-M-d HH:mm:ss} %t %p %m%n</pattern>
        </encoder>
    </appender>

    <logger name="org.springframework.boot" level="debug"
            additivity="false">
        <appender-ref ref="springboot"/>
    </logger>
    <!-- name包必须能够扫描到所以类，包括启动类 -->
    <logger name="com.example" level="debug" additivity="false">
        <appender-ref ref="tom"/>
    </logger>
    <root level="info">
        <appender-ref ref="stdout"/>
    </root>
</configuration>
````

#参考资料
[mybatis](http://www.mybatis.org/mybatis-3/zh/configuration.html#properties)

[MyBatis整合](http://blog.720ui.com/2016/springboot_02_data_mybatis/)