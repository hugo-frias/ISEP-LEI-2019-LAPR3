/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.data.EScooterDB;
import lapr.project.model.EScooter;
import lapr.project.model.Park;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Vera Pinto
 */
public class EScooterControllerTest {

    private static EScooterController instance;
    private static List<EScooter> auxListEScooter;

    public EScooterControllerTest() {
    }

    @BeforeAll
    public static void setUpClass() throws SQLException, IOException {
        List<EScooter> esList = new ArrayList<>();
        EScooter es = new EScooter("E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        esList.add(es);
        EScooterDB esdb = mock(EScooterDB.class);
        when(esdb.addEScooter(esList)).thenReturn(true);
        when(esdb.addEScooter(es)).thenReturn(true);
        when(esdb.removeEScooter(es)).thenReturn(true);
        when(esdb.getEScooter(any(String.class))).thenReturn(new EScooter());
        when(esdb.getEscooterWithEnergy(any(Double.class), any(String.class))).thenReturn(10);
        when(esdb.getEScooterForEnergy(any(String.class), any(Double.class))).thenReturn(new ArrayList<>());
        when(esdb.getHighestBatteryScooter(any(String.class))).thenReturn(new EScooter());

        auxListEScooter = new ArrayList<>();
        auxListEScooter.add(new EScooter("E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250));
        auxListEScooter.add(new EScooter("E501", 15, 15.5, -16.6, 30, 20, "off-road", 100, 62, 247));
        when(esdb.getAllEScooters()).thenReturn(auxListEScooter);

        when(esdb.getMinEnergyWithEScooters(auxListEScooter, 150)).thenReturn((double) 2470);

        instance = new EScooterController(esdb);
    }

    @Test
    public void testClass() {
        EScooterController esc = new EScooterController();
        assertNotNull(esc);
        EScooterController esc2 = new EScooterController(new EScooterDB());
        assertNotNull(esc2);
    }

    @Test
    public void testAddEScooter() throws SQLException {
        System.out.println("addEScooter");
        EScooter es = new EScooter("E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        List<EScooter> esList = new ArrayList<>();
        esList.add(es);
        boolean expResult = true;
        boolean result = instance.addEScooter(esList);
        assertEquals(expResult, result);

        EScooterDB esdb = mock(EScooterDB.class);
        when(esdb.addEScooter(new EScooter("E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250))).thenReturn(Boolean.FALSE);
        EScooterController instance1 = new EScooterController(esdb);

        expResult = false;
        result = instance1.addEScooter(esList);
        assertEquals(expResult, result);

        EScooterDB esdb1 = mock(EScooterDB.class);
        when(esdb1.addEScooter(new EScooter("E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250))).thenThrow(new SQLException());
        EScooterController instance2 = new EScooterController(esdb);

        expResult = false;
        result = instance2.addEScooter(esList);
        assertEquals(expResult, result);
    }

    @Test
    public void testRemoveEScooter() throws SQLException {
        System.out.println("removeEScooter");
        EScooter es = new EScooter("E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        boolean expResult = true;
        boolean result = instance.removeEScooter(es);
        assertEquals(expResult, result);

        EScooterDB esdb = mock(EScooterDB.class);
        when(esdb.removeEScooter(new EScooter("E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250))).thenReturn(Boolean.FALSE);
        EScooterController instance1 = new EScooterController(esdb);

        expResult = false;
        result = instance1.removeEScooter(es);
        assertEquals(expResult, result);

        EScooterDB esdb1 = mock(EScooterDB.class);
        when(esdb1.removeEScooter(new EScooter("E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250))).thenThrow(new SQLException());
        EScooterController instance2 = new EScooterController(esdb);

        expResult = false;
        result = instance2.removeEScooter(es);
        assertEquals(expResult, result);
    }

    @Test
    void suggestEscootersToGoFromOneParkToAnother() throws IOException, SQLException {
        Park p1 = new Park("1", 23.3, -10.2, 5, "Trindade", 50, 20, 10.5, 14.5);
        int actual = instance.suggestEscootersToGoFromOneParkToAnother(p1, p1, "null", "out.txt");
        assertEquals(10, actual);
        ArrayList<EScooter> l = (ArrayList<EScooter>) instance.getEScooterForEnergy("id", 10);
        assertEquals(new ArrayList<EScooter>(), l);
    }

    @Test
    void testGetES() throws SQLException {
        EScooter actual = instance.getEScooter("test");
        assertEquals(new EScooter(), actual);
    }

    @Test
    void testGetHighestBatteryScooter() throws SQLException {
        assertEquals(new EScooter(), instance.getHighestBatteryScooter("a"));
    }

    @Test
    void testGetAllEScooters() {
        assertEquals(auxListEScooter, instance.getAllEScooters());
    }

    @Test
    void testGetAllEScooters1() {
        assertNotNull(instance.getAllEScooters());
    }

    @Test
    void testGetAllEScooters3() {
        assertNotEquals(null, instance.getAllEScooters());
    }

    @Test
    void testGetEnergyWithEScooters() {
        assertEquals(2470, instance.getEnergyWithEScooters(auxListEScooter, 150));
    }

    @Test
    void testGetEnergyWithEScooters1() {
        assertNotNull(instance.getEnergyWithEScooters(auxListEScooter, 150));
    }

    @Test
    void testGetEnergyWithEScooters2() {
        assertNotEquals(0, instance.getEnergyWithEScooters(auxListEScooter, 150));
    }
}
