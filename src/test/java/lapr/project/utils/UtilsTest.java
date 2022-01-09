package lapr.project.utils;

import java.io.IOException;

import lapr.project.model.Place;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import lapr.project.model.Park;
import lapr.project.model.Path;
import org.junit.After;
import org.junit.AfterClass;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;

public class UtilsTest {

    public UtilsTest() {
    }

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
    public void testClass() {
        Utils u = new Utils();
        assertNotNull(u);
    }

    /**
     * Test of lengthOfANum method, of class NewClass.
     */
    @Test
    public void testLengthOfANum_int() {
        System.out.println("lengthOfANum");
        int num = 300;
        int expResult = 3;
        int result = Utils.lengthOfANum(num);
        assertEquals(expResult, result);
    }

    /**
     * Test of lengthOfANum method, of class NewClass.
     */
    @Test
    public void testLengthOfANum_double() {
        System.out.println("lengthOfANum");
        double num = 300.0;
        int expResult = 3;
        int result = Utils.lengthOfANum(num);
        assertEquals(expResult, result);
    }

    /**
     * Test of lengthOfANum method, of class NewClass.
     */
    @Test
    public void testLengthOfANum_double_int() {
        System.out.println("lengthOfANum");
        double num = 300.0;
        int length = 0;
        int expResult = 3;
        int result = Utils.lengthOfANum(num, length);
        assertEquals(expResult, result);
    }

    /**
     * Test of lengthOfANum method, of class NewClass.
     */
    @Test
    public void testLengthOfANum_int2() {
        System.out.println("lengthOfANum");
        int num = 0;
        int expResult = 1;
        int result = Utils.lengthOfANum(num);
        assertEquals(expResult, result);
    }

    @Test
    public void testLengthOfANum() {
        System.out.println("lengthOfANum");
        int length = 1;
        int num = 1;
        int result = Utils.lengthOfANum(num, length);
        assertEquals(1, result);
    }

    @Test
    public void testLengthOfANum2() {
        System.out.println("lengthOfANum");
        int length = 1;
        int num = 2;
        int result = Utils.lengthOfANum(num, length);
        assertEquals(2, result);
    }

