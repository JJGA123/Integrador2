/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function iniciarSesionQuery() {

    corr = $("#cor").val();
    clav = $("#cla").val();

    $.ajax({
        url: '/AgenPerWeb/SesionServlet',
        type: 'POST',
        data: {iniciarSesion: "true", correo: corr, clave: clav}
    }).done(function (sub) {

        if ((sub.indexOf('exito') >= 0)) {
            window.location = 'menu.jsp';
        } else {
            $("h3").remove("#mensajeAlerta");
            $('#mensaje').append("<h3 id='mensajeAlerta'><font color='red'>" + sub + "</font></h3>");

        }
    });
}


function registrarUsuarioQuery() {

    nomb = $("#nombre").val();
    corr = $("#correo").val();
    clav = $("#clave").val();

    $.ajax({
        url: '/AgenPerWeb/UsuarioServlet',
        type: 'POST',
        data: {registrarUsuario: "true", nombre: nomb, correo: corr, clave: clav}
    }).done(function (sub) {


        if ((sub.indexOf('exito') >= 0)) {
            $("h3").remove("#mensajeAlerta");
            $('#mensaje').append("<h3 id='mensajeAlerta'><font color='#0ac986'>" + 'Registo exitoso, iniciando sesion...' + "</font></h3>");

            setTimeout(function () {
                window.location = 'menu.jsp'
            }, 1500);
        } else {
            $("h3").remove("#mensajeAlerta");
            $('#mensaje').append("<h3 id='mensajeAlerta'><font color='red'>" + sub + "</font></h3>");

        }
    });
}



function agregarCompromisoQuery() {

    tipo = $("#tipo").val();
    fecha = $("#fecha").val();
    hora = $("#hora").val();
    obser = $("#observacion").val();
    activi = $("#msj2").val();
    $.ajax({
        url: '/AgenPerWeb/CompromisoServlet',
        type: 'POST',
        data: {agregarCompromiso: "true", tipo: tipo, fecha: fecha, hora: hora, observacion: obser, activi: activi}
    }).done(function (sub) {

        if ((sub.indexOf('exito') >= 0)) {

            $("h3").remove("#mensajeAlerta");
            $('#mensaje').append("<h3 id='mensajeAlerta'><font color='#0ac986'>" + 'Compromiso registrado' + "</font></h3>");


            setTimeout(function () {
                document.formagregar.reset();
                $("h3").remove("#mensajeAlerta");
            }, 2000);


        } else {
            $("h3").remove("#mensajeAlerta");
            $('#mensaje').append("<h3 id='mensajeAlerta'><font color='red'>" + sub + "</font></h3>");


            setTimeout(function () {
                $("h3").remove("#mensajeAlerta");
            }, 3000);
        }


    });
}

function validarAgreTipoQuery() {


    tipo = $("#tipo").val();


    if (tipo == 'Tarea') {

        $("div").remove("#mensajeinfo1");
        $("select").remove("#msj2");

        $('#mensaje1').append("<div id='mensajeinfo1'>" + "¿A que actividad pertenece?" + "</div>");

        $.ajax({
            url: '/AgenPerWeb/CompromisoServlet',
            type: 'POST',
            data: {cargarActividad: 'true'},
            datType: 'JSON'
        }).done(function (sub) {

            $('#mensaje2').append("<select class='form-control'  name='msj2' id='msj2' required autofocus>" + "¿A que actividad se la quiere asignar?" +
                    "<option> </option> " +
                    " </select>");
            for (i = 0; i < sub.length; i++) {

                $('#msj2').append("<option id='" + sub[i]['idActividad'] + "' value='" + sub[i]['idActividad'] + "'>" + sub[i]['idActividad'] + "</option>");


            }



        });
    } else {
        $("div").remove("#mensajeinfo1");
        $("select").remove("#msj2");
    }
}

