构建工程

为例创建一个springmvc工程你需要spring-boot-starter-thymeleaf和 spring-boot-starter-web的起步依赖。为例能够上传文件在服务器，你需要在web.xml中加入标签做相关的配置，但在sringboot 工程中，它已经为你自动做了，所以不需要你做任何的配置。


创建文件上传controller
类通过@Controller注解，表明自己是一个Spring mvc的c。每个方法通过 @GetMapping 或者@PostMapping注解表明自己的 http方法。

GET / 获取已经上传的文件列表
GET /files/{filename} 下载已经存在于服务器的文件
POST / 上传文件给服务器