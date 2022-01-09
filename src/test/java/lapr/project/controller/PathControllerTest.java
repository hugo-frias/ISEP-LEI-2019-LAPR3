package lapr.project.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lapr.project.data.PathDB;
import lapr.project.model.Path;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PathControllerTest {

    private static PathController instance;

    public PathControllerTest() {
    }

    @BeforeAll
    public static void setUpClass() throws SQLException {
        PathDB pdb = mock(PathDB.class);
        when(pdb.addPath(any(Path.class))).thenReturn(true);
        when(pdb.removePath(any(Path.class))).thenReturn(true);
        when(pdb.addPath(any(List.class))).thenReturn(true);
        when(pdb.addPath((List<Path>) null)).thenReturn(false);
        when(pdb.getAllPaths()).thenReturn(new ArrayList<>());
        instance = new PathController(pdb);
    }

    @Test
    void testClass() {
        PathController p = new PathController();
        assertNotNull(p);
    }

    /**
     * Test of addPath method, of class PathController.
     */
    @Test
    void testAddPath() throws SQLException {
        System.out.println("addBicycleList");
        Path b = new Path(40.67, 60.78, 56.8, 15.6, 0.002, 10, 1);

        boolean expResult = true;
        boolean result = instance.addPath(b);
        assertEquals(expResult, result);

        PathDB pdb = mock(PathDB.class);
        when(pdb.addPath(new Path(40.67, 60.78, 56.8, 15.6, 0.002, 10, 1))).thenReturn(Boolean.FALSE);
        PathController instance1 = new PathController(pdb);

        expResult = false;
        result = instance1.addPath(b);
        assertEquals(expResult, result);

        PathDB pdb1 = mock(PathDB.class);
        when(pdb1.addPath(any(List.class))).thenReturn(true);
        PathController instance2 = new PathController(pdb1);

        expResult = false;
        result = instance2.addPath(b);
        assertEquals(expResult, result);

        result = instance.addPath(new ArrayList<>());
        assertTrue(result);

        result = instance.addPath(new ArrayList<>());
        assertTrue(result);

        result = instance.addPath((List<Path>) null);
        assertFalse(result);
    }

    /**
     * Test of removeBicycle method, of class BicycleController.
     */
    @Test
    void testRemoveBicycle() throws SQLException {
        System.out.println("removeBicycleList");
        Path b = new Path(40.67, 60.78, 56.8, 15.6, 0.002, 10, 1);

        boolean expResult = true;
        boolean result = instance.removePath(b);
        assertEquals(expResult, result);

        PathDB bdb = mock(PathDB.class);
        when(bdb.removePath(new Path(40.67, 60.78, 56.8, 15.6, 0.002, 10, 1))).thenReturn(Boolean.FALSE);
        PathController instance1 = new PathController(bdb);

        expResult = false;
        result = instance1.removePath(b);
        assertEquals(expResult, result);

        PathDB bdb1 = mock(PathDB.class);
        when(bdb1.removePath(new Path(40.67, 60.78, 56.8, 15.6, 0.002, 10, 1))).thenThrow(new SQLException());
        PathController instance2 = new PathController(bdb);

        expResult = false;
        result = instance2.removePath(b);
        assertEquals(expResult, result);
    }

    @Test
    void testGetPaths() {
        assertEquals(new ArrayList<>(), instance.getAllPaths());
    }

}
