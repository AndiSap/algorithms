package dynamicProgramming;

import java.util.Arrays;

public class PartitionArray {

    /**
     * Recursively partition array into 2 equal sum arrays (exponential time)
     */
    public boolean canPartition(int[] array) {
        int sum = 0;
        for(int element : array)
            sum += element;

        if(sum % 2 != 0)
            return false;

        return isSubsetSum(array, sum/2, array.length - 1);
    }

    public boolean isSubsetSum(int[] array, int sum, int position) {
        if(position == 0)
            return array[0] == sum;

        if(sum < array[position]) // don't take element
            return isSubsetSum(array, sum, position - 1);

        return isSubsetSum(array, sum, position - 1) ||
                isSubsetSum(array, sum - array[position], position - 1);
    }

    /**
     * Partition array into 2 equal sum arrays using dynamic programming in polynomial time
     */
    public boolean partitionDp(int[] array) {
        int sum = 0;
        for(int elements : array)
            sum += elements;

        boolean[][] partitionMatrix = new boolean[array.length + 1][sum/2 + 1];

        for(int i = 0; i <= array.length; i++) {
            Arrays.fill(partitionMatrix[i], false);
            for (int j = 0; j <= sum / 2 + 1; j++) {
                if (j == 0)
                    partitionMatrix[i][j] = true;
            }
        }

        for(int i = 1; i <= array.length; i++)
            for (int j = 1; j < sum / 2 + 1; j++) {
                if(j >= array[i - 1]) {
                    partitionMatrix[i][j] = partitionMatrix[i - 1][j] || partitionMatrix[i - 1][j - array[i - 1]];

                }
            }

        printElements(partitionMatrix, array.length, sum/2, array);
        return partitionMatrix[array.length][sum/2];
    }

    /**
     * Print array A -> to get array B just calculate array - {A}
     */
    public void printElements(boolean[][] matrix, int i, int j, int[] array) {
        if(i == 0 || j == 0)
            return;

        if(matrix[i][j] != matrix[i - 1][j]) {
            System.out.println("PartitionArray used element: " + array[i - 1]);
            printElements(matrix, i - 1, j - array[i - 1], array);
            return;
        }

        printElements(matrix, i - 1, j, array);
    }
}
