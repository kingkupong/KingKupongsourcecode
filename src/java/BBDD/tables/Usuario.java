/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BBDD.tables;

import BBDD.utilities.Conector;
import BBDD.utilities.Consultas;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Boomeraling
 */
public class Usuario {

  

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
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
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
     * @return the fulladdress
     */
    public String getFulladdress() {
        return fulladdress;
    }

    /**
     * @return the registerDate
     */
    public Date getRegisterDate() {
        return registerDate;
    }

    /**
     * @return the latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * @return the longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * @return the profilesimageurl
     */
    public String getProfilesimageurl() {
        return profileimageurl;
    }

    /**
     * @return the lastLogin
     */
    public Date getLastLogin() {
        return lastLogin;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    public enum Busqueda {

        EMAIL, USERNAME, FBID
    }

    private int id;
    private String fbid;
    private String username;
    private String email;
    private String password;
    private String country;
    private String city;
    private String stateorprovince;
    private String cp;
    private String fulladdress;
    private Date lastLogin, registerDate;
    private Double latitude, longitude;
    private String profileimageurl;

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
    public Usuario(int id) throws SQLException {
        this.id = id;
        establecerConexion();
        sql = "Select username, email, password, country, stateorprovince FROM usuario where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, id);
        rs = stm.executeQuery();
        rs.next();
        this.username = rs.getString("username");
        this.email = rs.getString("email");
        this.password = rs.getString("password");
        this.country = rs.getString("country");
        this.stateorprovince = rs.getString("stateorprovince");
        rs.close();
        stm.close();
        getOptionals();
        conexion.con.close();
    }

    /**
     * Este es un Constructor que dado el valor del nombre carga todos los
     * valores al objeto creado
     *
     * @param busqueda
     * @param b
     * @throws SQLException
     */
    public Usuario(String busqueda, Busqueda b) throws SQLException {
        if (Busqueda.USERNAME == b) {
            this.username = busqueda;
            sql = "Select id, email, password, country, stateorprovince FROM Usuario where username=?";
        }
        if (Busqueda.EMAIL == b) {
            this.email = busqueda;
            sql = "Select username, id, password, country, stateorprovince FROM Usuario where email=?";
        }
        if (Busqueda.FBID==b){
            this.fbid=busqueda;
            sql = "Select username, email, id, password, country, stateorprovince FROM Usuario where email=?";
        }
        establecerConexion();
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, busqueda);

        rs = stm.executeQuery();
        rs.next();
        this.id = rs.getInt("id");
        if (Busqueda.EMAIL == b) {
            this.username = rs.getString("username");
        }
        if (Busqueda.USERNAME == b) {
            this.email = rs.getString("email");
        }
        if (Busqueda.FBID==b){
            this.email = rs.getString("email");
            this.username = rs.getString("username");
        }

        this.password = rs.getString("password");
        this.country = rs.getString("country");
        this.stateorprovince = rs.getString("stateorprovince");

        rs.close();
        stm.close();
        conexion.con.close();

    }

