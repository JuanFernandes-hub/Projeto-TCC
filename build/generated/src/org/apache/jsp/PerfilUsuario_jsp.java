package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Lugar;
import java.util.List;
import DAO.LoginDAO;

public final class PerfilUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Colibri - Perfil</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\n");
      out.write("              integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            try {
                HttpSession sessao = request.getSession();
                int id = (Integer) sessao.getAttribute("idUsuarioLogado");
                LoginDAO logindao = new LoginDAO();
                List<Lugar> lugares = logindao.getLugaresCad(id);

                if (sessao.getAttribute("nomeUsuarioLogado") != null
                        && !sessao.getAttribute("nomeUsuarioLogado").equals("")) {
        
      out.write("          <p> ");
      out.print( sessao.getAttribute("idUsuarioLogado"));
      out.write(" </p>\n");
      out.write("        <p> ");
      out.print( sessao.getAttribute("nomeUsuarioLogado"));
      out.write(" </p>\n");
      out.write("        <p> ");
      out.print( sessao.getAttribute("classeUsuarioLogado"));
      out.write(" </p>\n");
      out.write("        <a href=\"SairPerfil\">Sair</a> <br/>\n");
      out.write("       \n");
      out.write("        <!-- Botão para acionar modal de deletar conta-->\n");
      out.write("        <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#ModalDeletaConta\">\n");
      out.write("            Deletar Conta\n");
      out.write("        </button> <br/>\n");
      out.write("        \n");
      out.write("        <a href=\"CadastraLugar.jsp\" class=\"btn btn-primary\">Cadastra Lugar</a>\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");

            }

            for (Lugar lugar : lugares) {
        
      out.write("  <div class=\"col-md-4\">\n");
      out.write("            <div class=\"card\" id=\"");
      out.print( lugar.getIdLugar());
      out.write("\" onclick=\"geraPg(this)\">\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                    <h3 class=\"card-title\"> ");
      out.print( lugar.getNome());
      out.write(" </h3>\n");
      out.write("                    <p class=\"card-text\">");
      out.print( lugar.getCategoria().getNome());
      out.write("</p>\n");
      out.write("                    <p class=\"card-text\">");
      out.print( lugar.getDescricao());
      out.write("</p>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <button id=\"deletar\" value=\"");
      out.print( lugar.getIdLugar());
      out.write("\" onclick=\"btnDeleteLug(this)\" >Deletar</button><!-- Colocar dentro do card, Arruma onmouseover do card para poder clicar no link-->\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div> ");

                }

            } catch (Exception e) {
                RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                rd.forward(request, response);
            }
        
      out.write("\n");
      out.write("        \n");
      out.write("        <!-- MODAL -->\n");
      out.write("        <div class=\"modal fade\" id=\"ModalDeletaConta\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"TituloModalDeletaConta\" aria-hidden=\"true\">\n");
      out.write("            <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <h5 class=\"modal-title\" id=\"TituloModalDeletaConta\">Deletar conta</h5>\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Fechar\">\n");
      out.write("                            <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        Deseja excluir sua conta? Você não conseguirá recuperá-la depois.\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Cancelar</button>\n");
      out.write("                        <a href=\"DeletaPerfil?id=");
      out.print( id );
      out.write("\" class=\"btn btn-primary\" role=\"button\">Deletar</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script src=\"http://code.jquery.com/jquery-3.4.1.min.js\" integrity=\"sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"js/GeraPgLugar.js\"></script> <!-- Guarda dados perfil do lugar  -->\n");
      out.write("        <script src=\"js/DeleteLugar.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
