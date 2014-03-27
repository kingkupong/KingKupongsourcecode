/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BBDD;

import BBDD.tables.Usuario;
import java.sql.Date;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrador
 */
public class TestUsuario {
        Date fecha = new Date(2009-1900,9,9);
        Usuario user;
    
    public TestUsuario() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws SQLException {
        user = new Usuario(2);
        user.setFbid("2");
        user.setCp("56");
        user.setFulladdress("2");
        user.setCity("2");
        user.setProfilesimageurl("localhost/a.png");
        user.setLatitude(20.5);
        user.setLongitude(100.5);
        user.setRegisterDate(new java.sql.Date (fecha.getTime()));
        user.setLastLogin(new java.sql.Date (fecha.getTime()));
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void existe() {
         Assert.assertNotNull(user.getUsername()) ;
        Assert.assertNotNull(user.getEmail()) ;
        Assert.assertNotNull(user.getPassword()) ;
        Assert.assertNotNull(user.getCountry()) ;
        Assert.assertNotNull(user.getStateorprovince()) ;
        Assert.assertNotNull(user.getRegisterDate());
        Assert.assertNotNull(user.getLastLogin());
        Assert.assertNotNull(user.getLongitude());
        Assert.assertNotNull(user.getLatitude());
        Assert.assertNotNull(user.getProfilesimageurl());
        Assert.assertNotNull(user.getCity());
        Assert.assertNotNull(user.getFulladdress());
        Assert.assertNotNull(user.getCp());
        Assert.assertNotNull(user.getFbid());
     }
}
