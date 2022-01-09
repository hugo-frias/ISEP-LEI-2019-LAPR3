package lapr.project.controller;

import lapr.project.data.UserDB;
import lapr.project.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserController {

    private UserDB udb;

    public UserController() {
        this.udb = new UserDB();
    }

    public UserController(UserDB mock) {
        this.udb = mock;
    }

    public User getUser(String email) throws SQLException {
        return udb.getUser(email);
    }

    public boolean addUser(User u) throws SQLException {
        return udb.addUser(u);
    }

    public boolean addUser(List<User> uList) throws SQLException {
        return udb.addUser(uList);
    }

    public boolean removeUser(User u) throws SQLException {
        if (u == null) {
            return false;
        }
        return udb.removeUser(u.getEmail());
    }

    public boolean updateUser(String email, User u) {
        if (u == null) {
            return false;
        }
        return udb.updateUser(email, u);
    }

    public boolean handleBatch(List<User> l, String action) {
        if (l.isEmpty()) {
            return false;
        }
        return udb.handleBatch(l, action);
    }

    public int getInvoiceCount() throws SQLException {
        return udb.getInvoiceCount();
    }

    public long getCurrentDebt(String string) throws SQLException {
        return udb.getCurrentDebt(string);
    }

    public User getUserByName(String s1) throws SQLException {
        return udb.getUserByName(s1);
    }

    public int getCurrentPoints(String username) throws SQLException {
        return udb.getCurrentPoints(username);
    }

    public int getPointsForMonth(int monthAux, String username) throws SQLException {
        return udb.getPointsForMonth(monthAux, username);
    }

    public double getEnergyWithBicycle(String username, double distance) {
        return udb.getEnergyWithBicycle(username, distance);
    }

}
