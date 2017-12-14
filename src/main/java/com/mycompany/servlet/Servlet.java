package com.mycompany.servlet;

import com.mycompany.controller.Controller;

public class Servlet {

	public void parameterPessoa(String senha,String nome) {
		Controller controller  = new Controller();
		controller.cadastrarPessoa(senha, nome);
	}

	@WebServlet("/login")
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException{ 
 	  try{
		username = request.getParameter("userName"); 
		password = request.getParameter("password");

		Controller controller = new Controller();
		Usuario usuario = controller.selectUser(username);
		if(usuario.getNomeUsuario() == username && usuario.getSenha()){
			request.getSession().setAttribute("nomeUsuario", username);
			response.sendRedirect("/admin");
		}
	  }catch (IOException e){
         Logger.getLogger(Aluno.class.getName()).log(Logger.Level.FATAL, null, e);
      }
	}
	
}
