package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Categoria;
import DAO.CategoriaDAO;
import model.Estado;
import DAO.EstadoDAO;
import java.util.List;
import java.util.ArrayList;

public final class CadastraLugar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Colibri - Cadastro de Lugares</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" rel=\"stylesheet\"> <!-- Bootstrap -->\n");
      out.write("        <link href=\"bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\" /> <!-- pasta Bootstrap -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/EstilosCadastro.css\"> <!-- css entrar -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/EstilosRodape.css\"> <!-- css do rodape -->\n");
      out.write("        <script type=\"text/javascript\" src=\"js/ValidaCadLugar.js\"></script> <!-- Validação -->\n");
      out.write("\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("            <form action=\"CadastraLugar\" method=\"post\" onsubmit=\"return validaForm(this)\" class=\"col-sm-6\" id=\"formLugar\">\n");
      out.write("                <div class=\"row justify-content-md-center\">\n");
      out.write("                    <h1 style=\"color: black\">Crie sua conta</h1>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"nome\" class=\"\" style=\"color: black;\">Nome do lugar</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"nNome\" id=\"nome\" placeholder=\"Nome\" autofocus required>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!-- SELECT CATEGORIAS -->\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"categoria\" class=\"\" style=\"color: black;\">Categoria</label>\n");
      out.write("                    <select class=\"form-control\" name=\"nCategoria\" id=\"categoria\">\n");
      out.write("                        ");

                            for (Categoria categoria : categorias) {
                        
      out.write("<option name=\"nCategoria\" value=\"");
 out.print(categoria.getIdCategoria()); 
      out.write('"');
      out.write('>');
 out.print(categoria.getNome());
                            }
                            
      out.write("</option>\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"form-row \">\n");
      out.write("                    <div class=\"col-5\">\n");
      out.write("                        <label for=\"acesso\">Acesso</label>\n");
      out.write("                        <select class=\"form-control\" name=\"nAcesso\" id=\"acesso\">\n");
      out.write("                            <option name=\"nAcesso\" value=\"gratuito\">Gratuito</option>\n");
      out.write("                            <option name=\"nAcesso\" value=\"pago\">Pago</option>\n");
      out.write("                            <option name=\"nAcesso\" value=\"Requer Permissão\">Requer Permissão</option>\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col\">\n");
      out.write("                        <label for=\"horarioInicial\" class=\"\" style=\"color: black;\">Das</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"nHorarioInicial\" id=\"horarioInicial\" placeholder=\"Horário Inicial\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col\">\n");
      out.write("                        <label for=\"horarioFinal\" class=\"\" style=\"color: black;\">Às</label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"nHorarioFinal\" id=\"horarioFinal\" placeholder=\"Horário Final\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("\n");
      out.write("                <!-- SELECT ESTADO-->\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"estado\" class=\"\" style=\"color: black;\">Estado</label>\n");
      out.write("                    <select class=\"form-control\" name=\"nEstado\" id=\"estado\" required>\n");
      out.write("                        <option class=\"Selecione\" value=\"\" disabled selected hidden>Selecione...</option>\n");
      out.write("                        ");

                            for (Estado estado : estados) {
                                int id = estado.getIdEstado();
                                String nome = estado.getNome();
                        
      out.write("<option name=\"nEstado\" value=\"");
 out.print(id); 
      out.write('"');
      out.write('>');
 out.print(nome);
                            }
                            
      out.write("</option>\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <!-- SELECT CIDADE -->\n");
      out.write("                <div class=\"form-group\" >\n");
      out.write("                    <label for=\"cidade\" class=\"\" style=\"color: black;\">Cidade</label>\n");
      out.write("                    <select class=\"form-control\" name=\"nCidade\" id=\"cidade\" required>\n");
      out.write("                        <!-- option gerados por ajax, de acordo com o estado selecionado -->\n");
      out.write("                        <option value=\"\" disabled selected hidden>Selecione...</option>\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"bairro\" class=\"\" style=\"color: black;\">Bairro (opcional)</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"nBairro\" id=\"bairro\" placeholder=\"Bairro\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"rua\" class=\"\" style=\"color: black;\">Rua (opcional)</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"nRua\" id=\"rua\" placeholder=\"R. Rio Branco\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"numero\" class=\"\" style=\"color: black;\">N° (opcional)</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"nNumero\" id=\"numero\" placeholder=\"Número\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"complemento\" class=\"\" style=\"color: black;\">Complemento (opcional)</label>\n");
      out.write("                    <textarea class=\"form-control\" name=\"nComplemento\" id=\"complemento\" placeholder=\"Digite alguns detalhes.\" rows=\"5\"></textarea>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <br>\n");
      out.write("                \n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"descricao\" class=\"\" style=\"color: black;\">Descrição</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"nDescricao\" id=\"descricao\" placeholder=\"Descreva o lugar em uma frase\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                <button type=\"submit\" id=\"botao\" class=\"btn btn-warning\">Enviar</button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- IMPORTANTE - SCRIPTS NECESSARIOS PARA O FUNCIONAMENTO DO DROPDOWN -->\n");
      out.write("        <script src=\"http://code.jquery.com/jquery-3.4.1.min.js\"\n");
      out.write("        integrity=\"sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js\"></script> <!-- MASCARAS -->\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery.mask.min.js\"></script> <!-- MASCARAS -->\n");
      out.write("        <script type=\"text/javascript\" src=\"js/Mascaras.js\"></script> <!-- FORMATA MASCARAS -->\n");
      out.write("        <script src=\"bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\"></script> <!-- AJAX -->\n");
      out.write("        <script type=\"text/javascript\" src=\"js/GetCidades.js\"></script> <!-- MEU AJAX -->\n");
      out.write("        \n");
      out.write("        \n");
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
