<%-- 
    Document   : registrarusuario
    Created on : Jan 9, 2018, 4:00:13 PM
    Author     : sidious
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="base/header.jsp" %>
        <title>QPA | Registro</title>
    </head>
    <body>
        <%@include file="base/navbar.jsp" %>
        <div class="container">
            <form action="RegistrarUsuario" method="POST" role="form" class="col-md-offset-5 col-md-3">
                <legend>Registrar Experimentador</legend>
                <div class="form-group">
                    <input type="email" class="form-control" name="email" id="" placeholder="Email" required>
                    <input type="password" name="senha" class="form-control" placeholder="Senha" required>
                </div>
                <button type="submit" class="btn btn-primary">Registrar</button>
            </form>
        </div>
        <div class="container">
            <hr>
            <%@include file="base/footer.jsp" %>
        </div>
        <%@include file="base/scripts.jsp" %>
    </body>
</html>
