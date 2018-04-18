#构建工程

创建一个springboot工程，由于用到了 web 、thymeleaf、validator、el，引入相应的起步依赖和依赖

#创建一个PersonForm的Object类

这个实体类，在2个属性:name,age.它们各自有验证的注解：

@Size(min=2, max=30) name的长度为2-30个字符
@NotNull 不为空
@Min(18)age不能小于18

#参考资料
https://spring.io/guides/gs/handling-form-submission/
https://spring.io/guides/gs/validating-form-input/

