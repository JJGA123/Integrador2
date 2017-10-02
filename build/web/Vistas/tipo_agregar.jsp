<%-- 
    Document   : tipo
    Created on : 7/12/2016, 03:40:06 PM
    Author     : Cristian Ramirez
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="encabezado.jsp"/>

        <div id="main">
            <section>
                <div class="container">
                    <header>
                        <h2><font color="#0ac986">Agregar nuevo tipo</font></h2><br/>

                        <div id="mensaje" ></div>

                    </header>


                    <div class="row" >
                        <div class="col-md-10" ></div>
                        <div class="col-md-10" ></div>
                        <div class="col-md-8" >

                            <form class="login" name="formagregar" onSubmit="agregarTipoCompromisoQuery();
                                    return false" >


                                <table border="0">

                                    <tr>
                                        <td>
                                            <br/><div style="text-align: left;">¿Nombre del nuevo tipo de compromiso a guardar? :&nbsp; &nbsp; &nbsp;&nbsp; </div>

                                        </td>
                                        <td>
                                           <br/><input class="form-control" type="text" id="nombre" required autofocus>
                                        

                                        </td>
                                    </tr>



                                </table>


                                <button align="center" class="log-btn " type="submit" >Guardar</button><br/><br/> <br/><br/>

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

    </body>

</html>