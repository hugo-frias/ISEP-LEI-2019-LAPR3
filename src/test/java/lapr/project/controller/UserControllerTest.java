package lapr.project.controller;

import lapr.project.data.UserDB;
import lapr.project.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserControllerTest {

    private static UserController uc;

    @BeforeAll
    public static void setUpClass() throws SQLException {
        UserDB udb = mock(UserDB.class);
        User u = new User("user", "mail", "pass", 1, 1, 'M', 1, 1, 1);
        User u2 = new User("user1", "mails", "passs", 12, 12, 'M', 13, 14, 51);
        List<User> list = new ArrayList<>();
        when(udb.addUser(any(User.class))).thenReturn(true);
        when(udb.removeUser("mail")).thenReturn(true);
        when(udb.removeUser("mail2")).thenReturn(false);
        when(udb.removeUser(null)).thenReturn(false);
        when(udb.getUser("mail")).thenReturn(u);
        when(udb.getUser("mail2")).thenReturn(null);
        when(udb.updateUser(any(String.class), any(User.class))).thenReturn(true);
        when(udb.handleBatch(any(List.class), any(String.class))).thenReturn(true);
        when(udb.addUser(list)).thenReturn(true);
        when(udb.getInvoiceCount()).thenReturn(2);
        when(udb.getCurrentDebt("user")).thenReturn(20L);
        when(udb.getUserByName("user")).thenReturn(new User("user", "mail", "pass", 1, 1, 'M', 1, 1, 1));
        when(udb.getCurrentPoints(any(String.class))).thenReturn(0);
        when(udb.getPointsForMonth(any(Integer.class), any(String.class))).thenReturn(0);
        when(udb.getEnergyWithBicycle("carlos", 0)).thenReturn((double) 0);
        uc = new UserController(udb);
    }

    @Test
    void testClass() {
        UserController uc = new UserController();
        assertNotNull(uc);
    }

    @Test
    void getUser() throws SQLException {
        User expected = new User("user", "mail", "pass", 1, 1, 'M', 1, 1, 1);
        User actual = uc.getUser("mail");
        assertEquals(expected, actual);
    }

    @Test
    void getUser2() throws SQLException {
        User expected = null;
        User actual = uc.getUser("mail2");
        assertEquals(expected, actual);
    }

    @Test
    void addUser() throws SQLException {
        User u = new User("user", "mail", "pass", 1, 1, 'M', 1, 1, 1);
        boolean actual = uc.addUser(u);
        assertTrue(actual);
    }

    @Test
    void addUser2() throws SQLException {
        User u = new User("user", "mail", "pass", 1, 1, 'M', 1, 1, 1);
        User u2 = new User("user1", "mails", "passs", 12, 12, 'M', 13, 14, 51);
        List<User> list = new ArrayList<>();
        list.add(u);
        list.add(u2);
        boolean aux = uc.addUser(list);
        assertFalse(aux);
    }

    @Test
    void getInvoiceCount() throws SQLException {
        int result = uc.getInvoiceCount();
        int exp = 2;
        assertEquals(result, exp);
    }

    @Test
    void getCurrentDebt() throws SQLException {
        User u = new User("user", "mail", "pass", 1, 1, 'M', 1, 1, 1);
        long result = uc.getCurrentDebt(u.getUsername());
        long exp = 20;
        assertEquals(result, exp);
    }

    @Test
    void getUserByName() throws SQLException {
        User u = new User("user", "mail", "pass", 1, 1, 'M', 1, 1, 1);
        User result = uc.getUserByName(u.getUsername());
        assertEquals(u, result);
    }

    @Test
    void removeUser() throws SQLException {
        User u = new User("user", "mail", "pass", 1, 1, 'M', 1, 1, 1);
        boolean actual = uc.removeUser(u);
        assertTrue(actual);
    }

    @Test
    void removeUser2() throws SQLException {
        boolean actual = uc.removeUser(null);
        assertFalse(actual);
    }

    @Test
    void removeUser3() throws SQLException {
        User u2 = new User("user22", "mail2", "pass", 1, 1, 'M', 1, 1, 1);
        boolean actual = uc.removeUser(u2);
        assertEquals(actual, false);
    }

    @Test
    void updateUser() {
        User u = new User("user2", "mail2", "pass2", 2, 2, 'F', 2, 2, 2);
        boolean actual = uc.updateUser("mail", u);
        assertTrue(actual);
    }

    @Test
    void updateUser2() {
        boolean actual = uc.updateUser("mail", null);
        assertFalse(actual);
    }

    @Test
    void handleBatch() {
        List<User> l = new ArrayList<>();
        User u = new User("user", "mail", "pass", 1, 1, 'M', 1, 1, 1);
        User u2 = new User("user2", "mail2", "pass2", 2, 2, 'F', 2, 2, 2);
        l.add(u);
        l.add(u2);

        boolean actual = uc.handleBatch(l, "add");
        assertTrue(actual);

        actual = uc.handleBatch(l, "remove");
        assertTrue(actual);
    }

    @Test
    void handleBatch2() {
        List<User> l = new ArrayList<>();

        boolean actual = uc.handleBatch(l, "add");
        assertFalse(actual);

        actual = uc.handleBatch(l, "remove");
        assertFalse(actual);
    }

    @Test
    void testGetPoints() throws SQLException {
        assertEquals(0, uc.getCurrentPoints("a"));
        assertEquals(0, uc.getPointsForMonth(0, "a"));
    }

    @Test
    void testGetEnergyWithBicycle() {
        assertEquals(0, uc.getEnergyWithBicycle("carlos", 0));
    }

    @Test
    void testGetEnergyWithBicycle1() {
        assertNotNull(uc.getEnergyWithBicycle("carlos", 0));
    }

    @Test
    void testGetEnergyWithBicycle2() {
        assertNotEquals(-1, uc.getEnergyWithBicycle("carlos", 0));
    }
}
