package dynamicProgrammingTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import dynamicProgramming.MaxSumRectangle;

public class MaxSumrectangleTest {
    MaxSumRectangle instance;
    int[][] matrix = new int[][] {
            { 1, 2, -1, -4, -20 },
            { -8, -3, 4, 2, 1 },
            { 3, 8, 10, 1, 3 },
            { -4, -1, 1, 7, -6 }
    };

    @Before
    public void setUp() {
        instance = new MaxSumRectangle();
    }

    @Test
    public void testMaxSumRectangle() {
        System.out.println("MaxSumRectangle: Testing max sum rectangle");
        int expectedResult = 29;
        Assert.assertEquals(expectedResult, instance.calculateMaxSum(matrix));
    }
}
