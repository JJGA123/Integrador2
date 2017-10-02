/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Cita;
import DTO.Entrevista;
import Interfaz.IEntrevista;
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
public class MySQLEntrevistaDAO implements IEntrevista {

    private Connection conn;
    private String DRIVER = "org.gjt.mm.mysql.Driver";
    private String DBURL = "jdbc:mysql://localhost/integrador";
    private String USER = "root";
    private String PASS = "";
    public boolean keepConnection;

    public MySQLEntrevistaDAO(boolean keepConnection) {
        this.keepConnection = keepConnection;
        try {
            Class.forName(DRIVER).newInstance();
            conn = DriverManager.getConnection(DBURL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Entrevista consultarEntrevista(String correo, String idEntrevista) throws Exception {
        Entrevista dto = null;
        try {
            String selectStatement = "SELECT descripcion,idUsu,idEntrevista,fecha,hora FROM entrevista where idUsu='" + correo + "' AND idEntrevista='" + idEntrevista + "'";
            PreparedStatement prepStmt = conn.prepareStatement(selectStatement);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                dto = new Entrevista();
                dto.setDescripcion(rs.getString(1));
                dto.setIdUsu(rs.getString(2));
                dto.setIdEntrevista(rs.getString(3));
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
    public boolean actualizarEntrevista(String correo, String descripcion, String fecha, String idEntrevista, String hora) {
        PreparedStatement stmt = null;
        boolean ok = false;
        try {
            if (!descripcion.equalsIgnoreCase("") & !fecha.equalsIgnoreCase("")) {
                stmt = conn.prepareStatement("UPDATE entrevista SET descripcion='" + descripcion + "', fecha='" + fecha + "', hora='" + hora + "' WHERE idUsu='" + correo + "' AND idEntrevista='" + idEntrevista + "'");
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
    public boolean registrarEntrevista(Entrevista dto) {
        boolean exito = false;
        try {
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("INSERT INTO entrevista (descripcion,idUsu,idEntrevista,fecha,hora) values (?,?,?,?,?)");
            stmt.setString(1, dto.getDescripcion());
            stmt.setString(2, dto.getIdUsu());
            stmt.setString(3, dto.getIdEntrevista());
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
    public boolean eliminarEntrevista(String correo, String idEntrevista) {
        PreparedStatement stmt = null;
        boolean ok = false;
        try {
            stmt = conn.prepareStatement("DELETE FROM entrevista WHERE idEntrevista='" + idEntrevista + "' AND idUsu='" + correo + "'");
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
