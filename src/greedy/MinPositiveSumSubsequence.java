package greedy;

import java.util.Arrays;

public class MinPositiveSumSubsequence {

    /**
     * time: O(n (logn)^2 )
     */
    public int findMinPosSumSub(int[] array, int left, int right) {
        if(left == right)
            return array[left];

        int middle = (left + right) / 2;

        /**
         * Calculate min pos sum subsequence which includes midpoint
         */
        // calculate left sums when starting from left to midpoint
        int[] leftSums = new int[middle - left + 1];
        int index = 0;
        for(int i = middle; i >= left; i--) {
            if(index == 0)
                leftSums[index] = array[middle];
            else
                leftSums[index] = leftSums[index - 1] + array[i];
            index++;
        }
        // calculate right sums when starting from midpoint to right end
        int[] rightSums = new int[right - middle];
        index = 0;
        for(int i = middle + 1; i <= right; i++) {
            if(index == 0)
                rightSums[index] = array[middle + 1];
            else
                rightSums[index] = rightSums[index - 1] + array[i];
            index++;
        }

        Arrays.sort(leftSums);
        Arrays.sort(rightSums);
        // find minimum positive sum as combination of sums
        int maxSumMiddle = Integer.MAX_VALUE;
        int i = 0;
        int j = rightSums.length - 1;
        for(int times = 0; times < leftSums.length + rightSums.length; times++){
            int sum = leftSums[i] + rightSums[j];
            if(sum > 0 && j > 0)
                j--;
            else if(sum <= 0 && i < leftSums.length -1 )
                i++;
            if(sum > 0 && sum < maxSumMiddle)
                maxSumMiddle = sum;
        }

        if(maxSumMiddle <= 0)
            maxSumMiddle = Integer.MAX_VALUE;

        /**
         * Calculates left and right min positive sum
         */
        int leftSide = findMinPosSumSub(array, left, middle);
        int rightSide = findMinPosSumSub(array, middle + 1, right);

        int minPosSide;
        if(leftSide < 0 && rightSide > 0)
            minPosSide = rightSide;
        else if(leftSide < 0 && rightSide < 0)
            minPosSide = Math.max(leftSide, rightSide);
        else if(leftSide > 0 && rightSide < 0)
            minPosSide = leftSide;
        else
            minPosSide = Math.min(leftSide, rightSide);

        return Math.min(minPosSide, maxSumMiddle);
    }
}
