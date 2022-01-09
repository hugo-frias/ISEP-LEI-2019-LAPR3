/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.util.LinkedList;
import lapr.project.model.Park;
import lapr.project.model.Place;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hugo
 */
public class mostEnergyEfficientComparatorTest {
    
    public mostEnergyEfficientComparatorTest() {
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
     * Test of compare method, of class mostEnergyEfficientComparator.
     */
    @Test
    public void testCompare() {
        System.out.println("compare");
        Place vOrig = new Park("orig", 10, 10, 0, "São Bento", 70, 20, 10.5, 14.5);
        Place place = new Park("2", 17.5, 15, 0, "São Francisco", 50, 20, 10.5, 14.5);
        Place vDest = new Park("dest", 20, 10, 0, "Trindade", 50, 20, 10.5, 14.5);
        
        LinkedList<Place> o1 = new LinkedList<>();
        LinkedList<Place> o2 = new LinkedList<>();
        o1.add(vOrig);
        o1.add(vDest);
        
        o2.add(vOrig);
        o2.add(place);
        o2.add(vDest);
        mostEnergyEfficientComparator instance = new mostEnergyEfficientComparator();
        int expResult = -1;
        int result = instance.compare(o1, o2);
        assertEquals(expResult, result);
    }
    @Test
    public void testCompare2() {
        System.out.println("compare");
        Place vOrig = new Park("orig", 10, 10, 0, "São Bento", 70, 20, 10.5, 14.5);
        Place place = new Park("2", 17.5, 15, 0, "São Francisco", 50, 20, 10.5, 14.5);
        Place vDest = new Park("dest", 20, 10, 0, "Trindade", 50, 20, 10.5, 14.5);
        
        LinkedList<Place> o1 = new LinkedList<>();
        LinkedList<Place> o2 = new LinkedList<>();
        o1.add(vOrig);
        o1.add(vDest);
        
        o2.add(vOrig);
        o2.add(place);
        o2.add(vDest);
        mostEnergyEfficientComparator instance = new mostEnergyEfficientComparator();
        int expResult = 1;
        int result = instance.compare(o2, o1);
        assertEquals(expResult, result);
    }
    @Test
    public void testCompare3() {
        System.out.println("compare");
        Place vOrig = new Park("orig", 10, 10, 0, "São Bento", 70, 20, 10.5, 14.5);
        Place vDest = new Park("dest", 20, 10, 0, "Trindade", 50, 20, 10.5, 14.5);
        
        LinkedList<Place> o1 = new LinkedList<>();
        LinkedList<Place> o2 = new LinkedList<>();
        o1.add(vOrig);
        o1.add(vDest);
        
        o2.add(vOrig);
        o2.add(vDest);
        mostEnergyEfficientComparator instance = new mostEnergyEfficientComparator();
        int expResult = 0;
        int result = instance.compare(o2, o1);
        assertEquals(expResult, result);
    }
    
}
