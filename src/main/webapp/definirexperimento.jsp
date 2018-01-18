<%-- 
    Document   : definirexperimento
    Created on : Jan 18, 2018, 5:39:26 PM
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
        <div class="container">
            <form action="DefinirExperimento" method="POST" role="form" class="col-md-offset-2 col-md-8">
                <div class="form-group">
                    <label for="objEstudo">Objeto de Estudo</label>
                    <input type="text" class="form-control" name="nome" required>
                    <div class="form-group">
                        <label for="objetivo">Descrição:</label>
                        <textarea class="form-control" rows="5" name="objetivo" style="resize: none"></textarea>                         
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
            <hr>
            <%@include file="base/footer.jsp" %>
        </div>
        <%@include file="base/scripts.jsp" %>
    </body>
</html>