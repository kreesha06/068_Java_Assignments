<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Success</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                text-align: center;
                margin-top: 50px;
            }
            .success-message {
                border: 2px solid #4CAF50;
                display: inline-block;
                padding: 30px 50px;
                background-color: #e8f5e9;
                color: #2e7d32;
                border-radius: 10px;
            }
            .btn {
                margin-top: 20px;
                padding: 10px 20px;
                background-color: #4CAF50;
                color: white;
                text-decoration: none;
                border-radius: 5px;
                font-size: 16px;
            }
            .btn:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <body>

        <div class="success-message">
            <h2>✅ Your order has been placed successfully!</h2>
            <p>Thank you for shopping with us.</p>
            <a href="shop.jsp" class="btn">Continue Shopping</a>
            <a href="cart.jsp" class="btn">View Cart</a>
        </div>

    </body>
</html>
