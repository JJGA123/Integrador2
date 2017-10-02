/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DTO.Actividad;
import DTO.Cita;
import DTO.Compromiso2;
import DTO.Cumpleaños;
import DTO.Entrevista;
import DTO.Paseo;
import DTO.Tarea;
import Interfaz.INegocio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cristian Ramirez
 */
@WebServlet(name = "auxiliarServlet", urlPatterns = {"/auxiliarServlet"})
public class auxiliarServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String tipo = request.getParameter("tipo");
            String id = request.getParameter("id");
            String actividad = request.getParameter("msj2");
            System.out.println("tippppppppppooooooooo1" + tipo);
            System.out.println("id" + id);
            System.out.println("act" + actividad);

            INegocio ne = (INegocio) request.getSession().getAttribute("negocio");

            request.getSession().setAttribute("modificarTipo", tipo);

            if (tipo.equalsIgnoreCase("actividad")) {

                Actividad act = ne.consultarActividad(id);

                if (act != null) {
                    request.getSession().setAttribute("modificarAct", act);
                } else {
                    request.getSession().setAttribute("modificarTipo", "error");

                }

            } else if (tipo.equalsIgnoreCase("cita")) {

                Cita cit = ne.consultarCita(id);

                if (cit != null) {
                    request.getSession().setAttribute("modificarCit", cit);
                } else {
                    request.getSession().setAttribute("modificarTipo", "error");

                }
            } else if (tipo.equalsIgnoreCase("cumpleanos")) {

                Cumpleaños cum = ne.consultarCumpleaños(id);
                if (cum != null) {
                    request.getSession().setAttribute("modificarCum", cum);
                } else {

                    request.getSession().setAttribute("modificarTipo", "error");
                }

            } else if (tipo.equalsIgnoreCase("tarea")) {

                Tarea tar = ne.consultarTarea(actividad, id);
                if (tar != null) {
                    request.getSession().setAttribute("modificarTar", tar);
                } else {

                    request.getSession().setAttribute("modificarTipo", "error");
                }
            } else if (tipo.equalsIgnoreCase("entrevista")) {

                Entrevista ent = ne.consultarEntrevista(id);
                if (ent != null) {
                    request.getSession().setAttribute("modificarEnt", ent);
                } else {

                    request.getSession().setAttribute("modificarTipo", "error");
                }
            } else if (tipo.equalsIgnoreCase("paseo")) {

                Paseo pas = ne.consultarPaseo(id);
                if (pas != null) {
                    request.getSession().setAttribute("modificarPas", pas);
                } else {

                    request.getSession().setAttribute("modificarTipo", "error");
                }
            } else {
                Compromiso2 otro = ne.consultarCompromiso2(tipo, id);
                if (otro != null) {
                    request.getSession().setAttribute("modificarOtro", otro);
                } else {

                    request.getSession().setAttribute("modificarTipo", "error");
                }

            }

            response.sendRedirect("Vistas/auxiliar_mod.jsp");

        } catch (Exception ex) {
            Logger.getLogger(auxiliarServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
