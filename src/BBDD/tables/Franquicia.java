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
 * @author Boomeraling
 */
public class Franquicia {
    
    
    
    private int id;
    private String name;
    private int franquiciadoid;
    private String fulladdress;
    private String cp;
    private String stateorprovince;
    private String city;
    private String country;
    private Double longitude;
    private Double latitude;
    private String profileimageurl;
    private String background;
    
    private Conector conexion = null;
    private PreparedStatement stm = null;
    private String sql;
    private ResultSet rs;
    
    
    public Franquicia(int id) throws SQLException{
        this.id = id;
        establecerConexion();
        sql = "Select name, franquiciadoid, fulladdress, cp, city, stateorprovince, country FROM Franquicia where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, id);
        rs = stm.executeQuery();
        rs.next();
        this.name = rs.getString("name");
        this.franquiciadoid = rs.getInt("franquiciadoid");
        this.country = rs.getString("country");
        this.fulladdress = rs.getString("fulladdress");
        this.city = rs.getString("city");
        this.stateorprovince = rs.getString("stateorprovince");
        this.cp = rs.getString("cp");
        getOptionals();
        conexion.con.close();
        
    }
    public Franquicia(String name, int franquiciadoid, String fulladdress, String cp, String city, String stateorprovince, String country) throws SQLException{
        this.name = name;
        this.franquiciadoid = franquiciadoid;
        this.fulladdress = fulladdress;
        this.cp=cp;
        this.city=city;
        this.stateorprovince = stateorprovince;
        this.country=country;
        sql = "Insert INTO Franquicia (name, franquiciadoid, fulladdress, cp, city, stateorprovince, country) VALUES(?,?,?,?,?,?,?)";
        establecerConexion();
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, name);
        stm.setInt(2, franquiciadoid);
        stm.setString(3, fulladdress);
        stm.setString(4, cp);
        stm.setString(5, city);
        stm.setString(6, stateorprovince);
        stm.setString(7, country);
        stm.execute();
        getIdBBDD();
        conexion.con.close();
        
        
        
    }

    
    
    
    
    
    
    /**
     * Getters
     */
    
     
    /*^*
    
    */
    public String getCountry(){
        return country;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the franquiciadoid
     */
    public int getFranquiciadoid() {
        return franquiciadoid;
    }
    /**
     * @return the fulladdres
     */
    public String getFulladdress() {
        return fulladdress;
    }

    /**
     * @return the cp
     */
    public String getCp() {
        return cp;
    }

    /**
     * @return the stateorprovince
     */
    public String getStateorprovince() {
        return stateorprovince;
    }
    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * @return the latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * @return the profileimageurl
     */
    public String getProfileimageurl() {
        return profileimageurl;
    }

    /**
     * @return the background
     */
    public String getBackground() {
        return background;
    }
    
    
    
    
    
    /**
     * Setters
     */
    
   
    /**
     * @param name the name to set
     * @throws java.sql.SQLException
     */
    public void setName(String name) throws SQLException {
        this.name = name;
        establecerConexion();
        sql = "Update Franquicia set name=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, name);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }
    
    public void setCountry(String country) throws SQLException{
        this.country=country;
        establecerConexion();
        sql = "Update Franquicia set country=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, country);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }
    
    /**
     * @param fulladdress the fulladdres to set
     * @throws java.sql.SQLException
     */
    public void setFulladdress(String fulladdress) throws SQLException {
        this.fulladdress = fulladdress;
        establecerConexion();
        sql = "Update Franquicia set fulladdress=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, fulladdress);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }
    /**
     * @param cp the cp to set
     * @throws java.sql.SQLException
     */
    public void setCp(String cp) throws SQLException {
        this.cp = cp;
        establecerConexion();
        sql = "Update Franquicia set cp=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, cp);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }
    /**
     * @param stateorprovince the stateorprovince to set
     * @throws java.sql.SQLException
     */
    public void setStateorprovince(String stateorprovince) throws SQLException {
        this.stateorprovince = stateorprovince;
        establecerConexion();
        sql = "Update Franquicia set stateorprovince=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, stateorprovince);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     * @param longitude the longitude to set
     * @throws java.sql.SQLException
     */
    public void setLongitude(Double longitude) throws SQLException {
        this.longitude = longitude;
        establecerConexion();
        sql = "Update Franquicia set longitude=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setDouble(1, longitude);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     * @param latitude the latitude to set
     * @throws java.sql.SQLException
     */
    public void setLatitude(Double latitude) throws SQLException {
        this.latitude = latitude;
        establecerConexion();
        sql = "Update Franquicia set latitude=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setDouble(1, latitude);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     * @param background the background to set
     * @throws java.sql.SQLException
     */
    public void setBackground(String background) throws SQLException {
        this.background = background;
        establecerConexion();
        sql = "Update Franquicia set background=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, background);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }
    
      /**
     * @param franquiciadoid the franquiciadoid to set
     * @throws java.sql.SQLException
     */
    public void setFranquiciadoid(int franquiciadoid) throws SQLException {
        this.franquiciadoid = franquiciadoid;
        establecerConexion();
        sql = "Update Franquicia set franquiciadoid=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, franquiciadoid);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }
     /**
     * @param profileimageurl the profileimageurl to set
     * @throws java.sql.SQLException
     */
    public void setProfileimageurl(String profileimageurl) throws SQLException {
        this.profileimageurl = profileimageurl;
        establecerConexion();
        sql = "Update Franquicia set profileimageurl=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, profileimageurl);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }
    
    
    private void getProfileimageurlBBDD() throws SQLException {
        establecerConexion();
        sql = "Select profileimageurl FROM Franquicia where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, getId());
        rs = stm.executeQuery();
        if(rs.next())this.profileimageurl = rs.getString("profileimageurl");
        conexion.con.close();
    }

    private void getLongitudeBBDD() throws SQLException {
        establecerConexion();
        sql = "Select longitude FROM Franquicia where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, getId());
        rs = stm.executeQuery();
        if(rs.next())this.longitude = rs.getDouble("longitude");
        conexion.con.close();
    }

    private void getLatitudeBBDD() throws SQLException {
        establecerConexion();
        sql = "Select latitude FROM Franquicia where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, getId());
        rs = stm.executeQuery();
        if(rs.next())this.latitude = rs.getDouble("latitude");
        conexion.con.close();
    }
    private void getBackgroundBBDD() throws SQLException{
        establecerConexion();
        sql = "Select background FROM Franquicia where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, getId());
        rs = stm.executeQuery();
        if(rs.next())this.background = rs.getString("background");
        conexion.con.close();
    }
    
    private void getIdBBDD() throws SQLException{
        establecerConexion();
        sql = "Select max(id) from Franquicia";
        rs = stm.executeQuery(sql);
        while (rs.next()) {
           this.id=rs.getInt(1);
        }
        conexion.con.close();

    }
    
    
    
    private void getOptionals() throws SQLException{
        getLatitudeBBDD();
        getLongitudeBBDD();
        getProfileimageurlBBDD();
        getBackgroundBBDD();
    }
    
    
    private void establecerConexion() throws SQLException {
        if (conexion == null) {
            conexion = new Conector();
        } else if (conexion.con.isClosed()) {
            conexion = new Conector();
        }
    }
    
}
