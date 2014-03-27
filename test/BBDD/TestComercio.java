package BBDD;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import BBDD.tables.Comercio;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Boomeraling
 */
public class TestComercio {

    Comercio comercio;

    public TestComercio() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws SQLException {
        comercio = new Comercio(1);
        comercio.setActive(false);
        comercio.setBusinessname("Mena Coop");
        comercio.setCity("Menaland");
        comercio.setCountry("Mena Paradise");
        comercio.setCp("07009");
        comercio.setDescription("Fabricante de menas");
        comercio.setFbid("XAFQWfa234##");
        comercio.setFulladress("Calle Mena");
        comercio.setLatitude(25.5);
        comercio.setLongitude(100.5);
        comercio.setProfileimageurl("localhost/a.png");
        comercio.setStateorprovince("Root");
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void Existe() {
        assertNotNull(comercio.getCity());
        assertNotNull(comercio.getCountry());
        assertNotNull(comercio.getCp());
        assertNotNull(comercio.getDescription());
        assertNotNull(comercio.getFbid());
        assertNotNull(comercio.getId());
        assertNotNull(comercio.getLatitude());
        assertNotNull(comercio.getLongitude());
        assertNotNull(comercio.getProfileimageurl());
        assertNotNull(comercio.getStateorprovince());
    }
    
    public void Escritura() throws SQLException{

    }
}
