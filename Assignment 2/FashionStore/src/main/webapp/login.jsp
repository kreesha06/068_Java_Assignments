<%-- 
    Document   : login
    Created on : 27-Jan-2026, 12:04:07 pm
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>User Login</h1>
        
        <form action="LoginServlet" method="post">
            Login ID: <input type="text" name="login"><br><br>
            Password: <input type="password" name="password"><br><br>

            <input type="submit" value="Login">
        </form>
        
        <br>
        <a href="register.jsp">New User?</a>
    </body>
</html>
