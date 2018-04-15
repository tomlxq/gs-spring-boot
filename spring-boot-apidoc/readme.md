###apidoc简介

apidoc通过在你代码的注释来生成api文档的。它对代码没有侵入性，只需要你写好相关的注释即可，并且它仅通过写简单的配置就可以生成高颜值的api接口页面。它基于node.js，所以你需要安装node.js环境。node.js安装，点击这里。这里就不介绍。

###准备工作

安装完node.js安装api.doc,它的项目源码：https://github.com/apidoc/apidoc

###注释怎么写
````
@api
@api {method} path [title]

method：请求方法，
path：请求路径 
title(可选)：标题
````

````
@apiDescription
@apiDescription text
text说明
````

````
@apiError
@apiError [(group)] [{type}] field [description]

（group）（可选）：参数将以这个名称分组，不设置的话，默认是Error 4xx 
{type}（可选）：返回值类型，例如：{Boolean}, {Number}, {String}, {Object}, {String[]} 
field：返回值字段名称 
descriptionoptional（可选）：返回值字段说明
````

````
@apiGroup
@apiGroup name
name：组名称，也是导航的标题
````

更多注释，参见官方文档：http://apidocjs.com/#params

#步骤

1. 首先写配置文件

    在项目的主目录新建一个apidoc.json文件：
    ````
    {
      "name": "example",
      "version": "0.1.0",
      "description": "A basic apiDoc example"
    }
    ````
更多配置参考：http://apidocjs.com/#configuration

2. 写个注释:
    ````
    
        /**
         * @api {POST} /register 注册用户
         * @apiGroup Users
         * @apiVersion 0.0.1
         * @apiDescription 用于注册用户
         * @apiParam {String} account 用户账户名
         * @apiParam {String} password 密码
         * @apiParam {String} mobile 手机号
         * @apiParam {int} vip = 0  是否注册Vip身份 0 普通用户 1 Vip用户
         * @apiParam {String} [recommend] 邀请码
         * @apiParamExample {json} 请求样例：
         *                ?account=sodlinken&password=11223344&mobile=13739554137&vip=0&recommend=
         * @apiSuccess (200) {String} msg 信息
         * @apiSuccess (200) {int} code 0 代表无错误 1代表有错误
         * @apiSuccessExample {json} 返回样例:
         *                {"code":"0","msg":"注册成功"}
         */
    ````

3. 用apidoc命令生成文档界面

    先cd到工程的外层目录，并在外层目建个输出文档的目录，我建的是docapi
    ````
    apidoc -i spring-boot-apidoc  -o apidoc/
    ````

#参考资料

[apidoc](https://github.com/apidoc/apidoc)

[apidocjs.com](http://apidocjs.com/)

[使用apidoc 生成Restful web Api文档](https://blog.csdn.net/soslinken/article/details/50468896)