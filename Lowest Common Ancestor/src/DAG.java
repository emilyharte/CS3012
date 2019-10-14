import java.util.ArrayList;

public class DAG {

    public ArrayList<Integer>[] table; //adjacency table

    public DAG(int num) {

        table = (ArrayList<Integer>[]) new ArrayList[num];
        for (int i = 0; i < num; i++) {
            table[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w) {

        if (v >= 0 && v < table.length && w >= 0 && w < table.length) {
            addEdge(table, v, w);
        }
    }

    public void addEdge(ArrayList<Integer>[] table, int v, int w) {
        ArrayList<Integer> list = table[v];
        if(!list.contains(w)); {
            list.add(w);
        }
        if(containsCycle()) {
            for(int i =0; i < list.size(); i++) {
                if(list.get(i) == w) {
                    list.remove(i);
                }
            }
        }
    }

    public boolean containsCycle() {

        int[] vertices = new int[table.length];

        return false;

    }

}
