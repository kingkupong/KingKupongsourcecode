/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BBDD.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Boomeraling
 */
public class Conector {

    public Connection con = null;
    private PreparedStatement stm = null;
    private String adress = "localhost/kupoi";
    private String usuario = "root";
    private String password = "";

    
    
    
    /**
     * @param adress - Dirección de la base de datos
     * @param usuario - Usuario de la base de datos
     * @param password - Contraseña de la base de datos
     */
    public Conector() throws ClassNotFoundException {

        if (con == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://" + adress, usuario, password);
            } catch (SQLException ex) {
                Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Conector(String adress, String usuario, String password) {
        if (con == null) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + adress, usuario, password);
            } catch (SQLException ex) {
                Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