function consultarCompromisoQuery() {

    tipo = $("#tipo").val();
    activi = $("#msj2").val();
    fecha1 = $("#fecha1").val();
    fecha2 = $("#fecha2").val();

    $("#tabla2").remove();
    $("#info1").remove();
    $("#fallo1").remove();
    if (tipo == 'actividad') {
        $('#info').append("<h5 id='info1'><font color='#0ac986'>" + "Actividades" + "</font></h5>");
    } else if (tipo == 'cita') {
        $('#info').append("<div id='info1'><font color='#0ac986'>" + "Citas" + "</font></div>");
    } else if (tipo == 'cumpleaños') {
        $('#info').append("<div id='info1'><font color='#0ac986'>" + "Cumpleaños" + "</font></div>");
    } else if (tipo == 'tarea') {
        $('#info').append("<div id='info1'><font color='#0ac986'>" + "Tareas" + "</font></div>");
    }


    $.ajax({
        url: '/AgenPerWeb/CompromisoServlet',
        type: 'POST',
        data: {consultarCompromiso: "true", tipo: tipo, actividad: activi, fecha1: fecha1, fecha2: fecha2},
        dataType: 'JSON'
    }).done(function (sub) {


        if ((sub[0] == undefined)) {

            $("div").remove("#fallo1");
            $('#fallo').append("<div id='fallo1'><font color='red'>" + 'No se encuentraron datos' + "</font></h3>");

        } else if (sub[0]['ErrorFalta'] == "ErrorFalta") {

            $('#fallo').append("<div id='fallo1'><font color='red'>" + 'Faltan fechas por seleccionar' + "</font></h3>");

        } else {

            $('#tablaconsultar').append("<table id='tabla2' > <tr ><th> <font color='#0ac986'>"
                    + 'Id' + "</font></th><th> <font color='#0ac986'>"
                    + 'Descripción' + "</font></th><th><font color='#0ac986'>"
                    + 'Fecha' + "</font></th><th><font color='#0ac986'>"
                    + 'Hora' + "</th></font></tr>"
                    + " </table>");

            for (i = 0; i < sub.length; i++) {
                $('#tabla2').append("<tr ><td>"
                        + sub[i]['Id'] + "</td><td>"
                        + sub[i]['Descripcion'] + "</td><td>"
                        + sub[i]['Fecha'] + "</td><td>"
                        + sub[i]['Hora'] + "</td></tr>");

            }
        }

    });
}



function validarConTipoQuery() {


    tipo = $("#tipo").val();


    if (tipo == 'tarea') {

        $("div").remove("#mensajeinfo1");
        $("select").remove("#msj2");
        $('#mensaje1').append("<div id='mensajeinfo1'>" + "¿A que actividad pertenece?:" + "</div>");


        $.ajax({
            url: '/AgenPerWeb/CompromisoServlet',
            type: 'POST',
            data: {cargarActividad: 'true'},
            datType: 'JSON'
        }).done(function (sub) {

            $('#mensaje2').append("<select class='form-control' id='msj2' required autofocus>" + "¿A que actividad se la quiere asignar?" +
                    "<option> </option> " +
                    " </select>");
            for (i = 0; i < sub.length; i++) {

                $('#msj2').append("<option id='" + sub[i]['idActividad'] + "' value='" + sub[i]['idActividad'] + "'>" + sub[i]['idActividad'] + "</option>");


            }

        });


    } else {
        $("div").remove("#mensajeinfo1");
        $("select").remove("#msj2");
    }
}


function EliminarCompromisoQuery() {


    tipo = $("#tipo").val();
    id = $("#id").val();
    activi = $("#msj2").val();

    $.ajax({
        url: '/AgenPerWeb/CompromisoServlet',
        type: 'POST',
        data: {eliminarCompromiso: "true", tipo: tipo, id: id, activi: activi}
    }).done(function (sub) {

        if ((sub.indexOf('exito') >= 0)) {

            $("div").remove("#mensajeAlerta");
            $('#mensaje').append("<br/><div id='mensajeAlerta'><font color='#0ac986'>" + 'Compromiso eliminado' + "</font></div><br/>");



            setTimeout(function () {
                window.location = 'eliminar.jsp'
            }, 2000);


        } else {
            $("div").remove("#mensajeAlerta");
            $('#mensaje').append("<br/><div id='mensajeAlerta'><font color='red'>" + sub + "</font></div><br/>");


            setTimeout(function () {
                $("h3").remove("#mensajeAlerta");
            }, 3000);
        }


    });
}

