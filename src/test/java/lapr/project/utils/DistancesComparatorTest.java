package lapr.project.utils;

import lapr.project.model.Park;
import lapr.project.model.Place;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class DistancesComparatorTest {

    public DistancesComparatorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of compare method, of class DistancesComparator.
     */
    @Test
    public void testCompare() {
        System.out.println("compare");
        double latitude = 23.3;
        double longitude = 10.2;
        int elevation = 5;
        Place o1 = new Park("2", 20.3, 10.2, 65, "São Bento", 70, 10, 10.5, 14.5);
        Place o2 = new Park("3", 27.3, 10.2, 89, "São Bento", 50, 20, 10.5, 14.5);
        DistancesComparator instance = new DistancesComparator(latitude, longitude, elevation);
        int expResult = -1;
        int result = instance.compare(o1, o2);
        assertEquals(expResult, result);

        expResult = 1;
        result = instance.compare(o2, o1);
        assertEquals(expResult, result);

        expResult = 0;
        result = instance.compare(o2, o2);
        assertEquals(expResult, result);
    }

}
