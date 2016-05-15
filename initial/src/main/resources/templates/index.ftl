<#include "header.ftl">
<div class="container">

    value from inteceptor 处理耗时:${handleTime!}ms
    <h1>服务器消息推送</h1>
    <div id="msg_from_server"></div>
</div>
<@jsMac/>

<script
        type="text/javascript">
    var json = {"name": "tom", "password": "123", "email": "tom@qq.com"};

    $.ajax({
        url: "/getXml",
        data: JSON.stringify(json),
        type: "POST",
        contentType: "application/json",
        success: function (data) {
            console.log(data);
        }
    });
    $.ajax({
        url: "/getJson",
        data: JSON.stringify(json),
        type: "POST",
        contentType: "application/json",
        success: function (data) {
            console.log(data);
        }
    });

    if (!!window.EventSource) {
        var source = new EventSource('push'); //为http://localhost:8080/testSpringMVC/push
        s = '';
        source.addEventListener('message', function (e) {

            s += e.data + "<br/>";
            $("#msg_from_server").html(s);

        });

        source.addEventListener('open', function (e) {
            console.log("连接打开.");
        }, false);

        source.addEventListener('error', function (e) {
            if (e.readyState == EventSource.CLOSED) {
                console.log("连接关闭");
            } else {
                console.log(e.readyState);
            }
        }, false);
    } else {
        console.log("没有sse");
    }
</script>
<#include "footer.ftl">

