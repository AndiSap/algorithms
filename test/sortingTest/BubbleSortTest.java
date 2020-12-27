package sortingTest;

import sorting.BubbleSort;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class BubbleSortTest {
    BubbleSort instance;

    public BubbleSortTest() {}

    @Before
    public void setUp() {
        instance = new BubbleSort();
    }

    @Test
    public void testSort() {
        System.out.println("BubbleSort: Testing sort");
        int[] input = new int[]{5, 1, 4, 2, 8};
        int[] expectedResult = new int[]{1, 2, 4, 5, 8};
        instance.sort(input);
        Assert.assertEquals(Arrays.toString(expectedResult), Arrays.toString(input));
    }

    @Test
    public void testRecursiveSort() {
        System.out.println("BubbleSort: Testing recursive sort");
        int[] input = new int[]{5, 1, 4, 2, 8};
        int[] expectedResult = new int[]{1, 2, 4, 5, 8};
        instance.recursiveSort(input, input.length);
        Assert.assertEquals(Arrays.toString(expectedResult), Arrays.toString(input));
    }
}