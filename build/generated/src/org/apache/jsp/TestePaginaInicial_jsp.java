package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import model.Lugar;
import DAO.LugarDAO;

public final class TestePaginaInicial_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


                    LugarDAO lugardao = new LugarDAO();
                    List<Lugar> lugares = lugardao.getLugar();
                
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
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\n");
      out.write("              integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,500;0,700;0,900;1,300;1,400;1,500;1,700;1,900&display=swap\" rel=\"stylesheet\"> \n");
      out.write("        <link rel=\"stylesheet\" href=\"css/PaginaInicialEstilo.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/PgInicialCardEstilos.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/EstilosRodape.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"section-top\">\n");
      out.write("            <nav class=\"navbar navbar-expand-md navbar-dark edit-nav\">\n");
      out.write("                <!-- navbar expansiva -->\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <!-- Logo -->\n");
      out.write("                    <a class=\"navbar-brand\" href=\"index.html\" style=\"color: white;\">\n");
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
      out.write("                                <a class=\"nav-link\" href=\"index.html\" style=\"color: #ffffff;\"><b>Home</b></a>\n");
      out.write("                                <!-- como um \"\"\"botao\"\"\" , mas e um link-->\n");
      out.write("                            </li>\n");
      out.write("\n");
      out.write("                            <li class=\"nav-item\">\n");
      out.write("                                <a class=\"nav-link\" href=\"#\" style=\"color: #ffffff;\"><b>Lugares</b></a>\n");
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
      out.write("            <div class=\"content\">\n");
      out.write("                <h1>Descubra sua Cidade</h1>\n");
      out.write("                <input class=\"input-imagem\" type=\"search\" name=\"\" id=\"\" placeholder=\"Pesquise Lugares\">\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!-- Setinha -->\n");
      out.write("            <div class=\"content2\">\n");
      out.write("                <i class=\"fas fa-chevron-down\" style=\"\"></i>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"container pt-5\">\n");
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("                ");
      out.write("\n");
      out.write("                ");

                    //Limitar numero de cards na home
                    for (int i = 0; i < lugares.size(); i++) {
                
      out.write("  <div class=\"col-md-3 my-card-col\" style=\"padding-left: 10px; padding-right: 10px;\">\n");
      out.write("                    <div class=\"card-container mycard\" id=\"");
      out.print( lugares.get(i).getIdLugar());
      out.write("\">\n");
      out.write("                        <div class=\"card-img\"></div>\n");
      out.write("                        <div class=\"card-container-texto\">\n");
      out.write("                            <a class=\"card-titulo\" href=\"#\">");
      out.print( lugares.get(i).getNome());
      out.write("</a>\n");
      out.write("                            <p class=\"card-texto\">");
      out.print( lugares.get(i).getCategoria().getNome());
      out.write("</p>\n");
      out.write("                            <p class=\"card-texto\">");
      out.print( lugares.get(i).getDescricao());
      out.write("</p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"my-card-footer\">\n");
      out.write("                            <a href=\"GetLugar?idLugar=");
      out.print( lugares.get(i).getIdLugar());
      out.write("&act=get\">Ver Mais</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                ");

                        if (i >= 11) {
                            break;
                        }
                    }
                
      out.write("        \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <footer class=\"myfooter footer mt-auto py-3\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row justify-content-center area-footer-opcao\">\n");
      out.write("                    <h2><b>Colibri</b></h2>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row justify-content-center\">\n");
      out.write("                    <div class=\"col-sm-4 mt-3 area-footer-opcao\">\n");
      out.write("                        <h2><b>Sobre</b></h2>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-4 mt-3 area-footer-opcao\">\n");
      out.write("                        <h2><b>Lugares</b></h2>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-4 mt-3 area-footer-opcao\">\n");
      out.write("                        <h2><b>Redes Sociais</b></h2>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("        <footer class=\"myfooter-copyright footer mt-auto\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row justify-content-center\">\n");
      out.write("                    <p>Fabricado por Juan - 2020</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </footer><!-- FIM FOOTERS -->\n");
      out.write("\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/js/all.min.js\"></script>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"\n");
      out.write("                integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\"\n");
      out.write("        crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"\n");
      out.write("                integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\"\n");
      out.write("        crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"\n");
      out.write("                integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\"\n");
      out.write("        crossorigin=\"anonymous\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("        </body>\n");
      out.write("        </html>\n");
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
