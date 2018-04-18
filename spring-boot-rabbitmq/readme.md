#如何通过spring raabitmq去构建一个消息发送和订阅的程序。 
1. 机器需要安装rabbitmq
    你可以去官网下载，http://www.rabbitmq.com/download.html
    安装完成后开启服务器：
    rabbitmq-server
    网页登录方法
    http://127.0.0.1:15672/
    用户名和密码默认为guest/guest
    用java代码去连接rabbitmq用的端口是5672

2. 构建工程

    构架一个SpringBoot工程，其pom文件依赖加上spring-boot-starter-amqp的起步依赖：
    ````
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-amqp</artifactId>
    </dependency>
    ````

3. 创建消息接收者

    在任何的消息队列程序中，你需要创建一个消息接收者，用于响应发送的消息。
    
4. 创建消息监听，并发送一条消息

    在spring程序中，RabbitTemplate提供了发送消息和接收消息的所有方法。你只需简单的配置下就行了：
    
    需要一个消息监听容器
    声明一个quene,一个exchange,并且绑定它们
    一个组件去发送消息



参考资料
https://www.cnblogs.com/boshen-hzb/p/6841982.html
https://spring.io/guides/gs/messaging-rabbitmq/
http://docs.spring.io/spring-amqp/reference/html/_introduction.html#quick-tour