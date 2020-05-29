package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DAO.CategoriaDAO;
import model.Estado;
import java.util.List;
import DAO.EstadoDAO;
import model.Categoria;

public final class LugarUpdate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


            //Pegar estado para select
            EstadoDAO daoEstado = new EstadoDAO();
            List<Estado> estados = daoEstado.getEstado();

            //Pegar categorias para selecr
            CategoriaDAO daoCategoria = new CategoriaDAO();
            List<Categoria> categorias = daoCategoria.getCategoria();

        
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
      out.write("            /* var update = JSON.parse(sessionStorage.getItem('update'));\n");
      out.write("             console.log(update);\n");
      out.write("             var coluna = JSON.parse(sessionStorage.getItem('coluna'));\n");
      out.write("             console.log(coluna); */\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("        ");

            try {
                HttpSession sessao = request.getSession();
                int id = (Integer) sessao.getAttribute("idUsuarioLogado");
        
      out.write("\n");
      out.write("        <!-- Achar um jeito de alterar mandando coluna, novoValor, e id do Lugar -->\n");
      out.write("        <form onsubmit=\"return validaForm(this)\" >\n");
      out.write("            <label style=\"color: black;\">Nome:</label>\n");
      out.write("            <input class=\"dados\" id=\"nome\" name=\"nNome\" style=\"color: black;\"/>\n");
      out.write("            <br/>\n");
      out.write("            <label style=\"color: black;\">Avaliacao:</label>\n");
      out.write("            <input class=\"dados\" id=\"avaliacao\" name=\"nAvaliacao\" style=\"color: black;\"/>\n");
      out.write("            <br/>\n");
      out.write("            <label style=\"color: black;\">Categoria:</label>\n");
      out.write("            <select class=\"dados form-control\" name=\"nCategoria\" id=\"categoria\">\n");
      out.write("                <option class=\"Selecione\" value=\"\" disabled selected hidden>Selecione...</option>\n");
      out.write("                ");

                    for (Categoria categoria : categorias) {
                
      out.write("<option name=\"nCategoria\" value=\"");
 out.print(categoria.getIdCategoria()); 
      out.write('"');
      out.write('>');
 out.print(categoria.getNome());
                    }
                    
      out.write("</option>\n");
      out.write("            </select>\n");
      out.write("            <br/>\n");
      out.write("            <label style=\"color: black;\">Acesso:</label>\n");
      out.write("            <select class=\"dados form-control\" name=\"nAcesso\" id=\"acesso\" required>\n");
      out.write("                <option name=\"nAcesso\" value=\"gratuito\">Gratuito</option>\n");
      out.write("                <option name=\"nAcesso\" value=\"pago\">Pago</option>\n");
      out.write("                <option name=\"nAcesso\" value=\"Requer Permissão\">Requer Permissão</option>\n");
      out.write("            </select>\n");
      out.write("            <br/>\n");
      out.write("            <label style=\"color: black;\">Abre:</label>\n");
      out.write("            <input class=\"dados\" id=\"horaInicial\" name=\"nHoraInicial\" style=\"color: black;\"/>\n");
      out.write("            <br/>\n");
      out.write("            <label style=\"color: black;\">Fecha:</label>\n");
      out.write("            <input class=\"dados\" id=\"horaFinal\" name=\"nHoraFinal\" style=\"color: black;\"/>\n");
      out.write("            <br/>\n");
      out.write("            <div class=\"form-check form-check-inline\">\n");
      out.write("                <input class=\"form-check-input\" type=\"checkbox\" id=\"semHorario\" value=\"semHorario\">\n");
      out.write("                <label class=\"form-check-label\" for=\"semHorario\">Sem horário</label>\n");
      out.write("            </div>\n");
      out.write("            <label style=\"color: black;\">Descrição:</label>\n");
      out.write("            <input class=\"dados\" id=\"descricao\" name=\"nDescricao\" style=\"color: black;\"/>\n");
      out.write("            <br/>\n");
      out.write("            <label style=\"color: black;\">Estado:</label>\n");
      out.write("            <select class=\"form-control\" name=\"nEstado\" id=\"estado\" required>\n");
      out.write("                <option class=\"Selecione\" value=\"\" disabled selected hidden>Selecione...</option>\n");
      out.write("                ");

                    for (Estado estado : estados) {
                        int idEst = estado.getIdEstado();
                        String nome = estado.getNome();
                
      out.write("<option name=\"nEstado\" value=\"");
 out.print(idEst); 
      out.write('"');
      out.write('>');
 out.print(nome);
                    }
                    
      out.write("</option>\n");
      out.write("            </select>\n");
      out.write("            <br/>\n");
      out.write("            <label style=\"color: black;\">Cidade:</label>\n");
      out.write("            <select class=\"form-control\" name=\"nCidade\" id=\"cidade\" required>\n");
      out.write("                <option value=\"\" disabled selected hidden>Selecione...</option>\n");
      out.write("            </select>\n");
      out.write("            <br/>\n");
      out.write("            <label style=\"color: black;\">Bairro:</label>\n");
      out.write("            <input class=\"dados\" id=\"bairro\" name=\"nBairro\" style=\"color: black;\"/>\n");
      out.write("            <br/>\n");
      out.write("            <label style=\"color: black;\">Rua:</label>\n");
      out.write("            <input class=\"dados\" id=\"rua\" name=\"nRua\" style=\"color: black;\"/>\n");
      out.write("            <br/>\n");
      out.write("            <label style=\"color: black;\">N:</label>\n");
      out.write("            <input class=\"dados\" id=\"numero\" name=\"nNumero\" style=\"color: black;\"/>\n");
      out.write("            <br/>\n");
      out.write("            <button id=\"botao\" type=\"submit\" onclick=\"atualizaLugar()\">Salvar</button>\n");
      out.write("        </form>\n");
      out.write("            <button  onclick=\"window.location.assign('newjsp.jsp');\">Cancelar</button>\n");
      out.write("        \n");
      out.write("        <h1>Hello World!</h1>\n");
      out.write("        ");

            } catch (Exception e) {
                RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                rd.forward(request, response);
            }
        
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"http://code.jquery.com/jquery-3.4.1.min.js\"\n");
      out.write("        integrity=\"sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\"></script> <!-- AJAX -->\n");
      out.write("        <script type=\"text/javascript\" src=\"js/UpdateLugar.js\"></script> <!-- MEU AJAX  para atualizar dados-->\n");
      out.write("        <script type=\"text/javascript\" src=\"js/GetCidades.js\"></script> <!-- MEU AJAX pegar dados-->\n");
      out.write("        <script type=\"text/javascript\" src=\"js/ValidaCadLugar.js\"></script>\n");
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
