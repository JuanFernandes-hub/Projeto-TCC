/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.LocalizacaoDAO;
import DAO.LugarDAO;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
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
        try {
            LugarDAO ldao = new LugarDAO();
            String lugar_json = request.getParameter("lugar");
            String localizacao_json = request.getParameter("localizacao");
            String cidade_json = request.getParameter("cidade");
            String categoria_json = request.getParameter("categoria");
            Gson gson = new Gson();
            //Transforma json em objeto java
            Cidade cidade = gson.fromJson(cidade_json, Cidade.class);
            Categoria categoria = gson.fromJson(categoria_json, Categoria.class);
            Lugar lugar = gson.fromJson(lugar_json, Lugar.class);
            Localizacao localizacao = gson.fromJson(localizacao_json, Localizacao.class);
            
            localizacao.setCidade(cidade);
            LocalizacaoDAO.atualizaLocalizacao(localizacao);
            lugar.setCategoria(categoria);
            lugar.setLocalizacao(localizacao);
            LugarDAO.atualizaLugar(lugar);


            //Json para retornar ao ajax
            Gson retorno = new Gson();
            JsonObject obj = new JsonObject();
            JsonElement jsonobj = retorno.toJsonTree(LugarDAO.getLugar(lugar.getIdLugar()));
            obj.add("dados",jsonobj);
            
            //resposta
            PrintWriter outAlt = response.getWriter();
            outAlt.println(obj.toString());
            outAlt.close();
            
        }catch(IOException ex) {
            ex.printStackTrace();
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
