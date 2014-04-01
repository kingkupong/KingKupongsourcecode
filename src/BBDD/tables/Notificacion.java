/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BBDD.tables;

import BBDD.utilities.Conector;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mushi
 */
public class Notificacion {

    

    public enum Busqueda {

        ID, FROM, TO
    }
    private int id;
    private int from_id;
    private int to_id;
    private Date fecha_enviado;
    private String asunto;
    private String mensaje;
    private String enlace;

    /**
     * Variables de la BBDD
     */
    private Conector conexion = null;
    private PreparedStatement stm = null;
    private String sql;
    private ResultSet rs;
    
    
    public Notificacion(int id, Busqueda b) throws SQLException {
        this.id = id;
        if (b==Busqueda.ID){
             establecerConexion();
        sql = "Select from_id, to_id, fecha_enviado, asunto, mensaje FROM Notificacion where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, id);
        rs = stm.executeQuery();
        rs.next();
        this.from_id = rs.getInt("from_id");
        this.to_id = rs.getInt("to_id");
        this.fecha_enviado = rs.getDate("fecha_enviado");
        this.asunto = rs.getString("asunto");
        this.mensaje= rs.getString("mensaje");
        conexion.con.close();
        
        }
    }

    public Notificacion(int from_id, int to_id, Date fecha_enviado, String asunto, String mensaje, String enlace) throws SQLException {
    this.from_id=from_id;
    this.to_id=id;
    this.fecha_enviado=fecha_enviado;
    this.asunto=asunto;
    this.mensaje=mensaje;
    this.enlace=enlace;
    sql = "Insert INTO Notificacion (from_id, to_id, fecha_enviado, asunto,mensaje,enlace) VALUES(?,?,?,?,?,?) ";
        establecerConexion();
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, from_id);
        stm.setInt(2, to_id);
        stm.setDate(3, fecha_enviado);
        stm.setString(4, asunto);
        stm.setString(5, mensaje);
        stm.setString(6, enlace);
        stm.execute();
        getIdBBDD();
        conexion.con.close();
    }
    
    
    
        /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the from_id
     */
    public int getFrom_id() {
        return from_id;
    }

    /**
     * @return the to_id
     */
    public int getTo_id() {
        return to_id;
    }

    /**
     * @return the fecha_enviado
     */
    public Date getFecha_enviado() {
        return fecha_enviado;
    }

    /**
     * @return the asunto
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @return the enlace
     */
    public String getEnlace() {
        return enlace;
    }
  
    /**
     * Setters
     * 
     */

    /**
     * @param from_id the from_id to set
     */
    public void setFrom_id(int from_id) throws SQLException {
        this.from_id = from_id;
        establecerConexion();
        sql = "Update Notificacion set from_id=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, from_id);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     * @param to_id the to_id to set
     */
    public void setTo_id(int to_id) throws SQLException {
        this.to_id = to_id;
        establecerConexion();
        sql = "Update Notificacion set to_id=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, to_id);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     * @param fecha_enviado the fecha_enviado to set
     */
    public void setFecha_enviado(Date fecha_enviado) throws SQLException {
        this.fecha_enviado = fecha_enviado;
        establecerConexion();
        sql = "Update Notificacion set fecha_enviado=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setDate(1, fecha_enviado);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     * @param asunto the asunto to set
     */
    public void setAsunto(String asunto) throws SQLException {
        this.asunto = asunto;
        establecerConexion();
        sql = "Update Notificacion set asunto=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, asunto);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) throws SQLException {
        this.mensaje = mensaje;
        establecerConexion();
        sql = "Update Notificacion set mensaje=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, mensaje);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     * @param enlace the enlace to set
     */
    public void setEnlace(String enlace) throws SQLException {
        this.enlace = enlace;
        establecerConexion();
        sql = "Update Notificacion set enlace=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, enlace);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }
    private void getIdBBDD() throws SQLException{
        establecerConexion();
        sql = "Select max(id) from Notificacion";
        rs = stm.executeQuery(sql);
        while (rs.next()) {
           this.id=rs.getInt(1);
        }
        conexion.con.close();

    }
    
    private void establecerConexion() throws SQLException {
        if (conexion == null) {
            conexion = new Conector();
        } else if (conexion.con.isClosed()) {
            conexion = new Conector();
        }
    }

}
