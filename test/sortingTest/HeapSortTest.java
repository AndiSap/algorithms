package sortingTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sorting.HeapSort;

import java.util.Arrays;

public class HeapSortTest {
    HeapSort instance;

    public HeapSortTest() {
    }

    @Before
    public void setUp() {
        instance = new HeapSort();
    }

    @Test
    public void testSort() {
        System.out.println("HeapSort: Testing sort");
        int[] input = new int[]{5, 1, 4, 2, 8};
        int[] expectedResult = new int[]{1, 2, 4, 5, 8};
        instance.sort(input);
        Assert.assertEquals(Arrays.toString(expectedResult), Arrays.toString(input));
    }
}