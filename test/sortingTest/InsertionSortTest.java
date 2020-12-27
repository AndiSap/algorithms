package sortingTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sorting.InsertionSort;

import java.util.Arrays;

public class InsertionSortTest {
    InsertionSort instance;

    public InsertionSortTest() {
    }

    @Before
    public void setUp() {
        instance = new InsertionSort();
    }

    @Test
    public void testSort() {
        System.out.println("InsertionSort: Testing sort");
        int[] input = new int[]{5, 1, 4, 2, 8};
        int[] expectedResult = new int[]{1, 2, 4, 5, 8};
        instance.sort(input);
        Assert.assertEquals(Arrays.toString(expectedResult), Arrays.toString(input));
    }
}