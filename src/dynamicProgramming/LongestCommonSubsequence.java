package dynamicProgramming;

public class LongestCommonSubsequence {

    /**
     * LCS non-contiguous recursive
     */
    public int calculcateLCS(String word1, String word2, int s1, int s2) {
        //base case
        if(s1 == 0 || s2 == 0) {
            if(word1.charAt(s1) == word2.charAt(s2))
                return 1;
            return 0;
        }

        if(word1.charAt(s1) == word2.charAt(s2))
            return calculcateLCS(word1, word2, s1 - 1, s2 - 1) + 1;
        else
            return Math.max(calculcateLCS(word1, word2, s1, s2 -1), calculcateLCS(word1, word2, s1 - 1, s2));
    }

    /**
     * LCS contiguous recursive
     */
    public int calculcateLCSCon(String word1, String word2, int s1, int s2, int count) {
        if(s1 == 0 || s2 == 0) {
            if(word1.charAt(s1) == word2.charAt(s2))
                return count++;
            return count;
        }

        if(word1.charAt(s1) == word2.charAt(s2))
            count = calculcateLCSCon(word1, word2, s1 - 1, s2 - 1, count + 1);
        else
            count = Math.max(count,
                    Math.max(calculcateLCSCon(word1, word2, s1, s2 - 1, 0),
                            calculcateLCSCon(word1, word2, s1 - 1, s2, 0)));

        return count;
    }

    /**
     * LCS non-contiguous dynamic programming appraoch
     */
    public int[][] createMatrix(String word1, String word2) {
        int[][] lcsMatrix = new int[word1.length()][word2.length()];

        for(int i = 0; i < word1.length(); i++) {
            for(int j = 0; j < word2.length(); j++) {
                if(i == 0 || j == 0)
                    lcsMatrix[i][j] = 0;
                else if(word1.charAt(i) == word2.charAt(j))
                    lcsMatrix[i][j] = lcsMatrix[i - 1][j - 1] + 1;
                else
                    lcsMatrix[i][j] = Math.max(lcsMatrix[i - 1][j], lcsMatrix[i][j - 1]);
            }
        }

        return lcsMatrix;
    }

    public void printLCS(int[][] matrix, int i, int j, String word1) {
        if(i == 0 || j == 0)
            return;
        if(matrix[i][j] == matrix[i-1][j]) {
            printLCS(matrix, i - 1, j, word1);
            return;
        }
        if(matrix[i][j] != matrix[i-1][j-1]) {
            System.out.println("LCS dp: " + word1.charAt(i));
            printLCS(matrix, i-1, j- 1, word1);
        }
        else
            printLCS(matrix, i, j - 1, word1);
    }
}
