/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Localizacao;
import model.Lugar;

/**
 *
 * @author juann
 */
public class CadastraLugar extends HttpServlet {

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
            Lugar lugar = new Lugar();
            Localizacao localizacao = new Localizacao();
            String nome_lugar = request.getParameter("nName");
            String categoria_lugar = request.getParameter("nCategoria");
            String estado_lugar = request.getParameter("nEstado");
            String cidade_lugar = request.getParameter("nCidade");
            String rua_lugar = request.getParameter("nRua");
            String complemento_lugar = request.getParameter("nComplemento");
            
            //setando localizacao
            localizacao.setRua(rua_lugar);
            localizacao.setCidade(cidade_lugar);
            localizacao.setEstado(estado_lugar);
            localizacao.setComplemento(complemento_lugar);
            
            //setando lugar
            lugar.setNome(nome_lugar);
            lugar.setCategoria(categoria_lugar);
            lugar.setLocalizacao(localizacao);
            
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
        return "Short description";
    }// </editor-fold>

}
