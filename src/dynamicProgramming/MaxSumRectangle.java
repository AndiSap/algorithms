package dynamicProgramming;

public class MaxSumRectangle {
    int top = -1;
    int left = -1;
    int bottom = -1;
    int right = -1;

    /**
     * time: O(n^3)
     */
    public int calculateMaxSum(int[][] matrix) {
        int maxSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            int localMax = -1;
            int[] tmp = new int[matrix.length];

            for (int j = i; j < matrix.length; j++) {
                // create tmp subarray
                int[] current = createTmpArray(matrix, j);
                // add current tmp to old tmp
                for(int idx = 0; idx < matrix.length; idx++)
                    tmp[idx] += current[idx];
                // use kadane to calc max sum of subarray
                localMax = maxSumSub(tmp);

                if(localMax > maxSum) {
                    left = i;
                    right = j;
                    maxSum = localMax;
                }
            }
        }

        return maxSum;
    }

    public int[] createTmpArray(int[][] matrix, int column) {
        int[] result = new int[matrix.length];

        for(int idx = 0; idx < matrix.length; idx++)
            result[idx] = matrix[idx][column];

        return result;
    }

    /**
     * Using kadanes algorithm for linear time
     */
    public int maxSumSub(int[] array) {
        int localMax = 0;
        int globalMax = 0;

        for(int i = 0; i < array.length; i++) {
            if(array[i] > localMax + array[i]) // only for saving index
                top = i;

            localMax = Math.max(array[i], localMax + array[i]);

            if(localMax > globalMax) {
                globalMax = localMax;
                bottom = i;
            }
        }

        return globalMax;
    }
}
