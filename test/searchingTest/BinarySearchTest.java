package searchingTest;

import searching.BinarySearch;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {
    BinarySearch instance;

    public BinarySearchTest() {}

    @Before
    public void setUp() {
        instance = new BinarySearch();
    }

    @Test
    public void testSearch() {
        System.out.println("BinarySearch: Testing search");
        int[] input = new int[]{2, 3, 4, 10, 40};
        int target = 10;
        int expectedResult = 3;
        int result = instance.search(input, target, 0, input.length - 1);
        Assert.assertEquals(expectedResult, result);
    }
}