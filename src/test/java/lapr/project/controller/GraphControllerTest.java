package lapr.project.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import lapr.project.data.ParkDB;
import lapr.project.model.Park;
import lapr.project.model.Path;
import lapr.project.model.Place;
import lapr.project.utils.Distances;
import lapr.project.utils.Graph;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GraphControllerTest {

    private static GraphController instance;
    private static ParkController instanceR;

    public GraphControllerTest() {
    }

    @BeforeAll
    public static void setUpClass() throws SQLException {
        ParkDB pdb = mock(ParkDB.class);
        when(pdb.getPark("orig")).thenReturn(new Park("orig", 10, 10, 0, "São Bento", 70, 20, 10.5, 14.5));
        when(pdb.getPark("dest")).thenReturn(new Park("dest", 20, 10, 0, "Trindade", 50, 20, 10.5, 14.5));
        instanceR = new ParkController(pdb);
    }

    /**
     * Test of fillGraph method, of class GraphController.
     */
    @Test
    public void testFillGraph() throws Exception {
        System.out.println("getNearestParks");
        Place p = new Park("1", 23.3, -10.2, 5, "Trindade", 50, 20, 10.5, 14.5);
        List<Place> places = new ArrayList<>();
        places.add(p);
        List<Path> paths = null;
        GraphController instance1 = new GraphController();
        instance1.fillGraph(places, paths);
        Graph<Place, Path> g = new Graph<>(false);
        g.insertVertex(p);
        assertEquals(g, instance1.getG());
    }

    /**
     * Test of getNearestParks method, of class GraphController.
     */
    @Test
    public void testGetNearestParks() throws Exception {
        System.out.println("getNearestParks");
        Place p = new Park("1", 23.3, -10.2, 5, "Trindade", 50, 20, 10.5, 14.5);
        double radius = 0.0;
        GraphController instance1 = new GraphController();
        List<Park> expResult = new ArrayList<>();
        List<Park> result = instance1.getNearestParks(p, radius);
        assertEquals(expResult, result);
    }

    /**
     * Test of getShortestPathDistance method, of class GraphController.
     */
    @Test
    public void testGetShortestPathDistance() throws Exception {
        System.out.println("getShortestPathDistance");
        LinkedList<Place> shortRoute = new LinkedList<>();
        Place p = new Park("1", 23.3, -10.2, 5, "Trindade", 50, 20, 10.5, 14.5);
        GraphController instance1 = new GraphController();
        int expResult = 0;
        int result = instance1.getShortestPathDistance(p, p, shortRoute);
        assertEquals(expResult, result);
    }

    /**
     * Test of getShortestPathPassingThroughtPlacesDistance method, of class
     * GraphController.
     */
    @Test
    public void testGetShortestPathPassingThroughtPlacesDistance() throws Exception {
        System.out.println("getShortestPathPassingThroughtPlacesDistance");
        List<Place> mandatoryPlaces = new ArrayList<>();
        List<Place> shortRoute = new ArrayList<>();
        GraphController instance1 = new GraphController();
        int expResult = 0;
        int result = instance1.getShortestPathPassingThroughtPlacesDistance(null, null, mandatoryPlaces, shortRoute);
        assertEquals(expResult, result);
    }

    /**
     * Test of allPaths method, of class
     * GraphController.
     */
    @Test
    public void testAllPaths() throws Exception {
        System.out.println("allPaths");
        LinkedList<Place> path = new LinkedList<>();
        LinkedList<LinkedList<Place>> paths = new LinkedList<>();
        ArrayList<Place> toVisit = new ArrayList<>();
        GraphController instance1 = new GraphController();
        LinkedList<LinkedList<Place>> expResult = new LinkedList<>();
        instance1.allPaths(null, null, path,paths, toVisit);
        assertEquals(expResult, paths);
    }

    /**
     * Test of writePathsFile method, of class GraphController.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWritePathsFile() throws Exception {
        System.out.println("writePathsFile");

        Place vOrig = new Park("orig", 10, 10, 0, "São Bento", 70, 20, 10.5, 14.5);
        Place vDest = new Park("dest", 20, 10, 0, "Trindade", 50, 20, 10.5, 14.5);
        Place place2 = new Park("2", 17.5, 15, 0, "São Francisco", 50, 20, 10.5, 14.5);
        Place place3 = new Park("3", 20.5, 15, 0, "São Francisco", 50, 20, 10.5, 14.5);
        Place place5 = new Park("5", 15, 10, 0, "São Francisco", 50, 20, 10.5, 14.5);
        Graph<Place, Path> g = new Graph<>(false);
        g.insertVertex(vOrig);
        g.insertVertex(vDest);
        g.insertVertex(place3);
        g.insertVertex(place2);
        g.insertVertex(place5);

        Path p1 = new Path(10, 10, 17.5, 15, 20, 30, 40);
        Path p2 = new Path(10, 10, 20.5, 15, 20, 30, 40);
        Path p3 = new Path(17.5, 15, 15, 10, 20, 30, 40);
        Path p4 = new Path(20.5, 15, 15, 10, 20, 30, 40);
        Path p5 = new Path(20.5, 15, 20, 10, 20, 30, 40);
        Path p6 = new Path(15, 10, 20, 10, 20, 30, 40);

        g.insertEdge(vOrig, place2, p1, Distances.distance(10, 10, 15, 10, 0));
        g.insertEdge(vOrig, place3, p2, Distances.distance(10, 10, 15, 10, 0));
        g.insertEdge(place2, place5, p3, Distances.distance(15, 10, 17.5, 15, 0));
        g.insertEdge(place3, place5, p4, Distances.distance(15, 10, 20, 10, 0));
        g.insertEdge(place3, vDest, p5, Distances.distance(17.5, 15, 20, 10, 0));
        g.insertEdge(place5, vDest, p6, Distances.distance(15, 10, 20, 10, 0));

        int maxNumberOfSuggestions = 2;
        List<LinkedList<Place>> paths = new ArrayList<>();

        LinkedList<Place> path1 = new LinkedList<>();
        path1.add(vOrig);
        path1.add(place2);
        path1.add(vDest);

        LinkedList<Place> path2 = new LinkedList<>();
        path2.add(vOrig);
        path2.add(place3);
        path2.add(vDest);

        paths.add(path2);
        paths.add(path1);

        String outputFileName = "filePaths.csv";
        int elevation = 10;
        GraphController instance = new GraphController();
        int expResult = 2;
        int result = instance.writePathsFile(maxNumberOfSuggestions, paths, outputFileName, elevation);
        assertEquals(expResult, result);
    }

    /**
     * Test of writePathsFile method, of class GraphController.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWritePathsFile2() throws Exception {
        System.out.println("writePathsFile");

        Place vOrig = new Park("orig", 10, 10, 0, "São Bento", 70, 20, 10.5, 14.5);
        Place vDest = new Park("dest", 20, 10, 0, "Trindade", 50, 20, 10.5, 14.5);
        Place place2 = new Park("2", 17.5, 15, 0, "São Francisco", 50, 20, 10.5, 14.5);
        Place place3 = new Park("3", 20.5, 15, 0, "São Francisco", 50, 20, 10.5, 14.5);

        int maxNumberOfSuggestions = 1;
        List<LinkedList<Place>> paths = new ArrayList<>();

        LinkedList<Place> path1 = new LinkedList<>();
        path1.add(vOrig);
        path1.add(place2);
        path1.add(vDest);

        LinkedList<Place> path2 = new LinkedList<>();
        path2.add(vOrig);
        path2.add(place3);
        path2.add(vDest);

        paths.add(path2);
        paths.add(path1);

        String outputFileName = "filePaths.csv";
        int elevation = 10;
        GraphController instance = new GraphController();
        int expResult = 1;
        int result = instance.writePathsFile(maxNumberOfSuggestions, paths, outputFileName, elevation);
        assertEquals(expResult, result);
    }

    /**
     * Test of writePathsFile method, of class GraphController.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testWritePathsFile3() throws Exception {
        System.out.println("writePathsFile");

        Place vOrig = new Park("orig", 10, 10, 0, "São Bento", 70, 20, 10.5, 14.5);
        Place vDest = new Park("dest", 20, 10, 0, "Trindade", 50, 20, 10.5, 14.5);
        Place place2 = new Park("2", 17.5, 15, 0, "São Francisco", 50, 20, 10.5, 14.5);
        Place place3 = new Park("3", 20.5, 15, 0, "São Francisco", 50, 20, 10.5, 14.5);

        int maxNumberOfSuggestions = 1;
        List<LinkedList<Place>> paths = new ArrayList<>();
        List<LinkedList<Place>> paths2 = new ArrayList<>();
        LinkedList<Place> path1 = new LinkedList<>();
        path1.add(vOrig);
        path1.add(place2);
        path1.add(vDest);

        LinkedList<Place> path2 = new LinkedList<>();
        path2.add(vOrig);
        path2.add(place3);
        path2.add(vDest);

        paths.add(path2);
        paths.add(path1);

        String outputFileName = "filePaths.csv";
        int elevation = 10;
        GraphController instance = new GraphController();
        int expResult = 0;
        int result = instance.writePathsFile(maxNumberOfSuggestions, paths2, outputFileName, elevation);
        assertEquals(expResult, result);
    }

    /**
     * Test of sortPaths method, of class GraphController.
     */
    @Test
    public void testSortPaths() {
        System.out.println("sortPaths");

        Place vOrig = new Park("orig", 10, 10, 0, "São Bento", 70, 20, 10.5, 14.5);
        Place vDest = new Park("dest", 20, 10, 0, "Trindade", 50, 20, 10.5, 14.5);
        Place place2 = new Park("2", 17.5, 15, 0, "São Francisco", 50, 20, 10.5, 14.5);
        Place place3 = new Park("3", 20.5, 15, 0, "São Francisco", 50, 20, 10.5, 14.5);

        String sortingCriteria = "";
        boolean ascendingOrder = false;
        List<LinkedList<Place>> paths = null;
        GraphController instance = new GraphController();
        boolean expResult = true;
        boolean result = instance.sortPaths(sortingCriteria, ascendingOrder, paths);
        assertEquals(expResult, result);
    }

    /**
     * Test of sortPaths method, of class GraphController.
     */
    @Test
    public void testSortPaths2() {
        System.out.println("sortPaths");

        Place vOrig = new Park("orig", 10, 10, 0, "São Bento", 70, 20, 10.5, 14.5);
        Place vDest = new Park("dest", 20, 10, 0, "Trindade", 50, 20, 10.5, 14.5);
        Place place2 = new Park("2", 17.5, 15, 0, "São Francisco", 50, 20, 10.5, 14.5);
        Place place3 = new Park("3", 20.5, 15, 0, "São Francisco", 50, 20, 10.5, 14.5);

        List<LinkedList<Place>> paths = new ArrayList<>();

        LinkedList<Place> path1 = new LinkedList<>();
        path1.add(vOrig);
        path1.add(place2);
        path1.add(vDest);

        LinkedList<Place> path2 = new LinkedList<>();
        path2.add(vOrig);
        path2.add(vDest);

        paths.add(path2);
        paths.add(path1);

        String sortingCriteria = "shortest_distance";
        boolean ascendingOrder = true;
        GraphController instance = new GraphController();
        boolean expResult = false;
        boolean result = instance.sortPaths(sortingCriteria, ascendingOrder, paths);
        assertEquals(expResult, result);
    }

    /**
     * Test of sortPaths method, of class GraphController.
     */
    @Test
    public void testSortPaths3() {
        System.out.println("sortPaths");

        Place vOrig = new Park("orig", 10, 10, 0, "São Bento", 70, 20, 10.5, 14.5);
        Place vDest = new Park("dest", 20, 10, 0, "Trindade", 50, 20, 10.5, 14.5);
        Place place2 = new Park("2", 17.5, 15, 0, "São Francisco", 50, 20, 10.5, 14.5);
        Place place3 = new Park("3", 20.5, 15, 0, "São Francisco", 50, 20, 10.5, 14.5);

        List<LinkedList<Place>> paths = new ArrayList<>();

        LinkedList<Place> path1 = new LinkedList<>();
        path1.add(vOrig);
        path1.add(place2);
        path1.add(vDest);

        LinkedList<Place> path2 = new LinkedList<>();
        path2.add(vOrig);
        path2.add(vDest);

        paths.add(path2);
        paths.add(path1);

        String sortingCriteria = "energy";
        boolean ascendingOrder = true;
        GraphController instance = new GraphController();
        boolean expResult = false;
        boolean result = instance.sortPaths(sortingCriteria, ascendingOrder, paths);
        assertEquals(expResult, result);
    }

    /**
     * Test of sortPaths method, of class GraphController.
     */
    @Test
    public void testSortPaths4() {
        System.out.println("sortPaths");

        Place vOrig = new Park("orig", 10, 10, 0, "São Bento", 70, 20, 10.5, 14.5);
        Place vDest = new Park("dest", 20, 10, 0, "Trindade", 50, 20, 10.5, 14.5);
        Place place2 = new Park("2", 17.5, 15, 0, "São Francisco", 50, 20, 10.5, 14.5);
        Place place3 = new Park("3", 20.5, 15, 0, "São Francisco", 50, 20, 10.5, 14.5);

        List<LinkedList<Place>> paths = new ArrayList<>();

        LinkedList<Place> path1 = new LinkedList<>();
        path1.add(vOrig);
        path1.add(place2);
        path1.add(vDest);

        LinkedList<Place> path2 = new LinkedList<>();
        path2.add(vOrig);
        path2.add(vDest);

        LinkedList<Place> path3 = new LinkedList<>();
        path3.add(vOrig);
        path3.add(place2);
        path3.add(place3);
        path3.add(vDest);

        paths.add(path2);
        paths.add(path1);
        paths.add(path3);

        String sortingCriteria = "number_of_points";
        boolean ascendingOrder = false;
        GraphController instance = new GraphController();
        boolean expResult = false;
        boolean result = instance.sortPaths(sortingCriteria, ascendingOrder, paths);
        assertEquals(expResult, result);

        assertEquals(new ArrayList<>(), instance.getInputPOIs(null));
    }

}
