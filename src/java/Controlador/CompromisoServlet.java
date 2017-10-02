/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DTO.Actividad;
import DTO.Cita;
import DTO.Compromiso;
import DTO.Compromiso2;
import DTO.Cumpleaños;
import DTO.Entrevista;
import DTO.Estadistica;
import DTO.Tarea;
import Interfaz.INegocio;
import DTO.Negocio;
import DTO.Paseo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sun.xml.ws.transport.tcp.server.glassfish.ServletFakeArtifactSet;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cristian Ramirez
 */
@WebServlet(name = "CompromisoServlet", urlPatterns = {"/CompromisoServlet"})
public class CompromisoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void cargarActividad(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {

            INegocio neg = (INegocio) request.getSession().getAttribute("negocio");
            ArrayList<Actividad> lista = neg.consultarActividades();

            Gson gson = new Gson();
            String listado = gson.toJson(lista);

            response.getWriter().print(listado);
            /* TODO output your page here. You may use following sample code. */

        } catch (Exception ex) {
            Logger.getLogger(CompromisoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    protected void agregarCompromiso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String tipo = request.getParameter("tipo");

            System.out.println("tipo:" + tipo);
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String fe = request.getParameter("fecha");
            Date fecha = formatter.parse(fe);

            String observacion = request.getParameter("observacion");
            String activi = request.getParameter("activi");

            String hora = request.getParameter("hora");

            System.out.println("horaaaaaaaaaaaaaaa" + hora);
            INegocio ne = (INegocio) request.getSession().getAttribute("negocio");
            System.out.println("horaa....." + hora);
            System.out.println("activiviiiiii " + activi);

            if (ne.validarFecha(fe)) {
                if (tipo.equalsIgnoreCase("actividad")) {

                    if (ne.registrarActividad(observacion, fe, hora)) {
                        response.getWriter().print("exito");
                    } else {
                        response.getWriter().print("Error en el registro");
                    }
                } else if (tipo.equalsIgnoreCase("cita")) {

                    if (ne.registrarCita(observacion, fe, hora)) {
                        response.getWriter().print("exito");
                    } else {
                        response.getWriter().print("Error en el registro");
                    }
                } else if (tipo.equalsIgnoreCase("cumpleaños")) {

                    if (ne.registrarCumpleaños(observacion, fe, hora)) {
                        response.getWriter().print("exito");
                    } else {
                        response.getWriter().print("Error en el registro");
                    }
                } else if (tipo.equalsIgnoreCase("tarea")) {

                    if (ne.registrarTarea(activi, observacion, fe, hora)) {
                        response.getWriter().print("exito");
                    } else {
                        response.getWriter().print("Error en el registro");
                    }
                } else if (tipo.equalsIgnoreCase("entrevista")) {

                    if (ne.registrarEntrevista(observacion, fe, hora)) {
                        response.getWriter().print("exito");
                    } else {
                        response.getWriter().print("Error en el registro");
                    }
                } else if (tipo.equalsIgnoreCase("paseo")) {

                    if (ne.registrarPaseo(observacion, fe, hora)) {
                        response.getWriter().print("exito");
                    } else {
                        response.getWriter().print("Error en el registro");
                    }
                } else if (ne.registrarCompromiso2(tipo, observacion, fe, hora)) {
                    response.getWriter().print("exito");
                } else {
                    response.getWriter().print("Error en el registro");
                }
            } else {
                response.getWriter().print("No es una fecha permitida");
            }
        } catch (ParseException ex) {
            Logger.getLogger(CompromisoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    protected void consultarCompromiso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            Negocio ne = (Negocio) request.getSession().getAttribute("negocio");

            String tipo = request.getParameter("tipo");
            String actividad = request.getParameter("actividad");
            String fechaIni = request.getParameter("fecha1");
            String fechaFin = request.getParameter("fecha2");

            System.out.println("tipo:" + tipo);

            JsonArray array = new JsonArray();

            if (fechaIni.isEmpty() && fechaFin.isEmpty()) {
                if (tipo.equalsIgnoreCase("actividad")) {

                    ArrayList<Actividad> lista = ne.consultarActividades();

                    if (lista != null) {
                        for (Actividad act : lista) {
                            JsonObject object = new JsonObject();
                            object.addProperty("Id", act.getIdActividad());
                            object.addProperty("Descripcion", act.getDescripcion());
                            object.addProperty("Fecha", act.getFecha());
                            object.addProperty("Hora", act.getHora());
                            array.add(object);
                        }

                        String listado = array.toString();
                        response.getWriter().print(listado);
                    } else {

                        JsonObject object = new JsonObject();
                        response.getWriter().print(object);
                    }
                } else if (tipo.equalsIgnoreCase("cita")) {

                    ArrayList<Cita> lista = ne.consultarCitas();

                    if (lista != null) {

                        for (Cita ci : lista) {
                            JsonObject object = new JsonObject();
                            object.addProperty("Id", ci.getIdCita());
                            object.addProperty("Descripcion", ci.getDescripcion());
                            object.addProperty("Fecha", ci.getFecha());
                            object.addProperty("Hora", ci.getHora());
                            array.add(object);
                        }

                        String listado = array.toString();
                        response.getWriter().print(listado);

                    } else {

                        JsonObject object = new JsonObject();
                        response.getWriter().print(object);
                    }

                } else if (tipo.equalsIgnoreCase("cumpleaños")) {

                    ArrayList<Cumpleaños> lista = ne.consultarCumpleaños();

                    if (lista != null) {

                        for (Cumpleaños cum : lista) {
                            JsonObject object = new JsonObject();
                            object.addProperty("Id", cum.getIdCumpleaños());
                            object.addProperty("Descripcion", cum.getDescripcion());
                            object.addProperty("Fecha", cum.getFecha());
                            object.addProperty("Hora", cum.getHora());
                            array.add(object);
                        }

                        String listado = array.toString();
                        response.getWriter().print(listado);
                    } else {

                        JsonObject object = new JsonObject();
                        response.getWriter().print(object);
                    }

                } else if (tipo.equalsIgnoreCase("tarea")) {

                    ArrayList<Tarea> lista = ne.consultarTareas(actividad);

                    if (lista != null) {
                        for (Tarea tar : lista) {
                            JsonObject object = new JsonObject();
                            object.addProperty("Id", tar.getIdTarea());
                            object.addProperty("Descripcion", tar.getDescripcion());
                            object.addProperty("Fecha", tar.getFecha());
                            object.addProperty("Hora", tar.getHora());
                            array.add(object);
                        }

                        String listado = array.toString();
                        response.getWriter().print(listado);

                    } else {

                        JsonObject object = new JsonObject();
                        response.getWriter().print(object);
                    }

                } else if (tipo.equalsIgnoreCase("entrevista")) {

                    System.out.println("entroeoo");
                    ArrayList<Entrevista> lista = ne.consultarEntrevistas();

                    if (lista != null) {
                        for (Entrevista ent : lista) {
                            JsonObject object = new JsonObject();
                            object.addProperty("Id", ent.getIdEntrevista());
                            object.addProperty("Descripcion", ent.getDescripcion());
                            object.addProperty("Fecha", ent.getFecha());
                            object.addProperty("Hora", ent.getHora());
                            array.add(object);
                        }

                        String listado = array.toString();
                        response.getWriter().print(listado);

                    } else {

                        JsonObject object = new JsonObject();
                        response.getWriter().print(object);
                    }

                } else if (tipo.equalsIgnoreCase("paseo")) {

                    ArrayList<Paseo> lista = ne.consultarPaseos();

                    if (lista != null) {
                        for (Paseo pas : lista) {
                            JsonObject object = new JsonObject();
                            object.addProperty("Id", pas.getIdPaseo());
                            object.addProperty("Descripcion", pas.getDescripcion());
                            object.addProperty("Fecha", pas.getFecha());
                            object.addProperty("Hora", pas.getHora());
                            array.add(object);
                        }

                        String listado = array.toString();
                        response.getWriter().print(listado);

                    } else {

                        JsonObject object = new JsonObject();
                        response.getWriter().print(object);
                    }

                } else {

                    ArrayList<Compromiso2> lista = ne.consultarCompromisos2(tipo);

                    if (lista != null) {
                        for (Compromiso2 pas : lista) {
                            JsonObject object = new JsonObject();
                            object.addProperty("Id", pas.getIdCompromiso2());
                            object.addProperty("Descripcion", pas.getDescripcion());
                            object.addProperty("Fecha", pas.getFecha());
                            object.addProperty("Hora", pas.getHora());
                            array.add(object);
                        }

                        String listado = array.toString();
                        response.getWriter().print(listado);

                    } else {

                        JsonObject object = new JsonObject();
                        response.getWriter().print(object);
                    }
                }
                /* TODO output your page here. You may use following sample code. */

            } else if (!fechaIni.isEmpty() && !fechaFin.isEmpty()) {

                if (tipo.equalsIgnoreCase("actividad")) {

                    ArrayList<Actividad> lista = ne.consultarIntervaloActividades(fechaIni, fechaFin);

                    if (lista != null) {
                        for (Actividad act : lista) {
                            JsonObject object = new JsonObject();
                            object.addProperty("Id", act.getIdActividad());
                            object.addProperty("Descripcion", act.getDescripcion());
                            object.addProperty("Fecha", act.getFecha());
                            object.addProperty("Hora", act.getHora());
                            array.add(object);
                        }

                        String listado = array.toString();
                        response.getWriter().print(listado);
                    } else {

                        JsonObject object = new JsonObject();
                        response.getWriter().print(object);
                    }
                } else if (tipo.equalsIgnoreCase("cita")) {

                    ArrayList<Cita> lista = ne.consultarIntervaloCitas(fechaIni, fechaFin);

                    if (lista != null) {

                        for (Cita ci : lista) {
                            JsonObject object = new JsonObject();
                            object.addProperty("Id", ci.getIdCita());
                            object.addProperty("Descripcion", ci.getDescripcion());
                            object.addProperty("Fecha", ci.getFecha());
                            object.addProperty("Hora", ci.getHora());
                            array.add(object);
                        }

                        String listado = array.toString();
                        response.getWriter().print(listado);

                    } else {

                        JsonObject object = new JsonObject();
                        response.getWriter().print(object);
                    }

                } else if (tipo.equalsIgnoreCase("cumpleaños")) {

                    ArrayList<Cumpleaños> lista = ne.consultarIntervaloCumpleaños(fechaIni, fechaFin);

                    if (lista != null) {

                        for (Cumpleaños cum : lista) {
                            JsonObject object = new JsonObject();
                            object.addProperty("Id", cum.getIdCumpleaños());
                            object.addProperty("Descripcion", cum.getDescripcion());
                            object.addProperty("Fecha", cum.getFecha());
                            object.addProperty("Hora", cum.getHora());
                            array.add(object);
                        }

                        String listado = array.toString();
                        response.getWriter().print(listado);
                    } else {

                        JsonObject object = new JsonObject();
                        response.getWriter().print(object);
                    }

                } else if (tipo.equalsIgnoreCase("tarea")) {

                    ArrayList<Tarea> lista = ne.consultarIntervaloTareas(fechaIni, fechaFin, actividad);

                    if (lista != null) {
                        for (Tarea tar : lista) {
                            JsonObject object = new JsonObject();
                            object.addProperty("Id", tar.getIdTarea());
                            object.addProperty("Descripcion", tar.getDescripcion());
                            object.addProperty("Fecha", tar.getFecha());
                            object.addProperty("Hora", tar.getHora());
                            array.add(object);
                        }

                        String listado = array.toString();
                        response.getWriter().print(listado);

                    } else {

                        JsonObject object = new JsonObject();
                        response.getWriter().print(object);
                    }

                } else if (tipo.equalsIgnoreCase("entrevista")) {

                    ArrayList<Entrevista> lista = ne.consultarIntervaloEntrevistas(fechaIni, fechaFin);

                    if (lista != null) {

                        for (Entrevista ent : lista) {
                            JsonObject object = new JsonObject();
                            object.addProperty("Id", ent.getIdEntrevista());
                            object.addProperty("Descripcion", ent.getDescripcion());
                            object.addProperty("Fecha", ent.getFecha());
                            object.addProperty("Hora", ent.getHora());
                            array.add(object);
                        }

                        String listado = array.toString();
                        response.getWriter().print(listado);
                    } else {

                        JsonObject object = new JsonObject();
                        response.getWriter().print(object);
                    }

                } else if (tipo.equalsIgnoreCase("paseo")) {

                    ArrayList<Paseo> lista = ne.consultarIntervaloPaseos(fechaIni, fechaFin);

                    if (lista != null) {

                        for (Paseo pas : lista) {
                            JsonObject object = new JsonObject();
                            object.addProperty("Id", pas.getIdPaseo());
                            object.addProperty("Descripcion", pas.getDescripcion());
                            object.addProperty("Fecha", pas.getFecha());
                            object.addProperty("Hora", pas.getHora());
                            array.add(object);
                        }

                        String listado = array.toString();
                        response.getWriter().print(listado);
                    } else {

                        JsonObject object = new JsonObject();
                        response.getWriter().print(object);
                    }

                } else {
                    ArrayList<Compromiso2> lista = ne.consultarIntervaloCompromiso2(tipo, fechaIni, fechaFin);

                    if (lista != null) {

                        for (Compromiso2 pas : lista) {
                            JsonObject object = new JsonObject();
                            object.addProperty("Id", pas.getIdCompromiso2());
                            object.addProperty("Descripcion", pas.getDescripcion());
                            object.addProperty("Fecha", pas.getFecha());
                            object.addProperty("Hora", pas.getHora());
                            array.add(object);
                        }

                        String listado = array.toString();
                        response.getWriter().print(listado);
                    } else {

                        JsonObject object = new JsonObject();
                        response.getWriter().print(object);
                    }
                }

            } else if (fechaIni.isEmpty() || fechaFin.isEmpty()) {

                System.out.println("sadadas");
                JsonObject object = new JsonObject();
                object.addProperty("ErrorFalta", "ErrorFalta");
                array.add(object);

                String listado = array.toString();
                response.getWriter().print(listado);

            }

        } catch (Exception ex) {
            Logger.getLogger(CompromisoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void eliminarCompromiso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String tipo = request.getParameter("tipo");
            String id = request.getParameter("id");
            String actividad = request.getParameter("activi");
            INegocio ne = (INegocio) request.getSession().getAttribute("negocio");

            if (tipo.equalsIgnoreCase("actividad")) {

                if (ne.eliminarActividad(id)) {
                    response.getWriter().print("exito");
                } else {
                    response.getWriter().print("No se encontro una actividad con esta ID");
                }
            } else if (tipo.equalsIgnoreCase("cita")) {

                if (ne.eliminarCita(id)) {
                    response.getWriter().print("exito");
                } else {
                    response.getWriter().print("No se encontro una cita con esta ID");
                }
            } else if (tipo.equalsIgnoreCase("cumpleaños")) {

                if (ne.eliminarCumpleaños(id)) {
                    response.getWriter().print("exito");
                } else {
                    response.getWriter().print("No se encontro un cumpleaños con esta ID");
                }
            } else if (tipo.equalsIgnoreCase("tarea")) {

                if (ne.eliminarTarea(actividad, id)) {
                    response.getWriter().print("exito");
                } else {
                    response.getWriter().print("No se encontro una tarea con esta ID");
                }
            } else if (tipo.equalsIgnoreCase("entrevista")) {

                if (ne.eliminarEntrevista(id)) {
                    response.getWriter().print("exito");
                } else {
                    response.getWriter().print("No se encontro una entrevista con esta ID");
                }
            } else if (tipo.equalsIgnoreCase("paseo")) {

                if (ne.eliminarPaseo(id)) {
                    response.getWriter().print("exito");
                } else {
                    response.getWriter().print("No se encontro un paseo con esta ID");
                }
            } else if (ne.eliminarCompromiso2(tipo, id)) {
                response.getWriter().print("exito");
            } else {
                response.getWriter().print("No se encontro un compromiso con esta ID");
            }

        }

    }

    protected void eliminarTipoCompromiso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String tipo = request.getParameter("tipo");

            INegocio ne = (INegocio) request.getSession().getAttribute("negocio");

            if (ne.eliminarCompromiso(tipo)) {
                response.getWriter().print("exito");
            } else {
                response.getWriter().print("No se encontro un tipo de compromiso");
            }

        }

    }

    protected void modificarCompromiso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String tipo = request.getParameter("tipo");

            String id = request.getParameter("id");

            String fe = request.getParameter("fecha");

            String observacion = request.getParameter("observacion");
            String hora = request.getParameter("hora");
            String actividad = request.getParameter("actividad");

            INegocio ne = (INegocio) request.getSession().getAttribute("negocio");
            System.out.println("horaa....." + hora);
            System.out.println("activiviiiiii" + tipo);

            if (ne.validarFecha(fe)) {

                if (tipo.equalsIgnoreCase("actividad")) {
                    if (ne.actualizarActividad(observacion, fe, id, hora)) {
                        response.getWriter().print("exito");
                    } else {
                        response.getWriter().print("Error en la actualización");
                    }
                } else if (tipo.equalsIgnoreCase("cita")) {

                    if (ne.actualizarCita(observacion, fe, id, hora)) {
                        response.getWriter().print("exito");
                    } else {
                        response.getWriter().print("Error en la actualización");
                    }
                } else if (tipo.equalsIgnoreCase("cumpleanos") || tipo.equalsIgnoreCase("cumpleaños")) {

                    if (ne.actualizarCumpleaños(observacion, fe, id, hora)) {
                        response.getWriter().print("exito");
                    } else {
                        response.getWriter().print("Error en la actualización");
                    }
                } else if (tipo.equalsIgnoreCase("tarea")) {

                    if (ne.actualizarTarea(actividad, observacion, fe, id, hora)) {
                        response.getWriter().print("exito");
                    } else {
                        response.getWriter().print("Error en la actualización");
                    }
                } else if (tipo.equalsIgnoreCase("entrevista")) {

                    if (ne.actualizarEntrevista(observacion, fe, id, hora)) {
                        response.getWriter().print("exito");
                    } else {
                        response.getWriter().print("Error en la actualización");
                    }
                } else if (tipo.equalsIgnoreCase("paseo")) {

                    if (ne.actualizarPaseo(observacion, fe, id, hora)) {
                        response.getWriter().print("exito");
                    } else {
                        response.getWriter().print("Error en la actualización");
                    }
                } else if (ne.actualizarCompromiso2(tipo, id, observacion, fe, hora)) {
                    response.getWriter().print("exito");
                } else {
                    response.getWriter().print("Error en la actualización");
                }
            } else {
                response.getWriter().print("No es una fecha permitida");
            }
        }

    }

    protected void agregarTipoCompromiso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String nombre = request.getParameter("nombre");

            INegocio ne = (INegocio) request.getSession().getAttribute("negocio");

            if (ne.registrarCompromiso(nombre)) {
                response.getWriter().print("exito");
            } else {
                response.getWriter().print("Error en el registro");
            }

        }
    }

    protected void consultarAlarmaCompromiso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {

            Negocio ne = (Negocio) request.getSession().getAttribute("negocio");

            String tipo = request.getParameter("tipo");

            System.out.println("probandooooo" + tipo);

            String activi = request.getParameter("activi");

            JsonArray array = new JsonArray();

            if (tipo.equalsIgnoreCase("actividad")) {

                ArrayList<Actividad> lista = ne.consultarActividades();

                if (lista != null) {
                    for (Actividad act : lista) {

                        System.out.println("probandooooo 22222222222222222222");

                        JsonObject object = new JsonObject();

                        String alarma = ne.alarma(act.getFecha(), act.getHora());

                        object.addProperty("Id", act.getIdActividad());
                        object.addProperty("Descripcion", act.getDescripcion());
                        object.addProperty("Alarma", alarma);

                        array.add(object);
                    }

                    String listado = array.toString();
                    response.getWriter().print(listado);
                } else {

                    JsonObject object = new JsonObject();
                    response.getWriter().print(object);
                }
            } else if (tipo.equalsIgnoreCase("cita")) {

                ArrayList<Cita> lista = ne.consultarCitas();

                if (lista != null) {

                    for (Cita ci : lista) {
                        JsonObject object = new JsonObject();
                        String alarma = ne.alarma(ci.getFecha(), ci.getHora());
                        object.addProperty("Id", ci.getIdCita());
                        object.addProperty("Descripcion", ci.getDescripcion());
                        object.addProperty("Alarma", alarma);

                        array.add(object);
                    }

                    String listado = array.toString();
                    response.getWriter().print(listado);

                } else {

                    JsonObject object = new JsonObject();
                    response.getWriter().print(object);
                }

            } else if (tipo.equalsIgnoreCase("cumpleaños")) {

                ArrayList<Cumpleaños> lista = ne.consultarCumpleaños();

                if (lista != null) {

                    for (Cumpleaños cum : lista) {
                        JsonObject object = new JsonObject();
                        String alarma = ne.alarma(cum.getFecha(), cum.getHora());
                        object.addProperty("Id", cum.getIdCumpleaños());
                        object.addProperty("Descripcion", cum.getDescripcion());
                        object.addProperty("Alarma", alarma);

                        array.add(object);
                    }

                    String listado = array.toString();
                    response.getWriter().print(listado);
                } else {

                    JsonObject object = new JsonObject();
                    response.getWriter().print(object);
                }

            } else if (tipo.equalsIgnoreCase("tarea")) {

                ArrayList<Tarea> lista = ne.consultarTareas(activi);

                if (lista != null) {
                    for (Tarea tar : lista) {
                        JsonObject object = new JsonObject();
                        String alarma = ne.alarma(tar.getFecha(), tar.getHora());
                        object.addProperty("Id", tar.getIdAct());
                        object.addProperty("Descripcion", tar.getDescripcion());
                        object.addProperty("Alarma", alarma);

                        array.add(object);
                    }

                    String listado = array.toString();
                    response.getWriter().print(listado);

                } else {

                    JsonObject object = new JsonObject();
                    response.getWriter().print(object);
                }
            } else if (tipo.equalsIgnoreCase("entrevista")) {

                ArrayList<Entrevista> lista = ne.consultarEntrevistas();

                if (lista != null) {
                    for (Entrevista ent : lista) {
                        JsonObject object = new JsonObject();
                        String alarma = ne.alarma(ent.getFecha(), ent.getHora());
                        object.addProperty("Id", ent.getIdEntrevista());
                        object.addProperty("Descripcion", ent.getDescripcion());
                        object.addProperty("Alarma", alarma);

                        array.add(object);
                    }

                    String listado = array.toString();
                    response.getWriter().print(listado);

                } else {

                    JsonObject object = new JsonObject();
                    response.getWriter().print(object);
                }

            } else if (tipo.equalsIgnoreCase("paseo")) {

                ArrayList<Paseo> lista = ne.consultarPaseos();

                if (lista != null) {
                    for (Paseo pas : lista) {
                        JsonObject object = new JsonObject();
                        String alarma = ne.alarma(pas.getFecha(), pas.getHora());
                        object.addProperty("Id", pas.getIdPaseo());
                        object.addProperty("Descripcion", pas.getDescripcion());
                        object.addProperty("Alarma", alarma);

                        array.add(object);
                    }

                    String listado = array.toString();
                    response.getWriter().print(listado);

                } else {

                    JsonObject object = new JsonObject();
                    response.getWriter().print(object);
                }

            } else {

                ArrayList<Compromiso2> lista = ne.consultarCompromisos2(tipo);

                if (lista != null) {
                    for (Compromiso2 pas : lista) {
                        JsonObject object = new JsonObject();
                        String alarma = ne.alarma(pas.getFecha(), pas.getHora());
                        object.addProperty("Id", pas.getIdCompromiso2());
                        object.addProperty("Descripcion", pas.getDescripcion());
                        object.addProperty("Alarma", alarma);

                        array.add(object);
                    }

                    String listado = array.toString();
                    response.getWriter().print(listado);

                } else {

                    JsonObject object = new JsonObject();
                    response.getWriter().print(object);
                }

            }
            /* TODO output your page here. You may use following sample code. */

        } catch (Exception ex) {
            Logger.getLogger(CompromisoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void consultarEstadisticaCompromiso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {

            System.out.println("comprobandoooooooooooo");

            Negocio ne = (Negocio) request.getSession().getAttribute("negocio");

            String tipo = request.getParameter("tipo");
            String operacion = request.getParameter("operacion");

            String activi = request.getParameter("activi");

            System.out.println("comprobbnannnndooooo " + tipo);
            System.out.println("comprooobaanndooooo " + operacion);

            JsonArray array = new JsonArray();

            if (operacion.equalsIgnoreCase("registrado")) {

                ArrayList<Estadistica> lista = ne.consultarEstRegistrada(tipo);

                if (lista != null) {
                    for (Estadistica act : lista) {

                        System.out.println("compprooooobanndooooooo iddddd " + act.getTipo());
                        JsonObject object = new JsonObject();

                        object.addProperty("Id", act.getId());
                        object.addProperty("Descripcion", act.getDescripcion());
                        object.addProperty("Fecha", act.getFecha());
                        object.addProperty("FechaSistema", act.getFechaSistema());
                        object.addProperty("Hora", act.getHora());
                        object.addProperty("HoraSistema", act.getHoraSistema());

                        array.add(object);
                    }

                    String listado = array.toString();
                    response.getWriter().print(listado);
                } else {

                    JsonObject object = new JsonObject();
                    response.getWriter().print(object);
                }
            } else if (operacion.equalsIgnoreCase("eliminado")) {

                ArrayList<Estadistica> lista = ne.consultarEstEliminada(tipo);

                if (lista != null) {

                    for (Estadistica act : lista) {
                        JsonObject object = new JsonObject();

                        object.addProperty("Id", act.getId());
                        object.addProperty("Descripcion", act.getDescripcion());
                        object.addProperty("Fecha", act.getFecha());
                        object.addProperty("FechaSistema", act.getFechaSistema());
                        object.addProperty("Hora", act.getHora());
                        object.addProperty("HoraSistema", act.getHoraSistema());

                        array.add(object);
                    }

                    String listado = array.toString();
                    response.getWriter().print(listado);

                } else {

                    JsonObject object = new JsonObject();
                    response.getWriter().print(object);
                }

            } else if (operacion.equalsIgnoreCase("actualizado")) {

                ArrayList<Estadistica> lista = ne.consultarEstActualizada(tipo);

                if (lista != null) {

                    for (Estadistica act : lista) {
                        JsonObject object = new JsonObject();

                        object.addProperty("Id", act.getId());
                        object.addProperty("Descripcion", act.getDescripcion());
                        object.addProperty("Fecha", act.getFecha());
                        object.addProperty("FechaSistema", act.getFechaSistema());
                        object.addProperty("Hora", act.getHora());
                        object.addProperty("HoraSistema", act.getHoraSistema());

                        array.add(object);
                    }

                    String listado = array.toString();
                    response.getWriter().print(listado);
                } else {

                    JsonObject object = new JsonObject();
                    response.getWriter().print(object);
                }

            } else {
                response.getWriter().print("Tipo no valido");
            }
            /* TODO output your page here. You may use following sample code. */

        } catch (Exception ex) {
            Logger.getLogger(CompromisoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void cargarComboCompromiso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {

            INegocio neg = (INegocio) request.getSession().getAttribute("negocio");
            ArrayList<Compromiso> lista = neg.consultarCompromisos();

            System.out.println(lista.toString());
            Gson gson = new Gson();
            String listado = gson.toJson(lista);

            response.getWriter().print(listado);
            /* TODO output your page here. You may use following sample code. */

        } catch (Exception ex) {
            Logger.getLogger(CompromisoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("cargarActividad") != null) {
            cargarActividad(request, response);
        } else if (request.getParameter("agregarCompromiso") != null) {
            agregarCompromiso(request, response);
        } else if (request.getParameter("consultarCompromiso") != null) {
            consultarCompromiso(request, response);
        } else if (request.getParameter("eliminarCompromiso") != null) {
            eliminarCompromiso(request, response);
        } else if (request.getParameter("modificarCompromiso") != null) {
            modificarCompromiso(request, response);
        } else if (request.getParameter("agregarTipoCompromiso") != null) {
            agregarTipoCompromiso(request, response);
        } else if (request.getParameter("consultarAlarmaCompromiso") != null) {
            consultarAlarmaCompromiso(request, response);
        } else if (request.getParameter("consultarEstadisticaCompromiso") != null) {
            consultarEstadisticaCompromiso(request, response);
        } else if (request.getParameter("cargarComboCompromiso") != null) {
            cargarComboCompromiso(request, response);
        } else if (request.getParameter("eliminarTipoCompromiso") != null) {
            eliminarTipoCompromiso(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
