/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import DTO.Actividad;
import DTO.Cita;
import DTO.Cumpleaños;
import DTO.Entrevista;
import DTO.Paseo;
import DTO.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jhon Galvis
 */
public interface IUsuario {

    public String idActual(String correo);

    public boolean actualizarId(String correo, String id);

    public boolean registrarUsuario(Usuario dto);

    public Usuario consultarUsuario(String correo);

    public boolean actualizarUsuario(String nombre, String correo, String contraseña) throws Exception;

    public ArrayList<Actividad> consultarActividades(String idUsu) throws Exception;

    public ArrayList<Cita> consultarCitas(String idUsu) throws Exception;

    public ArrayList<Cumpleaños> consultarCumpleaños(String idCumpleaños) throws Exception;
    
    public ArrayList<Entrevista> consultarEntrevistas(String idUsu) throws Exception;

    public ArrayList<Paseo> consultarPaseos(String idUsu) throws Exception;
    

}
