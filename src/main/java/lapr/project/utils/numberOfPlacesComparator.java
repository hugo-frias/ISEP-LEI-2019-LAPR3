package lapr.project.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import lapr.project.model.Place;

public class numberOfPlacesComparator implements Comparator<LinkedList<Place>> {

    

    @Override
    public int compare(LinkedList<Place> o1, LinkedList<Place> o2) {
        if (o1.size() > o2.size()) {
            return 1;
        }
        if (o1.size() < o2.size()) {
            return -1;
        }
        return 0;
    }

}
