package graphs;

import java.util.*;

public class AdjacencyList {
    public ArrayList<ArrayList<Integer>> graph;

    public AdjacencyList(int rows) {
        graph = new ArrayList<>();
        for(int i = 0; i < rows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            graph.add(list);
        }
    }

    public void addEdge(int u, int v) {
        if(!graph.get(u).contains(v))
            graph.get(u).add(v);
        if(!graph.get(v).contains(u))
            graph.get(v).add(u);
    }

    public int print() {
        for (ArrayList<Integer> integers : graph) {
            for (int element : integers) {
                System.out.print(element + " -> ");
            }
            System.out.println();
        }
        return 0;
    }

    /**
     * Using adjacency list
     */
    public void bfs(int source) {
        boolean[] visited = new boolean[graph.size()];

        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        visited[source] = true;

        while(!queue.isEmpty()) {
            int next = queue.poll();
            for(int element : graph.get(next)) {
                if(!visited[element]) {
                    visited[element] = true;
//                    System.out.println("-------> Visiting element: " + element);
                    queue.add(element);
                }

            }
        }
    }

    public ArrayList<Integer> getNeighbors(int[][] matrix, int element) {
        ArrayList<Integer> solution = new ArrayList<>();
        for(int i = 0; i < matrix[0].length; i++) {
            if(matrix[element][i] >= 1)
                solution.add(i);
        }
        return solution;
    }

    /**
     * Using matrix
     */
    public void bfsMatrix(int[][] matrix, int source) {
        boolean[] visited = new boolean[graph.size()];

        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        visited[source] = true;

        while(!queue.isEmpty()) {
            int next = queue.poll();
            for(int element : getNeighbors(matrix, next)) {
                if(!visited[element]) {
                    visited[element] = true;
//                    System.out.println("-------> Matrix: Visiting element: " + element);
                    queue.add(element);
                }

            }
        }
    }

    public void dfs(int source) {
        boolean[] visited = new boolean[graph.size()];
        dfsUtil(source, visited);
    }

    /**
     * Using adjacency list
     */
    public void dfsUtil(int source, boolean[] visited) {

//        LinkedList<Integer> queue = new LinkedList<Integer>();
//        queue.add(source);
        visited[source] = true;

//        while(!queue.isEmpty()) {
//            int next = queue.poll();
            for(int element : graph.get(source)) {
                if(!visited[element]) {
//                    visited[element] = true;
//                    System.out.println("-------> Visiting element: " + element);
                    dfsUtil(element, visited);
                }

            }
//        }
    }

    public void dfsMatrix(int[][] matrix, int source) {
        boolean[] visited = new boolean[graph.size()];
        dfsUtilMatrix(matrix, source, visited);
    }

    /**
     * Using matrix
     */
    public void dfsUtilMatrix(int[][] matrix, int source, boolean[] visited) {
//        LinkedList<Integer> queue = new LinkedList<Integer>();
//        queue.add(source);
        visited[source] = true;

//        while(!queue.isEmpty()) {
//            int next = queue.pollLast();
            for(int element : getNeighbors(matrix, source)) {
                if(!visited[element]) {
//                    visited[element] = true;
//                    System.out.println("-------> Matrix: Visiting element: " + element);
                    dfsUtilMatrix(matrix, element, visited);
                }

            }
        }
//    }

    public void dijkstra(int source) {
        boolean[] visited = new boolean[graph.size()];
        int[] distance = new int[graph.size()];
        Arrays.fill(distance, 0);
        /**
         * To implement dijkstra use priority queue with sorts elements in queue after distance
         */
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            if(distance[o1] == distance[o2])
                return 0;
            else if(distance[o1] < distance[o2])
                return -1;
            else
                return 1;
        });
        queue.add(source);
        visited[source] = true;

        while(!queue.isEmpty()) {
            int next = queue.poll();
            ArrayList<Integer> neighbors = graph.get(next);
            for (int element : neighbors) {
                if(!visited[element]) {
                    visited[element] = true;
                    distance[element] = distance[next] + 1;
                    queue.add(element);
                }
            }
        }

        System.out.println("Dijkstra shortest paths: " + Arrays.toString(distance));
    }

    /**
     * find minimum spanning tree using prim's algorithm on a matrix
     */
    public void primMst(int[][] matrix, int source) {
        int[] cost = new int[matrix.length];
        Arrays.fill(cost, Integer.MAX_VALUE);
        boolean[] inMst = new boolean[matrix.length];
        int[] parent = new int[matrix.length];
        parent[0] = -1;

        cost[source] = 0;
        inMst[source] = true;

        for(int i = 0; i < matrix.length; i++) {
            int current = i;
            PriorityQueue<Integer> neighbors = new PriorityQueue<>(getNeighbors(matrix, current));
//            neighbors.sort(new Comparator<Integer>() {
//                public int compare(Integer o1, Integer o2) {
//                    if(matrix[current][o1] == matrix[current][o2])
//                        return 0;
//                    else if (matrix[current][o1] < matrix[current][o2])
//                        return -1;
//                    else
//                        return 1;
//                }
//            });

            for(int neighbor : neighbors) {
                if(!inMst[neighbor] && (cost[neighbor] > matrix[current][neighbor])) {
                    cost[neighbor] = matrix[current][neighbor];
                    inMst[neighbor] = true;
                    parent[neighbor] = current;
//                    queue.add(neighbor);
                }
            }
        }

        System.out.println("Parents of: " + Arrays.toString(parent));
    }
}
