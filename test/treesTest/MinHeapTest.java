package sortingTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import trees.MinHeap;

import java.util.Arrays;

public class MinHeapTest {
    MinHeap instance;

    public MinHeapTest() {
//        instance = new MinHeap(11);
    }

    @Before
    public void setUp() {
        instance = new MinHeap(11);
    }

    @Test
    public void testInsertKey() {
        instance = new MinHeap(11);
        System.out.println("MinHeap: Testing insert key");
        int expectedResult = 2;
        instance.insertKey(3);
        instance.insertKey(2);
        instance.insertKey(5);
        Assert.assertEquals(expectedResult, instance.getMin());
    }

    @Test
    public void testDeleteKey() {
        instance = new MinHeap(11);
        System.out.println("MinHeap: Testing delete key");
        instance.insertKey(3);
        instance.insertKey(2);
        instance.insertKey(5);

        int expectedResult = 3;
        int extracted = instance.deleteKey(0);
        Assert.assertEquals(-2147483648, extracted);
        Assert.assertEquals(expectedResult, instance.getMin());
    }

    @Test
    public void testDeleteAndInsert() {
        instance = new MinHeap(11);
        System.out.println("MinHeap: Testing insert and delete key");
        instance.insertKey(3);
        instance.insertKey(2);
        instance.deleteKey(1);
        instance.insertKey(15);
        instance.insertKey(5);
        instance.insertKey(4);
        instance.insertKey(45);

        Assert.assertEquals(2, instance.extractMin());
        Assert.assertEquals(4, instance.getMin());
    }

    @Test
    public void testDecreaseKey() {
        instance = new MinHeap(11);
        System.out.println("MinHeap: Testing decrese key");
        instance.insertKey(3);
        instance.insertKey(2);
        instance.deleteKey(1);
        instance.insertKey(15);
        instance.insertKey(5);
        instance.insertKey(4);
        instance.insertKey(45);
        instance.extractMin();
        instance.decreaseKey(2, 1);
        Assert.assertEquals(1, instance.getMin());

    }
}
