/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlet;

import com.mycompany.controller.ControllerExperimento;
import com.mycompany.model.Experimento;
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

/**
 *
 * @author sidious
 */
@WebServlet(name = "DefinirExperimento", urlPatterns = {"/DefinirExperimento"})
public class DefinirExperimento extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(DefinirExperimento.class.getName());
    private Experimento experimento = null;
    HttpSession session = null;

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
            if (defineExperimento(request, response)) {
                System.out.println("true");
            } else {
                System.out.println("false");
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
        session = request.getSession(false);
        experimento = (Experimento) session.getAttribute("experimento");
        //request.setAttribute("experimento", experimento);
        response.sendRedirect("definirexperimento.jsp");
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
        return "Servlet responsável pela definição de experimento";
    }// </editor-fold>

    protected boolean defineExperimento(HttpServletRequest request, HttpServletResponse response) {
        String objEstudo = request.getParameter("objEstudo");
        String objetivo = request.getParameter("objetivo");
        String perspectiva = request.getParameter("perspectiva");
        String focoQualidade = request.getParameter("focoQualidade");
        String contexto = request.getParameter("contexto");
        boolean editavel = request.getParameterValues("editavel") != null;
        boolean concluido = request.getParameterValues("concluido") != null;
        LOGGER.log(Level.INFO,
                "REQUEST:\n[objEstudo]: {0}\n[objetivo]: {1}\n[perspectiva]: {2}\n[focoQualidade]: {3}\n[contexto]: {4}\n[editavel]: {5}\n[concluido]: {6}",
                new Object[]{objEstudo, objetivo, perspectiva, focoQualidade, contexto, editavel, concluido});
        return ControllerExperimento.createDefinicao(experimento, objEstudo, objetivo, perspectiva, focoQualidade, contexto, editavel);
    }

}
