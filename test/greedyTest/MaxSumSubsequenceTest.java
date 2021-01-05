package greedyTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import greedy.MaxSumSubsequence;

import java.util.Arrays;


public class MaxSumSubsequenceTest {
    MaxSumSubsequence instance;

    public MaxSumSubsequenceTest() {
    }

    @Before
    public void setUp() {
        instance = new MaxSumSubsequence();

    }

    @Test
    public void testMaxSum() {
        System.out.println("MaxSumSubsequence: Testing max sum subsequence");
        int expectedResult = 11;
        int[] input = { 2, -4, 1, 9, -6, 7, -3 };

        Assert.assertEquals(expectedResult, instance.findMaxSumSub(input, 0, input.length - 1));
    }
}
