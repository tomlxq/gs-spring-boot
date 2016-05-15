<#include "header.ftl">
<div class="container">

    <div id="resp"></div>
    <input type="button" onclick="req();" value="请求"/>

</div>
<@jsMac/>
<script>
    function req() {
        $.ajax({
            url: "convert",
            data: "tom-luo",//注意此处的格式
            type: "POST",
            contentType: "application/x-tom",
            success: function (data) {
                $("#resp").html(data);
            }
        });
    }

</script>
<#include "footer.ftl">