package org.apache.jsp.Vistas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class iniciarsesion_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html class=\"no-js\"> \n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <title>Agenda Personal - AgenPerWeb</title>\n");
      out.write("        <link rel=\"shortcut icon\" href=\"Diseño/Dis1/favicon.ico\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Raleway:200,300,400,700\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\".../Diseño/Dis1/css/animate.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\".../Diseño/Dis1/css/icomoon.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\".../Diseño/Dis1/css/bootstrap.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\".../Diseño/Dis1/css/flexslider.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\".../Diseño/Dis1/css/owl.carousel.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\".../Diseño/Dis1/css/owl.theme.default.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\".../Diseño/Dis1/css/style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\".../Diseño/Dis1/css/login.css\">\n");
      out.write("        <script src=\".../Diseño/Dis1/js/modernizr-2.6.2.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n");
      out.write("        <script src=\".../Diseño/Dis1/js/ajax.js\"></script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div id=\"fh5co-page\">\n");
      out.write("            <header id=\"fh5co-header\" role=\"banner\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"header-inner\">\n");
      out.write("                        <h1><a href=\"../index.jsp\">AgenPerWeb</a></h1>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </header>\n");
      out.write("            <br/>            \n");
      out.write("\n");
      out.write("            <div class=\"login-form\">\n");
      out.write("\n");
      out.write("                <h1>Iniciar sesión</h1>\n");
      out.write("\n");
      out.write("                <h3 id=\"mensaje\" style=\"text-align: center;\"></h3>\n");
      out.write("                <form class=\"login\" onSubmit=\"iniciarSesionQuery();\n");
      out.write("                        return false\" >\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"form-group \">\n");
      out.write("                        <input type=\"email\" class=\"form-control\" placeholder=\"Correo\" name=\"cor\" id=\"cor\" required autofocus>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"form-group log-status\">\n");
      out.write("                        <input type=\"password\" class=\"form-control\" placeholder=\"Contraseña\" name=\"cla\" id=\"cla\" required autofocus>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <button class=\"log-btn\" type=\"submit\" >Aceptar</button><br/><br/> \n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("                <a class=\"link\" href=\"registrar.jsp\">¿Deseas registrarte?</a> \n");
      out.write("            </div><br/>\n");
      out.write("\n");
      out.write("            <footer id=\"fh5co-footer\" role=\"contentinfo\">\n");
      out.write("\n");
      out.write("                <div class=\" fh5co-copyright text-center\">\n");
      out.write("                    <p>&copy; Todos los derechos reservados 2016</p>\t\n");
      out.write("                </div>\n");
      out.write("            </footer>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- jQuery -->\n");
      out.write("\n");
      out.write("        <script class=\"cssdeck\" src=\"//cdnjs.cloudflare.com/ajax/libs/jquery/1.8.0/jquery.min.js\"></script>\n");
      out.write("        <script src=\".../Diseño/Dis1/js/jquery.min.js\"></script>\n");
      out.write("        <script src=\".../Diseño/Dis1/js/jquery.easing.1.3.js\"></script>\n");
      out.write("        <script src=\".../Diseño/Dis1/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\".../Diseño/Dis1/js/jquery.waypoints.min.js\"></script>\n");
      out.write("        <script src=\".../Diseño/Dis1/js/owl.carousel.min.js\"></script>\n");
      out.write("        <script src=\".../Diseño/Dis1/js/jquery.flexslider-min.js\"></script>\n");
      out.write("        <script src=\".../Diseño/Dis1/js/main.js\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
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
