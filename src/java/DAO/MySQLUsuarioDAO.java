/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaz.IUsuario;
import DTO.Actividad;
import DTO.Cita;
import DTO.Cumpleaños;
import DTO.Entrevista;
import DTO.Paseo;
import DTO.Tarea;
import DTO.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jhon Galvis
 */
public class MySQLUsuarioDAO implements IUsuario {

    private Connection conn;
    private String DRIVER = "org.gjt.mm.mysql.Driver";
    private String DBURL = "jdbc:mysql://localhost/integrador";
    private String USER = "root";
    private String PASS = "";
    public boolean keepConnection;

    public MySQLUsuarioDAO(boolean keepConnection) {
        this.keepConnection = keepConnection;
        try {
            Class.forName(DRIVER).newInstance();
            conn = DriverManager.getConnection(DBURL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean actualizarId(String correo, String idActual) {
        PreparedStatement stmt = null;
        boolean ok = false;
        try {
            stmt = conn.prepareStatement("UPDATE usuario SET idActual='" + idActual + "' WHERE correo='" + correo + "'");
            stmt.executeUpdate();
            ok = true;

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
    public String idActual(String correo) {
        Usuario dto = null;
        try {
            String selectStatement = "SELECT nombre,correo,contrasena,idActual FROM usuario where correo='" + correo + "'";
            PreparedStatement prepStmt = conn.prepareStatement(selectStatement);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                dto = new Usuario();
                dto.setNombre(rs.getString(1));
                dto.setCorreo(rs.getString(2));
                dto.setContrasena(rs.getString(3));
                dto.setIdActual(rs.getString(4));
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
        return dto.getIdActual();
    }

    @Override
    public boolean registrarUsuario(Usuario dto) {
        PreparedStatement stmt = null;
        boolean exito = false;
        try {
            stmt = conn.prepareStatement("INSERT INTO usuario" + "(nombre,correo,contrasena,idActual) values (?,?,?,?)");
            stmt.setString(1, dto.getNombre());
            stmt.setString(2, dto.getCorreo());
            stmt.setString(3, dto.getContrasena());
            stmt.setString(4, "0000");
            int total = stmt.executeUpdate();
            if (total > 0) {
                exito = true;
                stmt.close();
            }
        } catch (SQLException ex) {
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
    public Usuario consultarUsuario(String correo) {
        Usuario dto = null;
        try {
            String selectStatement = "SELECT nombre,correo,contrasena FROM usuario where correo='" + correo + "'";
            PreparedStatement prepStmt = conn.prepareStatement(selectStatement);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                dto = new Usuario();
                dto.setNombre(rs.getString(1));
                dto.setCorreo(rs.getString(2));
                dto.setContrasena(rs.getString(3));
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
    public boolean actualizarUsuario(String nombre, String correo, String contraseña) throws Exception {
        PreparedStatement stmt = null;
        boolean ok = false;
        try {
            if (!nombre.equalsIgnoreCase("") & !contraseña.equalsIgnoreCase("")) {
                stmt = conn.prepareStatement("UPDATE usuario SET nombre='" + nombre + "', contrasena='" + contraseña + "' WHERE correo='" + correo + "'");
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
    public ArrayList<Actividad> consultarActividades(String idUsu) throws Exception {
        ArrayList<Actividad> lista = null;
        try {
            String selectStatement = "SELECT descripcion,idUsu,idActividad,fecha,hora FROM actividad where idUsu='" + idUsu + "'";
            PreparedStatement prepStmt = conn.prepareStatement(selectStatement);
            ResultSet rs = prepStmt.executeQuery();
            lista = new ArrayList<Actividad>();
            while (rs.next()) {
                Actividad n = new Actividad();
                n.setDescripcion(rs.getString(1));
                n.setIdUsu(rs.getString(2));
                n.setIdActividad(rs.getString(3));
                n.setFecha(rs.getString(4));
                n.setHora(rs.getString(5));
                System.out.println("Actividad:" + n.getDescripcion() + " fecha:" + n.getFecha());
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
    public ArrayList<Cita> consultarCitas(String correo) throws Exception {
        ArrayList<Cita> lista = null;
        try {
            String selectStatement = "SELECT idCita,idUsu,descripcion,fecha,hora FROM cita where idUsu='" + correo + "'";
            PreparedStatement prepStmt = conn.prepareStatement(selectStatement);
            ResultSet rs = prepStmt.executeQuery();
            lista = new ArrayList<Cita>();
            while (rs.next()) {
                Cita n = new Cita();
                n.setIdCita(rs.getString(1));
                n.setIdUsu(rs.getString(2));
                n.setDescripcion(rs.getString(3));
                n.setFecha(rs.getString(4));
                n.setHora(rs.getString(5));
                System.out.println("Cita:" + n.getDescripcion() + " fecha:" + n.getFecha());
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
    public ArrayList<Cumpleaños> consultarCumpleaños(String correo) throws Exception {
        ArrayList<Cumpleaños> lista = null;
        try {
            String selectStatement = "SELECT idCumpleaños,idUsu,descripcion,fecha,hora FROM cumpleaños where idUsu='" + correo + "'";
            PreparedStatement prepStmt = conn.prepareStatement(selectStatement);
            ResultSet rs = prepStmt.executeQuery();
            lista = new ArrayList<Cumpleaños>();
            while (rs.next()) {
                Cumpleaños n = new Cumpleaños();
                n.setIdCumpleaños(rs.getString(1));
                n.setIdUsu(rs.getString(2));
                n.setDescripcion(rs.getString(3));
                n.setFecha(rs.getString(4));
                n.setHora(rs.getString(5));
                System.out.println("Cumpleaños:" + n.getDescripcion() + " fecha:" + n.getFecha());
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

    

//    public static void main(String[] args) throws Exception {
//        MySQLUsuarioDAO m = new MySQLUsuarioDAO(false);
////        Usuario u = new Usuario("Jhon", "correo", "1234");
////        m.registrarUsuario(u);
////        m.actualizarUsuario("Jhon", "correo", "54321");
////        Actividad a = new Actividad("0002", "Integrador", "17/10/2016", "correo");
////        m.registrarActividad(a);
////        System.out.println(m.consultarActividad("correo", "0001").getDescripcion());
////        m.eliminarActividad("correo", "0002");
////        m.actualizarActividad("correo", "Diseño", "18/10/2016", "0001");
////        Tarea t = new Tarea("0002", "analisis", "17/10/2016", "0001");
////        m.registrarTarea(t);
////        m.eliminarTarea("0001", "0002");
////        m.actualizarTarea("0001", "UML", "18/10/2016", "0001");
////        m.consultarTares("0001");
////        System.out.println("Tarea "+m.consultarTarea("0001", "0001").getDescripcion());
////        Cita c = new Cita("0002", "Almuerzo", "18/10/2016", "correo");
////        m.registrarCita(c);
////        m.eliminarCita("correo", "0001");
////        m.actualizarCita("correo", "Cena", "19/10/2017", "0002");
////        m.consultarCita("correo");
////        System.out.println("Cita: "+m.consultarCita("correo", "0002").getFecha());
////        Cumpleaños c = new Cumpleaños("0002", "Amor", "18/10/2016", "correo");
////        m.registrarCumpleaños(c);
////        m.eliminarCumpleaños("correo", "0001");
////        m.actualizarCumpleaños("correo", "Amor 2", "19/10/2017", "0002");
////        m.consultarCumpleaños("correo");
////        System.out.println("Cumpleaños: "+m.consultarCumpleaños("correo", "0002").getDescripcion());
//    }

    @Override
    public ArrayList<Entrevista> consultarEntrevistas(String idUsu) throws Exception {
        ArrayList<Entrevista> lista = null;
        try {
            String selectStatement = "SELECT idEntrevista,idUsu,descripcion,fecha,hora FROM entrevista where idUsu='" + idUsu + "'";
            PreparedStatement prepStmt = conn.prepareStatement(selectStatement);
            ResultSet rs = prepStmt.executeQuery();
            lista = new ArrayList<Entrevista>();
            while (rs.next()) {
                Entrevista n = new Entrevista();
                n.setIdEntrevista(rs.getString(1));
                n.setIdUsu(rs.getString(2));
                n.setDescripcion(rs.getString(3));
                n.setFecha(rs.getString(4));
                n.setHora(rs.getString(5));
                System.out.println("Entrevista:" + n.getDescripcion() + " fecha:" + n.getFecha());
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
    public ArrayList<Paseo> consultarPaseos(String idUsu) throws Exception {
        ArrayList<Paseo> lista = null;
        try {
            String selectStatement = "SELECT idPaseo,idUsu,descripcion,fecha,hora FROM paseo where idUsu='" + idUsu + "'";
            PreparedStatement prepStmt = conn.prepareStatement(selectStatement);
            ResultSet rs = prepStmt.executeQuery();
            lista = new ArrayList<Paseo>();
            while (rs.next()) {
                Paseo n = new Paseo();
                n.setIdPaseo(rs.getString(1));
                n.setIdUsu(rs.getString(2));
                n.setDescripcion(rs.getString(3));
                n.setFecha(rs.getString(4));
                n.setHora(rs.getString(5));
                System.out.println("Paseo:" + n.getDescripcion() + " fecha:" + n.getFecha());
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
