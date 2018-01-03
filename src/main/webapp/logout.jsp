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
        <title>QPA</title>
    </head>
    <body>
        <% 
            // Only allow autenticated users
            String user = null;
            if(session.getAttribute("user") == null){
                response.sendRedirect("login.jsp");
            }else user = (String) session.getAttribute("user");
            String username = null;
            String sessionID = null;
            Cookie[] cookies = request.getCookies();
            if(cookies != null){
                for(Cookie c : cookies){
                    if(c.getName().equals("user"))
                        username = c.getValue();
                }
            }
        %>
        <%@include file="base/navbarlogged.jsp" %>
        <div class="container">
            <h3>Deseja realmente sair? Qualquer trabalho não salvo será perdido.</h3>
            <br>
            <form action="LogoutServlet" method="post">
                <button type="submit" class="btn btn-primary">Sair</button>
            </form>
            <hr>
            <%@include file="base/footer.jsp" %>
        </div>
        <%@include file="base/scripts.jsp" %>
    </body>
</html>
