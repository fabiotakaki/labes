<%-- 
    Document   : home
    Created on : Jan 4, 2018, 3:27:33 PM
    Author     : sidious
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="base/header.jsp" %>
        <title>QPA | Experimentos</title>
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
        <jsp:include page="/ListarExperimentos" />
        <%@include file="base/navbarlogged.jsp" %>
        <div class="container">
            <div class="row">
                <form class="navbar-form" role="search" method="get"
                  action="BuscaExperimento">
                <input type="text" class="form-control" name="q" placeholder="Busca">
                <button type="submit" class="btn btn-default">
                    <i class="fas fa-search"></i>
                </button>
                <a class="btn btn-success btn-lg pull-right" href="<%= response.encodeURL("registrarexperimento.jsp")%>">
                    <i class="fas fa-plus"></i>&nbsp; Adicionar Experimento
                </a>
            </form>
            </div>
            <br>

            <c:choose>
                <c:when test="${empty experimentos}">
                    <div class="panel panel-warning">
                        <div class="panel-heading">
                            <i class="fas fa-exclamation-triangle"></i>&nbsp;
                        </div>
                        <div class="panel-body">
                            Você não possui nenhum experimento.<br>
                            Adicione um novo experimento utilizando o botão acima.
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="panel-grap">
                        <c:forEach items="${experimentos}" var="experimento">
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
                            </div> 
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </div>
            <hr>
            <%@include file="base/footer.jsp" %>
        </div>
        <%@include file="base/scripts.jsp" %>
    </body>
</html>
