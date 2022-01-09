package lapr.project.model;

import java.sql.SQLException;
import lapr.project.data.PoiDB;

public class Poi extends Place {

    public Poi() {

    }

    /**
     * Full POI constructor
     *
     * @param latitude
     * @param longitude
     * @param elevation
     * @param poiDescription
     */
    public Poi(String id, double latitude, double longitude, int elevation, String poiDescription) {
        super(id, latitude, longitude, elevation, poiDescription);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
