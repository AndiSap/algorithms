package greedy;

public class MaxSumSubsequence {

    /**
     * time: O(nlogn)
     */
    public int findMaxSumSub(int[] array, int left, int right) {
        if (left == right)
            return array[left];

        int middle = (left + right) / 2;

        /**
         * calculate max subsequence overlapping middle element
         */
        int leftMax = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = middle; i >= left; i--) { // go from middle to left end
            sum += array[i];
            if (sum > leftMax)
                leftMax = sum;
        }

        int rightMax = Integer.MIN_VALUE;
        sum = 0;
        for (int i = middle + 1; i <= right; i++) { // go from middle+1 to right end
            sum += array[i];
            if (sum > rightMax)
                rightMax = sum;
        }

        int maxSide = Math.max(findMaxSumSub(array, left, middle), findMaxSumSub(array, middle + 1, right));

        return Math.max(maxSide, leftMax + rightMax);
    }
}
