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
    <title>成功</title>
</head>
<body>
<%
    if (session == null) {
        response.sendRedirect("index.jsp");
    }
%>
<div>
    <label>操作结果:</label>
    <%=session.getAttribute("code")%>
</div>
<div>
    <%=session.getAttribute("result")%>
</div>
</body>
</html>
