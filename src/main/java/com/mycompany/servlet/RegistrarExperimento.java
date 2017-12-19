/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlet;

import com.mycompany.controller.ControllerExperimento;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            String htmlResponse = "<html>";
            if (createExperimento(request, response)) {
                htmlResponse += "<h2>Experimento cadastrado com sucesso!</h2>";
                htmlResponse += "</html>";
            } else {
                htmlResponse += "<h2>Erro ao cadastrar o experimento, verifique o log para mais detalhes!</h2>";
                htmlResponse += "</html>";
                LOGGER.log(Level.SEVERE, "ERRO: [consulte banco]");
            }
            out.println(htmlResponse);
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

    private boolean createExperimento(HttpServletRequest request, HttpServletResponse response) {
        String nome, descricao;
        boolean isReplicavel;
        Date data_inicio;
        //Integer idCriador = Integer.parseInt(request.getParameter("idExperimentador"));

        nome = request.getParameter("nome");
        descricao = request.getParameter("descricao");
        isReplicavel = request.getParameter("replicacao").equals("0");
        LOGGER.log(Level.INFO, "Nome: {0}\nDescricao: {1}\nisReplicavel: {2}\nData: {3}", new Object[]{nome, descricao, isReplicavel, request.getParameter("data_inicial")});
        return ControllerExperimento.createExperimento(nome, descricao, isReplicavel);
    }

}
