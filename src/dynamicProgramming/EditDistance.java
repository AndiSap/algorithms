package dynamicProgramming;

public class EditDistance {
    int[][] editMatrix;
    String word1;
    String word2;

    /**
     * DP version of edit distance O(nm)
     */
    public int[][] createMatrix(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        editMatrix = new int[word1.length()][word2.length()];

        for(int i = 0; i < word2.length(); i++) {
            for(int j = 0; j < word1.length(); j++) {
                if(i == 0) {
                    editMatrix[0][j] = j + 1;
                }
                else if(j == 0)
                    editMatrix[i][0] = i + 1;
                else {
                    // if current element is the same
                    int change = editMatrix[i - 1][j - 1];
                    int add = editMatrix[i][j - 1] + 1;
                    int remove = editMatrix[i - 1][j] + 1;
                    if(word1.charAt(i) != word2.charAt(j))
                        change += 1;

                    int addRemove = Math.min(add, remove);
                    editMatrix[i][j] = Math.min(addRemove, change);
                }
            }
        }
        return editMatrix;
    }

    public void printEdits(int u, int v) {
        if(u == 0 && v == 0) {
            if(word1.charAt(u) != word2.charAt(v))
                System.out.println("Edit Distance: changed: " +  word1.charAt(u) + " to " + word2.charAt(v));
            return;
        }
        if(u == 0) {
            System.out.println("Edit Distance: added: " + word2.charAt(v));
            printEdits(u, v - 1);
            return;
        }
        if(v == 0) {
            System.out.println("Edit Distance: removed: " + word1.charAt(u));
            printEdits(u - 1, v );
            return;
        }
        if(word1.charAt(u) == word2.charAt(v)) {
            // don't do anything
            printEdits(u - 1, v - 1 );
            return;
        }
        if(editMatrix[u - 1][v] < editMatrix[u][v]) {
            System.out.println("Edit Distance: removed: " + word1.charAt(u));
            printEdits(u - 1, v );
            return;
        }
        if(editMatrix[u][v - 1] < editMatrix[u][v]) {
            System.out.println("Edit Distance: added: " + word2.charAt(v));
            printEdits(u, v - 1);
            return;
        }
        System.out.println("Edit Distance: changed: " +  word1.charAt(u) + " to " + word2.charAt(v));
    }

    /**
     * Recursive implemention of edit distance O(3^n)
     */
    public int editDistance(String word1, String word2, int u, int v) {
        if(u == 0 && v == 0) {
            if(word1.charAt(u) == word2.charAt(v))
                return 0;
            else
                return 1;
        }
        if(u == 0)
            return v + 1; //editDistance(word1, word2, u, v - 1) + 1;
        if(v == 0)
            return u + 1; //editDistance(word1, word2, u - 1, v) + 1;

        int change = 1;
        if(word1.charAt(u) == word2.charAt(v))
            change = 0; //return editDistance(word1, word2, u - 1, v - 1);

        return Math.min(Math.min(editDistance(word1, word2, u, v - 1) + 1, editDistance(word1, word2, u - 1, v) + 1),
                editDistance(word1, word2, u - 1, v - 1) + change); //return editDistance(word1, word2, u - 1, v - 1) + 1;
    }
}