function EliminarTipoCompromisoQuery(){
    

    tipo = $("#tipo").val();
 

    $.ajax({
        url: '/AgenPerWeb/CompromisoServlet',
        type: 'POST',
        data: {eliminarTipoCompromiso: "true", tipo: tipo}
    }).done(function (sub) {

        if ((sub.indexOf('exito') >= 0)) {

            $("div").remove("#mensajeAlerta");
            $('#mensaje').append("<br/><div id='mensajeAlerta'><font color='#0ac986'>" + 'Tipo de compromiso eliminado' + "</font></div><br/>");



            setTimeout(function () {
                window.location = 'tipo_eliminar.jsp'
            }, 2000);


        } else {
            $("div").remove("#mensajeAlerta");
            $('#mensaje').append("<br/><div id='mensajeAlerta'><font color='red'>" + sub + "</font></div><br/>");


            setTimeout(function () {
                $("h3").remove("#mensajeAlerta");
            }, 3000);
        }


    });
}

function modificarCompromisoQuery() {


    tipo = $("#tipo").val();
    id = $("#id").val();
    fecha = $("#fecha").val();
    hora = $("#hora").val();
    obser = $("#observacion").val();
    actividad = $("#actividad").val();

    $.ajax({
        url: '/AgenPerWeb/CompromisoServlet',
        type: 'POST',
        data: {modificarCompromiso: "true", tipo: tipo, id: id, fecha: fecha, hora: hora, observacion: obser, actividad: actividad}
    }).done(function (sub) {

        if ((sub.indexOf('exito') >= 0)) {

            $("h3").remove("#mensajeAlerta");
            $('#mensaje').append("<h3 id='mensajeAlerta'><font color='#0ac986'>" + 'Compromiso modificado' + "</font></h3>");


            setTimeout(function () {
                window.location = 'modificar.jsp'
            }, 2000);


        } else {
            $("h3").remove("#mensajeAlerta");
            $('#mensaje').append("<h3 id='mensajeAlerta'><font color='red'>" + sub + "</font></h3>");


            setTimeout(function () {
                $("h3").remove("#mensajeAlerta");
            }, 3000);
        }


    });

}

function agregarTipoCompromisoQuery() {
    nombre = $("#nombre").val();

    $.ajax({
        url: '/AgenPerWeb/CompromisoServlet',
        type: 'POST',
        data: {agregarTipoCompromiso: "true", nombre: nombre}
    }).done(function (sub) {

        if ((sub.indexOf('exito') >= 0)) {

            $("h3").remove("#mensajeAlerta");
            $('#mensaje').append("<h3 id='mensajeAlerta'><font color='#0ac986'>" + 'Tipo de compromiso registrado' + "</font></h3>");


            setTimeout(function () {
                document.formagregar.reset();
                $("h3").remove("#mensajeAlerta");
            }, 2000);


        } else {
            $("h3").remove("#mensajeAlerta");
            $('#mensaje').append("<h3 id='mensajeAlerta'><font color='red'>" + sub + "</font></h3>");


            setTimeout(function () {
                $("h3").remove("#mensajeAlerta");
            }, 3000);
        }


    });
}
function consultarAlarmaQuery() {
    tipo = $("#tipo").val();
    activi = $("#msj2").val();

    $("#tabla2").remove();
    $("#info1").remove();
    $("#fallo1").remove();

    $.ajax({
        url: '/AgenPerWeb/CompromisoServlet',
        type: 'POST',
        data: {consultarAlarmaCompromiso: "true", tipo: tipo, activi: activi},
        dataType: 'JSON'
    }).done(function (sub) {



        if ((sub[0] == undefined)) {

            $("div").remove("#fallo1");
            $('#fallo').append("<div id='fallo1'><font color='red'>" + 'No se encuentraron datos' + "</font></h3>");

        } else {

            $('#tablaconsultar').append("<table id='tabla2' > <tr ><th> <font color='#0ac986'>"
                    + 'Id ' + "</font></th><th> <font color='#0ac986'>"
                    + 'Descripcion ' + "</font></th><th> <font color='#0ac986'>"

                    + 'Alarma ' + "</th></font></tr>"
                    + " </table>");

            for (i = 0; i < sub.length; i++) {
                $('#tabla2').append("<tr ><td>"
                        + sub[i]['Id'] + "</td><td>"
                        + sub[i]['Descripcion'] + "</td><td>"
                        + sub[i]['Alarma'] + "</td></tr>");

            }
        }


    });
}


