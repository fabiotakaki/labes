package com.mycompany.servlet;

import com.mycompany.controller.Controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");

        String n1 = req.getParameter("n1");
        String n2 = req.getParameter("n2");

        Controller controller = new Controller();
        controller.cadastrarPessoa(n1, n2);

    }

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
