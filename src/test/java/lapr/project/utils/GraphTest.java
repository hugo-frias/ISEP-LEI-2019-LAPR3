package lapr.project.utils;

import java.util.Arrays;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author frodrigues
 * @author DEI-ESINF
 */
class GraphTest {

    Graph<String, String> instance = new Graph<>(true);
    Graph<String, String> instance1 = new Graph<>(false);

    public GraphTest() {
    }

    @Before
    public void setUp() {

    }

    /**
     * Test of numVertices method, of class Graph.
     */
    @Test
    public void testNumVertices() {
        System.out.println("Test numVertices");

        assertTrue((instance.numVertices() == 0));

        instance.insertVertex("A");
        assertTrue((instance.numVertices() == 1));

        instance.insertVertex("B");
        assertTrue((instance.numVertices() == 2));

        instance.removeVertex("A");
        assertTrue((instance.numVertices() == 1));

        instance.removeVertex("B");
        assertTrue((instance.numVertices() == 0));
    }

    /**
     * Test of vertices method, of class Graph.
     */
    @Test
    public void testVertices() {
        System.out.println("Test vertices");

        Iterator<String> itVerts = instance.vertices().iterator();

        assertTrue(itVerts.hasNext() == false);

        instance.insertVertex("A");
        instance.insertVertex("B");

        itVerts = instance.vertices().iterator();

        assertTrue((itVerts.next().compareTo("A") == 0));
        assertTrue((itVerts.next().compareTo("B") == 0));

        instance.removeVertex("A");

        itVerts = instance.vertices().iterator();
        assertTrue((itVerts.next().compareTo("B")) == 0);

        instance.removeVertex("B");

        itVerts = instance.vertices().iterator();
        assertTrue(itVerts.hasNext() == false);
    }

    /**
     * Test of numEdges method, of class Graph.
     */
    @Test
    public void testNumEdges() {
        System.out.println("Test numEdges");

        assertTrue((instance.numEdges() == 0));

        instance.insertEdge("A", "B", "Edge1", 6);
        assertTrue((instance.numEdges() == 1));

        instance.insertEdge("A", "C", "Edge2", 1);
        assertTrue((instance.numEdges() == 2));

        instance.removeEdge("A", "B");
        assertTrue((instance.numEdges() == 1));

        instance.removeEdge("A", "C");
        assertTrue((instance.numEdges() == 0));
    }

    /**
     * Test of edges method, of class Graph.
     */
    @Test
    public void testEdges() {
        System.out.println("Test Edges");

        Iterator<Edge<String, String>> itEdge = instance.edges().iterator();

        assertTrue((itEdge.hasNext() == false));

        instance.insertEdge("A", "B", "Edge1", 6);
        instance.insertEdge("A", "C", "Edge2", 1);
        instance.insertEdge("B", "D", "Edge3", 3);
        instance.insertEdge("C", "D", "Edge4", 4);
        instance.insertEdge("C", "E", "Edge5", 1);
        instance.insertEdge("D", "A", "Edge6", 2);
        instance.insertEdge("E", "D", "Edge7", 1);
        instance.insertEdge("E", "E", "Edge8", 1);

        itEdge = instance.edges().iterator();

        itEdge.next();
        itEdge.next();
        assertTrue(itEdge.next().getElement().equals("Edge3") == true);

        itEdge.next();
        itEdge.next();
        assertTrue(itEdge.next().getElement().equals("Edge6") == true);

        instance.removeEdge("A", "B");

        itEdge = instance.edges().iterator();
        assertTrue(itEdge.next().getElement().equals("Edge2") == true);

        instance.removeEdge("A", "C");
        instance.removeEdge("B", "D");
        instance.removeEdge("C", "D");
        instance.removeEdge("C", "E");
        instance.removeEdge("D", "A");
        instance.removeEdge("E", "D");
        instance.removeEdge("E", "E");
        itEdge = instance.edges().iterator();
        assertTrue(itEdge.hasNext() == false);
    }

