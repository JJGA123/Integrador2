/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import DTO.Actividad;
import DTO.Compromiso;
import DTO.Compromiso2;
import DTO.Tarea;
import java.util.ArrayList;

/**
 *
 * @author Jhon Galvis
 */
public interface ICompromiso {
    
    public boolean consultarCompromiso(String correo, String tipo) throws Exception;
    
    public ArrayList<Compromiso> consultarCompromisos(String idUsu) throws Exception;

    public boolean registrarCompromiso(Compromiso dto);

    public boolean eliminarCompromiso(String tipo, String idUsu);
    
}
