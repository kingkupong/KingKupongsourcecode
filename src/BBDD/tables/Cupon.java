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
import java.util.Date;

/**
 *
 * @author Boomeraling
 */
public class Cupon {

    

    /**
     * 
     * @param QR
     * @throws SQLException 
     */
    public void setQR(String QR) throws SQLException {
        this.QR = QR;
        establecerConexion();
        sql = "Update cupon set QR=? WHERE id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, QR);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }

  

    /**
     * @param barcode the barcode to set
     * @throws java.sql.SQLException
     */
    public void setBarcode(String barcode) throws SQLException {
        this.barcode = barcode;
        establecerConexion();
        sql = "Update cupon set barcode=? WHERE id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, barcode);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }

    public enum Busqueda {

        NAME, CODE, DESCRIPTION, TITLE
    }

    // Datos del cupon
    private int id;
    private int businessid;
    private String code;
    private String name;
    private String title;
    private String description;
    private Date datestart;
    private Date dateexpiration;
    private String backgroundimageurl;
    private double price;
    private double realprice;
    private String conditions;
    private int availquota;
    private String couponimageurl;
    private String QR;
    private String barcode;

    // Variables BDD
    private Conector conexion = null;
    private PreparedStatement stm = null;
    private String sql;
    private ResultSet rs;

    // CONSTRUCTORES
    /**
     * Constructor que recupera los datos a traves de su id.
     *
     * @param id
     * @throws SQLException
     */
    public Cupon(int id) throws SQLException {
        this.id = id;
        establecerConexion();
        sql = "SELECT businessid, code, name, title, datestart, dateexpiration, "
                + "availquota, couponimageurl FROM cupon WHERE id = ? ;";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, id);
        rs = stm.executeQuery();
        rs.next();
        this.businessid = rs.getInt("businessid");
        this.code = rs.getString("code");
        this.name = rs.getString("name");
        this.title = rs.getString("title");
        this.datestart = rs.getDate("datestart");
        this.dateexpiration = rs.getDate("dateexpiration");
        this.availquota = rs.getInt("availquota");
        this.couponimageurl = rs.getString("couponimageurl");
        rs.close();
        stm.close();
        getOptionals();
        conexion.con.close();
        
    }

    /**
     * Constructor que recupera los datos a traves del campo de busqueda. Puede
     * buscar segun el name, code, description o title
     *
     * @param busqueda
     * @param b
     * @throws SQLException
     */
    public Cupon(String busqueda, Busqueda b) throws SQLException {

        switch (b) {
            case NAME:
                sql = "SELECT id, businessid, code, title, datestart, dateexpiration, "
                        + "availquota, couponimageurl FROM cupones WHERE name = ? ;";
                this.name = busqueda;
                break;
            case CODE:
                sql = "SELECT id, businessid, name, title, datestart, dateexpiration, "
                        + "availquota, couponimageurl FROM cupones WHERE code = ? ;";
                this.code = busqueda;
                break;
            case DESCRIPTION:
                // description LIKE maybe?
                sql = "SELECT id, businessid, name, code, title, datestart, dateexpiration, "
                        + "availquota, couponimageurl FROM cupones WHERE description = ? ;";
                this.description = busqueda;
                break;
            case TITLE:
                sql = "SELECT id, businessid, name, code, datestart, dateexpiration, "
                        + "availquota, couponimageurl FROM cupones WHERE title = ? ;";
                this.title = busqueda;
                break;
        }
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, busqueda);
        rs = stm.executeQuery();
        rs.next();
        if (b == Busqueda.NAME) {
            this.code = rs.getString("code");
            this.title = rs.getString("title");
        }
        if (b == Busqueda.CODE) {
            this.title = rs.getString("title");
            this.name = rs.getString("name");
        }
        if (b == Busqueda.DESCRIPTION) {
            this.code = rs.getString("code");
            this.title = rs.getString("title");
            this.name = rs.getString("name");
        }
        if (b == Busqueda.TITLE) {
            this.code = rs.getString("code");
            this.name = rs.getString("name");
        }
        this.id = rs.getInt("id");
        this.businessid = rs.getInt("businessid");
        this.datestart = rs.getDate("datestart");
        this.dateexpiration = rs.getDate("dateexpiration");
        this.availquota = rs.getInt("availquota");
        this.couponimageurl = rs.getString("couponimageurl");
        rs.close();
        stm.close();
        getOptionals();
        conexion.con.close();
        
    }

