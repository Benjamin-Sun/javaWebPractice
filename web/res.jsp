<%--
  Created by IntelliJ IDEA.
  User: benjamin
  Date: 2019-03-26
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String req = (String) request.getAttribute("username");
    out.print(req);
%>

</body>
</html>
