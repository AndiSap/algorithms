package dynamicProgrammingTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import dynamicProgramming.kSubsetSum;

public class kSubsetSumTest {
    kSubsetSum instance;
    int[] elements = {3, 34, 4, 12, 5, 2};

    public kSubsetSumTest() {
    }

    @Before
    public void setUp() {
        instance = new kSubsetSum();
    }

    @Test
    public void testKSubsetsum() {
        System.out.println("kSubsetSum: Testing k subset sum recursive");
        Assert.assertTrue(instance.isKSubset(elements, elements.length - 1, 9));
        Assert.assertFalse(instance.isKSubset(elements, elements.length - 1, 30));
        instance.createMatrix(elements, 9);
    }
}
