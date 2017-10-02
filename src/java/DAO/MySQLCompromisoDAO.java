/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Compromiso;
import DTO.Compromiso2;
import DTO.Tarea;
import Interfaz.ICompromiso;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jhon Galvis
 */
public class MySQLCompromisoDAO implements ICompromiso {

    private Connection conn;
    private String DRIVER = "org.gjt.mm.mysql.Driver";
    private String DBURL = "jdbc:mysql://localhost/integrador";
    private String USER = "root";
    private String PASS = "";
    public boolean keepConnection;

    public MySQLCompromisoDAO(boolean keepConnection) {
        this.keepConnection = keepConnection;
        try {
            Class.forName(DRIVER).newInstance();
            conn = DriverManager.getConnection(DBURL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Compromiso> consultarCompromisos(String idUsu) throws Exception {
        ArrayList<Compromiso> lista = null;
        System.out.println(":"+idUsu);
        try {
            String selectStatement = "SELECT tipo,idUsu FROM compromiso where idUsu='" + idUsu + "'";
            PreparedStatement prepStmt = conn.prepareStatement(selectStatement);
            ResultSet rs = prepStmt.executeQuery();
            lista = new ArrayList<Compromiso>();
            Compromiso n1 = new Compromiso("Actividad", "");
            lista.add(n1);
            Compromiso n2 = new Compromiso("Cita", "");
            lista.add(n2);
            Compromiso n3 = new Compromiso("Cumpleaños", "");
            lista.add(n3);
            Compromiso n4 = new Compromiso("Tarea", "");
            lista.add(n4);
            Compromiso n5 = new Compromiso("Entrevista", "");
            lista.add(n5);
            Compromiso n6 = new Compromiso("Paseo", "");
            lista.add(n6);
            while (rs.next()) {
                Compromiso n = new Compromiso();
                n.setTipo(rs.getString(1));
                n.setIdUsu(rs.getString(2));
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
        for(Compromiso c1:lista){
            System.out.println("Compromiso entro: "+c1.getTipo());
        }
        return lista;
    }

    @Override
    public boolean registrarCompromiso(Compromiso dto) {
        boolean exito = false;
        try {
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("INSERT INTO compromiso (tipo,idUsu) values (?,?)");
            stmt.setString(1, dto.getTipo());
            stmt.setString(2, dto.getIdUsu());
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
    public boolean eliminarCompromiso(String tipo, String idUsu) {
        PreparedStatement stmt = null;
        boolean ok = false;
        try {
            stmt = conn.prepareStatement("DELETE FROM compromiso WHERE tipo='" + tipo + "' AND idUsu='" + idUsu + "'");
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

    
    @Override
    public boolean consultarCompromiso(String correo, String tipo) throws Exception {
        Compromiso dto = null;
        try {
            String selectStatement = "SELECT tipo,idUsu FROM compromiso where idUsu='" + correo + "' AND tipo='" + tipo + "'";
            PreparedStatement prepStmt = conn.prepareStatement(selectStatement);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                dto = new Compromiso();
                dto.setTipo(rs.getString(1));
                dto.setIdUsu(rs.getString(2));
                
            }
            rs.close();
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
        if(dto==null){
            System.out.println("No existe este tipo de compromiso");
        }else{
            return true;
        }
        return false;
    }
    
    
}