    /**
     * Test of getEdge method, of class Graph.
     */
    @Test
    public void testGetEdge() {
        System.out.println("Test getEdge");

        instance.insertEdge("A", "B", "Edge1", 6);
        instance.insertEdge("A", "C", "Edge2", 1);
        instance.insertEdge("B", "D", "Edge3", 3);
        instance.insertEdge("C", "D", "Edge4", 4);
        instance.insertEdge("C", "E", "Edge5", 1);
        instance.insertEdge("D", "A", "Edge6", 2);
        instance.insertEdge("E", "D", "Edge7", 1);
        instance.insertEdge("E", "E", "Edge8", 1);

        assertTrue(instance.getEdge("A", "E") == null);

        assertTrue(instance.getEdge("B", "D").getElement().equals("Edge3") == true);
        assertTrue(instance.getEdge("D", "B") == null);

        instance.removeEdge("D", "A");
        assertTrue(instance.getEdge("D", "A") == null);

        assertTrue(instance.getEdge("E", "E").getElement().equals("Edge8") == true);
    }

    /**
     * Test of getKey method, of class Graph.
     */
    @Test
    public void testGetKey() {
        System.out.println("Test getKey");

        instance.insertVertex("A");

        int key = 0;

        int result = instance.getKey("A");
        assertTrue(result == key);
    }

    /**
     * Test of allKeyVerts method, of class Graph.
     */
    @Test
    public void testAllKeyVerts() {
        System.out.println("Test allKeyVerts");

        instance.insertVertex("A");
        instance.insertVertex("B");

        String keyVerts[] = {"A", "B"};
        String result[] = instance.allkeyVerts();
        assertTrue(Arrays.equals(result, keyVerts));
    }

    /**
     * Test of adjVertices method, of class Graph.
     */
    @Test
    public void testAdjVertices() {
        System.out.println("Test adjVertices");

        Iterable result = instance.adjVertices("C");
        assertTrue(result == null);
    }

    /**
     * Test of endVertices method, of class Graph.
     */
    @Test
    public void testEndVertices() {
        System.out.println("Test endVertices");

        instance.insertEdge("A", "B", "Edge1", 6);
        instance.insertEdge("A", "C", "Edge2", 1);
        instance.insertEdge("B", "D", "Edge3", 3);
        instance.insertEdge("C", "D", "Edge4", 4);
        instance.insertEdge("C", "E", "Edge5", 1);
        instance.insertEdge("D", "A", "Edge6", 2);
        instance.insertEdge("E", "D", "Edge7", 1);
        instance.insertEdge("E", "E", "Edge8", 1);

        Edge<String, String> edge0 = new Edge<>();

        String[] vertices = new String[2];

        //assertTrue("endVertices should be null", instance.endVertices(edge0)==null);
        Edge<String, String> edge1 = instance.getEdge("A", "B");
        //vertices = instance.endVertices(edge1);
        assertTrue(instance.endVertices(edge1)[0].equals("A"));
        assertTrue(instance.endVertices(edge1)[1].equals("B"));

        assertTrue(instance.endVertices(null) == null);

        Vertex<String, String> vert = new Vertex(10, "C");
        Edge<String, String> edge2 = new Edge("df", 1, null, vert);
        assertTrue(instance.endVertices(edge2) == null);

        Vertex<String, String> vert1 = new Vertex(11, "D");
        Edge<String, String> edge3 = new Edge("df", 1, vert1, vert);
        assertTrue(instance.endVertices(edge3) == null);
    }

