package dynamicProgramming;

public class RodCut {

    /**
     * Recursive implementation of rod cutting for max profit
     */
    public int calculateProfit(int[] profits, int length) {
        if(length == 0)
            return 0;

        int maxProfit = 0;

        for(int i = 0; i < length; i++)
             maxProfit = Math.max(maxProfit, profits[i] + calculateProfit(profits, length - i - 1));

        return maxProfit;
    }

    /**
     * Bottom up dynamic programming approach in O(n*n)
     */
    public int createMatrix(int[] profits, int length) {
        int[] rodCutDp = new int[length + 1];
        int[] solution = new int[length + 1];

        for(int i = 1; i <= length; i++) {
            int max = -1;
            for(int j = 0; j < i; j++) {
                if(max < (profits[j] + rodCutDp[i - j - 1]))
                    solution[i] = j + 1; // this is used as index here!
                max = Math.max(max, profits[j] + rodCutDp[i - j - 1]);
            }
            rodCutDp[i] = max;
        }
        printSolution(solution, length);
        return rodCutDp[length];
    }

    public void printSolution(int[] solution, int position) {
        if(position == 0)
            return;
        System.out.println("Rod cut: used cuts at: " + solution[position]);
        printSolution(solution, position - solution[position]);
    }
}
