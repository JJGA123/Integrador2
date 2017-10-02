/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import DTO.Actividad;
import DTO.Estadistica;
import DTO.Tarea;
import java.util.ArrayList;

/**
 *
 * @author Jhon Galvis
 */
public interface IEstadisticas {
    public ArrayList<Estadistica> consultarEstEliminada(String idUsu,String tipo) throws Exception;
    public boolean registrarEstEliminada(Estadistica dto);
    public ArrayList<Estadistica> consultarEstActualizada(String idUsu,String tipo) throws Exception;
    public boolean registrarEstActualizada(Estadistica dto);
    public ArrayList<Estadistica> consultarEstRegistrada(String idUsu,String tipo) throws Exception;
    public boolean registrarEstRegistrada(Estadistica dto);

}
