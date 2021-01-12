package dynamicProgramming;

public class EggDrop {

    /**
     * Recursive
     */
    public int calculateMinTries(int eggs, int floors) {
        int minimum = Integer.MAX_VALUE;
        if(eggs == 1)
            return floors;

        if(floors <= 1)
            return floors;

        for(int i = 1; i <= floors; i++) { // try every possibility
            int current = Math.max(calculateMinTries(eggs - 1, i - 1), // egg breaks
                    calculateMinTries(eggs, floors - i)); // egg did not break
            if(current < minimum)
                minimum = current;
        }

        return minimum + 1;
    }

    /**
     * Dynamic programming
     */
    public int calculateMinTriesDp(int eggs, int floors) {
        int[][] matrix = new int[eggs + 1][floors + 1];

        for(int i = 1; i <= eggs; i++) {
            for(int j = 1; j <= floors; j++) {
                if(i == 1 || j == 1)
                    matrix[i][j] = j;
                else {
                    int min = Integer.MAX_VALUE;
                    for(int k = i; k <= j; k++) {
                        int current = 1 + Math.max(matrix[i - 1][k - 1], matrix[i][j - k]);
                        if(current < min)
                            min = current;
                    }
                    matrix[i][j] = min;
                }
            }
        }

        return matrix[eggs][floors];
    }
}
