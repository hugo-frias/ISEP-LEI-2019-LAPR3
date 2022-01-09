package lapr.project.controller;

import java.sql.SQLException;
import java.util.List;

import lapr.project.data.BicycleDB;
import lapr.project.model.Bicycle;

public class BicycleController {

    private final BicycleDB bDB;

    public BicycleController() {
        bDB = new BicycleDB();
    }

    public BicycleController(BicycleDB bdb) {
        this.bDB = bdb;
    }

    public boolean addBicycle(List<Bicycle> b) throws SQLException {
        return bDB.addBicycle(b);
    }

    public boolean removeBicycle(Bicycle b) throws SQLException {
        return bDB.removeBicycle(b);
    }

    public Bicycle getBicycle(String bicycleId) throws SQLException {
        Bicycle b = bDB.getBicycle(bicycleId);
        if (b != null) {
            return b;
        } else throw new RuntimeException("null bicycle");
    }

}
