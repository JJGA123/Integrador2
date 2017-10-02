/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Interfaz.IUsuario;
import DAO.MySQLActividadDAO;
import DAO.MySQLUsuarioDAO;
import Interfaz.IActividad;
import Interfaz.ICita;
import Interfaz.ICumpleaños;
import Interfaz.ITarea;
import DAO.MySQLCitaDAO;
import DAO.MySQLCompromiso2DAO;
import DAO.MySQLCompromisoDAO;
import DAO.MySQLCumpleañosDAO;
import DAO.MySQLEntrevistaDAO;
import DAO.MySQLEstadisticaDAO;
import DAO.MySQLPaseoDAO;
import DAO.MySQLTareaDAO;
import DTO.Compromiso;
import Interfaz.ICompromiso;
import Interfaz.ICompromiso2;
import Interfaz.IEntrevista;
import Interfaz.IEstadisticas;
import Interfaz.IPaseo;

/**
 *
 * @author Jhon Galvis
 */
public class Factory {

    public IUsuario obtenerUsuario(boolean keepConnection) {
        return new MySQLUsuarioDAO(keepConnection);
    }

    public IActividad obtenerActividad(boolean keepConnection) {
        return new MySQLActividadDAO(keepConnection);
    }

    public ITarea obtenerTarea(boolean keepConnection) {
        return new MySQLTareaDAO(keepConnection);
    }

    public ICita obtenerCita(boolean keepConnection) {
        return new MySQLCitaDAO(keepConnection);
    }

    public ICumpleaños obtenerCumpleaños(boolean keepConnection) {
        return new MySQLCumpleañosDAO(keepConnection);
    }
    
    public IEntrevista obtenerEntrevista(boolean keepConnection) {
        return new MySQLEntrevistaDAO(keepConnection);
    }
    
    public IPaseo obtenerPaseo(boolean keepConnection) {
        return new MySQLPaseoDAO(keepConnection);
    }
    
    public IEstadisticas obtenerEstadistica(boolean keepConnection) {
        return new MySQLEstadisticaDAO(keepConnection);
    }

    public ICompromiso obtenerCompromiso(boolean keepConnection) {
        return new MySQLCompromisoDAO(keepConnection);
    }
    
    public ICompromiso2 obtenerCompromiso2(boolean keepConnection) {
        return new MySQLCompromiso2DAO(keepConnection);
    }
}
