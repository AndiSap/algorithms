package dynamicProgrammingTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import dynamicProgramming.EditDistance;

public class EditDistanceTest {
    EditDistance instance;
    String word1 = "sample";
    String word2 = "dampen";

    public EditDistanceTest() {
    }

    @Before
    public void setUp() {
        instance = new EditDistance();
    }

    @Test
    public void testCreateMatrix() {
        System.out.println("EditDistance: Testing creation of edit matrix");
        int[][] expectedResult = {
                {0, 1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5, 6},
                {2, 1, 2, 3, 4, 5},
                {3, 2, 1, 2, 3, 4},
                {4, 3, 2, 1, 2, 3},
                {5, 4, 3, 2, 3, 4}};

        Assert.assertEquals(3, instance.createMatrix(word1, word2)[word1.length() - 1][word2.length() - 1]);
        instance.printEdits(word1.length() - 1, word2.length() -1);
    }

    @Test
    public void testEditDistance() {
        System.out.println("EditDistance: Testing edit distance");
        String first = "voldemort";
        String second = "dumbledore";
        Assert.assertEquals(3, instance.editDistance(word1, word2, word1.length() -1, word2.length() - 1));
        Assert.assertEquals(7, instance.editDistance(first, second, first.length() -1, second.length() - 1));

    }
}