function consultarEstadisticaQuery() {
    tipo = $("#tipo").val();
    operacion = $("#operacion").val();
    activi = $("#msj2").val();

    $("#tabla2").remove();
    $("#info1").remove();
    $("#fallo1").remove();

    $.ajax({
        url: '/AgenPerWeb/CompromisoServlet',
        type: 'POST',
        data: {consultarEstadisticaCompromiso: "true", tipo: tipo, operacion: operacion, activi: activi},
        dataType: 'JSON'
    }).done(function (sub) {



        if ((sub[0] == undefined)) {

            $("div").remove("#fallo1");
            $('#fallo').append("<div id='fallo1'><font color='red'>" + 'No se encuentraron datos' + "</font></h3>");

        } else {




            $('#tablaconsultar').append("<table id='tabla2' > <tr ><th> <font color='#0ac986'>"
                    + 'Id' + "</font></th><th> <font color='#0ac986'>"

                    + 'Descripción' + "</font></th><th><font color='#0ac986'>"
                    + 'Fecha' + "</font></th><th><font color='#0ac986'>"
                    + 'Fecha sistema' + "</font></th><th><font color='#0ac986'>"
                    + 'Hora' + "</font></th><th><font color='#0ac986'>"
                    + 'Hora sistema' + "</th></font></tr>"
                    + " </table>");

            for (i = 0; i < sub.length; i++) {
                $('#tabla2').append("<tr ><td>"
                        + sub[i]['Id'] + "</td><td>"

                        + sub[i]['Descripcion'] + "</td><td>"
                        + sub[i]['Fecha'] + "</td><td>"
                        + sub[i]['FechaSistema'] + "</td><td>"
                        + sub[i]['Hora'] + "</td><td>"
                        + sub[i]['HoraSistema'] + "</td></tr>");

            }
        }


    });
}



function cargarComboCompromiso() {

    $('#tipo0').append("<select onchange='validarAgreTipoQuery()' class='form-control' id='tipo' name='tipo' required autofocus>" +
            "<option></option> " +
            " </select>");


    $.ajax({
        url: '/AgenPerWeb/CompromisoServlet',
        type: 'POST',
        data: {cargarComboCompromiso: 'true'},
        datType: 'JSON'
    }).done(function (sub) {

        for (i = 0; i < sub.length; i++) {

            $('#tipo').append("<option id='" + sub[i]['tipo'] + "' value='" + sub[i]['tipo'] + "'>" + sub[i]['tipo'] + "</option>");

        }



    });


}


function cargarComboCompromiso2() {

    $('#tipo0').append("<select class='form-control' id='tipo' name='tipo' required autofocus>" +
            "<option></option> " +
            " </select>");


    $.ajax({
        url: '/AgenPerWeb/CompromisoServlet',
        type: 'POST',
        data: {cargarComboCompromiso: 'true'},
        datType: 'JSON'
    }).done(function (sub) {

        for (i = 0; i < sub.length; i++) {

            $('#tipo').append("<option id='" + sub[i]['tipo'] + "' value='" + sub[i]['tipo'] + "'>" + sub[i]['tipo'] + "</option>");

        }



    });


}







