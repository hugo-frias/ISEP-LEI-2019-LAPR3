/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import lapr.project.data.EScooterDB;
import lapr.project.data.RentDB;
import lapr.project.model.EScooter;
import lapr.project.model.Park;
import lapr.project.model.Place;
import lapr.project.model.Rent;
import lapr.project.model.User;
import lapr.project.model.Vehicle;
import lapr.project.utils.Distances;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Hugo
 */
public class RentControllerTest {

    private static RentController instanceR;

    public RentControllerTest() {
    }

    @BeforeAll
    public static void setUpClass() throws SQLException {
        RentDB rdb = mock(RentDB.class);
        Date data = new Date(15, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        Date data3 = new Date(15, 10, 2023);
        Timestamp timestamp = new Timestamp(1);
        Timestamp timestamp2 = new Timestamp(1);
        User user = new User("Manuel", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("id", data, data2, 300, user, vehicle, parkStart, parkEnd);
        double distance = Distances.distance(parkStart.getLatitude(), parkStart.getLongitude(), parkEnd.getLatitude(), parkEnd.getLongitude(), parkEnd.getElevation() - parkStart.getElevation());
        when(rdb.addRent(instance)).thenReturn(Long.valueOf(1));
        when(rdb.getNumberOfRents()).thenReturn(1);
        when(rdb.getParkByVehicle("PT-E500")).thenReturn(new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5));
        when(rdb.lockVehicle(parkEnd, "Manuel", distance)).thenReturn(Boolean.TRUE);
        when(rdb.getRentByUsername("Manuel")).thenReturn("id");
        when(rdb.lockVehicle(parkEnd, user.getUsername(), distance)).thenReturn(Boolean.TRUE);
        when(rdb.getDateByRentId("id")).thenReturn(data2);
        when(rdb.getTimestampInMiliseconds(data2)).thenReturn(10L);
        when(rdb.getTimestampInMiliseconds(timestamp)).thenReturn(10L);
        when(rdb.getTimestampInMiliseconds(timestamp2)).thenReturn(10L);
        when(rdb.getTimestampInMiliseconds(data3)).thenReturn(0L);
        when(rdb.forHowLongAVehicleIsUnlocked("V")).thenReturn((long) 0);
        when(rdb.getNumberOfRents()).thenReturn(5);

        when(rdb.addRent(any(String.class), any(String.class), any(String.class))).thenReturn(true);
        when(rdb.addRentB(any(String.class), any(String.class), any(String.class))).thenReturn(true);
        when(rdb.addRentR(any(String.class), any(String.class), any(String.class))).thenReturn(true);
        when(rdb.lockVehicle(any(String.class), any(String.class), any(String.class), any(Double.class))).thenReturn(true);
        when(rdb.lockVehicleE(any(String.class), any(String.class), any(String.class), any(Double.class))).thenReturn(true);
        when(rdb.lockVehicleB(any(String.class), any(String.class), any(String.class), any(Double.class))).thenReturn(true);

        when(rdb.getParkByRent(any(String.class))).thenReturn(new Park());
        when(rdb.getRentUpdateMilisseconds(any(String.class))).thenReturn(0L);

        when(rdb.getCost(any(String.class))).thenReturn((double) 0);
        when(rdb.getTotalPoints(any(String.class))).thenReturn(0);
        when(rdb.getAllRentsAndPointsByUsername(any(String.class))).thenReturn(new ArrayList<>());

        when(rdb.getAllRentsByUsername(any(String.class))).thenReturn(new ArrayList<>());

        instanceR = new RentController(rdb);
    }

    /**
     * Test of getNumberOfRents method, of class RentController.
     */
    @Test
    public void testGetNumberOfRents() throws SQLException {
        System.out.println("getNumberOfRents");
        assertEquals(5, instanceR.getNumberOfRents());
    }

    /**
     * Test of addRent method, of class RentController.
     */
    @Test
    public void testAddRent() throws SQLException {
        System.out.println("addRent");
        Date data = new Date(15, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Manuel", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent r = new Rent("id", data, data2, 300, user,
                vehicle, parkStart, parkEnd);
        long expResult = 1;
        long result = instanceR.addRent(r);
        assertEquals(expResult, result);

        RentDB rdb = mock(RentDB.class);
        when(rdb.addRent(r)).thenReturn(Long.valueOf(0));
        RentController instance2 = new RentController(rdb);

        expResult = 0;
        result = instance2.addRent(r);
        assertEquals(expResult, result);

        assertTrue(instanceR.addRent("a", "b", "c"));
        assertTrue(instanceR.addRentB("a", "b", "c"));
        assertTrue(instanceR.addRentE("a", "b", "c"));

    }

    /**
     * Test of getParkByVehicle method, of class RentController.
     */
    @Test
    public void testGetParkByVehicle2() throws SQLException {
        System.out.println("getParkByVehicle");
        Date data = new Date(15, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Manuel", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent r = new Rent("id", data, data2, 300, user,
                vehicle, parkStart, parkEnd);
        String bikeDisc = "";
        RentController instance = new RentController();
        Place expResult = null;
        Place result = instanceR.getParkByVehicle(bikeDisc);
        assertEquals(expResult, result);
    }

    /**
     * Test of getRentByUsername method, of class RentController.
     */
    @Test
    public void testGetRentByUsername() throws SQLException {
        System.out.println("getRentByUsername");
        String username = "Manuel";
        String expResult = "id";
        String result = instanceR.getRentByUsername(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of getRentByUsername method, of class RentController.
     */
    @Test
    public void testGetRentByUsername2() throws SQLException {
        System.out.println("getRentByUsername");
        String username = "";
        String expResult = null;
        String result = instanceR.getRentByUsername(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateByRentID method, of class RentController.
     */
    @Test
    public void testGetDateByRentID2() throws SQLException {
        System.out.println("getDateByRentID");
        String rentId = "";
        RentController instance = new RentController();
        Date expResult = null;
        Date result = instanceR.getDateByRentID(rentId);
        assertEquals(expResult, result);
    }

    /**
     * Test of getTimestampInMiliseconds method, of class RentController.
     */
    @Test
    public void testGetTimestampInMiliseconds2() throws SQLException {
        System.out.println("getTimestampInMiliseconds");
        Date endDate = new Date(15, 10, 2023);
        RentController instance = new RentController();
        Timestamp timestamp = new Timestamp(1);
        Timestamp timestamp2 = new Timestamp(1);
        long expResult = 10L;
        long result = instanceR.getTimestampInMiliseconds(timestamp2);
        assertEquals(expResult, result);
    }

    @Test
    public void testForHowLongAVehicleIsUnlocked() throws SQLException {
        assertEquals(0, instanceR.forHowLongAVehicleIsUnlocked("V"));
    }

    @Test
    public void testForHowLongAVehicleIsUnlocked2() throws SQLException {
        assertNotNull(instanceR.forHowLongAVehicleIsUnlocked("V"));
    }

    @Test
    public void testForHowLongAVehicleIsUnlocked3() throws SQLException {
        assertNotEquals(100, instanceR.forHowLongAVehicleIsUnlocked("V"));
    }

    @Test
    public void testLock() throws SQLException {
        assertTrue(instanceR.lockVehicle("a", "b", "c", 1));
        assertTrue(instanceR.lockVehicleB("a", "b", "c", 1));
        assertTrue(instanceR.lockVehicleE("a", "b", "c", 1));
    }

    @Test
    public void testGetParkByRent() throws SQLException {
        assertEquals(new Park(), instanceR.getParkByRent("l"));
    }

    @Test
    public void testGetRentMilisseconds() throws SQLException {
        assertEquals(0, instanceR.getRentUpdateMilisseconds("a"));
        assertEquals(0, instanceR.getRentMilisseconds("a"));
    }

    @Test
    public void testGetAllRentsByUsername() throws SQLException {
        assertEquals(new ArrayList<>(), instanceR.getAllRentsByUsername("a"));
    }

    @Test
    void testGetCostPoints() throws SQLException {
        assertEquals(0, instanceR.getCost("a"));
        assertEquals(0, instanceR.getTotalPoints("a"));
        assertEquals(new ArrayList<>(), instanceR.getAllRentsAndPointsByUsername("a"));
    }

}
