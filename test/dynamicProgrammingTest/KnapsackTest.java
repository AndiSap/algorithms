package dynamicProgrammingTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import dynamicProgramming.Knapsack;

public class KnapsackTest {
    Knapsack instance;
    int[] weight = {3, 5, 5, 1, 4};
    int[] profit = {4, 6, 5, 3, 5};
    int capacity = 10;

    public KnapsackTest() {
    }

    @Before
    public void setUp() {
        instance = new Knapsack();
    }

    @Test
    public void testCalculate01Knapsack() {
        System.out.println("Knapsack: Testing 0-1 knapsack resursive");
        Assert.assertEquals(14, instance.calculate01Knapsack(weight, profit, weight.length - 1, capacity));
    }

    @Test
    public void testCreateMatrix() {
        System.out.println("Knapsack: Testing 0-1 knapsack dp");
        Assert.assertEquals(14, instance.createMatrix(weight, profit, capacity)[weight.length][capacity]);
        instance.printUsedElements(instance.createMatrix(weight, profit, capacity), weight.length, capacity, weight);
    }
}
