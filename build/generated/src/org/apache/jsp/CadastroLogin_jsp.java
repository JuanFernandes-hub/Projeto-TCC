package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CadastroLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <!-- NAVBAR -->\n");
      out.write("        <nav class=\"navbar navbar-expand-md navbar-dark \" style=\"background-color:#4A44F2; margin-bottom: 0px; border-radius: 0px\">\n");
      out.write("            <!-- navbar expansiva -->\n");
      out.write("\n");
      out.write("            <div class=\"container\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                <!-- Logo -->\n");
      out.write("                <span class=\"mx-3\" style=\"font-size: 25px; color: #ffffff;\">\n");
      out.write("                    <i class=\"far fa-compass\"></i>\n");
      out.write("                </span>\n");
      out.write("                <a class=\"navbar-brand\" href=\"index.html\" style=\"color: #ffffff;\">\n");
      out.write("                    <b>\n");
      out.write("                        NomeLegal\n");
      out.write("                    </b>\n");
      out.write("                </a>\n");
      out.write("\n");
      out.write("                <!-- Botão que carrega as opcoes da barra de navegadores (collapse) (3 riscos) -->\n");
      out.write("                <button class=\"navbar-toggler\" title=\"button\" data-toggle=\"collapse\" data-target=\"#conteudoDaBarra\">\n");
      out.write("                    <span class=\"navbar-toggler-icon\"></span> <!-- carrega o icone dos 3 riscos -->\n");
      out.write("                </button>\n");
      out.write("\n");
      out.write("                <!-- Opcoes da barra de navegacao -->\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"conteudoDaBarra\">\n");
      out.write("                    <!-- id que liga ao collapse(3 riscos) -->\n");
      out.write("                    <ul class=\"navbar-nav ml-auto\">\n");
      out.write("                        <!-- a lista aumenta automaticamente -->\n");
      out.write("                        <li class=\"nav-item active\">\n");
      out.write("                            <!-- opcao ativa -->\n");
      out.write("                            <a class=\"nav-link\" href=\"index.html\" style=\"color: #ffffff;\"><b>Home</b></a>\n");
      out.write("                            <!-- como um \"\"\"botao\"\"\" , mas e um link-->\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"#\" style=\"color: #ffffff;\"><b>Lugares</b></a>\n");
      out.write("                            <!-- como um \"\"\"botao\"\"\" , mas e um link-->\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <li class=\"nav-item \">\n");
      out.write("                            <a class=\"nav-link\" href=\"sobre.html\" style=\"color: #ffffff;\"><b>Sobre</b></a>\n");
      out.write("                            <!-- como um \"\"\"botao\"\"\" , mas e um link-->\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"Login.jsp\" style=\"color: #ffffff;\"><b>Entrar</b></a>\n");
      out.write("                            <!-- como um \"\"\"botao\"\"\" , mas e um link-->\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav> <!-- FIM-NAVBAR -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container-fluid\"\n");
      out.write("             style=\"background-image:url(imagens/morretes.jpg);padding-top: 100px ;background-position: bottom; background-repeat: no-repeat; background-size: cover; height: 543px;\">\n");
      out.write("\n");
      out.write("            <div class=\"row justify-content-center mt-5\">\n");
      out.write("                <div class=\"col-5 janelaLogin\">\n");
      out.write("\n");
      out.write("                    <form action=\"CadastraLogin\" method=\"post\">\n");
      out.write("                        <div class=\"row justify-content-md-center\">\n");
      out.write("                            <h1 style=\"color: #ffffff\">Crie sua conta</h1>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("\n");
      out.write("                            <div class=\"camposCad col-sm-6 text-left\">\n");
      out.write("                                <label for=\"nome\" class=\"\" style=\"color: #ffffff;\">Nome</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"nNome\" id=\"nome\" placeholder=\"Nome\" autofocus required>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"camposCad col-sm-6 text-left\" >\n");
      out.write("                                <label for=\"senha\" class=\"\" style=\"color: #ffffff;\">Senha</label>\n");
      out.write("                                <input type=\"password\" class=\"form-control\" name=\"nSenha\" id=\"senha\" placeholder=\"Senha\" required>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"form-group row\">\n");
      out.write("                            <div class=\"camposCad col-sm-12 text-left\">\n");
      out.write("                                <label for=\"email\" class=\"\" style=\"color: #ffffff;\">Email</label>\n");
      out.write("                                <input type=\"email\" class=\"form-control\" name=\"nEmail\" id=\"email\" placeholder=\"Email\" required>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-botaozinho \">Enviar</button>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- FOOTERS -->\n");
      out.write("        <footer class=\"myfooter footer mt-auto py-3\">\n");
      out.write("            <div class=\"container\"></div>\n");
      out.write("            <div class=\"row mx-3\">\n");
      out.write("                <div class=\"col-sm-3 mt-3\">\n");
      out.write("                    <i class=\"far fa-compass\" aria-hidden=\"true\" style=\"font-size: 150px; color: #ffffff;\"></i>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-sm-3 mt-3\">\n");
      out.write("                    <h2 style=\"color: #ffffff;\"><b>Sobre</b></h2>\n");
      out.write("                    <div class=\"col\">\n");
      out.write("                        <a href=\"#\" style=\"color: #ffffff;\">\n");
      out.write("                            <p>Opção 1</p>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-sm-3 mt-3\" style=\"color: #ffffff;\">\n");
      out.write("                    <h2><b>Lugares</b></h2>\n");
      out.write("                    <a href=\"#\" style=\"color: #ffffff;\">\n");
      out.write("                        <p>Opção 1</p>\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-sm-3 mt-3\" style=\"color: #ffffff;\">\n");
      out.write("                    <h2><b>Redes Sociais</b></h2>\n");
      out.write("                    <a href=\"#\" style=\"color: #ffffff;\">\n");
      out.write("                        <p>Opção 1</p>\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </footer>\n");
      out.write("    <footer class=\"myfooter-copyright footer mt-auto\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row justify-content-center\">\n");
      out.write("                <p><small>Fabricado por Juan - 2020</small></p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </footer><!-- FIM FOOTERS -->\n");
      out.write("\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/js/all.min.js\"></script><!-- font awesome -->\n");
      out.write("    <!-- IMPORTANTE - SCRIPTS NECESSARIOS PARA O FUNCIONAMENTO DO DROPDOWN, DEVE SER A ULTIMA COISA ANTES DE FECHAR O BODY -->\n");
      out.write("    <script src=\"http://code.jquery.com/jquery-3.4.1.min.js\"\n");
      out.write("    integrity=\"sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\"></script> <!-- ajax -->\n");
      out.write("</body>\n");
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
