<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/26
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jpa</title>
</head>
<body>
<form name="f" action='bind' method="post" id="userform">
    <div>
        <label>id:</label>
        <label>
            <input class="theinput" type="text" name="id"/>
        </label>
        <label>姓名:</label>
        <label>
            <input class="theinput" type="text" name="name"/>
        </label>
        <label>性别:</label>
        <label>
            <input class="theinput" type="text" name="gender"/>
        </label>
        <label>年龄:</label>
        <label>
            <input class="theinput" type="text" name="age"/>
        </label>
        <label>课程:</label>
        <label>
            <input class="theinput" type="text" name="course"/>
        </label>

    </div>
    <br>
    <input class="submit" type="submit" value="单实体插入" onclick="document.f.action='/hello/jpa/mentor/add';document.f.submit();"/>
    <input class="submit" type="submit" value="单实体查询" onclick="document.f.action='/hello/jpa/mentor/select';document.f.submit();"/>
    <input class="submit" type="submit" value="单实体删除" onclick="document.f.action='/hello/jpa/mentor/delete';document.f.submit();"/>
    <input class="submit" type="submit" value="单实体更新" onclick="document.f.action='/hello/jpa/mentor/update';document.f.submit();"/>
    <br>
    <input class="submit" type="submit" value="一对一插入" onclick="document.f.action='/hello/jpa/teacher/add';document.f.submit();"/>
    <input class="submit" type="submit" value="一对一查询" onclick="document.f.action='/hello/jpa/teacher/select';document.f.submit();"/>
    <input class="submit" type="submit" value="一对一删除" onclick="document.f.action='/hello/jpa/teacher/delete';document.f.submit();"/>
    <input class="submit" type="submit" value="一对一更新" onclick="document.f.action='/hello/jpa/teacher/update';document.f.submit();"/>
    <br>


</form>
</body>
</html>

