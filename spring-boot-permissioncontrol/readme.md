RESTful是无状态的，所以每次请求就需要对起进行认证和授权
身份认证，即登录验证用户是否拥有相应的身份。简单的说就是一个Web页面点击登录后，服务端进行用户密码的校验。
权限验证（授权）
也可以说成授权，就是在身份认证后，验证该身份具体拥有某种权限。即针对于某种资源的CRUD,不同用户的操作权限是不同的。

一般简单项目：做个sign（加密加盐参数）+ 针对用户的access_token

复杂的话，加入 SLL ，并使用OAuth2进行对token的安全传输。

 [理解本真的REST架构风格](http://www.infoq.com/cn/articles/understanding-restful-style "Spring Boot教程与Spring Cloud教程")<br>