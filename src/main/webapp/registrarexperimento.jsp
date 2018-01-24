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
        <title>QPA | Registrar Experimento</title>
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
        <%String divMensagem = "";%>
            <%  if(session.getAttribute("ExperimentoSucess") != null){
            divMensagem = "<div class=\" alert alert-danger alert-dismissible\" role=\"alert\"><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Experimento cadastrado com sucesso!</strong></div>";
            session.removeAttribute("ExperimentoSucess");
        }
            if(session.getAttribute("ExperimentoDanger") != null){
                divMensagem = "<div class=\" alert alert-danger alert-dismissible\" role=\"alert\"><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Erro ao cadastrar experimento!</strong></div>";
                session.removeAttribute("ExperimentoDanger");
            }
        System.out.println(divMensagem);
        %>
        <div class="row container col-md-3 col-md-offset-5">
           <%= divMensagem %></div>
        </div>
        <div class="container">
            <form action="RegistrarExperimento" method="POST" role="form" class="col-md-offset-2 col-md-8">
                <legend>Registrar Experimento</legend>
                <div class="form-group">
                    <label for="nome">Nome do Experimento</label>
                    <input type="text" class="form-control" name="nome" placeholder="Nome do Experimento" required>
                    <div class="form-group">
                        <label for="descricao">Descrição:</label>
                        <textarea class="form-control" rows="5" name="descricao" id="descricao" style="resize: none"></textarea>
                    </div>
                    <label for="replicacao">Replicação</label>
                    <select name="replicacao" id="replicacao" class="form-control">
                        <option value="0">Não pode ser replicado</option>
                        <option value="1">Pode ser replicado</option>
                    </select>
                    <label for="data_inicial">Data do Início do Experimento</label>
                    <input type="date" class="form-control" name="data_inicial" id="data_inicial" required>
                    <span class="validity"></span>
                </div>
                <label for="replicacao">Replicação</label>
                <select name="replicacao" id="replicacao" class="form-control">
                    <option value="0">Não pode ser replicado</option>
                    <option value="1">Pode ser replicado</option>
                </select>
                <label for="data_inicial">Data do Início do Experimento</label>
                <input type="date" class="form-control" name="data_inicial" id="data_inicial" required>
                <span class="validity"></span>
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
