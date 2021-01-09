package dynamicProgrammingTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import dynamicProgramming.MaxSubsetSum;

public class MaxSubsetSumTest {
    MaxSubsetSum instance;
    int[] elements = {-2, -1, -3, 4, -1, 2, 1, -5, 4};
    int[] elementsNegative = {-8, -12, -3, -4, -6, -2, -4, -5, -4};

    public MaxSubsetSumTest() {
    }

    @Before
    public void setUp() {
        instance = new MaxSubsetSum();
    }

    @Test
    public void testMaxSubset() {
        System.out.println("MaxSubsetSum: Testing max subset sum kadane");
        int exptectedResult = 6;
        Assert.assertEquals(exptectedResult, instance.maxSubsetSum(elements));
    }

    @Test
    public void testMaxSubsetNegative() {
        System.out.println("MaxSubsetSum: Testing max subset sum kadane with only negative");
        int exptectedResult = -2;
        Assert.assertEquals(exptectedResult, instance.maxSubsetSum(elementsNegative));
    }

}