    /**
     * Constuctor de RegistroComercio Sirve para crear un Comercio nuevo
     *
     * @param username
     * @param email
     * @param password
     * @param country
     * @param stateorprovince
     * @throws SQLException
     */
    public Usuario(String username, String email, String password, String country, String stateorprovince) throws SQLException {
        this.username = username;
        this.email = email;
        this.password = password;
        this.country = country;
        this.stateorprovince = stateorprovince;
        sql = "Insert into Usuario (username, email, password, country, stateorprovince) VALUES(?,?,?,?,?)";
        establecerConexion();
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, username);
        stm.setString(2, email);
        stm.setString(3, password);
        stm.setString(4, country);
        stm.setString(5, stateorprovince);
        stm.executeUpdate();
        getIdBBDD();
        conexion.con.close();

    }

    /**
     * @param username the username to set
     * @throws java.sql.SQLException
     */
    public void setUsername(String username) throws SQLException {
        this.username = username;
        establecerConexion();
        sql = "Update Usuario set username=(?) where id=(?)";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, username);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     * @param email the email to set
     * @throws java.sql.SQLException
     */
    public void setEmail(String email) throws SQLException {
        this.email = email;
        establecerConexion();
        sql = "Update Usuario set email=(?) where id=(?)";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, email);
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
        sql = "Update Usuario set fbid=(?) where id=(?)";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, fbid);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     * @param password the password to set
     * @throws java.sql.SQLException
     */
    public void setPassword(String password) throws SQLException {
        this.password = password;
        establecerConexion();
        sql = "Update Usuario set password=(?) where id=(?)";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, password);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     * @param country the country to set
     * @throws java.sql.SQLException
     */
    public void setCountry(String country) throws SQLException {
        this.country = country;
        establecerConexion();
        sql = "Update Usuario set country=(?) where id=(?)";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, country);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     * @param fulladdress the fulladdress to set
     * @throws java.sql.SQLException
     */
    public void setFulladdress(String fulladdress) throws SQLException {
        this.fulladdress = fulladdress;
        establecerConexion();
        sql = "Update Usuario set fulladdress=(?) where id=(?)";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, fulladdress);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     * @param city the city to set
     * @throws java.sql.SQLException
     */
    public void setCity(String city) throws SQLException {
        this.city = city;
        establecerConexion();
        sql = "Update Usuario set city=(?) where id=(?)";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, city);
        stm.setInt(2, id);
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
        sql = "Update Usuario set stateorprovince=(?) where id=(?)";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, stateorprovince);
        stm.setInt(2, id);
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
        sql = "Update Usuario set cp=(?) where id=(?)";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, cp);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }

    /**
     * @param profilesimageurl the profilesimageurl to set
     * @throws java.sql.SQLException
     */
    public void setProfilesimageurl(String profilesimageurl) throws SQLException {
        this.profileimageurl = profilesimageurl;
        establecerConexion();
        sql = "Update Usuario set profileimageurl=(?) where id=(?)";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, profilesimageurl);
        stm.setInt(2, id);
        conexion.con.close();
    }

    public void setLongitude(Double longitude) throws SQLException {
        this.longitude = longitude;
        establecerConexion();
        sql = "Update Usuario set longitude=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setDouble(1, longitude);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }

    private void establecerConexion() throws SQLException {
        if (conexion == null) {
            conexion = new Conector();
        } else if (conexion.con.isClosed()) {
            conexion = new Conector();
        }
    }

    public void setLatitude(Double latitude) throws SQLException {
        this.latitude = latitude;
        establecerConexion();
        sql = "Update usuario set latitude=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setDouble(1, latitude);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }

    public void setRegisterDate(Date registerDate) throws SQLException {
        this.registerDate = registerDate;
        establecerConexion();
        sql = "Update usuario set registerDate=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setDate(1, registerDate);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }

    public void setLastLogin(Date lastLogin) throws SQLException {
        this.lastLogin = lastLogin;
        establecerConexion();
        sql = "Update usuario set registerDate=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setDate(1, lastLogin);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }

    private void getLongitudeBBDD() throws SQLException {
        establecerConexion();
        sql = "Select longitude FROM Usuario where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, getId());
        rs = stm.executeQuery();
        if(rs.next())this.longitude = rs.getDouble("longitude");
        conexion.con.close();
    }

    private void getLatitudeBBDD() throws SQLException {
        establecerConexion();
        sql = "Select latitude FROM Usuario where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, id);
        rs = stm.executeQuery();
        if(rs.next())this.latitude = rs.getDouble("latitude");
        conexion.con.close();
    }

    private void getProfileimageurlBBDD() throws SQLException {
        establecerConexion();
        sql = "Select profileimageurl FROM Usuario where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, getId());
        rs = stm.executeQuery();
        if(rs.next())this.profileimageurl = rs.getString("profileimageurl");
        conexion.con.close();
    }

    private void getFbidBBDD() throws SQLException {
        establecerConexion();
        sql = "Select fbid FROM Usuario where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, getId());
        rs = stm.executeQuery();
        if(rs.next())this.fbid = rs.getString("fbid");
        conexion.con.close();
    }

    private void getRegisterDateBBDD() throws SQLException {
        establecerConexion();
        sql = "Select registerdate FROM Usuario where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, getId());
        rs = stm.executeQuery();
        if(rs.next())this.registerDate = rs.getDate("registerdate");
        conexion.con.close();
    }

    private void getLastLoginBBDD() throws SQLException {
        establecerConexion();
        sql = "Select lastlogin FROM Usuario where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, getId());
        rs = stm.executeQuery();
        if(rs.next())this.lastLogin = rs.getDate("lastlogin");
        conexion.con.close();
    }

    private void getFullAddressBBDD() throws SQLException {
        establecerConexion();
        sql = "Select fulladdress FROM Usuario where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, getId());
        rs = stm.executeQuery();
        if(rs.next()) this.fulladdress = rs.getString("fulladdress");
        conexion.con.close();
    }

    private void getCityBBDD() throws SQLException {
        establecerConexion();
        sql = "Select city FROM Usuario where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, getId());
        rs = stm.executeQuery();
        if(rs.next())this.city = rs.getString("city");
        conexion.con.close();
    }

    private void getIdBBDD() throws SQLException {
        establecerConexion();
        sql = "Select max(id) from Usuario";
        rs = stm.executeQuery(sql);
        while (rs.next()) {
            this.id = rs.getInt(1);
        }
        conexion.con.close();

    }

    private void getOptionals() throws SQLException {
        getLatitudeBBDD();
        getLongitudeBBDD();
        getProfileimageurlBBDD();
        getFbidBBDD();
        getRegisterDateBBDD();
        getLastLoginBBDD();
        getFullAddressBBDD();
        getCityBBDD();

    }

}
