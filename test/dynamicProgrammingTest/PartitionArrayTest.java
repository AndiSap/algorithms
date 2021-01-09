package dynamicProgrammingTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import dynamicProgramming.PartitionArray;

public class PartitionArrayTest {
    PartitionArray instance;
    int[] elementsT = { 3, 1, 5, 9, 12 };
    int[] elementsF = { 1, 5, 9, 12 };

    public PartitionArrayTest() {
    }

    @Before
    public void setUp() {
        instance = new PartitionArray();
    }

    @Test
    public void testCanPartition() {
        System.out.println("PartitionArray: Testing can partition recursive");
        Assert.assertTrue(instance.canPartition(elementsT));
        Assert.assertFalse(instance.canPartition(elementsF));
    }

    @Test
    public void testCanPartitionDp() {
        System.out.println("PartitionArray: Testing can partition dp");
        Assert.assertTrue(instance.partitionDp(elementsT));
        Assert.assertFalse(instance.partitionDp(elementsF));
    }
}
