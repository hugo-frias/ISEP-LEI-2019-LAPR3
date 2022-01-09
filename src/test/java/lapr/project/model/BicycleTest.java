package lapr.project.model;


import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Vera Pinto
 */
public class BicycleTest {

    public BicycleTest() {
    }
    
    /**
     * Test of getDescription method, of class Bicycle.
     */
    @Test
    public void testGetBicycleDescription1() {
        System.out.println("getBicycledescription1");
        Bicycle instance = new Bicycle("B700", 90, 22.78, 20.89, 30, 60,15);
        String expResult = "B700";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBicycledescription method, of class Bicycle.
     */
    @Test
    public void testGetBicycledescription2() {
        System.out.println("getBicycledescription2");
        Bicycle instance = new Bicycle("B500", 90, 22.78, 20.89, 30, 60,17);
        String expResult = "B500";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBicycledescription method, of class Bicycle.
     */
    @Test
    public void testGetBicycledescription3() {
        System.out.println("getBicycledescription3");
        Bicycle instance = new Bicycle("B600", 90, 22.78, 20.89, 30, 60,19);
        String expResult = "B600";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWeight method, of class Bicycle.
     */
    @Test
    public void testGetWeight1() {
        System.out.println("getWeight1");
        Bicycle instance = new Bicycle("B700", 90, 22.78, 20.89, 30, 60,15);
        int expResult = 90;
        int result = instance.getWeight();
        assertEquals(expResult, result);

    }

    /**
     * Test of getWeight method, of class Bicycle.
     */
    @Test
    public void testGetWeight2() {
        System.out.println("getWeight2");
        Bicycle instance = new Bicycle("B700", 70, 22.78, 20.89, 30, 60,15);
        int expResult = 70;
        int result = instance.getWeight();
        assertEquals(expResult, result);

    }

    /**
     * Test of getWeight method, of class Bicycle.
     */
    @Test
    public void testGetWeight3() {
        System.out.println("getWeight3");
        Bicycle instance = new Bicycle("B700", 80, 22.78, 20.89, 30, 60,17);
        int expResult = 80;
        int result = instance.getWeight();
        assertEquals(expResult, result);

    }

    /**
     * Test of getParkLatitude method, of class Bicycle.
     */
    @Test
    public void testGetParkLatitude1() {
        System.out.println("getParkLatitude1");
        Bicycle instance = new Bicycle("B700", 80, 20.01, 20.89, 30, 60,19);
        double expResult = 20.01;
        double result = instance.getParkLatitude();
        assertEquals(expResult, result, 3);

    }

    /**
     * Test of getParkLatitude method, of class Bicycle.
     */
    @Test
    public void testGetParkLatitude2() {
        System.out.println("getParkLatitude2");
        Bicycle instance = new Bicycle("B700", 80, 22.78, 20.89, 30, 60,15);
        double expResult = 22.78;
        double result = instance.getParkLatitude();
        assertEquals(expResult, result, 3);

    }

    /**
     * Test of getParkLatitude method, of class Bicycle.
     */
    @Test
    public void testGetParkLatitude3() {
        System.out.println("getParkLatitude3");
        Bicycle instance = new Bicycle("B700", 80, 20.89, 20.89, 30, 60,17);
        double expResult = 20.89;
        double result = instance.getParkLatitude();
        assertEquals(expResult, result, 3);

    }

    /**
     * Test of getParkLongitude method, of class Bicycle.
     */
    @Test
    public void testGetParkLongitude1() {
        System.out.println("getParkLongitude1");
        Bicycle instance = new Bicycle("B700", 80, 20.89, 20.89, 30, 60,19);
        double expResult = 20.89;
        double result = instance.getParkLongitude();
        assertEquals(expResult, result, 3);

    }

    /**
     * Test of getParkLongitude method, of class Bicycle.
     */
    @Test
    public void testGetParkLongitude2() {
        System.out.println("getParkLongitude2");
        Bicycle instance = new Bicycle("B700", 80, 20.89, 22.89, 30, 60,15);
        double expResult = 22.89;
        double result = instance.getParkLongitude();
        assertEquals(expResult, result, 3);

    }

    /**
     * Test of getParkLongitude method, of class Bicycle.
     */
    @Test
    public void testGetParkLongitude3() {
        System.out.println("getParkLongitude3");
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 30, 60,17);
        double expResult = 26.89;
        double result = instance.getParkLongitude();
        assertEquals(expResult, result, 3);

    }

    /**
     * Test of getAerodynamicCoefficient method, of class Bicycle.
     */
    @Test
    public void testGetAerodynamicCoefficient1() {
        System.out.println("getAerodynamicCoefficient1");
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 30.50, 60,15);
        double expResult = 30.50;
        double result = instance.getAerodynamicCoefficient();
        assertEquals(expResult, result, 3);

    }

    /**
     * Test of getAerodynamicCoefficient method, of class Bicycle.
     */
    @Test
    public void testGetAerodynamicCoefficient2() {
        System.out.println("getAerodynamicCoefficient2");
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 35.50, 60,17);
        double expResult = 35.50;
        double result = instance.getAerodynamicCoefficient();
        assertEquals(expResult, result, 3);

    }

