package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CadastroLugar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Nome - Cadastre-se</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" rel=\"stylesheet\"> <!-- Bootstrap -->\n");
      out.write("        <link href=\"bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\" /> <!-- pasta Bootstrap -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/EstilosCadastro.css\"> <!-- css entrar -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/EstilosRodape.css\"> <!-- css do rodape -->\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            <form action=\"\" method=\"post\" class=\"col-sm-6\">\n");
      out.write("                <div class=\"row justify-content-md-center\">\n");
      out.write("                    <h1 style=\"color: black\">Crie sua conta</h1>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"nome\" class=\"\" style=\"color: black;\">Nome do lugar</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"nNome\" id=\"nome\" placeholder=\"Nome\" autofocus required>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"categoria\" class=\"\" style=\"color: black;\">Categoria</label>\n");
      out.write("                    <select class=\"form-control\" name=\"nCategoria\" id=\"categoria\">\n");
      out.write("                        <option>1</option>\n");
      out.write("                        <option>2</option>\n");
      out.write("                        <option>3</option>\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"estado\" class=\"\" style=\"color: black;\">Estado</label>\n");
      out.write("                    <select class=\"form-control\" name=\"nEstado\" id=\"estado\">\n");
      out.write("                        <option>1</option>\n");
      out.write("                        <option>2</option>\n");
      out.write("                        <option>3</option>\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"cidade\" class=\"\" style=\"color: black;\">Cidade</label>\n");
      out.write("                    <select class=\"form-control\" name=\"nCidade\" id=\"cidade\">\n");
      out.write("                        <option>1</option>\n");
      out.write("                        <option>2</option>\n");
      out.write("                        <option>3</option>\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"rua\" class=\"\" style=\"color: black;\">Rua (opcional)</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"nRua\" id=\"rua\" placeholder=\"R. Rio Branco\">\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"complemento\" class=\"\" style=\"color: black;\">Complemento (opcional)</label>\n");
      out.write("                    <textarea class=\"form-control\" name=\"nRua\" id=\"rua\" placeholder=\"Digite alguns detalhes.\" rows=\"5\"></textarea>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <button type=\"submit\" class=\"btn btn-warning\">Enviar</button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/js/all.min.js\"></script><!-- font awesome -->\n");
      out.write("        <!-- IMPORTANTE - SCRIPTS NECESSARIOS PARA O FUNCIONAMENTO DO DROPDOWN, DEVE SER A ULTIMA COISA ANTES DE FECHAR O BODY -->\n");
      out.write("        <script src=\"http://code.jquery.com/jquery-3.4.1.min.js\"\n");
      out.write("        integrity=\"sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\"></script> <!-- ajax -->\n");
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
