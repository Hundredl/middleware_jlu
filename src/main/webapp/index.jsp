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
        <label>专业:</label>
        <label>
            <input class="theinput" type="text" name="major"/>
        </label>
        <label>地址:</label>
        <label>
            <input class="theinput" type="text" name="address"/>
        </label>

    </div>
    <br>
    <input class="submit" type="submit" value="单实体插入" onclick="document.f.action='stu/add';document.f.submit();"/>
    <input class="submit" type="submit" value="单实体查询" onclick="document.f.action='stu';document.f.submit();"/>
    <input class="submit" type="submit" value="单实体删除" onclick="document.f.action='stu/del';document.f.submit();"/>
    <input class="submit" type="submit" value="单实体更新" onclick="document.f.action='stu/update';document.f.submit();"/>
    <br>
    <input class="submit" type="submit" value="一对一插入" onclick="document.f.action='student/add';document.f.submit();"/>
    <input class="submit" type="submit" value="一对一查询" onclick="document.f.action='student';document.f.submit();"/>
    <input class="submit" type="submit" value="一对一删除" onclick="document.f.action='student/del';document.f.submit();"/>
    <input class="submit" type="submit" value="一对一更新" onclick="document.f.action='student/update';document.f.submit();"/>
    <br>


</form>
</body>
</html>
