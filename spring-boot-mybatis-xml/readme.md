
1. 在springBoot+Mybatis日志显示SQL的执行情况的最简单方法就是在properties新增：

logging.level.com.dy.springboot.server.mapper=debug
注意：其中logging.level.com.你的Mapper包=日志等级


2. 在 application.properties 应用配置文件，增加 Mybatis 相关配置
````
## Mybatis 配置
mybatis.typeAliasesPackage=com.example.springbootmybatisxml.domain
mybatis.mapperLocations=classpath:mapper/*.xml
````
mybatis.typeAliasesPackage 配置为 com.example.springbootmybatisxml.domain，指向实体类包路径。mybatis.mapperLocations 配置为 classpath 路径下 mapper 包下，* 代表会扫描所有 xml 文件。
mybatis 其他配置相关详解如下：
````
mybatis.config = mybatis 配置文件名称
mybatis.mapperLocations = mapper xml 文件地址
mybatis.typeAliasesPackage = 实体类包路径
mybatis.typeHandlersPackage = type handlers 处理器包路径
mybatis.check-config-location = 检查 mybatis 配置是否存在，一般命名为 mybatis-config.xml
mybatis.executorType = 执行模式。默认是 SIMPLE
````

3. 在 Application 应用启动类添加注解 MapperScan
mapper 接口类扫描包配置注解 MapperScan ：用这个注解可以注册 Mybatis mapper 接口类。

##参考
* [利用 Mybatis-generator自动生成代码](http://www.cnblogs.com/yjmyzz/p/4210554.html) 
* [Mybatis 通用 Mapper3](https://github.com/abel533/Mapper)
* [Mybatis 分页插件 PageHelper](https://github.com/pagehelper/Mybatis-PageHelper) 