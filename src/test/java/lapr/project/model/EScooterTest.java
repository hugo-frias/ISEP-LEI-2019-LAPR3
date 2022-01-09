package lapr.project.model;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EScooterTest {

    @BeforeAll
    public static void setUpClass() throws SQLException {
    }

    public EScooterTest() {
    }

    /**
     * Test of getEsDescription method, of class EScooter.
     */
    @Test
    public void testGetESDescription1() {
        System.out.println("getEsDescription1");
        EScooter instance = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        String expResult = "PT-E500";
        String result = instance.getDescription();
        assertEquals(expResult, result);

    }

    /**
     * Test of getEsDescription method, of class EScooter.
     */
    @Test
    public void testGetESDescription2() {
        System.out.println("getEsDescription2");
        EScooter instance = new EScooter("PT-E510", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        String expResult = "PT-E510";
        String result = instance.getDescription();
        assertEquals(expResult, result);

    }

    /**
     * Test of getEsDescription method, of class EScooter.
     */
    @Test
    public void testGetESDescription3() {
        System.out.println("getEsDescription3");
        EScooter instance = new EScooter("PT-E130", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        String expResult = "PT-E130";
        String result = instance.getDescription();
        assertEquals(expResult, result);

    }

    /**
     * Test of getWeight method, of class EScooter.
     */
    @Test
    public void testGetWeight1() {
        System.out.println("getWeight1");
        EScooter instance = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        int expResult = 15;
        int result = instance.getWeight();
        assertEquals(expResult, result);

    }

    /**
     * Test of getWeight method, of class EScooter.
     */
    @Test
    public void testGetWeight2() {
        System.out.println("getWeight2");
        EScooter instance = new EScooter("PT-E500", 25, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        int expResult = 25;
        int result = instance.getWeight();
        assertEquals(expResult, result);

    }

    /**
     * Test of getWeight method, of class EScooter.
     */
    @Test
    public void testGetWeight3() {
        System.out.println("getWeight3");
        EScooter instance = new EScooter("PT-E500", 45, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        int expResult = 45;
        int result = instance.getWeight();
        assertEquals(expResult, result);

    }

    /**
     * Test of getEsType method, of class EScooter.
     */
    @Test
    public void testGetEsType1() {
        System.out.println("getEsType1");
        EScooter instance = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        String expResult = "off-road";
        String result = instance.getEsType();
        assertEquals(expResult, result);

    }

    /**
     * Test of getEsType method, of class EScooter.
     */
    @Test
    public void testGetEsType2() {
        System.out.println("getEsType2");
        EScooter instance = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "city", 100, 50, 250);
        String expResult = "city";
        String result = instance.getEsType();
        assertEquals(expResult, result);

    }

    /**
     * Test of getParkLatitude method, of class EScooter.
     */
    @Test
    public void testGetParkLatitude1() {
        System.out.println("getParkLatitude1");
        EScooter instance = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        double expResult = 15.5;
        double result = instance.getParkLatitude();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getParkLatitude method, of class EScooter.
     */
    @Test
    public void testGetParkLatitude2() {
        System.out.println("getParkLatitude2");
        EScooter instance = new EScooter("PT-E500", 15, -20.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        double expResult = -20.5;
        double result = instance.getParkLatitude();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getParkLatitude method, of class EScooter.
     */
    @Test
    public void testGetParkLatitude3() {
        System.out.println("getParkLatitude3");
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        double expResult = -14.5;
        double result = instance.getParkLatitude();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getParkLongitude method, of class EScooter.
     */
    @Test
    public void testGetParkLongitude1() {
        System.out.println("getParkLongitude1");
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        double expResult = -16.6;
        double result = instance.getParkLongitude();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getParkLongitude method, of class EScooter.
     */
    @Test
    public void testGetParkLongitude2() {
        System.out.println("getParkLongitude2");
        EScooter instance = new EScooter("PT-E500", 15, -14.5, 20.2, 30, 20, "off-road", 100, 50, 250);
        double expResult = 20.2;
        double result = instance.getParkLongitude();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getParkLongitude method, of class EScooter.
     */
    @Test
    public void testGetParkLongitude3() {
        System.out.println("getParkLongitude3");
        EScooter instance = new EScooter("PT-E500", 15, -14.5, 17.2, 30, 20, "off-road", 100, 50, 250);
        double expResult = 17.2;
        double result = instance.getParkLongitude();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getMaxBatteryCapacity method, of class EScooter.
     */
    @Test
    public void testGetMaxBatteryCapacity1() {
        System.out.println("getMaxBatteryCapacity1");
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        int expResult = 100;
        int result = instance.getMaxBatteryCapacity();
        assertEquals(expResult, result);

    }

    /**
     * Test of getMaxBatteryCapacity method, of class EScooter.
     */
    @Test
    public void testGetMaxBatteryCapacity2() {
        System.out.println("getMaxBatteryCapacity2");
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 30, 20, "off-road", 110, 50, 250);
        int expResult = 110;
        int result = instance.getMaxBatteryCapacity();
        assertEquals(expResult, result);

    }

    /**
     * Test of getMaxBatteryCapacity method, of class EScooter.
     */
    @Test
    public void testGetMaxBatteryCapacity3() {
        System.out.println("getMaxBatteryCapacity3");
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 30, 20, "off-road", 150, 50, 250);
        int expResult = 150;
        int result = instance.getMaxBatteryCapacity();
        assertEquals(expResult, result);

    }

    /**
     * Test of getActualBatteryCapacity method, of class EScooter.
     */
    @Test
    public void testGetActualBatteryCapacity1() {
        System.out.println("getActualBatteryCapacity1");
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        int expResult = 50;
        int result = instance.getActualBatteryCapacity();
        assertEquals(expResult, result);

    }

    /**
     * Test of getActualBatteryCapacity method, of class EScooter.
     */
    @Test
    public void testGetActualBatteryCapacity2() {
        System.out.println("getActualBatteryCapacity2");
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 30, 20, "off-road", 100, 70, 250);
        int expResult = 70;
        int result = instance.getActualBatteryCapacity();
        assertEquals(expResult, result);

    }

    /**
     * Test of getActualBatteryCapacity method, of class EScooter.
     */
    @Test
    public void testGetActualBatteryCapacity3() {
        System.out.println("getActualBatteryCapacity3");
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 30, 20, "off-road", 100, 55, 250);
        int expResult = 55;
        int result = instance.getActualBatteryCapacity();
        assertEquals(expResult, result);

    }

    /**
     * Test of getAerodynamicCoefficient method, of class EScooter.
     */
    @Test
    public void testGetAerodynamicCoefficient1() {
        System.out.println("getAerodynamicCoefficient1");
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 23.3, 20.7, "off-road", 100, 50, 250);
        double expResult = 23.3;
        double result = instance.getAerodynamicCoefficient();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getAerodynamicCoefficient method, of class EScooter.
     */
    @Test
    public void testGetAerodynamicCoefficient2() {
        System.out.println("getAerodynamicCoefficient2");
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 29.0, 20.7, "off-road", 100, 50, 250);
        double expResult = 29.0;
        double result = instance.getAerodynamicCoefficient();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getAerodynamicCoefficient method, of class EScooter.
     */
    @Test
    public void testGetAerodynamicCoefficient3() {
        System.out.println("getAerodynamicCoefficient3");
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 25.7, 20.7, "off-road", 100, 50, 250);
        double expResult = 25.7;
        double result = instance.getAerodynamicCoefficient();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getFrontalArea method, of class EScooter.
     */
    @Test
    public void testGetFrontalArea1() {
        System.out.println("getFrontalArea1");
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 29.0, 20.7, "off-road", 100, 50, 250);
        double expResult = 20.7;
        double result = instance.getFrontalArea();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getFrontalArea method, of class EScooter.
     */
    @Test
    public void testGetFrontalArea2() {
        System.out.println("getFrontalArea2");
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 29.0, 30.0, "off-road", 100, 50, 250);
        double expResult = 30.0;
        double result = instance.getFrontalArea();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getFrontalArea method, of class EScooter.
     */
    @Test
    public void testGetFrontalArea3() {
        System.out.println("getFrontalArea3");
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 250);
        double expResult = 9.7;
        double result = instance.getFrontalArea();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of setEsDescription method, of class EScooter.
     */
    @Test
    public void testSetEsDescription1() {
        System.out.println("setEsDescription1");
        String esDescription = "PT-E100";
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 250);
        instance.setDescription(esDescription);

    }

    /**
     * Test of setEsDescription method, of class EScooter.
     */
    @Test
    public void testSetEsDescription2() {
        System.out.println("setEsDescription2");
        String esDescription = "PT-E900";
        EScooter instance = new EScooter("PT-E135", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 250);
        instance.setDescription(esDescription);

    }

    /**
     * Test of setEsDescription method, of class EScooter.
     */
    @Test
    public void testSetEsDescription3() {
        System.out.println("setEsDescription3");
        String esDescription = "PT-E150";
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 250);
        instance.setDescription(esDescription);

    }

    /**
     * Test of setWeight method, of class EScooter.
     */
    @Test
    public void testSetWeight1() {
        System.out.println("setWeight1");
        int weight = 10;
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 250);
        instance.setWeight(weight);

    }

    /**
     * Test of setWeight method, of class EScooter.
     */
    @Test
    public void testSetWeight2() {
        System.out.println("setWeight2");
        int weight = 20;
        EScooter instance = new EScooter("PT-E550", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 250);
        instance.setWeight(weight);

    }

    /**
     * Test of setWeight method, of class EScooter.
     */
    @Test
    public void testSetWeight3() {
        System.out.println("setWeight3");
        int weight = 20;
        EScooter instance = new EScooter("PT-E200", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 250);
        instance.setWeight(weight);

    }

    /**
     * Test of setEsType method, of class EScooter.
     */
    @Test
    public void testSetEsType1() {
        System.out.println("setEsType1");
        String esType = "city";
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 250);
        instance.setEsType(esType);

    }

    /**
     * Test of setEsType method, of class EScooter.
     */
    @Test
    public void testSetEsType2() {
        System.out.println("setEsType2");
        String esType = "off-road";
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 29.0, 9.7, "city", 100, 50, 250);
        instance.setEsType(esType);

    }

    /**
     * Test of setEsType method, of class EScooter.
     */
    @Test
    public void testSetEsType3() {
        System.out.println("setEsType3");
        String esType = "off-road";
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 29.0, 9.7, "city", 100, 50, 250);
        instance.setEsType(esType);

    }

    /**
     * Test of setParkLatitude method, of class EScooter.
     */
    @Test
    public void testSetParkLatitude1() {
        System.out.println("setParkLatitude1");
        double parkLatitude = -20.0;
        EScooter instance = new EScooter("PT-E501", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 250);
        instance.setParkLatitude(parkLatitude);

    }

    /**
     * Test of setParkLatitude method, of class EScooter.
     */
    @Test
    public void testSetParkLatitude2() {
        System.out.println("setParkLatitude2");
        double parkLatitude = 20.0;
        EScooter instance = new EScooter("PT-E550", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 250);
        instance.setParkLatitude(parkLatitude);

    }

    /**
     * Test of setParkLatitude method, of class EScooter.
     */
    @Test
    public void testSetParkLatitude3() {
        System.out.println("setParkLatitude3");
        double parkLatitude = -10.0;
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 250);
        instance.setParkLatitude(parkLatitude);

    }

    /**
     * Test of setParkLongitude method, of class EScooter.
     */
    @Test
    public void testSetParkLongitude1() {
        System.out.println("setParkLongitude1");
        double parkLongitude = 20.0;
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 250);
        instance.setParkLongitude(parkLongitude);

    }

    /**
     * Test of setParkLongitude method, of class EScooter.
     */
    @Test
    public void testSetParkLongitude2() {
        System.out.println("setParkLongitude2");
        double parkLongitude = -3.0;
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 250);
        instance.setParkLongitude(parkLongitude);

    }

    /**
     * Test of setParkLongitude method, of class EScooter.
     */
    @Test
    public void testSetParkLongitude3() {
        System.out.println("setParkLongitude3");
        double parkLongitude = -20.0;
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 250);
        instance.setParkLongitude(parkLongitude);

    }

    /**
     * Test of setMaxBatteryCapacity method, of class EScooter.
     */
    @Test
    public void testSetMaxBatteryCapacity1() {
        System.out.println("setMaxBatteryCapacity1");
        int maxBatteryCapacity = 150;
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 250);
        instance.setMaxBatteryCapacity(maxBatteryCapacity);

    }

    /**
     * Test of setMaxBatteryCapacity method, of class EScooter.
     */
    @Test
    public void testSetMaxBatteryCapacity2() {
        System.out.println("setMaxBatteryCapacity2");
        int maxBatteryCapacity = 120;
        EScooter instance = new EScooter("PT-E502", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 250);
        instance.setMaxBatteryCapacity(maxBatteryCapacity);

    }

    /**
     * Test of setMaxBatteryCapacity method, of class EScooter.
     */
    @Test
    public void testSetMaxBatteryCapacity3() {
        System.out.println("setMaxBatteryCapacity3");
        int maxBatteryCapacity = 80;
        EScooter instance = new EScooter("PT-E501", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 250);
        instance.setMaxBatteryCapacity(maxBatteryCapacity);

    }

    /**
     * Test of setActualBatteryCapacity method, of class EScooter.
     */
    @Test
    public void testSetActualBatteryCapacity1() {
        System.out.println("setActualBatteryCapacity1");
        int actualBatteryCapacity = 60;
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 110, 50, 250);
        instance.setActualBatteryCapacity(actualBatteryCapacity);

    }

    /**
     * Test of setActualBatteryCapacity method, of class EScooter.
     */
    @Test
    public void testSetActualBatteryCapacity2() {
        System.out.println("setActualBatteryCapacity2");
        int actualBatteryCapacity = 30;
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 150, 50, 250);
        instance.setActualBatteryCapacity(actualBatteryCapacity);

    }

    /**
     * Test of setActualBatteryCapacity method, of class EScooter.
     */
    @Test
    public void testSetActualBatteryCapacity3() {
        System.out.println("setActualBatteryCapacity3");
        int actualBatteryCapacity = 50;
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 250);
        instance.setActualBatteryCapacity(actualBatteryCapacity);

    }

    /**
     * Test of setAerodynamicCoefficient method, of class EScooter.
     */
    @Test
    public void testSetAerodynamicCoefficient1() {
        System.out.println("setAerodynamicCoefficient1");
        double aerodynamicCoefficient = 30.0;
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 250);
        instance.setAerodynamicCoefficient(aerodynamicCoefficient);

    }

    /**
     * Test of setAerodynamicCoefficient method, of class EScooter.
     */
    @Test
    public void testSetAerodynamicCoefficient2() {
        System.out.println("setAerodynamicCoefficient2");
        double aerodynamicCoefficient = 20.0;
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 250);
        instance.setAerodynamicCoefficient(aerodynamicCoefficient);

    }

    /**
     * Test of setAerodynamicCoefficient method, of class EScooter.
     */
    @Test
    public void testSetAerodynamicCoefficient3() {
        System.out.println("setAerodynamicCoefficient3");
        double aerodynamicCoefficient = 10.0;
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 250);
        instance.setAerodynamicCoefficient(aerodynamicCoefficient);

    }

    /**
     * Test of setFrontalArea method, of class EScooter.
     */
    @Test
    public void testSetFrontalArea1() {
        System.out.println("setFrontalArea1");
        double frontalArea = 10;
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 250);
        instance.setFrontalArea(frontalArea);

    }

    /**
     * Test of setFrontalArea method, of class EScooter.
     */
    @Test
    public void testSetFrontalArea2() {
        System.out.println("setFrontalArea2");
        double frontalArea = 20;
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 250);
        instance.setFrontalArea(frontalArea);

    }

    /**
     * Test of setFrontalArea method, of class EScooter.
     */
    @Test
    public void testSetFrontalArea3() {
        System.out.println("setFrontalArea3");
        double frontalArea = 30;
        EScooter instance = new EScooter("E500", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 250);
        instance.setFrontalArea(frontalArea);

    }
    
    /**
     * Test of getMotor method, of class EScooter.
     */
    @Test
    public void testGetMotor1() {
        System.out.println("getMotor1");
        EScooter instance = new EScooter("PT-E500", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 250);
        int expResult = 250;
        int result = instance.getMotor();
        assertEquals(expResult, result);
       
    }
    /**
     * Test of getMotor method, of class EScooter.
     */
    @Test
    public void testGetMotor2() {
        System.out.println("getMotor2");
        EScooter instance = new EScooter("E500", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 200);
        int expResult = 200;
        int result = instance.getMotor();
        assertEquals(expResult, result);
       
    }
    /**
     * Test of getMotor method, of class EScooter.
     */
    @Test
    public void testGetMotor3() {
        System.out.println("getMotor3");
        EScooter instance = new EScooter("E600", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 150);
        int expResult = 150;
        int result = instance.getMotor();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setMotor method, of class EScooter.
     */
    @Test
    public void testSetMotor1() {
        System.out.println("setMotor1");
        int motor = 150;
        EScooter instance = new EScooter("E500", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 250);
        instance.setMotor(motor);
    }
    
    /**
     * Test of setMotor method, of class EScooter.
     */
    @Test
    public void testSetMotor2() {
        System.out.println("setMotor2");
        int motor = 170;
        EScooter instance = new EScooter("E500", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 250);
        instance.setMotor(motor);
    }
    /**
     * Test of setMotor method, of class EScooter.
     */
    @Test
    public void testSetMotor3() {
        System.out.println("setMotor3");
        int motor = 180;
        EScooter instance = new EScooter("E500", 15, -14.5, -16.6, 29.0, 9.7, "off-road", 100, 50, 250);
        instance.setMotor(motor);
    }




}
