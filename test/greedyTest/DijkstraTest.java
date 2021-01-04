package greedyTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import greedy.Dijkstra;

import java.util.Arrays;


public class DijkstraTest {
    Dijkstra instance;
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


    public DijkstraTest() {
    }

    @Before
    public void setUp() {
        instance = new Dijkstra();

    }

    @Test
    public void testPaths() {
        System.out.println("Dijkstra: Testing parents");
        int[] expectedResult = {0, 0, 1, 2, 5, 6, 7, 0, 2};

        Assert.assertEquals(Arrays.toString(expectedResult), Arrays.toString(instance.computePaths(matrix, 0)));
    }

    @Test
    public void testShortestPath() {
        System.out.println("Dijkstra: Testing all distances");
        int[] expectedResult = {0, 7, 6, 5};

        Assert.assertEquals(Arrays.toString(expectedResult), instance.computeShortestPath(matrix, 0, 5).toString());
    }
}