    /**
     * Test of getAerodynamicCoefficient method, of class Bicycle.
     */
    @Test
    public void testGetAerodynamicCoefficient3() {
        System.out.println("getAerodynamicCoefficient3");
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 45.50, 60,19);
        double expResult = 45.50;
        double result = instance.getAerodynamicCoefficient();
        assertEquals(expResult, result, 3);

    }

    /**
     * Test of getFrontalArea method, of class Bicycle.
     */
    @Test
    public void testGetFrontalArea1() {
        System.out.println("getFrontalArea1");
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 50, 50.50,15);
        double expResult = 50.50;
        double result = instance.getFrontalArea();
        assertEquals(expResult, result, 3);

    }

    /**
     * Test of getFrontalArea method, of class Bicycle.
     */
    @Test
    public void testGetFrontalArea2() {
        System.out.println("getFrontalArea2");
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 60, 47.50,17);
        double expResult = 47.50;
        double result = instance.getFrontalArea();
        assertEquals(expResult, result, 3);

    }

    /**
     * Test of getFrontalArea method, of class Bicycle.
     */
    @Test
    public void testGetFrontalArea3() {
        System.out.println("getFrontalArea3");
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 60, 45.50,17);
        double expResult = 45.50;
        double result = instance.getFrontalArea();
        assertEquals(expResult, result, 3);

    }

    /**
     * Test of setWeight method, of class Bicycle.
     */
    @Test
    public void testSetWeight1() {
        System.out.println("setWeight1");
        int weight = 50;
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 45.50, 60,17);
        instance.setWeight(weight);
    }

    /**
     * Test of setWeight method, of class Bicycle.
     */
    @Test
    public void testSetWeight2() {
        System.out.println("setWeight2");
        int weight = 80;
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 45.50, 60,17);
        instance.setWeight(weight);
    }

    /**
     * Test of setWeight method, of class Bicycle.
     */
    @Test
    public void testSetWeight3() {
        System.out.println("setWeight3");
        int weight = 90;
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 45.50, 60,17);
        instance.setWeight(weight);
    }

    /**
     * Test of setParkLatitude method, of class Bicycle.
     */
    @Test
    public void testSetParkLatitude1() {
        System.out.println("setParkLatitude1");
        double parkLatitude = 25.8;
        Bicycle instance = new Bicycle("PT-B700", 80, 20.89, 26.89, 45.50, 60,19);
        instance.setParkLatitude(parkLatitude);

    }

    /**
     * Test of setParkLatitude method, of class Bicycle.
     */
    @Test
    public void testSetParkLatitude2() {
        System.out.println("setParkLatitude2");
        double parkLatitude = 19.8;
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 45.50, 60,15);
        instance.setParkLatitude(parkLatitude);

    }

    /**
     * Test of setParkLatitude method, of class Bicycle.
     */
    @Test
    public void testSetParkLatitude3() {
        System.out.println("setParkLatitude3");
        double parkLatitude = -10.8;
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 45.50, 60,19);
        instance.setParkLatitude(parkLatitude);

    }

    /**
     * Test of setParkLongitude method, of class Bicycle.
     */
    @Test
    public void testSetParkLongitude1() {
        System.out.println("setParkLongitude1");
        double parkLongitude = 15.70;
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 45.50, 60,15);
        instance.setParkLongitude(parkLongitude);

    }

    /**
     * Test of setParkLongitude method, of class Bicycle.
     */
    @Test
    public void testSetParkLongitude2() {
        System.out.println("setParkLongitude2");
        double parkLongitude = -11.02;
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 45.50, 60,17);
        instance.setParkLongitude(parkLongitude);

    }

    /**
     * Test of setParkLongitude method, of class Bicycle.
     */
    @Test
    public void testSetParkLongitude3() {
        System.out.println("setParkLongitude3");
        double parkLongitude = -20.01;
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 45.50, 60,19);
        instance.setParkLongitude(parkLongitude);

    }

    /**
     * Test of setAerodynamicCoefficient method, of class Bicycle.
     */
    @Test
    public void testSetAerodynamicCoefficient1() {
        System.out.println("setAerodynamicCoefficient1");
        double aerodynamicCoefficient = 50.5;
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 45.50, 60,15);
        instance.setAerodynamicCoefficient(aerodynamicCoefficient);
    }

    /**
     * Test of setAerodynamicCoefficient method, of class Bicycle.
     */
    @Test
    public void testSetAerodynamicCoefficient2() {
        System.out.println("setAerodynamicCoefficient2");
        double aerodynamicCoefficient = 90.5;
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 45.50, 60,15);
        instance.setAerodynamicCoefficient(aerodynamicCoefficient);
    }

    /**
     * Test of setAerodynamicCoefficient method, of class Bicycle.
     */
    @Test
    public void testSetAerodynamicCoefficient3() {
        System.out.println("setAerodynamicCoefficient3");
        double aerodynamicCoefficient = 70.5;
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 45.50, 60,15);
        instance.setAerodynamicCoefficient(aerodynamicCoefficient);
    }

    /**
     * Test of setFrontalArea method, of class Bicycle.
     */
    @Test
    public void testSetFrontalArea1() {
        System.out.println("setFrontalArea1");
        double frontalArea = 11.5;
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 45.50, 60,17);
        instance.setFrontalArea(frontalArea);

    }

    /**
     * Test of setFrontalArea method, of class Bicycle.
     */
    @Test
    public void testSetFrontalArea2() {
        System.out.println("setFrontalArea2");
        double frontalArea = 30.6;
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 45.50, 60,19);
        instance.setFrontalArea(frontalArea);

    }

    /**
     * Test of setFrontalArea method, of class Bicycle.
     */
    @Test
    public void testSetFrontalArea3() {
        System.out.println("setFrontalArea3");
        double frontalArea = 80.5;
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 45.50, 60,19);
        instance.setFrontalArea(frontalArea);

    }

    /**
     * Test of setBicycleDescription method, of class Bicycle.
     */
    @Test
    public void testSetBicycleDescription1() {
        System.out.println("setBicycleDescription1");
        String BicycleDescription = "B120";
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 45.50, 60,19);
        instance.setDescription(BicycleDescription);

    }

    /**
     * Test of setBicycleDescription method, of class Bicycle.
     */
    @Test
    public void testSetBicycleDescription2() {
        System.out.println("setBicycleDescription2");
        String BicycleDescription = "B200";
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 45.50, 60,17);
        instance.setDescription(BicycleDescription);

    }

    /**
     * Test of setBicycleDescription method, of class Bicycle.
     */
    @Test
    public void testSetBicycleDescription3() {
        System.out.println("setBicycleDescription3");
        String BicycleDescription = "B500";
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 45.50, 60,15);
        instance.setDescription(BicycleDescription);

    }

    /*
     /**
     * Test of save method, of class Bicycle.
     *
    @Ignore
    public void testSave() throws SQLException {
        System.out.println("save");
        Bicycle instance = new Bicycle("PT-B700", 80, 20.89, 26.89, 45.50, 60);
        ;
        instance.save();

    }

    /**
     * Test of delete method, of class Bicycle.
     *
    @Ignore
    public void testDelete() {
        System.out.println("delete");
        Bicycle instance = new Bicycle("PT-B700", 80, 20.89, 26.89, 45.50, 60);
        ;
        instance.delete();

    }
     */

    /**
     * Test of getWheel_size method, of class Bicycle.
     */
    @Test
    public void testGetWheel_size1() {
        System.out.println("getWheel_size1");
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 45.50, 60,15);
        int expResult = 15;
        int result = instance.getWheelSize();
        assertEquals(expResult, result);
        
    }
    /**
     * Test of getWheel_size method, of class Bicycle.
     */
    @Test
    public void testGetWheel_size2() {
        System.out.println("getWheel_size2");
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 45.50, 60,19);
        int expResult = 19;
        int result = instance.getWheelSize();
        assertEquals(expResult, result);
        
    }
    /**
     * Test of getWheel_size method, of class Bicycle.
     */
    @Test
    public void testGetWheel_size3() {
        System.out.println("getWheel_size3");
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 45.50, 60,17);
        int expResult = 17;
        int result = instance.getWheelSize();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setWheel_size method, of class Bicycle.
     */
    @Test
    public void testSetWheel_size1() {
        System.out.println("setWheel_size1");
        int wheel_size = 15;
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 45.50, 60,17);
        instance.setWheelSize(wheel_size);
    }
    /**
     * Test of setWheel_size method, of class Bicycle.
     */
    @Test
    public void testSetWheel_size2() {
        System.out.println("setWheel_size2");
        int wheel_size = 15;
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 45.50, 60,19);
        instance.setWheelSize(wheel_size);
    }
    /**
     * Test of setWheel_size method, of class Bicycle.
     */
    @Test
    public void testSetWheel_size3() {
        System.out.println("setWheel_size3");
        int wheel_size = 17;
        Bicycle instance = new Bicycle("B700", 80, 20.89, 26.89, 45.50, 60,15);
        instance.setWheelSize(wheel_size);
    }


}
