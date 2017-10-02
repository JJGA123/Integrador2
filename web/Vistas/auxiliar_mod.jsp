<%-- 
    Document   : aa
    Created on : 30/11/2016, 04:02:24 AM
    Author     : Cristian Ramirez
--%>



<%@page import="DTO.Compromiso2"%>
<%@page import="javafx.scene.control.Alert"%>
<%@page import="DTO.Paseo"%>
<%@page import="DTO.Entrevista"%>
<%@page import="DTO.Tarea"%>
<%@page import="DTO.Cumpleaños"%>
<%@page import="DTO.Cita"%>
<%@page import="DTO.Actividad"%>
<%

    if (session.getAttribute("sesion") == null) {
        response.sendRedirect("../index.jsp");
    }

    String tipo = (String) session.getAttribute("modificarTipo");


%> 

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="encabezado.jsp"/>


<div id="main">
    <section>
        <div class="container">
            <header>
                <h2><font color="#0ac986">Modificar compromiso</font></h2><br/>

                <div id="mensaje" ></div>

            </header>


            <%     if (tipo.equalsIgnoreCase("error")) {
            %>
            <h3 id='mensajeAlerta'><font color='red'>" No se encontraron datos "</font></h3>");

            <%
            } else if (tipo.equalsIgnoreCase("actividad")) {

                Actividad obj = (Actividad) session.getAttribute("modificarAct");

            %>


            <div class="row" >
                <div class="col-md-10" ></div>
                <div class="col-md-10" ></div>
                <div class="col-md-8" >

                    <form class="login" name="formagregar" onSubmit="modificarCompromisoQuery();
                            return false" >


                        <table border="0">

                            <tr>
                                <td>
                                    <div style="text-align: left;">¿Tipo de compromiso? :</div>

                                </td>
                                <td>
                                    <input readonly="true" class="form-control"  type="text" id="tipo" value="<%=tipo%>" required autofocus>


                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <br/>   <div style="text-align: left;">¿ID del compromiso? :</div>

                                </td>
                                <td>
                                    <br/>   <input readonly="true" class="form-control"  type="text" id="id" value="<%=obj.getIdActividad()%>" required autofocus>


                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <br/><div style="text-align: left;">¿Cual es la fecha limite para realizar el compromiso? :&nbsp; &nbsp; &nbsp;&nbsp; </div>
                                </td>
                                <td> 
                                    <br/>  <input class="form-control"  type="date" id="fecha" value="<%=obj.getFecha()%>" required autofocus>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <br/><div style="text-align: left;">¿Cual es la hora del compromiso? :</div>
                                </td>
                                <td> 
                                    <br/>  <input class="form-control"  type="time"  name="hora"id="hora" value="<%=obj.getHora()%>"required autofocus>
                                </td>
                            </tr>
                            <tr>
                                <td> 
                                    <br/><div style="text-align: left;">¿Deseas colocar una observación? :</div>  
                                </td>
                                <td> 
                                    <br/>  <input class="form-control" type="text" id="observacion" value="<%=obj.getDescripcion()%>" required autofocus>
                                </td>

                            </tr>


                        </table>


                        <button align="center" class="log-btn " type="submit" >Guardar</button><br/><br/> 

                    </form> 

                </div>
            </div>

            <%
            } else if (tipo.equalsIgnoreCase("cita")) {
                Cita obj = (Cita) session.getAttribute("modificarCit");


            %>
            <div class="row" >
                <div class="col-md-10" ></div>
                <div class="col-md-10" ></div>
                <div class="col-md-8" >

                    <form class="login" name="formagregar" onSubmit="modificarCompromisoQuery();
                            return false" >


                        <table border="0">

                            <tr>
                                <td>
                                    <div style="text-align: left;">¿Tipo de compromiso? :</div>

                                </td>
                                <td>
                                    <input readonly="true" class="form-control"  type="text" id="tipo" value="<%=tipo%>" required autofocus>


                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <br/><div style="text-align: left;">¿ID del compromiso? :</div>

                                </td>
                                <td>
                                    <br/>  <input readonly="true" class="form-control"  type="text" id="id" value="<%=obj.getIdCita()%>" required autofocus>


                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <br/><div style="text-align: left;">¿Cual es la fecha limite para realizar el compromiso? :&nbsp; &nbsp; &nbsp;&nbsp; </div>
                                </td>
                                <td> 
                                    <br/>  <input class="form-control"  type="date" id="fecha" value="<%=obj.getFecha()%>" required autofocus>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <br/><div style="text-align: left;">¿Cual es la hora del compromiso? :</div>
                                </td>
                                <td> 
                                    <br/>  <input class="form-control"  type="time"  name="hora"id="hora" value="<%= obj.getHora()%>" required autofocus>
                                </td>
                            </tr>
                            <tr>
                                <td> 
                                    <br/><div style="text-align: left;">¿Deseas colocar una observación? :</div>  
                                </td>
                                <td> 
                                    <br/>  <input class="form-control" type="text" id="observacion" value="<%=obj.getDescripcion()%>" required autofocus>
                                </td>

                            </tr>


                        </table>


                        <button align="center" class="log-btn " type="submit" >Guardar</button><br/><br/> 

                    </form> 

                </div>
            </div>


            <%
            } else if (tipo.equalsIgnoreCase("cumpleanos")) {
                Cumpleaños obj = (Cumpleaños) session.getAttribute("modificarCum");
            %>



            <div class="row" >
                <div class="col-md-10" ></div>
                <div class="col-md-10" ></div>
                <div class="col-md-8" >

                    <form class="login" name="formagregar" onSubmit="modificarCompromisoQuery();
                            return false" >


                        <table border="0">

                            <tr>
                                <td>
                                    <div style="text-align: left;">¿Tipo de compromiso? :</div>

                                </td>
                                <td>
                                    <input readonly="true" class="form-control"  type="text" id="tipo" value="<%=tipo%>" required autofocus>


                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <br/>  <div style="text-align: left;">¿ID del compromiso? :</div>

                                </td>
                                <td>
                                    <br/>  <input readonly="true" class="form-control"  type="text" id="id" value="<%=obj.getIdCumpleaños()%>" required autofocus>


                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <br/><div style="text-align: left;">¿Cual es la fecha limite para realizar el compromiso? :&nbsp; &nbsp; &nbsp;&nbsp; </div>
                                </td>
                                <td> 
                                    <br/>  <input class="form-control"  type="date" id="fecha" value="<%=obj.getFecha()%>" required autofocus>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <br/><div style="text-align: left;">¿Cual es la hora del compromiso? :</div>
                                </td>
                                <td> 
                                    <br/>  <input class="form-control"  type="time"  name="hora"id="hora" value="<%=obj.getHora()%>"required autofocus>
                                </td>
                            </tr>
                            <tr>
                                <td> 
                                    <br/><div style="text-align: left;">¿Deseas colocar una observación? :</div>  
                                </td>
                                <td> 
                                    <br/>  <input class="form-control" type="text" id="observacion" value="<%=obj.getDescripcion()%>" required autofocus>
                                </td>

                            </tr>


                        </table>


                        <button align="center" class="log-btn " type="submit" >Guardar</button><br/><br/> 

                    </form> 

                </div>
            </div>



            <%
            } else if (tipo.equalsIgnoreCase("tarea")) {

                Tarea obj = (Tarea) session.getAttribute("modificarTar");

            %>


            <div class="row" >
                <div class="col-md-10" ></div>
                <div class="col-md-10" ></div>
                <div class="col-md-8" >

                    <form class="login" name="formagregar" onSubmit="modificarCompromisoQuery();
                            return false" >


                        <table border="0">

                            <tr>
                                <td>
                                    <div style="text-align: left;">¿Tipo de compromiso? :</div>

                                </td>
                                <td>
                                    <input readonly="true" class="form-control"  type="text" id="tipo" value="<%=tipo%>" required autofocus>


                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <br/>  <div style="text-align: left;">¿ID del compromiso? :</div>

                                </td>
                                <td>
                                    <br/>  <input readonly="true" class="form-control"  type="text" id="id" value="<%=obj.getIdTarea()%>" required autofocus>


                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <br/><div style="text-align: left;">¿Cual es la fecha limite para realizar el compromiso? :&nbsp; &nbsp; &nbsp;&nbsp; </div>
                                </td>
                                <td> 
                                    <br/>  <input class="form-control"  type="date" id="fecha" value="<%=obj.getFecha()%>" required autofocus>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <br/><div style="text-align: left;">¿Cual es la hora del compromiso? :</div>
                                </td>
                                <td> 
                                    <br/>  <input class="form-control"  type="time"  name="hora"id="hora" value="<%=obj.getHora()%>"required autofocus>
                                </td>
                            </tr>
                            <tr>
                                <td> 
                                    <br/><div style="text-align: left;">¿Deseas colocar una observación? :</div>  
                                </td>
                                <td> 
                                    <br/>  <input class="form-control" type="text" id="observacion" value="<%=obj.getDescripcion()%>" required autofocus>
                                </td>

                            </tr>


                            <tr>
                                <td> 
                                    <br/><div style="text-align: left;">¿A que actividad pertenece? :</div>  
                                </td>
                                <td> 
                                    <br/>  <input readonly="true" class="form-control" type="text" id="actividad" value="<%=obj.getIdAct()%>" required autofocus>
                                </td>

                            </tr>

                        </table>


                        <button align="center" class="log-btn " type="submit" >Guardar</button><br/><br/> 

                    </form> 

                </div>
            </div>




            <%
            } else if (tipo.equalsIgnoreCase("entrevista")) {

                Entrevista obj = (Entrevista) session.getAttribute("modificarEnt");
            %>


            <div class="row" >
                <div class="col-md-10" ></div>
                <div class="col-md-10" ></div>
                <div class="col-md-8" >

                    <form class="login" name="formagregar" onSubmit="modificarCompromisoQuery();
                            return false" >


                        <table border="0">

                            <tr>
                                <td>
                                    <div style="text-align: left;">¿Tipo de compromiso? :</div>

                                </td>
                                <td>
                                    <input readonly="true" class="form-control"  type="text" id="tipo" value="<%=tipo%>" required autofocus>


                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <br/> <div style="text-align: left;">¿ID del compromiso? :</div>

                                </td>
                                <td>
                                    <br/>  <input readonly="true" class="form-control"  type="text" id="id" value="<%=obj.getIdEntrevista()%>" required autofocus>


                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <br/><div style="text-align: left;">¿Cual es la fecha limite para realizar el compromiso? :&nbsp; &nbsp; &nbsp;&nbsp; </div>
                                </td>
                                <td> 
                                    <br/>  <input class="form-control"  type="date" id="fecha" value="<%=obj.getFecha()%>" required autofocus>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <br/><div style="text-align: left;">¿Cual es la hora del compromiso? :</div>
                                </td>
                                <td> 
                                    <br/>  <input class="form-control"  type="time"  name="hora"id="hora" value="<%=obj.getHora()%>" required autofocus>
                                </td>
                            </tr>
                            <tr>
                                <td> 
                                    <br/><div style="text-align: left;">¿Deseas colocar una observación? :</div>  
                                </td>
                                <td> 
                                    <br/>  <input class="form-control" type="text" id="observacion" value="<%=obj.getDescripcion()%>" required autofocus>
                                </td>

                            </tr>


                        </table>


                        <button align="center" class="log-btn " type="submit" >Guardar</button><br/><br/> 

                    </form> 

                </div>
            </div>




            <%
            } else if (tipo.equalsIgnoreCase("paseo")) {
                Paseo obj = (Paseo) session.getAttribute("modificarPas");

            %>



            <div class="row" >
                <div class="col-md-10" ></div>
                <div class="col-md-10" ></div>
                <div class="col-md-8" >

                    <form class="login" name="formagregar" onSubmit="modificarCompromisoQuery();
                            return false" >


                        <table border="0">

                            <tr>
                                <td>
                                    <div style="text-align: left;">¿Tipo de compromiso? :</div>

                                </td>
                                <td>
                                    <input readonly="true" class="form-control"  type="text" id="tipo" value="<%=tipo%>" required autofocus>


                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <br/>   <div style="text-align: left;">¿ID del compromiso? :</div>

                                </td>
                                <td>
                                    <br/>  <input readonly="true" class="form-control"  type="text" id="id" value="<%=obj.getIdPaseo()%>" required autofocus>


                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <br/><div style="text-align: left;">¿Cual es la fecha limite para realizar el compromiso? :&nbsp; &nbsp; &nbsp;&nbsp; </div>
                                </td>
                                <td> 
                                    <br/>  <input class="form-control"  type="date" id="fecha" value="<%=obj.getFecha()%>" required autofocus>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <br/><div style="text-align: left;">¿Cual es la hora del compromiso? :</div>
                                </td>
                                <td> 
                                    <br/>  <input class="form-control"  type="time"  name="hora"id="hora" value="<%=obj.getHora()%>"required autofocus>
                                </td>
                            </tr>
                            <tr>
                                <td> 
                                    <br/><div style="text-align: left;">¿Deseas colocar una observación? :</div>  
                                </td>
                                <td> 
                                    <br/>  <input class="form-control" type="text" id="observacion" value="<%=obj.getDescripcion()%>" required autofocus>
                                </td>

                            </tr>


                        </table>


                        <button align="center" class="log-btn " type="submit" >Guardar</button><br/><br/> 

                    </form> 

                </div>
            </div>




            <%                      } else {
                Compromiso2 obj = (Compromiso2) session.getAttribute("modificarOtro");


            %>


            <div class="row" >
                <div class="col-md-10" ></div>
                <div class="col-md-10" ></div>
                <div class="col-md-8" >

                    <form class="login" name="formagregar" onSubmit="modificarCompromisoQuery();
                            return false" >


                        <table border="0">

                            <tr>
                                <td>
                                    <div style="text-align: left;">¿Tipo de compromiso? :</div>

                                </td>
                                <td>
                                    <input readonly="true" class="form-control"  type="text" id="tipo" value="<%=tipo%>" required autofocus>


                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <br/>   <div style="text-align: left;">¿ID del compromiso? :</div>

                                </td>
                                <td>
                                    <br/>  <input readonly="true" class="form-control"  type="text" id="id" value="<%=obj.getIdCompromiso2()%>" required autofocus>


                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <br/><div style="text-align: left;">¿Cual es la fecha limite para realizar el compromiso? :&nbsp; &nbsp; &nbsp;&nbsp; </div>
                                </td>
                                <td> 
                                    <br/>  <input class="form-control"  type="date" id="fecha" value="<%=obj.getFecha()%>" required autofocus>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <br/><div style="text-align: left;">¿Cual es la hora del compromiso? :</div>
                                </td>
                                <td> 
                                    <br/>  <input class="form-control"  type="time"  name="hora"id="hora" value="<%=obj.getHora()%>"required autofocus>
                                </td>
                            </tr>
                            <tr>
                                <td> 
                                    <br/><div style="text-align: left;">¿Deseas colocar una observación? :</div>  
                                </td>
                                <td> 
                                    <br/>  <input class="form-control" type="text" id="observacion" value="<%=obj.getDescripcion()%>" required autofocus>
                                </td>

                            </tr>


                        </table>


                        <button align="center" class="log-btn " type="submit" >Guardar</button><br/><br/> 

                    </form> 

                </div>
            </div>


            <%}
            %>


        </div>

    </section>

</div>


<%
%>


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

</body>

</html>
