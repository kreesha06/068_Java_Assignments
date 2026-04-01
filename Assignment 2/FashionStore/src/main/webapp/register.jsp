<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Registration</title>
    </head>
    <body>
        <h2>New User Registration</h2>

        <%-- Display error message if servlet sends one --%>
        <%
            String error = (String) request.getAttribute("error");
            if (error != null) {
        %>
        <div style="color:red;"><%= error%></div>
        <% }%>

        <form action="<%= request.getContextPath()%>/RegisterServlet" method="post">
            Name: 
            <input type="text" name="username" 
                   value="<%= request.getParameter("username") != null ? request.getParameter("username") : ""%>"><br>

            Login ID: 
            <input type="text" name="login" 
                   value="<%= request.getParameter("login") != null ? request.getParameter("login") : ""%>"><br>

            Password: 
            <input type="password" name="password"><br>

            Email: 
            <input type="email" name="email" 
                   value="<%= request.getParameter("email") != null ? request.getParameter("email") : ""%>"><br>

            <%-- Generate captcha and store in session --%>
            <%
                int captcha = new Random().nextInt(9000) + 1000; // 1000-9999
                session.setAttribute("captcha", captcha);
            %>
            Captcha: <%= captcha%>
            <input type="text" name="captcha"><br>

            <input type="submit" value="Register">
        </form>
    </body>
</html>
