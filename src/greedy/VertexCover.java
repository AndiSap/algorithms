package greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class VertexCover {

    private ArrayList<Integer> getNeighbors(int[][] matrix, int source) {
        ArrayList<Integer> neighbors = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++)
            if(matrix[source][i] > 0)
                neighbors.add(i);

        return neighbors;
    }

    public ArrayList<Integer> computeCover(int[][] matrix) {
        ArrayList<Integer> cover = new ArrayList<>();
        int[] vertexDegree = new int[matrix.length];
        for(int i = 0; i < matrix.length; i++) {
            ArrayList<Integer> neighbors = getNeighbors(matrix, i);
            vertexDegree[i] = neighbors.size();
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            if(vertexDegree[o1] == vertexDegree[o2])
                return 0;
            else if(vertexDegree[o1] > vertexDegree[o2])
                return -1;
            else
                return 1;
        });

        ArrayList<Integer> inCover = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++)
            queue.add(i);

        while(inCover.size() != matrix.length) {
            int element = queue.poll();
            inCover.add(element);
            cover.add(element);
            for(int vertex : getNeighbors(matrix, element))
                if(!inCover.contains(vertex)) inCover.add(vertex);
        }

        return cover;
    }
}
