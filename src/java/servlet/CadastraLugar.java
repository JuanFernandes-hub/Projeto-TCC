/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.CategoriaDAO;
import DAO.CidadeDAO;
import DAO.EstadoDAO;
import DAO.LocalizacaoDAO;
import DAO.LugarDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categoria;
import model.Cidade;
import model.Estado;
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
            String nome_lugar = request.getParameter("nNome");
            String categoria_lugar = request.getParameter("nCategoria");
            String estado_lugar = request.getParameter("nEstado");
            String cidade_lugar = request.getParameter("nCidade");
            String rua_lugar = request.getParameter("nRua");
            String complemento_lugar = request.getParameter("nComplemento");
            
            //setando localizacao
            localizacao.setRua(rua_lugar);
            localizacao.setComplemento(complemento_lugar);
            
            
            Estado estado = new Estado();
            estado.setIdEstado(Integer.parseInt(estado_lugar));//o nome é o pk do estado
            
            Cidade cidade = new Cidade();
            cidade.setIdCidade(Integer.parseInt(cidade_lugar));
            cidade.setEstado(estado);
            
            localizacao.setCidade(cidade);
            LocalizacaoDAO.insereLocalizacao(localizacao);
            
            //gambiarra para pega pk da localizacao
            //com a localizacao inserida, puxo ela do banco
            //e pego a sua pk
            LocalizacaoDAO localdao = new LocalizacaoDAO();
            Localizacao local = localdao.getLocalizacao(cidade);
            localizacao.setIdLocalizacao(local.getIdLocalizacao());
            
            //setando categoria
            Categoria categoria = new Categoria();
            categoria.setIdCategoria(Integer.parseInt(categoria_lugar));
            
            
            //Nao esta enviando o lugar
            lugar.setNome(nome_lugar);
            lugar.setAvaliacao(5);
            lugar.setCategoria(categoria);
            lugar.setLocalizacao(localizacao); //é preciso que a localizacao tenha uma pk
            LugarDAO.insereLugar(lugar);
            
            
            System.out.print(lugar.getNome());
            System.out.print(lugar.getLocalizacao());
            System.out.println(localizacao.getIdLocalizacao());
            
            RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
            rd.forward(request, response);
            
        }catch( Exception e ){
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.forward(request, response);
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
