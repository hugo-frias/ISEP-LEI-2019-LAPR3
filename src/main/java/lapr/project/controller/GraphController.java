package lapr.project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import lapr.project.model.Park;
import lapr.project.model.Path;
import lapr.project.model.Place;
import lapr.project.utils.Graph;
import lapr.project.utils.GraphAlgorithms;

public class GraphController {

    private final Graph g;

    public GraphController() {
        g = new Graph(false);
    }

    public Graph getG() {
        return g.clone();
    }

    public void fillGraph(List<Place> places, List<Path> paths) {
        GraphAlgorithms.fillGraph(g, places, paths);
    }

    public List<Park> getNearestParks(Place place, double radius) {
        return GraphAlgorithms.getNearestParks(g, place, radius);
    }

    public int getShortestPathDistance(Place c1, Place c2, LinkedList<Place> shortRoute) {
        return (int) GraphAlgorithms.shortestRoute(g, c1, c2, shortRoute);
    }

    public int getShortestPathPassingThroughtPlacesDistance(Place orig, Place dest, List<Place> mandatoryPlaces, List<Place> shortRoute) {
        return (int) GraphAlgorithms.shortestRoutePassingThroughtPlaces(g, orig, dest, mandatoryPlaces, shortRoute);
    }
    
    public void allPaths(Place vOrig, Place vDest, LinkedList<Place> path, List<LinkedList<Place>> paths, ArrayList<Place> vToVisit) {
        GraphAlgorithms.allPaths(g, vOrig, vDest, path, paths, vToVisit);
    }

    public int writePathsFile(int maxNumberOfSuggestions, List<LinkedList<Place>> paths, String outputFileName, int elevation) throws IOException {
        return GraphAlgorithms.writePathsFile(maxNumberOfSuggestions, paths, outputFileName, elevation);
    }

    public boolean sortPaths(String sortingCriteria, boolean ascendingOrder, List<LinkedList<Place>> paths) {
        return GraphAlgorithms.sortPaths(sortingCriteria, ascendingOrder, paths);
    }

    public List<Place> getInputPOIs(String inputPOIs) {
        return GraphAlgorithms.getInputPOIS(inputPOIs);
    }

}
