/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Ignore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;

public class PoiTest {

    @BeforeEach
    void setUp() {
        try {
            Properties properties
                    = new Properties(System.getProperties());
            InputStream input = new FileInputStream("target/classes/application.properties");
            properties.load(input);
            input.close();
            System.setProperties(properties);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PoiTest() {
    }

    /**
     * Test of getLatitude method, of class Poi.
     */
    @Test
    public void testGetLatitude1() {
        System.out.println("getLatitude");
        Poi instance = new Poi("1", 1, 2, 30, "Nice place to rest");
        double expResult = 1.0;
        double result = instance.getLatitude();
        assertEquals(expResult, result, 3);
    }

    /**
     * Test of getLatitude method, of class Poi.
     */
    @Test
    public void testGetLatitude2() {
        System.out.println("getLatitude");
        Poi instance = new Poi("1", 10, 2, 30, "Nice place to rest");
        double expResult = 10.0;
        double result = instance.getLatitude();
        assertEquals(expResult, result, 3);
    }

    /**
     * Test of getLatitude method, of class Poi.
     */
    @Test
    public void testGetLatitude3() {
        System.out.println("getLatitude");
        Poi instance = new Poi("1", 5, 2, 30, "Nice place to rest");
        double expResult = 5.0;
        double result = instance.getLatitude();
        assertEquals(expResult, result, 3);
    }

    /**
     * Test of getLongitude method, of class Poi.
     */
    @Test
    public void testGetLongitude1() {
        System.out.println("getLongitude");
        Poi instance = new Poi("1", 5, 2, 30, "Nice place to rest");
        double expResult = 2.0;
        double result = instance.getLongitude();
        assertEquals(expResult, result, 3);
    }

    /**
     * Test of getLongitude method, of class Poi.
     */
    @Test
    public void testGetLongitude2() {
        System.out.println("getLongitude");
        Poi instance = new Poi("1", 5, 21, 30, "Nice place to rest");
        double expResult = 21.0;
        double result = instance.getLongitude();
        assertEquals(expResult, result, 3);
    }

    /**
     * Test of getLongitude method, of class Poi.
     */
    @Test
    public void testGetLongitude3() {
        System.out.println("getLongitude");
        Poi instance = new Poi("1", 5, 32, 30, "Nice place to rest");
        double expResult = 32.0;
        double result = instance.getLongitude();
        assertEquals(expResult, result, 3);
    }

    /**
     * Test of getElevation method, of class Poi.
     */
    @Test
    public void testGetElevation1() {
        System.out.println("getElevation");
        Poi instance = new Poi("1", 5, 32, 30, "Nice place to rest");
        int expResult = 30;
        int result = instance.getElevation();
        assertEquals(expResult, result, 3);
    }

    /**
     * Test of getElevation method, of class Poi.
     */
    @Test
    public void testGetElevation2() {
        System.out.println("getElevation");
        Poi instance = new Poi("1", 5, 32, 39, "Nice place to rest");
        int expResult = 39;
        int result = instance.getElevation();
        assertEquals(expResult, result, 3);
    }

    /**
     * Test of getElevation method, of class Poi.
     */
    @Test
    public void testGetElevation3() {
        System.out.println("getElevation");
        Poi instance = new Poi("1", 5, 32, 130, "Nice place to rest");
        int expResult = 130;
        int result = instance.getElevation();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPoiDescription method, of class Poi.
     */
    @Test
    public void testGetPoiDescription1() {
        System.out.println("getPoiDescription");
        Poi instance = new Poi("1", 5, 32, 130, "Nice place to rest");
        String expResult = "Nice place to rest";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPoiDescription method, of class Poi.
     */
    @Test
    public void testGetPoiDescription2() {
        System.out.println("getPoiDescription");
        Poi instance = new Poi("1", 5, 32, 130, "Nice place to rest and drink");
        String expResult = "Nice place to rest and drink";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPoiDescription method, of class Poi.
     */
    @Test
    public void testGetPoiDescription3() {
        System.out.println("getPoiDescription");
        Poi instance = new Poi("1", 5, 32, 130, "Nice place to rest and sleep");
        String expResult = "Nice place to rest and sleep";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLatitude method, of class Poi.
     */
    @Test
    public void testSetLatitude1() {
        System.out.println("setLatitude");
        Poi instance = new Poi("1", 5, 32, 130, "Nice place to rest and sleep");
        double latitude = 1;
        instance.setLatitude(latitude);
    }

    /**
     * Test of setLatitude method, of class Poi.
     */
    @Test
    public void testSetLatitude2() {
        System.out.println("setLatitude");
        Poi instance = new Poi("1", 5, 32, 130, "Nice place to rest and sleep");
        double latitude = 0.0;
        instance.setLatitude(latitude);
    }

    /**
     * Test of setLatitude method, of class Poi.
     */
    @Test
    public void testSetLatitude3() {
        System.out.println("setLatitude");
        Poi instance = new Poi("1", 5, 32, 130, "Nice place to rest and sleep");
        double latitude = 10.0;
        instance.setLatitude(latitude);
    }

    /**
     * Test of setLongitude method, of class Poi.
     */
    @Test
    public void testSetLongitude1() {
        System.out.println("setLongitude");
        Poi instance = new Poi("1", 5, 32, 130, "Nice place to rest and sleep");
        double longitude = 0.0;
        instance.setLongitude(longitude);
    }

    /**
     * Test of setLongitude method, of class Poi.
     */
    @Test
    public void testSetLongitude2() {
        System.out.println("setLongitude");
        Poi instance = new Poi("1", 5, 32, 130, "Nice place to rest and sleep");
        double longitude = 10.5;
        instance.setLongitude(longitude);
    }

    /**
     * Test of setLongitude method, of class Poi.
     */
    @Test
    public void testSetLongitude3() {
        System.out.println("setLongitude");
        Poi instance = new Poi("1", 5, 32, 130, "Nice place to rest and sleep");
        double longitude = 20.0;
        instance.setLongitude(longitude);
    }

    /**
     * Test of setElevation method, of class Poi.
     */
    @Test
    public void testSetElevation1() {
        System.out.println("setElevation");
        Poi instance = new Poi("1", 5, 32, 130, "Nice place to rest and sleep");
        int elevation = 120;
        instance.setElevation(elevation);
    }

    /**
     * Test of setElevation method, of class Poi.
     */
    @Test
    public void testSetElevation2() {
        System.out.println("setElevation");
        Poi instance = new Poi("1", 5, 32, 130, "Nice place to rest and sleep");
        int elevation = 0;
        instance.setElevation(elevation);
    }

    /**
     * Test of setElevation method, of class Poi.
     */
    @Test
    public void testSetElevation3() {
        System.out.println("setElevation");
        Poi instance = new Poi("1", 5, 32, 130, "Nice place to rest and sleep");
        int elevation = 8;
        instance.setElevation(elevation);
    }

    /**
     * Test of setPoiDescription method, of class Poi.
     */
    @Test
    public void testSetPoiDescription1() {
        System.out.println("setPoiDescription");
        Poi instance = new Poi("1", 5, 32, 130, "Nice place to rest and sleep");
        String poiDescription = "";
        instance.setDescription(poiDescription);
    }

    /**
     * Test of setPoiDescription method, of class Poi.
     */
    @Test
    public void testSetPoiDescription2() {
        System.out.println("setPoiDescription");
        Poi instance = new Poi("1", 5, 32, 130, "Nice place to rest and sleep");
        String poiDescription = "Testing it";
        instance.setDescription(poiDescription);
    }

    /**
     * Test of setPoiDescription method, of class Poi.
     */
    @Test
    public void testSetPoiDescription3() {
        System.out.println("setPoiDescription");
        Poi instance = new Poi("1", 5, 32, 130, "Nice place to rest and sleep");
        String poiDescription = "Let's go";
        instance.setDescription(poiDescription);
    }

    @Test
    void getID() {
        Poi instance = new Poi("1", 19, 200, 4, "Cool Poi");
        instance.setId("5");
        assertEquals("5", instance.getId());
    }

    @Test
    void setID() {
        Poi instance = new Poi("1", 19, 200, 4, "Cool Poi");
        String id = "5";
        instance.setId(id);
    }

//    /**
//     * Test of save method, of class Poi.
//     */
//    @Ignore
//    public void testSave() throws SQLException {
//        System.out.println("save");
//        Poi instance = new Poi();
//        instance.save();
//    }
//
//    /**
//     * Test of update method, of class Poi.
//     */
//    @Ignore
//    public void testUpdate() {
//        System.out.println("update");
//        Poi instance = new Poi();
//        instance.update();
//    }
//
//    /**
//     * Test of delete method, of class Poi.
//     */
//    @Ignore
//    public void testDelete() {
//        System.out.println("delete");
//        Poi instance = new Poi();
//        instance.delete();
//    }

    @Test
    void testEquals1() {
        Poi p = new Poi();
        assertEquals(p, p);
        assertEquals(p.hashCode(), p.hashCode());
    }

    @Test
    void testEquals2() {
        Poi p1 = new Poi();
        Poi p2 = null;
        assertNotEquals(p1, p2);
    }

    @Test
    void testEquals3() {
        Poi p1 = new Poi();
        Path p2 = new Path();
        assertNotEquals(p1, p2);
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void testEquals4() {
        Poi p1 = new Poi("1", 2, 3, 4, "df");
        Poi p2 = new Poi("1", 2, 3, 4, "df");
        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void testEquals5() {
        Poi p1 = new Poi("1", 2, 3, 4, "df");
        Poi p2 = new Poi("2", 3, 3, 4, "df");
        assertNotEquals(p1, p2);
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }

    @Ignore
    public void testToString() {
        System.out.println("toString");
        Poi instance = new Poi("1", 2, 3, 4, "df");
        String expResult = "Id: 1, Latitude: 2.000, Longitude: 3.000, Elevation: 4, Description: df";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Ignore
    public void testToString2() {
        System.out.println("toString");
        Poi instance = new Poi();
        String expResult = "Id: null, Latitude: 0.000, Longitude: 0.000, Elevation: 0, Description: null";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
