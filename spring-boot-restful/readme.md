##1.数据库准备
创建数据库 springbootdb & 插入数据：
````
mysql> create database springbootdb;
mysql> use springbootdb;
mysql> DROP TABLE IF EXISTS  `city`;
mysql> CREATE TABLE `city` (
    ->   `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '城市编号',
    ->   `province_id` int(10) unsigned  NOT NULL COMMENT '省份编号',
    ->   `city_name` varchar(25) DEFAULT NULL COMMENT '城市名称',
    ->   `description` varchar(25) DEFAULT NULL COMMENT '描述',
    ->   PRIMARY KEY (`id`)
    -> ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
mysql> INSERT city VALUES (1 ,1,'乐山市','tomlxq 的家在乐山。');
mysql> create user springbootdb;
mysql> grant all on springbootdb.* to springbootdb;
mysql> use mysql;
mysql> update user set authentication_string=password("123456") where user="springbootdb";
mysql> flush privileges;
````
##2.工程项目结构介绍
springboot-restful 工程项目结构如下图所示：
````
com.example.demo.controller - Controller 层
com.example.demo.dao - 数据操作层 DAO
com.example.demo.domain - 实体类
com.example.demo.service - 业务逻辑层
Application - 应用启动类
application.properties - 应用配置文件，应用启动会自动读取配置
````
改数据库配置
打开 application.properties 文件， 修改相应的数据源配置，比如数据源地址.账号.密码等。（如果不是用 MySQL，自行添加连接驱动 pom，然后修改驱动名配置。）

##3. 运行工程
右键运行 spring-boot-restful 工程 Application 应用启动类的 main 函数。
用 postman 工具可以如下操作，
根据 ID，获取城市信息
GET http://127.0.0.1:8080/api/city/1
获取城市列表
GET http://127.0.0.1:8080/api/city
新增城市信息
POST http://127.0.0.1:8080/api/city
更新城市信息
PUT http://127.0.0.1:8080/api/city
删除城市信息
DELETE http://127.0.0.1:8080/api/city/2

## 4.控制层实现详解
1.什么是 REST?
REST 是属于 WEB 自身的一种架构风格，是在 HTTP 1.1 规范下实现的。
Representational State Transfer 全称翻译为表现层状态转化。
Resource：资源。比如 newsfeed；
Representational：表现形式，比如用JSON，富文本等；
State Transfer：状态变化。通过HTTP 动作实现。

理解 REST ,要明白五个关键要素：
资源（Resource）
资源的表述（Representation）
状态转移（State Transfer）
统一接口（Uniform Interface）
超文本驱动（Hypertext Driven）

6 个主要特性：
面向资源（Resource Oriented）
可寻址（Addressability）
连通性（Connectedness）
无状态（Statelessness）
统一接口（Uniform Interface）
超文本驱动（Hypertext Driven）
具体这里就不一一展开，详见 http://www.infoq.com/cn/articles/understanding-restful-style
## 5.Spring 对 REST 支持实现
CityRestController.java 城市 Controller 实现 Restful HTTP 服务
@RequestMapping 处理请求地址映射。
````
method          指定请求的方法类型：POST/GET/DELETE/PUT 等
value           指定实际的请求地址
consumes        指定处理请求的提交内容类型，例如 Content-Type 头部设置application/json, text/html
produces        指定返回的内容类型
@PathVariable   URL 映射时，用于绑定请求参数到方法参数
@RequestBody    这里注解用于读取请求体 body 的数据，通过 HttpMessageConverter 解析绑定到对象中
````
## 6.HTTP 知识补充
````
GET         请求获取Request-URI所标识的资源
POST        在Request-URI所标识的资源后附加新的数据
HEAD        请求获取由Request-URI所标识的资源的响应消息报头
PUT         请求服务器存储一个资源，并用Request-URI作为其标识
DELETE      请求服务器删除Request-URI所标识的资源
TRACE       请求服务器回送收到的请求信息，主要用于测试或诊断
CONNECT     保留将来使用
OPTIONS     请求查询服务器的性能，或者查询与资源相关的选项和需求
````
##Issues:
1. Java连接Mysql数据库警告：Establishing SSL connection without server's identity verification is not recommend 
```
WARN: Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
url加上&useSSL=true
spring.datasource.url=jdbc:mysql://localhost:3306/springbootdb?useUnicode=true&characterEncoding=utf8&useSSL=true
```







