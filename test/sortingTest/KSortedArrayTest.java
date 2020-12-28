package sortingTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sorting.KSortedArray;

import java.util.Arrays;

public class KSortedArrayTest {
    KSortedArray instance;

    public KSortedArrayTest() {
    }

    @Before
    public void setUp() {
        instance = new KSortedArray();
    }

    @Test
    public void testSort() {
        System.out.println("KSortedArray: Testing sort");
        int[] input = new int[]{6, 5, 3, 2, 8, 10, 9};
        int[] expectedResult = new int[]{2, 3, 5, 6, 8, 9, 10};
        instance.sort(input, 3);
        Assert.assertEquals(Arrays.toString(expectedResult), Arrays.toString(input));
    }

    @Test
    public void testKsort() {
        System.out.println("KSortedArray: Testing ksort");
        int[] input = new int[]{6, 5, 3, 2, 8, 10, 9};
        int[] expectedResult = new int[]{2, 3, 5, 6, 8, 9, 10};
        instance.sort(input, 3);
        Assert.assertEquals(Arrays.toString(expectedResult), Arrays.toString(input));
    }
}