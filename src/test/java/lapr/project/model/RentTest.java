package lapr.project.model;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class RentTest {

    public RentTest() {
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
     * Test of getRequest_code method, of class Rent.
     */
    @Test
    public void testGetRequest_code() {
        System.out.println("getRequest_code");
        Date data = new Date(15, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Manuel", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("id", data, data2, 300, user,
                vehicle, parkStart, parkEnd);
        String expResult = "id";
        String result = instance.getRequestCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRequest_code method, of class Rent.
     */
    @Test
    public void testGetRequest_code2() {
        System.out.println("getRequest_code");
        Date data = new Date(15, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Manuel", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("id2", data, data2, 300, user,

                vehicle, parkStart, parkEnd);
        String expResult = "id2";
        String result = instance.getRequestCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRequest_code method, of class Rent.
     */
    @Test
    public void testGetRequest_code3() {
        System.out.println("getRequest_code");
        Date data = new Date(15, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Manuel", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("3", data, data2, 300, user,
                vehicle, parkStart, parkEnd);
        String expResult = "3";
        String result = instance.getRequestCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRequest_code method, of class Rent.
     */
    @Test
    public void testSetRequest_code() {
        System.out.println("setRequest_code");
        Date data = new Date(15, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Manuel", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("3", data, data2, 300, user,
                vehicle, parkStart, parkEnd);
        String request_code = "1";
        instance.setRequestCode(request_code);
    }

    /**
     * Test of setRequest_code method, of class Rent.
     */
    @Test
    public void testSetRequest_code2() {
        System.out.println("setRequest_code");
        Date data = new Date(15, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Manuel", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("3", data, data2, 300, user,
                vehicle, parkStart, parkEnd);
        String request_code = "2";
        instance.setRequestCode(request_code);
    }

    /**
     * Test of setRequest_code method, of class Rent.
     */
    @Test
    public void testSetRequest_code3() {
        System.out.println("setRequest_code");
        Date data = new Date(15, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Manuel", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("3", data, data2, 300, user,
                vehicle, parkStart, parkEnd);
        String request_code = "5";
        instance.setRequestCode(request_code);
    }

    /**
     * Test of getDate_rent method, of class Rent.
     */
    @Test
    public void testGetDate_hour_start() {
        System.out.println("getDate_rent");
        Date data = new Date(15, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Manuel", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 300, user,

                vehicle, parkStart, parkEnd);
        Date expResult = new Date(15, 10, 2000);
        Date result = instance.getDate_hour_start();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDate_rent method, of class Rent.
     */
    @Test
    public void testGetDate_hour_start2() {
        System.out.println("getDate_rent");
        Date data = new Date(12, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Manuel", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 300, user,
                vehicle, parkStart, parkEnd);
        Date expResult = new Date(12, 10, 2000);
        Date result = instance.getDate_hour_start();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDate_rent method, of class Rent.
     */
    @Test
    public void testGetDate_hour_start3() {
        System.out.println("getDate_rent");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Manuel", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 300, user,
                vehicle, parkStart, parkEnd);
        Date expResult = new Date(13, 10, 2000);
        Date result = instance.getDate_hour_start();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDate_rent method, of class Rent.
     */
    @Test
    public void testSetDate_hour_start() {
        System.out.println("setDate_rent");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Antonio", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 300, user,
                vehicle, parkStart, parkEnd);
        Date date_rent = new Date(19, 10, 2000);
        instance.setDate_hour_start(date_rent);
    }

    /**
     * Test of setDate_rent method, of class Rent.
     */
    @Test
    public void testSetDate_hour_start2() {
        System.out.println("setDate_rent");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Manuel", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 300, user,
                vehicle, parkStart, parkEnd);
        Date date_rent = new Date(10, 10, 2000);
        instance.setDate_hour_start(date_rent);
    }

    /**
     * Test of setDate_rent method, of class Rent.
     */
    @Test
    public void testSetDate_hour_start3() {
        System.out.println("setDate_rent");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Manuel", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 300, user,
                vehicle, parkStart, parkEnd);
        Date date_rent = new Date(15, 10, 2000);
        instance.setDate_hour_start(date_rent);
    }

    /**
     * Test of getDate_hour_finish method, of class Rent.
     */
    @Test
    public void testGetDate_hour_finish() {
        System.out.println("getDate_hour_finish");
        Date data = new Date(15, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Manuel", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 300, user,

                vehicle, parkStart, parkEnd);
        Date expResult = new Date(15, 10, 2001);
        Date result = instance.getDate_hour_finish();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDate_hour_finish method, of class Rent.
     */
    @Test
    public void testGetDate_hour_finish2() {
        System.out.println("getDate_hour_finish");
        Date data = new Date(15, 10, 2000);
        Date data2 = new Date(15, 10, 2002);
        User user = new User("Manuel", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 300, user,

                vehicle, parkStart, parkEnd);
        Date expResult = new Date(15, 10, 2002);
        Date result = instance.getDate_hour_finish();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDate_hour_finish method, of class Rent.
     */
    @Test
    public void testGetDate_hour_finish3() {
        System.out.println("getDate_hour_finish");
        Date data = new Date(15, 10, 2000);
        Date data2 = new Date(15, 10, 2003);
        User user = new User("Manuel", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 300, user,

                vehicle, parkStart, parkEnd);
        Date expResult = new Date(15, 10, 2003);
        Date result = instance.getDate_hour_finish();
        assertEquals(expResult, result);
    }


    /**
     * Test of setDate_hour_finish method, of class Rent.
     */
    @Test
    public void testSetDate_hour_finish() {
        System.out.println("setDate_hour_finish");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Antonio", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 300, user,
                vehicle, parkStart, parkEnd);
        Date date2 = new Date(19, 10, 2030);
        instance.setDate_hour_finish(date2);
    }

    /**
     * Test of setDate_hour_finish method, of class Rent.
     */
    @Test
    public void testSetDate_hour_finish2() {
        System.out.println("setDate_hour_finish");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Antonio", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 300, user,
                vehicle, parkStart, parkEnd);
        Date date2 = new Date(19, 10, 3000);
        instance.setDate_hour_finish(date2);
    }

    /**
     * Test of setDate_hour_finish method, of class Rent.
     */
    @Test
    public void testSetDate_hour_finish3() {
        System.out.println("setDate_hour_finish");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Antonio", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 300, user,
                vehicle, parkStart, parkEnd);
        Date date2 = new Date(19, 9, 2030);
        instance.setDate_hour_finish(date2);
    }


    /**
     * Test of getDistancia_km method, of class Rent.
     */
    @Test
    public void testGetDistancia_km() {
        System.out.println("getDistancia_km");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Manuel", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 300, user,
                vehicle, parkStart, parkEnd);
        int expResult = 300;
        int result = instance.getDistanciaKm();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDistancia_km method, of class Rent.
     */
    @Test
    public void testGetDistancia_km2() {
        System.out.println("getDistancia_km");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Manuel", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 400, user,
                vehicle, parkStart, parkEnd);
        int expResult = 400;
        int result = instance.getDistanciaKm();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDistancia_km method, of class Rent.
     */
    @Test
    public void testGetDistancia_km3() {
        System.out.println("getDistancia_km");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Manuel", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 10, user,

                vehicle, parkStart, parkEnd);
        int expResult = 10;
        int result = instance.getDistanciaKm();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDistancia_km method, of class Rent.
     */
    @Test
    public void testSetDistancia_km() {
        System.out.println("setDistancia_km");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Manuel", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 10, user,

                vehicle, parkStart, parkEnd);
        int distancia_km = 300;
        instance.setDistanciaKm(distancia_km);
    }

    /**
     * Test of setDistancia_km method, of class Rent.
     */
    @Test
    public void testSetDistancia_km2() {
        System.out.println("setDistancia_km");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Manuel", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 10, user,

                vehicle, parkStart, parkEnd);
        int distancia_km = 200;
        instance.setDistanciaKm(distancia_km);
    }

    /**
     * Test of setDistancia_km method, of class Rent.
     */
    @Test
    public void testSetDistancia_km3() {
        System.out.println("setDistancia_km");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Manuel", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 10, user,

                vehicle, parkStart, parkEnd);
        int distancia_km = 123;
        instance.setDistanciaKm(distancia_km);
    }

    /**
     * Test of getUser method, of class Rent.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Manuel", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 10, user, vehicle, parkStart, parkEnd);
        User expResult = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        User result = instance.getUser();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUser method, of class Rent.
     */
    @Test
    public void testGetUser2() {
        System.out.println("getUser");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Manuel", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 10, user,

                vehicle, parkStart, parkEnd);
        User expResult = new User("Manuel", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        User result = instance.getUser();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUser method, of class Rent.
     */
    @Test
    public void testGetUser3() {
        System.out.println("getUser");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Antonio", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 10, user,

                vehicle, parkStart, parkEnd);
        User expResult = new User("Antonio", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        User result = instance.getUser();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUser method, of class Rent.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Antonio", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 10, user,

                vehicle, parkStart, parkEnd);
        User user_test = new User("Antonio2", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        instance.setUser(user_test);
    }

    /**
     * Test of setUser method, of class Rent.
     */
    @Test
    public void testSetUser2() {
        System.out.println("setUser");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Antonio", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 10, user,

                vehicle, parkStart, parkEnd);
        User user_test = new User("Antonio2", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        instance.setUser(user_test);
    }

    /**
     * Test of setUser method, of class Rent.
     */
    @Test
    public void testSetUser3() {
        System.out.println("setUser");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Antonio", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 10, user,

                vehicle, parkStart, parkEnd);
        User user_test = new User("Antonio2", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        instance.setUser(user_test);
    }

    /**
     * Test of getVehicle method, of class Rent.
     */
    @Test
    public void testGetVehicle() {
        System.out.println("getVehicle");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Antonio", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 10, user,

                vehicle, parkStart, parkEnd);
        Vehicle expResult = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        Vehicle result = instance.getVehicle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getVehicle method, of class Rent.
     */
    @Test
    public void testGetVehicle2() {
        System.out.println("getVehicle");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Antonio", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 10, user,

                vehicle, parkStart, parkEnd);
        Vehicle expResult = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        Vehicle result = instance.getVehicle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getVehicle method, of class Rent.
     */
    @Test
    public void testGetVehicle3() {
        System.out.println("getVehicle");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Antonio", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 10, user,

                vehicle, parkStart, parkEnd);
        Vehicle expResult = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        Vehicle result = instance.getVehicle();
        assertEquals(expResult, result);
    }

    /**
     * Test of setVehicle method, of class Rent.
     */
    @Test
    public void testSetVehicle() {
        System.out.println("setVehicle");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Antonio", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 10, user,

                vehicle, parkStart, parkEnd);
        Vehicle vehicleFinal = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        instance.setVehicle(vehicleFinal);
    }

    /**
     * Test of setVehicle method, of class Rent.
     */
    @Test
    public void testSetVehicle2() {
        System.out.println("setVehicle");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Antonio", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 10, user,

                vehicle, parkStart, parkEnd);
        Vehicle vehicleFinal = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        instance.setVehicle(vehicleFinal);
    }

    /**
     * Test of setVehicle method, of class Rent.
     */
    @Test
    public void testSetVehicle3() {
        System.out.println("setVehicle");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Antonio", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 10, user,

                vehicle, parkStart, parkEnd);
        Vehicle vehicleFinal = new EScooter("PT-E300", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        instance.setVehicle(vehicleFinal);
    }

    /**
     * Test of getInitial_park method, of class Rent.
     */
    @Test
    public void testGetInitial_park() {
        System.out.println("getInitial_park");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Antonio", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 10, user,

                vehicle, parkStart, parkEnd);
        Park expResult = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park result = instance.getInitialPark();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInitial_park method, of class Rent.
     */
    @Test
    public void testGetInitial_park2() {
        System.out.println("getInitial_park");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Antonio", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        Park parkStart = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 10, user,
                vehicle, parkStart, parkEnd);
        Park expResult = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Park result = instance.getInitialPark();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInitial_park method, of class Rent.
     */
    @Test
    public void testGetInitial_park3() {
        System.out.println("getInitial_park");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Antonio", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);
        Park parkStart = new Park("1", 27.3, 10.2, 15, "Campo", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 10, user,
                vehicle, parkStart, parkEnd);
        Park expResult = new Park("1", 27.3, 10.2, 15, "Campo", 50, 20, 10.5, 14.5);
        Park result = instance.getInitialPark();
        assertEquals(expResult, result);
    }

    /**
     * Test of setInitial_park method, of class Rent.
     */
    @Test
    public void testSetInitial_park() {
        System.out.println("setInitial_park");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Antonio", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Campo", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 10, user,
                vehicle, parkStart, parkEnd);
        Park initial_park = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        instance.setInitialPark(initial_park);
    }

    /**
     * Test of setInitial_park method, of class Rent.
     */
    @Test
    public void testSetInitial_park2() {
        System.out.println("setInitial_park");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Antonio", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Campo", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 10, user,
                vehicle, parkStart, parkEnd);
        Park initial_park = new Park("1", 27.3, 10.2, 15, "Campo", 50, 20, 10.5, 14.5);
        instance.setInitialPark(initial_park);
    }

    /**
     * Test of setInitial_park method, of class Rent.
     */
    @Test
    public void testSetInitial_park3() {
        System.out.println("setInitial_park");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Antonio", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Campo", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 10, user,
                vehicle, parkStart, parkEnd);
        Park initial_park = new Park("1", 27.3, 10.2, 15, "Bolhão", 50, 20, 10.5, 14.5);
        instance.setInitialPark(initial_park);
    }

    /**
     * Test of getEnd_park method, of class Rent.
     */
    @Test
    public void testGetEnd_park() {
        System.out.println("getEnd_park");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Antonio", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Campo", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 10, user,
                vehicle, parkStart, parkEnd);
        Park expResult = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Park result = instance.getEndPark();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEnd_park method, of class Rent.
     */
    @Test
    public void testGetEnd_park2() {
        System.out.println("getEnd_park");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Antonio", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Campo", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 10, user,
                vehicle, parkStart, parkEnd);
        Park expResult = new Park("1", 27.3, 10.2, 15, "Campo", 50, 20, 10.5, 14.5);
        Park result = instance.getEndPark();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEnd_park method, of class Rent.
     */
    @Test
    public void testGetEnd_park3() {
        System.out.println("getEnd_park");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Antonio", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Campo", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Bolhão", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 10, user,
                vehicle, parkStart, parkEnd);
        Park expResult = new Park("1", 27.3, 10.2, 15, "Bolhão", 50, 20, 10.5, 14.5);
        Park result = instance.getEndPark();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEnd_park method, of class Rent.
     */
    @Test
    public void testSetEnd_park() {
        System.out.println("setEnd_park");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Antonio", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Campo", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Bolhão", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 10, user,
                vehicle, parkStart, parkEnd);
        Park end_park = new Park("1", 27.3, 10.2, 15, "Campo", 50, 20, 10.5, 14.5);
        ;
        instance.setEnd_park(end_park);
    }

    /**
     * Test of setEnd_park method, of class Rent.
     */
    @Test
    public void testSetEnd_park2() {
        System.out.println("setEnd_park");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Antonio", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Campo", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Bolhão", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 10, user,
                vehicle, parkStart, parkEnd);
        Park end_park = new Park("1", 27.3, 10.2, 15, "Camp", 50, 20, 10.5, 14.5);
        ;
        instance.setEnd_park(end_park);
    }

    /**
     * Test of setEnd_park method, of class Rent.
     */
    @Test
    public void testSetEnd_park3() {
        System.out.println("setEnd_park");
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Antonio", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Campo", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Bolhão", 50, 20, 10.5, 14.5);
        Rent instance = new Rent("1", data, data2, 10, user,
                vehicle, parkStart, parkEnd);
        Park end_park = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        ;
        instance.setEnd_park(end_park);
    }

    @Test
    void testEquals1() {
        Rent p = new Rent();
        assertEquals(p, p);
        assertEquals(p.hashCode(), p.hashCode());
    }

    @Test
    void testEquals2() {
        Rent p1 = new Rent();
        Rent p2 = null;
        assertNotEquals(p1, p2);
    }

    @Test
    void testEquals3() {
        Rent p1 = new Rent();
        Poi p2 = new Poi();
        assertNotEquals(p1, p2);
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }

    @Ignore
    void testEquals4() {
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Antonio", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent p1 = new Rent("1", data, data2, 10, user,
                vehicle, parkStart, parkEnd);
        Rent p2 = new Rent("1", data, data2, 10, user,
                vehicle, parkStart, parkEnd);
        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void testEquals5() {
        Date data = new Date(13, 10, 2000);
        Date data2 = new Date(15, 10, 2001);
        User user = new User("Antonio", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        Vehicle vehicle = new EScooter("PT-E500", 15, 15.5, -16.6, 30, 20, "off-road", 100, 50, 250);

        Park parkStart = new Park("1", 27.3, 10.2, 15, "Trindade", 50, 20, 10.5, 14.5);
        Park parkEnd = new Park("1", 27.3, 10.2, 15, "Maia", 50, 20, 10.5, 14.5);
        Rent p1 = new Rent("1", data, data2, 10, user,
                vehicle, parkStart, parkEnd);
        Rent p2 = new Rent("2", data, data2, 10, user,
                vehicle, parkStart, parkEnd);
        assertNotEquals(p1, p2);
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }


}
