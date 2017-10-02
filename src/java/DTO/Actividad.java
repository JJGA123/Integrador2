/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Interfaz.IActividad;
import Interfaz.ITarea;
import Factory.Factory;
import Interfaz.IEstadisticas;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jhon Galvis
 */
public class Actividad{

    public String idActividad;
    public String descripcion;
    public String fecha;
    public String idUsu;
    public String hora;
    private Factory factory;

    public Actividad(String idUsu, String descripcion, String fecha,String idActividad,String hora) {
        this.idActividad = idActividad;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.idUsu=idUsu;
        this.hora=hora;
	factory = new Factory();
    }

    public Actividad() {
        factory = new Factory();
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    public String getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(String idActividad) {
        this.idActividad = idActividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(String idUsu) {
        this.idUsu = idUsu;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public Tarea consultarTarea(String idUsu,String idAct_idTarea, String idTarea) throws Exception {
        ITarea a = factory.obtenerTarea(false);
        Tarea t = a.consultarTarea(idUsu,idAct_idTarea, idTarea);
        System.out.println("id2: "+t.getIdAct());
        return t;
    }

    
    public ArrayList<Tarea> consultarTares(String idUsu,String idActividad) throws Exception {
        IActividad a = factory.obtenerActividad(false);
        ArrayList<Tarea> t = a.consultarTares(idUsu,idActividad);
        return t;
    }

    
    public boolean actualizarTarea(String idUsu,String idAct_idTare, String descripcion, String fecha, String idTarea,String hora) throws Exception {
        ITarea a = factory.obtenerTarea(false);
        Usuario u = new Usuario();
        Tarea t = consultarTarea(idUsu, idAct_idTare, idTarea);
        u.registrarEstActualizada(t.getDescripcion(), t.getIdUsu(), t.getIdTarea(), t.getHora(),t.getFecha(),"Tarea");
        return a.actualizarTarea(idUsu,idAct_idTare, descripcion, fecha, idTarea,hora);
    }

    
    public boolean registrarTarea(String idUsu,String idAct_idTare, String descripcion, String fecha, String idTarea,String hora) {
        ITarea a = factory.obtenerTarea(false);
        Tarea t = new Tarea(idUsu,idAct_idTare, descripcion, fecha, idTarea,hora);
        Usuario u = new Usuario();
        u.registrarEstRegistrada(descripcion, idUsu, idTarea, hora,fecha ,"Tarea");
        return a.registrarTarea(t);
    }

    
    public boolean eliminarTarea(String idUsu,String idAct_idTar, String idTarea) throws Exception {
        ITarea a = factory.obtenerTarea(false);
        Usuario u = new Usuario();
        Tarea t = consultarTarea(idUsu, idAct_idTar, idTarea);
        u.registrarEstEliminada(t.getDescripcion(), t.getIdUsu(), t.getIdTarea(),t.getHora(),t.getFecha(),"Tarea");
        return a.eliminarTarea(idUsu,idAct_idTar, idTarea);
    }

    @Override
    public String toString() {
        return "Descripcion : "+getDescripcion() +" Fecha limite : "+getFecha();
    }
   
}
