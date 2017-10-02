/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Actividad;
import DTO.Compromiso2;
import DTO.Tarea;
import Interfaz.ICompromiso2;
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
public class MySQLCompromiso2DAO implements ICompromiso2{
    private Connection conn;
    private String DRIVER = "org.gjt.mm.mysql.Driver";
    private String DBURL = "jdbc:mysql://localhost/integrador";
    private String USER = "root";
    private String PASS = "";
    public boolean keepConnection;

    public MySQLCompromiso2DAO(boolean keepConnection) {
        this.keepConnection = keepConnection;
        try {
            Class.forName(DRIVER).newInstance();
            conn = DriverManager.getConnection(DBURL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Compromiso2 consultarCompromiso2(String nomCompromiso,String correo, String idCompromiso2) throws Exception {
        Compromiso2 dto = null;
        try {
            String selectStatement = "SELECT descripcion,fecha,hora,idCompromiso,idUsu FROM compromiso2 where idUsu='" + correo + "' AND idCompromiso='" + idCompromiso2 + "' AND tipo='" + nomCompromiso + "'";
            PreparedStatement prepStmt = conn.prepareStatement(selectStatement);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                dto = new Compromiso2();
                dto.setDescripcion(rs.getString(1));
                dto.setFecha(rs.getString(2));
                dto.setHora(rs.getString(3));
                dto.setIdCompromiso2(rs.getString(4));
                dto.setIdUsu(rs.getString(5));
            }
            rs.close();
            System.out.println("correo "+correo+" idAct "+idCompromiso2);
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
    public boolean actualizarCompromiso2(String nomCompromiso,String idCompromiso2, String descripcion, String fecha, String correo, String hora) {
        PreparedStatement stmt = null;
        boolean ok = false;
        try {
            if (!descripcion.equalsIgnoreCase("") & !fecha.equalsIgnoreCase("")) {
                stmt = conn.prepareStatement("UPDATE compromiso2 SET descripcion='" + descripcion + "', fecha='" + fecha + "', hora='" + hora +"' WHERE idUsu='" + correo + "' AND idCompromiso='"+idCompromiso2 + "' AND tipo='" + nomCompromiso + "'");
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
    public boolean registrarCompromiso2(Compromiso2 dto) {
        boolean exito = false;
        System.out.println(" : "+dto.getDescripcion());
        try {
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("INSERT INTO compromiso2 (descripcion,fecha,hora,idCompromiso,idUsu,tipo) values (?,?,?,?,?,?)");
            System.out.println(dto.getIdUsu());
            stmt.setString(1, dto.getDescripcion());
            stmt.setString(2, dto.getFecha());
            stmt.setString(3, dto.getHora());
            stmt.setString(4, dto.getIdCompromiso2());
            stmt.setString(5, dto.getIdUsu());
            stmt.setString(6, dto.getTipo());
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
    public boolean eliminarCompromiso2(String nomCompromiso,String correo, String idCompromiso2) {
        PreparedStatement stmt = null;
        boolean ok = false;
        try {
            stmt = conn.prepareStatement("DELETE FROM compromiso2 WHERE idUsu='" + correo + "' AND idCompromiso='" + idCompromiso2  + "' AND tipo='" + nomCompromiso + "'");
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
    public ArrayList<Compromiso2> consultarCompromisos2(String nomCompromiso,String idUsu) throws Exception {
        ArrayList<Compromiso2> lista = null;
        try {
            String selectStatement = "SELECT descripcion,fecha,hora,idCompromiso,idUsu FROM compromiso2 where idUsu='"+idUsu + "' AND tipo='" + nomCompromiso + "'";
            PreparedStatement prepStmt = conn.prepareStatement(selectStatement);
            ResultSet rs = prepStmt.executeQuery();
            lista = new ArrayList<Compromiso2>();
            while (rs.next()) {
                Compromiso2 n = new Compromiso2();
                n.setDescripcion(rs.getString(1));
                n.setFecha(rs.getString(2));
                n.setHora(rs.getString(3));
                n.setIdCompromiso2(rs.getString(4));
                n.setIdUsu(rs.getString(5));
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

}


        
    

