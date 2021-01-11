package dynamicProgramming;

public class MatrixChainMul {

    /**
     * Recursive implementation of matrix chain multiplications in O(2^n)
     */
    public int matrixChain(int[] dimensions, int i, int j) {
        if(i == j)
            return 0;

        int min = Integer.MAX_VALUE;
        for(int k = i; k < j; k++) {
            int current = matrixChain(dimensions, i, k) + matrixChain(dimensions, k + 1, j)
                    + dimensions[i-1] * dimensions[k] * dimensions[j];
            if(current < min)
                min = current;
        }
        return min;
    }

    /**
     * Dynamic programming implementation of matrix chain multiplications in O(n^3)
     */
    public int matrixChainDp(int[] dimensions) {
        int[][] matrix = new int[dimensions.length][dimensions.length];
        int[][] parent = new int[dimensions.length][dimensions.length];

        for(int length = 2; length <= dimensions.length; length++)
            for(int i = 1; i < dimensions.length - length + 1; i++) {
                int j = i + length - 1;
                if(i == j) matrix[i][j] = 0;
                else {
                    int min = Integer.MAX_VALUE;
                    int par = -1;
                    for(int k = i; k < j; k++) {
                        int current = matrix[i][k] + matrix[k + 1][j] + dimensions[i-1] * dimensions[k] * dimensions[j];
                        if (current < min) {
                            min = current;
                            par = k;
                        }
                    }
                    matrix[i][j] = min;
                    parent[i][j] = par;
                }
            }

        System.out.println("MatrixChainMul: Print parenthization");
        printBrackets(parent, 1, dimensions.length - 1);
        System.out.println();
        return matrix[1][dimensions.length -1];
    }

    /**
     * Printing brackets for matrix chain multiplication
     */
    public void printBrackets(int[][] parentMatrix, int start, int end) {
        if(start == end) {
            System.out.print("A" + start);
            return;
        }
        int k = parentMatrix[start][end];
        System.out.print("(");
        printBrackets(parentMatrix, start, k);

        printBrackets(parentMatrix, k + 1, end);
        System.out.print(")");
    }

    /**
     * Numbers of possible parenthesizations recursive
     */
    public int noOfPossibleParent(int elements) {
        if(elements <= 1)
            return 1;

        int sum = 0;
        for(int k = 1; k < elements; k++)
            sum += noOfPossibleParent(k) * noOfPossibleParent(elements - k);
        return sum;
    }

    /**
     * Numbers of possible parenthesizations dynamic programming
     */
    public int noOfPossibleParentDp(int elements) {
        int[] dp = new int[elements + 1];
        dp[0] = dp[1] = 1;
        for(int i = 2; i <= elements; i++)
            for(int k = 1; k < i; k++)
                dp[i] += dp[k] * dp[i - k];

        return dp[elements];
    }
}
