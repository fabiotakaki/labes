package com.mycompany.servlet;

import com.mycompany.controller.ControllerUsuario;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="RegistrarUsuario", urlPatterns = {"/RegistrarUsuario"})
public class RegistrarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String htmlResponse = "<html>";
            if (createUsuario(request, response)) {
                htmlResponse += "<h2>Usuário cadastrado com sucesso!</h2>";
                htmlResponse += "</html>";
            } else {
                htmlResponse += "<h2>Erro ao cadastrar o usuário, verifique o log para mais detalhes!</h2>";
                htmlResponse += "</html>";
            }
            out.println(htmlResponse);
        } finally {
            out.close();
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
        //System.out.println("Entrou");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        return ControllerUsuario.createUsuario(email, senha);
    }

}
