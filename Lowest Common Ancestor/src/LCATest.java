import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)

public class LCATest {

    @Test
    public void emptyTree() {
        LCA tree = new LCA();
        Node result = tree.findLCA(tree.root.left.data, tree.root.right.data);
        assertEquals(null, result);
    }

    @Test
    public void tree1() {
        LCA tree = new LCA();
        tree.root = new Node(3);
        tree.root.left = new Node(2);
        tree.root.right = new Node(7);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(8);

        Node result = tree.findLCA(5, 8);
        assertEquals(7, result.data);
        result = tree.findLCA(2, 7);
        assertEquals(3, result.data);
        result = tree.findLCA(3, 6);
    }


}
