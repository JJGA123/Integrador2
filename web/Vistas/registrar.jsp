<%-- 
    Document   : Registrar
    Created on : 8/10/2016, 07:01:23 AM
    Author     : Cristian Ramirez
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html class="no-js"> 

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Agenda Personal - AgenPerWeb</title>
        <link rel="shortcut icon" href="Diseño/Dis1/favicon.ico">
        <link href="https://fonts.googleapis.com/css?family=Raleway:200,300,400,700" rel="stylesheet">
        <link rel="stylesheet" href=".../Diseño/Dis1/css/animate.css">
        <link rel="stylesheet" href=".../Diseño/Dis1/css/icomoon.css">
        <link rel="stylesheet" href=".../Diseño/Dis1/css/bootstrap.css">
        <link rel="stylesheet" href=".../Diseño/Dis1/css/flexslider.css">
        <link rel="stylesheet" href=".../Diseño/Dis1/css/owl.carousel.min.css">
        <link rel="stylesheet" href=".../Diseño/Dis1/css/owl.theme.default.min.css">
        <link rel="stylesheet" href=".../Diseño/Dis1/css/style.css">
        <link rel="stylesheet" href=".../Diseño/Dis1/css/login.css">
        <script src=".../Diseño/Dis1/js/modernizr-2.6.2.min.js"></script>


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src=".../Diseño/Dis1/js/ajax.js"></script>

    </head>

    <body>

        <div id="fh5co-page">
            <header id="fh5co-header" role="banner">
                <div class="container">
                    <div class="header-inner">
                        <h1><a href="index.jsp">AgenPerWeb</a></h1>
                        <nav role="navigation">
                            <ul>                              
                                <li class="cta"><a href="iniciarsesion.jsp">Iniciar sesión</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </header>
            <br/>            


            <div id="fh5co-testimony-section">
                <div class="container">

                    <div class="row">
                        <div class="col-md-12 col-offset-0 to-animate">
                            <div class="wrap-testimony animate-box">
                                <div class="item">
                                    <div class="testimony-slide active text-center">

                                        <blockquote>


                                            <h1>Crea tu cuenta de AgenPerWeb</h1>
                                            <p>Por favor llene a continuacion todos los datos.</p>


                                            <h3 id="mensaje" style="text-align: center;"></h3>

                                            <form class="login" name="formregistrar"  onSubmit="registrarUsuarioQuery();
                                                    return false" >


                                                <div class="form-group ">
                                                    <input type="text" class="form-control" placeholder="Nombres" id="nombre" required autofocus>
                                                </div>

                                                <div class="form-group ">
                                                    <input type="email" class="form-control" placeholder="Correo" id="correo"  required autofocus>
                                                </div>
                                                <div class="form-group">
                                                    <input  type="password" class="form-control" placeholder="Contraseña" id="clave"  minlength="5"  required autofocus >
                                                </div>

                                                <button type="submit" class="log-btn">Aceptar</button><br/><br/>         

                                            </form>




                                        </blockquote>

                                    </div>
                                </div>


                            </div>
                        </div>
                    </div>

                </div>
            </div>



            <footer id="fh5co-footer" role="contentinfo">

                <div class=" fh5co-copyright text-center">
                    <p>&copy; Todos los derechos reservados 2016</p>	
                </div>
            </footer>

        </div>


        <!-- jQuery -->

        <script class="cssdeck" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
        <script src=".../Diseño/Dis1/js/jquery.min.js"></script>
        <script src=".../Diseño/Dis1/js/jquery.easing.1.3.js"></script>
        <script src=".../Diseño/Dis1/js/bootstrap.min.js"></script>
        <script src=".../Diseño/Dis1/js/jquery.waypoints.min.js"></script>
        <script src=".../Diseño/Dis1/js/owl.carousel.min.js"></script>
        <script src=".../Diseño/Dis1/js/jquery.flexslider-min.js"></script>
        <script src=".../Diseño/Dis1/js/main.js"></script>

    </body>

</html>


