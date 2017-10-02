/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import DTO.Actividad;
import DTO.Tarea;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jhon Galvis
 */
public interface IActividad {

    public ArrayList<Tarea> consultarTares(String idUsu,String idTarea) throws Exception;

    public Actividad consultarActividad(String correo, String idActividad) throws Exception;

    public boolean actualizarActividad(String correo, String descripcion, String fecha, String idActividad,String hora);

    public boolean registrarActividad(Actividad dto);

    public boolean eliminarActividad(String correo, String idActividad);
}
