<#include "header.ftl">
<div class="container">
    <p><label for="name">name: </label> ${account.name}</p>
    <p><label for="email">email: </label> ${account.email}</p>
    <p><label for="password">password: </label> ${account.password}</p>
</div>
<@jsMac/>
<#include "footer.ftl">