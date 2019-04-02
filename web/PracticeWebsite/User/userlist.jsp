<%@ page import="Entity.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: benjamin
  Date: 2019-04-01
  Time: 08:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <% User user=((User)session.getAttribute("user"));
        if(user==null){
            out.print("未登录");
        }else{
            out.print(user.getUname());
        }
    %>
    <%--<c:if test="${user == null}"></c:if>--%>

</div>
<a href="useradd.jsp"><input type="button" value="添加"></a>
<table>
    <caption>显示用户信息</caption>
    <tr>
        <th>用户名</th>
        <th>电话号码</th>
        <th>住址</th>
        <th>操作</th>
    </tr>
    <%--<%--%>
        <%--List<User> userList=(List<User>)request.getAttribute("users");--%>
        <%--for(User u:userList) {--%>
            <%--out.print("<tr >"+--%>
                    <%--"<td >" +u.getUname()+"</td >"+--%>
                    <%--"<td >" +u.getTelephone()+"</td >"+--%>
                    <%--"<td >" + u.getAddress()+"</td >"+--%>
                    <%--"<td > <a href='delete.user?id="+u.getUid()+"'>删除</a> &nbsp;&nbsp;&nbsp;<a href='find.user?id="+u.getUid()+"'>修改</a></td ></tr >");--%>
        <%--}--%>
    <%--%>--%>
    <c:forEach items = "${users}" var = "user">
        <tr>
        <td>${user.uname}</td>
        <td>${user.telephone}</td>
        <td>${user.address}</td>
        <td> <a href='delete.user?id=${user.uid}'>删除</a>
            &nbsp;&nbsp;&nbsp;
            <a href='find.user?id=${user.uid}'>修改</a></td >
        </tr >
    </c:forEach>
</table>
</body>
</html>
