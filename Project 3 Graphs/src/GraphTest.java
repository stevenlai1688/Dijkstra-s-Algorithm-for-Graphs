// --== CS400 File Header Information ==--
// Name: Steven Lai
// Email: sylai2@wisc.edu
// Team: HG
// TA: Hang Yin
// Lecturer: Gary Dahl
// Notes to Grader: 
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests the implementation of CS400Graph for the individual component of
 * Project Three: the implementation of Dijsktra's Shortest Path algorithm.
 */
public class GraphTest {

    private CS400Graph<String> graph;
    
    /**
     * Instantiate graph from last week's shortest path activity.
     */
    @BeforeEach
    public void createGraph() {
        graph = new CS400Graph<>();
        // insert vertices A-E
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        // insert edges from Week 09. Dijkstra's Activity
        graph.insertEdge("A","B",2);
        graph.insertEdge("A","D",4);
        graph.insertEdge("A","E",1);
        graph.insertEdge("B","C",5);
        graph.insertEdge("C","A",3);
        graph.insertEdge("D","B",3);
        graph.insertEdge("D","C",7);
        graph.insertEdge("D","E",1);
        graph.insertEdge("E","C",8);
    }

    /**
     * Checks the distance/total weight cost from the vertex labelled C to E
     * (should be 4), and from the vertex labelled A to C (should be 7).
     */
    @Test
    public void providedTestToCheckPathCosts() {
        assertTrue(graph.getPathCost("C", "E") == 4);    
        assertTrue(graph.getPathCost("A", "C") == 7);
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * labelled C to E, and from the vertex labelled A to C.
     */
    @Test
    public void providedTestToCheckPathContents() {
        // check that the paths taken are correct
        assertTrue(graph.shortestPath("C", "E").toString().equals(
            "[C, A, E]"
        ));
        assertTrue(graph.shortestPath("A", "C").toString().equals(
            "[A, B, C]"
        ));
    }
    /**
     * Checks that last week's Dijkstra Activity returns the correct results
     */
    @Test
    public void providedTestToCheckDijkstrasActivity() {
      // check additional paths
      assertTrue(graph.shortestPath("C", "D").toString().equals(
          "[C, A, D]"
          ));
      assertTrue(graph.shortestPath("C", "A").toString().equals(
          "[C, A]"
          ));
      
    }
    /**
     * Checks the longest path is correct
     */
    @Test
    public void providedTestToCheckLongestPath() {
      assertTrue(graph.getPathCost("C", "D") == 7);
    }
    /**
     * Checks to make sure that shorter path of the two possible path is selected
     */
    @Test
    public void providedTestToCheckShortestPathOfTheTwo() {
      // ensure that the output is not the incorrect one "[C, A, D, B]"
      assertTrue(graph.shortestPath("C", "B").toString().equals(
          "[C, A, B]"
          ));
    }
    /**
     * Checks to make sure that shorter weight of the two possible path is selected
     */
    @Test
    public void providedTestToCheckShortestWeightOfTheTwo() {
      // check that shorter weight of the two is selected, instead of other paths
      assertTrue(graph.getPathCost("C", "B") == 5);
    }
}