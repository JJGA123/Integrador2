<%-- 
    Document   : modificar
    Created on : 20/10/2016, 11:18:54 PM
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
                        <h2><font color="#0ac986">Modificar compromiso</font></h2><br/>

                    </header>

                    <div class="container">
                        <div class="row" >

                            <div class="col-md-10" ></div>

                            <div class="col-md-10" ></div>

                            <div class="col-md-10" ></div>
                            <div class="col-md-10" ></div>
                            <div class="col-md-10" ></div>
                            <div class="col-md-8" >

                                <form class="login" name="formagregar" action="../auxiliarServlet" >


                                    <table border="0" >

                                        <tr>
                                            <td>
                                                <div style="text-align: left;">¿Tipo de compromiso a modificar? :&nbsp; &nbsp; &nbsp;&nbsp; </div>

                                            </td>
                                            <td>
                                               <div id="tipo0" name="tipo0">      

                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <br/><div style="text-align: left;">¿Cual es la ID del compromiso? :&nbsp; &nbsp; &nbsp;&nbsp; </div>
                                            </td>
                                            <td> 
                                                <br/>  <input class="form-control"  type="number" name="id" id="id" required autofocus>
                                            </td>
                                        </tr>


                                        <tr >
                                            <td> 
                                                <br/><div id="mensaje1" name="mensaje1" style="text-align: left;"></div>  
                                            </td>
                                            <td> 
                                                <br/><div id="mensaje2" name="mensaje2" ></div>
                                            </td>

                                        </tr>

                                    </table>



                                    <button class=" log-btn " type="submit" >Aceptar</button><br/><br/> 



                                </form> <br/>

                            </div>
                        </div>
                    </div>
                </div>

        </div>

    </section>

</div>





<div id="footer">
    <ul class="copyright">
        <li>&copy; Todos los derechos reservados 2016.</li>
    </ul>
</div>

<!-- Scripts -->


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src=".../Diseño/Dis1/js/ajax.js"></script>
<script src=".../Diseño/Dis2/js/jquery.min.js"></script>
<script src=".../Diseño/Dis2/js/jquery.scrolly.min.js"></script>
<script src=".../Diseño/Dis2/js/jquery.scrollzer.min.js"></script>
<script src=".../Diseño/Dis2/js/skel.min.js"></script>
<script src=".../Diseño/Dis2/js/util.js"></script>
<script src=".../Diseño/Dis2/js/main.js"></script>

<script src=".../Diseño/Dis1/js/ufps.js"></script>



<script type="text/javascript">
                        cargarComboCompromiso();
</script>
</body>

</html>


