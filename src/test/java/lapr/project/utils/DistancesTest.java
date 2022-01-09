package lapr.project.utils;

import java.util.LinkedList;

import lapr.project.model.Park;
import lapr.project.model.Place;
import org.junit.jupiter.api.Test;

import static lapr.project.utils.Distances.distance;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DistancesTest {

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

    @Test
    void distancesTest() {
        Distances d = new Distances();
        assertNotNull(d);
    }

    @Test
    void distance1() {
        double actual = distance(38.7071631, -9.135517, 40.4166909, -3.7003454, 0);
        double expected = 503.0725;
        assertEquals(actual, expected, 4);
    }

    @Test
    void distance2() {
        double lat1 = 1;
        double lon1 = 2;
        double lat2 = 1;
        double lon2 = 3;
        double actual = distance(lat1, lon1, lat2, lon2, 0);
        double expected = 111.1726;
        assertEquals(lat1, lat2);
        assertNotEquals(lon1, lon2);
        assertEquals(actual, expected, 4);
    }

    @Test
    void distance3() {
        double lat1 = 1;
        double lon1 = 3;
        double lat2 = 2;
        double lon2 = 3;
        double actual = distance(lat1, lon1, lat2, lon2, 0);
        double expected = 111.1726;
        assertNotEquals(lat1, lat2);
        assertEquals(lon1, lon2);
        assertEquals(actual, expected, 4);
    }

    @Test
    void distance4() {
        double elevation = 10; //10 meters
        double actual = distance(1, 2, 3, 4, elevation);
        double expected = 314.3878249;
        assertTrue(elevation > 0);
        assertEquals(expected, actual, 5);
        expected = 150;
        assertNotEquals(actual, expected, 5);
    }

    @Test
    void calculateCost() {
        Park cp;
        Park dp;

        cp = new Park("1", 2, 3, 4, "A", 10, 10, 220, 16);
        dp = new Park("1", 3, 4, 4, "A", 10, 10, 220, 16);
        assertEquals(2017.01486, Distances.calculateCost(cp, dp, 250), 3);

        cp = new Park("1", 2, 3, 4, "A", 10, 10, 220, 16);
        dp = new Park("1", 2, 3, 4, "A", 10, 10, 220, 16);
        assertEquals(0, Distances.calculateCost(cp, dp, 250), 0);

        cp = new Park("1", 2, 3, 4, "A", 10, 10, 220, 16);
        dp = new Park("1", 3, 4, 4, "A", 10, 10, 220, 16);
        assertNotEquals(8.164670, Distances.calculateCost(cp, dp, 250), 6);
    }

    /**
     * Test of calculateCostOfAPath method, of class Distances.
     */
    @Test
    public void testCalculateCostOfAPath() {
        System.out.println("calculateCostOfAPath");
        Place vOrig = new Park("orig", 10, 10, 0, "São Bento", 70, 20, 10.5, 14.5);
        Place place = new Park("2", 17.5, 15, 0, "São Francisco", 50, 20, 10.5, 14.5);
        Place vDest = new Park("dest", 20, 10, 0, "Trindade", 50, 20, 10.5, 14.5);

        LinkedList<Place> o1 = new LinkedList<>();
        o1.add(vOrig);
        o1.add(vDest);


        double expResult = Distances.calculateCost(vOrig, vDest, 250);
        double result = Distances.calculateCostOfAPath(o1, 250);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getFullPathDistance method, of class Distances.
     */
    @Test
    public void testGetFullPathDistance() {
        System.out.println("getFullPathDistance");

        Place vOrig = new Park("orig", 10, 10, 0, "São Bento", 70, 20, 10.5, 14.5);
        Place place = new Park("2", 17.5, 15, 0, "São Francisco", 50, 20, 10.5, 14.5);
        Place vDest = new Park("dest", 20, 10, 0, "Trindade", 50, 20, 10.5, 14.5);

        LinkedList<Place> o1 = new LinkedList<>();
        o1.add(vOrig);
        o1.add(vDest);
        double expResult = Distances.distance(vOrig.getLatitude(), vOrig.getLongitude(), vDest.getLatitude(), vDest.getLongitude(), vDest.getElevation() - vOrig.getElevation());
        double result = Distances.getFullPathDistance(o1);
        assertEquals(expResult, result, 0.0);
    }
}