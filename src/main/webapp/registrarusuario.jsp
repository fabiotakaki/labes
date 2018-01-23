<%-- 
    Document   : registrarusuario
    Created on : Jan 9, 2018, 4:00:13 PM
    Author     : sidious
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="base/header.jsp" %>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <title>QPA | Registro</title>
    </head>
    <body>
        <%@include file="base/navbar.jsp" %>
        <%String divMensagem = "";%>
            <%  if(session.getAttribute("UsuarioSuccess") != null){ 
            divMensagem = "<div class=\" alert alert-danger alert-dismissible\" role=\"alert\"><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Usuário cadastrado com sucesso!</strong></div>";
            session.removeAttribute("UsuarioSucess");
        }            
            if(session.getAttribute("UsuarioDanger") != null){
                divMensagem = "<div class=\" alert alert-danger alert-dismissible\" role=\"alert\"><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button><strong>Erro ao cadastrar usuário!</strong></div>";
                session.removeAttribute("UsuarioDanger");
            }
        System.out.println(divMensagem);
        %>
        <div class="row container col-md-3 col-md-offset-5">
           <%= divMensagem %></div>
        </div>
        <div class="container">
            <form id="formCadastrar" action="RegistrarUsuario" method="POST" role="form" class="col-md-offset-5 col-md-3">
                <legend>Registrar Experimentador</legend>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" class="form-control" name="email" id="" placeholder="Digite seu email" minlength="5" maxlength="25" required>
                    <br>
                    <label for="senha">Senha:</label>
                    <input type="password" id="senha"  name="senha" class="form-control" placeholder="Digite sua senha" minlength="8" maxlength="20" required>
                    <br>
                    <label for="confirmasenha">Confirmar Senha:</label>
                    <input type="password" id="confirmasenha" name="confirmasenha" class="form-control" placeholder="Digite sua senha novamente" minlength="8" maxlength="20" onfocusout="validarSenha()" required>
                </div>
                <button onclick="validarSenhaSubmit()" class="btn btn-primary">Registrar</button>
            </form>
        </div>
        
        <div class="container">
            <hr>
            <%@include file="base/footer.jsp" %>
        </div>
        <%@include file="base/scripts.jsp" %>
    </body>
</html>
<script>

function validarSenha(){
   Senha = document.getElementById('senha').value;
   CSenha = document.getElementById('confirmasenha').value;
   if (Senha != CSenha && CSenha != "") {
      alert("SENHAS DIFERENTES!\nFAVOR DIGITAR SENHAS IGUAIS");
      $("#confirmasenha").val("");
   }
}

function validarSenhaSubmit(){
   Senha = document.getElementById('senha').value;
   CSenha = document.getElementById('confirmasenha').value;
   if (Senha != CSenha && CSenha != "") {
      alert("SENHAS DIFERENTES!\nFAVOR DIGITAR SENHAS IGUAIS");
      $("#confirmasenha").val("");
   }
   else{
       document.formCadastrar.submit();
   }
}

</script>