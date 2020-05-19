package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import DAO.LugarDAO;
import model.Lugar;

public final class Lugar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <script>\n");
      out.write("            var dadosArquivados = JSON.parse(sessionStorage.getItem('chave'));\n");
      out.write("            console.log(dadosArquivados);\n");
      out.write("        </script>\n");
      out.write("        <label style=\"color: black;\">Nome:</label>\n");
      out.write("        <label class=\"\" id=\"nome\" style=\"color: black;\"></label>\n");
      out.write("        <br/>\n");
      out.write("        <label style=\"color: black;\">Avaliacao:</label>\n");
      out.write("        <label class=\"\" id=\"avaliacao\" style=\"color: black;\"></label>\n");
      out.write("        <br/>\n");
      out.write("        <label style=\"color: black;\">Categoria:</label>\n");
      out.write("        <label class=\"\" id=\"categoria\" style=\"color: black;\"></label>\n");
      out.write("        <br/>\n");
      out.write("        <label style=\"color: black;\">Acesso:</label>\n");
      out.write("        <label class=\"\" id=\"acesso\" style=\"color: black;\"></label>\n");
      out.write("        <br/>\n");
      out.write("        <label style=\"color: black;\">Abre:</label>\n");
      out.write("        <label class=\"\" id=\"horaInicial\" style=\"color: black;\"></label>\n");
      out.write("        <br/>\n");
      out.write("        <label style=\"color: black;\">Fecha:</label>\n");
      out.write("        <label class=\"\" id=\"horaFinal\" style=\"color: black;\"></label>\n");
      out.write("        <br/>\n");
      out.write("        <label style=\"color: black;\">Descrição:</label>\n");
      out.write("        <label class=\"\" id=\"descricao\" style=\"color: black;\"></label>\n");
      out.write("        <br/>\n");
      out.write("        <label style=\"color: black;\">Estado:</label>\n");
      out.write("        <label class=\"\" id=\"estado\" style=\"color: black;\"></label>\n");
      out.write("        <br/>\n");
      out.write("        <label style=\"color: black;\">Cidade:</label>\n");
      out.write("        <label class=\"\" id=\"cidade\" style=\"color: black;\"></label>\n");
      out.write("        <br/>\n");
      out.write("        <label style=\"color: black;\">Bairro:</label>\n");
      out.write("        <label class=\"\" id=\"bairro\" style=\"color: black;\"></label>\n");
      out.write("        <br/>\n");
      out.write("        <label style=\"color: black;\">Rua:</label>\n");
      out.write("        <label class=\"\" id=\"rua\" style=\"color: black;\"></label>\n");
      out.write("        <br/>\n");
      out.write("        <label style=\"color: black;\">N:</label>\n");
      out.write("        <label class=\"\" id=\"numero\" style=\"color: black;\"></label>\n");
      out.write("\n");
      out.write("        \n");
      out.write("        <script src=\"http://code.jquery.com/jquery-3.4.1.min.js\"\n");
      out.write("        integrity=\"sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\"></script> <!-- AJAX -->\n");
      out.write("        <script type=\"text/javascript\" src=\"js/GetLugar.js\"></script> <!-- MEU AJAX -->\n");
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
