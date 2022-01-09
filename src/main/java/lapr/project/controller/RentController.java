package lapr.project.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import lapr.project.data.RentDB;
import lapr.project.model.Place;
import lapr.project.model.Rent;

public class RentController {

    private final RentDB rDB;

    public RentController() {
        rDB = new RentDB();
    }

    public RentController(RentDB rdb) {
        this.rDB = rdb;
    }

    public int getNumberOfRents() throws SQLException {
        return rDB.getNumberOfRents();
    }

    public long addRent(Rent rent) throws SQLException {
        return rDB.addRent(rent);
    }

    public boolean addRent(String idAux, String s, String s1) throws SQLException {
        return rDB.addRent(idAux, s, s1);
    }

    public Place getParkByVehicle(String bikeDisc) throws SQLException {
        return rDB.getParkByVehicle(bikeDisc);
    }

    public boolean lockVehicle(String bikeDisc, String username, String id, double distance) throws SQLException {
        return rDB.lockVehicle(bikeDisc, username, id, distance);
    }

    public Place getParkByRent(String username) throws SQLException {
        return rDB.getParkByRent(username);
    }

    public long getRentUpdateMilisseconds(String rentId) throws SQLException {
        return rDB.getRentUpdateMilisseconds(rentId);
    }

    public String getRentByUsername(String username) throws SQLException {
        return rDB.getRentByUsername(username);
    }

    public Date getDateByRentID(String rentId) throws SQLException {
        return rDB.getDateByRentId(rentId);
    }

    public long getTimestampInMiliseconds(Timestamp endDate) throws SQLException {
        return rDB.getTimestampInMiliseconds(endDate);
    }

    public long getRentMilisseconds(String idAux) throws SQLException {
        return rDB.getRentMilisseconds(idAux);
    }

    public long forHowLongAVehicleIsUnlocked(String vehicleID) throws SQLException {
        return rDB.forHowLongAVehicleIsUnlocked(vehicleID);
    }

    public ArrayList<String> getAllRentsByUsername(String username) throws SQLException {
        return rDB.getAllRentsByUsername(username);
    }

    public boolean addRentB(String id, String s, String s1) throws SQLException {
        return rDB.addRentB(id, s, s1);
    }

    public boolean addRentE(String id, String s, String s1) throws SQLException {
        return rDB.addRentR(id, s, s1);
    }

    public boolean lockVehicleE(String bikeDisc, String username, String id, double distance) throws SQLException {
        return rDB.lockVehicleE(bikeDisc, username, id, distance);
    }

    public boolean lockVehicleB(String bikeDisc, String username, String id, double distance) throws SQLException {
        return rDB.lockVehicleB(bikeDisc, username, id, distance);

    }

    public double getCost(String username) throws SQLException {
        return rDB.getCost(username);
    }

    public int getTotalPoints(String username) throws SQLException {
        return rDB.getTotalPoints(username);
    }

    public ArrayList<String> getAllRentsAndPointsByUsername(String username) throws SQLException {
        return rDB.getAllRentsAndPointsByUsername(username);
    }

}
