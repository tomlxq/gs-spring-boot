
>介绍如何在springboot中如何创建含有多个module的工程，栗子中含有两个 module，一个作为libarary. 工程，另外一个是主工程，调用libary .其中libary jar有一个服务，main工程调用这个服务。

#创建根工程
````
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>spring-boot-multi-module</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>pom</packaging>

    <name>spring-boot-multi-module</name>
    <description>Demo project for Spring Boot</description>
    <modules>
        <module>libary</module>
        <module>application</module>
    </modules>
</project>
````
需要注意的是packaging标签为pom 属性。

#创建libary工程
libary工程为maven工程，其pom文件的packaging标签为jar 属性。创建一个service组件,它读取配置文件的 service.message属性。

#创建一个springbot工程
引入相应的依赖,创建一个web服务.

````
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>com.example</groupId>
        <artifactId>libary</artifactId>
        <version>${project.version}</version>
    </dependency>
</dependencies>
````
主工程需要依赖的另一个库libary

打印出了`Hello World`

说明确实引用了libary中的方法。

#参考资料
https://spring.io/guides/gs/multi-module/
