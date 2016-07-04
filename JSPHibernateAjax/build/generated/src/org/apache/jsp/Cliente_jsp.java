package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Cliente_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script src=\"funciones.js\">\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Hello World!</h1>\n");
      out.write("        <form method=\"post\">\n");
      out.write("            <input type=\"text\" id=\"rut\" name=\"rut\" placeholder=\"Rut\"/>\n");
      out.write("            <input type=\"text\" id=\"nombre\" name=\"nombre\" placeholder=\"Nombre\"/>\n");
      out.write("            <input type=\"text\" id=\"apellido\" name=\"apellido\" placeholder=\"Apellido\"/>\n");
      out.write("            <input type=\"button\" value=\"Insertar\" onclick=\"InsertarCliente(rut.value, nombre.value, apellido.value)\"/>\n");
      out.write("            <input type=\"button\" value=\"ConsultarTodos\" onclick=\"ClienteConsultaAll(nombre.value)\"/>\n");
      out.write("            <input type=\"submit\" value=\"ConsultarTodos\"/>\n");
      out.write("        </form>\n");
      out.write("        <table id=\"tableClient\" border=\"1\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Nombres</th>\n");
      out.write("                <th>Apellidos</th>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        <div id=\"divParcial\"></div>\n");
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
