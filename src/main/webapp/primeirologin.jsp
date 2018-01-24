<%-- 
    Document   : primeirologin
    Created on : Jan 17, 2018, 01:01:13 PM
    Author     : Darlan Nakamura
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="base/header.jsp" %>
        <title>QPA | Primeiro Login</title>
    </head>
    <body>
        <%
            // Only allow autenticated users
            String user = null;
            if (session.getAttribute("user") == null) {
                response.sendRedirect("login.jsp");
            } else {
                user = (String) session.getAttribute("user");
            }
            String userName = null;
            String sessionID = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (c.getName().equals("user")) {
                        userName = c.getValue();
                    }
                    if (c.getName().equals("JSESSIONID")) {
                        sessionID = c.getValue();
                    }
                }
            } else {
                sessionID = session.getId();
            }
        %>
        
        <%@include file="base/navbarlogged.jsp" %>
        <div class="container">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <form action="PrimeiroLoginServlet" method="POST" role="form"></form>
                     <div class="form-group">
                    <input type="nome" class="form-control" name="nome" placeholder="Insira seu nome" required>
                    <input type="email" name="email" class="form-control" placeholder="Insira seu e-mail" required>
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
                </div>
                <div class="panel-body">
                    
                </div>
            </div>
        </div>
        <hr>
        <%@include file="base/footer.jsp" %>
    </div>
    <%@include file="base/scripts.jsp" %>
</body>
</html>
