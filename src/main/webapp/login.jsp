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
        <div class="row container col-md-3 col-md-offset-5">
               <%
                    String divMensagem = "";
                    if(session.getAttribute("loginDanger") != null){
                        divMensagem = "<div class=\" alert alert-danger alert-dismissible\" role=\"alert\"><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>E-mail e/ou senha incorretos!</strong></div>";
                        session.removeAttribute("loginDanger");
                    }
                %>
                <%= divMensagem %>
        </div>
        <div class="container">
            <form action="LoginServlet" method="POST" role="form" class="col-md-offset-5 col-md-3">
                <legend>Acessar sistema</legend>
                <div class="form-group">
                    <label for="email">E-mail:</label>
                    <input type="email" class="form-control" name="email" placeholder="" minlength="5" maxlength="25" required>
                    <br>
                    <label for="senha">Senha:</label>
                    <input type="password" name="senha" class="form-control" placeholder="" minlength="8" maxlength="30" required>
                </div>
                <button type="submit" class="btn btn-primary">Acessar</button>
                <br><br>
            </form>
            
             
        </div>
        <div class="container col-md-12">
            <hr>
            <%@include file="base/footer.jsp" %>
        </div>
        <%@include file="base/scripts.jsp" %>
    </body>
</html>