package com.mycompany.servlet;

import com.mycompany.controller.ControllerUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "RegistrarUsuario", urlPatterns = {"/RegistrarUsuario"})
public class RegistrarUsuario extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(RegistrarUsuario.class.getName());

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           //String htmlResponse = "<html>";
            HttpSession session = request.getSession();
            if (createUsuario(request, response)) {
                session.setAttribute("UsuarioSucess", "Usuario Cadastrado com Sucesso");
                
            } else {
                //htmlResponse += "<h2>Erro ao cadastrar o usuário, verifique o log para mais detalhes!</h2>";
                //htmlResponse += "</html>";
                //LOGGER.log(Level.SEVERE, "ERRO: [consulte banco]");
                session.setAttribute("UsuarioDanger", "Erro ao cadastrar usuário");
            }
            String encodeURL = response.encodeRedirectURL("registrarusuario.jsp");
            response.sendRedirect(encodeURL);
            //out.println(htmlResponse);
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
