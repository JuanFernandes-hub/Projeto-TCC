package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class TesteLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Entrar - Colibri</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,500;0,700;0,900;1,300;1,400;1,500;1,700;1,900&display=swap\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@300;400;500;700&display=swap\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/EstiloBtns.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/EstiloInputLabel.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/EstiloLogin.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"row tela\">\n");
      out.write("                <div class=\"col-md-6 offset-sm-1 area-col\">\n");
      out.write("                    <h1 class=\"\">Cadastrar</h1>\n");
      out.write("                    <form class=\"\"> \n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <label for=\"\" class=\"col-md-2\">Usuário</label>\n");
      out.write("                            <div class=\"col-md-10\">\n");
      out.write("                                <input class=\"my-input\" type=\"text\" placeholder=\"Crie um usuário\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <label for=\"\" class=\"col-md-2\">Email</label>\n");
      out.write("                            <div class=\"col-md-10\">\n");
      out.write("                                <input class=\"my-input\" type=\"text\" placeholder=\"Seu Email\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <label for=\"\" class=\"col-md-2\">Senha</label>\n");
      out.write("                            <div class=\"col-md-10 input-group mb-3\">\n");
      out.write("                                <div class=\"input-group-prepend\">\n");
      out.write("                                    <div class=\"input-group-text\" onclick=\"mostraSenha('#senha', '#olho1')\"\n");
      out.write("                                         style=\"cursor: pointer;\">\n");
      out.write("                                        <i id=\"olho1\" class=\"far fa-eye-slash\"></i>\n");
      out.write("                                    </div>\n");
      out.write("                                    <input type=\"password\" class=\"my-input-icon\" id=\"senha\" name=\"nSenha\"\n");
      out.write("                                           placeholder=\"Sua senha\" />\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <label for=\"\" class=\"col-md-2\">Senha</label>\n");
      out.write("                            <div class=\"col-md-10 input-group mb-3\" style=\"\">\n");
      out.write("                                <div class=\"input-group-prepend\">\n");
      out.write("                                    <div class=\"input-group-text\" onclick=\"mostraSenha('#senha', '#olho1')\"\n");
      out.write("                                         style=\"cursor: pointer;\">\n");
      out.write("                                        <i id=\"olho1\" class=\"far fa-eye-slash\"></i>\n");
      out.write("                                    </div>\n");
      out.write("                                    <input type=\"password\" class=\"my-input-icon\" id=\"senha\" name=\"nSenha\"\n");
      out.write("                                           placeholder=\"Confirme sua senha\" />\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <div class=\"offset-sm-2 col-sm-10\">\n");
      out.write("                                <button class=\"btn my-button-accept\">Salvar</button>\n");
      out.write("                                <button class=\"btn my-button-cancel\">Cancelar</button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-5 area-cap\">\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Optional JavaScript -->\n");
      out.write("        <!-- jQuery first, then Popper.js, then Bootstrap JS -->\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/js/all.min.js\"></script>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\"\n");
      out.write("        crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
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
