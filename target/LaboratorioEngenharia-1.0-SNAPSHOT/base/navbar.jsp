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
            <a class="navbar-brand" href="/labes">QPA</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <!--<ul class="nav navbar-nav">
                <li class="active"><a href="#">Link</a></li>
                <li><a href="#">Link</a></li>
            </ul>-->
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="login.jsp">Acessar <i class="fas fa-sign-in-alt"></i></a></li>
                <li><a href="registrarusuario.html">Registrar <i class="fas fa-user-plus"></i></a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div>
</nav>
