package sortingTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sorting.MergeSort;

import java.util.Arrays;

public class MergeSortTest {
    MergeSort instance;

    public MergeSortTest() {
    }

    @Before
    public void setUp() {
        instance = new MergeSort();
    }

    @Test
    public void testSort() {
        System.out.println("MergeSort: Testing sort");
        int[] input = new int[]{5, 1, 4, 2, 8};
        int[] expectedResult = new int[]{1, 2, 4, 5, 8};
        instance.sort(input, 0, input.length - 1);
        Assert.assertEquals(Arrays.toString(expectedResult), Arrays.toString(input));
    }
}