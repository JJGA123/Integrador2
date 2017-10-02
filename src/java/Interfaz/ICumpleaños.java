/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import DTO.Cumpleaños;

/**
 *
 * @author Jhon Galvis
 */
public interface ICumpleaños {

    public Cumpleaños consultarCumpleaños(String correo, String idCumpleaños) throws Exception;

    public boolean actualizarCumpleaños(String correo, String descripcion, String fecha, String idCumpleaños,String hora);

    public boolean registrarCumpleaños(Cumpleaños dto);

    public boolean eliminarCumpleaños(String correo, String idCumpleaños);
}
