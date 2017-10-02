<%-- 
    Document   : index
    Created on : 18/08/2016, 08:02:23 PM
    Author     : Cristian Ramirez
--%>

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
        <link rel="stylesheet" href="Diseño/Dis1/css/animate.css">
        <link rel="stylesheet" href="Diseño/Dis1/css/icomoon.css">
        <link rel="stylesheet" href="Diseño/Dis1/css/bootstrap.css">
        <link rel="stylesheet" href="Diseño/Dis1/css/flexslider.css">
        <link rel="stylesheet" href="Diseño/Dis1/css/owl.carousel.min.css">
        <link rel="stylesheet" href="Diseño/Dis1/css/owl.theme.default.min.css">
        <link rel="stylesheet" href="Diseño/Dis1/css/style.css">

    </head>

    <body>

        <div id="fh5co-page">

            <header id="fh5co-header" role="banner">
                <div class="container">
                    <div class="header-inner">
                        <h1><a href="index.jsp">AgenPerWeb</a></h1>
                        <nav role="navigation">
                            <ul>                              
                                <li class="cta"><a href="Vistas/iniciarsesion.jsp">Iniciar sesión</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </header>


            <aside id="fh5co-hero" class="js-fullheight">
                <div class="flexslider js-fullheight">
                    <ul class="slides">
                        <li style="background-image: url(Diseño/Dis1/images/slide_1.jpg);">
                            <div class="overlay-gradient"></div>
                            <div class="container">
                                <div class="col-md-10 col-md-offset-1 text-center js-fullheight slider-text">
                                    <div class="slider-text-inner">
                                        <h2>Te ayudaremos a organizar todos tus compromisos diarios</h2>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li style="background-image: url(Diseño/Dis1/images/slide_2.jpg);">
                            <div class="container">
                                <div class="col-md-10 col-md-offset-1 text-center js-fullheight slider-text">
                                    <div class="slider-text-inner">
                                        <h2>AgenPerWeb es una agenda personal en linea </h2>
                                        <p><a href="Vistas/iniciarsesion.jsp" class="btn btn-primary btn-lg">¿Deseas iniciar sesion?</a></p>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li style="background-image: url(Diseño/Dis1/images/slide_3.jpg);">
                            <div class="container">
                                <div class="col-md-10 col-md-offset-1 text-center js-fullheight slider-text">
                                    <div class="slider-text-inner">
                                        <h2>Ofrecemos tecnologia, seguridad y mucho mas...</h2>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </aside>

            <div id="fh5co-services-section">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 col-md-offset-3 text-center fh5co-heading animate-box">
                            <h2>Nuestras caracteristicas</h2>
                            <p> Somos un proyecto enfocado a organizar todos tus compromisos diarios.</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4 animate-box">
                            <div class="services">
                                <i class="icon-laptop"></i>
                                <div class="desc">
                                    <h3>Seguridad</h3>
                                    <p>Nuestra aplicacion cuenta con un logeo de HttpSession para proteger el acceso.</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 animate-box">
                            <div class="services">
                                <i class="icon-server"></i>
                                <div class="desc">
                                    <h3>Confiabilidad</h3>
                                    <p>Su informacion estara totalmente segura en nuestros servidores MySQL.</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 animate-box">
                            <div class="services">
                                <i class="icon-tablet"></i>
                                <div class="desc">
                                    <h3>Adaptabilidad</h3>
                                    <p>Nuestro diseño es responsivo, por lo tanto puedes acceder en cualquier dispositivo.</p>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

            <div id="fh5co-testimony-section">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 col-md-offset-3 text-center fh5co-heading animate-box">
                            <h2>¿Quienes somos?</h2>
                            <p>Este proyecto es desarrollado por estudiantes de ingenieria de sistemas de la UFPS. </p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 col-offset-0 to-animate">
                            <div class="wrap-testimony animate-box">
                                <div class="owl-carousel-fullwidth">
                                    <div class="item">
                                        <div class="testimony-slide active text-center">
                                            <figure>
                                                <img src="Diseño/Dis1/images/perfil1.jpg" alt="user">
                                            </figure>
                                            <blockquote>
                                                <p>Cristian Ramirez</p>
                                            </blockquote>
                                            <span>Estudiante de 7° semestre de Ing. Sistemas </span>
                                        </div>
                                    </div>

                                    <div class="item">
                                        <div class="testimony-slide active text-center">
                                            <figure>
                                                <img src="Diseño/Dis1/images/perfil2.jpg" alt="user">
                                            </figure>
                                            <blockquote>
                                                <p>Jhon Galvis</p>
                                            </blockquote>
                                            <span>Estudiante de 6° semestre de Ing. Sistemas</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>

            <div class="fh5co-cta" style="background-image: url(Diseño/Dis1/images/slide_2.jpg);">
                <div class="overlay"></div>
                <div class="container">
                    <div class="col-md-12 text-center animate-box">
                        <h3>Inicia sesion para poder entrar a la aplicación.</h3>
                        <p><a href="Vistas/iniciarsesion.jsp" class="btn btn-primary btn-outline with-arrow">Aqui! <i class="icon-arrow-right"></i></a></p>
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
        <script src="Diseño/Dis1/js/modernizr-2.6.2.min.js"></script>

        <script src="Diseño/Dis1/js/jquery.min.js"></script>
        <script src="Diseño/Dis1/js/jquery.easing.1.3.js"></script>
        <script src="Diseño/Dis1/js/bootstrap.min.js"></script>
        <script src="Diseño/Dis1/js/jquery.waypoints.min.js"></script>
        <script src="Diseño/Dis1/js/owl.carousel.min.js"></script>
        <script src="Diseño/Dis1/js/jquery.flexslider-min.js"></script>
        <script src="Diseño/Dis1/js/main.js"></script>

    </body>

</html>



