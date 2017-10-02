/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DTO.Actividad;
import DTO.Cita;
import DTO.Cumpleaños;
import DTO.Negocio;
import Interfaz.IActividad;
import Interfaz.IUsuario;
import DTO.Tarea;
import Factory.Factory;
import DTO.Usuario;
import Interfaz.INegocio;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.font.EAttribute;

/**
 *
 * @author Jhon Galvis
 */
public class Negocio implements INegocio {

    private Factory factory;
    private Usuario usuActual;

    public Negocio() {
        factory = new Factory();
        usuActual = new Usuario();
    }

    public Negocio getNegocio() {
        return this;

    }

    @Override
    public String obtenerNombre() {
        return usuActual.getNombre();
    }

    @Override
    public boolean iniciarSesion(String correo, String contraseña) {
        usuActual = usuActual.getUsuario(correo);
        if (usuActual == null) {
            System.out.println("No existe el usuario");
            return false;
        } else if (usuActual.getUsuario(correo).getContrasena().equalsIgnoreCase(contraseña)) {
            System.out.println("Se inicio");
            return true;
        }
        return false;
    }

    @Override
    public boolean cerrarSesion() {
        usuActual = null;
        return true;
    }

    @Override
    public Tarea consultarTarea(String idAct_idTarea, String idTarea) throws Exception {

        Actividad a1 = usuActual.consultarActividad(usuActual.getCorreo(), idAct_idTarea);
        if (a1 == null) {
            System.out.println("La actividad no existe");
        } else {
            Tarea t = a1.consultarTarea(usuActual.getCorreo(), idAct_idTarea, idTarea);
            System.out.println("id3 : " + t.getIdAct());
            if (t == null) {
                System.out.println("La tarea no existe");
            } else {
                return t;
            }
        }

        return null;
    }

