import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)

public class LCATest {

    @Test
    public void tree1() {

        /*
                    3
                  /   \
                2       7
              /  \     /  \
             3    6   5    8
         */

        LCA tree = new LCA();

        tree.root = new Node(3);

        //left subtree
        tree.root.left = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(6);

        //right subtree
        tree.root.right = new Node(7);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(8);

        Node result = tree.findLCA(5, 8);
        assertEquals(7, result.data);

        result = tree.findLCA(7, 2);
        assertEquals(3, result.data);
        
        result = tree.findLCA(6, 8);
        assertEquals(3, result.data);

    }

    @Test
    public void tree2() {

        /*
                   2
                /      \
               5        9
             /  \      / \
            6    3    8   10
           / \
          4   7

         */

        LCA tree = new LCA();

        tree.root = new Node(2);

        //left subtree
        tree.root.left = new Node(5);
        tree.root.left.left = new Node(6);
        tree.root.left.right = new Node(3);

        //right subtree
        tree.root.right = new Node(9);
        tree.root.right.left = new Node(8);
        tree.root.right.right = new Node(10);

        //left left subtree
        tree.root.left.left.left = new Node(4);
        tree.root.left.left.right = new Node(7);

        Node result = tree.findLCA(4,7);
        assertEquals(6, result.data);
        result = tree.findLCA(6, 3);
        assertEquals(5, result.data);
        result = tree.findLCA(8, 10);
        assertEquals(9, result.data);
        result = tree.findLCA(4, 3);
        assertEquals(5, result.data);
        result = tree.findLCA(7, 9);
        assertEquals(2, result.data);
        result = tree.findLCA(4, 8);
        assertEquals(2, result.data);
        result = tree.findLCA(7, 10);
        assertEquals(2, result.data);

    }

    @Test
    public void tree3() {
        /*
                                6
                             /     \
                          9          4
                       /     \     /   \
                     3       2    11     7
                                        /   \
                                      5      12
                                    /  \
                                   13   8
         */

        LCA tree = new LCA();
        tree.root = new Node(6);

        //left subtree
        tree.root.left = new Node(9);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(2);

        //right subtree
        tree.root.right = new Node(4);
        tree.root.right.left = new Node(11);
        tree.root.right.right = new Node(7);

        //right right subtree
        tree.root.right.right.left = new Node(5);
        tree.root.right.right.right = new Node(12);

        //right right left subtree
        tree.root.right.right.left.left = new Node(13);
        tree.root.right.right.left.right = new Node(8);

        Node result = tree.findLCA(3 , 2);
        assertEquals(9, result.data);

        result = tree.findLCA(11, 7);
        assertEquals(4, result.data);

        result = tree.findLCA(13, 8);
        assertEquals(5, result.data);

        result = tree.findLCA(5, 12);
        assertEquals(7, result.data);

        result = tree.findLCA(3 , 4);
        assertEquals(6, result.data);

        result = tree.findLCA(13, 12);
        assertEquals(7, result.data);

        result = tree.findLCA(8, 11);
        assertEquals(4, result.data);

        result = tree.findLCA(3, 8);
        assertEquals(6, result.data);

    }

}
