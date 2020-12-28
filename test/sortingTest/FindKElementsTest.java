package sortingTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sorting.FindKElements;

import java.util.Arrays;

public class FindKElementsTest {
    FindKElements instance;

    public FindKElementsTest() {
    }

    @Before
    public void setUp() {
        instance = new FindKElements();
    }

    @Test
    public void testFindKelements() {
        System.out.println("FindKElements: Testing find k largest elements");
        int[] input = new int[]{50, 30, 12, 9, 23, 2, 1};
        int[] expectedResult = new int[]{23, 30, 50};
        int[] solution = instance.findKelements(input, 3, 0, input.length - 1);
        System.out.println(Arrays.toString(input));
        Assert.assertEquals(Arrays.toString(expectedResult), Arrays.toString(solution));
    }
}