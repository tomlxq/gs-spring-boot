springboot开启事务很简单，只需要一个注解@Transactional 就可以了。因为在springboot中已经默认对jpa、jdbc、mybatis开启了事事务，引入它们依赖的时候，事物就默认开启。当然，如果你需要用其他的orm，比如beatlsql，就需要自己配置相关的事物管理器。



参考资料
[managing-transactions](https://spring.io/guides/gs/managing-transactions/)