    /**
     * Test of opposite method, of class Graph.
     */
    @Test
    public void testOpposite() {
        System.out.println("Test opposite");

        instance.insertVertex("A");
        instance.insertVertex("B");
        instance.insertVertex("C");
        instance.insertVertex("D");
        instance.insertVertex("E");

        instance.insertEdge("A", "B", "Edge1", 6);
        instance.insertEdge("A", "C", "Edge2", 1);
        instance.insertEdge("B", "D", "Edge3", 3);
        instance.insertEdge("C", "D", "Edge4", 4);
        instance.insertEdge("C", "E", "Edge5", 1);
        instance.insertEdge("D", "A", "Edge6", 2);
        instance.insertEdge("E", "D", "Edge7", 1);
        instance.insertEdge("E", "E", "Edge8", 1);

        Edge<String, String> edge5 = instance.getEdge("C", "E");
        String vert = instance.opposite("A", edge5);
        assertTrue(vert == null);

        Edge<String, String> edge1 = instance.getEdge("A", "B");
        vert = instance.opposite("A", edge1);
        assertTrue(vert.equals("B") == true);

        Edge<String, String> edge8 = instance.getEdge("E", "E");
        vert = instance.opposite("E", edge8);
        assertTrue(vert.equals("E") == true);

        vert = instance.opposite("F", edge8);
        assertTrue(vert == null);
    }

    /**
     * Test of outDegree method, of class Graph.
     */
    @Test
    public void testOutDegree() {
        System.out.println("Test outDegree");

        instance.insertVertex("A");
        instance.insertVertex("B");
        instance.insertVertex("C");
        instance.insertVertex("D");
        instance.insertVertex("E");

        instance.insertEdge("A", "B", "Edge1", 6);
        instance.insertEdge("A", "C", "Edge2", 1);
        instance.insertEdge("B", "D", "Edge3", 3);
        instance.insertEdge("C", "D", "Edge4", 4);
        instance.insertEdge("C", "E", "Edge5", 1);
        instance.insertEdge("D", "A", "Edge6", 2);
        instance.insertEdge("E", "D", "Edge7", 1);
        instance.insertEdge("E", "E", "Edge8", 1);

        int outdeg = instance.outDegree("G");
        assertTrue(outdeg == -1);

        outdeg = instance.outDegree("A");
        assertTrue(outdeg == 2);

        outdeg = instance.outDegree("B");
        assertTrue(outdeg == 1);

        outdeg = instance.outDegree("E");
        assertTrue(outdeg == 2);
    }

    /**
     * Test of inDegree method, of class Graph.
     */
    @Test
    public void testInDegree() {
        System.out.println("Test inDegree");

        instance.insertVertex("A");
        instance.insertVertex("B");
        instance.insertVertex("C");
        instance.insertVertex("D");
        instance.insertVertex("E");

        instance.insertEdge("A", "B", "Edge1", 6);
        instance.insertEdge("A", "C", "Edge2", 1);
        instance.insertEdge("B", "D", "Edge3", 3);
        instance.insertEdge("C", "D", "Edge4", 4);
        instance.insertEdge("C", "E", "Edge5", 1);
        instance.insertEdge("D", "A", "Edge6", 2);
        instance.insertEdge("E", "D", "Edge7", 1);
        instance.insertEdge("E", "E", "Edge8", 1);

        int indeg = instance.inDegree("G");
        assertTrue(indeg == -1);

        indeg = instance.inDegree("A");
        assertTrue(indeg == 1);

        indeg = instance.inDegree("D");
        assertTrue(indeg == 3);

        indeg = instance.inDegree("E");
        assertTrue(indeg == 2);
    }

