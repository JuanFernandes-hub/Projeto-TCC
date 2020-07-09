/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.CategoriaDAO;
import DAO.CidadeDAO;
import DAO.LocalizacaoDAO;
import DAO.LugarDAO;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categoria;
import model.Cidade;
import model.Localizacao;
import model.Lugar;

/**
 *
 * @author juann
 */
public class UpdateLugar extends HttpServlet {

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
        try{
            Lugar lugar = new Lugar();
            Localizacao localizacao = new Localizacao();

            int idLugar = parseInt(request.getParameter("idLugar"));
            
            String nome = (String)request.getParameter("nNome");
            int idCategoria = parseInt(request.getParameter("nCategoria"));
            String acesso_lugar = request.getParameter("nAcesso");
            String horarioInicial_lugar = request.getParameter("nHoraInicial");
            String horarioFinal_lugar = request.getParameter("nHoraFinal");
            int idCidade = parseInt(request.getParameter("nCidade"));
            String bairro_lugar = request.getParameter("nBairro");
            String rua_lugar = request.getParameter("nRua");
            String numero_lugar = request.getParameter("nNumero");
            String complemento_lugar = request.getParameter("nComplemento");
            String descricao_lugar = request.getParameter("nDescricao");

            //Transformando Horas em Time(SQL)
            DateFormat formato = new SimpleDateFormat("HH:mm");
            Time horaInicial_lugar = new java.sql.Time(formato.parse(horarioInicial_lugar).getTime());
            Time horaFinal_lugar = new java.sql.Time(formato.parse(horarioFinal_lugar).getTime());
            
            Categoria categoria = CategoriaDAO.getCategoria(idCategoria);
            Cidade cidade = CidadeDAO.getCidade(idCidade);
            
            localizacao.setRua(rua_lugar);
            localizacao.setComplemento(complemento_lugar);
            localizacao.setCidade(cidade);
            localizacao.setBairro(bairro_lugar);
            localizacao.setNumero(numero_lugar);
            int idLocalizacao = LugarDAO.getLugar(idLugar).getLocalizacao().getIdLocalizacao();
            localizacao.setIdLocalizacao(idLocalizacao);
            LocalizacaoDAO.atualizaLocalizacao(localizacao);
            
            
            lugar.setIdLugar(idLugar);
            lugar.setNome(nome);
            lugar.setLocalizacao(localizacao);
            lugar.setCategoria(categoria);
            lugar.setAvaliacao(5); //Padrão
            lugar.setAcesso(acesso_lugar);
            lugar.setHoraInicial(horaInicial_lugar);
            lugar.setHoraFinal(horaFinal_lugar);
            lugar.setDescricao(descricao_lugar);
            LugarDAO.atualizaLugar(lugar);

            RequestDispatcher rd = request.getRequestDispatcher("GetLugar?idLugar="+idLugar+"&act=get");
            rd.forward(request, response);
        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
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
