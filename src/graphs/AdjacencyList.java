package graphs;

import java.util.ArrayList;
import java.util.LinkedList;

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
            if(matrix[element][i] == 1)
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
}
