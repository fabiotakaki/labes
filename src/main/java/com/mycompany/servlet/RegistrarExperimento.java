/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlet;

import com.mycompany.controller.ControllerExperimento;
import com.mycompany.controller.ControllerUsuario;
import com.mycompany.model.Experimento;
import com.mycompany.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sidious
 */
@WebServlet(name = "RegistrarExperimento", urlPatterns = {"/RegistrarExperimento"})
public class RegistrarExperimento extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(RegistrarExperimento.class.getName());

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Experimento exp = createExperimento(request, response);
            HttpSession session = request.getSession();
            if (exp != null) {
                session.setAttribute("ExperimentoSuccess", "Experimento cadastrado com sucesso!");
                String encodeURL = response.encodeRedirectURL("experimentos.jsp");
                response.sendRedirect(encodeURL);
            } else {
                session.setAttribute("ExperimentoDanger", "Erro ao cadastrar experimento!");
                
                LOGGER.log(Level.SEVERE, "ERRO: [Erro na interação com o banco, consulte o log para mais detalhes]");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("home.jsp");
                out.println("<h2>Email ou senha inválidos!</h2>");
                rd.include(request, response);
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet responsável pelo registro de novos experimentos";
    }// </editor-fold>

    private Experimento createExperimento(HttpServletRequest request, HttpServletResponse response) {
        Experimento exp = null;
        try {
            String nome;
            String descricao;
            boolean isReplicavel;
            Calendar data_inicio;
            HttpSession session = request.getSession(false);
            //LOGGER.log(Level.INFO, "Entrou aqui");
            String userName = (String) session.getAttribute("user");
            //LOGGER.log(Level.INFO, userName);
            Usuario usuario = ControllerUsuario.buscaUsuarioEmail(userName);
            nome = request.getParameter("nome");
            descricao = request.getParameter("descricao");
            isReplicavel = request.getParameter("replicacao").equals("0");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT-03:00"));
            Date date = sdf.parse(request.getParameter("data_inicial"));
            data_inicio = Calendar.getInstance();
            data_inicio.setTime(date);
            exp = ControllerExperimento.createExperimento(nome, descricao, data_inicio, isReplicavel, usuario);
        } catch (ParseException ex) {
            LOGGER.log(Level.SEVERE, "ERRO: [{0}]", ex.getMessage());
        }
        return exp;
    }

}
