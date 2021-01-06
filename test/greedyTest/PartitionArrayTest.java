package greedyTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import greedy.PartitionArray;

import java.util.Arrays;


public class PartitionArrayTest {
    PartitionArray instance;

    public PartitionArrayTest() {
    }

    @Before
    public void setUp() {
        instance = new PartitionArray();

    }

    @Test
    public void testMaxSum() {
        System.out.println("PartitionArray: Testing partition array into 2 equal subarrays");
        int[] input = {1, 4, 6, 7, 8, 9, 12, 19};
        int[] input2 = {8, 4, 12, 7, 1, 19, 6, 9};

        instance.partitionArrayEqually(input);
        instance.paritionArray(input2);
        instance.getPartitionElements(input2);
    }

    @Test
    public void testisSubsetSum() {
        System.out.println("PartitionArray: Testing is subset sum");
        int[] input = { 3, 1, 5, 9, 12 };
        Assert.assertTrue(instance.canPartition(input));
        instance.getPartitionElements(input);
    }
}
