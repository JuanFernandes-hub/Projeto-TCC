package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import model.Lugar;
import DAO.LugarDAO;

public final class Lugares_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Colibri - Lugares</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\n");
      out.write("              integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            LugarDAO lugardao = new LugarDAO();
            List<Lugar> lugares = lugardao.getLugar();
        
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            ");

                    for(Lugar lugar: lugares){
                
      out.write("  <div class=\"col-md-4\">\n");
      out.write("                    <div class=\"card\" name=\" jbj\" id=\"");
 out.print(lugar.getIdLugar()); 
      out.write("\" onclick=\"geraPg(this);\">\n");
      out.write("                            <div class=\"card-body\">\n");
      out.write("                                <h3 class=\"card-title\"> ");
 out.print(lugar.getNome()); 
      out.write(" </h3>\n");
      out.write("                                <p class=\"card-text\">");
 out.print(lugar.getDescricao()); 
      out.write("</p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div> ");

                    }    
                
      out.write("\n");
      out.write("                \n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <script src=\"http://code.jquery.com/jquery-3.4.1.min.js\" integrity=\"sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"http://code.jquery.com/jquery-3.4.1.min.js\"></script>\n");
      out.write("        <script src=\"bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\"></script> <!-- ajax -->\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("                function geraPg(e){\n");
      out.write("                    //redirecionar para uma página\n");
      out.write("                    window.location.assign(\"Lugar.jsp\");\n");
      out.write("                    console.log($(e).find(\".card-title\").text());\n");
      out.write("                    console.log($(e).id);\n");
      out.write("                    /*function redireciona(e){\n");
      out.write("                        e.getId();\n");
      out.write("                        e.getNome();\n");
      out.write("                    }*/\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                //criar função que recebe id do card e buscar dados para por em campos\n");
      out.write("                \n");
      out.write("                \n");
      out.write("            \n");
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
