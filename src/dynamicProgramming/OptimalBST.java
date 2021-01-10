package dynamicProgramming;

public class OptimalBST {

    /**
     * Calculate optimal BST cost resursively in O(2^n)
     */
    public int optimalCost(int[] frequency, int i, int j) {
        if(i == j)
            return frequency[i];

        if(i > j)
            return 0;

        int totalFreq = 0;
        for(int idx = i; idx <= j; idx++)
            totalFreq += frequency[idx];

        int min = Integer.MAX_VALUE;
        for(int r = i; r <= j; r++) {
            int optimal = optimalCost(frequency, i, r - 1) + optimalCost(frequency, r + 1, j);
            if(optimal < min)
                min = optimal;
        }

        return min + totalFreq;
    }

    public int optimalCostDp(int[] frequency) {
        int[][] costMatrix = new int[frequency.length][frequency.length];
        for(int i = 0; i < frequency.length; i++)
            costMatrix[i][i] = frequency[i];

        // have to do calculation diagonal!
        for(int length = 2; length <= frequency.length; length++) // length of subtree
            for(int i = 0; i < frequency.length - length + 1; i++) {

                int j = i + length - 1;
                costMatrix[i][j] = Integer.MAX_VALUE;

                int sum = 0;
                for(int idx = i; idx <= j; idx++)
                    sum += frequency[idx]; //costMatrix[idx][idx];

                for(int r = i; r <= j; ++r) {
                    int right = 0;
                    if(r < j) right = costMatrix[r + 1][j];
                    int left = 0;
                    if(r > i) left = costMatrix[i][r - 1];

                    int current = left + right + sum;
                    if(current < costMatrix[i][j])
                        costMatrix[i][j] = current;
                    }
            }
        return costMatrix[0][frequency.length - 1];
    }

    /**
     * Calculate no of unique bst recursively
     */
    public int noOfBst(int nodes) {
        if(nodes <= 1)
            return 1;

        int sum = 0;
        for(int i = 1; i <= nodes; i++)
            sum += noOfBst(i - 1) * noOfBst(nodes - i);

        return sum;
    }

    /**
     * Calculate no of unique bst dynamic programming
     */
    public int noOfBstDp(int nodes) {
        int[] dp = new int[nodes + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= nodes; i++)
            for(int j = 1; j <= i; j++)
                dp[i] += dp[j - 1] * dp[i - j];

        return dp[nodes];
    }

}
