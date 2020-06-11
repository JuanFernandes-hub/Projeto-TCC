/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.LoginLugarDAO;
import DAO.LugarDAO;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.LoginLugar;
import model.Lugar;

/**
 *
 * @author juann
 */
public class DeletaLugar extends HttpServlet {

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
        try{
            LugarDAO ldao = new LugarDAO();
            int idLugar = parseInt(request.getParameter("pesquisa"));
            Lugar lugar = ldao.getLugar(idLugar);
            String mensagem;
            
            try{
            ldao.deletaLugar(lugar);
                mensagem = "Excluido com sucesso!"; 
            }catch(Exception e){
                mensagem = "Ocorreu algum erro. Desculpe.";
            }
            
            //Json para retornar ao ajax
            Gson gson = new Gson();
            JsonObject obj = new JsonObject();
            JsonElement jsonobj = gson.toJsonTree(mensagem);
            obj.add("mensagem",jsonobj);
            
            //resposta
            PrintWriter out = response.getWriter();
            out.println(obj.toString());
            out.close();
            
            RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
            rd.forward(request, response);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        /*try {
            int id = (Integer)parseInt(request.getParameter("id"));
            System.out.println("Chegou aqui " + id +"AQUI");
            
            LugarDAO dao = new LugarDAO();
            dao.deletaLoginLugar(id);
            
            System.out.println("Passou do dao");
            
            
            RequestDispatcher rd = request.getRequestDispatcher("PerfilUsuario.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            System.out.println("ERRO: " + e);
        }*/
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
