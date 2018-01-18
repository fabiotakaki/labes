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
            <div class="row">
                <div class="col-md-6 form-group">
                    <form action="LoginServlet" method="POST" role="form">
                        <legend>Acessar sistema</legend>
                        <div class="form-group">
                            <input type="email" class="form-control" name="email" placeholder="Email" required>
                            <input type="password" name="senha" class="form-control" placeholder="Senha" required>
                        </div>
                        <button type="submit" class="btn btn-primary">Acessar</button>
                        <button type="reset" class="btn btn-default">Limpar</button>
                    </form>
                </div>
                <div class="col-md-6 form-group">
                    <form action="PrimeiroAcesso" method="POST" role="form">
                        <legend>Primeiro Acesso</legend>
                        <div class="form-group">
                            <input type="nome" class="form-control" name="nome" placeholder="Insira seu nome" required>
                            <input type="email" name="email" class="form-control" placeholder="Insira seu e-mail" required>
                        </div>
                        <button type="submit" class="btn btn-primary">Acessar</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="container">
            <hr>
            <%@include file="base/footer.jsp" %>
        </div>
        <%@include file="base/scripts.jsp" %>
    </body>
</html>
