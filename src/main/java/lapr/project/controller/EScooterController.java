package lapr.project.controller;

import lapr.project.data.EScooterDB;
import lapr.project.model.EScooter;
import lapr.project.model.Park;
import lapr.project.utils.Distances;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Hugo
 */
public class EScooterController {

    private final EScooterDB esDB;

    public EScooterController(EScooterDB esdb) {
        esDB = esdb;
    }

    public EScooterController() {
        esDB = new EScooterDB();
    }

    public boolean addEScooter(List<EScooter> es) throws SQLException {
        return esDB.addEScooter(es);
    }

    public boolean removeEScooter(EScooter es) throws SQLException {
        return esDB.removeEScooter(es);
    }

    public EScooter getEScooter(String s) throws SQLException {
        return esDB.getEScooter(s);
    }

    public int suggestEscootersToGoFromOneParkToAnother(Park actual, Park destination, String username, String output) throws SQLException, IOException {
        double energy = Distances.calculateCost(actual, destination, 250);
        return esDB.getEscooterWithEnergy(energy, output);
    }

    public List<EScooter> getEScooterForEnergy(String id, double energyCost) throws SQLException {
        return esDB.getEScooterForEnergy(id, energyCost);
    }

    public EScooter getHighestBatteryScooter(String string) throws SQLException {
        return esDB.getHighestBatteryScooter(string);
    }

    public List<EScooter> getAllEScooters() {
        return esDB.getAllEScooters();
    }

    public double getEnergyWithEScooters(List<EScooter> escooters, double distance) {
        return esDB.getMinEnergyWithEScooters(escooters, distance);
    }

}
