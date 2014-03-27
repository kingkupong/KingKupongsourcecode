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
/**
 * id businessname email fbid password registerdate lastlogin country fulladress
 * city stateorprovince cp latitude longitude description profileimageurl active
 *
 *
 */
public class Comercio {

   

   
    public enum Busqueda{
         BUSINESSNAME,EMAIL,FBID
     }
    private int id;
    private String businessname;
    private String email;
    private String fbid;
    private int franquiciaID;
    private String password;
    private String country;
    private String fulladdress;
    private String city;
    private String stateorprovince;
    private String cp;
    private boolean active;
    private String description;
    private String profileimageurl;
    private Double longitude;
    private Double latitude;

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
    public Comercio(int id) throws SQLException {
        this.id = id;
        establecerConexion();
        sql = "Select businessname, email, password, country, fulladdress, city, stateorprovince, cp, active FROM Comercio where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, id);
        rs = stm.executeQuery();
        rs.next();
        this.businessname = rs.getString("businessname");
        this.email = rs.getString("email");
        this.password = rs.getString("password");
        this.country = rs.getString("country");
        this.fulladdress = rs.getString("fulladdress");
        this.city = rs.getString("city");
        this.stateorprovince = rs.getString("stateorprovince");
        this.cp = rs.getString("cp");
        this.active = rs.getBoolean("active");
        getOptionals();
        conexion.con.close();
        
    }

   
    /**
     * Este es un Constructor que dado el valor del nombre carga todos los
     * valores al objeto creado
     * @param busqueda
     * @param b
     * @throws SQLException 
     */
    public Comercio(String busqueda, Busqueda b) throws SQLException {
        if (Busqueda.BUSINESSNAME==b)
        {
            this.businessname = busqueda;
            sql = "Select id, email, password, country, fulladdress, city, stateorprovince, cp, active FROM Comercio where businessname=?";
        }
        if (Busqueda.EMAIL==b){
            this.email = busqueda;
            sql = "Select businessname, id, password, country, fulladdress, city, stateorprovince, cp, active FROM Comercio where email=?";
        }
        if(Busqueda.FBID==b){
            this.fbid=busqueda;
            sql="Select id, businessname, email, password, country, fulladdress, city, stateorprovince, cp, active FROM Comercio where fbid=?";
        }
        establecerConexion();
        stm = conexion.con.prepareStatement(sql);
        if (Busqueda.BUSINESSNAME==b) stm.setString(1, businessname);
        if (Busqueda.EMAIL==b) stm.setString(1, email);
        if (Busqueda.FBID==b)stm.setString(1,fbid);
        rs = stm.executeQuery();
        rs.next();
        this.id = rs.getInt("id");
        if (Busqueda.EMAIL==b) this.businessname = rs.getString("businessname");
        if (Busqueda.BUSINESSNAME==b) this.email = rs.getString("email");
        if (Busqueda.FBID==b){
            this.email = rs.getString("email");
            this.businessname = rs.getString("businessname");
        }
        this.password = rs.getString("password");
        this.country = rs.getString("country");
        this.fulladdress = rs.getString("fulladdress");
        this.city = rs.getString("city");
        this.stateorprovince = rs.getString("stateorprovince");
        this.cp = rs.getString("cp");
        this.active = rs.getBoolean("active");
        rs.close();
        getOptionals();
        conexion.con.close();
        
    }

