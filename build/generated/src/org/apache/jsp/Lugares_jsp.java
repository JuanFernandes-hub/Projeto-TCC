package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Cidade;
import DAO.CidadeDAO;
import model.Estado;
import DAO.EstadoDAO;
import model.Categoria;
import DAO.CategoriaDAO;
import java.util.List;
import model.Lugar;
import DAO.LugarDAO;

public final class Lugares_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


            LugarDAO lugardao = new LugarDAO();
            //resetar List
            List<Lugar> lugares = null;
            
            CategoriaDAO categoriadao = new CategoriaDAO();
            List<Categoria> categorias = categoriadao.getCategoria();
            
            EstadoDAO estado = new EstadoDAO();
            List<Estado> estados = estado.getEstado();
            
            List<Cidade> cidades = CidadeDAO.getCidade();
        
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Lugares - Colibri</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\n");
      out.write("              integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <select class=\"filtroCatg\" id=\"filtroCatg\">\n");
      out.write("                 <option class=\"Selecione\" value=\"\" disabled selected hidden>Selecione...</option>\n");
      out.write("                ");

                    for(Categoria categoria : categorias){
                
      out.write("<option value=\"");
      out.print( categoria.getIdCategoria() );
      out.write("\"> ");
      out.print( categoria.getNome() );
      out.write(" </option>\n");
      out.write("                        ");

                    }
                
      out.write("\n");
      out.write("            </select>\n");
      out.write("            \n");
      out.write("            <select class=\"filtroCatg\">\n");
      out.write("                 <option class=\"Selecione\" value=\"\" disabled selected hidden>Selecione...</option>\n");
      out.write("                ");

                    for(Estado estado : estados){
                
      out.write("<option value=\"");
      out.print( estado.getSigla() );
      out.write("\"> ");
      out.print( estado.getNome() );
      out.write(" </option>\n");
      out.write("                        ");

                    }
                
      out.write("\n");
      out.write("            </select>\n");
      out.write("            \n");
      out.write("            <button class=\"filtroCatg\" value=\"semFiltro\" onclick=\"limpaFiltro()\">Sem filtro</button>\n");
      out.write("            \n");
      out.write("            ");

                lugares = LugarDAO.getLugar();
                for (Lugar lugar : lugares) {
                    //variaveis para colocar classe para filtar
                    int idCategoria = lugar.getCategoria().getIdCategoria();
                    int idCidade = lugar.getLocalizacao().getCidade().getIdCidade();
                    String siglaEst = lugar.getLocalizacao().getCidade().getEstado().getSigla();
                    
            
      out.write("  <div class=\"col-md-4\">\n");
      out.write("                <div class=\"card ");
      out.print( lugar.getCategoria().getIdCategoria() );
      out.write("\">\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <h3 class=\"card-title\"> ");
      out.print( lugar.getNome() );
      out.write(" </h3>\n");
      out.write("                        <p class=\"card-text\">");
      out.print( lugar.getCategoria().getNome() );
      out.write("</p>\n");
      out.write("                        <p class=\"card-text\">");
      out.print( lugar.getDescricao() );
      out.write("</p>\n");
      out.write("                        <a href=\"GetLugar?idLugar=");
      out.print( lugar.getIdLugar());
      out.write("&act=get\">Ver Mais</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div> ");

                }
            
      out.write("\n");
      out.write("\n");
      out.write("            \n");
      out.write("            \n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/js/all.min.js\"></script>\n");
      out.write("        <script src=\"http://code.jquery.com/jquery-3.4.1.min.js\" integrity=\"sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(\".filtroCatg\").on(\"change\",function(){\n");
      out.write("                let ctg = $(this).val();\n");
      out.write("                let cards = $(\".card\")\n");
      out.write("                console.log(ctg);\n");
      out.write("                //$(cards).fadeOut();\n");
      out.write("                $(cards).each(function(){\n");
      out.write("                    if(!$(this).hasClass(ctg)){\n");
      out.write("                        $(this).fadeOut();\n");
      out.write("                    }\n");
      out.write("                })\n");
      out.write("            });\n");
      out.write("            \n");
      out.write("            function limpaFiltro(){\n");
      out.write("                let cards = $(\".card\");\n");
      out.write("                $(cards).fadeIn();\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
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
