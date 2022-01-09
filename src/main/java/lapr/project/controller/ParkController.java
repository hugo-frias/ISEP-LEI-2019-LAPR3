package lapr.project.controller;

import lapr.project.data.ParkDB;
import lapr.project.model.Bicycle;
import lapr.project.model.EScooter;
import lapr.project.model.Park;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class ParkController {

    private final ParkDB parkDB;

    public ParkController() {
        parkDB = new ParkDB();
    }

    public ParkController(ParkDB udb) {
        this.parkDB = udb;
    }

    public List<Bicycle> getBicyclesByCords(double latitude, double longitude) throws SQLException {
        return parkDB.getBicyclesByParkCoords(latitude, longitude);

    }

    public List<Bicycle> getBicyclesByParkID(String parkID) throws SQLException {
        return parkDB.getBicyclesByParkID(parkID);
    }

    public List<EScooter> getEScootersByParkCoords(double latitude, double longitude) throws SQLException {
       return parkDB.getEScootersByParkCoords(latitude, longitude);
    }
    
     public List<EScooter> getEScootersByParkID(String parkID) throws SQLException {
       return parkDB.getEScootersByParkID(parkID);
    }
    
    public int hasFreeSlotsBicyclesByParkID(String parkID) throws SQLException {
        return parkDB.hasFreeSlotsBicyclesByParkID(parkID);
    }

    public int hasFreeSlotsEScootersByParkID(String parkID) throws SQLException {
        return parkDB.hasFreeSlotsEScootersByParkID(parkID);
    }

    public int hasFreeSlotsLoanedVehicle(String parkID, String userEmail) throws SQLException {
        return parkDB.hasFreeSlotsLoanedVehicle(parkID, userEmail);
    }
    
    public Park getPark(String parkId) throws SQLException {
        return parkDB.getPark(parkId);
    }

    public Park getParkByCoordinates(double latitude, double longitude) throws SQLException {
        return parkDB.getPark(latitude, longitude);
    }

    public boolean addPark(List<Park> p) throws SQLException {
        return parkDB.addPark(p);
    }

    public boolean removePark(Park p) throws SQLException {
        return parkDB.removePark(p);
    }

    public Map<EScooter, Double> getChargingEScootersByParkID(String parkID) throws SQLException {
        return parkDB.getChargingEScootersByParkID(parkID);
    }
    
    public List<Park> getAllParks() {
        return parkDB.getAllParks();
    }

}
