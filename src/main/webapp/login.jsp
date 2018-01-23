<%-- 
    Document   : home
    Created on : Jan 2, 2018, 10:15:23 PM
    Author     : sidious
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="base/header.jsp" %>
        <title>QPA | Acesso</title>
    </head>
    <body>
        <%@include file="base/navbar.jsp" %>
        <div class="container">
            <form action="LoginServlet" method="POST" role="form" class="col-md-offset-5 col-md-3">
                <legend>Acessar sistema</legend>
                <div class="form-group">
                    <input type="email" class="form-control" name="email" placeholder="Email" required>
                    <input type="password" name="senha" class="form-control" placeholder="Senha" required>
                </div>
                <button type="submit" class="btn btn-primary">Acessar</button>
            </form>
        </div>
        <div class="container">
            <hr>
            <%@include file="base/footer.jsp" %>
        </div>
        <%@include file="base/scripts.jsp" %>
    </body>
</html>
