
<%-- 
    Document   : cart
    Created on : 27-Jan-2026, 12:09:39 pm
    Author     : root
--%>
<%@ page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ page import="java.util.*,java.sql.*,db.dbConnection,model.CartItem" %>

        <h2>Your Cart</h2>

        <%
            ArrayList<CartItem> cart = (ArrayList<CartItem>) session.getAttribute("cart");
            double total = 0;

            if (cart == null || cart.isEmpty()) {
        %>
        Cart is empty
        <%
        } else {
            Connection con = dbConnection.getConnection();
            for (CartItem item : cart) {
                PreparedStatement ps = con.prepareStatement("SELECT product_name, price FROM product_master WHERE product_id=?");
                ps.setInt(1, item.getProductId());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    double price = rs.getDouble("price");
                    double subtotal = price * item.getQuantity();
                    total += subtotal;
        %>
        <div>
            <b><%= rs.getString("product_name")%></b> -
            Qty:
            <form action="UpdateCartServlet" method="post" style="display:inline;">
                <input type="hidden" name="productId" value="<%= item.getProductId()%>">
                <input type="number" name="quantity" value="<%= item.getQuantity()%>" min="1">
                <input type="submit" value="Update">
            </form>
            <a href="RemoveFromCartServlet?productId=<%= item.getProductId()%>">Delete</a>
            = ₹<%= subtotal%>
        </div>
        <%
                }
            }
        %>
        <hr>
        <h3>Total: ₹<%= total%></h3>

        <form action="success.jsp" method="post">
            <input type="hidden" name="total" value="<%= total%>">
            <input type="submit" value="place order">
        </form>
        <%
            }
        %>

</html>

