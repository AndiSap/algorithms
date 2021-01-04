package greedy;

import java.lang.reflect.Array;
import java.util.*;

public class MST {
    public ArrayList<Integer> getNeighbors(int[][] matrix, int source) {
        ArrayList<Integer> neighbors = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++)
            if(matrix[source][i] > 0)
                neighbors.add(i);

        return neighbors;
    }

    public int[] constructMST(int[][] matrix) {
        int[] cost = new int[matrix.length];
        int[] parent = new int[matrix.length];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            if(cost[o1] == cost[o2])
                return 0;
            else if(cost[o1] < cost[o2])
                return -1;
            else
                return 1;
        });

//        ArrayList<Integer> inMst = new ArrayList<>();
        parent[0] = -1;
        for(int i = 0; i < matrix.length; i++)
            queue.add(i);

        while(!queue.isEmpty()) {
            int element = queue.poll();
//            inMst.add(element);
            ArrayList<Integer> neighbors = getNeighbors(matrix, element);

            for(int neighbor : neighbors) {
                if(matrix[element][neighbor] < cost[neighbor]) {
                    cost[neighbor] = matrix[element][neighbor];
                    parent[neighbor] = element;
                }
            }
        }
        return parent;
    }
}
