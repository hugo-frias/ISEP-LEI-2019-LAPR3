package lapr.project.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import lapr.project.model.Place;

public class mostEnergyEfficientComparator implements Comparator<LinkedList<Place>> {

    

    @Override
    public int compare(LinkedList<Place> o1, LinkedList<Place> o2) {
        if (Distances.calculateCostOfAPath(o1, 250) > Distances.calculateCostOfAPath(o2, 250)) {
            return 1;
        }
        if (Distances.calculateCostOfAPath(o1, 250) < Distances.calculateCostOfAPath(o2, 250)) {
            return -1;
        }
        return 0;
    }

}
