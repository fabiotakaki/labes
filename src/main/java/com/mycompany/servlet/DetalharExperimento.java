/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlet;

import com.mycompany.controller.ControllerExperimento;
import com.mycompany.model.Definicao;
import com.mycompany.model.Experimento;
import com.mycompany.model.Usuario;
import java.io.IOException;
import java.util.Objects;
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
@WebServlet(name = "DetalharExperimento", urlPatterns = {"/DetalharExperimento"})
public class DetalharExperimento extends HttpServlet {

    Experimento experimento = null;
    private HttpSession session = null;

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
        // se já existe um objeto experimento associado a sessão
        experimento = (Experimento) session.getAttribute("experimento");
        if (session.getAttribute("experimento") == null
                || experimento.getId() != Integer.parseInt(request.getParameter("experimentoId"))) {
            experimento = getExperimento(request, response);
            session.setAttribute("experimento", experimento);
            if (experimento.getDefinicao() == null) {
                System.out.println("Teste");
            }
        }
        String encodeURL = response.encodeRedirectURL("experimentodetalhes.jsp");
        response.sendRedirect(encodeURL);
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
        return "Servlet responsável por realizar a captura dos detalhes do experimento";
    }// </editor-fold>

    protected Experimento getExperimento(HttpServletRequest request, HttpServletResponse response) {
        //HttpSession session = request.getSession(false);
        //Experimento experimento = (Experimento) session.getAttribute("experimento");
        Integer experimentoId = Integer.valueOf(request.getParameter("experimentoId"));
        Experimento exp = ControllerExperimento.buscaExperimento(experimentoId);
        Usuario user = (Usuario) session.getAttribute("userObj");
        if (!Objects.equals(user.getId(), exp.getCriador().getId())) {
            return null;
        }
        return exp;
    }

    protected Definicao getDefinicao(Integer idExperimento) {
        return null;
    }

}
