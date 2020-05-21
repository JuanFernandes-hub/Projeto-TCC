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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
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
      out.write("                    <p> ");
      out.print( sessao.getAttribute("nomeUsuarioLogado"));
      out.write(" </p>\n");
      out.write("                    <p> ");
      out.print( sessao.getAttribute("classeUsuarioLogado"));
      out.write(" </p>\n");
      out.write("                    <a href=\"Sair.jsp\">Sair</a> ");

                    }
                        
                for (Lugar lugar : lugares) {
        
      out.write("  <div class=\"col-md-4\">\n");
      out.write("            <div class=\"card\" name=\" jbj\" id=\"");
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
      out.write("                    <a href=\"DeletaLugar?id=");
      out.print( lugar.getIdLugar() );
      out.write("\">Deletar</a>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("\n");
      out.write("        </div> ");

            }
                
            } catch (Exception e) {
                RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                rd.forward(request, response);
            }
        
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
