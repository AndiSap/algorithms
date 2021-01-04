package greedyTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import greedy.CoinChange;

import java.util.Arrays;

public class CoinChangeTest {
    CoinChange instance;
    int[] change = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
    int amount = 121;

    public CoinChangeTest() {
    }

    @Before
    public void setUp() {
        instance = new CoinChange();
    }

    @Test
    public void testRefuel() {
        System.out.println("CoinChange: Testing change");
        int[] exptectedResult = {100, 20, 1};
        Assert.assertEquals(Arrays.toString(exptectedResult), instance.calculateChange(change, amount).toString());

        int[] exptectedResult2 = {100, 100, 50, 20, 10, 2, 1};
        Assert.assertEquals(Arrays.toString(exptectedResult2), instance.calculateChange(change, 283).toString());
    }
}
