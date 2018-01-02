<%-- 
    Document   : home
    Created on : Jan 2, 2018, 9:27:33 PM
    Author     : sidious
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <!-- Latest compiled and minified JavaScript -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>QPA | Home</title>
    </head>
    <body>
        <% 
            // Only allow autenticated users
            String user = null;
            if(session.getAttribute("user") == null){
                response.sendRedirect("login.html");
            }else user = (String) session.getAttribute("user");
            String username = null;
            String sessionID = null;
            Cookie[] cookies = request.getCookies();
            if(cookies != null){
                for(Cookie c : cookies){
                    if(c.getName().equals("user"))
                        username = c.getValue();
                    if(c.getName().equals("JSESSIONID"))
                        sessionID = c.getValue();
                }
            }
        %>
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
                        <li><a href="logout.jsp">Sair <i class="fas fa-sign-out-alt"></i></a>
                            <form action="LogoutServlet" method="post">
                                <input type="submit" value="Logout" >
                            </form>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div>
        </nav>
        <div class="jumbotron">
            <div class="container">
                <h1 class="">QPA</h1>
                <p>Curta apresentação da ferramenta</p>
                <p><a class="btn btn-primary btn-lg" href="#" role="button">Saiba mais &raquo;</a></p>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <h2>O que é?</h2>
                    <p>lorem ipsum</p>
                </div>
                <div class="col-md-4">
                    <h2>Quem usa?</h2>
                    <p>lorem ipsum</p>
                </div>
                <div class="col-md-4">
                    <h2>Características</h2>
                    <p>lorem ipsum</p>
                </div>
                <h3>Bem vindo <%= username %>, você foi autenticado com sucesso. SESSIONID = <%= sessionID %></h3>
            </div>
            <hr>
            <footer>
                <p>&copy; 2017 LES Inc.</p>
            </footer>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.0.1/js/all.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
