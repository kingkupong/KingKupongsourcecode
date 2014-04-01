/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BBDD.tables;

import BBDD.utilities.Conector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Axel
 */
public class DetalleFactura {

    private int id;
    private int facturaid;
    private String concepto;
    private int cantidad;
    private double precio;

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
     * @param id
     * @throws SQLException
     */
    public DetalleFactura(int id) throws SQLException {
        this.id = id;
        establecerConexion();
        sql = "Select facturaid, concepto, cantidad, precio FROM DetalleFactura where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, id);
        rs = stm.executeQuery();
        rs.next();
        this.facturaid = rs.getInt("facturaid");
        this.concepto = rs.getString("concepto");
        this.cantidad = rs.getInt("cantidad");
        this.precio = rs.getDouble("precio");
        conexion.con.close();
    }

    public DetalleFactura(int facturaid, String concepto, int cantidad, int precio) throws SQLException {
        this.facturaid = facturaid;
        this.concepto = concepto;
        this.cantidad = cantidad;
        this.precio = precio;
        sql = "Insert INTO DetalleFactura (facturaid, concepto, cantidad, precio) VALUES(?,?,?,?) ";
        establecerConexion();
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, facturaid);
        stm.setString(2, concepto);
        stm.setInt(3, cantidad);
        stm.setDouble(4, precio);
        stm.execute();
        getIdBBDD();
        conexion.con.close();
    }

    public void deleteComercio() throws SQLException {
        establecerConexion();
        sql = "Delete DetalleFactura where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, getId());
        stm.executeUpdate();
        stm.close();
        conexion.con.close();
    }

    /**
     * @param facturaid the facturaid to set
     * @throws java.sql.SQLException
     */
    public void setFacturaid(int facturaid) throws SQLException {
        establecerConexion();
        sql = "Update DetalleFactura set facturaid=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, facturaid);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
        this.facturaid = facturaid;

    }

    /**
     * @param concepto the concepto to set
     * @throws java.sql.SQLException
     */
    public void setConcepto(String concepto) throws SQLException {
        establecerConexion();
        sql = "Update DetalleFactura set concepto=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, concepto);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
        this.concepto = concepto;
    }

    /**
     * @param cantidad the cantidad to set
     * @throws java.sql.SQLException
     */
    public void setCantidad(int cantidad) throws SQLException {
        establecerConexion();
        sql = "Update DetalleFactura set cantidad=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, cantidad);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
        this.cantidad = cantidad;
    }

    /**
     * @param precio the precio to set
     * @throws java.sql.SQLException
     */
    public void setPrecio(double precio) throws SQLException {
        establecerConexion();
        sql = "Update DetalleFactura set precio=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setDouble(1, precio);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
        this.precio = precio;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the facturaid
     */
    public int getFacturaid() {
        return facturaid;
    }

    /**
     * @return the concepto
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     *
     * @throws SQLException
     */
    private void getIdBBDD() throws SQLException {
        establecerConexion();
        sql = "Select max(id) from DetalleFactura";
        rs = stm.executeQuery(sql);
        while (rs.next()) {
            this.id = rs.getInt(1);
        }
        conexion.con.close();

    }

    /**
     * Conecta con la base de Datos
     *
     * @throws SQLException
     */
    private void establecerConexion() throws SQLException {
        if (conexion == null) {
            conexion = new Conector();
        } else if (conexion.con.isClosed()) {
            conexion = new Conector();
        }
    }

}
