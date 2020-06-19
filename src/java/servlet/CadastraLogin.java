/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.ClasseDAO;
import DAO.LoginDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Classe;
import model.Login;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author juann
 */
public class CadastraLogin extends HttpServlet {

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
            Login login = new Login();
            String usuario_form = (String) request.getParameter("nNome");
            String senha_form = (String) request.getParameter("nSenha");
            String email_form = (String) request.getParameter("nEmail");
            String mensagem = null;

            //verifica se usuario ja esta cadastrado
            //senha é valida no front
            if (!LoginDAO.usuarioCadastrado(usuario_form)) {
                //verifica se email ja esta cadastrado
                if (!LoginDAO.emailCadastrado(email_form)) {
                    //hash
                    senha_form = DigestUtils.sha1Hex(senha_form);

                    login.setUsuario(usuario_form);
                    login.setSenha(senha_form);
                    login.setEmail(email_form);
                    //Só é cadastrado usuário comum
                    Classe classe = ClasseDAO.getClasse("comum");
                    login.setClasse(classe);

                    LoginDAO.insereLogin(login);
                    RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                    rd.forward(request, response);
                } else {
                    mensagem = "Email já cadastrado. Ultilize outro";
                    request.setAttribute("mensagem", mensagem);
                    RequestDispatcher rd = request.getRequestDispatcher("CadastroLogin.jsp");
                    rd.forward(request, response);
                }
            } else {
                mensagem = "Usuário já cadastrado. Tente outro";
                request.setAttribute("mensagem", mensagem);
                RequestDispatcher rd = request.getRequestDispatcher("CadastroLogin.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            String mensagem = "Ocorreu algum erro. Desculpe.";
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = request.getRequestDispatcher("CadastroLogin.jsp");
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
