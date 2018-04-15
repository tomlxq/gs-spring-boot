#springboot集成swagger2，构建优雅的Restful API

RESTful API的重磅好伙伴Swagger2，它可以轻松的整合到Spring Boot中，并与Spring MVC程序配合组织出强大RESTful API文档。它既可以减少我们创建文档的工作量，同时说明内容又整合入实现代码中，让维护文档和修改代码整合为一体，可以让我们在修改代码逻辑的同时方便的修改文档说明。另外Swagger2也提供了强大的页面测试功能来调试每个RESTful API。

swagger,中文“拽”的意思。它是一个功能强大的api框架，它的集成非常简单，不仅提供了在线文档的查阅，而且还提供了在线文档的测试。
另外swagger很容易构建restful风格的api。

写生产文档的注解

swagger通过注解表明该接口会生成文档，包括接口名、请求方法、参数、返回信息的等等。

|ANNOTATION|DESC|
|----|-----|
|@Api|修饰整个类，描述Controller的作用|
|@ApiOperation|描述一个类的一个方法，或者说一个接口|
|@ApiParam|单个参数描述|
|@ApiModel|用对象来接收参数|
|@ApiProperty|用对象接收参数时，描述对象的一个字段|
|@ApiResponse|HTTP响应其中1个描述|
|@ApiResponses|HTTP响应整体描述|
|@ApiIgnore|使用该注解忽略这个API|
|@ApiError |发生错误返回的信息|
|@ApiParamImplicitL|一个请求参数|
|@ApiParamsImplicit|多个请求参数|

通过相关注解，就可以让swagger2生成相应的文档。如果你不需要某接口生成文档，只需要在加@ApiIgnore注解即可。需要说明的是，如果请求参数在url上，@ApiImplicitParam 上加paramType = “path” 。

启动工程，访问：http://localhost:8080/swagger-ui.html 

#参考资料

[swagger.io](http://swagger.io/docs/)

[Spring Boot中使用Swagger2构建强大的RESTful API文档](http://blog.didispace.com/springbootswagger2/)