package searching;

public class SubString {

    /**
     * not continuous
     */
    public boolean contains(String text, String pattern, int i, int j) {
        if(j == -1) return true;
        if(i == 1 && j == 1)
            return text.charAt(0) == pattern.charAt(0);

        if(pattern.charAt(j) == text.charAt(i))
            return contains(text, pattern, i-1, j-1);

        else
            return contains(text, pattern, i-1, j);
    }

    /**
     * continuous
     */
    public boolean containsContinuous(String text, String pattern, int i, int j) {
        if(j == -1) return true;
        if(i == 1 && j == 1)
            return text.charAt(0) == pattern.charAt(0);

        if(i == -1 && j != 0) return false;

        if(pattern.charAt(j) == text.charAt(i))
            return containsContinuous(text, pattern, i-1, j-1);

        else {
            if(j != pattern.length() - 1) {
                j = pattern.length() - 1;
            }
            return containsContinuous(text, pattern, i-1, j);
        }
    }
}
