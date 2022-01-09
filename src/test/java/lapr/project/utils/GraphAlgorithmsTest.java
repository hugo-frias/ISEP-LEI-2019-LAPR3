package lapr.project.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import lapr.project.controller.GraphController;
import lapr.project.model.Park;
import lapr.project.model.Path;
import lapr.project.model.Place;
import lapr.project.model.Poi;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.Assert.*;

import org.junit.Ignore;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GraphAlgorithmsTest {

    public GraphAlgorithmsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of fillGraph method, of class MainController.
     */
    @Test
    public void testFillGraph() {
        System.out.println("fillGraph");

        ArrayList<Place> parks = new ArrayList<>();
        ArrayList<Path> paths = new ArrayList<>();

        Graph<Place, Path> aux = new Graph(false);
        Graph<Place, Path> instance = new Graph(false);

        Park p1 = new Park("1", 27.3, 10.2, 15, "São Bento", 50, 20, 10.5, 14.5);
        Park p2 = new Park("2", 28.3, 11.2, 15, "São Francisco", 50, 20, 10.5, 14.5);
        Park p3 = new Park("3", 29.3, 12.2, 15, "São Carlos", 50, 20, 10.5, 14.5);
        Park p4 = new Park("4", 30.3, 13.2, 15, "São Bernardo", 50, 20, 10.5, 14.5);

        Path p5 = new Path(27.3, 10.2, 28.3, 11.2, 0.003, 222, 1.2);
        Path p6 = new Path(28.3, 11.2, 29.3, 12.2, 0.003, 222, 1.2);
        Path p7 = new Path(29.3, 12.2, 30.3, 13.2, 0.003, 222, 1.2);

        parks.add(p1);
        parks.add(p2);
        parks.add(p3);
        parks.add(p4);

        paths.add(p5);
        paths.add(p6);
        paths.add(p7);

        aux.insertVertex(p1);
        aux.insertVertex(p2);
        aux.insertVertex(p3);
        aux.insertVertex(p4);

        aux.insertEdge(p1, p2, p5, 148);
        aux.insertEdge(p2, p3, p6, 147);
        aux.insertEdge(p3, p4, p7, 310);

        GraphAlgorithms.fillGraph(instance, parks, paths);

        assertTrue("Graphs should be equals", aux.equals(instance));

    }

    /**
     * Test of fillGraph method, of class MainController.
     */
    @Test
    public void testFillGraph2() {
        System.out.println("fillGraph");

        ArrayList<Place> parks = new ArrayList<>();
        ArrayList<Path> paths = new ArrayList<>();

        Graph<Place, Path> aux = new Graph(false);
        Graph<Place, Path> instance = new Graph(false);

        Park p1 = new Park("1", 27.3, 10.2, 15, "São Bento", 50, 20, 10.5, 14.5);
        Park p2 = new Park("2", 28.3, 11.2, 15, "São Francisco", 50, 20, 10.5, 14.5);
        Park p3 = new Park("3", 29.3, 12.2, 15, "São Carlos", 50, 20, 10.5, 14.5);
        Park p4 = new Park("4", 30.3, 13.2, 15, "São Bernardo", 50, 20, 10.5, 14.5);

        Path p8 = new Path(31.3, 16.2, 38.3, 29.2, 0.003, 222, 1.2);

        parks.add(p1);
        parks.add(p2);
        parks.add(p3);
        parks.add(p4);

        paths.add(p8);

        aux.insertVertex(p1);
        aux.insertVertex(p2);
        aux.insertVertex(p3);
        aux.insertVertex(p4);

        GraphAlgorithms.fillGraph(instance, parks, paths);

        assertTrue("Graphs should be equals", aux.equals(instance));

    }

    /**
     * Test of getNearestParks method, of class GraphAlgorithms.
     */
    @Test
    public void testGetNearestParks1() {
        System.out.println("getNearestParks");

        Graph<Place, Path> aux = new Graph(false);

        Park p1 = new Park("1", 27.3, 10.2, 15, "São Bento", 50, 20, 10.5, 14.5);
        Park p2 = new Park("2", 28.3, 11.2, 15, "São Francisco", 50, 20, 10.5, 14.5);
        Park p3 = new Park("3", 29.3, 12.2, 15, "São Carlos", 50, 20, 10.5, 14.5);
        Park p4 = new Park("4", 60.3, 13.2, 15, "São Bernardo", 50, 20, 10.5, 14.5);

        Path p5 = new Path(27.3, 10.2, 28.3, 11.2, 0.003, 222, 1.2);
        Path p6 = new Path(28.3, 11.2, 29.3, 12.2, 0.003, 222, 1.2);
        Path p7 = new Path(29.3, 12.2, 30.3, 13.2, 0.003, 222, 1.2);

        aux.insertVertex(p1);
        aux.insertVertex(p2);
        aux.insertVertex(p3);
        aux.insertVertex(p4);

        aux.insertEdge(p1, p2, p5, 148);
        aux.insertEdge(p2, p3, p6, 147);
        aux.insertEdge(p3, p4, p7, 310);

        Park park = p3;
        double radius = 200.0;
        ArrayList<Park> expResult = new ArrayList<>();

        expResult.add(p3);
        expResult.add(p2);

        ArrayList<Park> result = (ArrayList<Park>) GraphAlgorithms.getNearestParks(aux, park, radius);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNearestParks method, of class GraphAlgorithms.
     */
    @Test
    public void testGetNearestParks2() {
        System.out.println("getNearestParks");

        Graph<Place, Path> aux = new Graph(false);

        Park p1 = new Park("1", 27.3, 10.2, 15, "São Bento", 50, 20, 10.5, 14.5);
        Park p2 = new Park("2", 28.3, 11.2, 15, "São Francisco", 50, 20, 10.5, 14.5);
        Park p3 = new Park("3", 29.3, 12.2, 15, "São Carlos", 50, 20, 10.5, 14.5);
        Park p4 = new Park("4", 60.3, 13.2, 15, "São Bernardo", 50, 20, 10.5, 14.5);

        Path p5 = new Path(27.3, 10.2, 28.3, 11.2, 0.003, 222, 1.2);
        Path p6 = new Path(28.3, 11.2, 29.3, 12.2, 0.003, 222, 1.2);
        Path p7 = new Path(29.3, 12.2, 30.3, 13.2, 0.003, 222, 1.2);

        aux.insertVertex(p1);
        aux.insertVertex(p2);
        aux.insertVertex(p3);
        aux.insertVertex(p4);

        aux.insertEdge(p1, p2, p5, 148);
        aux.insertEdge(p2, p3, p6, 147);
        aux.insertEdge(p3, p4, p7, 310);

        Park park = p3;
        double radius = 148.0;
        ArrayList<Park> expResult = new ArrayList<>();

        expResult.add(p3);
        expResult.add(p2);

        ArrayList<Park> result = (ArrayList<Park>) GraphAlgorithms.getNearestParks(aux, park, radius);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNearestParks method, of class GraphAlgorithms.
     */
    @Test
    public void testGetNearestParks3() {
        System.out.println("getNearestParks");

        Graph<Place, Path> aux = new Graph(false);

        Park p1 = new Park("1", 27.3, 10.2, 15, "São Bento", 50, 20, 10.5, 14.5);
        Park p2 = new Park("2", 28.3, 11.2, 15, "São Francisco", 50, 20, 10.5, 14.5);
        Park p3 = new Park("3", 29.3, 12.2, 15, "São Carlos", 50, 20, 10.5, 14.5);
        Park p4 = new Park("4", 30.3, 13.2, 15, "São Bernardo", 50, 20, 10.5, 14.5);

        Path p5 = new Path(27.3, 10.2, 28.3, 11.2, 0.003, 222, 1.2);
        Path p6 = new Path(28.3, 11.2, 29.3, 12.2, 0.003, 222, 1.2);
        Path p7 = new Path(29.3, 12.2, 30.3, 13.2, 0.003, 222, 1.2);

        aux.insertVertex(p1);
        aux.insertVertex(p2);
        aux.insertVertex(p3);
        aux.insertVertex(p4);

        aux.insertEdge(p1, p2, p5, 148);
        aux.insertEdge(p2, p3, p6, 147);
        aux.insertEdge(p3, p4, p7, 310);

        Park park = p3;
        double radius = 1.0;
        ArrayList<Park> expResult = new ArrayList<>();

        expResult.add(p3);

        ArrayList<Park> result = (ArrayList<Park>) GraphAlgorithms.getNearestParks(aux, park, radius);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNearestParks method, of class GraphAlgorithms.
     */
    @Test
    public void testGetNearestParks4() {
        System.out.println("getNearestParks");

        Graph<Place, Path> aux = new Graph(false);

        Park p1 = new Park("1", 27.3, 10.2, 15, "São Bento", 50, 20, 10.5, 14.5);
        Park p2 = new Park("2", 28.3, 11.2, 15, "São Francisco", 50, 20, 10.5, 14.5);

        aux.insertVertex(p1);
        aux.insertVertex(p2);

        Place park = p1;
        double radius = 0;
        ArrayList<Park> expResult = new ArrayList<>();

        expResult.add(p1);

        ArrayList<Park> result = (ArrayList<Park>) GraphAlgorithms.getNearestParks(aux, park, radius);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNearestParks method, of class GraphAlgorithms.
     */
    @Test
    public void testGetNearestParks5() {
        System.out.println("getNearestParks");

        Graph<Place, Path> aux = new Graph(false);

        Park p1 = new Park("1", 27.3, 10.2, 15, "São Bento", 50, 20, 10.5, 14.5);
        Park p2 = new Park("2", 28.3, 11.2, 15, "São Francisco", 50, 20, 10.5, 14.5);

        Path p5 = new Path(27.3, 10.2, 28.3, 11.2, 0.003, 222, 1.2);

        aux.insertVertex(p1);
        aux.insertVertex(p2);

        double d = Distances.distance(27.3, 10.2, 28.3, 11.2, 0);
        System.out.println(d);

        aux.insertEdge(p1, p2, p5, Distances.distance(27.3, 10.2, 28.3, 11.2, 0));

        Place park = p1;
        double radius = Distances.distance(27.3, 10.2, 28.3, 11.2, 0);
        ArrayList<Park> expResult = new ArrayList<>();

        expResult.add(p1);
        expResult.add(p2);

        ArrayList<Park> result = (ArrayList<Park>) GraphAlgorithms.getNearestParks(aux, park, radius);
        assertEquals(expResult, result);
    }

    /**
     * Test of shortestRoute method, of class GraphAlgorithms.
     */
    @Test
    public void testShortestRoute1() {
        System.out.println("route");
        Graph<Place, Path> g = new Graph<>(false);

        Park p1 = new Park("3", 20.3, 10.2, 65, "São Bento", 70, 20, 10.5, 14.5);
        Park p2 = new Park("2", -29.3, -10.2, 5, "Trindade", 50, 20, 10.5, 14.5);

        g.insertVertex(p1);

        LinkedList<Place> shortPath = new LinkedList<>();
        double lenpath;
        lenpath = GraphAlgorithms.shortestRoute(g, p1, p2, shortPath);
        assertTrue("Length path should be 0 if vertex does not exist", lenpath == 0);
    }

    /**
     * Test of shortestRoute method, of class GraphAlgorithms.
     */
    @Test
    public void testShortestRoute2() {
        Graph<Place, Path> g = new Graph<>(false);

        Park p1 = new Park("3", 20.3, 10.2, 65, "São Bento", 70, 20, 10.5, 14.5);

        g.insertVertex(p1);

        LinkedList<Place> shortPath = new LinkedList<>();

        double lenpath = GraphAlgorithms.shortestRoute(g, p1, p1, shortPath);
        assertTrue("Number of nodes should be 1 if source and vertex are the same", shortPath.size() == 1);
        assertTrue("The size of the route should be 0", lenpath == 0);
    }

    /**
     * Test of shortestRoute method, of class GraphAlgorithms.
     */
    @Test
    public void testShortestRoute3() {
        Graph<Place, Path> g = new Graph<>(false);

        Park p1 = new Park("3", 20.3, 10.2, 65, "São Bento", 70, 20, 10.5, 14.5);
        Park p2 = new Park("2", -29.3, -10.2, 5, "Trindade", 50, 20, 10.5, 14.5);

        g.insertVertex(p1);
        g.insertVertex(p2);

        LinkedList<Place> shortPath = new LinkedList<>();

        double lenpath = GraphAlgorithms.shortestRoute(g, p1, p2, shortPath);
        assertTrue("The size should be 0, because there is no edge between the points", lenpath == 0);
    }

    /**
     * Test of shortestRoute method, of class GraphAlgorithms.
     */
    @Test
    public void testShortestRoute4() {
        Graph<Place, Path> g = new Graph<>(false);

        LinkedList<Place> shortPath = new LinkedList<>();

        double lenpath = GraphAlgorithms.shortestRoute(g, null, null, shortPath);
        assertTrue("The size should be 0, because there is no edge between the points", lenpath == 0);
    }

    /**
     * Test of route method, of class GraphAlgorithms.
     */
    @Test
    public void testShortestRoute5() {
        Graph<Place, Path> g = new Graph<>(false);

        Park p1 = new Park("3", 20.3, 10.2, 65, "São Bento", 70, 20, 10.5, 14.5);
        Park p2 = new Park("2", -29.3, -10.2, 5, "Trindade", 50, 20, 10.5, 14.5);

        Path p3 = new Path(20.3, 10.2, -29.3, -10.2, 20, 30, 40);
        g.insertVertex(p1);
        g.insertVertex(p2);

        g.insertEdge(p1, p2, p3, Distances.distance(20.3, 10.2, -29.3, -10.2, 0));
        LinkedList<Place> shortPath = new LinkedList<>();

        double lenpath = GraphAlgorithms.shortestRoute(g, p1, p2, shortPath);
        assertEquals(5932.779, lenpath, 3);
        assertTrue("Number of points should be 2", shortPath.size() == 2);
    }

    /**
     * Test of route method, of class GraphAlgorithms.
     */
    @Test
    public void testShortestRoute6() {
        Graph<Place, Path> g = new Graph<>(false);

        Park p1 = new Park("3", 20.3, 10.2, 65, "São Bento", 70, 20, 10.5, 14.5);
        Park p2 = new Park("2", -29.3, -10.2, 5, "Trindade", 50, 20, 10.5, 14.5);
        Park p3 = new Park("4", -29.3, -11.2, 5, "São Francisco", 50, 20, 10.5, 14.5);

        Path p4 = new Path(20.3, 10.2, -29.3, -10.2, 20, 30, 40);
        Path p5 = new Path(20.3, 10.2, -29.3, -11.2, 20, 30, 40);
        Path p6 = new Path(-29.3, -11.2, 20.3, 10.2, 20, 30, 40);

        g.insertVertex(p1);
        g.insertVertex(p2);

        g.insertEdge(p1, p2, p4, Distances.distance(20.3, 10.2, -29.3, -10.2, 0));
        g.insertEdge(p1, p3, p5, Distances.distance(20.3, 10.2, -29.3, -11.2, 0));
        g.insertEdge(p3, p2, p6, Distances.distance(-29.3, -11.2, 20.3, 10.2, 0));

        LinkedList<Place> shortPath = new LinkedList<>();

        double lenpath = GraphAlgorithms.shortestRoute(g, p1, p2, shortPath);
        assertEquals(5932.779, lenpath, 3);
        assertTrue("Number of points should be 2", shortPath.size() == 2);
    }

    /**
     * Test of transitiveClosure method, of class GraphAlgorithms.
     */
    @Test
    public void testTransitiveClosure1() {
        System.out.println("transitiveClosure");
        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph();

        Park p1 = new Park("3", 20.3, 10.2, 65, "São Bento", 70, 20, 10.5, 14.5);
        Park p2 = new Park("2", -29.3, -10.2, 5, "Trindade", 50, 20, 10.5, 14.5);
        Park p3 = new Park("4", -29.3, -11.2, 5, "São Francisco", 50, 20, 10.5, 14.5);

        graph.insertVertex(p1);
        graph.insertVertex(p2);
        graph.insertVertex(p3);

        graph.insertEdge(p1, p2, Distances.distance(p1.getLatitude(), p1.getLongitude(), p2.getLatitude(), p2.getLongitude(), p2.getElevation() - p1.getElevation()));
        graph.insertEdge(p2, p3, Distances.distance(p2.getLatitude(), p2.getLongitude(), p3.getLatitude(), p3.getLongitude(), p3.getElevation() - p2.getElevation()));

        AdjacencyMatrixGraph expResult = new AdjacencyMatrixGraph();

        expResult.insertVertex(p1);
        expResult.insertVertex(p2);
        expResult.insertVertex(p3);

        double distance1 = Distances.distance(p1.getLatitude(), p1.getLongitude(), p2.getLatitude(), p2.getLongitude(), p2.getElevation() - p1.getElevation());
        double distance2 = Distances.distance(p2.getLatitude(), p2.getLongitude(), p3.getLatitude(), p3.getLongitude(), p3.getElevation() - p2.getElevation());

        expResult.insertEdge(p1, p2, distance1);
        expResult.insertEdge(p2, p3, distance2);
        expResult.insertEdge(p1, p3, distance1 + distance2);

        AdjacencyMatrixGraph result = GraphAlgorithms.transitiveClosure(graph);
        assertEquals(expResult, result);

        graph.insertEdge(p1, p3, distance1 + distance2 + 1000);

        result = GraphAlgorithms.transitiveClosure(graph);
        assertEquals(expResult, result);
    }

    /**
     * Test of shortestRoutePassingThroughtPlaces method, of class
     * GraphAlgorithms.
     */
    @Test
    public void testShortestRoutePassingThroughtPlaces1() {
        System.out.println("shortestRoutePassingThroughtPlaces");
        Graph<Place, Path> g = new Graph<>(false);

        Place orig = new Park("3", 20.3, 10.2, 65, "São Bento", 70, 20, 10.5, 14.5);
        Place dest = new Park("2", -29.3, -10.2, 5, "Trindade", 50, 20, 10.5, 14.5);

        g.insertVertex(orig);

        ArrayList<Place> mandatoryPlaces = null;
        LinkedList<Place> shortRoute = null;

        GraphAlgorithms instance = new GraphAlgorithms();

        double result = instance.shortestRoutePassingThroughtPlaces(g, orig, dest, mandatoryPlaces, shortRoute);
        assertTrue("Length path should be 0 if vertex does not exist", result == 0);

    }

    /**
     * Test of shortestRoutePassingThroughtPlaces method, of class
     * GraphAlgorithms.
     */
    @Test
    public void testShortestRoutePassingThroughtPlaces2() {
        System.out.println("shortestRoutePassingThroughtPlaces");
        Graph<Place, Path> g = new Graph<>(false);

        Place orig = new Park("3", 20.3, 10.2, 65, "São Bento", 70, 20, 10.5, 14.5);
        Place dest = new Park("2", -29.3, -10.2, 5, "Trindade", 50, 20, 10.5, 14.5);

        Place place = new Park("4", -29.3, -11.2, 5, "São Francisco", 50, 20, 10.5, 14.5);

        g.insertVertex(orig);
        g.insertVertex(dest);

        Path p = new Path(20.3, 10.2, -29.3, -10.2, 20, 30, 40);

        g.insertEdge(orig, dest, p, Distances.distance(20.3, 10.2, -29.3, -10.2, 0));

        ArrayList<Place> mandatoryPlaces = new ArrayList<>();

        mandatoryPlaces.add(place);

        LinkedList<Place> shortRoute = new LinkedList<>();

        GraphAlgorithms instance = new GraphAlgorithms();

        double result = instance.shortestRoutePassingThroughtPlaces(g, orig, dest, mandatoryPlaces, shortRoute);
        assertTrue("The size of the route should be 0", result == 0);
    }

    /**
     * Test of shortestRoutePassingThroughtPlaces method, of class
     * GraphAlgorithms.
     */
    @Test
    public void testShortestRoutePassingThroughtPlaces3() {
        System.out.println("shortestRoutePassingThroughtPlaces");
        Graph<Place, Path> g = new Graph<>(false);

        Place orig = new Park("3", 10, 10, 0, "São Bento", 70, 20, 10.5, 14.5);
        Place dest = new Park("2", 20, 10, 0, "Trindade", 50, 20, 10.5, 14.5);

        Place place1 = new Park("4", 17.5, 15, 0, "São Francisco", 50, 20, 10.5, 14.5);
        Place place2 = new Park("5", 15, 10, 0, "São Francisco", 50, 20, 10.5, 14.5);

        g.insertVertex(orig);
        g.insertVertex(dest);
        g.insertVertex(place1);
        g.insertVertex(place2);

        Path p1 = new Path(10, 10, 15, 10, 20, 30, 40);
        Path p2 = new Path(15, 10, 17.5, 15, 20, 30, 40);
        Path p3 = new Path(15, 10, 20, 10, 20, 30, 40);
        Path p4 = new Path(17.5, 15, 20, 10, 20, 30, 40);

        g.insertEdge(orig, place2, p1, Distances.distance(10, 10, 15, 10, 0));
        g.insertEdge(place2, place1, p2, Distances.distance(15, 10, 17.5, 15, 0));
        g.insertEdge(place2, dest, p3, Distances.distance(15, 10, 20, 10, 0));
        g.insertEdge(place1, dest, p4, Distances.distance(17.5, 15, 20, 10, 0));

        ArrayList<Place> mandatoryPlaces = new ArrayList<>();

        mandatoryPlaces.add(place1);

        LinkedList<Place> shortRoute = new LinkedList<>();

        GraphAlgorithms instance = new GraphAlgorithms();

        double expResult = 1752.934;
        double result = instance.shortestRoutePassingThroughtPlaces(g, orig, dest, mandatoryPlaces, shortRoute);
        assertEquals(expResult, result, 3);
        assertTrue("Number of points should be 4", shortRoute.size() == 4);

        Place place3 = new Park("6", 20, 20, 0, "São Francisco", 50, 20, 10.5, 14.5);
        Place place4 = new Park("7", 21, 21, 0, "São Francisco", 50, 20, 10.5, 14.5);

        g.insertVertex(place3);
        g.insertVertex(place4);

        Path p5 = new Path(17.5, 15, 20, 20, 20, 30, 40);
        Path p6 = new Path(20, 20, 20, 10, 20, 30, 40);
        Path p7 = new Path(20, 20, 21, 21, 20, 30, 40);
        Path p8 = new Path(21, 21, 20, 10, 20, 30, 40);

        g.insertEdge(place1, place3, p5, Distances.distance(17.5, 15, 20, 20, 0));
        g.insertEdge(place3, dest, p6, Distances.distance(20, 20, 20, 10, 0));
        g.insertEdge(place3, place4, p7, Distances.distance(20, 20, 21, 21, 0));
        g.insertEdge(place4, dest, p8, Distances.distance(21, 21, 20, 10, 0));

        mandatoryPlaces.clear();

        mandatoryPlaces.add(place3);
        mandatoryPlaces.add(place4);
        mandatoryPlaces.add(place1);

        shortRoute.clear();

        expResult = 3056.058;
        result = instance.shortestRoutePassingThroughtPlaces(g, orig, dest, mandatoryPlaces, shortRoute);
        assertEquals(expResult, result, 3);
        assertTrue("Number of points should be 6", shortRoute.size() == 6);

    }

    /**
     * Test of allPaths method, of class GraphAlgorithms.
     */
    @Test
    public void testAllPaths() {
        System.out.println("allPaths");

        Graph<Place, Path> g = new Graph<>(false);
        Place vOrig = new Park("orig", 10, 10, 0, "São Bento", 70, 20, 10.5, 14.5);
        Place vDest = new Park("dest", 20, 10, 0, "Trindade", 50, 20, 10.5, 14.5);

        Place place2 = new Park("2", 17.5, 15, 0, "São Francisco", 50, 20, 10.5, 14.5);
        Place place3 = new Park("3", 20.5, 15, 0, "São Francisco", 50, 20, 10.5, 14.5);
        Place place5 = new Park("5", 15, 10, 0, "São Francisco", 50, 20, 10.5, 14.5);

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

        ArrayList<Place> vToVisit = new ArrayList<>();
        LinkedList<Place> path = new LinkedList<>();
        ArrayList<LinkedList<Place>> paths = new ArrayList<>();

        vToVisit.add(place5);

        path.push(vOrig);

        GraphAlgorithms.allPaths(g, vOrig, vDest, path, paths, vToVisit);
        assertEquals(3, paths.size());
    }

    /**
     * Test of writePathsFile method, of class GraphAlgorithms.
     */
    @org.junit.Test
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
        int expResult = 2;
        int result = GraphAlgorithms.writePathsFile(maxNumberOfSuggestions, paths, outputFileName, elevation);
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
        int expResult = 1;
        int result = GraphAlgorithms.writePathsFile(maxNumberOfSuggestions, paths, outputFileName, elevation);
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
        int expResult = 1;
        int result = GraphAlgorithms.writePathsFile(maxNumberOfSuggestions, paths, outputFileName, elevation);
        assertEquals(expResult, result);
    }

    /**
     * Test of writePathsFile method, of class GraphController.
     *
     * @throws java.lang.Exception
     */
    @Ignore
    public void testWritePathsFile4() throws Exception {
        System.out.println("writePathsFile");

        Place vOrig = new Park("orig", 10, 10, 0, "São Bento", 70, 20, 10.5, 14.5);
        Place vDest = new Park("dest", 20, 10, 0, "Trindade", 50, 20, 10.5, 14.5);
        Place place2 = new Park("2", 17.5, 15, 0, "São Francisco", 50, 20, 10.5, 14.5);
        Place place3 = new Park("3", 20.5, 15, 0, "São Francisco", 50, 20, 10.5, 14.5);

        int maxNumberOfSuggestions = 4;
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
        List<String> expResult = Utils.loadCsv(outputFileName);
        int elevation = 10;
        GraphAlgorithms.writePathsFile(maxNumberOfSuggestions, paths, outputFileName, elevation);
        List<String> result = Utils.loadCsv(outputFileName);
        assertEquals(expResult, result);
    }

    /**
     * Test of sortPaths method, of class GraphAlgorithms.
     */
    @org.junit.Test
    public void testSortPaths() {
        System.out.println("sortPaths");
        Place vOrig = new Park("orig", 10, 10, 0, "São Bento", 70, 20, 10.5, 14.5);
        Place vDest = new Park("dest", 20, 10, 0, "Trindade", 50, 20, 10.5, 14.5);
        Place place2 = new Park("2", 17.5, 15, 0, "São Francisco", 50, 20, 10.5, 14.5);
        Place place3 = new Park("3", 20.5, 15, 0, "São Francisco", 50, 20, 10.5, 14.5);

        String sortingCriteria = "";
        boolean ascendingOrder = false;
        List<LinkedList<Place>> paths = null;
        boolean expResult = true;
        boolean result = GraphAlgorithms.sortPaths(sortingCriteria, ascendingOrder, paths);
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
        boolean result = GraphAlgorithms.sortPaths(sortingCriteria, ascendingOrder, paths);
        assertEquals(expResult, result);
    }

    /**
     * Test of sortPaths method, of class GraphController.
     */
    @Test
    public void testSortPaths5() {
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

        List<LinkedList<Place>> expResult = new ArrayList<>();
        expResult.add(path1);
        expResult.add(path2);

        GraphAlgorithms.sortPaths(sortingCriteria, ascendingOrder, paths);
        assertEquals(expResult, paths);
    }

    /**
     * Test of sortPaths method, of class GraphController.
     */
    @Test
    public void testSortPaths8() {
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
        boolean ascendingOrder = false;
        GraphController instance = new GraphController();

        List<LinkedList<Place>> expResult = new ArrayList<>();
        expResult.add(path2);
        expResult.add(path1);

        GraphAlgorithms.sortPaths(sortingCriteria, ascendingOrder, paths);
        assertEquals(expResult, paths);
    }

    /**
     * Test of sortPaths method, of class GraphController.
     */
    @Test
    public void testSortPaths6() {
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

        List<LinkedList<Place>> expResult = new ArrayList<>();
        expResult.add(path2);
        expResult.add(path1);

        GraphAlgorithms.sortPaths(sortingCriteria, ascendingOrder, paths);
        assertEquals(expResult, paths);
    }

    /**
     * Test of sortPaths method, of class GraphController.
     */
    @Test
    public void testSortPaths7() {
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
        boolean ascendingOrder = false;
        GraphController instance = new GraphController();

        List<LinkedList<Place>> expResult = new ArrayList<>();
        expResult.add(path1);
        expResult.add(path2);

        GraphAlgorithms.sortPaths(sortingCriteria, ascendingOrder, paths);
        assertEquals(expResult, paths);
    }

    /**
     * Test of sortPaths method, of class GraphController.
     */
    @Test
    public void testSortPaths9() {
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

        String sortingCriteria = "number_of_points";
        boolean ascendingOrder = true;
        GraphController instance = new GraphController();

        List<LinkedList<Place>> expResult = new ArrayList<>();
        expResult.add(path2);
        expResult.add(path1);

        GraphAlgorithms.sortPaths(sortingCriteria, ascendingOrder, paths);
        assertEquals(expResult, paths);
    }

    /**
     * Test of sortPaths method, of class GraphController.
     */
    @Test
    public void testSortPaths10() {
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

        String sortingCriteria = "number_of_points";
        boolean ascendingOrder = false;
        GraphController instance = new GraphController();

        List<LinkedList<Place>> expResult = new ArrayList<>();
        expResult.add(path1);
        expResult.add(path2);

        GraphAlgorithms.sortPaths(sortingCriteria, ascendingOrder, paths);
        assertEquals(expResult, paths);
    }
    /**
     * Test of sortPaths method, of class GraphController.
     */
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
        boolean result = GraphAlgorithms.sortPaths(sortingCriteria, ascendingOrder, paths);
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
        boolean result = GraphAlgorithms.sortPaths(sortingCriteria, ascendingOrder, paths);
        assertEquals(expResult, result);
    }

    /**
     * Test of getInputPOIS method, of class GraphAlgorithms.
     */
    @Ignore
    public void testGetInputPOIS() {
        System.out.println("getInputPOIS");
        String inputPOIs = "poisTest";
        GraphController instance = new GraphController();
        ArrayList<Place> expResult = new ArrayList<Place>();
        Poi test1 = new Poi("1", 20, 30, 10, "cenas");
        Poi test2 = new Poi("2", 40, 50, 0, "cenas2");
        Poi test3 = new Poi("2", 100, 20, 50, "cenas3");
        expResult.add(test1);
        expResult.add(test2);
        expResult.add(test3);
        ArrayList<Place> result = (ArrayList<Place>) GraphAlgorithms.getInputPOIS(inputPOIs);
        assertEquals(expResult, result);
    }
}
