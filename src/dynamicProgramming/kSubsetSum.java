package dynamicProgramming;

import java.util.Arrays;

public class kSubsetSum {

    /**
     * Solving k subset sum in O(2^n) time
     */
    public boolean isKSubset(int[] elements, int position, int sum) {
        if(position == 0)
            return elements[0] == sum;

        if(elements[position] > sum)
            return isKSubset(elements, position - 1, sum);

        return isKSubset(elements, position - 1, sum) ||
                isKSubset(elements, position - 1, sum - elements[position]);
    }

    /**
     * Solves kSubset sum in O(n*SUM) time -> still exponential
     */
    public boolean[][] createMatrix(int[] elements, int sum) {
        boolean[][] kSubsetMatrix = new boolean[elements.length][sum + 1];
        for(int i = 0; i < elements.length; i++) {
            Arrays.fill(kSubsetMatrix[i], false);
            kSubsetMatrix[i][0] = true;
        }

        kSubsetMatrix[0][elements[0]] = true;
        for(int i = 1; i < elements.length; i++) {
            for(int j = 0; j <= sum; j++) {
                kSubsetMatrix[i][j] = kSubsetMatrix[i - 1][j];
                if(j >= elements[i]) {
                        kSubsetMatrix[i][j] = kSubsetMatrix[i][j] || kSubsetMatrix[i-1][j - elements[i]];
                }
            }
        }

//        for(int i = 0; i < elements.length; i++) {
//            for(int j = 0; j <= sum; j++) {
//                String printC = "F";
//                if(kSubsetMatrix[i][j]) printC = "T";
//                System.out.print("" + printC + " ");
//            }
//            System.out.println();
//        }

        return kSubsetMatrix;
    }
}
