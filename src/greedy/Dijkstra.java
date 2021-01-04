package greedy;

import java.util.*;

public class Dijkstra {

    private ArrayList<Integer> getNeighbors(int[][] matrix, int source) {
        ArrayList<Integer> neighbors = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++)
            if(matrix[source][i] > 0)
                neighbors.add(i);

        return neighbors;
    }

    public int[] computePaths(int[][] matrix, int source) {
        int[] distances = new int[matrix.length];
        int[] parent = new int[matrix.length];
        Arrays.fill(distances, Integer.MAX_VALUE);
        boolean[] visited = new boolean[matrix.length];

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            if(distances[o1] == distances[o2])
                return 0;
            else if(distances[o1] < distances[o2])
                return -1;
            else
                return 1;
        });

        queue.add(source);
        distances[source] = 0;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            ArrayList<Integer> neighbors = getNeighbors(matrix, current);
            Collections.sort(neighbors, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if(matrix[current][o1] == matrix[current][o2])
                        return 0;
                    else if (matrix[current][o1] < matrix[current][o2])
                        return -1;
                    else
                        return 1;
                }
            });

            for (int neighbor : neighbors) {
                if (distances[current] + matrix[current][neighbor] < distances[neighbor])
                    parent[neighbor] = current;
                distances[neighbor] = Math.min(distances[neighbor], distances[current] + matrix[current][neighbor]);

                if(!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return parent;
    }

    public ArrayList<Integer> computeShortestPath(int[][] matrix, int source, int destination) {
        int[] parent = computePaths(matrix, source);
        ArrayList<Integer> path = new ArrayList<>();

        int current = destination;
        path.add(destination);
        while(current != source) {
            path.add(parent[current]);
            current = parent[current];
        }

        Collections.reverse(path);
        return path;
    }
}
