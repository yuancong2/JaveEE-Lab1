<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
    } else {
        out.println("当前登录：" + session.getAttribute("username") );
    }
%>

<html>
<head>
    <title>登录成功</title>
</head>
<body>
    <p>欢迎，<%= session.getAttribute("username") %>！登录成功</p>
    <!--<a href="LoginServlet">注销</a>-->
</body>
</html>
