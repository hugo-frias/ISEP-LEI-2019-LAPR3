package lapr.project.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import lapr.project.model.Park;
import lapr.project.model.Path;
import lapr.project.model.Place;
import lapr.project.model.Poi;

public class GraphAlgorithms {

    public GraphAlgorithms() {
        //Empty constructor to hide the implicit one
    }

    public static void fillGraph(Graph<Place, Path> g, List<Place> places, List<Path> paths) {
        if (places != null) {
            addPlacesToGraph(g, places);
        }
        if (paths != null) {
            addPathsToGraph(g, paths, places);
        }
    }

    /**
     * Adds park instances to a graph
     */
    private static void addPlacesToGraph(Graph<Place, Path> g, List<Place> places) {
        for (Place place : places) {
            g.insertVertex(place);
        }
    }

    /**
     * Adds path instances to a graph
     *
     * @param paths
     */
    private static void addPathsToGraph(Graph<Place, Path> g, List<Path> paths, List<Place> places) {
        Place p1 = null;
        Place p2 = null;
        for (Path path : paths) {
            for (Place place : places) {
                if (path.getLatitudeA() == place.getLatitude() && path.getLongitudeA() == place.getLongitude()) {
                    p1 = place;
                }
                if (path.getLatitudeB() == place.getLatitude() && path.getLongitudeB() == place.getLongitude()) {
                    p2 = place;
                }
            }
            if (p1 != null && p2 != null) {
                g.insertEdge(p1, p2, path, Distances.distance(p1.getLatitude(), p1.getLongitude(), p2.getLatitude(), p2.getLongitude(), (double) p2.getElevation() - (double) p1.getElevation()));
            }
        }
    }

    public static List<Park> getNearestParks(Graph<Place, Path> g, Place place, double radius) {
        if (place == null || g.numVertices() == 0) {
            return new ArrayList<>();
        }
        ArrayList<Park> nearestParks = new ArrayList<>();
        boolean[] temp = new boolean[g.numVertices()];
        if (place instanceof Park) {
            nearestParks.add((Park) place);
        }
        if (radius > 0) {
            getNearestParks(g, place, place, radius, nearestParks, temp);
        }
        return nearestParks;
    }

    private static void getNearestParks(Graph<Place, Path> g, Place orig, Place place, double radius, ArrayList<Park> nearestParks, boolean temp[]) {
        ArrayList<Place> adj = new ArrayList<>();
        Iterable<Place> p = g.adjVertices(place);
        for (Place p1 : p) {
            adj.add(p1);
        }
        for (Place place1 : adj) {
            if (!temp[g.getKey(place)]) {
                if (Distances.distance(orig.getLatitude(), orig.getLongitude(), place1.getLatitude(), place1.getLongitude(), 0) <= radius) {
                    temp[g.getKey(place1)] = true;
                    if (place1 instanceof Park) {
                        nearestParks.add((Park) place1);
                    }
                    getNearestParks(g, orig, place1, radius, nearestParks, temp);
                }
            }
        }
    }

    public static double shortestRoute(Graph<Place, Path> g, Place orig, Place dest, LinkedList<Place> shortRoute) {
        if (orig == null || dest == null) {
            return 0;
        }
        if (orig.equals(dest)) {
            shortRoute.add(orig);
            return 0;
        }
        if ((!g.validVertex(orig)) || (!g.validVertex(dest))) {
            return 0;
        }
        int nVerts = g.numVertices();
        boolean[] visited = new boolean[nVerts];
        int[] pathKeys = new int[nVerts];
        double[] dist = new double[nVerts];
        Place[] vertices = g.allkeyVerts();
        for (int i = 0; i < nVerts; i++) {
            dist[i] = Double.MAX_VALUE;
            pathKeys[i] = -1;
        }
        shortestRouteLength(g, orig, vertices, visited, pathKeys, dist);

        Place vOrig = orig;
        Place vDest = dest;

        double lengthPath = dist[g.getKey(vDest)];

        if (lengthPath != Double.MAX_VALUE) {
            getRoute(g, vOrig, vDest, vertices, pathKeys, shortRoute);
            return lengthPath;
        }

        return 0;
    }

    private static void shortestRouteLength(Graph<Place, Path> g, Place VOrig, Place[] vertices, boolean[] visited, int[] pathKeys, double[] dist) {
        Place count = VOrig;
        int key = g.getKey(count);
        dist[key] = 0;
        while (key != -1) {
            count = vertices[key];
            visited[key] = true;
            for (Place c1 : g.adjVertices(count)) {
                int adjKey = g.getKey(c1);
                if (!visited[adjKey] && dist[adjKey] > dist[key] + g.getEdge(count, c1).getWeight()) {
                    dist[adjKey] = dist[key] + g.getEdge(count, c1).getWeight();
                    pathKeys[adjKey] = key;
                }
            }
            key = getVertMinDist(dist, visited);
        }
    }

