<%-- 
    Document   : shop
    Created on : 27-Jan-2026, 12:05:50 pm
    Author     : root
--%>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="db.dbConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>

        <h2>Welcome ${sessionScope.user}</h2>
        <a href="cart.jsp">🛒 View Cart</a>
        <hr>

        <%
            try (Connection con = dbConnection.getConnection()) {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM product_master");

                while (rs.next()) {
        %>
        <div style="border:1px solid #aaa;padding:10px;margin:10px;">
            <h3><%= rs.getString("product_name")%></h3>
            Price: ₹<%= rs.getDouble("price")%><br>
            Discount: <%= rs.getDouble("discount")%>%<br>
            Stock: <%= rs.getInt("stock")%><br>
            <a href="CartServlet?productId=<%= rs.getInt("product_id")%>">Add to Cart</a>
        </div>
        <%
                }
            }
        %>

    </body>
</html>