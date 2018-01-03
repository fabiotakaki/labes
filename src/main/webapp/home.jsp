<%-- 
    Document   : home
    Created on : Jan 2, 2018, 9:27:33 PM
    Author     : sidious
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="base/header.jsp" %>
        <title>QPA | Home</title>
    </head>
    <body>
        <% 
            // Only allow autenticated users
            String user = null;
            if(session.getAttribute("user") == null){
                response.sendRedirect("login.html");
            }else user = (String) session.getAttribute("user");
            String userName = null;
            String sessionID = null;
            Cookie[] cookies = request.getCookies();
            if(cookies != null){
                for(Cookie c : cookies){
                    if(c.getName().equals("user"))
                        userName = c.getValue();
                    if(c.getName().equals("JSESSIONID"))
                        sessionID = c.getValue();
                }
            }
        %>
        <%@include file="base/navbarlogged.jsp" %>
        <div class="jumbotron">
            <div class="container">
                <h1 class="">QPA</h1>
                <p>Curta apresentação da ferramenta</p>
                <p><a class="btn btn-primary btn-lg" href="#" role="button">Saiba mais &raquo;</a></p>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <h2>O que é?</h2>
                    <p>lorem ipsum</p>
                </div>
                <div class="col-md-4">
                    <h2>Quem usa?</h2>
                    <p>lorem ipsum</p>
                </div>
                <div class="col-md-4">
                    <h2>Características</h2>
                    <p>lorem ipsum</p>
                </div>
                <h3>Bem vindo <%= userName %>, você foi autenticado com sucesso. SESSIONID = <%= sessionID %></h3>
            </div>
            <hr>
            <%@include file="base/footer.jsp" %>
        </div>
        <%@include file="base/scripts.jsp" %>
    </body>
</html>
