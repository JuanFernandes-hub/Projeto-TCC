package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Cidade;
import DAO.CidadeDAO;
import DAO.LugarDAO;
import model.Lugar;
import java.util.List;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


                    List<Cidade> cidades = CidadeDAO.getCidade();
                

                    LugarDAO lugardao = new LugarDAO();
                    List<Lugar> lugares = lugardao.getLugar();
                    String test = "TESTEEE";
                
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
      out.write("        <title>Home - Colibri</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/EstiloHome.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/EstilosRodape.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\n");
      out.write("              integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"fundo-imagem\">\n");
      out.write("            <nav class=\"navbar navbar-expand-md navbar-dark edit-nav\">\n");
      out.write("                <!-- navbar expansiva -->\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <!-- Logo -->\n");
      out.write("\n");
      out.write("                    <a class=\"navbar-brand\" href=\"Home.jsp\" style=\"color: #ffffff;\">\n");
      out.write("                        <span class=\"mx-1\" style=\"font-size: 25px; color: #ffffff;\">\n");
      out.write("                            <i class=\"far fa-compass\"></i>\n");
      out.write("                        </span>\n");
      out.write("                        <b>\n");
      out.write("                            Colibri\n");
      out.write("                        </b>\n");
      out.write("                    </a>\n");
      out.write("\n");
      out.write("                    <!-- Botão que carrega as opcoes da barra de navegadores (collapse) (3 riscos) -->\n");
      out.write("                    <button class=\"navbar-toggler\" title=\"button\" data-toggle=\"collapse\" data-target=\"#conteudoDaBarra\">\n");
      out.write("                        <span class=\"navbar-toggler-icon\"></span> <!-- carrega o icone dos 3 riscos -->\n");
      out.write("                    </button>\n");
      out.write("\n");
      out.write("                    <!-- Opcoes da barra de navegacao -->\n");
      out.write("                    <div class=\"collapse navbar-collapse\" id=\"conteudoDaBarra\">\n");
      out.write("                        <!-- id que liga ao collapse(3 riscos) -->\n");
      out.write("                        <ul class=\"navbar-nav ml-auto\">\n");
      out.write("                            <!-- a lista aumenta automaticamente -->\n");
      out.write("                            <li class=\"nav-item active\">\n");
      out.write("                                <!-- opcao ativa -->\n");
      out.write("                                <a class=\"nav-link\" href=\"Home.jsp\" style=\"color: #ffffff;\"><b>Home</b></a>\n");
      out.write("                                <!-- como um \"\"\"botao\"\"\" , mas e um link-->\n");
      out.write("                            </li>\n");
      out.write("\n");
      out.write("                            <li class=\"nav-item\">\n");
      out.write("                                <a class=\"nav-link\" href=\"Lugares.jsp\" style=\"color: #ffffff;\"><b>Lugares</b></a>\n");
      out.write("                                <!-- como um \"\"\"botao\"\"\" , mas e um link-->\n");
      out.write("                            </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <li class=\"nav-item \">\n");
      out.write("                                <a class=\"nav-link\" href=\"sobre.html\" style=\"color: #ffffff;\"><b>Sobre</b></a>\n");
      out.write("                                <!-- como um \"\"\"botao\"\"\" , mas e um link-->\n");
      out.write("                            </li>\n");
      out.write("\n");
      out.write("                            <li class=\"nav-item\">\n");
      out.write("                                <a class=\"nav-link\" href=\"Login.jsp\" style=\"color: #ffffff;\"><b>Entrar</b></a>\n");
      out.write("                                <!-- como um \"\"\"botao\"\"\" , mas e um link-->\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("            <div class=\"fundo-texto\">\n");
      out.write("                ");
      out.write("\n");
      out.write("\n");
      out.write("                <h1 style=\"font-size:50px\">Descubra sua cidade</h1>\n");
      out.write("                <form method=\"get\" action=\"GetLugarCidade\">\n");
      out.write("                    <!--<input class=\"input-imagem\" type=\"search\" name=\"\" id=\"\" placeholder=\"Pesquise Lugares\">-->\n");
      out.write("                    <select class=\"form-control\" name=\"nCidade\" id=\"cidade\" required>\n");
      out.write("                        <!-- option gerados por ajax, de acordo com o estado selecionado -->\n");
      out.write("                        <option value=\"\" disabled selected hidden>Selecione...</option>\n");
      out.write("                        ");

                            for (Cidade cidade : cidades) {
                        
      out.write(" <option value=\"");
      out.print( cidade.getIdCidade());
      out.write("\"> ");
 out.print(cidade.getNome() + " - " + cidade.getEstado().getSigla()); 
      out.write(" </option>");

                            }
                        
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                    <button class=\"form-control\" type=\"submit\">OK</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"container pt-5\">\n");
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-3 cardCol\">\n");
      out.write("                    <div class=\"card mycard\">\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <h3 class=\"card-title\">Title</h3>\n");
      out.write("                            <p class=\"card-text\">Text</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-3 cardCol\">\n");
      out.write("                    <div class=\"card mycard\">\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <h3 class=\"card-title\">Title</h3>\n");
      out.write("                            <p class=\"card-text\">Text</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("\n");
      out.write("                ");

                    //Limitar numero de cards na home
                    for (int i = 0; i < 10; i++) {
                
      out.write("  <div class=\"col-md-3 cardCol\">\n");
      out.write("                    <div class=\"card mycard\" id=\"");
      out.print( lugares.get(i).getIdLugar());
      out.write("\" onclick=\"geraPg(this)\">\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <h3 class=\"card-title\"> ");
 out.print(lugares.get(i).getNome()); 
      out.write(" </h3>\n");
      out.write("                            <p class=\"card-text\">");
 out.print(lugares.get(i).getCategoria().getNome()); 
      out.write("</p>\n");
      out.write("                            <p class=\"card-text\">");
 out.print(lugares.get(i).getDescricao());
      out.write("</p>\n");
      out.write("                        </div>\n");
      out.write("                        <p>");
      out.print( test);
      out.write("</p>\n");
      out.write("                    </div>\n");
      out.write("                </div> ");

                    }
                
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <p>Lorem ipsum duis ac nam litora eros molestie fusce urna, imperdiet tortor lectus sapien mollis fames euismod\n");
      out.write("                lorem dui, aenean accumsan donec a blandit nisl auctor iaculis. dapibus molestie libero inceptos lobortis\n");
      out.write("                vehicula arcu pharetra massa, habitasse imperdiet ad ornare platea at facilisis eleifend, scelerisque metus\n");
      out.write("                ultricies donec volutpat potenti class. primis sed varius aliquam luctus dapibus, nostra per malesuada\n");
      out.write("                sollicitudin donec placerat, aenean cras lacinia vitae. lobortis auctor senectus vulputate curae ipsum ultricies\n");
      out.write("                id urna lorem etiam, imperdiet eleifend fames vestibulum pretium rutrum vel sociosqu mollis sodales diam, mattis\n");
      out.write("                conubia lacinia enim mattis nibh fusce cras lacus. </p>\n");
      out.write("\n");
      out.write("            <p>Lorem ipsum duis ac nam litora eros molestie fusce urna, imperdiet tortor lectus sapien mollis fames euismod\n");
      out.write("                lorem dui, aenean accumsan donec a blandit nisl auctor iaculis. dapibus molestie libero inceptos lobortis\n");
      out.write("                vehicula arcu pharetra massa, habitasse imperdiet ad ornare platea at facilisis eleifend, scelerisque metus\n");
      out.write("                ultricies donec volutpat potenti class. primis sed varius aliquam luctus dapibus, nostra per malesuada\n");
      out.write("                sollicitudin donec placerat, aenean cras lacinia vitae. lobortis auctor senectus vulputate curae ipsum ultricies\n");
      out.write("                id urna lorem etiam, imperdiet eleifend fames vestibulum pretium rutrum vel sociosqu mollis sodales diam, mattis\n");
      out.write("                conubia lacinia enim mattis nibh fusce cras lacus. </p>\n");
      out.write("\n");
      out.write("            <p style=\"margin-bottom: 50px\">Lorem ipsum duis ac nam litora eros molestie fusce urna, imperdiet tortor lectus sapien mollis fames euismod\n");
      out.write("                lorem dui, aenean accumsan donec a blandit nisl auctor iaculis. dapibus molestie libero inceptos lobortis\n");
      out.write("                vehicula arcu pharetra massa, habitasse imperdiet ad ornare platea at facilisis eleifend, scelerisque metus\n");
      out.write("                ultricies donec volutpat potenti class. primis sed varius aliquam luctus dapibus, nostra per malesuada\n");
      out.write("                sollicitudin donec placerat, aenean cras lacinia vitae. lobortis auctor senectus vulputate curae ipsum ultricies\n");
      out.write("                id urna lorem etiam, imperdiet eleifend fames vestibulum pretium rutrum vel sociosqu mollis sodales diam, mattis\n");
      out.write("                conubia lacinia enim mattis nibh fusce cras lacus. </p>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <footer class=\"myfooter footer mt-auto py-3\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row mx-3\">\n");
      out.write("                    <div class=\"col-sm-3 mt-3\">\n");
      out.write("                        <i class=\"far fa-compass\" aria-hidden=\"true\" style=\"font-size: 150px; color: #ffffff;\"></i>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3 mt-3\">\n");
      out.write("                        <h2 style=\"color: #ffffff;\"><b>Sobre</b></h2> <!-- //#4A44F2 -->\n");
      out.write("                        <div class=\"col\">\n");
      out.write("                            <a href=\"#\" style=\"color: #ffffff;\">\n");
      out.write("                                <p>Opção 1</p>\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3 mt-3\" style=\"color: #ffffff;\">\n");
      out.write("                        <h2><b>Lugares</b></h2>\n");
      out.write("                        <a href=\"#\" style=\"color: #ffffff;\">\n");
      out.write("                            <p>Opção 1</p>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3 mt-3\" style=\"color: #ffffff;\">\n");
      out.write("                        <h2><b>Redes Sociais</b></h2>\n");
      out.write("                        <a href=\"#\" style=\"color: #ffffff;\">\n");
      out.write("                            <p>Opção 1</p>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("        <footer class=\"myfooter-copyright footer mt-auto\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row justify-content-center\">\n");
      out.write("                    <p><small>Fabricado por Juan - 2020</small></p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </footer><!-- FIM FOOTERS -->\n");
      out.write("\n");
      out.write("        <!-- font awesome -->\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/js/all.min.js\"></script>\n");
      out.write("        <!-- Optional JavaScript -->\n");
      out.write("        <!-- jQuery first, then Popper.js, then Bootstrap JS -->\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"\n");
      out.write("                integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\"\n");
      out.write("        crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"\n");
      out.write("                integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\"\n");
      out.write("        crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"\n");
      out.write("                integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\"\n");
      out.write("        crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"js/GeraPgLugar.js\"></script> <!-- Guarda dados perfil do lugar  -->\n");
      out.write("        <script>\n");
      out.write("                        $(function () {\n");
      out.write("                            $(window).on('popstate', function () {\n");
      out.write("                                location.reload(true);\n");
      out.write("                            });\n");
      out.write("                        });\n");
      out.write("        </script>\n");
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
