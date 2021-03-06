package graphsTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import graphs.AdjacencyList;

import java.util.ArrayList;

public class AdjacencyListTest {
    AdjacencyList instance;
    int[][] matrix = new int[][]{
            {0, 1, 0, 0, 1},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 1, 0},
            {0, 1, 1, 0, 1},
            {1, 1, 0, 1, 0}
    };

    int[][] dijkstraMatrix = new int[][]{
            { 0, 1, 0, 0, 0, 0, 0, 1, 0 },
            { 1, 0, 1, 0, 0, 0, 0, 1, 0 },
            { 0, 1, 0, 1, 0, 1, 0, 0, 1 },
            { 0, 0, 1, 0, 1, 1, 0, 0, 0 },
            { 0, 0, 0, 1, 0, 1, 0, 0, 0 },
            { 0, 0, 1, 1, 1, 0, 1, 0, 0 },
            { 0, 0, 0, 0, 0, 1, 0, 1, 1 },
            { 1, 1, 0, 0, 0, 0, 1, 0, 1 },
            { 0, 0, 1, 0, 0, 0, 1, 1, 0 } };

    int[][] primMatrix = new int[][]{
            { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
            { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
            { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
            { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
            { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

    public AdjacencyListTest() {
    }

    @Before
    public void setUp() {
        instance = new AdjacencyList(matrix.length);
        for(int row = 0; row < matrix.length; row++)
            for(int column = 0; column < matrix[0].length; column++)
                if(matrix[row][column] == 1)
                    instance.addEdge(row, column);
    }

    @Test
    public void testAddEdge() {
        System.out.println("AdjacencyList: Testing add edge");
        ArrayList<Integer> exptectedResult = new ArrayList<>();
        exptectedResult.add(1);
        exptectedResult.add(4);

        Assert.assertArrayEquals(exptectedResult.toArray(), instance.graph.get(0).toArray());
    }

    @Test
    public void testBfs() {
        System.out.println("AdjacencyList: Testing bfs");
        instance.bfs(2);
    }

    @Test
    public void testBfsMatrix() {
        System.out.println("AdjacencyList: Testing bfs matrix");
        instance.bfsMatrix(matrix, 2);
    }

    @Test
    public void testDfs() {
        System.out.println("AdjacencyList: Testing dfs");
        instance.dfs(2);
    }

    @Test
    public void testDfsMatrix() {
        System.out.println("AdjacencyList: Testing dfs matrix");
        instance.dfsMatrix(matrix, 2);
    }

    @Test
    public void testDijkstra() {
        System.out.println("AdjacencyList: Testing dijkstra");
        instance = new AdjacencyList(dijkstraMatrix.length);
        for(int row = 0; row < dijkstraMatrix.length; row++)
            for(int column = 0; column < dijkstraMatrix[0].length; column++)
                if(dijkstraMatrix[row][column] == 1)
                    instance.addEdge(row, column);

        instance.dijkstra(8);
    }

    @Test
    public void testPrimMst() {
        System.out.println("AdjacencyList: Testing primMst");
        instance = new AdjacencyList(primMatrix.length);

        instance.primMst(primMatrix, 0);
    }
}
