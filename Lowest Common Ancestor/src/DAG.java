import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DAG {

    public static final int UNVISITED = 0, IN_PROGRESS = 1, VISITED = 2;

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
        Arrays.fill(vertices, UNVISITED);

        for(int v = 0; v < table.length; v++) {
            if (containsCycle(v, vertices)) {
                return true;
            }
        }

        return false;

    }

    public boolean containsCycle(int vertex, int [] vertices) {
        switch(vertices[vertex]) {
            case IN_PROGRESS:
                return true;
            case VISITED:
                return false;
            case UNVISITED:
                vertices[vertex] = IN_PROGRESS;
        }

        ArrayList<Integer> list = table[vertex];
        for (int v : list) {
            if (containsCycle(v, vertices)) {
                return true;
            }
        }
        vertices[vertex] = VISITED;
        return false;
    }

    public ArrayList<Integer> lowestCommonAncestors(int v1, int v2) {

        ArrayList<Integer> lowestCommonAncestors = new ArrayList<>();
        if (v1 == v2) {
            lowestCommonAncestors.add(v1);
            return lowestCommonAncestors;
        }
        if(v1 < 0 || v1 >= table.length || v2 < 0 || v2 >= table.length) {
            return null;
        }

        ArrayList<Integer>[] parentTable = reverse(table);

        boolean[] v1Ancestors = new boolean[table.length];
        Arrays.fill(v1Ancestors, false);

        v1Ancestors[v1] = true;
        for(int v : parentTable[v1]) {
            markAncestors(parentTable, v1Ancestors, v);
        }

        Queue<Integer> currentLevel = new LinkedList<>();
        Queue<Integer> nextLevel = new LinkedList<>();

        for(int v : parentTable[v2]) {
            currentLevel.add(v);
        }

        while(!currentLevel.isEmpty()) {
            while(!currentLevel.isEmpty()) {
                int v = currentLevel.remove();

                if(v1Ancestors[v]) {
                    lowestCommonAncestors.add(v);
                }

                if(lowestCommonAncestors.isEmpty()) {
                    for (int w : parentTable[v]) {
                        nextLevel.add(w);
                    }
                }
            }
            currentLevel = nextLevel;
            nextLevel = new LinkedList<>();
        }
        return lowestCommonAncestors;
    }

    public void markAncestors(ArrayList<Integer>[] parentTable, boolean[] v1Ancestors, int vertex) {
        v1Ancestors[vertex] = true;

        for(int v : parentTable[vertex]) {
            markAncestors(parentTable, v1Ancestors, v);
        }
    }

    public ArrayList<Integer>[] reverse(ArrayList<Integer>[] table) {

        ArrayList<Integer>[] reversed = (ArrayList<Integer>[]) new ArrayList[table.length];

        for(int i = 0; i < reversed.length; i++) {
            reversed[i] = new ArrayList<>();
        }

        for(int v = 0; v < table.length; v++) {
            for(int w : table[v]) {
                addEdge(reversed, w, v);
            }
        }

        return reversed;
    }
    public String toString() {
        return toString(table);
    }

    public String toString(ArrayList<Integer>[] table) {
        String string = "";
        for(int v = 0; v < table.length; v++) {
            string += v + ": ";
            for(int vertex : table[v]) {
                string += vertex + " ";
            }
            string += "\n";
        }
        return string;
    }

}
