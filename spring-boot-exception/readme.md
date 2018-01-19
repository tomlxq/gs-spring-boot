异常统一处理的使用场景
在前后端分离开发中，经常用 HTTP over JSON 作为服务进行前后端联调对接。这里简单介绍下为啥前后端分离开发？我想到如下：

1.低耦合，责权分离，模块化。前后端之间利用轻量级协议对接耦合。
2.便于敏捷开发：后端给出 api 文档 -> 前端根据文档，mock出数据开发 ；同时，后端实现业务逻辑。
3.微服务尤其适用

这时候 HTTP over JSON 形式中很多涉及到返回码，错误码相关的处理。比如xxx参数不完整，权限不足，用户不存在等。

怎么统一处理认为是异常的场景呢？
利用的是 Spring 4.x 提供的 RestControllerAdvice。这里做下说明，也可以根据 ControllerAdvice 去实现。这里案例是 HTTP over JSON 模式，所以直接利用
RestControllerAdvice ，控制层通知器，这里用于统一拦截异常，进行响应处理。

##1.控制层通知器
GlobalErrorInfoHandler.java 代码如下：

````
@RestControllerAdvice
public class GlobalErrorInfoHandler {
    @ExceptionHandler(value = GlobalErrorInfoException.class)
    public ResultBody errorHandlerOverJson(HttpServletRequest request,
    GlobalErrorInfoException exception) {
        ErrorInfoInterface errorInfo = exception.getErrorInfo();
        ResultBody result = new ResultBody(errorInfo);
        return result;
    }
}
````
@ExceptionHandler 注解，标记了使用 errorHandlerOverJson() 方法来处理 GlobalErrorInfoException 异常。
@RestControllerAdvice 是 @ControllerAdvice 和 @ResponseBody 的语义结合。是控制器增强，直接返回对象。这里用于统一拦截异常，然后返回错误码对象体。
@ResponseBody 作用： 该注解用于将 Controller 的方法返回的对象，通过适当的 HttpMessageConverter 转换为指定格式后，写入到 Response 对象的 body 数据区。


##2.响应码设计
简单讲讲，这里定义了一个错误码接口，全局错误码枚举和各个业务错误码枚举去实现接口，并用枚举值枚举出错误码及错误码消息列表。