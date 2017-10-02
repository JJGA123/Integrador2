/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaz.ICita;
import DTO.Cita;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jhon Galvis
 */
public class MySQLCitaDAO implements ICita{
    
    private Connection conn;
    private String DRIVER = "org.gjt.mm.mysql.Driver";
    private String DBURL = "jdbc:mysql://localhost/integrador";
    private String USER = "root";
    private String PASS = "";
    public boolean keepConnection;

    public MySQLCitaDAO(boolean keepConnection) {
        this.keepConnection = keepConnection;
        try {
            Class.forName(DRIVER).newInstance();
            conn = DriverManager.getConnection(DBURL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Cita consultarCita(String correo, String idCita) throws Exception {
        Cita dto = null;
        try {
            String selectStatement = "SELECT idCita,idUsu,descripcion,fecha,hora FROM cita where idUsu='" + correo + "' AND idCita='" + idCita + "'";
            PreparedStatement prepStmt = conn.prepareStatement(selectStatement);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                dto = new Cita();
                dto.setIdCita(rs.getString(1));
                dto.setIdUsu(rs.getString(2));
                dto.setDescripcion(rs.getString(3));
                dto.setFecha(rs.getString(4));
                dto.setHora(rs.getString(5));
            }
            rs.close();
        } catch (Exception e) {
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
        return dto;
    }

    

    @Override
    public boolean actualizarCita(String correo, String descripcion, String fecha, String idCita,String hora) {
        PreparedStatement stmt = null;
        boolean ok = false;
        try {
            if (!descripcion.equalsIgnoreCase("") & !fecha.equalsIgnoreCase("")) {
                stmt = conn.prepareStatement("UPDATE cita SET descripcion='" + descripcion + "', fecha='" + fecha + "', hora='" + hora +"' WHERE idUsu='" + correo + "' AND idCita='" + idCita + "'");
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
    public boolean registrarCita(Cita dto) {
        boolean exito = false;
        try {
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("INSERT INTO cita (idCita,idUsu,descripcion,fecha,hora) values (?,?,?,?,?)");
            stmt.setString(1, dto.getIdCita());
            stmt.setString(2, dto.getIdUsu());
            stmt.setString(3, dto.getDescripcion());
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
    public boolean eliminarCita(String correo, String idCita) {
        PreparedStatement stmt = null;
        boolean ok = false;
        try {
            stmt = conn.prepareStatement("DELETE FROM cita WHERE idCita='" + idCita + "' AND idUsu='" + correo + "'");
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
