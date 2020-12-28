package searchingTest;

import searching.LinearSearch;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinearSearchTest {
    LinearSearch instance;

    public LinearSearchTest() {}

    @Before
    public void setUp() {
        instance = new LinearSearch();
    }

    @Test
    public void testSearch() {
        System.out.println("LinearSearch: Testing search");
        int[] input = new int[]{5, 1, 4, 2, 8};
        int target = 4;
        int expectedResult = 2;
        int result = instance.search(input, target);
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void testRecursiveSearch() {
        System.out.println("LinearSearch: Testing recursive search");
        int[] input = new int[]{5, 1, 4, 2, 8};
        int target = 4;
        int expectedResult = 2;
        int result = instance.recursiveSearch(input, target, input.length - 1);
        Assert.assertEquals(expectedResult, result);
    }
}