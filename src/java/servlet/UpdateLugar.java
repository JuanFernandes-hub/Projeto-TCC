/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

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
import model.Estado;
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
            Categoria categoria = new Categoria();
            Cidade cidade = new Cidade();
            Estado estado = new Estado();
            
            int id_Lugar = parseInt(request.getParameter("nId"));
            String nome_lugar = request.getParameter("nNome");
            int categoria_lugar = parseInt(request.getParameter("nCategoria"));
            String acesso_lugar = request.getParameter("nAcesso");
            String horarioInicial_lugar = request.getParameter("nHoraInicial");
            String horarioFinal_lugar = request.getParameter("nHoraFinal");
            int estado_lugar = parseInt(request.getParameter("nEstado"));
            int cidade_lugar = parseInt(request.getParameter("nCidade"));
            String bairro_lugar = request.getParameter("nBairro");
            String rua_lugar = request.getParameter("nRua");
            String numero_lugar = request.getParameter("nNumero");
            String complemento_lugar = request.getParameter("nComplemento");
            String descricao_lugar = request.getParameter("nDescricao");
            
            //Transformando Horas em Time(SQL)
            DateFormat formato = new SimpleDateFormat("HH:mm");
            Time horaInicial_lugar = new java.sql.Time(formato.parse(horarioInicial_lugar).getTime());
            Time horaFinal_lugar = new java.sql.Time(formato.parse(horarioFinal_lugar).getTime());
            
            System.out.println("Chegou AQUI: "+horaInicial_lugar);
            System.out.println("Chegou AQUI: "+horaFinal_lugar);
            
            estado.setIdEstado(estado_lugar);
            cidade.setIdCidade(cidade_lugar);
            cidade.setEstado(estado);

            localizacao.setRua(rua_lugar);
            localizacao.setComplemento(complemento_lugar);
            localizacao.setCidade(cidade);
            localizacao.setBairro(bairro_lugar);
            localizacao.setNumero(numero_lugar);
            int idLocalizacao = LugarDAO.getLugar(id_Lugar).getLocalizacao().getIdLocalizacao();
            localizacao.setIdLocalizacao(idLocalizacao);
            LocalizacaoDAO.atualizaLocalizacao(localizacao);

            categoria.setIdCategoria(categoria_lugar);

            lugar.setIdLugar(id_Lugar);
            lugar.setNome(nome_lugar);
            lugar.setLocalizacao(localizacao);
            lugar.setCategoria(categoria);
            lugar.setAvaliacao(5);
            lugar.setAcesso(acesso_lugar);
            lugar.setHoraInicial(horaInicial_lugar);
            lugar.setHoraFinal(horaFinal_lugar);
            lugar.setDescricao(descricao_lugar);
            
            LugarDAO.atualizaLugar(lugar);
            
            lugar.toString();
            
            RequestDispatcher rd = request.getRequestDispatcher("newjsp.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
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
