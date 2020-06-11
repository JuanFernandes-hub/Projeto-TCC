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
public class BtnUpdate extends HttpServlet {

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
        try {
            LugarDAO ldao = new LugarDAO();
            int idLugar = parseInt(request.getParameter("pesquisa"));
            HttpSession sessao = request.getSession();
            boolean UsuarioCadastrou = false;
            boolean AdmLogado = false;

            if (sessao.getAttribute("idUsuarioLogado") != null) {
                int idLogado = (int) sessao.getAttribute("idUsuarioLogado");
                String classeLogado = (String) sessao.getAttribute("classeUsuarioLogado");
                LoginLugar loginLugar = LoginLugarDAO.getLugar(idLogado, idLugar);
                System.out.println(classeLogado);

                //se cadastrou o lugar
                System.out.println("LoginLugar: " + loginLugar);
                if (loginLugar != null) {
                    UsuarioCadastrou = true;
                    System.out.println("UsuarioCAD: " + UsuarioCadastrou);
                } else {
                    //Não cadastrou
                    UsuarioCadastrou = false;
                }
                //É administrador
                if (!classeLogado.equalsIgnoreCase("comum")) {
                    AdmLogado = true;
                    System.out.println("ADM: " + AdmLogado);
                }
            }else{
                UsuarioCadastrou = false;
                AdmLogado = false;
            }

            /*
            int idLogado = (int) sessao.getAttribute("idUsuarioLogado");
            String classeLogado = (String) sessao.getAttribute("classeUsuarioLogado");
            LoginLugar loginLugar = LoginLugarDAO.getLugar(idLogado, idLugar);
            System.out.println(classeLogado);

            boolean UsuarioCadastrou = false;
            boolean AdmLogado = false;
            //se cadastrou o lugar
            System.out.println("LoginLugar: "+loginLugar);
            if (loginLugar != null) {
                UsuarioCadastrou = true;
                System.out.println("UsuarioCAD: "+UsuarioCadastrou);
            } else {
                UsuarioCadastrou = false;
                
            }
            //É administrador
            if (!classeLogado.equalsIgnoreCase("comum")) {
                AdmLogado = true;
                System.out.println("ADM: "+ AdmLogado);
            }

             */
            //Json para retornar ao ajax
            Gson gson = new Gson();
            JsonObject obj = new JsonObject();
            JsonElement jsonobj = gson.toJsonTree(UsuarioCadastrou);
            JsonElement jsonobj2 = gson.toJsonTree(AdmLogado);
            obj.add("dados", jsonobj);
            obj.add("dados2", jsonobj2);

            //resposta
            PrintWriter out = response.getWriter();
            out.println(obj.toString());
            out.close();
        } catch (IOException ex) {
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