    private static int getVertMinDist(double[] dist, boolean[] visited) {
        double min = Double.MAX_VALUE;
        int vert = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                vert = i;
            }
        }
        return vert;
    }

    private static void getRoute(Graph<Place, Path> g, Place vOrig, Place vDest, Place[] vertices, int[] routeKeys, LinkedList<Place> shortRoute) {
        if (!vOrig.equals(vDest)) {
            shortRoute.push(vDest);
            int vKey = g.getKey(vDest);
            int prevVKey = routeKeys[vKey];
            vDest = vertices[prevVKey];
            getRoute(g, vOrig, vDest, vertices, routeKeys, shortRoute);
        } else {
            shortRoute.push(vOrig);
        }
    }

    public static AdjacencyMatrixGraph transitiveClosure(AdjacencyMatrixGraph graph) {
        double distance;
        AdjacencyMatrixGraph newGraph = graph;
        for (int k = 0; k < graph.numVertices; k++) {
            for (int i = 0; i < graph.numVertices; i++) {
                if (graph.getEdge(graph.vertices.get(i), graph.vertices.get(k)) != null && i != k) {
                    for (int j = 0; j < graph.numVertices; j++) {
                        if (graph.getEdge(graph.vertices.get(k), graph.vertices.get(j)) != null && i != j && k != j) {
                            distance = (double) graph.getEdge(graph.vertices.get(k), graph.vertices.get(j)) + (double) graph.getEdge(graph.vertices.get(i), graph.vertices.get(k));
                            if (newGraph.getEdge(graph.vertices.get(i), graph.vertices.get(j)) == null) {
                                newGraph.insertEdge(graph.vertices.get(i), graph.vertices.get(j), distance);
                            } else if (distance < (double) newGraph.getEdge(graph.vertices.get(i), graph.vertices.get(j))) {
                                newGraph.edgeMatrix[i][j] = distance;
                            }
                        }
                    }
                }
            }
        }
        return newGraph;
    }

    public static List<Place> getInputPOIS(String inputPOIs) {
        if (inputPOIs == null) return new ArrayList<>();
        List<String> list = Utils.loadCsv(inputPOIs);
        ArrayList<Place> inputPois = new ArrayList<>();
        int count = 0;
        try {
            if (list != null) {
                for (String b : list) {
                    if (!b.contains("#")) {
                        if (count != 0) {
                            String[] aux = b.split(";");
                            double latitude = Double.parseDouble(aux[0]);
                            double longitude = Double.parseDouble(aux[1]);
                            int elevation = Integer.parseInt(aux[2]);
                            String description = aux[3];
                            Poi poi = new Poi("", latitude, longitude, elevation, description);
                            inputPois.add(poi);
                        }
                        count++;
                    }
                }
            }
        } catch (Exception e) {
            return null;
        }
        return inputPois;
    }

    private static AdjacencyMatrixGraph fillAdjacencyMatrixGraph(Graph g) {
        AdjacencyMatrixGraph adG = new AdjacencyMatrixGraph(g.numVertices());
        Iterable<Place> vert = g.vertices();
        for (Place p1 : vert) {
            adG.insertVertex(p1);
        }
        for (Place p1 : vert) {
            for (Place p2 : vert) {
                if (g.getEdge(p1, p2) != null && !p1.equals(p2)) {
                    adG.insertEdge(p1, p2, g.getEdge(p1, p2).getWeight());
                }
            }
        }
        transitiveClosure(adG);
        return adG;
    }

    public static void allPaths(Graph<Place, Path> g, Place vOrig, Place vDest, LinkedList<Place> path, List<LinkedList<Place>> paths, ArrayList<Place> vToVisit) {
        if (vOrig == null || vDest == null || path == null || paths == null || vToVisit == null) {
            return;
        }

        for (Place vAdj : g.adjVertices(vOrig)) {
            if (vAdj.equals(vDest)) {
                if (path.containsAll(vToVisit)) {
                    LinkedList<Place> temp = new LinkedList<>();
                    for (Place aux : path) {
                        temp.addFirst(aux);
                    }
                    temp.add(vDest);
                    paths.add(temp);

                }

            } else if (!path.contains(vAdj)) {
                path.push(vAdj);
                allPaths(g, vAdj, vDest, path, paths, vToVisit);
                path.pop();

            }

        }
    }

    public static int writePathsFile(int maxNumberOfSuggestions, List<LinkedList<Place>> paths, String outputFileName, int elevation) throws IOException {
        if (paths.isEmpty()) {
            return 0;
        }
        if (maxNumberOfSuggestions > paths.size()) {
            maxNumberOfSuggestions = paths.size();
        }
        FileWriter writer1 = new FileWriter(outputFileName);
        BufferedWriter writer = new BufferedWriter(writer1);
        for (int i = 0; i < maxNumberOfSuggestions; i++) {
            writer.write("Path " + i + 1);
            writer.newLine();
            writer.write("total_distance: " + Distances.getFullPathDistance(paths.get(i)));
            writer.newLine();
            writer.write("total energy: " + Distances.calculateCostOfAPath(paths.get(i), 250));
            writer.newLine();
            writer.write("elevation: " + elevation);
            writer.newLine();
            for (int j = 0; j < paths.get(i).size(); j++) {
                writer.write(paths.get(i).get(j).getLatitude() + ";" + paths.get(i).get(j).getLongitude());
                writer.newLine();
            }
            writer.newLine();
        }
        writer.close();
        writer1.close();
        return maxNumberOfSuggestions;
    }

    public static boolean sortPaths(String sortingCriteria, boolean ascendingOrder, List<LinkedList<Place>> paths) {
        if (sortingCriteria.equals("shortest_distance")) {
            shortestPathComparator c = new shortestPathComparator();
            if (!ascendingOrder) {
                Collections.sort(paths, c);

            } else {
                Collections.sort(paths, Collections.reverseOrder(c));
            }
        } else if (sortingCriteria.equals("energy")) {
            mostEnergyEfficientComparator c = new mostEnergyEfficientComparator();
            if (ascendingOrder) {
                Collections.sort(paths, c);

            } else {
                Collections.sort(paths, Collections.reverseOrder(c));
            }
        } else if (sortingCriteria.equals("number_of_points")) {
            numberOfPlacesComparator c = new numberOfPlacesComparator();
            if (ascendingOrder) {
                Collections.sort(paths, c);

            } else {
                Collections.sort(paths, Collections.reverseOrder(c));
            }
        } else {
            return true;
        }
        return false;
    }

    public static double shortestRoutePassingThroughtPlaces(Graph<Place, Path> g, Place orig, Place dest, List<Place> mandatoryPlaces, List<Place> shortRoute) {
        LinkedList<Place> places = new LinkedList<>();
        if (shortestRoute(g, orig, dest, places) == 0) {
            return 0;
        }
        for (Place p : mandatoryPlaces) {
            if (shortestRoute(g, orig, p, places) == 0) {
                return 0;
            }
        }
        AdjacencyMatrixGraph adjG = fillAdjacencyMatrixGraph(g);
        ArrayList<Place> route = new ArrayList<>();
        route.add(orig);
        for (Place p1 : mandatoryPlaces) {
            route.add(p1);
        }
        route.add(dest);

        Place origPlace = orig;
        int numberMandatoryPlaces = mandatoryPlaces.size();
        Place nextOrigPlace = mandatoryPlaces.get(0);

        for (int i = 1; i < numberMandatoryPlaces; i++) {
            double shortestDistance = (double) adjG.getEdge(origPlace, route.get(i));
            for (int j = i; j < numberMandatoryPlaces; j++) {
                if ((double) adjG.getEdge(origPlace, route.get(j + 1)) < shortestDistance) {
                    shortestDistance = (double) adjG.getEdge(origPlace, route.get(j + 1));
                    nextOrigPlace = route.get(j + 1);
                }
            }
            if (origPlace != nextOrigPlace) {
                origPlace = nextOrigPlace;
                int indexPOrigem = route.indexOf(origPlace);
                route.set(indexPOrigem, route.get(i));
                route.set(i, origPlace);
            }
        }

        shortRoute.add(orig);
        double finalDistance = 0;
        for (int k = 0; k < route.size() - 1; k++) {
            LinkedList<Place> shortPathBetweenCountrys = new LinkedList<>();
            shortestRoute(g, route.get(k), route.get(k + 1), shortPathBetweenCountrys);
            finalDistance += (double) adjG.getEdge(route.get(k), route.get(k + 1));
            for (int z = 1; z < shortPathBetweenCountrys.size(); z++) {
                shortRoute.add(shortPathBetweenCountrys.get(z));
            }
        }
        return finalDistance;
    }
}
