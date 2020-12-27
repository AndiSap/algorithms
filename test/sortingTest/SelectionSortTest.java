package sortingTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sorting.SelectionSort;

import java.util.Arrays;

public class SelectionSortTest {
    SelectionSort instance;

    public SelectionSortTest() {}

    @Before
    public void setUp() {
        instance = new SelectionSort();
    }

    @Test
    public void testSort() {
        System.out.println("SelectionSort: Testing sort");
        int[] input = new int[]{5, 1, 4, 2, 8};
        int[] expectedResult = new int[]{1, 2, 4, 5, 8};
        instance.sort(input);
        Assert.assertEquals(Arrays.toString(expectedResult), Arrays.toString(input));
    }

    @Test
    public void testIsSmallerStringFirst(){
        System.out.println("SelectionSort: Testing isSmallerStringFirst");
        String second = "floppy";
        String first = "flower";
        Assert.assertFalse(instance.isSmallerStringFirst(first, second, 0));
    }

    @Test
    public void testSortArray() {
        System.out.println("SelectionSort: Testing sort array");
        String[] input = new String[]{"paper", "true", "soap", "floppy", "flower"};
        String[] expectedResult = new String[]{"floppy", "flower", "paper", "soap", "true"};
        instance.sortArray(input);
        Assert.assertEquals(Arrays.toString(expectedResult), Arrays.toString(input));
    }
}