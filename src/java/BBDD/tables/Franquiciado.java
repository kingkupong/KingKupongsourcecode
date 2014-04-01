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
public class Franquiciado {

    public void getFbid() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public enum Busqueda{
        NAME,EMAIL,FBID
     }
    
    private int id;
    private String name;
    private String surname;
    private String NIF;
    private String address;
    private String email;
    private String telefono;
    private String password;
    private String fbid;
    private String profileimageurl;
    
    
    private Conector conexion = null;
    private PreparedStatement stm = null;
    private String sql;
    private ResultSet rs;
    
    public Franquiciado(String busqueda, Busqueda b) throws SQLException{
        if (Busqueda.NAME==b)
        {
            this.name = busqueda;
            sql = "Select id, surname, password, NIF, address, email, telefono FROM Franquiciado where name=?";
        }
        if (Busqueda.EMAIL==b){
            this.email = busqueda;
            sql = "Select id, name, surname, password, NIF, address, telefono FROM Franquiciado where email=?";
        }
        if(Busqueda.FBID==b){
            this.fbid=busqueda;
            sql = "Select id, name, email, surname, password, NIF, address, telefono FROM Franquiciado where email=?";
        }
        establecerConexion();
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, busqueda);
        rs = stm.executeQuery();
        rs.next();
        this.id = rs.getInt("id");
        if (Busqueda.EMAIL==b) this.name = rs.getString("name");
        if (Busqueda.NAME==b) this.email = rs.getString("email");
        if (Busqueda.FBID==b){
            this.email = rs.getString("email");
            this.name = rs.getString("name");
        }
        this.password = rs.getString("password");
        this.surname=rs.getString("surname");
        this.NIF=rs.getString("NIF");
        this.address=rs.getString("address");
        this.telefono=rs.getString("telefono");
        rs.close();
        getOptionals();
        conexion.con.close();
    }
    public Franquiciado(int id) throws SQLException{
        establecerConexion();
        sql = "Select name, surname, password, NIF, address, email, telefono FROM Franquiciado where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, id);
        rs = stm.executeQuery();
        rs.next();
        this.name= rs.getString("name");
        this.surname = rs.getString("surname");
        this.password = rs.getString("password");
        this.NIF = rs.getString("NIF");
        this.address = rs.getString("address");
        this.email = rs.getString("email");
        this.telefono = rs.getString("telefono");
        getOptionals();
        conexion.con.close();
    }
    public Franquiciado(String name, String surname,String password, String NIF, String address, String email, String telefono) throws SQLException{
        this.NIF=NIF;
        this.name=name;
        this.surname=surname;
        this.password=password;
        this.address=address;
        this.email=email;
        this.telefono=telefono;
        sql = "Insert INTO Franquiciado (name,surname,NIF,address,email,telefono,password) VALUES(?,?,?,?,?,?,?) ";
        establecerConexion();
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, name);
        stm.setString(2, surname);
        stm.setString(3, NIF);
        stm.setString(4, address);
        stm.setString(5, email);
        stm.setString(6, telefono);
        stm.setString(7, password);
        stm.execute();
        getIdBBDD();
        
        conexion.con.close();
        
    }
    
    /**
     * 
     * Setters
     * 
     */

    /**
     * @param name the name to set
     */
    public void setName(String name) throws SQLException {
        this.name = name;
        establecerConexion();
        sql = "Update Franquiciado set name=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, name);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }
    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) throws SQLException {
        this.surname = surname;
        establecerConexion();
        sql = "Update Franquiciado set surname=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, surname);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }
    public void setProfileimageurl(String profileimageurl) throws SQLException {
        this.profileimageurl = profileimageurl;
        establecerConexion();
        sql = "Update Franquiciado set profileimageurl=(?) where id=(?)";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, profileimageurl);
        stm.setInt(2, id);
        conexion.con.close();
    }
    
    public void setPassword(String password) throws SQLException {
       this.password = password;
        establecerConexion();
        sql = "Update Franquiciado set password=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, password);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }
    
    public void setFbid(String fbid) throws SQLException {
        this.fbid = fbid;
        establecerConexion();
        sql = "Update Franquiciado set fbid=(?) where id=(?)";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, fbid);
        stm.setInt(2, id);
        stm.executeUpdate();
        conexion.con.close();
    }
    /**
     * @param NIF the NIF to set
     */
    public void setNIF(String NIF) throws SQLException {
        this.NIF = NIF;
        establecerConexion();
        sql = "Update Franquiciado set NIF=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, NIF);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }
    /**
     * @param address the address to set
     */
    public void setAddress(String address) throws SQLException {
        this.address = address;
        establecerConexion();
        sql = "Update Franquiciado set address=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, address);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }
    /**
     * @param mail the mail to set
     */
    public void setMail(String email) throws SQLException {
        this.email = email;
        establecerConexion();
        sql = "Update Franquiciado set email=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, email);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }
    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) throws SQLException {
        this.telefono = telefono;
        establecerConexion();
        sql = "Update Franquiciado set telefono=? where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, telefono);
        stm.setInt(2,id);
        stm.executeUpdate();
        conexion.con.close();
    }
    
    /**
     * Getters 
     */
    
    
    
    
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
     * @return the name
     */
    public String getPassword() {
        return password;
    }
     /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }
 /**
     * @return the profileimageurl
     */
    public String getProfileimageurl() {
        return profileimageurl;
    }
   /**
     * @return the NIF
     */
    public String getNIF() {
        return NIF;
    }
    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }
    /**
     * @return the mail
     */
    public String getMail() {
        return email;
    }
    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }
    
    /**
     * @return the fbid
     */
    public String getfbid() {
        return fbid;
    }
    
    
    
    
    
    
    
    
    
    
    
    private void getIdBBDD() throws SQLException{
        establecerConexion();
        sql = "Select max(id) from Franquiciado";
        rs = stm.executeQuery(sql);
        while (rs.next()) {
           this.id=rs.getInt(1);
        }
        conexion.con.close();

    }
    private void getProfileimageurlBBDD() throws SQLException {
        establecerConexion();
        sql = "Select profileimageurl FROM Franquiciado where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, getId());
        rs = stm.executeQuery();
        if(rs.next()) this.profileimageurl = rs.getString("profileimageurl");
        conexion.con.close();
    }
    private void getFbidBBDD() throws SQLException {
        establecerConexion();
        sql = "Select fbid FROM Franquiciado where id=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setInt(1, getId());
        rs = stm.executeQuery();
        if(rs.next()) this.fbid = rs.getString("fbid");
        conexion.con.close();
    }
    
    private void getOptionals() throws SQLException{
        getFbidBBDD();
        getProfileimageurlBBDD();
    }
    
    
     private void establecerConexion() throws SQLException {
        if (conexion == null) {
            conexion = new Conector();
        } else if (conexion.con.isClosed()) {
            conexion = new Conector();
        }
    }
}
