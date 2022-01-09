package lapr.project.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import lapr.project.model.Place;

public class shortestPathComparator implements Comparator<LinkedList<Place>> {

    

    @Override
    public int compare(LinkedList<Place> o1, LinkedList<Place> o2) {
        if (Distances.getFullPathDistance(o1) > Distances.getFullPathDistance(o2)) {
            return 1;
        }
        if (Distances.getFullPathDistance(o1) < Distances.getFullPathDistance(o2)) {
            return -1;
        }
        return 0;
    }

}

