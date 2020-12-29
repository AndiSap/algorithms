package treesTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import trees.BST;

public class BSTTest {
    BST instance;
    BST.Node root;
    BST.Node expectedSearchResult;

    public BSTTest() {
    }

    /**
     * Tree setup:
     *          8
     *        /   \
     *       3    10
     *     /  \     \
     *    1    6     14
     *       /  \    /
     *      5    7  12
     */
    @Before
    public void setUp() {
        instance = new BST();
        root = new BST.Node(8);
        BST.Node secondLeft = new BST.Node(3);
        BST.Node leftThirdLeft = new BST.Node(1);
        BST.Node leftThirdRight = new BST.Node(6);
        leftThirdRight.left = new BST.Node(5);
        leftThirdRight.right = new BST.Node(7);
        secondLeft.right = leftThirdRight;
        secondLeft.left = leftThirdLeft;
        root.left = secondLeft;

        BST.Node secondRight = new BST.Node(10);
        BST.Node rightthirdRight = new BST.Node(14);
        rightthirdRight.left = new BST.Node(12);
        secondRight.right = rightthirdRight;
        root.right = secondRight;

        expectedSearchResult = leftThirdRight;
    }

    @Test
    public void testInsertKey() {
        System.out.println("BST: Testing search");
        Assert.assertEquals(expectedSearchResult, instance.search(root, 6));
    }

    @Test
    public void testInsert() {
        System.out.println("BST: Testing insertion");
        Integer[] expectedResult = new Integer[]{1, 3, 5, 6, 7, 8, 10, 12, 14};
        instance.insert(8);
        instance.insert(3);
        instance.insert(1);
        instance.insert(6);
        instance.insert(5);
        instance.insert(7);
        instance.insert(10);
        instance.insert(14);
        instance.insert(12);
        Assert.assertArrayEquals(expectedResult, instance.inorder());
    }

    @Test
    public void testDelete() {
        System.out.println("BST: Testing deletion");
        Integer[] expectedResult = new Integer[]{1, 3, 5, 6, 7, 10, 12, 14};
        instance.insert(8);
        instance.insert(3);
        instance.insert(1);
        instance.insert(6);
        instance.insert(5);
        instance.insert(7);
        instance.insert(10);
        instance.insert(14);
        instance.insert(12);
        instance.delete(8);
        Assert.assertArrayEquals(expectedResult, instance.inorder());
        Assert.assertEquals(10, instance.root.key);
    }
}