    /**
     * Constuctor de RegistroComercio Sirve para crear un Comercio nuevo
     *
     * @param businessname
     * @param email
     * @param password
     * @param country
     * @param fulladdress
     * @param city
     * @param stateorprovince
     * @param cp
     * @param active
     * @throws SQLException
     */
    public Comercio(String businessname, String email, String password, String country, String fulladdress, String city, String stateorprovince, String cp, boolean active) throws SQLException {
        this.businessname = businessname;
        this.email = email;
        this.password = password;
        this.country = country;
        this.fulladdress = fulladdress;
        this.city = city;
        this.stateorprovince = stateorprovince;
        this.cp = cp;
        this.active = active;
        sql = "Insert INTO Comercio (businessname, email, password, country, fulladdress, city, stateorprovince, cp, active) VALUES(?,?,?,?,?,?,?,?,?) ";
        establecerConexion();
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, businessname);
        stm.setString(2, email);
        stm.setString(3, password);
        stm.setString(4, country);
        stm.setString(5, fulladdress);
        stm.setString(6, city);
        stm.setString(7, stateorprovince);
        stm.setString(8, cp);
        stm.setBoolean(9, active);
        stm.execute();
        getIdBBDD();
        conexion.con.close();
        

    }

    /**
     * Métodos Setter
     */
    /**
     *
     *
     * @throws SQLException
     */
    public void deleteComercio() throws SQLException {
        establecerConexion();
        sql = "Delete Comercio where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, getId());
        stm.executeUpdate();
        stm.close();
        conexion.con.close();

    }
    
    /**
     * @param businessname the businessname to set
     * @throws SQLException
     */
    public void setBusinessname(String businessname) throws SQLException {
        this.businessname = businessname;
        establecerConexion();
        sql = "Update comercio set businessname=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, businessname);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     * @param email the email to set
     * @throws SQLException
     */
    public void setEmail(String email) throws SQLException {
        this.email = email;
        establecerConexion();
        sql = "Update comercio set email=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, email);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     * @param password the password to set
     * @throws SQLException
     */
    public void setPassword(String password) throws SQLException {
        this.password = password;
        establecerConexion();
        sql = "Update comercio set password=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, password);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     * @param country the country to set
     * @throws SQLException
     */
    public void setCountry(String country) throws SQLException {
        this.country = country;
        establecerConexion();
        sql = "Update comercio set country=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, country);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     * @param fulladdress the fulladress to set
     * @throws SQLException
     */
    public void setFulladress(String fulladdress) throws SQLException {
        this.fulladdress = fulladdress;
        establecerConexion();
        sql = "Update comercio set fulladdress=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, fulladdress);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     * @param stateorprovince the stateorprovince to set
     * @throws SQLException
     */
    public void setStateorprovince(String stateorprovince) throws SQLException {
        this.stateorprovince = stateorprovince;
        establecerConexion();
        sql = "Update comercio set stateorprovince=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, stateorprovince);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     * @param cp the cp to set
     * @throws SQLException
     */
    public void setCp(String cp) throws SQLException {
        this.cp = cp;
        establecerConexion();
        sql = "Update comercio set cp=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, cp);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     * @param description the description to set
     * @throws SQLException
     */
    public void setDescription(String description) throws SQLException {
        this.description = description;
        establecerConexion();
        sql = "Update comercio set description=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, description);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     * @param profileimageurl the profileimageurl to set
     * @throws SQLException
     */
    public void setProfileimageurl(String profileimageurl) throws SQLException {
        this.profileimageurl = profileimageurl;
        establecerConexion();
        sql = "Update comercio set profileimageurl=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, profileimageurl);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     * @param active the active to set
     * @throws SQLException
     */
    public void setActive(boolean active) throws SQLException {
        this.active = active;
        establecerConexion();
        sql = "Update comercio set active=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setBoolean(1, active);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     * @param city
     * @throws SQLException
     */
    public void setCity(String city) throws SQLException {
        this.city = city;
        establecerConexion();
        sql = "Update comercio set city=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, city);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     *
     * @param longitude
     * @throws SQLException
     */
    public void setLongitude(Double longitude) throws SQLException {
        this.longitude = longitude;
        establecerConexion();
        sql = "Update comercio set longitude=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setDouble(1, longitude);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     *
     * @param latitude
     * @throws SQLException
     */
    public void setLatitude(Double latitude) throws SQLException {
        this.latitude = latitude;
        establecerConexion();
        sql = "Update comercio set latitude=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setDouble(1, latitude);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }
    
    /**
     * @param fbid the fbid to set
     * @throws java.sql.SQLException
     */
    public void setFbid(String fbid) throws SQLException {
        this.fbid = fbid;
        establecerConexion();
        sql = "Update comercio set fbid=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, fbid);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }
    /**
     * @param franquiciaID the franquiciaID to set
     */
    public void setFranquiciaID(int franquiciaID) throws SQLException {
        this.franquiciaID = franquiciaID;
        establecerConexion();
        sql = "Update comercio set franquiciaID=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, franquiciaID);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }
    /**
     * Métodos Getters
     */
    
    
    /**
     * 
     * @return 
     */
    public String getCountry() {
        return country;
    }

    /**
     * @return the fulladdress
     */
    public String getFulladdress() {
        return fulladdress;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the fbid
     */
    public String getFbid() {
        return fbid;
    }
    /**
     * @return the stateorprovince
     */
    public String getStateorprovince() {
        return stateorprovince;
    }

    /**
     * @return the cp
     */
    public String getCp() {
        return cp;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the profileimageurl
     */
    public String getProfileimageurl() {
        return profileimageurl;
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
     * @return the franquiciaID
     */
    public int getFranquiciaID() {
        return franquiciaID;
    }

    
    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Métodos Getter BBDD Opcionales
     */
    private void getDescriptionBBDD() throws SQLException {
        establecerConexion();
        sql = "Select description FROM Comercio where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, getId());
        rs = stm.executeQuery();
        if(rs.next())this.description = rs.getString("description");
        conexion.con.close();
    }

    private void getProfileimageurlBBDD() throws SQLException {
        establecerConexion();
        sql = "Select profileimageurl FROM Comercio where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, getId());
        rs = stm.executeQuery();
        if(rs.next())this.profileimageurl = rs.getString("profileimageurl");
        conexion.con.close();
    }

    private void getLongitudeBBDD() throws SQLException {
        establecerConexion();
        sql = "Select longitude FROM Comercio where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, getId());
        rs = stm.executeQuery();
        if(rs.next())this.longitude = rs.getDouble("longitude");
        conexion.con.close();
    }

    private void getLatitudeBBDD() throws SQLException {
        establecerConexion();
        sql = "Select latitude FROM Comercio where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, getId());
        rs = stm.executeQuery();
        if(rs.next())this.latitude = rs.getDouble("latitude");
        conexion.con.close();
    }
    
    private void getFbidBBDD() throws SQLException{
        establecerConexion();
        sql = "Select fbid FROM Comercio where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, getId());
        rs = stm.executeQuery();
        rs.next();
        if(rs.next())this.fbid=(rs.getString("fbid"));
        conexion.con.close();
    }
    
    private void getIdBBDD() throws SQLException{
        establecerConexion();
        sql = "Select max(id) from Comercio";
        rs = stm.executeQuery(sql);
        while (rs.next()) {
           this.id=rs.getInt(1);
        }
        conexion.con.close();

    }
    private void getFranquiciaidBBDD() throws SQLException{
        establecerConexion();
        sql = "Select franquiciaID FROM Comercio where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, getId());
        rs = stm.executeQuery();
        if(rs.next())this.franquiciaID=(rs.getInt("franquiciaID"));
        conexion.con.close();

    }
    private void getOptionals() throws SQLException {
        getLatitudeBBDD();
        getLongitudeBBDD();
        getProfileimageurlBBDD();
        getDescriptionBBDD();
        getFranquiciaidBBDD();
    }
    
    /**
     * Métodos de la Base de Datos
     */
    
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
