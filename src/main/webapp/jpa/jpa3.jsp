<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/29
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jpa3</title>
</head>
<body>
<form name="f" action='bind' method="post" id="userform">
    <div>
        <label>id:</label>
        <label>
            <input class="theinput" type="text" name="id"/>
        </label>
        <br>
        <label>姓名:</label>
        <label>
            <input class="theinput" type="text" name="name"/>
        </label>
        <br>
        <label>性别:</label>
        <label>
            <input class="theinput" type="text" name="gender"/>
        </label>
        <br>
        <label>年龄:</label>
        <label>
            <input class="theinput" type="text" name="age"/>
        </label>
        <br>
        <label>课程:</label>
        <label>
            <input class="theinput" type="text" name="course"/>
        </label>

    </div>
    <br>
    <label>one2many:</label>
    <input class="submit" type="submit" value="insert" onclick="document.f.action='/hello/jpa3/one2many/add';document.f.submit();"/>
    <input class="submit" type="submit" value="select" onclick="document.f.action='/hello/jpa3/one2many/select';document.f.submit();"/>
    <input class="submit" type="submit" value="delete" onclick="document.f.action='/hello/jpa3/one2many/delete';document.f.submit();"/>
    <input class="submit" type="submit" value="update" onclick="document.f.action='/hello/jpa3/one2many/update';document.f.submit();"/>
    <br>
    <label>many2many:</label>
    <input class="submit" type="submit" value="insert" onclick="document.f.action='/hello/jpa/teacher/add';document.f.submit();"/>
    <input class="submit" type="submit" value="select" onclick="document.f.action='/hello/jpa/teacher/select';document.f.submit();"/>
    <input class="submit" type="submit" value="delete" onclick="document.f.action='/hello/jpa/teacher/delete';document.f.submit();"/>
    <input class="submit" type="submit" value="update" onclick="document.f.action='/hello/jpa/teacher/update';document.f.submit();"/>
    <br>
</form>
</body>
</html>


