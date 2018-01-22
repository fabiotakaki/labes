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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sidious
 */
@WebServlet(name = "DefinirExperimento", urlPatterns = {"/DefinirExperimento"})
public class DefinirExperimento extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DefinirExperimento</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DefinirExperimento at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        Experimento experimento = getExperimento(request, response);
        request.setAttribute("experimento", experimento);
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

    protected static Experimento getExperimento(HttpServletRequest request, HttpServletResponse response){
        //HttpSession session = request.getSession(false);
        //Experimento experimento = (Experimento) session.getAttribute("experimento");
        Integer experimentoId = Integer.valueOf(request.getParameter("experimentoId"));
        Experimento exp = ControllerExperimento.buscaExperimento(experimentoId);
        return exp;
    }
    
    protected static boolean defineExperimento(HttpServletRequest request, HttpServletResponse response){
        String objEstudo = request.getParameter("objEstudo");
        String objetivo = request.getParameter("objetivo");
        String perspectiva = request.getParameter("perspectiva");
        String focoQualidade = request.getParameter("focoQualidade");
        String contexto = request.getParameter("contexto");
        return true;
    }

}
