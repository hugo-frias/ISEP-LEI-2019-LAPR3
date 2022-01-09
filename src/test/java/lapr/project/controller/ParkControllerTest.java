package lapr.project.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lapr.project.data.ParkDB;
import lapr.project.model.Bicycle;
import lapr.project.model.EScooter;
import lapr.project.model.Park;
import lapr.project.model.Place;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParkControllerTest {

    private static ParkController instance;
    private static List<Bicycle> auxListBcl;
    private static HashMap<EScooter, Double> auxHashMapES;

    public ParkControllerTest() {
    }

    @BeforeAll
    public static void setUpClass() throws SQLException {
        List<Park> pList = new ArrayList<>();
        Park p = new Park("1", 23.3, -10.2, 5, "Trindade", 50, 20, 10.5, 14.5);
        pList.add(p);
        ParkDB parkDb = mock(ParkDB.class);
        when(parkDb.getMaxNumberOfBicyclesByParkCoords(0, 0)).thenReturn(0);
        when(parkDb.getMaxNumberOfBicyclesByParkID("P")).thenReturn(0);
        when(parkDb.getMaxNumberOfEScootersByParkCoords(0, 0)).thenReturn(0);
        when(parkDb.getMaxNumberOfScooters("P")).thenReturn(0);
        when(parkDb.getBicyclesByParkCoords(0, 0)).thenReturn(new ArrayList<>());
        when(parkDb.getBicyclesByParkID("P")).thenReturn(new ArrayList<>());
        when(parkDb.addPark(pList)).thenReturn(Boolean.TRUE);
        when(parkDb.addPark(p)).thenReturn(Boolean.TRUE);
        when(parkDb.getPark(any(String.class))).thenReturn(new Park());
        when(parkDb.getPark(any(Double.class), any(Double.class))).thenReturn(new Park());
        when(parkDb.removePark(p)).thenReturn(Boolean.TRUE);
        when(parkDb.getEScootersByParkCoords(any(Double.class), any(Double.class))).thenReturn(new ArrayList<>());
        when(parkDb.getEScootersByParkID(any(String.class))).thenReturn(new ArrayList<>());
        when(parkDb.getChargingEScootersByParkID("P")).thenReturn(new HashMap<>());
        when(parkDb.hasFreeSlotsLoanedVehicle("P", "UE@gmail.com")).thenReturn(2);
        when(parkDb.getAllParks()).thenReturn(new ArrayList<>());
        instance = new ParkController(parkDb);
        auxListBcl = new ArrayList<>();
        auxListBcl.add(new Bicycle("B101", 20, 40.67, 60.78, 56.8, 15.6, 10));
        auxHashMapES = new HashMap<>();
        EScooter eSAux = new EScooter("E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        auxHashMapES.put(eSAux, (double) (eSAux.getMaxBatteryCapacity() - eSAux.getActualBatteryCapacity()) * 60 / 1000 * 60);
    }

    @Test
    void testClass() {
        ParkController p = new ParkController();
        assertNotNull(p);
        ParkController p2 = new ParkController(new ParkDB());
        assertNotNull(p2);
    }

    @Test
    void getNumberOfBicycles() throws SQLException {
        assertEquals(new ArrayList<>(), instance.getBicyclesByParkID("P"));
    }

    @Test
    void getNumberOfBicycles1() throws SQLException {
        assertEquals(new ArrayList<>(), instance.getBicyclesByCords(0, 0));
    }

    @Test
    void getNumberOfBicycles2() throws SQLException {
        assertNotNull(instance.getBicyclesByCords(0, 0));
    }

    @Test
    void getNumberOfBicycles3() throws SQLException {
        assertNotNull(instance.getBicyclesByParkID("P"));
    }

    @Test
    void getNumberOfBicycles4() throws SQLException {
        assertNotEquals(auxListBcl, instance.getBicyclesByParkID("P"));
    }

    @Test
    void getNumberOfBicycles5() throws SQLException {
        assertNotEquals(auxListBcl, instance.getBicyclesByCords(0, 0));
    }

    @Test
    void checkParkFSBicycles() throws SQLException {
        assertNotEquals(100, instance.hasFreeSlotsBicyclesByParkID("P"));
    }

    @Test
    void checkParkFSBicycles1() throws SQLException {
        assertNotNull(instance.hasFreeSlotsBicyclesByParkID("P"));
    }

    @Test
    void checkParkFSBicycles2() throws SQLException {
        assertEquals(0, instance.hasFreeSlotsBicyclesByParkID("P"));
    }

    @Test
    void checkParkFSScooters() throws SQLException {
        assertNotEquals(100, instance.hasFreeSlotsEScootersByParkID("P"));
    }

    @Test
    void checkParkFSScooters1() throws SQLException {
        assertNotNull(instance.hasFreeSlotsEScootersByParkID("P"));
    }

    @Test
    void checkParkFSScooters2() throws SQLException {
        assertEquals(0, instance.hasFreeSlotsEScootersByParkID("P"));
    }

    @Test
    void checkParkLoanedVehicle() throws SQLException {
        assertEquals(2, instance.hasFreeSlotsLoanedVehicle("P", "UE@gmail.com"));
    }

    @Test
    void checkParkLoanedVehicle1() throws SQLException {
        assertNotNull(instance.hasFreeSlotsLoanedVehicle("P", "UE@gmail.com"));
    }

    @Test
    void checkParkLoanedVehicle2() throws SQLException {
        assertNotEquals(100, instance.hasFreeSlotsLoanedVehicle("P", "UE@gmail.com"));
    }

    @Test
    void getChargingEScootersByParkID() throws SQLException {
        assertEquals(new HashMap<>(), instance.getChargingEScootersByParkID("P"));
    }

    @Test
    void getChargingEScootersByParkID2() throws SQLException {
        assertNotNull(instance.getChargingEScootersByParkID("P"));
    }

    @Test
    void getChargingEScootersByParkID3() throws SQLException {
        assertNotEquals(auxHashMapES, instance.getChargingEScootersByParkID("P"));
    }

    /**
     * Test of addPark method, of class ParkController.
     */
    @Test
    public void testAddPark() throws SQLException {
        System.out.println("addPark");
        Park p = new Park("1", 23.3, -10.2, 5, "Trindade", 50, 20, 10.5, 14.5);
        List<Park> pList = new ArrayList<>();
        pList.add(p);
        boolean expResult = true;
        boolean result = instance.addPark(pList);
        assertEquals(expResult, result);

        ParkDB pdb = mock(ParkDB.class);
        when(pdb.addPark(new Park("1", 23.3, -10.2, 5, "Trindade", 50, 20, 10.5, 14.5))).thenReturn(Boolean.FALSE);
        ParkController instance1 = new ParkController(pdb);

        expResult = false;
        result = instance1.addPark(pList);
        assertEquals(expResult, result);

        ParkDB pdb1 = mock(ParkDB.class);
        when(pdb1.addPark(new Park("1", 23.3, -10.2, 5, "Trindade", 50, 20, 10.5, 14.5))).thenThrow(new SQLException());
        ParkController instance2 = new ParkController(pdb);

        expResult = false;
        result = instance2.addPark(pList);
        assertEquals(expResult, result);
    }

    /**
     * Test of removePark method, of class ParkController.
     */
    @Test
    public void testRemovePark() throws SQLException {
        System.out.println("removePark");
        Park p = new Park("1", 23.3, -10.2, 5, "Trindade", 50, 20, 10.5, 14.5);

        boolean expResult = true;
        boolean result = instance.removePark(p);
        assertEquals(expResult, result);

        ParkDB pdb = mock(ParkDB.class);
        when(pdb.removePark(new Park("1", 23.3, -10.2, 5, "Trindade", 50, 20, 10.5, 14.5))).thenReturn(Boolean.FALSE);
        ParkController instance1 = new ParkController(pdb);

        expResult = false;
        result = instance1.removePark(p);
        assertEquals(expResult, result);

        ParkDB pdb1 = mock(ParkDB.class);
        when(pdb1.removePark(new Park("1", 23.3, -10.2, 5, "Trindade", 50, 20, 10.5, 14.5))).thenThrow(new SQLException());
        ParkController instance2 = new ParkController(pdb);

        expResult = false;
        result = instance2.removePark(p);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNumES() throws SQLException {
        List<EScooter> l = instance.getEScootersByParkCoords(1, 1);
        assertEquals(new ArrayList<>(), l);
        l = instance.getEScootersByParkID("s");
        assertEquals(new ArrayList<>(), l);
    }

    @Test
    public void testGetESPark() throws SQLException {
        assertEquals(new ArrayList<>(), instance.getEScootersByParkCoords(1, 2));
        assertEquals(new ArrayList<>(), instance.getEScootersByParkID("a"));
    }

    @Test
    public void testGetPark() throws SQLException {
        assertEquals(new Park(), instance.getPark("a"));
        assertEquals(new Park(), instance.getParkByCoordinates(1, 2));
        assertEquals(new ArrayList<>(), instance.getAllParks());
    }
}
