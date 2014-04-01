/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BBDD.tables;

import BBDD.utilities.Conector;
import static BBDD.utilities.Consultas.establecerConexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Axel
 */
public class CuponesUsuario {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the id_usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * @return the id_comercio
     */
    public int getId_cupon() {
        return id_cupon;
    }

    /**
     * @return the fecha_compra
     */
    public Date getFecha_compra() {
        return fecha_compra;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    public enum Busqueda {

        ID, ID_USUARIO, ID_CUPON
    }

    private int id;
    private int id_usuario;
    private int id_cupon;
    private Date fecha_compra;
    private double precio;
    private String estado;

    /**
     *
     * Base de datos
     *
     */
    private Conector conexion = null;
    private PreparedStatement stm = null;
    private String sql;
    private ResultSet rs;

    /**
     * Este es un constructor que dada la ID carga todos los valores al objeto
     * creado
     *
     * @param busqueda
     * @param b
     * @throws SQLException
     */
    public CuponesUsuario(int busqueda, Busqueda b) throws SQLException {

        if (Busqueda.ID == b) {
            this.id = busqueda;
            sql = "Select id_usuario, id_cupon, fecha_compra, precio, estado FROM "
                    + "CuponesUsuario where id=?";
        }

        if (Busqueda.ID_CUPON == b) {
            this.id_cupon = busqueda;
            sql = "Select id, id_usuario, fecha_compra, precio, estado FROM "
                    + "CuponesUsuario where id_cupon=?";
        }

        if (Busqueda.ID_USUARIO == b) {
            this.id_usuario = busqueda;
            sql = "Select id, id_cupon, fecha_compra, precio, estado FROM "
                    + "CuponesUsuario where id_usuario=?";
        }

        establecerConexion();
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, busqueda);
        rs = stm.executeQuery();
        rs.next();
        this.fecha_compra = rs.getDate("fecha_compra");
        this.precio = rs.getDouble("precio");
        this.estado = rs.getString("estado");
        if (Busqueda.ID == b) {
            this.id_usuario = rs.getInt("id_usuario");
            this.id_cupon = rs.getInt("id_cupon");
        }

        if (Busqueda.ID_CUPON == b) {
            this.id_usuario = rs.getInt("id_usuario");
            this.id = rs.getInt("id");
        }

        if (Busqueda.ID_USUARIO == b) {
            this.id = rs.getInt("id");
            this.id_cupon = rs.getInt("id_cupon");
        }
        rs.close();
        stm.close();
        conexion.con.close();
    }

    /**
     *
     * Constructor para crear uno nuevo con los valores elegidos.
     *
     * @param id_usuario
     * @param id_cupon
     * @param fecha_compra
     * @param precio
     * @param estado
     * @throws java.sql.SQLException
     */
    public CuponesUsuario(int id_usuario, int id_cupon, Date fecha_compra, double precio, String estado) throws SQLException {
        this.id_usuario = id_usuario;
        this.id_cupon = id_cupon;
        this.fecha_compra = fecha_compra;
        this.precio = precio;
        this.estado = estado;
        sql = "Insert into CuponesUsuario (id_usuario, id_cupon, fecha_compra, precio, estado) "
                + "VALUES(?,?,?,?,?) ;";
        establecerConexion();
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, id_usuario);
        stm.setInt(2, id_cupon);
        stm.setDate(3, fecha_compra);
        stm.setDouble(4, precio);
        stm.setString(5, estado);
        stm.executeUpdate();
        getIdBBDD();
        conexion.con.close();
    }

    /**
     *
     *
     * @param id_usuario
     * @param fecha
     * @throws SQLException
     */
    public CuponesUsuario(int id_usuario, Date fecha) throws SQLException {
        this.id_usuario = id_usuario;
        sql = "Select id, id_cupon, fecha_compra, precio, estado FROM "
                + "CuponesUsuario where id_usuario=? AND fecha_compra >= ?";
        establecerConexion();
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, id_usuario);
        stm.setDate(2, fecha);
        rs = stm.executeQuery();
        rs.next();
        this.id = rs.getInt("id");
        this.id_cupon = rs.getInt("id_cupon");
        this.fecha_compra = rs.getDate("fecha_compra");
        this.precio = rs.getDouble("precio");
        this.estado = rs.getString("estado");
        rs.close();
        stm.close();
        conexion.con.close();
    }

    /**
     *
     * @param id_usuario
     * @throws SQLException
     */
    public void setId_usuario(int id_usuario) throws SQLException {
        this.id_usuario = id_usuario;
        establecerConexion();
        sql = "Update CuponesUsuario set id_usuario=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, id_usuario);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     *
     * @param id_cupon
     * @throws SQLException
     */
    public void setId_cupon(int id_cupon) throws SQLException {
        this.id_cupon = id_cupon;
        establecerConexion();
        sql = "Update CuponesUsuario set id_cupon=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, id_cupon);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     *
     * @param fecha_compra
     * @throws SQLException
     */
    public void setFecha_compra(Date fecha_compra) throws SQLException {
        this.fecha_compra = fecha_compra;
        establecerConexion();
        sql = "Update CuponesUsuario set fecha_compra=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setDate(1, fecha_compra);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     *
     * @param precio
     * @throws SQLException
     */
    public void setPrecio(double precio) throws SQLException {
        this.precio = precio;
        establecerConexion();
        sql = "Update CuponesUsuario set precio=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setDouble(1, precio);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     *
     * @param estado
     * @throws SQLException
     */
    public void setEstado(String estado) throws SQLException {
        this.estado = estado;
        establecerConexion();
        sql = "Update CuponesUsuario set estado=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, estado);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     *
     * @throws SQLException
     */
    private void getIdBBDD() throws SQLException {
        establecerConexion();
        sql = "Select max(id) from CuponesUsuario";
        rs = stm.executeQuery(sql);
        while (rs.next()) {
            this.id = rs.getInt(1);
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
