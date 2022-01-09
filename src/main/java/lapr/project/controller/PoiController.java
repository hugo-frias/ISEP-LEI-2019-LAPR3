package lapr.project.controller;

import java.sql.SQLException;
import java.util.List;

import lapr.project.data.PoiDB;
import lapr.project.model.Poi;

public class PoiController {

    private final PoiDB poiDB;

    public PoiController() {
        poiDB = new PoiDB();
    }

    public PoiController(PoiDB poidb) {
        this.poiDB = poidb;
    }

    public boolean addPoi(List<Poi> pois) throws SQLException {
        return poiDB.addPoi(pois);
    }

    public Poi getPoiByCoordinates(double latitude, double longitude) throws SQLException {
        return poiDB.getPoi(latitude, longitude);
    }

    public int getNumberOfPois() throws SQLException {
        return poiDB.getNumberOfPois();

    }

    public List<Poi> getAllPois() {
        return poiDB.getAllPois();
    }
    
    

}
