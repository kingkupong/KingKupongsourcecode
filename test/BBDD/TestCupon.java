
package BBDD;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BBDD.tables.Cupon;
import java.sql.SQLException;
import java.util.Date;
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
public class TestCupon {

    Cupon cupon;
    Date fecha = new Date(2009-1900,9,9);
    public TestCupon() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws SQLException {

        cupon = new Cupon(1);
        cupon.setAvailquota(1);
        cupon.setBackgroundimageurl("images/url.png");
        cupon.setBusinessId(1);
        cupon.setCode("XGXAsladf5~swa");
        cupon.setConditions("Mayor de 19 años");
        cupon.setCouponimageurl("images/cupon.png");
        cupon.setDateexpiration(new java.sql.Date (fecha.getTime()));
        cupon.setDatestart(new java.sql.Date (fecha.getTime()));
        cupon.setDescription("Este cupon es una cosa");
        cupon.setName("Cosa");
        cupon.setPrice(100);
        cupon.setRealprice(50);
        cupon.setTitle("Cupon inverso");
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
    public void testGetters() {
        assertNotNull("id", cupon.getId());
        assertNotNull("businessid", cupon.getBusinessid());
        assertNotNull("code", cupon.getCode());
        assertNotNull("name", cupon.getName());
        assertNotNull("title", cupon.getTitle());
        assertNotNull("description", cupon.getDescription());
        assertNotNull("datestart", cupon.getDatestart());
        assertNotNull("dateexpiration", cupon.getDateexpiration());
        assertNotNull("backgroundimageurl", cupon.getBackgroundimageurl());
        assertNotNull("price", cupon.getPrice());
        assertNotNull("realprice", cupon.getRealprice());
        assertNotNull("conditions", cupon.getConditions());
        assertNotNull("availquota", cupon.getAvailquota());
        assertNotNull("couponimageurl", cupon.getCouponimageurl());

    }

}
