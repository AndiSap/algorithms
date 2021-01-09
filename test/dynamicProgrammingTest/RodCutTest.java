package dynamicProgrammingTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import dynamicProgramming.RodCut;

public class RodCutTest {
    RodCut instance;
    int[] profits = {1, 5, 8, 9, 10, 17, 17, 20};

    public RodCutTest() {
    }

    @Before
    public void setUp() {
        instance = new RodCut();
    }

    @Test
    public void testCoinChange() {
        System.out.println("RodCut: Testing rod cut recursive");
        int exptectedResult = 22;
        Assert.assertEquals(exptectedResult, instance.calculateProfit(profits, profits.length));
    }

    @Test
    public void testCoinChangeDp() {
        System.out.println("RodCut: Testing rod cut dp");
        int exptectedResult = 22;
        Assert.assertEquals(exptectedResult, instance.createMatrix(profits, profits.length));
    }
}
