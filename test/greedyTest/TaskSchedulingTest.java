package greedyTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import greedy.TaskScheduling;

import java.util.Arrays;


public class TaskSchedulingTest {
    TaskScheduling instance;
    int[] start = new int[] {2, 1, 2, 4, 4, 6, 5, 7, 7, 8};
    int[] finish = new int[] {4, 4, 7, 8, 9, 8, 10, 9, 10, 11};

    int[] deadlines = {4, 3, 1, 4, 3, 1, 4, 6, 8, 2, 7};
    int[] profits = {40, 50, 20, 30, 50, 30, 40, 10, 60, 20, 50};

    public TaskSchedulingTest() {
    }

    @Before
    public void setUp() {
        instance = new TaskScheduling();
    }

    @Test
    public void testTaskScheduling() {
        System.out.println("TaskScheduling: Testing schedule");
        int[] exptectedResult = {2, 4, 10};
        Assert.assertEquals(Arrays.toString(exptectedResult), Arrays.toString(instance.schedule(start, finish)));
    }

    @Test
    public void testTaskSchedulingWithDeadlines() {
        System.out.println("TaskScheduling: Testing schedule with deadlines O(n*n)");
        int[] exptectedResult = {7, 5, 2, 1, 0, 8, 11, 9, 0, 0, 0};
        Assert.assertEquals(Arrays.toString(exptectedResult), Arrays.toString(instance.scheduleWithTime(deadlines, profits)));
    }

    @Test
    public void testTaskSchedulingWithDeadlinesFast() {
        System.out.println("TaskScheduling: Testing schedule with deadlines O(nlogn)");
        int[] exptectedResult = {7, 5, 2, 1, 0, 8, 11, 9, 0, 0, 0};
        Assert.assertEquals(Arrays.toString(exptectedResult), Arrays.toString(instance.scheduleWithDeadlines(deadlines, profits)));
    }

}
