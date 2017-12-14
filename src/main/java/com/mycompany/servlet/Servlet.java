package com.mycompany.servlet;

import com.mycompany.controller.Controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registrarusuario")
public class Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        try {
            String htmlResponse = "<html>";
            if (createUsuario(request, response)) {
                htmlResponse += "<h2>Usuario cadastrado com sucesso!</h2>";
                htmlResponse += "</html>";
            } else {
                htmlResponse += "<h2>ERRO ao cadastrar o usuário, consulte o log para mais detalhes!</h2>";
                htmlResponse += "</html>";
            }
            pw.println(htmlResponse);
        } finally {
            pw.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected boolean createUsuario(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email, senha;

        email = req.getParameter("email");
        senha = req.getParameter("senha");

        return Controller.cadastrarPessoa(email, senha);

    }

}
