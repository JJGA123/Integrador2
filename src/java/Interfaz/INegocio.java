/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import DTO.Actividad;
import DTO.Cita;
import DTO.Compromiso;
import DTO.Compromiso2;
import DTO.Cumpleaños;
import DTO.Entrevista;
import DTO.Estadistica;
import DTO.Paseo;
import Interfaz.IUsuario;
import DTO.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Interfaz.IActividad;
import DTO.Tarea;

/**
 *
 * @author Jhon Galvis
 */
public interface INegocio {

    

    //Iniciar sesion
    public boolean iniciarSesion(String correo, String contraseña);

    public boolean cerrarSesion();

    //Actividad
    public Tarea consultarTarea(String idAct_idTarea, String idTarea) throws Exception;

    public ArrayList<Tarea> consultarTareas(String idActivida) throws Exception;
    
    public ArrayList<Tarea> consultarIntervaloTareas(String fechaMinima,String fechaMayor,String idActivida) throws Exception;

    public boolean actualizarTarea(String idAct_idTare, String descripcion, String fecha, String idTarea,String hora);

    public boolean registrarTarea(String idAct_idTare, String descripcion, String fecha,String hora);

    public boolean eliminarTarea(String idAct_idTar, String idTarea);

    //Usuario
    public String obtenerNombre();

    public boolean registrarUsuario(String nombre, String correo, String contrasena);

    public String consultarUsuario();

    public boolean actualizarUsuario(String nombre, String contraseña) throws Exception;

    public ArrayList<Actividad> consultarActividades() throws Exception;
    
    public ArrayList<Actividad> consultarIntervaloActividades(String fechaMinima,String fechaMayor) throws Exception;

    public Actividad consultarActividad(String idActividad) throws Exception;

    public boolean actualizarActividad(String descripcion, String fecha, String idActividad,String hora);

    public boolean registrarActividad(String descripcion, String fecha,String hora);

    public boolean eliminarActividad(String idActividad);

    public Cita consultarCita(String idCita) throws Exception;

    public ArrayList<Cita> consultarCitas() throws Exception;
    
    public ArrayList<Cita> consultarIntervaloCitas(String fechaMinima,String fechaMayor) throws Exception;

    public boolean actualizarCita(String descripcion, String fecha, String idCita,String hora);

    public boolean registrarCita(String descripcion, String fecha,String hora);

    public boolean eliminarCita(String idCita);

    public Cumpleaños consultarCumpleaños(String idCumpleaños) throws Exception;

    public ArrayList<Cumpleaños> consultarCumpleaños() throws Exception;
    
    public ArrayList<Cumpleaños> consultarIntervaloCumpleaños(String fechaMinima,String fechaMayor) throws Exception;

    public boolean actualizarCumpleaños(String descripcion, String fecha, String idCumpleaños,String hora);

    public boolean registrarCumpleaños(String descripcion, String fecha,String hora);

    public boolean eliminarCumpleaños(String idCumpleaños);
    
    public ArrayList<Entrevista> consultarEntrevistas() throws Exception;

    public ArrayList<Entrevista> consultarIntervaloEntrevistas(String fechaMinima,String fechaMayor) throws Exception;
    
    public Entrevista consultarEntrevista(String idEntrevista) throws Exception;
    
    public boolean actualizarEntrevista(String descripcion, String fecha, String idEntrevista,String hora);

    public boolean registrarEntrevista(String descripcion, String fecha,String hora);

    public boolean eliminarEntrevista(String idEntrevista);
    
    public ArrayList<Paseo> consultarPaseos() throws Exception;
    
    public ArrayList<Paseo> consultarIntervaloPaseos(String fechaMinima,String fechaMayor) throws Exception;

    public Paseo consultarPaseo(String idPaseo) throws Exception;

    public boolean actualizarPaseo(String descripcion, String fecha, String idPaseo,String hora);

    public boolean registrarPaseo(String descripcion, String fecha,String hora);

    public boolean eliminarPaseo(String idPaseo);
    
    public ArrayList<Estadistica> consultarEstEliminada(String tipo) throws Exception;
    
    public ArrayList<Estadistica> consultarEstActualizada(String tipo) throws Exception;
    
    public ArrayList<Estadistica> consultarEstRegistrada(String tipo) throws Exception;
    
    public ArrayList<Compromiso> consultarCompromisos() throws Exception;

    public boolean registrarCompromiso(String tipo);

    public boolean eliminarCompromiso(String tipo);
    
    public ArrayList<Compromiso2> consultarCompromisos2(String nomCompromiso) throws Exception;
    
    public Compromiso2 consultarCompromiso2(String nomCompromiso,String idCompromiso2) throws Exception;

    public boolean actualizarCompromiso2(String nomCompromiso,String idCompromiso2, String descripcion, String fecha, String hora);
    
    public boolean registrarCompromiso2(String nomCompromiso,String descripcion, String fecha, String hora);

    public boolean eliminarCompromiso2(String nomCompromiso,String idCompromiso2);
    
    public ArrayList<Compromiso2> consultarIntervaloCompromiso2(String nomCompromiso,String fechaMinima, String fechaMayor) throws Exception ; 
    
    //otros
    
    public boolean validarFecha(String fecha);
    
    public boolean validarFecha2(String fecha);
    
    public String alarma(String fecha,String hora);
    
    public boolean consultaMayorFecha(String fechaMayor,String fecha);
    
    public boolean consultaMinimaFecha(String fechaMinima,String fecha);
    

}
