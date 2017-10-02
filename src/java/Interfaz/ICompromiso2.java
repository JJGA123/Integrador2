/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import DTO.Actividad;
import DTO.Compromiso2;
import DTO.Tarea;
import java.util.ArrayList;

/**
 *
 * @author Jhon Galvis
 */
public interface ICompromiso2 {

    public ArrayList<Compromiso2> consultarCompromisos2(String nomCompromiso,String idUsu) throws Exception;
    
    public Compromiso2 consultarCompromiso2(String nomCompromiso,String correo, String idCompromiso2) throws Exception;

    public boolean actualizarCompromiso2(String nomCompromiso,String idCompromiso2, String descripcion, String fecha,String correo, String hora);
    
    public boolean registrarCompromiso2(Compromiso2 dto);

    public boolean eliminarCompromiso2(String nomCompromiso,String correo, String idCompromiso2);
}
