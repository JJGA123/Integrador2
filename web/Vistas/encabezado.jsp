<%-- 
    Document   : encabezado
    Created on : 7/12/2016, 03:53:41 PM
    Author     : Cristian Ramirez
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

    <head>        
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Agenda Personal - AgenPerWeb</title>

        <link rel="stylesheet" href=".../Diseño/Dis1/css/login.css">
        <link rel="stylesheet" href=".../Diseño/Dis2/css/main.css" />
        <link rel="stylesheet" href=".../Diseño/Dis1/css/ufps.css">

    </head>

    <body>

        <div id="header">
            <div class="top">
                <div id="logo">
                    <span class="image avatar48"><img src=".../Diseño/Dis1/images/avatar1.jpg" alt="" /></span>
                    <h1 id="title" style="text-align: right;">
                        Bienvenido(a)

                        <p><a href="../SesionServlet?cerrarSesion=true">Cerrar sesión</a></p>
                    </h1>                  

                </div>

                <nav id="nav">
                    <ul>
                        <li><a href="menu.jsp" class="skel-layers-ignoreHref"><span class="icon fa-home">Inicio</span></a></li>
                        <li><a href="tipo_agregar.jsp" class="skel-layers-ignoreHref"><span class="icon fa-wrench">Nuevo tipo</span></a></li>
                        <li><a href="tipo_eliminar.jsp" class="skel-layers-ignoreHref"><span class="icon fa-wrench">Eliminar tipo</span></a></li>

                        <li><a href="consultar.jsp" class="skel-layers-ignoreHref"><span class="icon fa-user">Consultar</span></a></li>
                        <li><a href="agregar.jsp" class="skel-layers-ignoreHref"><span class="icon fa-th">Agregar</span></a></li>
                       
                        <li><a href="modificar.jsp" class="skel-layers-ignoreHref"><span class="icon fa-adn">Modificar</span></a></li>
                        <li><a href="eliminar.jsp" class="skel-layers-ignoreHref"><span class="icon fa-delicious">Eliminar</span></a></li>
                        <li><a href="alarma.jsp" class="skel-layers-ignoreHref"><span class="icon fa-warning">Alarmas</span></a></li>

                        <li><a href="estadistica.jsp" class="skel-layers-ignoreHref"><span class="icon fa-calendar">Estadisticas</span></a></li>
                    </ul>
                </nav>
            </div>
        </div>


