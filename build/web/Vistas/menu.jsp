<%-- 
    Document   : menu
    Created on : 8/10/2016, 12:26:26 PM
    Author     : Cristian Ramirez
--%>

<%  if (session.getAttribute("sesion") == null) {
        response.sendRedirect("../index.jsp");
    }
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="encabezado.jsp"/>
        <div id="main">
            <section>
                <div class="container">
                    <header>

                        <h2><font color="#0ac986">


                            AgenPerWeb <br/>
                            Hola,
                            <%
                                String nombre = (String) session.getAttribute("nombre");
                                out.print(nombre);
                            %>
                            </font></h2>
                    </header>

                    <p>AgenPerWeb es una agenda personal en linea con el objetivo de ayudarte a organizar todos tus compromisos diarios</p>
                    
                    <img src=".../Diseño/Dis1/images/agenda.jpg" /><br/><br/>
                    <p> Tranquilo(a) nosotros nos encargaremos de todo </p>
                </div>
            </section>

        </div>


        <div id="footer">
            <ul class="copyright">
                <li>&copy; Todos los derechos reservados 2016.</li>
            </ul>
        </div>



        <!-- Scripts -->
        <script src=".../Diseño/Dis2/js/jquery.min.js"></script>
        <script src=".../Diseño/Dis2/js/jquery.scrolly.min.js"></script>
        <script src=".../Diseño/Dis2/js/jquery.scrollzer.min.js"></script>
        <script src=".../Diseño/Dis2/js/skel.min.js"></script>
        <script src=".../Diseño/Dis2/js/util.js"></script>
        <script src=".../Diseño/Dis2/js/main.js"></script>

    </body>

</html>