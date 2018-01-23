<%-- 
    Document   : definirexperimento
    Created on : Jan 18, 2018, 5:39:26 PM
    Author     : sidious
--%>

<%@page import="com.mycompany.model.Experimento"%>
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
            Experimento experimento = null;
            if (session.getAttribute("user") == null) {
                response.sendRedirect("login.jsp");
            } else {
                user = (String) session.getAttribute("user");
                experimento = (Experimento) session.getAttribute("experimento");
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
        <jsp:include page="/DefinirExperimento" />
        <%@include file="base/navbarlogged.jsp" %>
        <div class="container">
            <form action="DefinirExperimento" method="POST" role="form" class="col-md-12">
                <div class="form-group">
                    <label for="obj_Estudo">Objeto de Estudo</label>
                    <input type="text" class="form-control" name="objEstudo" id="obj_Estudo">
                    <div class="form-group">
                        <label for="objetivo">Objetivo</label>
                        <textarea class="form-control" rows="5" name="objetivo" id="objetivo" style="resize: none"></textarea>               
                    </div>
                    <div class="form-group">
                        <label for="perspectiva">Perspectiva</label>
                        <textarea class="form-control" rows="5" name="perspectiva" id="perspectiva" style="resize: none"></textarea>               
                    </div>
                    <div class="form-group">
                        <label for="focoQualidade">Foco em Qualidade</label>
                        <input type="text" class="form-control" name="focoQualidade" id="focoQualidade">               
                    </div>
                    <div class="form-group">
                        <label for="contexto">Contexto</label>
                        <textarea class="form-control" rows="5" name="contexto" id="contexto" style="resize: none"></textarea>               
                    </div>
                    <div class="container row form-group">
                        <label for="editavel">Editável</label>
                        <input type="checkbox" name="editavel" id="editavel" value="editavel">
                        <br>
                        <label for="concluido">Concluído</label>
                        <input type="checkbox" name="concluido" id="concluido" value="concluido">
                    </div>
                    <span class="validity"></span>
                </div>
                <button type="submit" class="btn btn-primary">Registrar</button>
                <button type="reset" class="btn btn-default">Limpar</button>
            </form>
        </div>
        <hr>
        <%@include file="base/footer.jsp" %>
        <%@include file="base/scripts.jsp" %>
    </body>
</html>