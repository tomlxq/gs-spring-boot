<#include "header.ftl">
<div class="container">
    <h1>配置拦截器 addInterceptors </h1>
    <p>统计页面执行时间 处理耗时:${handleTime!}ms </p>
    <h1>静态资源映射 addResourceHandlers</h1>
    <p>
    <pre>
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    </pre>
    <p>

    <h1>服务器消息推送</h1>
    <p><label>pushMessage: </label><a href="/pushMessage">pushMessage</a></p>
    <h1>文件上传 配置multipartResolver</h1>
    <p><label>文件上传: </label><a href="/fileupload">file upload</a></p>
    <H1>视图配置ContentNegotiatingViewResolver</H1>
    <p><label>freemarker: </label><a href="/getContent">content</a></p>
    <p><label>pdf: </label><a href="/getContent.pdf">content</a></p>
    <p><label>xml: </label><a href="/getContent.xml">content</a></p>
    <p><label>json: </label><a href="/getContent.json">content</a></p>
    <h1>快捷定义ViewController</h1>
    <p>
        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/index");
        registry.addViewController("/pushMessage").setViewName("/pushMessage");
        registry.addViewController("/fileupload").setViewName("/fileupload");
        //添加更多
        }
    </p>
</div>
<@jsMac/>


<#include "footer.ftl">

