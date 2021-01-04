package greedyTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import greedy.VertexCover;

import java.util.Arrays;


public class VertexCoverTest {
    VertexCover instance;
    int[][] matrix= new int[][]{
            { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
            { 4, 0, 0, 0, 0, 0, 0, 11, 0 },
            { 0, 0, 0, 7, 0, 4, 0, 0, 2 },
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
            { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
            { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 }  };


    public VertexCoverTest() {
    }

    @Before
    public void setUp() {
        instance = new VertexCover();

    }

    @Test
    public void testVertexCover() {
        System.out.println("VertexCover: Testing cover");
        int[] expectedResult = {5, 7};

        Assert.assertEquals(Arrays.toString(expectedResult), instance.computeCover(matrix).toString());
    }
}
