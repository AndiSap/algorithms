package dynamicProgramming;

public class Knapsack {

    /**
     * Calculate 0-1 Knapsack recusively in O(2^n) - top down approach
     */
    public int calculate01Knapsack(int[] weight, int[] profit, int position, int capacity) {
        // base case
        if(position == 0 || capacity == 0)
            return 0;

        // calculate max of taking item vs not taking item
        if(capacity >= weight[position])
            return Math.max(calculate01Knapsack(weight, profit, position - 1, capacity),
                    calculate01Knapsack(weight, profit, position - 1, capacity - weight[position]) + profit[position]);

        else
            return calculate01Knapsack(weight, profit, position - 1, capacity);
    }

    /**
     * Create 0-1 Knapsack matrix in O(n*capacity) with input size of capacity being capacity = log(#) -> O( n*2^log(#) ) - bottom up approach
     */
    public int[][] createMatrix(int[] weight, int[] profit, int capacity) {
        int[][] knapsackMatrix = new int[weight.length + 1][capacity + 1];

        for(int i = 0; i <= weight.length; i++) {
            for(int j = 0; j <= capacity; j++) {
                if(i == 0 || j == 0)
                    knapsackMatrix[i][j] = 0;
                else if(j >= weight[i - 1])
                    knapsackMatrix[i][j] = Math.max(knapsackMatrix[i - 1][j - weight[i - 1]] + profit[i- 1], knapsackMatrix[i - 1][j]);
                else
                    knapsackMatrix[i][j] = knapsackMatrix[i - 1][j];
            }
        }
        return knapsackMatrix;
    }

    public void printUsedElements(int[][] matrix, int row, int column, int[] weight) {
        if(row == 0)
            return;
        if(matrix[row][column] != matrix[row - 1][column]) {
            System.out.println("0-1 Knapsack: used element: " + row);
            printUsedElements(matrix, row - 1, column - weight[row - 1], weight);
        } else {
            printUsedElements(matrix, row - 1, column, weight);
        }

    }
}
