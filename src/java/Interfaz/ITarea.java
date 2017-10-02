/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import DTO.Tarea;

/**
 *
 * @author Jhon Galvis
 */
public interface ITarea {
    
    public Tarea consultarTarea(String idUsu,String idAct_idTarea, String idTarea) throws Exception;
    public boolean actualizarTarea(String idUsu,String idAct_idTare,String descripcion,String fecha, String idTarea,String hora);
    public boolean registrarTarea(Tarea dto);
    public boolean eliminarTarea(String idUsu,String idAct_idTar,String idTarea);
}
