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
import static java.lang.Integer.parseInt;
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
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            Lugar lugar = new Lugar();
            Localizacao localizacao = new Localizacao();
            Categoria categoria = new Categoria();
            Cidade cidade = new Cidade();
            Estado estado = new Estado();
            
            String nome_lugar = request.getParameter("nNome");
            int categoria_lugar = parseInt(request.getParameter("nCategoria"));
            int estado_lugar = parseInt(request.getParameter("nEstado"));
            int cidade_lugar = parseInt(request.getParameter("nCidade"));
            String rua_lugar = request.getParameter("nRua");
            String complemento_lugar = request.getParameter("nComplemento");

            estado.setIdEstado(estado_lugar);
            cidade.setIdCidade(cidade_lugar);
            cidade.setEstado(estado);
            
            localizacao.setRua(rua_lugar);
            localizacao.setComplemento(complemento_lugar);
            localizacao.setCidade(cidade);
            int idLocal = LocalizacaoDAO.insere(localizacao); //manda pro banco e pega o id
            localizacao.setIdLocalizacao(idLocal);
            
            categoria.setIdCategoria(categoria_lugar);
            
            lugar.setNome(nome_lugar);
            lugar.setLocalizacao(localizacao);
            lugar.setCategoria(categoria);
            lugar.setAvaliacao(5);
            
            LugarDAO.insereLugar(lugar);
            
            
            /*
            out.println("<html>");
            out.println("<body>");
            out.println("Categoria " + categoria_lugar
                    + " adicionado com sucesso");
            out.println("</body>");
            out.println("</html>");
            */

            RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
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
