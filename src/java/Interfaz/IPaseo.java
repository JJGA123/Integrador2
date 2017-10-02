/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import DTO.Cita;
import DTO.Paseo;

/**
 *
 * @author Jhon Galvis
 */
public interface IPaseo {
    public Paseo consultarPaseo(String correo, String idPaseo) throws Exception;
    public boolean actualizarPaseo(String correo,String descripcion,String fecha, String idPaseo,String hora);
    public boolean registrarPaseo(Paseo dto);
    public boolean eliminarPaseo(String correo,String idPaseo);
}
