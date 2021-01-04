package greedyTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import greedy.MST;

import java.util.Arrays;


public class MSTTest {
    MST instance;
    int[][] matrix= new int[][]{
            { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
            { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
            { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
            { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
            { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 }  };


    public MSTTest() {
    }

    @Before
    public void setUp() {
        instance = new MST();

    }

    @Test
    public void testPrimMst() {
        System.out.println("MST: Testing primMst");
        int[] expectedResult = {-1, 0, 8, 2, 3, 6, 7, 6, 2};

        Assert.assertEquals(Arrays.toString(expectedResult), Arrays.toString(instance.constructMST(matrix)));
    }
}
