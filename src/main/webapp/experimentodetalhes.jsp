<%-- 
    Document   : experimentodetalhes
    Created on : Jan 9, 2018, 8:13:49 PM
    Author     : sidious
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="base/header.jsp" %>
        <title>QPA | Detalhes do Experimento</title>
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
        <jsp:include page="/DetalharExperimento" />
        <%@include file="base/navbarlogged.jsp" %>
        <div class="container">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <i class="fas fa-flask"></i>&nbsp; 
                    <a href="#">
                        ${experimento.nome}
                    </a>
                </div>
                <div class="panel-body">
                    ${experimento.descricao}
                </div>
                <div class="panel-footer">
                    <a class="btn btn-default" href="#">
                        <i class="fas fa-edit"></i>&nbsp; Alterar
                    </a>
                    <a class="btn btn-info" href="<%= response.encodeURL("definirexperimento.jsp?experimentoId=")%>${experimento.id}">
                        <i class="fas fa-wrench"></i>&nbsp; Definir
                    </a>
                </div>
            </div>
        </div>
        <hr>
        <%@include file="base/footer.jsp" %>
        <%@include file="base/scripts.jsp" %>
    </body>
</html>
