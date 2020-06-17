/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.ClasseDAO;
import DAO.LoginDAO;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Classe;
import model.Login;

/**
 *
 * @author juann
 */
public class UpdateLogin extends HttpServlet {

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
            String pesquisa = request.getParameter("login");
            String nomeClasse = request.getParameter("nomeClasse");
            Classe classe = ClasseDAO.getClasse(nomeClasse);
            
            Gson gson = new Gson();
            Login login = gson.fromJson(pesquisa, Login.class);
            login.setClasse(classe);
            System.out.println(login.toString());
            System.out.println(classe.toString());
            LoginDAO.atualizaLogin(login);
            
            JsonObject obj = new JsonObject();
            JsonElement jsonobj = gson.toJsonTree(login);
            obj.add("dados",jsonobj);
            
            //resposta
            PrintWriter out = response.getWriter();
            out.println(obj.toString());
            out.close();
        } catch (Exception ex) {
            RequestDispatcher rd = request.getRequestDispatcher("PerfilUsuario.jsp");
            rd.forward(request, response);
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
