<%-- 
    Document   : navbarlogged
    Created on : Jan 2, 2018, 10:13:59 PM
    Author     : sidious
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/labes/home.jsp">QPA</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav">
                    <li><a href="#">Experimentos</a></li>
                    <li><a href="#">Participantes</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="<%= response.encodeURL("logout.jsp") %>">Sair <i class="fas fa-sign-out-alt"></i></a>
                    <!--<form action="<%= response.encodeURL("LogoutServlet") %>" method="post">
                        <input type="submit" value="Logout" >
                    </form>-->
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div>
</nav>
