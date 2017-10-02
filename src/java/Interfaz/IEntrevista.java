/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import DTO.Cita;
import DTO.Entrevista;

/**
 *
 * @author Jhon Galvis
 */
public interface IEntrevista {
    public Entrevista consultarEntrevista(String correo, String idEntrevista) throws Exception;
    public boolean actualizarEntrevista(String correo,String descripcion,String fecha, String idEntrevista,String hora);
    public boolean registrarEntrevista(Entrevista dto);
    public boolean eliminarEntrevista(String correo,String idEntrevista);
}