    /**
     * Test of outgoingEdges method, of class Graph.
     */
    @Test
    public void testOutgoingEdges() {
        System.out.println(" Test outgoingEdges");

        instance.insertVertex("A");
        instance.insertVertex("B");
        instance.insertVertex("C");
        instance.insertVertex("D");
        instance.insertVertex("E");

        instance.insertEdge("A", "B", "Edge1", 6);
        instance.insertEdge("A", "C", "Edge2", 1);
        instance.insertEdge("B", "D", "Edge3", 3);
        instance.insertEdge("C", "D", "Edge4", 4);
        instance.insertEdge("C", "E", "Edge5", 1);
        instance.insertEdge("D", "A", "Edge6", 2);
        instance.insertEdge("E", "D", "Edge7", 1);
        instance.insertEdge("E", "E", "Edge8", 1);

        Iterator<Edge<String, String>> itEdge = instance.outgoingEdges("C").iterator();
        Edge<String, String> first = itEdge.next();
        Edge<String, String> second = itEdge.next();
        assertTrue(
                ((first.getElement().equals("Edge4") == true && second.getElement().equals("Edge5") == true)
                        || (first.getElement().equals("Edge5") == true && second.getElement().equals("Edge4") == true)));

        instance.removeEdge("E", "E");

        itEdge = instance.outgoingEdges("E").iterator();
        assertTrue((itEdge.next().getElement().equals("Edge7") == true));

        instance.removeEdge("E", "D");

        itEdge = instance.outgoingEdges("E").iterator();
        assertTrue((itEdge.hasNext() == false));

        assertTrue(instance.outgoingEdges(null) == null);
    }

    /**
     * Test of incomingEdges method, of class Graph.
     */
    @Test
    public void testIncomingEdges() {

        instance.insertVertex("A");
        instance.insertVertex("B");
        instance.insertVertex("C");
        instance.insertVertex("D");
        instance.insertVertex("E");

        instance.insertEdge("A", "B", "Edge1", 6);
        instance.insertEdge("A", "C", "Edge2", 1);
        instance.insertEdge("B", "D", "Edge3", 3);
        instance.insertEdge("C", "D", "Edge4", 4);
        instance.insertEdge("C", "E", "Edge5", 1);
        instance.insertEdge("D", "A", "Edge6", 2);
        instance.insertEdge("E", "D", "Edge7", 1);
        instance.insertEdge("E", "E", "Edge8", 1);

        Iterator<Edge<String, String>> itEdge = instance.incomingEdges("D").iterator();

        assertTrue((itEdge.next().getElement().equals("Edge3") == true));
        assertTrue((itEdge.next().getElement().equals("Edge4") == true));
        assertTrue((itEdge.next().getElement().equals("Edge7") == true));

        itEdge = instance.incomingEdges("E").iterator();

        assertTrue((itEdge.next().getElement().equals("Edge5") == true));
        assertTrue((itEdge.next().getElement().equals("Edge8") == true));

        instance.removeEdge("E", "E");

        itEdge = instance.incomingEdges("E").iterator();

        assertTrue((itEdge.next().getElement().equals("Edge5") == true));

        instance.removeEdge("C", "E");

        itEdge = instance.incomingEdges("E").iterator();
        assertTrue((itEdge.hasNext() == false));
    }

    /**
     * Test of insertVertex method, of class Graph.
     */
    @Test
    public void testInsertVertex() {
        System.out.println("Test insertVertex");

        instance.insertVertex("A");
        instance.insertVertex("B");
        instance.insertVertex("C");
        instance.insertVertex("D");
        instance.insertVertex("E");

        Iterator<String> itVert = instance.vertices().iterator();

        assertTrue((itVert.next().equals("A") == true));
        assertTrue((itVert.next().equals("B") == true));
        assertTrue((itVert.next().equals("C") == true));
        assertTrue((itVert.next().equals("D") == true));
        assertTrue((itVert.next().equals("E") == true));

        assertTrue(instance.insertVertex("A") == false);

        assertTrue(instance.insertVertex("F") == true);
    }

