#spring-boot-starter-validation
使用 Hibernate Validator 框架来提供 Java Bean 验证功能。
##pom.xml需要加上依赖
validator 验证依赖主要在 web 依赖中，web 依赖包含了 hibernate-validator 依赖
##实体类
Bean Validation 规范，运行时的数据验证框架。它是 JSR 303 规范，Hibernate Validator 实现了这套规范，并扩展了一些注解，如下：
* @Null 被注释的元素必须为 null
* @NotNull 被注释的元素必须不为 null
* @Min(value) 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
* @Max(value) 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
* @Size(max, min) 被注释的元素的大小必须在指定的范围内
* @Email 被注释的元素必须是电子邮箱地址
* @Length 被注释的字符串的大小必须在指定的范围内
* @NotEmpty 被注释的字符串的必须非空
* @Range 被注释的元素必须在合适的范围内

##控制层 UserController
@Valid 注解到实体类，使实体类 User 中验证注解生效，
BindingResult ，是数据绑定的结果对象，从源码中可以看出，
其继承了 Errors 接口，所以所有的错误信息都会被绑定到这个对象。
通过 hasErrors() 方法判断是否有错误信息，如果有返回原页面，并展示错误信息。