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
import javax.servlet.http.HttpSession;
import model.Classe;
import model.Login;
import org.apache.commons.codec.digest.DigestUtils;

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
        try {
            System.out.println("CHEGOU AQUI");
            HttpSession sessao = request.getSession(false);
            int idUsuarioLogado = (Integer) sessao.getAttribute("idUsuarioLogado");
            String senhaCorreta = LoginDAO.getLogin(idUsuarioLogado).getSenha();

            String usuario = (String) request.getParameter("nUsuario");
            String email = (String) request.getParameter("nEmail");
            String senhaDigitada = (String) request.getParameter("nSenha");
            String nomeClasse = (String) sessao.getAttribute("classeUsuarioLogado");
            senhaDigitada = DigestUtils.sha1Hex(senhaDigitada);
            
            String mensagem = null;

            if (senhaCorreta.equals(senhaDigitada)) {
                Classe classe = ClasseDAO.getClasse(nomeClasse);
                Login login = new Login(idUsuarioLogado, usuario, senhaCorreta, email, classe);
                LoginDAO.atualizaLogin(login);

                mensagem = "Dados alterados com sucesso.";
                request.setAttribute("mensagem", mensagem);
                RequestDispatcher rd = request.getRequestDispatcher("UpdateLogin.jsp");
                rd.forward(request, response);
            }else{
                mensagem = "Senha inválida, Tente novamente";
                request.setAttribute("mensagem", mensagem);
                RequestDispatcher rd = request.getRequestDispatcher("UpdateLogin.jsp");
                rd.forward(request, response);
            }

        } catch (Exception ex) {
            RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
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