    /**
     * Test of insertEdge method, of class Graph.
     */
    @Test
    public void testInsertEdge() {
        System.out.println("Test insertEdge");

        assertTrue((instance.numEdges() == 0));

        instance.insertEdge("A", "B", "Edge1", 6);
        assertTrue((instance.numEdges() == 1));

        instance.insertEdge("A", "C", "Edge2", 1);
        assertTrue((instance.numEdges() == 2));

        instance.insertEdge("B", "D", "Edge3", 3);
        assertTrue((instance.numEdges() == 3));

        instance.insertEdge("C", "D", "Edge4", 4);
        assertTrue((instance.numEdges() == 4));

        instance.insertEdge("C", "E", "Edge5", 1);
        assertTrue((instance.numEdges() == 5));

        instance.insertEdge("D", "A", "Edge6", 2);
        assertTrue((instance.numEdges() == 6));

        instance.insertEdge("E", "D", "Edge7", 1);
        assertTrue((instance.numEdges() == 7));

        instance.insertEdge("E", "E", "Edge8", 1);
        assertTrue((instance.numEdges() == 8));

        Iterator<Edge<String, String>> itEd = instance.edges().iterator();

        itEd.next();
        itEd.next();
        assertTrue((itEd.next().getElement().equals("Edge3") == true));
        itEd.next();
        itEd.next();
        assertTrue((itEd.next().getElement().equals("Edge6") == true));

        assertTrue(instance.insertEdge("C", "D", "Edge4", 4) == false);

        assertTrue(instance.insertEdge("F", "G", "Edge9", 1) == true);
    }

    /**
     * Test of removeVertex method, of class Graph.
     */
    @Test
    public void testRemoveVertex() {
        System.out.println("Test removeVertex");

        instance.insertVertex("A");
        instance.insertVertex("B");
        instance.insertVertex("C");
        instance.insertVertex("D");
        instance.insertVertex("E");

        instance.removeVertex("C");
        assertTrue((instance.numVertices() == 4));

        Iterator<String> itVert = instance.vertices().iterator();
        assertTrue((itVert.next().equals("A") == true));
        assertTrue((itVert.next().equals("B") == true));
        assertTrue((itVert.next().equals("D") == true));
        assertTrue((itVert.next().equals("E") == true));

        instance.removeVertex("A");
        assertTrue((instance.numVertices() == 3));

        itVert = instance.vertices().iterator();
        assertTrue((itVert.next().equals("B") == true));
        assertTrue((itVert.next().equals("D") == true));
        assertTrue((itVert.next().equals("E") == true));

        instance.removeVertex("E");
        assertTrue((instance.numVertices() == 2));

        itVert = instance.vertices().iterator();

        assertTrue(itVert.next().equals("B") == true);
        assertTrue(itVert.next().equals("D") == true);

        instance.removeVertex("B");
        instance.removeVertex("D");
        assertTrue((instance.numVertices() == 0));

        assertTrue(instance.removeVertex("F") == false);

        instance.insertVertex("A");
        assertTrue(instance.removeVertex("A") == true);

        instance.insertVertex("A");
        instance.insertVertex("B");
        int key = 0;
        instance.removeVertex("A");
        assertTrue(instance.getKey("B") == key);

    }

    /**
     * Test of removeEdge method, of class Graph.
     */
    @Test
    public void testRemoveEdge() {
        System.out.println("Test removeEdge");

        assertTrue((instance.numEdges() == 0));

        instance.insertEdge("A", "B", "Edge1", 6);
        instance.insertEdge("A", "C", "Edge2", 1);
        instance.insertEdge("B", "D", "Edge3", 3);
        instance.insertEdge("C", "D", "Edge4", 4);
        instance.insertEdge("C", "E", "Edge5", 1);
        instance.insertEdge("D", "A", "Edge6", 2);
        instance.insertEdge("E", "D", "Edge7", 1);
        instance.insertEdge("E", "E", "Edge8", 1);

        assertTrue((instance.numEdges() == 8));

        instance.removeEdge("E", "E");
        assertTrue((instance.numEdges() == 7));

        Iterator<Edge<String, String>> itEd = instance.edges().iterator();

        itEd.next();
        itEd.next();
        assertTrue((itEd.next().getElement().equals("Edge3") == true));
        itEd.next();
        itEd.next();
        assertTrue((itEd.next().getElement().equals("Edge6") == true));

        instance.removeEdge("C", "D");
        assertTrue((instance.numEdges() == 6));

        itEd = instance.edges().iterator();
        itEd.next();
        itEd.next();
        assertTrue((itEd.next().getElement().equals("Edge3") == true));
        assertTrue((itEd.next().getElement().equals("Edge5") == true));
        assertTrue((itEd.next().getElement().equals("Edge6") == true));
        assertTrue((itEd.next().getElement().equals("Edge7") == true));

        assertTrue(instance.removeEdge("F", "F") == false);

        Vertex<String, String> vert1 = new Vertex(11, "W");
        Vertex<String, String> vert2 = new Vertex(12, "Z");
        instance.insertVertex("W");
        instance.insertVertex("Z");
        Edge<String, String> edge2 = new Edge("df", 1, vert1, vert2);
        assertTrue(instance.removeEdge("W", "Z") == false);

        instance1.insertVertex("A");
        instance1.insertVertex("B");
        instance1.insertEdge("A", "B", "df", 1);
        instance1.insertEdge("B", "A", "dfq", 1);
        assertTrue(instance1.removeEdge("A", "B") == true);

    }

