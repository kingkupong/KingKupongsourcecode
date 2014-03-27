/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BBDD;

import BBDD.tables.Franquiciado;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrador
 */
public class TestFranquiciado {
    Franquiciado franquiciado;
    
    public TestFranquiciado() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws SQLException {
        franquiciado = new Franquiciado(1);
        franquiciado.setName("pepe");
        franquiciado.setSurname("mena");
        franquiciado.setNIF("3424");
        franquiciado.setAddress("werwer");
        franquiciado.setMail("agga@gmail.com");
        franquiciado.setTelefono("423424");
        franquiciado.setPassword("fsdfd");
        franquiciado.setFbid("2");
        franquiciado.setProfileimageurl("sdfdf");
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void existe() {
     franquiciado.getName();
     franquiciado.getSurname();
     franquiciado.getNIF();
     franquiciado.getAddress();
     franquiciado.getMail();
     franquiciado.getTelefono();
     franquiciado.getPassword();
     franquiciado.getFbid();
     franquiciado.getProfileimageurl();
     }
}
