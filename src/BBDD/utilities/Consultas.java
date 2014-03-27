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
     /**
     *
     * Base de datos
     *
     */
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
    
    public static void listadoEmailsUsuario() throws SQLException{
        establecerConexion();
        sql="Select email from Usuario";
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
