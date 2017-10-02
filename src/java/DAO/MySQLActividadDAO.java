/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaz.IActividad;
import DTO.Actividad;
import DTO.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import DTO.Tarea;

/**
 *
 * @author Jhon Galvis
 */
public class MySQLActividadDAO implements IActividad {

    private Connection conn;
    private String DRIVER = "org.gjt.mm.mysql.Driver";
    private String DBURL = "jdbc:mysql://localhost/integrador";
    private String USER = "root";
    private String PASS = "";
    public boolean keepConnection;

    public MySQLActividadDAO(boolean keepConnection) {
        this.keepConnection = keepConnection;
        try {
            Class.forName(DRIVER).newInstance();
            conn = DriverManager.getConnection(DBURL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public ArrayList<Tarea> consultarTares(String idUsu,String idActividad) throws Exception {
        ArrayList<Tarea> lista = null;
        try {
            String selectStatement = "SELECT idTarea,idAct_idTare,idUsu,descripcion,fecha,hora FROM tarea where idAct_idTare='" + idActividad + "' AND idUsu='"+idUsu+"'";
            PreparedStatement prepStmt = conn.prepareStatement(selectStatement);
            ResultSet rs = prepStmt.executeQuery();
            lista = new ArrayList<Tarea>();
            while (rs.next()) {
                Tarea n = new Tarea();
                n.setIdTarea(rs.getString(1));
                n.setIdAct(rs.getString(2));
                n.setIdUsu(rs.getString(3));
                n.setDescripcion(rs.getString(4));
                n.setFecha(rs.getString(5));
                n.setHora(rs.getString(6));
                System.out.println("Tarea:" + n.getDescripcion() + " fecha:" + n.getFecha());
                lista.add(n);
            }
            rs.close();
        } catch (Exception e) {
            lista = null;
            throw new Exception(e);
        } finally {
            if (!keepConnection) {
                if (conn != null) {
                    conn.close();
                }
            }
        }
        return lista;
    }

    @Override
    public Actividad consultarActividad(String correo, String idActividad) throws Exception {
        Actividad dto = null;
        
        try {
            String selectStatement = "SELECT descripcion,idUsu,idActividad,fecha,hora FROM actividad where idUsu='" + correo + "' AND idActividad='" + idActividad + "'";
            PreparedStatement prepStmt = conn.prepareStatement(selectStatement);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                dto = new Actividad();
                dto.setDescripcion(rs.getString(1));
                dto.setIdUsu(rs.getString(2));
                dto.setIdActividad(rs.getString(3));
                dto.setFecha(rs.getString(4));
                dto.setHora(rs.getString(5));
            }
            rs.close();
            System.out.println("correo "+correo+" idAct "+idActividad);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                throw new Exception(e);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } finally {
            if (!keepConnection) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MySQLUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        System.out.println("correo "+dto.getIdUsu());
        return dto;
    }

    @Override
    public boolean actualizarActividad(String correo, String descripcion, String fecha, String idActividad,String hora) {
        PreparedStatement stmt = null;
        boolean ok = false;
        try {
            if (!descripcion.equalsIgnoreCase("") & !fecha.equalsIgnoreCase("")) {
                stmt = conn.prepareStatement("UPDATE actividad SET descripcion='" + descripcion + "', fecha='" + fecha + "', hora='" + hora +"' WHERE idUsu='" + correo + "' AND idActividad='"+idActividad+"'");
                stmt.executeUpdate();
                ok = true;
            } else {
                System.out.println("Ingrese los valores que se le piden por favor, la actualizacion no puede tener campos vacios");
                ok = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("errooo!!");
        } finally {
            if (!keepConnection) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MySQLUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return ok;
    }

    @Override
    public boolean registrarActividad(Actividad dto) {
        boolean exito = false;
        try {
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("INSERT INTO actividad (descripcion,idUsu,idActividad,fecha,hora) values (?,?,?,?,?)");
            System.out.println(dto.getIdUsu());
            stmt.setString(1, dto.getDescripcion());
            stmt.setString(2, dto.getIdUsu());
            stmt.setString(3, dto.getIdActividad());
            stmt.setString(4, dto.getFecha());
            stmt.setString(5, dto.getHora());
            int total = stmt.executeUpdate();
            if (total > 0) {
                exito = true;
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MySQLUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (!keepConnection) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MySQLUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return exito;
    }

    @Override
    public boolean eliminarActividad(String correo, String actividad) {
        PreparedStatement stmt = null;
        boolean ok = false;
        try {
            stmt = conn.prepareStatement("DELETE FROM actividad WHERE idUsu='" + correo + "' AND idActividad='" + actividad + "'");
            stmt.executeUpdate();
            ok = true;
            System.out.println("ok");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("errooo!!");
        } finally {
            if (!keepConnection) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MySQLUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return ok;
    }
    

}
