import java.util.ArrayList;

public class DAG {

    public ArrayList<Integer>[] table; //adjacency table

    public DAG(int num) {

        table = (ArrayList<Integer>[]) new ArrayList[num];
        for (int i = 0; i < num; i++) {
            table[i] = new ArrayList<>();
        }
    }

}
