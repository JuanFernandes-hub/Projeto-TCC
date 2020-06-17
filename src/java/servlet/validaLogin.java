/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.LoginDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Login;

/**
 *
 * @author user
 */
public class validaLogin extends HttpServlet{

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
        
        HttpSession sessao = request.getSession(true);
        sessao.setMaxInactiveInterval(60*60); 
        
        Login login = null;
        String usuario_form = request.getParameter("nUsuario");
        String senha_form = request.getParameter("nSenha");
        String email_form = request.getParameter("nUsuario");
        
        try {
            LoginDAO dao = new LoginDAO();
            //recebe o usuario do banco
            login = dao.getLogin(usuario_form, senha_form, email_form);
            
        }catch( Exception e ){
            e.printStackTrace();
            RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
            rd.forward(request, response);
        }
        
        if( login == null ) {
            sessao.invalidate();
            String mensagem = "Usuário ou senha incorretos. Tente novamente.";
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
            rd.forward(request, response);
        //se tiver um usuario no banco
        }else{
            //variaveis que recebem os atributos da classe Login
            int idUsuario = login.getIdUsuario();
            String classeUsuario = login.getClasse().getNome();
            String usuario = login.getUsuario();
            
            //sessao seta os atributos
            sessao.setAttribute("idUsuarioLogado", idUsuario);
            sessao.setAttribute("classeUsuarioLogado", classeUsuario);
            sessao.setAttribute("nomeUsuarioLogado", usuario);
            
            RequestDispatcher rd = request.getRequestDispatcher("PerfilUsuario.jsp");
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
