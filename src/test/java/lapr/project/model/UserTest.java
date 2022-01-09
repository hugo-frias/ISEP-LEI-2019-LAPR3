/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Hugo
 */
public class UserTest {

    public UserTest() {
    }

    /**
     * Test of getUsername method, of class User.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        String expResult = "José";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsername method, of class User.
     */
    @Test
    public void testGetUsername2() {
        System.out.println("getUsername");
        User instance = new User("Manuel", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        String expResult = "Manuel";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsername method, of class User.
     */
    @Test
    public void testGetUsername3() {
        System.out.println("getUsername");
        User instance = new User("Hugo", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        String expResult = "Hugo";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsername method, of class User.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "José";
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        instance.setUsername(username);
    }

    /**
     * Test of setUsername method, of class User.
     */
    @Test
    public void testSetUsername2() {
        System.out.println("setUsername");
        String username = "Manuel";
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        instance.setUsername(username);
    }

    /**
     * Test of setUsername method, of class User.
     */
    @Test
    public void testSetUsername3() {
        System.out.println("setUsername");
        String username = "Diogo";
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        instance.setUsername(username);
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        String expResult = "a@gmail.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        assertNotNull(result.hashCode());
        assertEquals(result.hashCode(), expResult.hashCode());
        assertNotEquals(result.hashCode(), 0);
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail2() {
        System.out.println("getEmail");
        User instance = new User("José", "b@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        String expResult = "b@gmail.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        assertNotNull(result.hashCode());
        assertEquals(result.hashCode(), expResult.hashCode());
        assertNotEquals(result.hashCode(), 0);

    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail3() {
        System.out.println("getEmail");
        User instance = new User("José", "c@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        String expResult = "c@gmail.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        assertNotNull(result.hashCode());
        assertEquals(result.hashCode(), expResult.hashCode());
        assertNotEquals(result.hashCode(), 0);
        assertTrue(-1 * result.hashCode() < 0);
    }

    /**
     * Test of setEmail method, of class User.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "d@gmail.com";
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        instance.setEmail(email);
    }

    /**
     * Test of setEmail method, of class User.
     */
    @Test
    public void testSetEmail2() {
        System.out.println("setEmail");
        String email = "f@gmail.com";
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        instance.setEmail(email);
    }

    /**
     * Test of setEmail method, of class User.
     */
    @Test
    public void testSetEmail3() {
        System.out.println("setEmail");
        String email = "h@gmail.com";
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        instance.setEmail(email);
    }

    /**
     * Test of getHeight method, of class User.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        int expResult = 150;
        int result = instance.getHeight();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHeight method, of class User.
     */
    @Test
    public void testGetHeight2() {
        System.out.println("getHeight");
        User instance = new User("José", "a@gmail.com", "abc", 170, 70, 'M', 10, 123456789, 10);
        int expResult = 170;
        int result = instance.getHeight();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHeight method, of class User.
     */
    @Test
    public void testGetHeight3() {
        System.out.println("getHeight");
        User instance = new User("José", "a@gmail.com", "abc", 160, 70, 'M', 10, 123456789, 10);
        int expResult = 160;
        int result = instance.getHeight();
        assertEquals(expResult, result);
    }

    /**
     * Test of setHeight method, of class User.
     */
    @Test
    public void testSetHeight() {
        System.out.println("setHeight");
        int height = 180;
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        instance.setHeight(height);
    }

    /**
     * Test of setHeight method, of class User.
     */
    @Test
    public void testSetHeight2() {
        System.out.println("setHeight");
        int height = 190;
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        instance.setHeight(height);
    }

    /**
     * Test of setHeight method, of class User.
     */
    @Test
    public void testSetHeight3() {
        System.out.println("setHeight");
        int height = 170;
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        instance.setHeight(height);
    }

    /**
     * Test of getWeight method, of class User.
     */
    @Test
    public void testGetWeight() {
        System.out.println("getWeight");
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        int expResult = 70;
        int result = instance.getWeight();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWeight method, of class User.
     */
    @Test
    public void testGetWeight2() {
        System.out.println("getWeight");
        User instance = new User("José", "a@gmail.com", "abc", 150, 80, 'M', 10, 123456789, 10);
        int expResult = 80;
        int result = instance.getWeight();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWeight method, of class User.
     */
    @Test
    public void testGetWeight3() {
        System.out.println("getWeight");
        User instance = new User("José", "a@gmail.com", "abc", 150, 90, 'M', 10, 123456789, 10);
        int expResult = 90;
        int result = instance.getWeight();
        assertEquals(expResult, result);
    }

    /**
     * Test of setWeight method, of class User.
     */
    @Test
    public void testSetWeight() {
        System.out.println("setWeight");
        int weight = 45;
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        instance.setWeight(weight);
    }

    /**
     * Test of setWeight method, of class User.
     */
    @Test
    public void testSetWeight2() {
        System.out.println("setWeight");
        int weight = 50;
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        instance.setWeight(weight);
    }

    /**
     * Test of setWeight method, of class User.
     */
    @Test
    public void testSetWeight3() {
        System.out.println("setWeight");
        int weight = 55;
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        instance.setWeight(weight);
    }

    /**
     * Test of getCyclingAvgSpeed method, of class User.
     */
    @Test
    public void testGetCyclingAvgSpeed() {
        System.out.println("getCyclingAvgSpeed");
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        double expResult = 10.0;
        double result = instance.getCyclingAvgSpeed();
        assertEquals(expResult, result, 3);
    }

    /**
     * Test of getCyclingAvgSpeed method, of class User.
     */
    @Test
    public void testGetCyclingAvgSpeed2() {
        System.out.println("getCyclingAvgSpeed");
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 20, 123456789, 10);
        double expResult = 20.0;
        double result = instance.getCyclingAvgSpeed();
        assertEquals(expResult, result, 3);
    }

    /**
     * Test of getCyclingAvgSpeed method, of class User.
     */
    @Test
    public void testGetCyclingAvgSpeed3() {
        System.out.println("getCyclingAvgSpeed");
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 15, 123456789, 10);
        double expResult = 15.0;
        double result = instance.getCyclingAvgSpeed();
        assertEquals(expResult, result, 3);
    }

    /**
     * Test of setCyclingAvgSpeed method, of class User.
     */
    @Test
    public void testSetCyclingAvgSpeed() {
        System.out.println("setCyclingAvgSpeed");
        double cyclingAvgSpeed = 20.0;
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        instance.setCyclingAvgSpeed(cyclingAvgSpeed);
    }

    /**
     * Test of setCyclingAvgSpeed method, of class User.
     */
    @Test
    public void testSetCyclingAvgSpeed2() {
        System.out.println("setCyclingAvgSpeed");
        double cyclingAvgSpeed = 25.0;
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        instance.setCyclingAvgSpeed(cyclingAvgSpeed);
    }

    /**
     * Test of setCyclingAvgSpeed method, of class User.
     */
    @Test
    public void testSetCyclingAvgSpeed3() {
        System.out.println("setCyclingAvgSpeed");
        double cyclingAvgSpeed = 26.0;
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        instance.setCyclingAvgSpeed(cyclingAvgSpeed);
    }

    /**
     * Test of getVisaCardNumber method, of class User.
     */
    @Test
    public void testGetVisaCardNumber() {
        System.out.println("getVisaCardNumber");
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456789, 10);
        double expResult = 123456789;
        double result = instance.getVisaCardNumber();
        assertEquals(expResult, result, 3);
    }

    /**
     * Test of getVisaCardNumber method, of class User.
     */
    @Test
    public void testGetVisaCardNumber2() {
        System.out.println("getVisaCardNumber");
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456780, 10);
        double expResult = 123456780;
        double result = instance.getVisaCardNumber();
        assertEquals(expResult, result, 3);
    }

    /**
     * Test of getVisaCardNumber method, of class User.
     */
    @Test
    public void testGetVisaCardNumber3() {
        System.out.println("getVisaCardNumber");
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456787, 10);
        double expResult = 123456787;
        double result = instance.getVisaCardNumber();
        assertEquals(expResult, result, 3);
    }

    /**
     * Test of setVisaCardNumber method, of class User.
     */
    @Test
    public void testSetVisaCardNumber() {
        System.out.println("setVisaCardNumber");
        double visaCardNumber = 123456780;
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456787, 10);
        instance.setVisaCardNumber(visaCardNumber);
    }

    /**
     * Test of setVisaCardNumber method, of class User.
     */
    @Test
    public void testSetVisaCardNumber2() {
        System.out.println("setVisaCardNumber");
        double visaCardNumber = 123456789;
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456787, 10);
        instance.setVisaCardNumber(visaCardNumber);
    }

    /**
     * Test of setVisaCardNumber method, of class User.
     */
    @Test
    public void testSetVisaCardNumber3() {
        System.out.println("setVisaCardNumber");
        double visaCardNumber = 123456788;
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456787, 10);
        instance.setVisaCardNumber(visaCardNumber);
    }
    
    @Test
    public void testGetPoints(){
        System.out.println("getPoints");
        int points = 20;
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456787, 20);
        int expResult = points;
        int result = instance.getPoints();
        assertEquals(expResult, result);
        
    }
     @Test
    public void testGetPoints2(){
        System.out.println("getPoints");
        int points = 23;
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456787, 23);
        int expResult = points;
        int result = instance.getPoints();
        assertEquals(expResult, result);
        
    }
     @Test
    public void testGetPoints3(){
        System.out.println("getPoints");
        int points = 0;
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456787, 0);
        int expResult = points;
        int result = instance.getPoints();
        assertEquals(expResult, result);
        
    }
    @Test
    public void testSetPoints(){
        System.out.println("setPoints");
        int points = 40;
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456787, 10);
        instance.setPoints(points);
        
    }
    @Test
    public void testSetPoints2(){
        System.out.println("setPoints");
        int points = 0;
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456787, 10);
        instance.setPoints(points);
        
    }
    
    @Test
    public void testSetPoints3(){
        System.out.println("setPoints");
        int points = 100;
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456787, 10);
        instance.setPoints(points);
        
    }
    /**
     * Test of getGender method, of class User.
     */
    @Test
    public void testGetGender() {
        System.out.println("getGender");
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456787, 10);
        char expResult = 'M';
        char result = instance.getGender();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGender method, of class User.
     */
    @Test
    public void testGetGender2() {
        System.out.println("getGender");
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'F', 10, 123456787, 10);
        char expResult = 'F';
        char result = instance.getGender();
        assertEquals(expResult, result);
    }

    /**
     * Test of setGender method, of class User.
     */
    @Test
    public void testSetGender() {
        System.out.println("setGender");
        char gender = 'm';
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'F', 10, 123456787, 10);
        instance.setGender(gender);
    }

    /**
     * Test of setGender method, of class User.
     */
    @Test
    public void testSetGender2() {
        System.out.println("setGender");
        char gender = 'f';
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456787, 10);
        instance.setGender(gender);
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        User instance = new User("José", "a@gmail.com", "abc", 150, 70, 'M', 10, 123456787, 10);
        String expResult = "abc";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword2() {
        System.out.println("getPassword");
        User instance = new User("José", "a@gmail.com", "123", 150, 70, 'M', 10, 123456787, 10);
        String expResult = "123";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword3() {
        System.out.println("getPassword");
        User instance = new User("José", "a@gmail.com", "12", 150, 70, 'M', 10, 123456787, 10);
        String expResult = "12";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "21";
        User instance = new User("José", "a@gmail.com", "21", 150, 70, 'M', 10, 123456787, 10);
        instance.setPassword(password);
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword2() {
        System.out.println("setPassword");
        String password = "22";
        User instance = new User("José", "a@gmail.com", "21", 150, 70, 'M', 10, 123456787, 10);
        instance.setPassword(password);
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword3() {
        System.out.println("setPassword");
        String password = "23";
        User instance = new User("José", "a@gmail.com", "21", 150, 70, 'M', 10, 123456787, 10);
        instance.setPassword(password);
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        User instance = new User("Hugo", "a@gmail.com", "21", 150, 70, 'M', 10, 123456787, 10);
        String expResult = "Name: Hugo; Email: a@gmail.com";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        User instance = new User("Hugo", "a@gmail.com", "21", 150, 70, 'M', 10, 123456787, 10);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals");
        User instance = new User("Hugo", "a@gmail.com", "21", 150, 70, 'M', 10, 123456787, 10);
        Object obj = instance;
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEquals3() {
        System.out.println("equals");
        User instance = new User("Hugo", "a@gmail.com", "21", 150, 70, 'M', 10, 123456787, 10);
        Object obj = new Park("1", 23.3, -10.2, 5, "Trindade", 50, 20, 10.5, 14.5);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEquals4() {
        System.out.println("equals");
        User instance = new User("Hugo", "a@gmail.com", "21", 150, 70, 'M', 10, 123456787, 10);
        User obj = new User("Hugo2", "b@gmail.com", "21", 150, 70, 'M', 10, 123456787, 10);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    @Test
    void testEquals5() {
        User p = new User("Hugo", "a@gmail.com", "21", 150, 70, 'M', 10, 123456787, 10);
        assertEquals(p, p);
        assertEquals(p.hashCode(), p.hashCode());
    }

    @Test
    void testEquals6() {
        User p1 = new User("Hugo", "a@gmail.com", "21", 150, 70, 'M', 10, 123456787, 10);
        User p2 = null;
        assertNotEquals(p1, p2);
        assertNotNull(p1.hashCode());
    }

    @Test
    void testEquals7() {
        User p1 = new User("Hugo", "a@gmail.com", "21", 150, 70, 'M', 10, 123456787, 10);
        Poi p2 = new Poi();
        assertNotEquals(p1, p2);
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }

}
