package dynamicProgrammingTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import dynamicProgramming.TaskScheduling;

public class TaskSchedulingTest {
    TaskScheduling instance;
    int[] start = new int[] {1, 3, 6, 2};
    int[] finish = new int[] {2, 5, 19, 100};
    int[] profits = {50, 20, 100, 200};

    public TaskSchedulingTest() {
    }

    @Before
    public void setUp() {
        instance = new TaskScheduling();
    }

    @Test
    public void testTaskScheduling() {
        System.out.println("TaskScheduling DP: Testing schedule recursive");
        int exptectedResult = 250;
        Assert.assertEquals(exptectedResult, instance.calculateMaxProfit(start, finish, profits));
    }

    @Test
    public void testTaskSchedulingDp() {
        System.out.println("TTaskScheduling DP: Testing schedule using dp");
        int exptectedResult = 250;
        Assert.assertEquals(exptectedResult, instance.calculateMaxProfitDp(start, finish, profits));
    }

}
