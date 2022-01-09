package lapr.project.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lapr.project.data.BicycleDB;
import lapr.project.model.Bicycle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BicycleControllerTest {

    private static BicycleController instance;

    public BicycleControllerTest() {
    }

    @BeforeAll
    public static void setUpClass() throws SQLException {
        List<Bicycle> bList = new ArrayList<>();
        Bicycle b = new Bicycle("B101", 20, 40.67, 60.78, 56.8, 15.6, 10);
        bList.add(b);
        BicycleDB bdb = mock(BicycleDB.class);
        when(bdb.addBicycle(bList)).thenReturn(Boolean.TRUE);
        when(bdb.addBicycle(b)).thenReturn(Boolean.TRUE);
        when(bdb.removeBicycle(b)).thenReturn(Boolean.TRUE);
        when(bdb.getBicycle("B101")).thenReturn(b);
        when(bdb.getBicycle("null")).thenReturn(null);
        instance = new BicycleController();
        instance = new BicycleController(bdb);
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

    @Test
    public void testAddBicycle() throws SQLException {
        System.out.println("addBicycle");
        Bicycle b = new Bicycle("B101", 20, 40.67, 60.78, 56.8, 15.6, 10);
        List<Bicycle> bList = new ArrayList<>();
        bList.add(b);
        boolean expResult = true;
        boolean result = instance.addBicycle(bList);
        assertEquals(expResult, result);

        BicycleDB bdb = mock(BicycleDB.class);
        when(bdb.addBicycle(new Bicycle("B101", 20, 40.67, 60.78, 56.8, 15.6, 10))).thenReturn(Boolean.FALSE);
        BicycleController instance1 = new BicycleController(bdb);

        expResult = false;
        result = instance1.addBicycle(bList);
        assertEquals(expResult, result);

        BicycleDB bdb1 = mock(BicycleDB.class);
        when(bdb1.addBicycle(new Bicycle("B101", 20, 40.67, 60.78, 56.8, 15.6, 10))).thenThrow(new SQLException());
        BicycleController instance2 = new BicycleController(bdb);

        expResult = false;
        result = instance2.addBicycle(bList);
        assertEquals(expResult, result);

        when(bdb.addBicycle(any(Bicycle.class))).thenThrow(new SQLException("e"));
        result = instance2.addBicycle(bList);
        assertFalse(result);
        assertTrue(!result);
    }

    @Test
    public void testRemoveBicycle() throws SQLException {
        System.out.println("removeBicycleList");
        Bicycle b = new Bicycle("B101", 20, 40.67, 60.78, 56.8, 15.6, 10);

        boolean expResult = true;
        boolean result = instance.removeBicycle(b);
        assertEquals(expResult, result);

        BicycleDB bdb = mock(BicycleDB.class);
        when(bdb.removeBicycle(new Bicycle("B101", 20, 40.67, 60.78, 56.8, 15.6, 10))).thenReturn(Boolean.FALSE);
        BicycleController instance1 = new BicycleController(bdb);

        expResult = false;
        result = instance1.removeBicycle(b);
        assertEquals(expResult, result);

        BicycleDB bdb1 = mock(BicycleDB.class);
        when(bdb1.removeBicycle(new Bicycle("B101", 20, 40.67, 60.78, 56.8, 15.6, 10))).thenThrow(new SQLException());
        BicycleController instance2 = new BicycleController(bdb);

        expResult = false;
        result = instance2.removeBicycle(b);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetBicycle() throws SQLException {
        System.out.println("getBicycle");
        Bicycle actual = instance.getBicycle("B101");
        Bicycle expected = new Bicycle("B101", 20, 40.67, 60.78, 56.8, 15.6, 10);
        assertEquals(expected, actual);
        assertNotNull(actual);
        assertThrows(RuntimeException.class, () -> {
            instance.getBicycle("null");
        });
        assertDoesNotThrow(() -> {
            instance.getBicycle("B101");
        });
    }

}
