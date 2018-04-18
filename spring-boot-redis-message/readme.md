#springboot中用reids实现消息队列

在spring data redis中，利用redis发送一条消息和接受一条消息，需要三样东西：
一个连接工厂
一个消息监听容器
Redis template

###CMD启动相应的window配置
`redis-server redis.windows.conf`

#参考资料

[messaging-redis](https://spring.io/guides/gs/messaging-redis/)