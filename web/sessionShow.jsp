<%--
  Created by IntelliJ IDEA.
  User: benjamin
  Date: 2019-03-27
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SessionShow</title>
</head>
<body>
<%
    String str = (String) session.getAttribute("username");
    out.print(str);
%>
</body>
</html>
