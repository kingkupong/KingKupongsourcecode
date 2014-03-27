/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BBDD.utilities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Boomeraling
 */
public class Consultas {
    public enum Tabla{
         USUARIO, FRANQUICIADO, FRANQUICIA, COMERCIO, CUPON, MENSAJE, NOTIFICACION
     }

     /**
     *
     * Base de datos
     *
     */
    private Tabla tabla;
    static Conector conexion = null;
    static PreparedStatement stm = null;
    static String sql;
    static ResultSet rs;
    
    
    public static void establecerConexion() throws SQLException {
        if (conexion == null) {
            conexion = new Conector();
        } else if (conexion.con.isClosed()) {
            conexion = new Conector();
        }
    }
    
    /**
     * Búsquedas del usuario
     * @throws SQLException 
     */
    
    private static String selectTable(Tabla t)
    {
        switch (t){
            case USUARIO:
                return("Usuario");
            case COMERCIO:
                return("Comercio");
            case FRANQUICIADO:
                return("Franquiciado"); 
            case FRANQUICIA:
                return("Franquicia");
            case CUPON:
                return("CUPON");
            case MENSAJE:
                return("Mensaje");
            case NOTIFICACION:
                return ("Notificacion");
        }
           return null;
    }
    public static void listadoEmails(Tabla t) throws SQLException{
        establecerConexion();
    
        sql="Select email from "+selectTable(t);
        stm=conexion.con.prepareStatement(sql);
        rs=stm.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString(1));
        }
    }
    
    public static void listadoNombre(Tabla t) throws SQLException{
        establecerConexion();
        sql="Select name from "+selectTable(t);
        if (t==Consultas.Tabla.USUARIO) sql="Select username from "+selectTable(t);
        if (t==Consultas.Tabla.COMERCIO) sql="Select businessname from "+selectTable(t);
        stm=conexion.con.prepareStatement(sql);
        rs=stm.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString(1));
        }
    }
    
    public static void listadoNombreParecido(Tabla t, String nombre) throws SQLException{
        establecerConexion();
        sql="Select name from "+selectTable(t)+" where businessname like ?";
        if (t==Consultas.Tabla.USUARIO) sql="Select username from "+selectTable(t)+" where username like ?";
        if (t==Consultas.Tabla.COMERCIO) sql="Select businessname from "+selectTable(t)+" where businessname like ?";
        stm=conexion.con.prepareStatement(sql);
        rs=stm.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString(1));
        }
    }
  
  public static boolean existeMailUsuario(String email) throws SQLException{
      establecerConexion();
      sql="Select * from Usuario where email=?";
      stm=conexion.con.prepareStatement(sql);
      stm.setString(1,email);
      rs=stm.executeQuery();
      if(rs.next()){
          conexion.con.close();
          return true;
      }
      conexion.con.close();
      return false;
  }
     public static boolean existeMailComercio(String email) throws SQLException {
         establecerConexion();
        sql = "Select email from Comercio where email=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, email);
        rs = stm.executeQuery();
        if(rs.next()){
          conexion.con.close();
          return true;
      }
      conexion.con.close();
      return false;
    }
     public static boolean existeMailFranquiciado(String email) throws SQLException {
         establecerConexion();
        sql = "Select email from Franquiciado where email=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, email);
        rs = stm.executeQuery();
        if(rs.next()){
          conexion.con.close();
          return true;
      }
      conexion.con.close();
      return false;
    }
     public static boolean checkPasswordUsuario(String email, String password) throws SQLException {
         establecerConexion();
        sql = "Select password from Usuario where email=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, email);
        rs = stm.executeQuery();
        rs.next();
        if (password.equalsIgnoreCase(rs.getString("password"))) {
            conexion.con.close();
            return true;
        } else {
            conexion.con.close();
            return false;
        }
    }
     public static boolean checkPasswordComercio(String email, String password) throws SQLException {
         establecerConexion();
        sql = "Select password from Comercio where email=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, email);
        rs = stm.executeQuery();
        rs.next();
        if (password.equalsIgnoreCase(rs.getString("password"))) {
            conexion.con.close();
            return true;
        } else {
            conexion.con.close();
            return false;
        }
    }
     public static boolean checkPasswordFranquiciado(String email, String password) throws SQLException {
         establecerConexion();
        sql = "Select password from Franquiciado where email=?";
        stm = conexion.con.prepareStatement(sql);
        stm.setString(1, email);
        rs = stm.executeQuery();
        rs.next();
        if (password.equalsIgnoreCase(rs.getString("password"))) {
            conexion.con.close();
            return true;
        } else {
            conexion.con.close();
            return false;
        }
    }
    
}
