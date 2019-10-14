import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)

public class DAGTest {

    @Test
    public void graph1() {

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


        }
    }
}
