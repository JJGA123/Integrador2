/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Estadistica;
import DTO.Tarea;
import Interfaz.IEstadisticas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jhon Galvis
 */
public class MySQLEstadisticaDAO implements IEstadisticas {

    private Connection conn;
    private String DRIVER = "org.gjt.mm.mysql.Driver";
    private String DBURL = "jdbc:mysql://localhost/integrador";
    private String USER = "root";
    private String PASS = "";
    public boolean keepConnection;

    public MySQLEstadisticaDAO(boolean keepConnection) {
        this.keepConnection = keepConnection;
        try {
            Class.forName(DRIVER).newInstance();
            conn = DriverManager.getConnection(DBURL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Estadistica> consultarEstEliminada(String idUsu,String tipo) throws Exception {
        ArrayList<Estadistica> lista = null;
        try {
            String selectStatement = "SELECT descripcion,fecha,hora,id,idUsu,horaSistema,fechaSistema FROM eliminado where idUsu='" + idUsu + "' AND tipo='"+tipo+"'";
            PreparedStatement prepStmt = conn.prepareStatement(selectStatement);
            ResultSet rs = prepStmt.executeQuery();
            lista = new ArrayList<Estadistica>();
            while (rs.next()) {
                Estadistica n = new Estadistica();
                n.setDescripcion(rs.getString(1));
                n.setFecha(rs.getString(2));
                n.setHora(rs.getString(3));
                n.setId(rs.getString(4));
                n.setIdUsu(rs.getString(5));
                n.setHoraSistema(rs.getString(6));
                n.setFechaSistema(rs.getString(7));

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
    public boolean registrarEstEliminada(Estadistica dto) {
        boolean exito = false;
        try {
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("INSERT INTO eliminado (descripcion,fecha,hora,id,idUsu,horaSistema,fechaSistema,tipo) values (?,?,?,?,?,?,?,?)");
            stmt.setString(1, dto.getDescripcion());
            stmt.setString(2, dto.getFecha());
            stmt.setString(3, dto.getHora());
            stmt.setString(4, dto.getId());
            stmt.setString(5, dto.getIdUsu());
            stmt.setString(6, dto.getHoraSistema());
            stmt.setString(7, dto.getFechaSistema());
            stmt.setString(8, dto.getTipo());

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
    public ArrayList<Estadistica> consultarEstActualizada(String idUsu,String tipo) throws Exception {
        ArrayList<Estadistica> lista = null;
        System.out.println(idUsu);
        System.out.println(tipo);
        try {
            String selectStatement = "SELECT descripcion,fecha,hora,id,idUsu,horaSistema,fechaSistema FROM actualizado where idUsu='" + idUsu + "' AND tipo='"+tipo+"'";
            PreparedStatement prepStmt = conn.prepareStatement(selectStatement);
            ResultSet rs = prepStmt.executeQuery();
            lista = new ArrayList<Estadistica>();
            while (rs.next()) {
                Estadistica n = new Estadistica();
                n.setDescripcion(rs.getString(1));
                n.setFecha(rs.getString(2));
                n.setHora(rs.getString(3));
                n.setId(rs.getString(4));
                n.setIdUsu(rs.getString(5));
                n.setHoraSistema(rs.getString(6));
                n.setFechaSistema(rs.getString(7));

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
    public boolean registrarEstActualizada(Estadistica dto) {
        boolean exito = false;
        try {
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("INSERT INTO actualizado (descripcion,fecha,hora,id,idUsu,horaSistema,fechaSistema,tipo) values (?,?,?,?,?,?,?,?)");
            stmt.setString(1, dto.getDescripcion());
            stmt.setString(2, dto.getFecha());
            stmt.setString(3, dto.getHora());
            stmt.setString(4, dto.getId());
            stmt.setString(5, dto.getIdUsu());
            stmt.setString(6, dto.getHoraSistema());
            stmt.setString(7, dto.getFechaSistema());
            stmt.setString(8, dto.getTipo());

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
    public ArrayList<Estadistica> consultarEstRegistrada(String idUsu,String tipo) throws Exception {
        ArrayList<Estadistica> lista = null;
        try {
            String selectStatement = "SELECT descripcion,fecha,hora,id,idUsu,horaSistema,fechaSistema FROM registrado where idUsu='" + idUsu + "' AND tipo='"+tipo+"'";
            PreparedStatement prepStmt = conn.prepareStatement(selectStatement);
            ResultSet rs = prepStmt.executeQuery();
            lista = new ArrayList<Estadistica>();
            while (rs.next()) {
                Estadistica n = new Estadistica();
                n.setDescripcion(rs.getString(1));
                n.setFecha(rs.getString(2));
                n.setHora(rs.getString(3));
                n.setId(rs.getString(4));
                n.setIdUsu(rs.getString(5));
                n.setHoraSistema(rs.getString(6));
                n.setFechaSistema(rs.getString(7));

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
    public boolean registrarEstRegistrada(Estadistica dto) {
        boolean exito = false;
        try {
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("INSERT INTO registrado (descripcion,fecha,hora,id,idUsu,horaSistema,fechaSistema,tipo) values (?,?,?,?,?,?,?,?)");
            stmt.setString(1, dto.getDescripcion());
            stmt.setString(2, dto.getFecha());
            stmt.setString(3, dto.getHora());
            stmt.setString(4, dto.getId());
            stmt.setString(5, dto.getIdUsu());
            stmt.setString(6, dto.getHoraSistema());
            stmt.setString(7, dto.getFechaSistema());
            stmt.setString(8, dto.getTipo());
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

    

}
