/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import DTO.Cita;

/**
 *
 * @author Jhon Galvis
 */
public interface ICita {
    public Cita consultarCita(String correo, String idCita) throws Exception;
    public boolean actualizarCita(String correo,String descripcion,String fecha, String idCita,String hora);
    public boolean registrarCita(Cita dto);
    public boolean eliminarCita(String correo,String idCita);
}
