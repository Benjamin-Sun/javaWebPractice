<%@ page import="Entity.User" %><%--
  Created by IntelliJ IDEA.
  User: benjamin
  Date: 2019-04-01
  Time: 08:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <%=((User)session.getAttribute("user")).getUname()%>

</div>
<%
    User user=(User) request.getAttribute("user");
%>
<form method="post" action="update.user">
    <table>
        <caption>修改用户</caption>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username" value="<%=user.getUname()%>"></td>
        </tr>
        <tr>
            <td>电话</td>
            <td><input type="text" name="telephone" value="<%=user.getTelephone()%>"></td>
        </tr>
        <tr>
            <td>地址</td>
            <td><input type="text" name="address" value="<%=user.getAddress()%>"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="hidden" name="uid" value="<%=user.getUid()%>">
                <input type="submit" value="修改">

            </td>
        </tr>
    </table>
</form>
</body>
</html>
