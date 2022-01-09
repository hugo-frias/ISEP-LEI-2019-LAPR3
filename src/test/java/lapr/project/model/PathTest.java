package lapr.project.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PathTest {

    public PathTest() {
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
     * Test of getPath method, of class Path.
     */
//    @Test
//    public void testGetPath() {
//        System.out.println("getPath");
//        double latitudeA = 0.0;
//        double longitudeA = 0.0;
//        double latitudeB = 0.0;
//        double longitudeB = 0.0;
//        Path expResult = null;
//        Path result = Path.getPath(latitudeA, longitudeA, latitudeB, longitudeB);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of save method, of class Path.
//     */
//    @Test
//    public void testSave() {
//        System.out.println("save");
//        Path instance = new Path();
//        instance.save();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of update method, of class Path.
//     */
//    @Test
//    public void testUpdate() {
//        System.out.println("update");
//        Path instance = new Path();
//        instance.update();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getLatitudeA method, of class Path.
     */
    @Test
    public void testGetLatitudeA1() {
        System.out.println("getLatitudeA");
        Path instance = new Path(0.0, 10.0, 20.0, 30.0, 0.001, 220, 1);
        double expResult = 0.0;
        double result = instance.getLatitudeA();
        assertEquals(expResult, result, 3);
    }

    /**
     * Test of getLatitudeA method, of class Path.
     */
    @Test
    public void testGetLatitudeA2() {
        System.out.println("getLatitudeA");
        Path instance = new Path(1.0, 10.0, 20.0, 30.0, 0.001, 220, 1);
        double expResult = 1.0;
        double result = instance.getLatitudeA();
        assertEquals(expResult, result, 3);
    }

    /**
     * Test of getLatitudeA method, of class Path.
     */
    @Test
    public void testGetLatitudeA3() {
        System.out.println("getLatitudeA");
        Path instance = new Path(2.0, 10.0, 20.0, 30.0, 0.001, 220, 1);
        double expResult = 2.0;
        double result = instance.getLatitudeA();
        assertEquals(expResult, result, 3);
    }

    /**
     * Test of getLongitudeA method, of class Path.
     */
    @Test
    public void testGetLongitudeA1() {
        System.out.println("getLongitudeA");
        Path instance = new Path(2.0, 10.0, 20.0, 30.0, 0.001, 220, 1);
        double expResult = 10.0;
        double result = instance.getLongitudeA();
        assertEquals(expResult, result, 3);
    }

    /**
     * Test of getLongitudeA method, of class Path.
     */
    @Test
    public void testGetLongitudeA2() {
        System.out.println("getLongitudeA");
        Path instance = new Path(2.0, 11.0, 20.0, 30.0, 0.001, 220, 1);
        double expResult = 11.0;
        double result = instance.getLongitudeA();
        assertEquals(expResult, result, 3);
    }

    /**
     * Test of getLongitudeA method, of class Path.
     */
    @Test
    public void testGetLongitudeA3() {
        System.out.println("getLongitudeA");
        Path instance = new Path(2.0, 12.0, 20.0, 30.0, 0.001, 220, 1);
        double expResult = 12.0;
        double result = instance.getLongitudeA();
        assertEquals(expResult, result, 3);
    }

    /**
     * Test of getLatitudeB method, of class Path.
     */
    @Test
    public void testGetLatitudeB1() {
        System.out.println("getLatitudeB");
        Path instance = new Path(2.0, 12.0, 20.0, 30.0, 0.001, 220, 1);
        double expResult = 20.0;
        double result = instance.getLatitudeB();
        assertEquals(expResult, result, 3);
    }

    /**
     * Test of getLatitudeB method, of class Path.
     */
    @Test
    public void testGetLatitudeB2() {
        System.out.println("getLatitudeB");
        Path instance = new Path(2.0, 12.0, 21.0, 30.0, 0.001, 220, 1);
        double expResult = 21.0;
        double result = instance.getLatitudeB();
        assertEquals(expResult, result, 3);
    }

    /**
     * Test of getLatitudeB method, of class Path.
     */
    @Test
    public void testGetLatitudeB3() {
        System.out.println("getLatitudeB");
        Path instance = new Path(2.0, 12.0, 22.0, 30.0, 0.001, 220, 1);
        double expResult = 22.0;
        double result = instance.getLatitudeB();
        assertEquals(expResult, result, 3);
    }

    /**
     * Test of getLongitudeB method, of class Path.
     */
    @Test
    public void testGetLongitudeB1() {
        System.out.println("getLongitudeB");
        Path instance = new Path(2.0, 12.0, 22.0, 30.0, 0.001, 220, 1);
        double expResult = 30.0;
        double result = instance.getLongitudeB();
        assertEquals(expResult, result, 3);
    }

    /**
     * Test of getLongitudeB method, of class Path.
     */
    @Test
    public void testGetLongitudeB2() {
        System.out.println("getLongitudeB");
        Path instance = new Path(2.0, 12.0, 22.0, 31.0, 0.001, 220, 1);
        double expResult = 31.0;
        double result = instance.getLongitudeB();
        assertEquals(expResult, result, 3);
    }

    /**
     * Test of getLongitudeB method, of class Path.
     */
    @Test
    public void testGetLongitudeB3() {
        System.out.println("getLongitudeB");
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 0.001, 220, 1);
        double expResult = 32.0;
        double result = instance.getLongitudeB();
        assertEquals(expResult, result, 3);
    }

    /**
     * Test of getKineticCoefficient method, of class Path.
     */
    @Test
    public void testGetKineticCoefficient1() {
        System.out.println("getKineticCoefficient");
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 0.001, 220, 1);
        double expResult = 0.001;
        double result = instance.getKineticCoefficient();
        assertEquals(expResult, result, 3);
    }

    /**
     * Test of getKineticCoefficient method, of class Path.
     */
    @Test
    public void testGetKineticCoefficient2() {
        System.out.println("getKineticCoefficient");
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 1.002, 220, 1);
        double expResult = 1.001;
        double result = instance.getKineticCoefficient();
        assertEquals(expResult, result, 3);
    }

    /**
     * Test of getKineticCoefficient method, of class Path.
     */
    @Test
    public void testGetKineticCoefficient3() {
        System.out.println("getKineticCoefficient");
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 2.003, 220, 1);
        double expResult = 2.003;
        double result = instance.getKineticCoefficient();
        assertEquals(expResult, result, 3);
    }

    /**
     * Test of getWindDirection method, of class Path.
     */
    @Test
    public void testGetWindDirection1() {
        System.out.println("getWindDirection");
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 0.003, 220, 1);
        int expResult = 220;
        int result = instance.getWindDirection();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWindDirection method, of class Path.
     */
    @Test
    public void testGetWindDirection2() {
        System.out.println("getWindDirection");
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 0.003, 221, 1);
        int expResult = 221;
        int result = instance.getWindDirection();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWindDirection method, of class Path.
     */
    @Test
    public void testGetWindDirection3() {
        System.out.println("getWindDirection");
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 0.003, 222, 1);
        int expResult = 222;
        int result = instance.getWindDirection();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWindSpeed method, of class Path.
     */
    @Test
    public void testGetWindSpeed1() {
        System.out.println("getWindSpeed");
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 0.003, 222, 1);
        double expResult = 1.0;
        double result = instance.getWindSpeed();
        assertEquals(expResult, result, 1);
    }

    /**
     * Test of getWindSpeed method, of class Path.
     */
    @Test
    public void testGetWindSpeed2() {
        System.out.println("getWindSpeed");
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 0.003, 222, 1.1);
        double expResult = 1.1;
        double result = instance.getWindSpeed();
        assertEquals(expResult, result, 1);
    }

    /**
     * Test of getWindSpeed method, of class Path.
     */
    @Test
    public void testGetWindSpeed3() {
        System.out.println("getWindSpeed");
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 0.003, 222, 1.2);
        double expResult = 1.2;
        double result = instance.getWindSpeed();
        assertEquals(expResult, result, 1);
    }

    /**
     * Test of setLatitudeA method, of class Path.
     */
    @Test
    public void testSetLatitudeA1() {
        System.out.println("setLatitudeA");
        double latitudeA = 0.0;
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 0.003, 222, 1.2);
        instance.setLatitudeA(latitudeA);
        double result = instance.getLatitudeA();
        assertEquals(latitudeA, result, 3);
    }

    /**
     * Test of setLatitudeA method, of class Path.
     */
    @Test
    public void testSetLatitudeA2() {
        System.out.println("setLatitudeA");
        double latitudeA = 1.0;
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 0.003, 222, 1.2);
        instance.setLatitudeA(latitudeA);
        double result = instance.getLatitudeA();
        assertEquals(latitudeA, result, 3);
    }

    /**
     * Test of setLatitudeA method, of class Path.
     */
    @Test
    public void testSetLatitudeA3() {
        System.out.println("setLatitudeA");
        double latitudeA = 3.0;
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 0.003, 222, 1.2);
        instance.setLatitudeA(latitudeA);
        double result = instance.getLatitudeA();
        assertEquals(latitudeA, result, 3);
    }

    /**
     * Test of setLongitudeA method, of class Path.
     */
    @Test
    public void testSetLongitudeA1() {
        System.out.println("setLongitudeA");
        double longitudeA = 0.0;
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 0.003, 222, 1.2);
        instance.setLongitudeA(longitudeA);
        double result = instance.getLongitudeA();
        assertEquals(longitudeA, result, 3);
    }

    /**
     * Test of setLongitudeA method, of class Path.
     */
    @Test
    public void testSetLongitudeA2() {
        System.out.println("setLongitudeA");
        double longitudeA = 1.0;
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 0.003, 222, 1.2);
        instance.setLongitudeA(longitudeA);
        double result = instance.getLongitudeA();
        assertEquals(longitudeA, result, 3);
    }

    /**
     * Test of setLongitudeA method, of class Path.
     */
    @Test
    public void testSetLongitudeA3() {
        System.out.println("setLongitudeA");
        double longitudeA = 2.0;
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 0.003, 222, 1.2);
        instance.setLongitudeA(longitudeA);
        double result = instance.getLongitudeA();
        assertEquals(longitudeA, result, 3);
    }

    /**
     * Test of setLatitudeB method, of class Path.
     */
    @Test
    public void testSetLatitudeB1() {
        System.out.println("setLatitudeB");
        double latitudeB = 0.0;
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 0.003, 222, 1.2);
        instance.setLatitudeB(latitudeB);
        double result = instance.getLatitudeB();
        assertEquals(latitudeB, result, 3);
    }

    /**
     * Test of setLatitudeB method, of class Path.
     */
    @Test
    public void testSetLatitudeB2() {
        System.out.println("setLatitudeB");
        double latitudeB = 1.0;
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 0.003, 222, 1.2);
        instance.setLatitudeB(latitudeB);
        double result = instance.getLatitudeB();
        assertEquals(latitudeB, result, 3);
    }

    /**
     * Test of setLatitudeB method, of class Path.
     */
    @Test
    public void testSetLatitudeB3() {
        System.out.println("setLatitudeB");
        double latitudeB = 2.0;
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 0.003, 222, 1.2);
        instance.setLatitudeB(latitudeB);
        double result = instance.getLatitudeB();
        assertEquals(latitudeB, result, 3);
    }

    /**
     * Test of setLongitudeB method, of class Path.
     */
    @Test
    public void testSetLongitudeB1() {
        System.out.println("setLongitudeB");
        double longitudeB = 0.0;
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 0.003, 222, 1.2);
        instance.setLongitudeB(longitudeB);
        double result = instance.getLongitudeB();
        assertEquals(longitudeB, result, 3);
    }

    /**
     * Test of setLongitudeB method, of class Path.
     */
    @Test
    public void testSetLongitudeB2() {
        System.out.println("setLongitudeB");
        double longitudeB = 1.0;
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 0.003, 222, 1.2);
        instance.setLongitudeB(longitudeB);
        double result = instance.getLongitudeB();
        assertEquals(longitudeB, result, 3);
    }

    /**
     * Test of setLongitudeB method, of class Path.
     */
    @Test
    public void testSetLongitudeB3() {
        System.out.println("setLongitudeB");
        double longitudeB = 2.0;
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 0.003, 222, 1.2);
        instance.setLongitudeB(longitudeB);
        double result = instance.getLongitudeB();
        assertEquals(longitudeB, result, 3);
    }

    /**
     * Test of setKineticCoefficient method, of class Path.
     */
    @Test
    public void testSetKineticCoefficient1() {
        System.out.println("setKineticCoefficient");
        double kineticCoefficient = 0.000;
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 0.003, 222, 1.2);
        instance.setKineticCoefficient(kineticCoefficient);
        double result = instance.getKineticCoefficient();
        assertEquals(kineticCoefficient, result, 3);
    }

    /**
     * Test of setKineticCoefficient method, of class Path.
     */
    @Test
    public void testSetKineticCoefficient2() {
        System.out.println("setKineticCoefficient");
        double kineticCoefficient = 0.001;
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 0.003, 222, 1.2);
        instance.setKineticCoefficient(kineticCoefficient);
        double result = instance.getKineticCoefficient();
        assertEquals(kineticCoefficient, result, 3);
    }

    /**
     * Test of setKineticCoefficient method, of class Path.
     */
    @Test
    public void testSetKineticCoefficient3() {
        System.out.println("setKineticCoefficient");
        double kineticCoefficient = 0.002;
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 0.003, 222, 1.2);
        instance.setKineticCoefficient(kineticCoefficient);
        double result = instance.getKineticCoefficient();
        assertEquals(kineticCoefficient, result, 3);
    }

    /**
     * Test of setWindDirection method, of class Path.
     */
    @Test
    public void testSetWindDirection1() {
        System.out.println("setWindDirection");
        int windDirection = 0;
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 0.003, 222, 1.2);
        instance.setWindDirection(windDirection);
        int result = instance.getWindDirection();
        assertEquals(windDirection, result);
    }

    /**
     * Test of setWindDirection method, of class Path.
     */
    @Test
    public void testSetWindDirection2() {
        System.out.println("setWindDirection");
        int windDirection = 100;
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 0.003, 222, 1.2);
        instance.setWindDirection(windDirection);
        int result = instance.getWindDirection();
        assertEquals(windDirection, result);
    }

    /**
     * Test of setWindDirection method, of class Path.
     */
    @Test
    public void testSetWindDirection3() {
        System.out.println("setWindDirection");
        int windDirection = 200;
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 0.003, 222, 1.2);
        instance.setWindDirection(windDirection);
        int result = instance.getWindDirection();
        assertEquals(windDirection, result);
    }

    /**
     * Test of setWindSpeed method, of class Path.
     */
    @Test
    public void testSetWindSpeed1() {
        System.out.println("setWindSpeed");
        double windSpeed = 0.0;
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 0.003, 222, 1.2);
        instance.setWindSpeed(windSpeed);
        double result = instance.getWindSpeed();
        assertEquals(windSpeed, result, 1);
    }

    /**
     * Test of setWindSpeed method, of class Path.
     */
    @Test
    public void testSetWindSpeed2() {
        System.out.println("setWindSpeed");
        double windSpeed = 1.0;
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 0.003, 222, 1.2);
        instance.setWindSpeed(windSpeed);
        double result = instance.getWindSpeed();
        assertEquals(windSpeed, result, 1);
    }

    /**
     * Test of setWindSpeed method, of class Path.
     */
    @Test
    public void testSetWindSpeed3() {
        System.out.println("setWindSpeed");
        double windSpeed = 2.0;
        Path instance = new Path(2.0, 12.0, 22.0, 32.0, 0.003, 222, 1.2);
        instance.setWindSpeed(windSpeed);
        double result = instance.getWindSpeed();
        assertEquals(windSpeed, result, 1);
    }

    @Test
    void testEquals1() {
        Path p = new Path();
        assertEquals(p, p);
        assertEquals(p.hashCode(), p.hashCode());
    }

    @Test
    void testEquals2() {
        Path p1 = new Path();
        Path p2 = null;
        assertNotEquals(p1, p2);
    }

    @Test
    void testEquals3() {
        Path p1 = new Path();
        Poi p2 = new Poi();
        assertNotEquals(p1, p2);
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void testEquals4() {
        Path p1 = new Path(1, 2, 3, 4, 5, 6, 7);
        Path p2 = new Path(1, 2, 3, 4, 5, 6, 7);
        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void testEquals5() {
        Path p1 = new Path(1, 2, 3, 4, 5, 6, 7);
        Path p2 = new Path(1, 2, 3, 8, 5, 6, 7);
        assertNotEquals(p1, p2);
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void testEquals6() {
        Path p1 = new Path(1, 2, 3, 4, 5, 6, 7);
        Path p2 = new Path(1, 2, 7, 8, 5, 6, 7);
        assertNotEquals(p1, p2);
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void testEquals7() {
        Path p1 = new Path(1, 2, 3, 4, 5, 6, 7);
        Path p2 = new Path(1, 6, 7, 8, 5, 6, 7);
        assertNotEquals(p1, p2);
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void testEquals8() {
        Path p1 = new Path(1, 2, 3, 4, 5, 6, 7);
        Path p2 = new Path(8, 9, 10, 11, 12, 13, 14);
        assertNotEquals(p1, p2);
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }

//    /**
//     * Test of delete method, of class Path.
//     */
//    @Test
//    public void testDelete() {
//        System.out.println("delete");
//        Path instance = new Path();
//        instance.delete();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of toString method, of class Path.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Path instance = new Path();
        //String expResult = "";
        String expResult = "Path{latitudeA=0.0, longitudeA=0.0, latitudeB=0.0, longitudeB=0.0, kineticCoefficient=0.0, windDirection=0, windSpeed=0.0}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
