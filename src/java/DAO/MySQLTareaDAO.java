/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaz.ITarea;
import DTO.Tarea;
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
public class MySQLTareaDAO implements ITarea{
 
    private Connection conn;
    private String DRIVER = "org.gjt.mm.mysql.Driver";
    private String DBURL = "jdbc:mysql://localhost/integrador";
    private String USER = "root";
    private String PASS = "";
    public boolean keepConnection;

    public MySQLTareaDAO(boolean keepConnection) {
        this.keepConnection = keepConnection;
        try {
            Class.forName(DRIVER).newInstance();
            conn = DriverManager.getConnection(DBURL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
        @Override
    public Tarea consultarTarea(String idUsu,String idAct_idTare, String idTarea) throws Exception {
        Tarea dto = null;
        try {
            String selectStatement = "SELECT idTarea,idAct_idTare,idUsu,descripcion,fecha,hora FROM tarea where idAct_idTare='" + idAct_idTare + "' AND idTarea='" + idTarea + "' AND idUsu='"+idUsu+"'";
            PreparedStatement prepStmt = conn.prepareStatement(selectStatement);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                dto = new Tarea();
                dto.setIdTarea(rs.getString(1));
                dto.setIdAct(rs.getString(2));
                dto.setIdUsu(rs.getString(3));
                dto.setDescripcion(rs.getString(4));
                dto.setFecha(rs.getString(5));
                dto.setHora(rs.getString(6));
            }
            System.out.println("id : "+dto.getIdAct());
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
    public boolean actualizarTarea(String idUsu,String idAct_idTare, String descripcion, String fecha, String idTarea,String hora) {
        PreparedStatement stmt = null;
        boolean ok = false;
        try {
            if (!descripcion.equalsIgnoreCase("") & !fecha.equalsIgnoreCase("")) {
                stmt = conn.prepareStatement("UPDATE tarea SET descripcion='" + descripcion + "', fecha='" + fecha + "', hora='" + hora +"' WHERE idAct_idTare='" +idAct_idTare + "' AND idTarea='"+idTarea+"' AND idUsu='"+idUsu+"'");
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
    public boolean registrarTarea(Tarea dto) {
        boolean exito = false;
        try {
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("INSERT INTO tarea (idTarea,idAct_idTare,idUsu,descripcion,fecha,hora) values (?,?,?,?,?,?)");
            stmt.setString(1, dto.getIdTarea());
            stmt.setString(2, dto.getIdAct());
            stmt.setString(3, dto.getIdUsu());
            stmt.setString(4, dto.getDescripcion());
            stmt.setString(5, dto.getFecha());
            stmt.setString(6, dto.getHora());
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
    public boolean eliminarTarea(String idUsu,String idAct_idTar, String idTarea) {
        PreparedStatement stmt = null;
        boolean ok = false;
        try {
            stmt = conn.prepareStatement("DELETE FROM tarea WHERE idAct_idTare='" + idAct_idTar + "' AND idTarea='"+idTarea+"' AND idUsu='"+idUsu+"'");
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
