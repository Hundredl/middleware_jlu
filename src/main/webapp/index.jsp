<%--
  Created by IntelliJ IDEA.
  User: 吴非凡
  Date: 2021/3/25
  Time: 下午2:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>绑定</title>
</head>
<body>
<form name="f" action='bind' method="post" id="userform">
    <div>
        <label>绑定名字:</label>
        <label>
            <input class="theinput" type="text" name="binding_name" required/>
        </label>
        <label>绑定值:</label>
        <label>
            <input class="theinput" type="text" name="binding_value"/>
        </label>
    </div>
    <br>
    <input class="submit" type="submit" value="绑定" onclick="document.f.action='bind';document.f.submit();"/>
    <input class="submit" type="submit" value="查询" onclick="document.f.action='search';document.f.submit();"/>
    <input class="submit" type="submit" value="重新绑定" onclick="document.f.action='rebind';document.f.submit();"/>
    <input class="submit" type="submit" value="取消绑定" onclick="document.f.action='cancel';document.f.submit();"/>

</form>
</body>
</html>