    /**
     * Test of toString method, of class Graph.
     */
    @Test
    public void testClone() {
        System.out.println("Test Clone");

        instance.insertEdge("A", "B", "Edge1", 6);
        instance.insertEdge("A", "C", "Edge2", 1);
        instance.insertEdge("B", "D", "Edge3", 3);
        instance.insertEdge("C", "D", "Edge4", 4);
        instance.insertEdge("C", "E", "Edge5", 1);
        instance.insertEdge("D", "A", "Edge6", 2);
        instance.insertEdge("E", "D", "Edge7", 1);
        instance.insertEdge("E", "E", "Edge8", 1);

        Graph<String, String> instClone = instance.clone();

        assertTrue(instance.numVertices() == instClone.numVertices());
        assertTrue(instance.numEdges() == instClone.numEdges());

        //vertices should be equal
        Iterator<String> itvertClone = instClone.vertices().iterator();
        Iterator<String> itvertSource = instance.vertices().iterator();
        while (itvertSource.hasNext()) {
            assertTrue((itvertSource.next().equals(itvertClone.next()) == true));
        }
    }

    @Test
    public void testEquals() {
        System.out.println("Test Equals");

        instance.insertEdge("A", "B", "Edge1", 6);
        instance.insertEdge("A", "C", "Edge2", 1);
        instance.insertEdge("B", "D", "Edge3", 3);
        instance.insertEdge("C", "D", "Edge4", 4);
        instance.insertEdge("C", "E", "Edge5", 1);
        instance.insertEdge("D", "A", "Edge6", 2);
        instance.insertEdge("E", "D", "Edge7", 1);
        instance.insertEdge("E", "E", "Edge8", 1);

        assertFalse(instance.equals(null));

        assertTrue(instance.equals(instance));

        assertTrue(instance.equals(instance.clone()));

        Graph<String, String> other = instance.clone();

        other.removeEdge("E", "E");
        assertFalse(instance.equals(other));

        other.insertEdge("E", "E", "Edge8", 1);
        assertTrue(instance.equals(other));

        other.removeVertex("D");
        assertFalse(instance.equals(other));

        Graph<String, String> instance2 = new Graph<>(true);

        instance2.insertEdge("A", "K", "Edge9", 1);
        instance2.insertEdge("A", "C", "Edge9", 1);
        instance2.insertEdge("K", "V", "Edge9", 1);
        instance2.insertEdge("C", "V", "Edge9", 1);
        instance2.insertEdge("C", "N", "Edge9", 1);
        instance2.insertEdge("V", "A", "Edge9", 1);
        instance2.insertEdge("N", "V", "Edge9", 1);
        instance2.insertEdge("N", "N", "Edge9", 1);
        assertFalse(instance2.equals(instance));

    }

    /**
     * Test of toString method, of class Graph.
     */
    @Test
    public void testToString() {

        System.out.println(instance);

        instance.insertEdge("A", "K", "Edge9", 1);

        String output = "Graph: 2 vertices, 1 edges\nA (0): \n      (Edge9) - 1.0 - K\n\nK (1): \n\n";

        assertTrue(output.equals(instance.toString()));

    }
}
