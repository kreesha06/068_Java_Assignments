<%-- 
    Document   : convert
    Created on : 2 Mar 2026, 5:21:17 pm
    Author     : khushi shah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Currency Converter - Modern Java Assignment</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="modern-style.css">
    </head>
    <body>
        <div class="container">
            <h1>Currency Converter</h1>
            
            <form action="ConvertServlet" method="post">
                <div class="form-group">
                    <label>From Currency</label>
                    <select name="from">
                        <option>USD</option>
                        <option>INR</option>
                        <option>EUR</option>
                    </select>
                </div>
                
                <div class="form-group">
                    <label>To Currency</label>
                    <select name="to">
                        <option>INR</option>
                        <option>USD</option>
                        <option>EUR</option>
                    </select>
                </div>
                
                <div class="form-group">
                    <label>Amount</label>
                    <input type="text" name="amount" placeholder="Enter amount..." required/>
                </div>
                
                <input type="submit" value="Convert Now"/>
            </form>
            
            <c:if test="${not empty result}">
                <div class="status-msg success" style="margin-top: 2rem;">
                    <span style="font-size: 0.875rem; display: block; color: var(--text-muted);">Converted Amount</span>
                    <span style="font-size: 1.5rem; font-weight: 800; color: var(--text);">${result}</span>
                </div>
            </c:if>
        </div>
    </body>
</html>