    /**
     * Test of round method, of class NewClass.
     */
    @Test
    public void testRound() {
        System.out.println("round");
        double valor = 32.2333;
        int casasDecimais = 2;
        double expResult = 32.23;
        double result = Utils.round(valor, casasDecimais);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of containsNum method, of class NewClass.
     */
    @Test
    public void testContainsNum() {
        System.out.println("containsNum");
        String s = "abcsde";
        boolean expResult = false;
        boolean result = Utils.containsNum(s);
        assertEquals(expResult, result);
    }

    @Test
    public void testContainsNum2() {
        System.out.println("containsNum");
        String s = "abcde23sda";
        boolean expResult = true;
        boolean result = Utils.containsNum(s);
        assertEquals(expResult, result);
    }

    @Test
    public void testContainsNum3() {
        System.out.println("containsNum");
        String s = "";
        boolean expResult = false;
        boolean result = Utils.containsNum(s);
        assertEquals(expResult, result);
    }

    @Test
    public void testContainsNum4() {
        System.out.println("containsNum");
        String s = null;
        boolean expResult = false;
        boolean result = Utils.containsNum(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of containsLetter method, of class NewClass.
     */
    @Test
    public void testContainsLetter() {
        System.out.println("containsLetter");
        String s = "123";
        boolean expResult = false;
        boolean result = Utils.containsLetter(s);
        assertEquals(expResult, result);
    }

    @Test
    public void testContainsLetter2() {
        System.out.println("containsLetter");
        String s = "asd123asd";
        boolean expResult = true;
        boolean result = Utils.containsLetter(s);
        assertEquals(expResult, result);
    }

    @Test
    public void testContainsLetter3() {
        System.out.println("containsLetter");
        String s = "";
        boolean expResult = false;
        boolean result = Utils.containsLetter(s);
        assertEquals(expResult, result);
    }

    @Test
    public void testContainsLetter4() {
        System.out.println("containsLetter");
        String s = null;
        boolean expResult = false;
        boolean result = Utils.containsLetter(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of loadCsv method, of class Utils.
     */
    @Test
    public void testLoadCsv() {
        System.out.println("loadCsv");
        assertNull(Utils.loadCsv(""));
    }

    @Test
    public void testLoadCsv2() {
        System.out.println("loadCsv");
        String nomeFich = "";
        List<String> expResult = null;
        List<String> result = Utils.loadCsv(nomeFich);
        assertEquals(expResult, result);
    }

    @Test
    public void testLoadCsv4() {
        System.out.println("loadCsv");
        String nomeFich = null;
        List<String> expResult = null;
        List<String> result = Utils.loadCsv(nomeFich);
        assertEquals(expResult, result);
    }

    @Ignore
    public void testLoadCsv3() {
        System.out.println("loadCsv");
        String nomeFich = "usersTest";

        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("#lines starting with # should be ignored;;;;;;;");
        expResult.add("#Column description;;;;;;;");
        expResult.add("\"#username for the app - e.g. \"\"john\"\"\";;;;;;;");
        expResult.add("\"#user email - e.g. \"\"john@my.email.server.com\"\"\";;;;;;;");
        expResult.add("#height - the user height in cm with no decimal places - e.g. 150;;;;;;;");
        expResult.add("#weight - the user mass in Kg with no decimal places - e.g. 60;;;;;;;");
        expResult.add("#cycling average speed - the user average speed in m/s with two decimal places e.g 4.17;;;;;;;");
        expResult.add("#visa card number - the visa card number;;;;;;;");
        expResult.add("username;email;height;weight;cycling average speed;visa;;");
        expResult.add("nome;email@lol;15;12;10;123456789;a;asda");
        expResult.add("asdqwe;email@asd;20;30;30;912394855;a;asda");
        List<String> result = Utils.loadCsv(nomeFich);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlaceFromCoordenates method, of class Utils.
     */
    @Test
    public void testgetPlaceFromCoordenates1() {
        System.out.println("getPlaceFromCoordenates");
        double latitude = 28.3;
        double longitude = 11.2;
        ArrayList<Place> parks = new ArrayList<>();

        Park p1 = new Park("1", 27.3, 10.2, 15, "São Bento", 50, 20, 10.5, 14.5);
        Park p2 = new Park("2", 28.3, 11.2, 15, "São Francisco", 50, 20, 10.5, 14.5);
        Park p3 = new Park("3", 29.3, 12.2, 15, "São Carlos", 50, 20, 10.5, 14.5);
        Park p4 = new Park("4", 30.3, 13.2, 15, "São Bernardo", 50, 20, 10.5, 14.5);

        parks.add(p1);
        parks.add(p2);
        parks.add(p3);
        parks.add(p4);

        Park expResult = p2;
        Place result = Utils.getPlaceFromCoordenates(latitude, longitude, parks);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlaceFromCoordenates method, of class Utils.
     */
    @Test
    public void testgetPlaceFromCoordenates2() {
        System.out.println("getPlaceFromCoordenates");
        double latitude = 0.0;
        double longitude = 0.0;
        ArrayList<Place> parks = new ArrayList<>();

        Park p1 = new Park("1", 27.3, 10.2, 15, "São Bento", 50, 20, 10.5, 14.5);
        Park p2 = new Park("2", 28.3, 11.2, 15, "São Francisco", 50, 20, 10.5, 14.5);
        Park p3 = new Park("3", 29.3, 12.2, 15, "São Carlos", 50, 20, 10.5, 14.5);
        Park p4 = new Park("4", 30.3, 13.2, 15, "São Bernardo", 50, 20, 10.5, 14.5);

        parks.add(p1);
        parks.add(p2);
        parks.add(p3);
        parks.add(p4);

        Park expResult = null;
        Place result = Utils.getPlaceFromCoordenates(latitude, longitude, parks);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlaceFromCoordenates method, of class Utils.
     */
    @Test
    public void testgetPlaceFromCoordenates3() {
        System.out.println("getPlaceFromCoordenates");
        double latitude = 28.3;
        double longitude = 0.0;
        ArrayList<Place> parks = new ArrayList<>();

        Park p1 = new Park("1", 27.3, 10.2, 15, "São Bento", 50, 20, 10.5, 14.5);
        Park p2 = new Park("2", 28.3, 11.2, 15, "São Francisco", 50, 20, 10.5, 14.5);
        Park p3 = new Park("3", 29.3, 12.2, 15, "São Carlos", 50, 20, 10.5, 14.5);
        Park p4 = new Park("4", 30.3, 13.2, 15, "São Bernardo", 50, 20, 10.5, 14.5);

        parks.add(p1);
        parks.add(p2);
        parks.add(p3);
        parks.add(p4);

        Park expResult = null;
        Place result = Utils.getPlaceFromCoordenates(latitude, longitude, parks);
        assertEquals(expResult, result);
    }

    /**
     * Test of writeFile method, of class Utils.
     */

    @Test
    public void testWriteFile() throws IOException {
        System.out.println("writeFile");
        String stringToWrite = "Test for Test";
        String nameFile = "teste.txt";
        boolean expResult = true;
        boolean result = Utils.writeFile(stringToWrite, nameFile);
        assertEquals(expResult, result);
    }

    /**
     * Test of writeFile method, of class Utils.
     */

    @Test
    public void testWriteFile2() throws IOException {
        String stringToWrite = "";
        String nameFile = "teste.txt";
        boolean expResult = false;
        boolean result = Utils.writeFile(stringToWrite, nameFile);
        assertEquals(expResult, result);
    }

    /**
     * Test of writeFile method, of class Utils.
     */

    @Test
    public void testWriteFile3() throws IOException {
        String stringToWrite = null;
        String nameFile = null;
        boolean expResult = true;
        boolean result = Utils.writeFile(stringToWrite, nameFile);
        assertNotEquals(expResult, result);
    }
}
