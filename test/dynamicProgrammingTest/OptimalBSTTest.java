package dynamicProgrammingTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import dynamicProgramming.OptimalBST;

public class OptimalBSTTest {
    OptimalBST instance;
    int[] frequency = {34, 8, 50};
    int[] keys = {10, 12, 20};

    public OptimalBSTTest() {
    }

    @Before
    public void setUp() {
        instance = new OptimalBST();
    }

    @Test
    public void testCreateMatrix() {
        System.out.println("OptimalBST: Testing optimal BST recursive");
        int expectedResult = 142;
        Assert.assertEquals(expectedResult, instance.optimalCost(frequency, 0, frequency.length - 1));
//        instance.optimalCostDp(frequency);
    }

    @Test
    public void testCreateMatrixDp() {
        System.out.println("OptimalBST: Testing optimal BST dp");
        int expectedResult = 142;
        Assert.assertEquals(expectedResult, instance.optimalCostDp(frequency));
    }

    @Test
    public void testNumberOfBst() {
        System.out.println("OptimalBST: Testing number of unique bst");
        int expectedResult = 42;
        Assert.assertEquals(expectedResult, instance.noOfBst(5));
    }

    @Test
    public void testNumberOfBstDp() {
        System.out.println("OptimalBST: Testing number of unique bst dp");
        int expectedResult = 42;
        Assert.assertEquals(expectedResult, instance.noOfBstDp(5));
    }
}
