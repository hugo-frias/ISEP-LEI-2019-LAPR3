package lapr.project.controller;

import lapr.project.data.PoiDB;
import lapr.project.model.Poi;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PoiControllerTest {

    private static PoiController instance;

    @BeforeAll
    public static void setUpClass() throws SQLException {
        PoiDB pdb = mock(PoiDB.class);
        when(pdb.addPoi(any(List.class))).thenReturn(Boolean.TRUE);
        when(pdb.addPoi((List<Poi>) null)).thenReturn(false);
        when(pdb.getPoi(any(Double.class), any(Double.class))).thenReturn(new Poi());
        when(pdb.getPoi(0, 0)).thenReturn(null);
        when(pdb.getNumberOfPois()).thenReturn(5);
        when(pdb.getAllPois()).thenReturn(new ArrayList<>());
        instance = new PoiController(pdb);
    }

    @Test
    void testClass() {
        PoiController p = new PoiController();
        assertNotNull(p);
        PoiController p2 = new PoiController(new PoiDB());
        assertNotNull(p2);
    }

    @Test
    void addPoi() throws SQLException {
        boolean check = instance.addPoi(new ArrayList<>());
        assertTrue(check);
        check = instance.addPoi(null);
        assertFalse(check);
    }

    @Test
    void getPoiByCoordinates() throws SQLException {
        Poi p = (Poi) instance.getPoiByCoordinates(1, 2);
        assertEquals(p, new Poi());
        p = (Poi) instance.getPoiByCoordinates(0, 0);
        assertNull(p);
    }

    @Test
    void getNumberOfPois() throws SQLException {
        int actual = instance.getNumberOfPois();
        assertEquals(5, actual);
    }

    @Test
    void getAllPois() {
        assertEquals(new ArrayList<>(), instance.getAllPois());
    }
}