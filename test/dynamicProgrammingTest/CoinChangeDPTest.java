package dynamicProgrammingTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import dynamicProgramming.CoinChange;

public class CoinChangeDPTest {
    CoinChange instance;
    int[] change = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
    int amount = 121;

    public CoinChangeDPTest() {
    }

    @Before
    public void setUp() {
        instance = new CoinChange();
    }

    @Test
    public void testCoinChange() {
        System.out.println("CoinChange: Testing change recursive");
        int[] exptectedResult = {100, 20, 1};
        Assert.assertEquals(exptectedResult.length, instance.calculateChange(change, amount, change.length - 1));

        int[] exptectedResult2 = {100, 100, 50, 20, 10, 2, 1};
        Assert.assertEquals(exptectedResult2.length, instance.calculateChange(change, 283, change.length - 1));
    }

    @Test
    public void testChange() {
        System.out.println("CoinChange: Testing # of change recursive");
        int[] changeNo  = {1, 2, 3};
        int amountNo = 4;
        Assert.assertEquals(4, instance.change(changeNo, amountNo, changeNo.length - 1));

        instance.changeDp(changeNo, amountNo);
    }
}
