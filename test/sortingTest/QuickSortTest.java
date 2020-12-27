package sortingTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sorting.QuickSort;

import java.util.Arrays;

public class QuickSortTest {
    QuickSort instance;

    public QuickSortTest() {
    }

    @Before
    public void setUp() {
        instance = new QuickSort();
    }

    @Test
    public void testSort() {
        System.out.println("HeapSort: Testing sort");
        int[] input = new int[]{5, 1, 4, 2, 8};
        int[] expectedResult = new int[]{1, 2, 4, 5, 8};
        instance.sort(input, 0, input.length - 1);
        Assert.assertEquals(Arrays.toString(expectedResult), Arrays.toString(input));
    }
}