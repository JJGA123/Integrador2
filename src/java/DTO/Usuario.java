/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Interfaz.IActividad;
import Interfaz.ICita;
import Interfaz.ICumpleaños;
import Interfaz.IUsuario;
import Factory.Factory;
import Interfaz.ICompromiso;
import Interfaz.ICompromiso2;
import Interfaz.IEntrevista;
import Interfaz.IEstadisticas;
import Interfaz.IPaseo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Jhon Galvis
 */
public class Usuario {

    public String nombre;
    public String correo;
    public String contrasena;
    public String idActual;
    private Factory factory;

    public Usuario(String nombre, String correo, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.idActual = "0000";
        factory = new Factory();
    }

    public Usuario() {
        factory = new Factory();
    }

    public String idActual(String correo) {
        IUsuario u = factory.obtenerUsuario(false);
        String id = u.idActual(correo);
        int id2 = 0;
        for (int i = 0; i < 4; i++) {
            if (Integer.parseInt(id.substring(i, (i + 1))) != 0) {
                id2 = Integer.parseInt(id.substring(i, 4));
                break;
            }
        }
        id2++;
        id = "" + id2;
        int lon = id.length();
        if (lon == 1) {
            id = "000" + id2;
        }
        if (lon == 2) {
            id = "00" + id2;
        }
        if (lon == 3) {
            id = "0" + id2;
        }
        return id;
    }

    public String actualizarId(String correo) {
        IUsuario u = factory.obtenerUsuario(false);
        String ida = idActual(correo);
        u.actualizarId(correo, ida);
        return ida;
    }

    public String getIdActual() {
        return idActual;
    }

