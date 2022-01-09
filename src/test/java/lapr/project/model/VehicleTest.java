/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Vera Pinto
 */
public class VehicleTest {

    public VehicleTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of getDescription method, of class Vehicle.
     */
    @Test
    public void testGetDescription1() {
        System.out.println("getDescription1");
        Vehicle instance = new EScooter("E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        String expResult = "E500";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class Vehicle.
     */
    @Test
    public void testGetDescription2() {
        System.out.println("getDescription2");
        Vehicle instance = new Bicycle("B500", 50, 20.78, 22.89, 30, 50, 15);
        String expResult = "B500";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class Vehicle.
     */
    @Test
    public void testGetDescription3() {
        System.out.println("getDescription3");
        Vehicle instance = new Bicycle("B600", 50, 20.78, 22.89, 30, 50, 17);
        String expResult = "B600";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class Vehicle.
     */
    @Test
    public void testGetDescription4() {
        System.out.println("getDescription4");
        Vehicle instance = new EScooter("E700", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        String expResult = "E700";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWeight method, of class Vehicle.
     */
    @Test
    public void testGetWeight1() {
        System.out.println("getWeight1");
        Vehicle instance = new EScooter("E600", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        int expResult = 15;
        int result = instance.getWeight();
        assertEquals(expResult, result);

    }

    /**
     * Test of getWeight method, of class Vehicle.
     */
    @Test
    public void testGetWeight2() {
        System.out.println("getWeight2");
        Vehicle instance = new Bicycle("B100", 20, 20.78, 22.89, 30, 50, 15);
        int expResult = 20;
        int result = instance.getWeight();
        assertEquals(expResult, result);

    }

    /**
     * Test of getWeight method, of class Vehicle.
     */
    @Test
    public void testGetWeight3() {
        System.out.println("getWeight3");
        Vehicle instance = new Bicycle("B100", 50, 20.78, 22.89, 30, 50, 17);
        int expResult = 50;
        int result = instance.getWeight();
        assertEquals(expResult, result);

    }

    /**
     * Test of getWeight method, of class Vehicle.
     */
    @Test
    public void testGetWeight4() {
        System.out.println("getWeight4");
        Vehicle instance = new EScooter("E600", 30, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        int expResult = 30;
        int result = instance.getWeight();
        assertEquals(expResult, result);

    }

    /**
     * Test of getParkLatitude method, of class Vehicle.
     */
    @Test
    public void testGetParkLatitude1() {
        System.out.println("getParkLatitude1");
        Vehicle instance = new EScooter("E600", 30, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        double expResult = 15.5;
        double result = instance.getParkLatitude();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getParkLatitude method, of class Vehicle.
     */
    @Test
    public void testGetParkLatitude2() {
        System.out.println("getParkLatitude2");
        Vehicle instance = new EScooter("E600", 30, -15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        double expResult = -15.5;
        double result = instance.getParkLatitude();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getParkLatitude method, of class Vehicle.
     */
    @Test
    public void testGetParkLatitude3() {
        System.out.println("getParkLatitude3");
        Vehicle instance = new Bicycle("B100", 50, 20.78, 22.89, 30, 50, 15);
        double expResult = 20.78;
        double result = instance.getParkLatitude();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getParkLatitude method, of class Vehicle.
     */
    @Test
    public void testGetParkLatitude4() {
        System.out.println("getParkLatitude4");
        Vehicle instance = new Bicycle("B100", 50, -20.78, 22.89, 30, 50, 19);
        double expResult = -20.78;
        double result = instance.getParkLatitude();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getParkLongitude method, of class Vehicle.
     */
    @Test
    public void testGetParkLongitude1() {
        System.out.println("getParkLongitude1");
        Vehicle instance = new EScooter("E600", 30, -15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        double expResult = -16.6;
        double result = instance.getParkLongitude();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getParkLongitude method, of class Vehicle.
     */
    @Test
    public void testGetParkLongitude2() {
        System.out.println("getParkLongitude2");
        Vehicle instance = new Bicycle("B100", 50, -20.78, 22.89, 30, 50, 15);
        double expResult = 22.89;
        double result = instance.getParkLongitude();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getParkLongitude method, of class Vehicle.
     */
    @Test
    public void testGetParkLongitude3() {
        System.out.println("getParkLongitude3");
        Vehicle instance = new Bicycle("B100", 50, -20.78, -22.89, 30, 50, 17);
        double expResult = -22.89;
        double result = instance.getParkLongitude();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getParkLongitude method, of class Vehicle.
     */
    @Test
    public void testGetParkLongitude4() {
        System.out.println("getParkLongitude4");
        Vehicle instance = new EScooter("E600", 30, -15.5, 16.6, 30, 20, "off-road", 100, 50, 250);
        double expResult = 16.6;
        double result = instance.getParkLongitude();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getAerodynamicCoefficient method, of class Vehicle.
     */
    @Test
    public void testGetAerodynamicCoefficient1() {
        System.out.println("getAerodynamicCoefficient1");
        Vehicle instance = new EScooter("E600", 30, -15.5, 16.6, 30.2, 20, "off-road", 100, 50, 250);
        double expResult = 30.2;
        double result = instance.getAerodynamicCoefficient();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getAerodynamicCoefficient method, of class Vehicle.
     */
    @Test
    public void testGetAerodynamicCoefficient2() {
        System.out.println("getAerodynamicCoefficient2");
        Vehicle instance = new EScooter("E600", 30, -15.5, 16.6, 20.3, 20, "off-road", 100, 50, 250);
        double expResult = 20.3;
        double result = instance.getAerodynamicCoefficient();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getAerodynamicCoefficient method, of class Vehicle.
     */
    @Test
    public void testGetAerodynamicCoefficient3() {
        System.out.println("getAerodynamicCoefficient3");
        Vehicle instance = new Bicycle("B100", 50, -20.78, -22.89, 20.5, 50, 15);
        double expResult = 20.5;
        double result = instance.getAerodynamicCoefficient();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getAerodynamicCoefficient method, of class Vehicle.
     */
    @Test
    public void testGetAerodynamicCoefficient4() {
        System.out.println("getAerodynamicCoefficient4");
        Vehicle instance = new Bicycle("B100", 50, -20.78, -22.89, 10.6, 50, 17);
        double expResult = 10.6;
        double result = instance.getAerodynamicCoefficient();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getFrontalArea method, of class Vehicle.
     */
    @Test
    public void testGetFrontalArea1() {
        System.out.println("getFrontalArea1");
        Vehicle instance = new Bicycle("B100", 50, -20.78, -22.89, 10.6, 50, 17);
        double expResult = 50;
        double result = instance.getFrontalArea();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getFrontalArea method, of class Vehicle.
     */
    @Test
    public void testGetFrontalArea2() {
        System.out.println("getFrontalArea2");
        Vehicle instance = new Bicycle("B100", 50, -20.78, -22.89, 10.6, 50.6, 19);
        double expResult = 50.6;
        double result = instance.getFrontalArea();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getFrontalArea method, of class Vehicle.
     */
    @Test
    public void testGetFrontalArea3() {
        System.out.println("getFrontalArea3");
        Vehicle instance = new EScooter("E600", 30, -15.5, 16.6, 20.3, 20.2, "off-road", 100, 50, 250);
        double expResult = 20.2;
        double result = instance.getFrontalArea();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getFrontalArea method, of class Vehicle.
     */
    @Test
    public void testGetFrontalArea4() {
        System.out.println("getFrontalArea4");
        Vehicle instance = new EScooter("E600", 30, -15.5, 16.6, 20.3, 20.65, "city", 100, 50, 250);
        double expResult = 20.65;
        double result = instance.getFrontalArea();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of setDescription method, of class Vehicle.
     */
    @Test
    public void testSetDescription1() {
        System.out.println("setDescription1");
        String description = "PT-E200";
        Vehicle instance = new EScooter("E600", 30, -15.5, 16.6, 20.3, 20.65, "city", 100, 50, 250);
        instance.setDescription(description);

    }

    /**
     * Test of setDescription method, of class Vehicle.
     */
    @Test
    public void testSetDescription2() {
        System.out.println("setDescription2");
        String description = "PT-E100";
        Vehicle instance = new EScooter("E600", 30, -15.5, 16.6, 20.3, 20.65, "city", 100, 50, 250);
        instance.setDescription(description);

    }

    /**
     * Test of setDescription method, of class Vehicle.
     */
    @Test
    public void testSetDescription3() {
        System.out.println("setDescription3");
        String description = "PT-B102";
        Vehicle instance = new Bicycle("B100", 50, -20.78, -22.89, 10.6, 50.6, 15);
        instance.setDescription(description);

    }

    /**
     * Test of setDescription method, of class Vehicle.
     */
    @Test
    public void testSetDescription4() {
        System.out.println("setDescription4");
        String description = "PT-B900";
        Vehicle instance = new Bicycle("B100", 50, -20.78, -22.89, 10.6, 50.6, 17);
        instance.setDescription(description);

    }

    /**
     * Test of setWeight method, of class Vehicle.
     */
    @Test
    public void testSetWeight1() {
        System.out.println("setWeight1");
        int weight = 20;
        Vehicle instance = new EScooter("E600", 30, -15.5, 16.6, 20.3, 20.65, "city", 100, 50, 250);
        instance.setWeight(weight);

    }

    /**
     * Test of setWeight method, of class Vehicle.
     */
    @Test
    public void testSetWeight2() {
        System.out.println("setWeight2");
        int weight = 30;
        Vehicle instance = new EScooter("E650", 30, -15.5, 16.6, 20.3, 20.65, "city", 100, 50, 250);
        instance.setWeight(weight);

    }

    /**
     * Test of setWeight method, of class Vehicle.
     */
    @Test
    public void testSetWeight3() {
        System.out.println("setWeight3");
        int weight = 40;
        Vehicle instance = new Bicycle("B150", 50, -20.78, -22.89, 10.6, 50.6, 17);
        instance.setWeight(weight);

    }

    /**
     * Test of setWeight method, of class Vehicle.
     */
    @Test
    public void testSetWeight4() {
        System.out.println("setWeight4");
        int weight = 20;
        Vehicle instance = new Bicycle("B100", 50, -20.78, -22.89, 10.6, 50.6, 17);
        instance.setWeight(weight);

    }

    /**
     * Test of setParkLatitude method, of class Vehicle.
     */
    @Test
    public void testSetParkLatitude1() {
        System.out.println("setParkLatitude1");
        double parkLatitude = -10.0;
        Vehicle instance = new Bicycle("B100", 50, -20.78, -22.89, 10.6, 50.6, 19);
        instance.setParkLatitude(parkLatitude);

    }

    /**
     * Test of setParkLatitude method, of class Vehicle.
     */
    @Test
    public void testSetParkLatitude2() {
        System.out.println("setParkLatitude2");
        double parkLatitude = -15.5;
        Vehicle instance = new Bicycle("B150", 50, -20.78, -22.89, 10.6, 50.6, 15);
        instance.setParkLatitude(parkLatitude);

    }

    /**
     * Test of setParkLatitude method, of class Vehicle.
     */
    @Test
    public void testSetParkLatitude3() {
        System.out.println("setParkLatitude3");
        double parkLatitude = -20.5;
        Vehicle instance = new EScooter("E650", 30, -15.5, 16.6, 20.3, 20.65, "city", 100, 50, 250);
        instance.setParkLatitude(parkLatitude);

    }

    /**
     * Test of setParkLatitude method, of class Vehicle.
     */
    @Test
    public void testSetParkLatitude4() {
        System.out.println("setParkLatitude4");
        double parkLatitude = 20.0;
        Vehicle instance = new EScooter("E650", 30, -15.5, 16.6, 20.3, 20.65, "city", 100, 50, 250);
        instance.setParkLatitude(parkLatitude);

    }

    /**
     * Test of setParkLongitude method, of class Vehicle.
     */
    @Test
    public void testSetParkLongitude1() {
        System.out.println("setParkLongitude1");
        double parkLongitude = -15.0;
        Vehicle instance = new EScooter("E650", 30, -15.5, 16.6, 20.3, 20.65, "city", 100, 50, 250);
        instance.setParkLongitude(parkLongitude);

    }

    /**
     * Test of setParkLongitude method, of class Vehicle.
     */
    @Test
    public void testSetParkLongitude2() {
        System.out.println("setParkLongitude2");
        double parkLongitude = -20.0;
        Vehicle instance = new EScooter("E600", 30, -15.5, 16.6, 20.3, 20.65, "city", 100, 50, 250);
        instance.setParkLongitude(parkLongitude);

    }

    /**
     * Test of setParkLongitude method, of class Vehicle.
     */
    @Test
    public void testSetParkLongitude3() {
        System.out.println("setParkLongitude3");
        double parkLongitude = 10.0;
        Vehicle instance = new Bicycle("B150", 50, -20.78, -22.89, 10.6, 50.6, 15);
        instance.setParkLongitude(parkLongitude);

    }

    /**
     * Test of setParkLongitude method, of class Vehicle.
     */
    @Test
    public void testSetParkLongitude4() {
        System.out.println("setParkLongitude4");
        double parkLongitude = -20.0;
        Vehicle instance = new Bicycle("B150", 50, -20.78, -22.89, 10.6, 50.6, 17);
        instance.setParkLongitude(parkLongitude);

    }

    /**
     * Test of setAerodynamicCoefficient method, of class Vehicle.
     */
    @Test
    public void testSetAerodynamicCoefficient1() {
        System.out.println("setAerodynamicCoefficient1");
        double aerodynamicCoefficient = 15.6;
        Vehicle instance = new Bicycle("B100", 50, -20.78, -22.89, 10.6, 50.6, 17);
        instance.setAerodynamicCoefficient(aerodynamicCoefficient);

    }

    /**
     * Test of setAerodynamicCoefficient method, of class Vehicle.
     */
    @Test
    public void testSetAerodynamicCoefficient2() {
        System.out.println("setAerodynamicCoefficient2");
        double aerodynamicCoefficient = 15.6;
        Vehicle instance = new Bicycle("B150", 50, -20.78, -22.89, 10.6, 50.6, 19);
        instance.setAerodynamicCoefficient(aerodynamicCoefficient);

    }

    /**
     * Test of setAerodynamicCoefficient method, of class Vehicle.
     */
    @Test
    public void testSetAerodynamicCoefficient3() {
        System.out.println("setAerodynamicCoefficient3");
        double aerodynamicCoefficient = 10.5;
        Vehicle instance = new EScooter("E600", 30, -15.5, 16.6, 20.3, 20.65, "city", 100, 50, 250);
        instance.setAerodynamicCoefficient(aerodynamicCoefficient);

    }

    /**
     * Test of setAerodynamicCoefficient method, of class Vehicle.
     */
    @Test
    public void testSetAerodynamicCoefficient4() {
        System.out.println("setAerodynamicCoefficient4");
        double aerodynamicCoefficient = 20.5;
        Vehicle instance = new EScooter("E650", 30, -15.5, 16.6, 20.3, 20.65, "city", 100, 50, 250);
        instance.setAerodynamicCoefficient(aerodynamicCoefficient);

    }

    /**
     * Test of setFrontalArea method, of class Vehicle.
     */
    @Test
    public void testSetFrontalArea1() {
        System.out.println("setFrontalArea1");
        double frontalArea = 20.0;
        Vehicle instance = new Bicycle("B150", 50, -20.78, -22.89, 10.6, 50.6, 15);
        instance.setFrontalArea(frontalArea);

    }

    /**
     * Test of setFrontalArea method, of class Vehicle.
     */
    @Test
    public void testSetFrontalArea2() {
        System.out.println("setFrontalArea2");
        double frontalArea = 30.0;
        Vehicle instance = new Bicycle("B150", 50, -20.78, -22.89, 10.6, 50.6, 15);
        instance.setFrontalArea(frontalArea);

    }

    /**
     * Test of setFrontalArea method, of class Vehicle.
     */
    @Test
    public void testSetFrontalArea3() {
        System.out.println("setFrontalArea3");
        double frontalArea = 20.0;
        Vehicle instance = new EScooter("E650", 30, -15.5, 16.6, 20.3, 20.65, "city", 100, 50, 250);
        instance.setFrontalArea(frontalArea);

    }

    /**
     * Test of setFrontalArea method, of class Vehicle.
     */
    @Test
    public void testSetFrontalArea4() {
        System.out.println("setFrontalArea4");
        double frontalArea = 10.5;
        Vehicle instance = new EScooter("E600", 30, -15.5, 16.6, 20.3, 20.65, "city", 100, 50, 250);
        instance.setFrontalArea(frontalArea);

    }

    /**
     * Test of equals method, of class Vehicle.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new Vehicle("B150", 50, -20.78, -22.89, 10.6, 50.6) {
        };
        Vehicle instance = new Vehicle("B150", 50, -20.78, -22.89, 10.6, 50.6) {
        };
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Vehicle.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals");
        Object obj = new User("Manuel", "a@gmail.com", "150", 160, 60, 'A', 15, 1234, 10);
        Vehicle instance = new Vehicle("B150", 50, -20.78, -22.89, 10.6, 50.6) {
        };
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Vehicle.
     */
    @Test
    public void testEquals3() {
        System.out.println("equals");
        Object obj = null;
        Vehicle instance = new Vehicle("B150", 50, -20.78, -22.89, 10.6, 50.6) {
        };
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Vehicle.
     */
    @Test
    public void testEquals4() {
        System.out.println("equals");
        Object obj = new Vehicle("BR-B150", 50, -20.78, -22.89, 10.6, 50.6) {
        };
        Vehicle instance = new Vehicle("PT-B150", 50, -20.78, -22.89, 10.6, 50.6) {
        };
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Vehicle.
     */
    @Test
    public void testEquals5() {
        System.out.println("equals");
        Vehicle obj = new Vehicle("B150", 41, -2.78, -3.89, 321.6, 21.6) {
        };
        Vehicle instance = new Vehicle("B150", 50, -20.78, -22.89, 10.6, 50.6) {
        };
        boolean actual = instance.equals(obj);
        assertFalse(actual);
    }

    @Test
    void testEquals6() {
        Vehicle p = new Vehicle("B150", 50, -20.78, -22.89, 10.6, 50.6) {
        };
        assertEquals(p, p);
        assertEquals(p.hashCode(), p.hashCode());
    }

    @Test
    void testEquals7() {
        Vehicle p1 = new Vehicle("B150", 50, -20.78, -22.89, 10.6, 50.6) {
        };
        Vehicle p2 = null;
        assertNotEquals(p1, p2);
    }

    @Test
    void testEquals8() {
        Vehicle p1 = new Vehicle("B150", 50, -20.78, -22.89, 10.6, 50.6) {
        };
        Poi p2 = new Poi();
        assertNotEquals(p1, p2);
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Vehicle instance;
        instance = new Vehicle() {
        };
        String expResult = "Vehicle{description=description, weight=0, parkLatitude=0.0, parkLongitude=0.0, aerodynamicCoefficient=0.0, frontalArea=0.0}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
