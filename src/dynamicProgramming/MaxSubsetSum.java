package dynamicProgramming;

public class MaxSubsetSum {

    /**
     * Solve max subset sum using O(n) time
     */
    public int maxSubsetSum(int[] elements) {
        int localMax = -999;
        int globalMax = -9999;
        int left = 0;
        int right = 0;

        for(int i = 1; i < elements.length; i++) {
            if(elements[i] > elements[i] + localMax)
                left = i; // to find start point of subarray

            localMax = Math.max(elements[i], elements[i] + localMax);

            if(localMax > globalMax) {
                globalMax = localMax;
                right = i; // to find endpoint of subarray
            }
        }

        if(left > right)
            left = right; // accounts for negative only array -> max subarray is the largest number (smallest negative number) in array

        System.out.println("MaxSubset sum: found max subset starting at idx: " + left + " and ending at idx: " + right);
        return globalMax;
    }
}