    @Override
    public ArrayList<Tarea> consultarTareas(String idActividad) throws Exception {
        ArrayList<Tarea> t;

        Actividad a1 = usuActual.consultarActividad(usuActual.getCorreo(), idActividad);
        if (a1 == null) {
            System.out.println("La actividad no existe");
        } else {
            t = a1.consultarTares(usuActual.getCorreo(), idActividad);
            if (t == null) {
                System.out.println("No hay tareas");
            } else {
                return t;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Tarea> consultarIntervaloTareas(String fechaMinima, String fechaMayor, String idActividad) throws Exception {
        ArrayList<Tarea> t;
        ArrayList<Tarea> t2 = new ArrayList<>();
        Actividad a1 = usuActual.consultarActividad(usuActual.getCorreo(), idActividad);
        if (a1 == null) {
            System.out.println("La actividad no existe");
        } else {
            t = a1.consultarTares(usuActual.getCorreo(), idActividad);
            if (t == null) {
                System.out.println("No hay tareas");
            } else {
                for (Tarea tarea : t) {
                    if (consultaMinimaFecha(fechaMinima, tarea.getFecha())) {
                        if (consultaMayorFecha(fechaMayor, tarea.getFecha())) {
                            t2.add(tarea);
                        }
                    }
                }
                if (t2.size() >= 1) {
                    return t2;
                } else {
                    System.out.println("No hay fechas dentro de esta rango");
                }
            }
        }
        return null;
    }

    @Override
    public boolean actualizarTarea(String idAct_idTare, String descripcion, String fecha, String idTarea, String hora) {
        try {
            Actividad a1 = usuActual.consultarActividad(usuActual.getCorreo(), idAct_idTare);
            if (a1 == null) {
                System.out.println("La actividad no existe");
            } else {
                Tarea t2 = a1.consultarTarea(usuActual.getCorreo(), idAct_idTare, idTarea);
                if (t2 != null) {
                    boolean t = a1.actualizarTarea(usuActual.getCorreo(), idAct_idTare, descripcion, fecha, idTarea, hora);
                    if (!t) {
                        System.out.println("La tarea no pudo ser actualizada");
                    } else {
                        System.out.println("La tarea fue actualizada");
                        return t;
                    }
                } else {
                    System.out.println("La tarea no existe");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean registrarTarea(String idAct_idTare, String descripcion, String fecha, String hora) {

        try {
            Actividad a1 = usuActual.consultarActividad(usuActual.getCorreo(), idAct_idTare);
            if (a1 == null) {
                System.out.println("La actividad no existe");
            } else {
                String ida = usuActual.actualizarId(usuActual.getCorreo());
                System.out.println("ida " + ida);
                boolean t2 = a1.registrarTarea(usuActual.getCorreo(), idAct_idTare, descripcion, fecha, ida, hora);
                if (!t2) {
                    System.out.println("La tarea no se registro");
                } else {
                    System.out.println("La tarea se registro");
                    return t2;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean eliminarTarea(String idAct_idTar, String idTarea) {

        try {
            Actividad a1 = usuActual.consultarActividad(usuActual.getCorreo(), idAct_idTar);
            if (a1 == null) {
                System.out.println("La actividad no existe");
            } else {
                Tarea t2 = a1.consultarTarea(usuActual.getCorreo(), idAct_idTar, idTarea);
                if (t2 != null) {
                    boolean t = a1.eliminarTarea(usuActual.getCorreo(), idAct_idTar, idTarea);
                    if (!t) {
                        System.out.println("La tarea no se pudo eliminar");
                    } else {
                        System.out.println("La tarea fue eliminar");
                        return t;
                    }
                } else {
                    System.out.println("La tarea no existe");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean registrarUsuario(String nombre, String correo, String contrasena) {

        try {
            Usuario u = new Usuario(nombre, correo, contrasena);
            String u2 = u.consultarUsuario(correo);
            if (!u2.equalsIgnoreCase("")) {
                System.out.println("Este usuario ya existe");
            } else {
                boolean a1 = u.registrarUsuario(nombre, correo, contrasena);
                if (!a1) {
                    System.out.println("No se pudo registrar el usuario");
                    return false;
                } else {
                    System.out.println("El usuario se registro exitosamente");
                    return a1;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public String consultarUsuario() {
        try {
            String a1 = usuActual.consultarUsuario(usuActual.getCorreo());
            if (a1.equalsIgnoreCase("") || a1 == null) {
                System.out.println("El usuario no existe");
            } else {
                System.out.println("El usuario encontrado");
                return a1;
            }
        } catch (Exception ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public boolean actualizarUsuario(String nombre, String contrasena) throws Exception {

        try {
            boolean a1 = usuActual.actualizarUsuario(nombre, usuActual.getCorreo(), contrasena);
            if (!a1) {
                System.out.println("No se pudo actualizar el usuario");
                return false;
            } else {
                System.out.println("El usuario fue actualizado");
                return a1;
            }

        } catch (Exception ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public ArrayList<Actividad> consultarActividades() throws Exception {
        ArrayList<Actividad> t = usuActual.consultarActividades(usuActual.getCorreo());
        if (t == null) {
            System.out.println("El usuario no tiene actividades");
        } else {
            System.out.println("El usuario tiene las actividades");
            return t;
        }
        return null;
    }

    @Override
    public ArrayList<Actividad> consultarIntervaloActividades(String fechaMinima, String fechaMayor) throws Exception {
        ArrayList<Actividad> t = usuActual.consultarActividades(usuActual.getCorreo());
        ArrayList<Actividad> t2 = new ArrayList<>();
        if (t == null) {
            System.out.println("El usuario no tiene actividades");
        } else {
            System.out.println("El usuario tiene las actividades");
            for (Actividad tarea : t) {
                if (consultaMinimaFecha(fechaMinima, tarea.getFecha())) {
                    if (consultaMayorFecha(fechaMayor, tarea.getFecha())) {
                        t2.add(tarea);
                    }
                }
            }
            if (t2.size() >= 1) {
                return t2;
            } else {
                System.out.println("No hay fechas dentro de esta rango");
            }
        }
        return null;
    }

    @Override
    public Actividad consultarActividad(String idActividad) throws Exception {

        Actividad t = usuActual.consultarActividad(usuActual.getCorreo(), idActividad);
        if (t == null) {
            System.out.println("La actividad no existe");
        } else {
            System.out.println("La actividad fue encontrada");
            return t;
        }

        return null;
    }

    @Override
    public boolean actualizarActividad(String descripcion, String fecha, String idActividad, String hora) {
        try {
            Actividad a1 = usuActual.consultarActividad(usuActual.getCorreo(), idActividad);
            if (a1 == null) {
                System.out.println("La actividad no existe");
            } else {
                boolean t = usuActual.actualizarActividad(usuActual.getCorreo(), descripcion, fecha, idActividad, hora);
                if (!t) {
                    System.out.println("La actividad no pudo ser actualizada");
                } else {
                    System.out.println("La acatividad fue actualizada");
                    return t;
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean registrarActividad(String descripcion, String fecha, String hora) {

        try {
            String ida = usuActual.actualizarId(usuActual.getCorreo());
            System.out.println("ida " + ida);
            boolean t = usuActual.registrarActividad(usuActual.getCorreo(), descripcion, fecha, ida, hora);
            if (!t) {
                System.out.println("La actividad no se registro");
            } else {
                System.out.println("La actividad se registro");
                return t;
            }
        } catch (Exception ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean eliminarActividad(String idActividad) {

        try {
            Actividad a1 = usuActual.consultarActividad(usuActual.getCorreo(), idActividad);
            if (a1 != null) {
                boolean t = usuActual.eliminarActividad(usuActual.getCorreo(), idActividad);
                if (!t) {
                    System.out.println("La actividad no se elimino");
                } else {
                    System.out.println("La actividad se elimino");
                    return t;
                }
            } else {
                System.out.println("La actividad ya existe");
            }
        } catch (Exception ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public Cita consultarCita(String idCita) throws Exception {

        Cita t = usuActual.consultarCita(usuActual.getCorreo(), idCita);
        if (t == null) {
            System.out.println("La cita no existe");
        } else {
            System.out.println("La cita fue encontrada");
            return t;
        }

        return null;
    }

    @Override
    public ArrayList<Cita> consultarCitas() throws Exception {
        ArrayList<Cita> t = usuActual.consultarCitas(usuActual.getCorreo());
        if (t == null) {
            System.out.println("El usuario no tiene citas");
        } else {
            System.out.println("El usuario tiene las citas");
            return t;
        }
        return null;
    }

    @Override
    public ArrayList<Cita> consultarIntervaloCitas(String fechaMinima, String fechaMayor) throws Exception {
        ArrayList<Cita> t = usuActual.consultarCitas(usuActual.getCorreo());
        ArrayList<Cita> t2 = new ArrayList<>();
        if (t == null) {
            System.out.println("El usuario no tiene citas");
        } else {
            System.out.println("El usuario tiene las citas");
            for (Cita tarea : t) {
                if (consultaMinimaFecha(fechaMinima, tarea.getFecha())) {
                    if (consultaMayorFecha(fechaMayor, tarea.getFecha())) {
                        t2.add(tarea);
                    }
                }
            }
            if (t2.size() >= 1) {
                return t2;
            } else {
                System.out.println("No hay fechas dentro de esta rango");
            }
        }
        return null;
    }

    @Override
    public boolean actualizarCita(String descripcion, String fecha, String idCita, String hora) {

        try {
            Cita a1 = usuActual.consultarCita(usuActual.getCorreo(), idCita);
            if (a1 == null) {
                System.out.println("La actividad no existe");
            } else {
                boolean t = usuActual.actualizarCita(usuActual.getCorreo(), descripcion, fecha, idCita, hora);
                if (!t) {
                    System.out.println("La cita no pudo ser actualizada");
                } else {
                    System.out.println("La cita fue actualizada");
                    return t;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean registrarCita(String descripcion, String fecha, String hora) {

        try {
            String ida = usuActual.actualizarId(usuActual.getCorreo());
            System.out.println("ida " + ida);
            boolean t = usuActual.registrarCita(usuActual.getCorreo(), descripcion, fecha, ida, hora);
            if (!t) {
                System.out.println("La cita no se registro");
            } else {
                System.out.println("La cita se registro");
                return t;
            }

        } catch (Exception ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean eliminarCita(String idCita) {

        try {
            Cita a1 = usuActual.consultarCita(usuActual.getCorreo(), idCita);
            if (a1 != null) {
                boolean t = usuActual.eliminarCita(usuActual.getCorreo(), idCita);
                if (!t) {
                    System.out.println("La cita no se elimino");
                } else {
                    System.out.println("La cita se elimino");
                    return t;
                }
            } else {
                System.out.println("La cita ya existe");
            }
        } catch (Exception ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public Cumpleaños consultarCumpleaños(String idCumpleaños) throws Exception {

        Cumpleaños t = usuActual.consultarCumpleaños(usuActual.getCorreo(), idCumpleaños);
        if (t == null) {
            System.out.println("La cita no existe");
        } else {
            System.out.println("La cita fue encontrada");
            return t;
        }

        return null;
    }

    @Override
    public ArrayList<Cumpleaños> consultarCumpleaños() throws Exception {
        ArrayList<Cumpleaños> t = usuActual.consultarCumpleaños(usuActual.getCorreo());
        if (t == null) {
            System.out.println("El usuario no tiene citas");
        } else {
            System.out.println("El usuario tiene las citas");
            return t;
        }

        return null;
    }

    @Override
    public ArrayList<Cumpleaños> consultarIntervaloCumpleaños(String fechaMinima, String fechaMayor) throws Exception {
        ArrayList<Cumpleaños> t = usuActual.consultarCumpleaños(usuActual.getCorreo());
        ArrayList<Cumpleaños> t2 = new ArrayList<>();
        if (t == null) {
            System.out.println("El usuario no tiene citas");
        } else {
            System.out.println("El usuario tiene las citas");
            for (Cumpleaños tarea : t) {
                if (consultaMinimaFecha(fechaMinima, tarea.getFecha())) {
                    if (consultaMayorFecha(fechaMayor, tarea.getFecha())) {
                        t2.add(tarea);
                    }
                }
            }
            if (t2.size() >= 1) {
                return t2;
            } else {
                System.out.println("No hay fechas dentro de esta rango");
            }
        }
        return null;
    }

    @Override
    public boolean actualizarCumpleaños(String descripcion, String fecha, String idCumpleaños, String hora) {

        try {
            Cumpleaños a1 = usuActual.consultarCumpleaños(usuActual.getCorreo(), idCumpleaños);
            if (a1 == null) {
                System.out.println("El cumpleaños no existe");
            } else {
                boolean t = usuActual.actualizarCumpleaños(usuActual.getCorreo(), descripcion, fecha, idCumpleaños, hora);
                if (!t) {
                    System.out.println("El cumpleaños no pudo ser actualizada");
                } else {
                    System.out.println("El cumpleaños fue actualizada");
                    return t;
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean registrarCumpleaños(String descripcion, String fecha, String hora) {
        try {
            String ida = usuActual.actualizarId(usuActual.getCorreo());
            System.out.println("ida " + ida);
            boolean t = usuActual.registrarCumpleaños(ida, descripcion, fecha, usuActual.getCorreo(), hora);
            if (!t) {
                System.out.println("El cumple no se registro");
            } else {
                System.out.println("La cita se registro");
                return t;
            }

        } catch (Exception ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean eliminarCumpleaños(String idCumpleaños) {

        try {
            Cumpleaños a1 = usuActual.consultarCumpleaños(usuActual.getCorreo(), idCumpleaños);
            if (a1 != null) {
                boolean t = usuActual.eliminarCumpleaños(usuActual.getCorreo(), idCumpleaños);
                if (!t) {
                    System.out.println("El cumpleaños no se elimino");
                } else {
                    System.out.println("El cumpleaños se elimino");
                    return t;
                }
            } else {
                System.out.println("El cumpleaños ya existe");
            }
        } catch (Exception ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean validarFecha(String fecha) {
        Calendar fechaDes = Calendar.getInstance();
        int dia = fechaDes.get(Calendar.DAY_OF_MONTH);
        int mes = (fechaDes.get(Calendar.MONTH) + 1);
        int año = fechaDes.get(Calendar.YEAR);
        String[] sub = fecha.split("-");
        String[] subDia = sub[2].split("0");
        String[] subMes = sub[1].split("0");
        String dia2 = "";
        String mes2 = "";
        String año2 = "";
        try {
            dia2 = subDia[1];
            try {
                mes2 = subMes[1];
                año2 = sub[0];
            } catch (Exception e3) {
                mes2 = sub[1];
                año2 = sub[0];
            }
        } catch (Exception e) {
            dia2 = sub[2];
            try {
                mes2 = subMes[1];
                año2 = sub[0];
            } catch (Exception e2) {
                mes2 = sub[1];
                año2 = sub[0];
            }
        }
        if (Integer.parseInt(año2) < año) {
            return false;
        } else if (Integer.parseInt(año2) == año) {
            if (Integer.parseInt(mes2) < mes) {
                return false;
            } else if (Integer.parseInt(mes2) == mes) {
                if (Integer.parseInt(dia2) <= dia) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean validarFecha2(String fecha) {
        Calendar fechaDes = Calendar.getInstance();
        int dia = fechaDes.get(Calendar.DAY_OF_MONTH);
        int mes = (fechaDes.get(Calendar.MONTH) + 1);
        int año = fechaDes.get(Calendar.YEAR);
        String[] sub = fecha.split("-");
        String[] subDia = sub[2].split("0");
        String[] subMes = sub[1].split("0");
        String dia2 = "";
        String mes2 = "";
        String año2 = "";
        try {
            dia2 = subDia[1];
            try {
                mes2 = subMes[1];
                año2 = sub[0];
            } catch (Exception e3) {
                mes2 = sub[1];
                año2 = sub[0];
            }
        } catch (Exception e) {
            dia2 = sub[2];
            try {
                mes2 = subMes[1];
                año2 = sub[0];
            } catch (Exception e2) {
                mes2 = sub[1];
                año2 = sub[0];
            }
        }
        if (Integer.parseInt(año2) < año) {
            return false;
        } else if (Integer.parseInt(año2) == año) {
            if (Integer.parseInt(mes2) < mes) {
                return false;
            } else if (Integer.parseInt(mes2) == mes) {
                if (Integer.parseInt(dia2) < dia) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String alarma(String fecha, String hora) {
        Calendar fechaDes = Calendar.getInstance();
        int dia = fechaDes.get(Calendar.DAY_OF_MONTH);
        int mes = (fechaDes.get(Calendar.MONTH) + 1);
        int año = fechaDes.get(Calendar.YEAR);
        String[] sub = fecha.split("-");
        String[] subDia = sub[2].split("0");
        String[] subMes = sub[1].split("0");
        String dia2 = "";
        String mes2 = "";
        String año2 = "";
        try {
            dia2 = subDia[1];
            try {
                mes2 = subMes[1];
                año2 = sub[0];
            } catch (Exception e3) {
                mes2 = sub[1];
                año2 = sub[0];
            }
        } catch (Exception e) {
            dia2 = sub[2];
            try {
                mes2 = subMes[1];
                año2 = sub[0];
            } catch (Exception e2) {
                mes2 = sub[1];
                año2 = sub[0];
            }
        }
        int alarmaDia = 0;
        int alarmaMes = 0;
        int alarmaAño = 0;
        if (Integer.parseInt(año2) == año) {
            if (mes == Integer.parseInt(mes2)) {
                if (dia < Integer.parseInt(dia2)) {
                    alarmaDia = Integer.parseInt(dia2) - dia;
                }
                if (dia > Integer.parseInt(dia2)) {
                    alarmaDia = dia - Integer.parseInt(dia2);
                }
            }
            if (mes < Integer.parseInt(mes2)) {
                alarmaMes = Integer.parseInt(mes2) - mes;
                if (dia < Integer.parseInt(dia2)) {
                    alarmaDia = Integer.parseInt(dia2) - dia;
                }
                if (dia > Integer.parseInt(dia2)) {
                    alarmaDia = dia - Integer.parseInt(dia2);
                }
            }
            if (mes > Integer.parseInt(mes2)) {
                alarmaMes = mes - Integer.parseInt(mes2);
                if (dia < Integer.parseInt(dia2)) {
                    alarmaDia = Integer.parseInt(dia2) - dia;
                }
                if (dia > Integer.parseInt(dia2)) {
                    alarmaDia = dia - Integer.parseInt(dia2);
                }
            }
        }
        if (Integer.parseInt(año2) > año) {
            if (mes == Integer.parseInt(mes2)) {
                alarmaAño = Integer.parseInt(año2) - año;
                if (dia < Integer.parseInt(dia2)) {
                    alarmaDia = Integer.parseInt(dia2) - dia;
                }
                if (dia > Integer.parseInt(dia2)) {
                    alarmaAño--;
                    alarmaMes = 11;
                    if (mes == 2) {
                        alarmaDia = (28 - dia) + Integer.parseInt(dia2);
                        if (alarmaDia > 31) {
                            alarmaMes++;
                            alarmaDia = (31 - alarmaDia) * -1;
                        }
                    }
                    if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                        alarmaDia = (30 - dia) + Integer.parseInt(dia2);
                        if (alarmaDia > 31) {
                            alarmaMes++;
                            alarmaDia = (31 - alarmaDia) * -1;
                        }
                    }
                    if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                        alarmaDia = (31 - dia) + Integer.parseInt(dia2);
                        if (alarmaDia > 31) {
                            alarmaMes++;
                            alarmaDia = (31 - alarmaDia) * -1;
                        }
                    }
                    if (alarmaMes > 11) {
                        alarmaAño++;
                        alarmaMes = (12 - alarmaMes) * (-1);
                    }
                }
            }
            if (mes < Integer.parseInt(mes2)) {
                alarmaAño = (Integer.parseInt(año2) - año) - 1;
                alarmaMes = ((12 - mes) + Integer.parseInt(mes2) - 1);
                if (mes == 2) {
                    alarmaDia = (28 - dia) + Integer.parseInt(dia2);
                    if (alarmaDia > 31) {
                        alarmaMes++;
                        alarmaDia = (31 - alarmaDia) * -1;
                    }
                }
                if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                    alarmaDia = (30 - dia) + Integer.parseInt(dia2);
                    if (alarmaDia > 31) {
                        alarmaMes++;
                        alarmaDia = (31 - alarmaDia) * -1;
                    }
                }
                if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                    alarmaDia = (31 - dia) + Integer.parseInt(dia2);
                    if (alarmaDia > 31) {
                        alarmaMes++;
                        alarmaDia = (31 - alarmaDia) * -1;
                    }
                }
                if (alarmaMes > 11) {
                    alarmaAño++;
                    alarmaMes = (12 - alarmaMes) * (-1);
                }
            }
            if (mes > Integer.parseInt(mes2)) {
                alarmaAño = (Integer.parseInt(año2) - año) - 1;
                alarmaMes = ((12 - mes) + Integer.parseInt(mes2) - 1);
                if (mes == 2) {
                    alarmaDia = (28 - dia) + Integer.parseInt(dia2);
                    if (alarmaDia > 31) {
                        alarmaMes++;
                        alarmaDia = (31 - alarmaDia) * -1;
                    }
                }
                if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                    alarmaDia = (30 - dia) + Integer.parseInt(dia2);
                    if (alarmaDia > 31) {
                        alarmaMes++;
                        alarmaDia = (31 - alarmaDia) * -1;
                    }
                }
                if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                    alarmaDia = (31 - dia) + Integer.parseInt(dia2);
                    if (alarmaDia > 31) {
                        alarmaMes++;
                        alarmaDia = (31 - alarmaDia) * -1;
                    }
                }
                if (alarmaMes > 11) {
                    alarmaAño++;
                    alarmaMes = (12 - alarmaMes) * (-1);
                }
                //            LISTO   

            }
        }
        if (Integer.parseInt(año2) < año) {
            if (mes == Integer.parseInt(mes2)) {
                alarmaAño = (año - Integer.parseInt(año2));
                if (dia < Integer.parseInt(dia2)) {
                    alarmaDia = Integer.parseInt(dia2) - dia;
                }
                if (dia > Integer.parseInt(dia2)) {
                    alarmaAño--;
                    alarmaMes = 11;
                    if (mes == 2) {
                        alarmaDia = (28 - dia) + Integer.parseInt(dia2);
                        if (alarmaDia > 31) {
                            alarmaMes++;
                            alarmaDia = (31 - alarmaDia) * -1;
                        }
                    }
                    if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                        alarmaDia = (30 - dia) + Integer.parseInt(dia2);
                        if (alarmaDia > 31) {
                            alarmaMes++;
                            alarmaDia = (31 - alarmaDia) * -1;
                        }
                    }
                    if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                        alarmaDia = (31 - dia) + Integer.parseInt(dia2);
                        if (alarmaDia > 31) {
                            alarmaMes++;
                            alarmaDia = (31 - alarmaDia) * -1;
                        }
                    }
                    if (alarmaMes > 11) {
                        alarmaAño++;
                        alarmaMes = (12 - alarmaMes) * (-1);
                    }
                }
            }
            if (mes < Integer.parseInt(mes2)) {
                alarmaAño = (año - Integer.parseInt(año2)) - 1;
                alarmaMes = ((12 - mes) + Integer.parseInt(mes2)) - 1;
                if (mes == 2) {
                    alarmaDia = (28 - dia) + Integer.parseInt(dia2);
                    if (alarmaDia > 31) {
                        alarmaMes++;
                        alarmaDia = (31 - alarmaDia) * -1;
                    }
                }
                if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                    alarmaDia = (30 - dia) + Integer.parseInt(dia2);
                    if (alarmaDia > 31) {
                        alarmaMes++;
                        alarmaDia = (31 - alarmaDia) * -1;
                    }
                }
                if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                    alarmaDia = (31 - dia) + Integer.parseInt(dia2);
                    if (alarmaDia > 31) {
                        alarmaMes++;
                        alarmaDia = (31 - alarmaDia) * -1;
                    }
                }
                if (alarmaMes > 11) {
                    alarmaAño++;
                    alarmaMes = (12 - alarmaMes) * (-1);
                }
            }
            if (mes > Integer.parseInt(mes2)) {
                alarmaAño = (año - Integer.parseInt(año2)) - 1;
                alarmaMes = ((12 - mes) + Integer.parseInt(mes2) - 1);
                if (mes == 2) {
                    alarmaDia = (28 - dia) + Integer.parseInt(dia2);
                    if (alarmaDia > 31) {
                        alarmaMes++;
                        alarmaDia = (31 - alarmaDia) * (-1);
                    }
                }
                if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                    alarmaDia = (30 - dia) + Integer.parseInt(dia2);
                    if (alarmaDia > 31) {
                        alarmaMes++;
                        alarmaDia = (31 - alarmaDia) * (-1);
                    }
                }
                if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                    alarmaDia = (31 - dia) + Integer.parseInt(dia2);
                    if (alarmaDia > 31) {
                        alarmaMes++;
                        alarmaDia = (31 - alarmaDia) * (-1);
                    }
                }
                if (alarmaMes > 11) {
                    alarmaAño++;
                    alarmaMes = (12 - alarmaMes) * (-1);
                }
                //            LISTO   

            }
        }
        Calendar calendario = Calendar.getInstance();
        int hora1;
        int minutos;
        hora1 = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        String[] subHor = hora.split(":");
        String[] subHo = subHor[0].split("0");
        String[] subM = subHor[1].split("0");
        String horaS;
        String minS;
        try {
            minS = subM[1];
        } catch (Exception e) {
            minS = subHor[1];
        }
        try {
            horaS = subHo[1];
        } catch (Exception e) {
            horaS = subHor[0];
        }
        if (horaS.equalsIgnoreCase("00")) {
            horaS = "0";
        }
        if (minS.equalsIgnoreCase("00")) {
            minS = "0";
        }
        String alarmaMin = "";
        String alarmaHor = "";

        if (!validarFecha2(fecha)) {
            if (Integer.parseInt(horaS) == hora1) {
                alarmaHor = "" + 0;
                if (Integer.parseInt(minS) == minutos) {
                    alarmaMin = "0";
                }
                if (Integer.parseInt(minS) > minutos) {
                    alarmaMin = "" + (Integer.parseInt(minS) - minutos);
                }
                if (Integer.parseInt(minS) < minutos) {
                    alarmaMin = "" + (minutos - Integer.parseInt(minS));
                    return "Atraso " + alarmaAño + " años, " + alarmaMes + " meses, " + alarmaDia + " dias y " + alarmaHor + " horas, " + alarmaMin+" minutos";
                }
            }
            if (Integer.parseInt(horaS) > hora1) {
                alarmaHor = "" + ((Integer.parseInt(horaS) - hora1) - 1);
                if (Integer.parseInt(minS) == minutos) {
                    alarmaMin = "0";
                    int al2 = Integer.parseInt(alarmaHor);
                    al2++;
                    alarmaHor = "" + al2;
                }
                if (Integer.parseInt(minS) > minutos) {
                    alarmaMin = "" + ((60 - minutos) + Integer.parseInt(minS));
                    if (Integer.parseInt(alarmaMin) > 60) {
                        alarmaMin = "" + (Integer.parseInt(alarmaMin) - 60);
                        int al2 = Integer.parseInt(alarmaHor);
                        al2++;
                        alarmaHor = "" + al2;
                    }

                }
                if (Integer.parseInt(minS) < minutos) {
                    alarmaMin = "" + ((60 - minutos) + Integer.parseInt(minS));
                    if (Integer.parseInt(alarmaMin) > 60) {
                        alarmaMin = "" + (Integer.parseInt(alarmaMin) - 60);
                        int al2 = Integer.parseInt(alarmaHor);
                        al2++;
                        alarmaHor = "" + al2;
                    }
                }
            }
            if (Integer.parseInt(horaS) < hora1) {
                alarmaHor = "" + ((hora1 - Integer.parseInt(horaS)) - 1);
                if (Integer.parseInt(minS) == minutos) {
                    int al2 = Integer.parseInt(alarmaHor);
                    al2++;
                    alarmaHor = "" + al2;
                    alarmaMin = "0";
                }
                if (Integer.parseInt(minS) > minutos) {
                    alarmaMin = "" + ((60 - minutos) + Integer.parseInt(minS));
                    if (Integer.parseInt(alarmaMin) > 60) {
                        alarmaMin = "" + (Integer.parseInt(alarmaMin) - 60);
                        int al2 = Integer.parseInt(alarmaHor);
                        al2++;
                        alarmaHor = "" + al2;
                    }
                }
                if (Integer.parseInt(minS) < minutos) {
                    alarmaMin = "" + ((60 - minutos) + Integer.parseInt(minS));
                    if (Integer.parseInt(alarmaMin) > 60) {
                        alarmaMin = "" + (Integer.parseInt(alarmaMin) - 60);
                        int al2 = Integer.parseInt(alarmaHor);
                        al2++;
                        alarmaHor = "" + al2;
                    }
                }
            }
            if (alarmaAño == 0 & alarmaMes == 0 & alarmaDia == 0) {
                return "Atraso " + alarmaAño + " años, " + alarmaMes + " meses, " + alarmaDia + " dias y " + alarmaHor + " horas, " + alarmaMin+" minutos";
            }
        }
        if (Integer.parseInt(horaS) == hora1) {
            alarmaHor = "" + 0;
            if (Integer.parseInt(minS) == minutos) {
                alarmaMin = "0";
            }
            if (Integer.parseInt(minS) > minutos) {
                alarmaMin = "" + (Integer.parseInt(minS) - minutos);
            }
            if (Integer.parseInt(minS) < minutos) {
                alarmaMin = "" + (minutos - Integer.parseInt(minS));
                return "Atraso " + alarmaAño + " años, " + alarmaMes + " meses, " + alarmaDia + " dias y " + alarmaHor + " horas, " + alarmaMin+" minutos";
            }
        }
        if (Integer.parseInt(horaS) > hora1) {
            alarmaHor = "" + ((Integer.parseInt(horaS) - hora1) - 1);
            if (Integer.parseInt(minS) == minutos) {
                alarmaMin = "0";
                int al2 = Integer.parseInt(alarmaHor);
                al2++;
                alarmaHor = "" + al2;
            }
            if (Integer.parseInt(minS) > minutos) {
                alarmaMin = "" + ((60 - minutos) + Integer.parseInt(minS));
                if (Integer.parseInt(alarmaMin) > 60) {
                    alarmaMin = "" + (Integer.parseInt(alarmaMin) - 60);
                    int al2 = Integer.parseInt(alarmaHor);
                    al2++;
                    alarmaHor = "" + al2;
                }

            }
            if (Integer.parseInt(minS) < minutos) {
                alarmaMin = "" + ((60 - minutos) + Integer.parseInt(minS));
                if (Integer.parseInt(alarmaMin) > 60) {
                    alarmaMin = "" + (Integer.parseInt(alarmaMin) - 60);
                    int al2 = Integer.parseInt(alarmaHor);
                    al2++;
                    alarmaHor = "" + al2;
                }
            }
        }
        if (Integer.parseInt(horaS) < hora1) {
            alarmaHor = "" + ((hora1 - Integer.parseInt(horaS)) - 1);
            if (Integer.parseInt(minS) == minutos) {
                int al2 = Integer.parseInt(alarmaHor);
                al2++;
                alarmaHor = "" + al2;
                alarmaMin = "0";
            }
            if (Integer.parseInt(minS) > minutos) {
                alarmaMin = "" + ((60 - minutos) + Integer.parseInt(minS));
                if (Integer.parseInt(alarmaMin) > 60) {
                    alarmaMin = "" + (Integer.parseInt(alarmaMin) - 60);
                    int al2 = Integer.parseInt(alarmaHor);
                    al2++;
                    alarmaHor = "" + al2;
                }
            }
            if (Integer.parseInt(minS) < minutos) {
                alarmaMin = "" + ((60 - minutos) + Integer.parseInt(minS));
                if (Integer.parseInt(alarmaMin) > 60) {
                    alarmaMin = "" + (Integer.parseInt(alarmaMin) - 60);
                    int al2 = Integer.parseInt(alarmaHor);
                    al2++;
                    alarmaHor = "" + al2;
                }

            }
            if (alarmaAño == 0 & alarmaMes == 0 & alarmaDia == 0) {
                return "Atraso " + alarmaAño + " años, " + alarmaMes + " meses, " + alarmaDia + " dias y " + alarmaHor + " horas, " + alarmaMin+" minutos";
            }
        }
        return alarmaAño + " años, " + alarmaMes + " meses, " + alarmaDia + " dias y " + alarmaHor + " horas, " + alarmaMin+" minutos";
    }

    @Override
    public boolean consultaMinimaFecha(String fechaMenor, String fecha) {
        String[] sub = fechaMenor.split("-");
        String[] subDia = sub[2].split("0");
        String[] subMes = sub[1].split("0");
        String dia = "";
        String mes = "";
        String año = "";
        try {
            dia = subDia[1];
            try {
                mes = subMes[1];
                año = sub[0];
            } catch (Exception e3) {
                mes = sub[1];
                año = sub[0];
            }
        } catch (Exception e) {
            dia = sub[2];
            try {
                mes = subMes[1];
                año = sub[0];
            } catch (Exception e2) {
                mes = sub[1];
                año = sub[0];
            }
        }
        String[] sub2 = fecha.split("-");
        String[] subDia2 = sub[2].split("0");
        String[] subMes2 = sub[1].split("0");
        String dia2 = "";
        String mes2 = "";
        String año2 = "";
        try {
            dia2 = subDia2[1];
            try {
                mes2 = subMes2[1];
                año2 = sub2[0];
            } catch (Exception e3) {
                mes2 = sub2[1];
                año2 = sub2[0];
            }
        } catch (Exception e) {
            dia2 = sub2[2];
            try {
                mes2 = subMes2[1];
                año2 = sub2[0];
            } catch (Exception e2) {
                mes2 = sub2[1];
                año2 = sub2[0];
            }
        }
        if (Integer.parseInt(año2) < Integer.parseInt(año)) {
            return false;
        } else if (Integer.parseInt(año2) == Integer.parseInt(año)) {
            if (Integer.parseInt(mes2) < Integer.parseInt(mes)) {
                return false;
            } else if (Integer.parseInt(mes2) == Integer.parseInt(mes)) {
                if (Integer.parseInt(dia2) < Integer.parseInt(dia)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean consultaMayorFecha(String fechaMayor, String fecha) {
        String[] sub = fechaMayor.split("-");
        String[] subDia = sub[2].split("0");
        String[] subMes = sub[1].split("0");
        String dia = "";
        String mes = "";
        String año = "";
        try {
            dia = subDia[1];
            try {
                mes = subMes[1];
                año = sub[0];
            } catch (Exception e3) {
                mes = sub[1];
                año = sub[0];
            }
        } catch (Exception e) {
            dia = sub[2];
            try {
                mes = subMes[1];
                año = sub[0];
            } catch (Exception e2) {
                mes = sub[1];
                año = sub[0];
            }
        }
        String[] sub2 = fecha.split("-");
        String[] subDia2 = sub2[2].split("0");
        String[] subMes2 = sub2[1].split("0");
        String dia2 = "";
        String mes2 = "";
        String año2 = "";
        try {
            dia2 = subDia2[1];
            try {
                mes2 = subMes2[1];
                año2 = sub2[0];
            } catch (Exception e3) {
                mes2 = sub2[1];
                año2 = sub2[0];
            }
        } catch (Exception e) {
            dia2 = sub2[2];
            try {
                mes2 = subMes2[1];
                año2 = sub2[0];
            } catch (Exception e2) {
                mes2 = sub2[1];
                año2 = sub2[0];
            }
        }
        if (Integer.parseInt(año2) > Integer.parseInt(año)) {
            return false;
        } else if (Integer.parseInt(año2) == Integer.parseInt(año)) {
            if (Integer.parseInt(mes2) > Integer.parseInt(mes)) {
                return false;
            } else if (Integer.parseInt(mes2) == Integer.parseInt(mes)) {
                if (Integer.parseInt(dia2) > Integer.parseInt(dia)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public ArrayList<Entrevista> consultarEntrevistas() throws Exception {
        ArrayList<Entrevista> t = usuActual.consultarEntrevistas(usuActual.getCorreo());
        if (t == null) {
            System.out.println("El usuario no tiene entrevistas");
        } else {
            System.out.println("El usuario tiene las entrevistas");
            return t;
        }
        return null;
    }

    @Override
    public ArrayList<Entrevista> consultarIntervaloEntrevistas(String fechaMinima, String fechaMayor) throws Exception {
        ArrayList<Entrevista> t = usuActual.consultarEntrevistas(usuActual.getCorreo());
        ArrayList<Entrevista> t2 = new ArrayList<>();
        if (t == null) {
            System.out.println("El usuario no tiene entrevistas");
        } else {
            System.out.println("El usuario tiene las entrevistas");
            for (Entrevista tarea : t) {
                if (consultaMinimaFecha(fechaMinima, tarea.getFecha())) {
                    if (consultaMayorFecha(fechaMayor, tarea.getFecha())) {
                        t2.add(tarea);
                    }
                }
            }
            if (t2.size() >= 1) {
                return t2;
            } else {
                System.out.println("No hay fechas dentro de esta rango");
            }
        }
        return null;
    }

    @Override
    public Entrevista consultarEntrevista(String idEntrevista) throws Exception {
        Entrevista t = usuActual.consultarEntrevista(usuActual.getCorreo(), idEntrevista);
        if (t == null) {
            System.out.println("La entrevista no existe");
        } else {
            System.out.println("La entrevista fue encontrada");
            return t;
        }

        return null;
    }

    @Override
    public boolean actualizarEntrevista(String descripcion, String fecha, String idEntrevista, String hora) {
        try {
            Entrevista a1 = usuActual.consultarEntrevista(usuActual.getCorreo(), idEntrevista);
            if (a1 == null) {
                System.out.println("La actividad no existe");
            } else {
                boolean t = usuActual.actualizarEntrevista(usuActual.getCorreo(), descripcion, fecha, idEntrevista, hora);
                if (!t) {
                    System.out.println("La actividad no pudo ser entrevista");
                } else {
                    System.out.println("La acatividad fue entrevista");
                    return t;
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean registrarEntrevista(String descripcion, String fecha, String hora) {
        try {
            String ida = usuActual.actualizarId(usuActual.getCorreo());
            System.out.println("ida " + ida);
            boolean t = usuActual.registrarEntrevista(usuActual.getCorreo(), descripcion, fecha, ida, hora);
            if (!t) {
                System.out.println("La entrevista no se registro");
            } else {
                System.out.println("La entrevista se registro");
                return t;
            }
        } catch (Exception ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean eliminarEntrevista(String idEntrevista) {
        try {
            Entrevista a1 = usuActual.consultarEntrevista(usuActual.getCorreo(), idEntrevista);
            if (a1 != null) {
                boolean t = usuActual.eliminarEntrevista(usuActual.getCorreo(), idEntrevista);
                if (!t) {
                    System.out.println("La Entrevista no se elimino");
                } else {
                    System.out.println("La Entrevista se elimino");
                    return t;
                }
            } else {
                System.out.println("La Entrevista ya existe");
            }
        } catch (Exception ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public ArrayList<Paseo> consultarPaseos() throws Exception {
        ArrayList<Paseo> t = usuActual.consultarPaseos(usuActual.getCorreo());
        if (t == null) {
            System.out.println("El usuario no tiene Paseo");
        } else {
            System.out.println("El usuario tiene las Paseo");
            return t;
        }
        return null;
    }

    @Override
    public ArrayList<Paseo> consultarIntervaloPaseos(String fechaMinima, String fechaMayor) throws Exception {
        ArrayList<Paseo> t = usuActual.consultarPaseos(usuActual.getCorreo());
        ArrayList<Paseo> t2 = new ArrayList<>();
        if (t == null) {
            System.out.println("El usuario no tiene Paseo");
        } else {
            System.out.println("El usuario tiene las Paseo");
            for (Paseo tarea : t) {
                if (consultaMinimaFecha(fechaMinima, tarea.getFecha())) {
                    if (consultaMayorFecha(fechaMayor, tarea.getFecha())) {
                        t2.add(tarea);
                    }
                }
            }
            if (t2.size() >= 1) {
                return t2;
            } else {
                System.out.println("No hay fechas dentro de esta rango");
            }
        }
        return null;
    }

    @Override
    public Paseo consultarPaseo(String idPaseo) throws Exception {
        Paseo t = usuActual.consultarPaseo(usuActual.getCorreo(), idPaseo);
        if (t == null) {
            System.out.println("La Paseo no existe");
        } else {
            System.out.println("La Paseo fue encontrada");
            return t;
        }
        return null;
    }

    @Override
    public boolean actualizarPaseo(String descripcion, String fecha, String idPaseo, String hora) {
        try {
            Paseo a1 = usuActual.consultarPaseo(usuActual.getCorreo(), idPaseo);
            if (a1 == null) {
                System.out.println("La actividad no existe");
            } else {
                boolean t = usuActual.actualizarPaseo(usuActual.getCorreo(), descripcion, fecha, idPaseo, hora);
                if (!t) {
                    System.out.println("La Paseo no pudo ser entrevista");
                } else {
                    System.out.println("La Paseo fue entrevista");
                    return t;
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean registrarPaseo(String descripcion, String fecha, String hora) {
        try {
            String ida = usuActual.actualizarId(usuActual.getCorreo());
            System.out.println("ida " + ida);
            boolean t = usuActual.registrarPaseo(usuActual.getCorreo(), descripcion, fecha, ida, hora);
            if (!t) {
                System.out.println("La Paseo no se registro");
            } else {
                System.out.println("La Paseo se registro");
                return t;
            }
        } catch (Exception ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean eliminarPaseo(String idPaseo) {
        try {
            Paseo a1 = usuActual.consultarPaseo(usuActual.getCorreo(), idPaseo);
            if (a1 != null) {
                boolean t = usuActual.eliminarPaseo(usuActual.getCorreo(), idPaseo);
                if (!t) {
                    System.out.println("La Paseo no se elimino");
                } else {
                    System.out.println("La Paseo se elimino");
                    return t;
                }
            } else {
                System.out.println("La Paseo ya existe");
            }
        } catch (Exception ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public ArrayList<Estadistica> consultarEstEliminada(String tipo) throws Exception {
        ArrayList<Estadistica> t = usuActual.consultarEstEliminada(usuActual.getCorreo(), tipo);
        if (t == null) {
            System.out.println("El usuario no tiene Paseo");
        } else {
            System.out.println("El usuario tiene las Paseo");
            return t;
        }
        return null;
    }

    @Override
    public ArrayList<Estadistica> consultarEstActualizada(String tipo) throws Exception {
        ArrayList<Estadistica> t = usuActual.consultarEstActualizada(usuActual.getCorreo(), tipo);
        if (t == null) {
            System.out.println("El usuario no tiene Paseo");
        } else {
            System.out.println("El usuario tiene las Paseo");
            return t;
        }
        return null;
    }

    @Override
    public ArrayList<Estadistica> consultarEstRegistrada(String tipo) throws Exception {
        ArrayList<Estadistica> t = usuActual.consultarEstRegistrada(usuActual.getCorreo(), tipo);
        if (t == null) {
            System.out.println("El usuario no tiene Paseo");
        } else {
            System.out.println("El usuario tiene las Paseo");
            return t;
        }
        return null;
    }

    @Override
    public ArrayList<Compromiso> consultarCompromisos() throws Exception {
        System.out.println(usuActual.getCorreo());
        ArrayList<Compromiso> t = usuActual.consultarCompromisos(usuActual.getCorreo());
        if (t == null) {
            System.out.println("El usuario no tiene entrevistas");
        } else {
            System.out.println("El usuario tiene las entrevistas");
            return t;
        }
        return null;
    }

    @Override
    public boolean registrarCompromiso(String tipo) {
        try {
            boolean t = usuActual.registrarCompromiso(tipo, usuActual.getCorreo());
            if (!t) {
                System.out.println("El cumple no se registro");
            } else {
                System.out.println("La cita se registro");
                return t;
            }

        } catch (Exception ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminarCompromiso(String tipo) {
        try {
            boolean t = usuActual.eliminarCompromiso(tipo, usuActual.getCorreo());
            if (!t) {
                System.out.println("La Entrevista no se elimino");
            } else {
                System.out.println("La Entrevista se elimino");
                return t;
            }
        } catch (Exception ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public ArrayList<Compromiso2> consultarCompromisos2(String nomCompromiso) throws Exception {
        if(!usuActual.consultarCompromiso(usuActual.getCorreo(),nomCompromiso)){
                return null;
        }
        ArrayList<Compromiso2> t = usuActual.consultarCompromisos2(nomCompromiso,usuActual.getCorreo());
        if (t == null) {
            System.out.println("El usuario no tiene entrevistas");
        } else {
            System.out.println("El usuario tiene las entrevistas");
            return t;
        }
        return null;
    }
    
    @Override
    public ArrayList<Compromiso2> consultarIntervaloCompromiso2(String nomCompromiso,String fechaMinima, String fechaMayor) throws Exception {
        if(!usuActual.consultarCompromiso(usuActual.getCorreo(),nomCompromiso)){
                return null;
        }
        ArrayList<Compromiso2> t = usuActual.consultarCompromisos2(nomCompromiso,usuActual.getCorreo());
        ArrayList<Compromiso2> t2 = new ArrayList<>();
        if (t == null) {
            System.out.println("El usuario no tiene citas");
        } else {
            System.out.println("El usuario tiene las citas");
            for (Compromiso2 tarea : t) {
                if (consultaMinimaFecha(fechaMinima, tarea.getFecha())) {
                    if (consultaMayorFecha(fechaMayor, tarea.getFecha())) {
                        t2.add(tarea);
                    }
                }
            }
            if (t2.size() >= 1) {
                return t2;
            } else {
                System.out.println("No hay fechas dentro de esta rango");
            }
        }
        return null;
    }

    @Override
    public Compromiso2 consultarCompromiso2(String nomCompromiso,String idCompromiso2) throws Exception {
        if(!usuActual.consultarCompromiso(usuActual.getCorreo(),nomCompromiso)){
                return null;
        }
        Compromiso2 t = usuActual.consultarCompromiso2(nomCompromiso,usuActual.getCorreo(), idCompromiso2);
        if (t == null) {
            System.out.println("La entrevista no existe");
        } else {
            System.out.println("La entrevista fue encontrada");
            return t;
        }
        return null;
    }

    @Override
    public boolean actualizarCompromiso2(String nomCompromiso,String idCompromiso2, String descripcion, String fecha, String hora) {
        try {
            if(!usuActual.consultarCompromiso(usuActual.getCorreo(),nomCompromiso)){
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Compromiso2 a1 = usuActual.consultarCompromiso2(nomCompromiso,usuActual.getCorreo(), idCompromiso2);
            if (a1 == null) {
                System.out.println("El cumpleaños no existe");
            } else {
                boolean t = usuActual.actualizarCompromiso2(nomCompromiso, idCompromiso2,  descripcion,  fecha, usuActual.getCorreo(),  hora);
                if (!t) {
                    System.out.println("El cumpleaños no pudo ser actualizada");
                } else {
                    System.out.println("El cumpleaños fue actualizada");
                    return t;
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean registrarCompromiso2(String nomCompromiso,String descripcion, String fecha, String hora) {
        try {
            if(!usuActual.consultarCompromiso(usuActual.getCorreo(),nomCompromiso)){
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String ida = usuActual.actualizarId(usuActual.getCorreo());
            System.out.println("ida " + ida);
            boolean t = usuActual.registrarCompromiso2(nomCompromiso,ida, descripcion, fecha, usuActual.getCorreo(), hora);
            if (!t) {
                System.out.println("El cumple no se registro");
            } else {
                System.out.println("La cita se registro");
                return t;
            }

        } catch (Exception ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean eliminarCompromiso2(String nomCompromiso,String idCompromiso2) {
        try {
            if(!usuActual.consultarCompromiso(usuActual.getCorreo(),nomCompromiso)){
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Compromiso2 a1 = usuActual.consultarCompromiso2(nomCompromiso,usuActual.getCorreo(), idCompromiso2);
            if (a1 != null) {
                boolean t = usuActual.eliminarCompromiso2(nomCompromiso,usuActual.getCorreo(), idCompromiso2);
                if (!t) {
                    System.out.println("El cumpleaños no se elimino");
                } else {
                    System.out.println("El cumpleaños se elimino");
                    return t;
                }
            } else {
                System.out.println("El cumpleaños ya existe");
            }
        } catch (Exception ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
    public static void main(String[] args) throws Exception {
        Negocio n = new Negocio();
        n.iniciarSesion("jhongalvis@gmail.com", "1234.");
        ArrayList<Estadistica> e = n.consultarEstEliminada("Compromiso");
        System.out.println(e);
        for(Estadistica e1 : e){
            System.out.println(e1.toString());
            
            System.out.println("tipooooooooooooooooooooooooooooooooo "+e1.getTipo());
            System.out.println(e1.getId());
        }
    }
}
