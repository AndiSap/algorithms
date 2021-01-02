package greedyTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import greedy.FractorialKnapsack;

import java.util.Arrays;


public class FractorialKnapsackTest {
    FractorialKnapsack instance;
    int[] goods = new int[] {1, 2, 3, 4, 5};
    int[] weights = new int[] {3, 5, 5, 1, 4};
    int[] profit = new int[] {4, 6, 5, 3, 5};
    int M = 10;

    int[] go = {1, 2, 3, 4};
    int[] wt = { 10, 40, 20, 30 };
    int[] val = { 60, 40, 100, 120 };
    int capacity = 50;

    public FractorialKnapsackTest() {
    }

    @Before
    public void setUp() {
        instance = new FractorialKnapsack();
    }

    @Test
    public void testFractorialKnapsack() {
        System.out.println("FractorialKnapsack: Testing calculate knapsack");
        double[] exptectedResult = new double[] {1., .4, 0, 1., 1.};
        double[] exptectedResult2 = new double[] {1., 0., 1., .6666666666666666};
        Assert.assertEquals(Arrays.toString(exptectedResult), Arrays.toString(instance.calculateKnapsack(goods, weights, profit, M)));
        Assert.assertEquals(Arrays.toString(exptectedResult2), Arrays.toString(instance.calculateKnapsack(go, wt, val, capacity)));
    }

}
