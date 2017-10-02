package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html class=\"no-js\"> \n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <title>Agenda Personal - AgenPerWeb</title>\n");
      out.write("        <link rel=\"shortcut icon\" href=\"Diseño/Dis1/favicon.ico\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Raleway:200,300,400,700\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"Diseño/Dis1/css/animate.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"Diseño/Dis1/css/icomoon.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"Diseño/Dis1/css/bootstrap.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"Diseño/Dis1/css/flexslider.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"Diseño/Dis1/css/owl.carousel.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"Diseño/Dis1/css/owl.theme.default.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"Diseño/Dis1/css/style.css\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div id=\"fh5co-page\">\n");
      out.write("\n");
      out.write("            <header id=\"fh5co-header\" role=\"banner\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"header-inner\">\n");
      out.write("                        <h1><a href=\"index.jsp\">AgenPerWeb</a></h1>\n");
      out.write("                        <nav role=\"navigation\">\n");
      out.write("                            <ul>                              \n");
      out.write("                                <li class=\"cta\"><a href=\"Vistas/iniciarsesion.jsp\">Iniciar sesión</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </nav>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </header>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <aside id=\"fh5co-hero\" class=\"js-fullheight\">\n");
      out.write("                <div class=\"flexslider js-fullheight\">\n");
      out.write("                    <ul class=\"slides\">\n");
      out.write("                        <li style=\"background-image: url(Diseño/Dis1/images/slide_1.jpg);\">\n");
      out.write("                            <div class=\"overlay-gradient\"></div>\n");
      out.write("                            <div class=\"container\">\n");
      out.write("                                <div class=\"col-md-10 col-md-offset-1 text-center js-fullheight slider-text\">\n");
      out.write("                                    <div class=\"slider-text-inner\">\n");
      out.write("                                        <h2>Te ayudaremos a organizar todos tus compromisos diarios</h2>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </li>\n");
      out.write("                        <li style=\"background-image: url(Diseño/Dis1/images/slide_2.jpg);\">\n");
      out.write("                            <div class=\"container\">\n");
      out.write("                                <div class=\"col-md-10 col-md-offset-1 text-center js-fullheight slider-text\">\n");
      out.write("                                    <div class=\"slider-text-inner\">\n");
      out.write("                                        <h2>AgenPerWeb es una agenda personal en linea </h2>\n");
      out.write("                                        <p><a href=\"Vistas/iniciarsesion.jsp\" class=\"btn btn-primary btn-lg\">¿Deseas iniciar sesion?</a></p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </li>\n");
      out.write("                        <li style=\"background-image: url(Diseño/Dis1/images/slide_3.jpg);\">\n");
      out.write("                            <div class=\"container\">\n");
      out.write("                                <div class=\"col-md-10 col-md-offset-1 text-center js-fullheight slider-text\">\n");
      out.write("                                    <div class=\"slider-text-inner\">\n");
      out.write("                                        <h2>Ofrecemos tecnologia, seguridad y mucho mas...</h2>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </aside>\n");
      out.write("\n");
      out.write("            <div id=\"fh5co-services-section\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-6 col-md-offset-3 text-center fh5co-heading animate-box\">\n");
      out.write("                            <h2>Nuestras caracteristicas</h2>\n");
      out.write("                            <p> Somos un proyecto enfocado a organizar todos tus compromisos diarios.</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-4 animate-box\">\n");
      out.write("                            <div class=\"services\">\n");
      out.write("                                <i class=\"icon-laptop\"></i>\n");
      out.write("                                <div class=\"desc\">\n");
      out.write("                                    <h3>Seguridad</h3>\n");
      out.write("                                    <p>Nuestra aplicacion cuenta con un logeo de HttpSession para proteger el acceso.</p>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-4 animate-box\">\n");
      out.write("                            <div class=\"services\">\n");
      out.write("                                <i class=\"icon-server\"></i>\n");
      out.write("                                <div class=\"desc\">\n");
      out.write("                                    <h3>Confiabilidad</h3>\n");
      out.write("                                    <p>Su informacion estara totalmente segura en nuestros servidores MySQL.</p>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-4 animate-box\">\n");
      out.write("                            <div class=\"services\">\n");
      out.write("                                <i class=\"icon-tablet\"></i>\n");
      out.write("                                <div class=\"desc\">\n");
      out.write("                                    <h3>Adaptabilidad</h3>\n");
      out.write("                                    <p>Nuestro diseño es responsivo, por lo tanto puedes acceder en cualquier dispositivo.</p>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"fh5co-testimony-section\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-6 col-md-offset-3 text-center fh5co-heading animate-box\">\n");
      out.write("                            <h2>¿Quienes somos?</h2>\n");
      out.write("                            <p>Este proyecto es desarrollado por estudiantes de ingenieria de sistemas de la UFPS. </p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-12 col-offset-0 to-animate\">\n");
      out.write("                            <div class=\"wrap-testimony animate-box\">\n");
      out.write("                                <div class=\"owl-carousel-fullwidth\">\n");
      out.write("                                    <div class=\"item\">\n");
      out.write("                                        <div class=\"testimony-slide active text-center\">\n");
      out.write("                                            <figure>\n");
      out.write("                                                <img src=\"Diseño/Dis1/images/perfil1.jpg\" alt=\"user\">\n");
      out.write("                                            </figure>\n");
      out.write("                                            <blockquote>\n");
      out.write("                                                <p>Cristian Ramirez</p>\n");
      out.write("                                            </blockquote>\n");
      out.write("                                            <span>Estudiante de 7° semestre de Ing. Sistemas </span>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"item\">\n");
      out.write("                                        <div class=\"testimony-slide active text-center\">\n");
      out.write("                                            <figure>\n");
      out.write("                                                <img src=\"Diseño/Dis1/images/perfil2.jpg\" alt=\"user\">\n");
      out.write("                                            </figure>\n");
      out.write("                                            <blockquote>\n");
      out.write("                                                <p>Jhon Galvis</p>\n");
      out.write("                                            </blockquote>\n");
      out.write("                                            <span>Estudiante de 6° semestre de Ing. Sistemas</span>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"fh5co-cta\" style=\"background-image: url(Diseño/Dis1/images/slide_2.jpg);\">\n");
      out.write("                <div class=\"overlay\"></div>\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"col-md-12 text-center animate-box\">\n");
      out.write("                        <h3>Inicia sesion para poder entrar a la aplicación.</h3>\n");
      out.write("                        <p><a href=\"Vistas/iniciarsesion.jsp\" class=\"btn btn-primary btn-outline with-arrow\">Aqui! <i class=\"icon-arrow-right\"></i></a></p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
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
      out.write("        <script src=\"Diseño/Dis1/js/modernizr-2.6.2.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"Diseño/Dis1/js/jquery.min.js\"></script>\n");
      out.write("        <script src=\"Diseño/Dis1/js/jquery.easing.1.3.js\"></script>\n");
      out.write("        <script src=\"Diseño/Dis1/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"Diseño/Dis1/js/jquery.waypoints.min.js\"></script>\n");
      out.write("        <script src=\"Diseño/Dis1/js/owl.carousel.min.js\"></script>\n");
      out.write("        <script src=\"Diseño/Dis1/js/jquery.flexslider-min.js\"></script>\n");
      out.write("        <script src=\"Diseño/Dis1/js/main.js\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
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
