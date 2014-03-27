/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BBDD;

import BBDD.tables.Franquicia;
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
public class TestFranquicia {
    Franquicia franquicia;
    
    public TestFranquicia() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws SQLException {
         franquicia = new Franquicia(1);
        
        franquicia.setName("juan");
        franquicia.setCp("545");
        franquicia.setFulladdress("holaquetal");
        franquicia.setStateorprovince("alejandria");
        franquicia.setCountry("yokese");
        franquicia.setCity("palma");
        franquicia.setLatitude(34.2);
        franquicia.setLongitude(45.5);
        franquicia.setProfileimageurl("hola");
        franquicia.setBackground("negro");
    
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void existe() {
         Assert.assertNotNull(franquicia.getName());
         Assert.assertNotNull(franquicia.getCp());
         Assert.assertNotNull(franquicia.getFulladdress());
         Assert.assertNotNull(franquicia.getStateorprovince());
         Assert.assertNotNull(franquicia.getCountry());
         Assert.assertNotNull(franquicia.getCity());
         Assert.assertNotNull(franquicia.getLatitude());
         Assert.assertNotNull(franquicia.getLongitude());
         Assert.assertNotNull(franquicia.getProfileimageurl());
         Assert.assertNotNull(franquicia.getBackground());
     }
}