    /**
     * Constructor de RegistroCupon
     *
     * @param businessid
     * @param code
     * @param name
     * @param title
     * @param datestart
     * @param dateexpiration
     * @param availquota
     * @param couponimageurl
     * @throws SQLException
     */
    public Cupon(int businessid, String code, String name, String title, Date datestart,
            Date dateexpiration, int availquota, String couponimageurl)
            throws SQLException {
        this.businessid = businessid;
        this.code = code;
        this.name = name;
        this.title = title;
        this.datestart = datestart;
        this.dateexpiration = dateexpiration;
        this.availquota = availquota;
        this.couponimageurl = couponimageurl;
        sql = "Insert INTO CUPON (businessid, code, name, title, datestart, dateexpiration, "
                + "availquota, couponimageurl) VALUES(?,?,?,?,?,?,?,?)";
        establecerConexion();
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, businessid);
        stm.setString(2, code);
        stm.setString(3, name);
        stm.setString(4, title);
        stm.setDate(5, (java.sql.Date) datestart);
        stm.setDate(6, (java.sql.Date) dateexpiration);
        stm.setInt(7, availquota);
        stm.setString(8, couponimageurl);
        stm.executeUpdate();
        getIdBBDD();
        conexion.con.close();
        
    }

    // ELIMINAR
    /**
     *
     * @throws SQLException
     */
    public void deleteCupon() throws SQLException {
        establecerConexion();
        sql = "Delete Cupon where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, getId());
        stm.setInt(2, id);
        stm.executeUpdate();
        stm.close();
        conexion.con.close();
    }

    // SETTERS
    /**
     *
     * @param id
     * @throws SQLException
     */
    public void setBusinessId(int id) throws SQLException {
        this.businessid = id;
        establecerConexion();
        sql = "Update cupon set businessid=? WHERE id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, id);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     *
     * @param code
     * @throws SQLException
     */
    public void setCode(String code) throws SQLException {
        this.code = code;
        establecerConexion();
        sql = "Update cupon set code=? WHERE id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, code);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     *
     * @param name
     * @throws SQLException
     */
    public void setName(String name) throws SQLException {
        this.name = name;
        establecerConexion();
        sql = "Update cupon set name=? WHERE id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, name);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     *
     * @param title
     * @throws SQLException
     */
    public void setTitle(String title) throws SQLException {
        this.title = title;
        establecerConexion();
        sql = "Update cupon set title=? WHERE id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, title);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     *
     * @param description
     * @throws SQLException
     */
    public void setDescription(String description) throws SQLException {
        this.description = description;
        establecerConexion();
        sql = "Update cupon set description=? WHERE id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, description);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }

    public void setDatestart(Date datestart) throws SQLException {
        this.datestart = datestart;
        establecerConexion();
        sql = "Update cupon set datestart=? WHERE id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setDate(1, (java.sql.Date) datestart);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     *
     * @param dateexpiration
     * @throws SQLException
     */
    public void setDateexpiration(Date dateexpiration) throws SQLException {
        this.dateexpiration = dateexpiration;
        establecerConexion();
        sql = "Update cupon set dateexpiration=? WHERE id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setDate(1, (java.sql.Date) dateexpiration);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     *
     * @param backgroundimageurl
     * @throws SQLException
     */
    public void setBackgroundimageurl(String backgroundimageurl) throws SQLException {
        this.backgroundimageurl = backgroundimageurl;
        establecerConexion();
        sql = "Update cupon set backgroundimageurl=? WHERE id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, backgroundimageurl);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     *
     * @param price
     * @throws SQLException
     */
    public void setPrice(double price) throws SQLException {
        this.price = price;
        establecerConexion();
        sql = "Update cupon set price=? WHERE id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setDouble(1, price);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     *
     * @param realprice
     * @throws SQLException
     */
    public void setRealprice(double realprice) throws SQLException {
        this.realprice = realprice;
        establecerConexion();
        sql = "Update cupon set realprice=? WHERE id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setDouble(1, realprice);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     *
     * @param conditions
     * @throws SQLException
     */
    public void setConditions(String conditions) throws SQLException {
        this.conditions = conditions;
        establecerConexion();
        sql = "Update cupon set conditions=? WHERE id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, conditions);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();

    }

    /**
     *
     * @param availquota
     * @throws SQLException
     */
    public void setAvailquota(int availquota) throws SQLException {
        this.availquota = availquota;
        establecerConexion();
        sql = "Update cupon set availquota=? WHERE id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, availquota);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     *
     * @param couponimageurl
     * @throws SQLException
     */
    public void setCouponimageurl(String couponimageurl) throws SQLException {
        this.couponimageurl = couponimageurl;
        establecerConexion();
        sql = "Update cupon set couponimageurl=? WHERE id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, couponimageurl);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }

    // GETTERS
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @return the QR
     */
    public String getQR() {
        return QR;
    }
    

    /**
     * @return the businessid
     */
    public int getBusinessid() {
        return businessid;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
      /**
     * @return the barcode
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the datestart
     */
    public Date getDatestart() {
        return datestart;
    }

    /**
     * @return the dateexpiration
     */
    public Date getDateexpiration() {
        return dateexpiration;
    }

    /**
     * @return the backgroundimageurl
     */
    public String getBackgroundimageurl() {
        return backgroundimageurl;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return the realprice
     */
    public double getRealprice() {
        return realprice;
    }

    /**
     * @return the conditions
     */
    public String getConditions() {
        return conditions;
    }

    /**
     * @return the availquota
     */
    public int getAvailquota() {
        return availquota;
    }

    /**
     * @return the couponimageurl
     */
    public String getCouponimageurl() {
        return couponimageurl;
    }

    // GETTERS BDD
    /**
     *
     * @throws SQLException
     */
    private void getIdBBDD() throws SQLException {
        establecerConexion();
        sql = "Select max(id) from Cupon";
        stm = conexion.con.prepareStatement(sql);
        rs = stm.executeQuery(sql);
        while (rs.next()) {
            this.id = rs.getInt(1);
        }
        rs.close();
        stm.close();
        conexion.con.close();
    }

    /**
     *
     * @throws SQLException
     */
    private void getDescriptionBBDD() throws SQLException {
        establecerConexion();
        sql = "Select description FROM Cupon where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, id);
        rs = stm.executeQuery();
        if(rs.next())this.description = rs.getString("description");
        rs.close();
        stm.close();conexion.con.close();
        
    }
    
    /**
     *
     * @throws SQLException
     */
    private void getQRBBDD() throws SQLException {
        establecerConexion();
        sql = "Select QR FROM Cupon where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, id);
        rs = stm.executeQuery();
        if(rs.next())this.QR = rs.getString("QR");
        rs.close();
        stm.close();
        conexion.con.close();
    }
    /**
     *
     * @throws SQLException
     */
    private void getBarcodeBBDD() throws SQLException {
        establecerConexion();
        sql = "Select barcode FROM Cupon where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, id);
        rs = stm.executeQuery();
        if(rs.next())this.barcode= rs.getString("barcode");
        rs.close();
        stm.close();
        conexion.con.close();
        
    }

    /**
     *
     * @throws SQLException
     */
    private void getBackgroundimageurlBBDD() throws SQLException {
        establecerConexion();
        sql = "Select backgroundimageurl FROM Cupon where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, id);
        rs = stm.executeQuery();
        if(rs.next())this.backgroundimageurl = rs.getString("backgroundimageurl");
        rs.close();
        stm.close();
        conexion.con.close();
    }

    /**
     *
     * @throws SQLException
     */
    private void getPriceBBDD() throws SQLException {
        establecerConexion();
        sql = "Select price FROM Cupon where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, id);
        rs = stm.executeQuery();
        if(rs.next())this.price = rs.getDouble("price");
        rs.close();
        stm.close();
        conexion.con.close();
    }

    /**
     *
     * @throws SQLException
     */
    private void getRealpriceBBDD() throws SQLException {
        establecerConexion();
        sql = "Select realprice FROM Cupon where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, id);
        rs = stm.executeQuery();
        if(rs.next())this.realprice = rs.getDouble("realprice");
        rs.close();
        stm.close();
        conexion.con.close();
    }

    /**
     *
     * @throws SQLException
     */
    private void getConditionsBBDD() throws SQLException {
        establecerConexion();
        sql = "Select conditions FROM Cupon where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, id);
        rs = stm.executeQuery();
        if(rs.next())this.conditions = rs.getString("conditions");
        rs.close();
        stm.close();
        conexion.con.close();
    }

    /**
     *
     * @throws SQLException
     */
    private void getOptionals() throws SQLException {
        getDescriptionBBDD();
        getBackgroundimageurlBBDD();
        getPriceBBDD();
        getRealpriceBBDD();
        getConditionsBBDD();
        getQRBBDD();
        getBarcodeBBDD();

    }

    // CONEXION A BDD
    private void establecerConexion() throws SQLException {
        if (conexion == null) {
            conexion = new Conector();
        } else if (conexion.con.isClosed()) {
            conexion = new Conector();
        }
    }

}
