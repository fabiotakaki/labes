package com.mycompany.servlet;

import com.mycompany.controller.Controller;

public class Servlet {

	public void parameterPessoa(String senha,String nome) {
		Controller controller  = new Controller();
		controller.cadastrarPessoa(senha, nome);
	}
	
}
