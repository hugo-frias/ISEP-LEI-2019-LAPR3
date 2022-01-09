package lapr.project.model;

import org.junit.jupiter.api.Test;
import org.junit.Ignore;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ParkTest {

    public ParkTest() {
    }

    /**
     * Test of getParkID method, of class Park.
     */
    @Test
    public void testGetParkID1() {
        System.out.println("getParkID1");
        Park instance = new Park("1", 23.3, -10.2, 5, "Trindade", 50, 20, 10.5, 14.5);
        String expResult = "1";
        String result = instance.getId();
        assertEquals(expResult, result);

    }

    /**
     * Test of getParkID method, of class Park.
     */
    @Test
    public void testGetParkID2() {
        System.out.println("getParkID2");
        Park instance = new Park("2", 23.3, -10.2, 5, "Trindade", 50, 20, 10.5, 14.5);
        String expResult = "2";
        String result = instance.getId();
        assertEquals(expResult, result);

    }

    /**
     * Test of getParkID method, of class Park.
     */
    @Test
    public void testGetParkID3() {
        System.out.println("getParkID3");
        Park instance = new Park("3", 23.3, -10.2, 5, "Trindade", 50, 20, 10.5, 14.5);
        String expResult = "3";
        String result = instance.getId();
        assertEquals(expResult, result);

    }

    /**
     * Test of getLatitude method, of class Park.
     */
    @Test
    public void testGetLatitude1() {
        System.out.println("getLatitude1");
        Park instance = new Park("3", 23.3, -10.2, 5, "Trindade", 50, 20, 10.5, 14.5);
        double expResult = 23.3;
        double result = instance.getLatitude();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getLatitude method, of class Park.
     */
    @Test
    public void testGetLatitude2() {
        System.out.println("getLatitude2");
        Park instance = new Park("3", -29.3, -10.2, 5, "Trindade", 50, 20, 10.5, 14.5);
        double expResult = -29.3;
        double result = instance.getLatitude();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getLatitude method, of class Park.
     */
    @Test
    public void testGetLatitude3() {
        System.out.println("getLatitude3");
        Park instance = new Park("3", 27.3, -10.2, 5, "Trindade", 50, 20, 10.5, 14.5);
        double expResult = 27.3;
        double result = instance.getLatitude();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getLongitude method, of class Park.
     */
    @Test
    public void testGetLongitude1() {
        System.out.println("getLongitude1");
        Park instance = new Park("3", 27.3, -10.2, 5, "Trindade", 50, 20, 10.5, 14.5);
        double expResult = -10.2;
        double result = instance.getLongitude();
        assertEquals(expResult, result, 0.10);

    }

    /**
     * Test of getLongitude method, of class Park.
     */
    @Test
    public void testGetLongitude2() {
        System.out.println("getLongitude2");
        Park instance = new Park("3", 27.3, -20.2, 5, "Trindade", 50, 20, 10.5, 14.5);
        double expResult = -20.2;
        double result = instance.getLongitude();
        assertEquals(expResult, result, 0.10);

    }

    /**
     * Test of getLongitude method, of class Park.
     */
    @Test
    public void testGetLongitude3() {
        System.out.println("getLongitude3");
        Park instance = new Park("3", 27.3, 10.2, 5, "Trindade", 50, 20, 10.5, 14.5);
        double expResult = 10.2;
        double result = instance.getLongitude();
        assertEquals(expResult, result, 0.10);

    }

    /**
     * Test of getElevation method, of class Park.
     */
    @Test
    public void testGetElevation1() {
        System.out.println("getElevation1");
        Park instance = new Park("1", 27.3, 10.2, 5, "Trindade", 50, 20, 10.5, 14.5);
        int expResult = 5;
        int result = instance.getElevation();
        assertEquals(expResult, result);

    }

    /**
     * Test of getElevation method, of class Park.
     */
    @Test
    public void testGetElevation2() {
        System.out.println("getElevation2");
        Park instance = new Park("1", 27.3, 10.2, 55, "Trindade", 50, 20, 10.5, 14.5);
        int expResult = 55;
        int result = instance.getElevation();
        assertEquals(expResult, result);

    }

    /**
     * Test of getElevation method, of class Park.
     */
    @Test
    public void testGetElevation3() {
        System.out.println("getElevation3");
        Park instance = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        int expResult = 15;
        int result = instance.getElevation();
        assertEquals(expResult, result);

    }

    /**
     * Test of getParkDescription method, of class Park.
     */
    @Test
    public void testGetParkDescription1() {
        System.out.println("getParkDescription1");
        Park instance = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        String expResult = "Trindade";
        String result = instance.getDescription();
        assertEquals(expResult, result);

    }

    /**
     * Test of getParkDescription method, of class Park.
     */
    @Test
    public void testGetParkDescription2() {
        System.out.println("getParkDescription2");
        Park instance = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        String expResult = "Maia";
        String result = instance.getDescription();
        assertEquals(expResult, result);

    }

    /**
     * Test of getParkDescription method, of class Park.
     */
    @Test
    public void testGetParkDescription3() {
        System.out.println("getParkDescription3");
        Park instance = new Park("1", 27.3, 10.2, 15, "São Bento", 50, 20, 10.5, 14.5);
        String expResult = "São Bento";
        String result = instance.getDescription();
        assertEquals(expResult, result);

    }

    /**
     * Test of getMaxNumberBicycles method, of class Park.
     */
    @Test
    public void testGetMaxNumberBicycles1() {
        System.out.println("getMaxNumberBicycles1");
        Park instance = new Park("1", 27.3, 10.2, 15, "São Bento", 50, 20, 10.5, 14.5);
        int expResult = 50;
        int result = instance.getMaxNumberBicycles();
        assertEquals(expResult, result);

    }

    /**
     * Test of getMaxNumberBicycles method, of class Park.
     */
    @Test
    public void testGetMaxNumberBicycles2() {
        System.out.println("getMaxNumberBicycles2");
        Park instance = new Park("1", 27.3, 10.2, 15, "São Bento", 20, 20, 10.5, 14.5);
        int expResult = 20;
        int result = instance.getMaxNumberBicycles();
        assertEquals(expResult, result);

    }

    /**
     * Test of getMaxNumberBicycles method, of class Park.
     */
    @Test
    public void testGetMaxNumberBicycles3() {
        System.out.println("getMaxNumberBicycles3");
        Park instance = new Park("1", 27.3, 10.2, 15, "São Bento", 80, 20, 10.5, 14.5);
        int expResult = 80;
        int result = instance.getMaxNumberBicycles();
        assertEquals(expResult, result);

    }

    /**
     * Test of getMaxNumberEScooters method, of class Park.
     */
    @Test
    public void testGetMaxNumberEScooters1() {
        System.out.println("getMaxNumberEScooters1");
        Park instance = new Park("1", 27.3, 10.2, 15, "São Bento", 50, 20, 10.5, 14.5);
        int expResult = 20;
        int result = instance.getMaxNumberEScooters();
        assertEquals(expResult, result);

    }

    /**
     * Test of getMaxNumberEScooters method, of class Park.
     */
    @Test
    public void testGetMaxNumberEScooters2() {
        System.out.println("getMaxNumberEScooters2");
        Park instance = new Park("1", 27.3, 10.2, 15, "São Bento", 50, 10, 10.5, 14.5);
        int expResult = 10;
        int result = instance.getMaxNumberEScooters();
        assertEquals(expResult, result);

    }

    /**
     * Test of getMaxNumberEScooters method, of class Park.
     */
    @Test
    public void testGetMaxNumberEScooters3() {
        System.out.println("getMaxNumberEScooters3");
        Park instance = new Park("1", 27.3, 10.2, 15, "São Bento", 50, 30, 10.5, 14.5);
        int expResult = 30;
        int result = instance.getMaxNumberEScooters();
        assertEquals(expResult, result);

    }

    /**
     * Test of getInputVoltage method, of class Park.
     */
    @Test
    public void testGetInputVoltage1() {
        System.out.println("getInputVoltage1");
        Park instance = new Park("1", 27.3, 10.2, 15, "São Bento", 50, 20, 10.5, 14.5);
        double expResult = 10.5;
        double result = instance.getInputVoltage();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getInputVoltage method, of class Park.
     */
    @Test
    public void testGetInputVoltage2() {
        System.out.println("getInputVoltage2");
        Park instance = new Park("1", 27.3, 10.2, 15, "São Bento", 50, 20, 20.5, 14.5);
        double expResult = 20.5;
        double result = instance.getInputVoltage();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getInputVoltage method, of class Park.
     */
    @Test
    public void testGetInputVoltage3() {
        System.out.println("getInputVoltage3");
        Park instance = new Park("1", 27.3, 10.2, 15, "São Bento", 50, 50, 40.5, 14.5);
        double expResult = 40.5;
        double result = instance.getInputVoltage();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getInputCurrent method, of class Park.
     */
    @Test
    public void testGetInputCurrent1() {
        System.out.println("getInputCurrent1");
        Park instance = new Park("1", 27.3, 10.2, 15, "São Bento", 50, 20, 10.5, 14.5);
        double expResult = 14.5;
        double result = instance.getInputCurrent();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getInputCurrent method, of class Park.
     */
    @Test
    public void testGetInputCurrent2() {
        System.out.println("getInputCurrent2");
        Park instance = new Park("1", 27.3, 10.2, 15, "São Bento", 50, 20, 10.5, 17.5);
        double expResult = 17.5;
        double result = instance.getInputCurrent();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of getInputCurrent method, of class Park.
     */
    @Test
    public void testGetInputCurrent3() {
        System.out.println("getInputCurrent3");
        Park instance = new Park("1", 27.3, 10.2, 15, "São Bento", 50, 30, 10.5, 19.5);
        double expResult = 19.5;
        double result = instance.getInputCurrent();
        assertEquals(expResult, result, 0.01);

    }

    /**
     * Test of setParkID method, of class Park.
     */
    @Test
    public void testSetParkID1() {
        System.out.println("setParkID1");
        String parkID = "3";
        Park instance = new Park("1", 27.3, 10.2, 15, "São Bento", 50, 20, 10.5, 14.5);
        instance.setId(parkID);

    }

    /**
     * Test of setParkID method, of class Park.
     */
    @Test
    public void testSetParkID2() {
        System.out.println("setParkID2");
        String parkID = "5";
        Park instance = new Park("2", 27.3, 10.2, 15, "São Bento", 50, 20, 10.5, 14.5);
        instance.setId(parkID);

    }

    /**
     * Test of setParkID method, of class Park.
     */
    @Test
    public void testSetParkID3() {
        System.out.println("setParkID3");
        String parkID = "3";
        Park instance = new Park("7", 27.3, 10.2, 15, "São Bento", 50, 20, 10.5, 14.5);
        instance.setId(parkID);

    }

    /**
     * Test of setLatitude method, of class Park.
     */
    @Test
    public void testSetLatitude1() {
        System.out.println("setLatitude1");
        double latitude = -10.0;
        Park instance = new Park("1", 27.3, 10.2, 15, "São Bento", 50, 20, 10.5, 14.5);
        instance.setLatitude(latitude);

    }

    /**
     * Test of setLatitude method, of class Park.
     */
    @Test
    public void testSetLatitude2() {
        System.out.println("setLatitude2");
        double latitude = 10.0;
        Park instance = new Park();
        instance.setLatitude(latitude);

    }

    /**
     * Test of setLatitude method, of class Park.
     */
    @Test
    public void testSetLatitude3() {
        System.out.println("setLatitude3");
        double latitude = -17.0;
        Park instance = new Park("7", 20.3, 10.2, 15, "São Bento", 50, 20, 10.5, 14.5);
        instance.setLatitude(latitude);

    }

    /**
     * Test of setLongitude method, of class Park.
     */
    @Test
    public void testSetLongitude1() {
        System.out.println("setLongitude1");
        double longitude = 7.02;
        Park instance = new Park("2", 20.3, 10.2, 15, "São Bento", 50, 30, 10.5, 14.5);
        instance.setLongitude(longitude);

    }

    /**
     * Test of setLongitude method, of class Park.
     */
    @Test
    public void testSetLongitude2() {
        System.out.println("setLongitude2");
        double longitude = -11.02;
        Park instance = new Park("7", 20.3, 10.2, 15, "São Bento", 50, 20, 10.5, 14.5);
        instance.setLongitude(longitude);

    }

    /**
     * Test of setLongitude method, of class Park.
     */
    @Test
    public void testSetLongitude3() {
        System.out.println("setLongitude3");
        double longitude = 11.02;
        Park instance = new Park("5", 20.3, 10.2, 15, "São Bento", 70, 20, 10.5, 14.5);
        instance.setLongitude(longitude);

    }

    /**
     * Test of setElevation method, of class Park.
     */
    @Test
    public void testSetElevation1() {
        System.out.println("setElevation1");
        int elevation = 15;
        Park instance = new Park("1", 20.3, 10.2, 15, "São Bento", 70, 20, 10.5, 14.5);
        instance.setElevation(elevation);

    }

    /**
     * Test of setElevation method, of class Park.
     */
    @Test
    public void testSetElevation2() {
        System.out.println("setElevation2");
        int elevation = 25;
        Park instance = new Park("2", 20.3, 10.2, 12, "São Bento", 70, 20, 10.5, 14.5);
        instance.setElevation(elevation);

    }

    /**
     * Test of setElevation method, of class Park.
     */
    @Test
    public void testSetElevation3() {
        System.out.println("setElevation3");
        int elevation = 65;
        Park instance = new Park("3", 20.3, 10.2, 65, "São Bento", 70, 20, 10.5, 14.5);
        instance.setElevation(elevation);

    }

    /**
     * Test of setParkDescription method, of class Park.
     */
    @Test
    public void testSetParkDescription1() {
        System.out.println("setParkDescription1");
        String parkDescription = "Maia";
        Park instance = new Park("3", 20.3, 10.2, 65, "São Bento", 70, 20, 10.5, 14.5);
        instance.setDescription(parkDescription);

    }

    /**
     * Test of setParkDescription method, of class Park.
     */
    @Test
    public void testSetParkDescription2() {
        System.out.println("setParkDescription2");
        String parkDescription = "Trindade";
        Park instance = new Park("3", 20.3, 10.2, 65, "São Bento", 70, 20, 10.5, 14.5);
        instance.setDescription(parkDescription);

    }

    /**
     * Test of setParkDescription method, of class Park.
     */
    @Test
    public void testSetParkDescription3() {
        System.out.println("setParkDescription3");
        String parkDescription = "São Bento";
        Park instance = new Park("3", 20.3, 10.2, 65, "Trindade", 70, 20, 10.5, 14.5);
        instance.setDescription(parkDescription);

    }

    /**
     * Test of setMaxNumberBicycles method, of class Park.
     */
    @Test
    public void testSetMaxNumberBicycles1() {
        System.out.println("setMaxNumberBicycles1");
        int maxNumberBicycles = 100;
        Park instance = new Park("3", 20.3, 10.2, 65, "São Bento", 70, 20, 10.5, 14.5);
        instance.setMaxNumberBicycles(maxNumberBicycles);

    }

    /**
     * Test of setMaxNumberBicycles method, of class Park.
     */
    @Test
    public void testSetMaxNumberBicycles2() {
        System.out.println("setMaxNumberBicycles2");
        int maxNumberBicycles = 20;
        Park instance = new Park("3", 20.3, 10.2, 65, "São Bento", 20, 20, 10.5, 14.5);
        instance.setMaxNumberBicycles(maxNumberBicycles);

    }

    /**
     * Test of setMaxNumberBicycles method, of class Park.
     */
    @Test
    public void testSetMaxNumberBicycles3() {
        System.out.println("setMaxNumberBicycles3");
        int maxNumberBicycles = 10;
        Park instance = new Park("3", 20.3, 10.2, 65, "São Bento", 70, 5, 10.5, 14.5);
        instance.setMaxNumberBicycles(maxNumberBicycles);

    }

    /**
     * Test of setMaxNumberEScooters method, of class Park.
     */
    @Test
    public void testSetMaxNumberEScooters1() {
        System.out.println("setMaxNumberEScooters1");
        int maxNumberEScooters = 30;
        Park instance = new Park("3", 20.3, 10.2, 65, "São Bento", 70, 20, 10.5, 14.5);
        instance.setMaxNumberEScooters(maxNumberEScooters);

    }

    /**
     * Test of setMaxNumberEScooters method, of class Park.
     */
    @Test
    public void testSetMaxNumberEScooters2() {
        System.out.println("setMaxNumberEScooters2");
        int maxNumberEScooters = 40;
        Park instance = new Park("3", 20.3, 10.2, 65, "São Bento", 70, 10, 10.5, 14.5);
        instance.setMaxNumberEScooters(maxNumberEScooters);

    }

    /**
     * Test of setMaxNumberEScooters method, of class Park.
     */
    @Test
    public void testSetMaxNumberEScooters3() {
        System.out.println("setMaxNumberEScooters3");
        int maxNumberEScooters = 60;
        Park instance = new Park("3", 20.3, 10.2, 65, "São Bento", 70, 20, 10.5, 14.5);
        instance.setMaxNumberEScooters(maxNumberEScooters);

    }

    /**
     * Test of setInputVoltage method, of class Park.
     */
    @Test
    public void testSetInputVoltage1() {
        System.out.println("setInputVoltage1");
        double inputVoltage = 15.0;
        Park instance = new Park("3", 20.3, 10.2, 65, "São Bento", 70, 20, 10.5, 14.5);
        instance.setInputVoltage(inputVoltage);

    }

    /**
     * Test of setInputVoltage method, of class Park.
     */
    @Test
    public void testSetInputVoltage2() {
        System.out.println("setInputVoltage2");
        double inputVoltage = 20.0;
        Park instance = new Park("3", 20.3, 10.2, 65, "São Bento", 70, 20, 10.5, 14.5);
        instance.setInputVoltage(inputVoltage);

    }

    /**
     * Test of setInputVoltage method, of class Park.
     */
    @Test
    public void testSetInputVoltage3() {
        System.out.println("setInputVoltage3");
        double inputVoltage = 30.0;
        Park instance = new Park("3", 20.3, 10.2, 65, "São Bento", 70, 20, 10.5, 14.5);
        instance.setInputVoltage(inputVoltage);

    }

    /**
     * Test of setInputCurrent method, of class Park.
     */
    @Test
    public void testSetInputCurrent1() {
        System.out.println("setInputCurrent1");
        double inputCurrent = 12.5;
        Park instance = new Park("3", 20.3, 10.2, 65, "São Bento", 70, 20, 10.5, 14.5);
        instance.setInputCurrent(inputCurrent);

    }

    /**
     * Test of setInputCurrent method, of class Park.
     */
    @Test
    public void testSetInputCurrent2() {
        System.out.println("setInputCurrent2");
        double inputCurrent = 22.5;
        Park instance = new Park("3", 20.3, 10.2, 65, "São Bento", 50, 30, 10.5, 14.5);
        instance.setInputCurrent(inputCurrent);

    }

    /**
     * Test of setInputCurrent method, of class Park.
     */
    @Test
    public void testSetInputCurrent3() {
        System.out.println("setInputCurrent3");
        double inputCurrent = 20.5;
        Park instance = new Park("3", 20.3, 10.2, 65, "São Bento", 10, 20, 10.5, 14.5);
        instance.setInputCurrent(inputCurrent);

    }

    @Test
    void testEquals1() {
        Park p = new Park();
        assertEquals(p, p);
        assertEquals(p.hashCode(), p.hashCode());
    }

    @Test
    void testEquals2() {
        Park p1 = new Park();
        Park p2 = null;
        assertNotEquals(p1, p2);
    }

    @Test
    void testEquals4() {
        Park p1 = new Park("1", 2, 3, 4, "df", 6, 7, 8, 9);
        Park p2 = new Park("1", 2, 3, 4, "df", 6, 7, 8, 9);
        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void testEquals5() {
        Park p1 = new Park();
        Poi p2 = new Poi();
        assertNotEquals(p1, p2);
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void testEquals6() {
        Park p1 = new Park("1", 2, 3, 4, "gh", 8, 5, 6, 7);
        Park p2 = new Park("2", 9, 10, 11, "hj", 56, 12, 13, 14);
        assertNotEquals(p1, p2);
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }

    @Ignore
    public void testToString() {
        System.out.println("toString");
        Park instance = new Park("3", 20.3, 10.2, 65, "São Bento", 70, 20, 10.5, 14.5);
        String expResult = "Id: 3, Latitude: 20.300, Longitude: 10.200, Elevation: 65, Description: São Bento, MaxNumberBicyles: 70, MaxNumberEScooters: 20, InputVoltage: 10.500, InputCurrent: 14.500";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Ignore
    public void testToString2() {
        System.out.println("toString");
        Park instance = new Park();
        String expResult = "Id: null, Latitude: 0.000, Longitude: 0.000, Elevation: 0, Description: null, MaxNumberBicyles: 0, MaxNumberEScooters: 0, InputVoltage: 0.000, InputCurrent: 0.000";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