    public void setIdActual(String idActual) {
        this.idActual = idActual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    @Override
    public String toString() {
        return "Nombre : " + getNombre() + " Correo: " + getCorreo();
    }

    public Usuario getUsuario(String correo) {
        IUsuario u = factory.obtenerUsuario(false);
        if (consultarUsuario(correo).equalsIgnoreCase("")) {
            System.out.println("No existe este usuario");
            return null;
        }
        return u.consultarUsuario(correo);
    }

    public boolean registrarUsuario(String nombre, String correo, String contrasena) {
        IUsuario u = factory.obtenerUsuario(false);
        Usuario u2 = new Usuario(nombre, correo, contrasena);
        return u.registrarUsuario(u2);
    }

    public String consultarUsuario(String correo) {
        IUsuario u = factory.obtenerUsuario(false);
        Usuario u2 = u.consultarUsuario(correo);
        if (u2 == null) {
            return "";
        }
        return u2.toString();
    }

    public boolean actualizarUsuario(String nombre, String correo, String contraseña) throws Exception {
        IUsuario u = factory.obtenerUsuario(false);
        return u.actualizarUsuario(nombre, correo, contraseña);
    }

    public ArrayList<Actividad> consultarActividades(String idUsu) throws Exception {
        IUsuario u = factory.obtenerUsuario(false);
        ArrayList<Actividad> a = u.consultarActividades(idUsu);
        return a;
    }

    public Actividad consultarActividad(String correo, String idActividad) throws Exception {
        IActividad u = factory.obtenerActividad(false);
        Actividad a2 = u.consultarActividad(correo, idActividad);
        if (a2 == null) {
            System.out.println("La actividad no se encontro");
            return null;
        }
        return a2;
    }

    public boolean actualizarActividad(String correo, String descripcion, String fecha, String idActividad, String hora) throws Exception {
        IActividad u = factory.obtenerActividad(false);
        Actividad p = consultarActividad(correo, idActividad);
        registrarEstActualizada(p.getDescripcion(), p.getIdUsu(), p.getIdActividad(), p.getHora(), p.getFecha(), "Actividad");
        return u.actualizarActividad(correo, descripcion, fecha, idActividad, hora);
    }

    public boolean registrarActividad(String idUsu, String descripcion, String fecha, String idActividad, String hora) {
        IActividad u = factory.obtenerActividad(false);
        Actividad a = new Actividad(idUsu, descripcion, fecha, idActividad, hora);
        registrarEstRegistrada(descripcion, idUsu, idActividad, hora, fecha, "Actividad");
        return u.registrarActividad(a);
    }

    public boolean eliminarActividad(String correo, String idActividad) throws Exception {
        IActividad u = factory.obtenerActividad(false);
        Actividad p = consultarActividad(correo, idActividad);
        registrarEstEliminada(p.getDescripcion(), p.getIdUsu(), p.getIdActividad(), p.getHora(), p.getFecha(), "Actividad");
        return u.eliminarActividad(correo, idActividad);
    }

    public Cita consultarCita(String correo, String idCita) throws Exception {
        ICita u = factory.obtenerCita(false);
        Cita a2 = u.consultarCita(correo, idCita);
        if (a2 == null) {
            System.out.println("No se encontro la cita");
            return null;
        }
        return a2;
    }

    public ArrayList<Cita> consultarCitas(String correo) throws Exception {
        IUsuario u = factory.obtenerUsuario(false);
        ArrayList<Cita> a = u.consultarCitas(correo);
        return a;
    }

    public boolean actualizarCita(String correo, String descripcion, String fecha, String idCita, String hora) throws Exception {
        ICita u = factory.obtenerCita(false);
        Cita p = consultarCita(correo, idCita);
        registrarEstActualizada(p.getDescripcion(), p.getIdUsu(), p.getIdCita(), p.getHora(), p.getFecha(), "Cita");
        return u.actualizarCita(correo, descripcion, fecha, idCita, hora);
    }

    public boolean registrarCita(String idUsu, String descripcion, String fecha, String idCita, String hora) {
        ICita u = factory.obtenerCita(false);
        Cita c = new Cita(idUsu, descripcion, fecha, idCita, hora);
        registrarEstRegistrada(descripcion, idUsu, idCita, hora, fecha, "Cita");
        return u.registrarCita(c);
    }

    public boolean eliminarCita(String correo, String idCita) throws Exception {
        ICita u = factory.obtenerCita(false);
        Cita p = consultarCita(correo, idCita);
        registrarEstEliminada(p.getDescripcion(), p.getIdUsu(), p.getIdCita(), p.getHora(), p.getFecha(), "Cita");
        return u.eliminarCita(correo, idCita);
    }

    public Cumpleaños consultarCumpleaños(String correo, String idCumpleaños) throws Exception {
        ICumpleaños u = factory.obtenerCumpleaños(false);
        Cumpleaños a2 = u.consultarCumpleaños(correo, idCumpleaños);
        if (a2 == null) {
            System.out.println("No se encontro el cumpleaños");
            return null;
        }
        return a2;
    }

    public ArrayList<Cumpleaños> consultarCumpleaños(String correo) throws Exception {
        IUsuario u = factory.obtenerUsuario(false);
        ArrayList<Cumpleaños> a = u.consultarCumpleaños(correo);
        return a;
    }

    public boolean actualizarCumpleaños(String correo, String descripcion, String fecha, String idCumpleaños, String hora) throws Exception {
        ICumpleaños u = factory.obtenerCumpleaños(false);
        Cumpleaños p = consultarCumpleaños(correo, idCumpleaños);
        registrarEstActualizada(p.getDescripcion(), p.getIdUsu(), p.getIdCumpleaños(), p.getHora(), p.getFecha(), "Cumpleaños");
        return u.actualizarCumpleaños(correo, descripcion, fecha, idCumpleaños, hora);
    }

    public boolean registrarCumpleaños(String idCumpleaños, String descripcion, String fecha, String idUsu, String hora) {
        ICumpleaños u = factory.obtenerCumpleaños(false);
        Cumpleaños c = new Cumpleaños(idCumpleaños, descripcion, fecha, idUsu, hora);
        registrarEstRegistrada(descripcion, idUsu, idCumpleaños, hora, fecha, "Cumpleaños");
        return u.registrarCumpleaños(c);
    }

    public boolean eliminarCumpleaños(String correo, String idCumpleaños) throws Exception {
        ICumpleaños u = factory.obtenerCumpleaños(false);
        Cumpleaños p = consultarCumpleaños(correo, idCumpleaños);
        registrarEstEliminada(p.getDescripcion(), p.getIdUsu(), p.getIdCumpleaños(), p.getHora(), p.getFecha(), "Cumpleaños");
        return u.eliminarCumpleaños(correo, idCumpleaños);
    }

    public Entrevista consultarEntrevista(String correo, String idEntrevista) throws Exception {
        IEntrevista u = factory.obtenerEntrevista(false);
        Entrevista a2 = u.consultarEntrevista(correo, idEntrevista);
        if (a2 == null) {
            System.out.println("No se encontro el entrevista");
            return null;
        }
        return a2;
    }

    public ArrayList<Entrevista> consultarEntrevistas(String correo) throws Exception {
        IUsuario u = factory.obtenerUsuario(false);
        ArrayList<Entrevista> a = u.consultarEntrevistas(correo);
        return a;
    }

    public boolean actualizarEntrevista(String correo, String descripcion, String fecha, String idEntrevista, String hora) throws Exception {
        IEntrevista u = factory.obtenerEntrevista(false);
        Entrevista p = consultarEntrevista(correo, idEntrevista);
        registrarEstActualizada(p.getDescripcion(), p.getIdUsu(), p.getIdEntrevista(), p.getHora(), p.getFecha(), "Entrevista");
        return u.actualizarEntrevista(correo, descripcion, fecha, idEntrevista, hora);
    }

    public boolean registrarEntrevista(String idUsu, String descripcion, String fecha, String idEntrevista, String hora) {
        IEntrevista u = factory.obtenerEntrevista(false);
        Entrevista c = new Entrevista(descripcion, idUsu, idEntrevista, fecha, hora);
        registrarEstRegistrada(descripcion, idUsu, idEntrevista, hora, fecha, "Entrevista");
        return u.registrarEntrevista(c);
    }

    public boolean eliminarEntrevista(String correo, String idEntrevista) throws Exception {
        IEntrevista u = factory.obtenerEntrevista(false);
        Entrevista p = consultarEntrevista(correo, idEntrevista);
        registrarEstEliminada(p.getDescripcion(), p.getIdUsu(), p.getIdEntrevista(), p.getHora(), p.getFecha(), "Entrevista");
        return u.eliminarEntrevista(correo, idEntrevista);
    }

    public Paseo consultarPaseo(String correo, String idPaseo) throws Exception {
        IPaseo u = factory.obtenerPaseo(false);
        Paseo a2 = u.consultarPaseo(correo, idPaseo);
        if (a2 == null) {
            System.out.println("No se encontro el paseo");
            return null;
        }
        return a2;
    }

    public ArrayList<Paseo> consultarPaseos(String correo) throws Exception {
        IUsuario u = factory.obtenerUsuario(false);
        ArrayList<Paseo> a = u.consultarPaseos(correo);
        return a;
    }

    public boolean actualizarPaseo(String correo, String descripcion, String fecha, String idPaseo, String hora) throws Exception {
        IPaseo u = factory.obtenerPaseo(false);
        Paseo p = consultarPaseo(correo, idPaseo);
        registrarEstActualizada(p.getDescripcion(), p.getIdUsu(), p.getIdPaseo(), p.getHora(), p.getFecha(), "Paseo");
        return u.actualizarPaseo(correo, descripcion, fecha, idPaseo, hora);
    }

    public boolean registrarPaseo(String idUsu, String descripcion, String fecha, String idPaseo, String hora) {
        IPaseo u = factory.obtenerPaseo(false);
        Paseo c = new Paseo(idPaseo, descripcion, fecha, idUsu, hora);
        registrarEstRegistrada(descripcion, idUsu, idPaseo, hora, fecha, "Paseo");
        return u.registrarPaseo(c);
    }

    public boolean eliminarPaseo(String correo, String idPaseo) throws Exception {
        IPaseo u = factory.obtenerPaseo(false);
        Paseo p = consultarPaseo(correo, idPaseo);
        registrarEstEliminada(p.getDescripcion(), p.getIdUsu(), p.getIdPaseo(), p.getHora(), p.getFecha(), "Paseo");
        return u.eliminarPaseo(correo, idPaseo);
    }

    public ArrayList<Estadistica> consultarEstEliminada(String idUsu, String tipo) throws Exception {
        IEstadisticas u = factory.obtenerEstadistica(false);
        ArrayList<Estadistica> a = u.consultarEstEliminada(idUsu, tipo);
        return a;
    }

    public boolean registrarEstEliminada(String descripcion, String idUsu, String id, String hora, String fecha, String tipo) {
        IEstadisticas u = factory.obtenerEstadistica(false);
        Calendar calendario = Calendar.getInstance();
        int hora1 = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        Calendar fechaDes = Calendar.getInstance();
        int dia = fechaDes.get(Calendar.DAY_OF_MONTH);
        int mes = (fechaDes.get(Calendar.MONTH) + 1);
        int año = fechaDes.get(Calendar.YEAR);
        String horaSis = "" + hora1 + ":" + minutos;
        String fechaSis = "" + año + "-" + mes + "-" + dia;
        Estadistica c = new Estadistica(descripcion, idUsu, id, fecha, hora, horaSis, fechaSis, tipo);
        return u.registrarEstEliminada(c);
    }

    public ArrayList<Estadistica> consultarEstActualizada(String idUsu, String tipo) throws Exception {
        IEstadisticas u = factory.obtenerEstadistica(false);
        ArrayList<Estadistica> a = u.consultarEstActualizada(idUsu, tipo);
        return a;
    }

    public boolean registrarEstActualizada(String descripcion, String idUsu, String id, String hora, String fecha, String tipo) {
        IEstadisticas u = factory.obtenerEstadistica(false);
        Calendar calendario = Calendar.getInstance();
        int hora1 = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        Calendar fechaDes = Calendar.getInstance();
        int dia = fechaDes.get(Calendar.DAY_OF_MONTH);
        int mes = (fechaDes.get(Calendar.MONTH) + 1);
        int año = fechaDes.get(Calendar.YEAR);
        String horaSis = "" + hora1 + ":" + minutos;
        String fechaSis = "" + año + "-" + mes + "-" + dia;
        Estadistica c = new Estadistica(descripcion, idUsu, id, fecha, hora, horaSis, fechaSis, tipo);
        return u.registrarEstActualizada(c);
    }

    public ArrayList<Estadistica> consultarEstRegistrada(String idUsu, String tipo) throws Exception {
        IEstadisticas u = factory.obtenerEstadistica(false);
        ArrayList<Estadistica> a = u.consultarEstActualizada(idUsu, tipo);
        return a;
    }

    public boolean registrarEstRegistrada(String descripcion, String idUsu, String id, String hora, String fecha, String tipo) {
        IEstadisticas u = factory.obtenerEstadistica(false);
        Calendar calendario = Calendar.getInstance();
        int hora1 = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        Calendar fechaDes = Calendar.getInstance();
        int dia = fechaDes.get(Calendar.DAY_OF_MONTH);
        int mes = (fechaDes.get(Calendar.MONTH) + 1);
        int año = fechaDes.get(Calendar.YEAR);
        String horaSis = "" + hora1 + ":" + minutos;
        String fechaSis = "" + año + "-" + mes + "-" + dia;
        Estadistica c = new Estadistica(descripcion, idUsu, id, fecha, hora, horaSis, fechaSis, tipo);
        return u.registrarEstRegistrada(c);
    }

    public ArrayList<Compromiso> consultarCompromisos(String idUsu) throws Exception {
        ICompromiso e = factory.obtenerCompromiso(false);
        ArrayList<Compromiso> a = e.consultarCompromisos(idUsu);
        return a;
    }

    public boolean registrarCompromiso(String tipo, String idUsu) {
        ICompromiso u = factory.obtenerCompromiso(false);
        Compromiso c = new Compromiso(tipo, idUsu);
        return u.registrarCompromiso(c);
    }

    public boolean eliminarCompromiso(String tipo, String idUsu) {
        ICompromiso u = factory.obtenerCompromiso(false);
        return u.eliminarCompromiso(tipo, idUsu);
    }

    public ArrayList<Compromiso2> consultarCompromisos2(String nomCompromiso,String idUsu) throws Exception {
        ICompromiso2 u = factory.obtenerCompromiso2(false);
        ArrayList<Compromiso2> a = u.consultarCompromisos2(nomCompromiso,idUsu);
        return a;
    }

    public Compromiso2 consultarCompromiso2(String nomCompromiso,String correo, String idCompromiso2) throws Exception {
        ICompromiso2 u = factory.obtenerCompromiso2(false);
        Compromiso2 a2 = u.consultarCompromiso2(nomCompromiso,correo, idCompromiso2);
        if (a2 == null) {
            System.out.println("No se encontro el paseo");
            return null;
        }
        return a2;
    }

    public boolean actualizarCompromiso2(String nomCompromiso,String idCompromiso2, String descripcion, String fecha, String correo, String hora) throws Exception {
        ICompromiso2 u = factory.obtenerCompromiso2(false);
        Compromiso2 p = consultarCompromiso2(nomCompromiso,correo, idCompromiso2);
        registrarEstActualizada(descripcion, correo, idCompromiso2, hora, fecha, nomCompromiso);
        return u.actualizarCompromiso2(nomCompromiso,idCompromiso2,descripcion,fecha,correo,hora);
    }

    public boolean registrarCompromiso2(String nomCompromiso,String idCompromiso2, String descripcion, String fecha, String idUsu, String hora) {
        ICompromiso2 u = factory.obtenerCompromiso2(false);
        Compromiso2 c = new Compromiso2(nomCompromiso,idCompromiso2,descripcion,fecha,idUsu,hora);
        registrarEstRegistrada(descripcion, idUsu, idCompromiso2, hora, fecha, nomCompromiso);
        return u.registrarCompromiso2(c);
    }

    public boolean eliminarCompromiso2(String nomCompromiso,String correo, String idCompromiso2) throws Exception {
        ICompromiso2 u = factory.obtenerCompromiso2(false);
        Compromiso2 p = consultarCompromiso2(nomCompromiso,correo, idCompromiso2);
        registrarEstEliminada(p.getDescripcion(), p.getIdUsu(), p.getIdCompromiso2(), p.getHora(), p.getFecha(), nomCompromiso);
        return u.eliminarCompromiso2(nomCompromiso,correo, idCompromiso2);
    }
    
    public boolean consultarCompromiso(String correo, String tipo) throws Exception {
        ICompromiso u = factory.obtenerCompromiso(false);
        return u.consultarCompromiso(correo, tipo);
    }
}
