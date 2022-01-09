package lapr.project.utils;

import java.util.ArrayList;
import java.util.LinkedList;

import lapr.project.model.Park;
import lapr.project.model.Place;

public class Distances {

    public Distances() {
    }

    /**
     * @param lat1      latitude location 1.
     * @param lon1      longitude locatin 1.
     * @param lat2      latitude location 2.
     * @param lon2      longitude location 2.
     * @param elevation elevation of the path.
     * @return the distance in kilometers between two coordinates.
     * @copyright https://www.geodatasource.com/developers/java.
     */
    public static double distance(double lat1, double lon1, double lat2, double lon2, double elevation) {

        elevation = Math.abs(elevation);

        if ((lat1 == lat2) && (lon1 == lon2)) return 0;

        double theta = lon1 - lon2;
        double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
        dist = Math.acos(dist);
        dist = Math.toDegrees(dist);

        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;

        if (elevation != 0) {
            elevation = elevation / 1000;
            dist = Math.sqrt((dist * dist) + (elevation * elevation));
        }
        return dist;

    }

    /**
     * Auxiliar method to calculate the energy cost (in watts) to travel from park A to park B).
     *
     * @param A park where the user is.
     * @param B park where the user wants to go.
     * @return the cost in watts.
     */
    public static double calculateCost(Place A, Place B, int motor) {
        double latCP = A.getLatitude();
        double lonCP = A.getLongitude();
        double latDP = B.getLatitude();
        double lonDP = B.getLongitude();
        double elevation = B.getElevation() - A.getElevation();
        double dbp = Distances.distance(latCP, lonCP, latDP, lonDP, elevation); //distance between parks

        dbp = dbp * 0.7; //only valid for 70% of the travel distance

        double vm = 15; //15kmh medium velocity
        double pm = motor; //e-scooter motor

        double t = dbp / vm; //time to travel between parks at the medium velocity
        double c = t * pm; //energy needed to travel from park a to b

        return c * 1.1; //cost in battery + 10% needed
    }

    public static double calculateCostOfAPath(LinkedList<Place> l, int motor) {
        double cost = 0;
        for (int i = 0; i < l.size(); i++) {
            for (int j = 1; j < l.size(); j++) {
                cost += calculateCost(l.get(i), l.get(j), motor);
            }
        }
        return cost;
    }

    public static double getFullPathDistance(LinkedList<Place> l) {
        double dist = 0;
        for (int i = 0; i < l.size(); i++) {
            for (int j = 1; j < l.size(); j++) {
                dist += Distances.distance(l.get(i).getLatitude(), l.get(i).getLongitude(),
                        l.get(j).getLatitude(), l.get(j).getLongitude(), (l.get(j).getElevation() - l.get(i).getElevation()));
            }
        }

        return dist;
    }


}
