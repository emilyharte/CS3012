import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)

public class DAGTest {


    @Test
    public void testConstructor(){
        DAG graph = new DAG(10);

        graph.addEdge(2, 3); //adding directed edge from vertex 2 to vertex 3
        graph.addEdge(2, 4); //adding directed edge from vertex 2 to vertex 4
        graph.addEdge(4,5); //adding directed edge from vertex 4 to vertex 5
        graph.addEdge(7,6); //adding directed edge from vertex 7 to vertex 6
        graph.addEdge(9, 1); //adding directed edge from vertex 9 to vertex 1

        //test amount of edges and vertices
        assertEquals(5, graph.getEdges());
        assertEquals(10, graph.getVertices());

        //test adjacency table
        String target = "[3, 4]";
        assertEquals(target, graph.table[2].toString());
    }

    @Test
    public void testAddEdge() {

        DAG graph = new DAG(10);

        graph.addEdge(3,7);
        graph.addEdge(6, 8);
        graph.addEdge(4,3);

        //this edge will not be added as it will create a cycle
        graph.addEdge(7,4);

        graph.addEdge(6, 5);

        //this edge will not be added as 11 is greater than 10
        graph.addEdge(8, 11);

        assertEquals(4, graph.getEdges());
    }

    @Test
    public void testLCA1() {

        DAG graph = new DAG(13);

        graph.addEdge(1, 2); //adding directed edge from vertex 1 to vertex 2
        graph.addEdge(1, 3); //adding directed edge from vertex 1 to vertex 3

        //left subgraph
        graph.addEdge(2, 4); //adding directed edge from vertex 2 to vertex 4
        graph.addEdge(4, 6); //adding directed edge from vertex 4 to vertex 6

        //right subgraph
        graph.addEdge(3, 5); //adding directed edge from vertex 3 to vertex 5
        graph.addEdge(5, 7); //adding directed edge from vertex 5 to vertex 7
        graph.addEdge(5, 8); //adding directed edge from vertex 5 to vertex 8

        //left right subgraph
        graph.addEdge(7, 10); //adding directed edge from vertex 7 to vertex 10
        graph.addEdge(10, 9); //adding directed edge from vertex 10 to vertex 9
        graph.addEdge(10, 13); //adding directed edge from vertex 10 to vertex 13
        graph.addEdge(10, 11); //adding directed edge from vertex 10 to vertex 11

        //very right subgraph
        graph.addEdge(11, 12); //adding directed edge from vertex 10 to vertex11

        //find LCA
        ArrayList<Integer> lca = graph.lowestCommonAncestors(8, 9);
        String target = "[5]";
        assertEquals(target, lca.toString());

        lca = graph.lowestCommonAncestors(9, 12);
        target = "[10]";
        assertEquals(target, lca.toString());

        lca = graph.lowestCommonAncestors(6, 12);
        target = "[1]";
        assertEquals(target, lca.toString());

        lca = graph.lowestCommonAncestors(4, 8);
        target = "[1]";
        assertEquals(target, lca.toString());


    }

}

