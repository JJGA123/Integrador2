<%-- 
    Document   : agregar
    Created on : 20/10/2016, 11:18:45 PM
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
                <h2><font color="#0ac986">Agregar compromiso</font></h2><br/>

                <div id="mensaje" ></div>

            </header>


            <div class="row" >
                <div class="col-md-10" ></div>
                <div class="col-md-10" ></div>
                <div class="col-md-8" >

                    <form class="login" name="formagregar" onSubmit="agregarCompromisoQuery();
                            return false" >


                        <table border="0">

                            <tr>
                                <td>
                                    <div style="text-align: left;">¿Que tipo de compromiso desear guardar? :</div>

                                </td>
                                <td>

                                    <div id="tipo0" name="tipo0">                                    

                                    </div>
                                </td>
                            </tr>


                            <tr>
                                <td>
                                    <br/><div style="text-align: left;">¿Cual es la fecha limite para realizar el compromiso? :&nbsp; &nbsp; &nbsp;&nbsp; </div>
                                </td>
                                <td> 
                                    <br/>  <input class="form-control"  type="date" id="fecha" required autofocus>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <br/><div style="text-align: left;">¿Cual es la hora del compromiso? :</div>
                                </td>
                                <td> 
                                    <br/>  <input class="form-control"  type="time"  name="hora"id="hora" required autofocus>
                                </td>
                            </tr>
                            <tr>
                                <td> 
                                    <br/><div style="text-align: left;">¿Deseas colocar una observación? :</div>  
                                </td>
                                <td> 
                                    <br/>  <input class="form-control" type="text" id="observacion" required autofocus>
                                </td>

                            </tr>


                            <tr >
                                <td> 
                                    <br/><div id="mensaje1" style="text-align: left;"></div>  
                                </td>
                                <td> 
                                    <br/><div id="mensaje2"></div>
                                </td>

                            </tr>

                        </table>


                        <button align="center" class="log-btn " type="submit" >Guardar</button><br/><br/> 

                    </form> 

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


<script type="text/javascript">
                        cargarComboCompromiso();
</script>
</body>

</html>