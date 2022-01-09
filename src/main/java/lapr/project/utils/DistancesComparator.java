package lapr.project.utils;

import java.util.Comparator;
import lapr.project.model.Place;

public class DistancesComparator implements Comparator<Place> {

    private final double latitude;
    private final double longitude;
    private final double elevation;

    public DistancesComparator(double latitude, double longitude, double elevation) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
    }

    @Override
    public int compare(Place o1, Place o2) {
        if (Distances.distance(latitude, longitude, o1.getLatitude(), o1.getLongitude(), o1.getElevation() - elevation) > Distances.distance(latitude, longitude, o2.getLatitude(), o2.getLongitude(), o2.getElevation() - elevation)) {
            return 1;
        }
        if (Distances.distance(latitude, longitude, o1.getLatitude(), o1.getLongitude(), o1.getElevation() - elevation) < Distances.distance(latitude, longitude, o2.getLatitude(), o2.getLongitude(), o2.getElevation() - elevation)) {
            return -1;
        }
        return 0;
    }

}

