package greedyTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import greedy.MinPositiveSumSubsequence;

import java.util.Arrays;


public class MinPositiveSumSubsequenceTest {
    MinPositiveSumSubsequence instance;

    public MinPositiveSumSubsequenceTest() {
    }

    @Before
    public void setUp() {
        instance = new MinPositiveSumSubsequence();

    }

    @Test
    public void testMaxSum() {
        System.out.println("MinPositiveSumSubsequence: Testing min positive sum subsequence");
        int expectedResult = 9;
        int[] input = {-34, 49, -58, 76, 29, -71, -54, 63};
        int[] input2 = {5,-4,3,5,4};

        Assert.assertEquals(expectedResult, instance.findMinPosSumSub(input, 0, input.length - 1));
        Assert.assertEquals(1, instance.findMinPosSumSub(input2, 0, input2.length - 1));
    }
}
