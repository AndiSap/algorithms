package strings;

import java.util.Arrays;
import java.util.HashMap;

public class Subsequence {

    public boolean isSubsequence(String text, String sequence, int t, int s) {
        if(t == -1) return false;
        if (text.charAt(t) == sequence.charAt(s)) {
            if (s == 0)
                return true;
            else
                return isSubsequence(text, sequence, t-1, s-1);
        }
        else
            return isSubsequence(text, sequence, t-1, /* s */sequence.length() - 1); // use s if pattern can be non-continuous
    }

    /**
     * Longest subsequence where every character appears at-least k times
     */
    public String subsequence(String text, int k) {
        String solution = "";
        int[] frequency = new int[26]; // for every character in the alphabet
        Arrays.fill(frequency, 0);

        for(int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i) - 'a']++;
        }

        for(int i = 0; i < text.length(); i++) {
            if(frequency[text.charAt(i) - 'a'] >= k)
                solution = solution.concat(String.valueOf(text.charAt(i)));
        }

        return solution;
    }

    /**
     * Longest common subsequence with permutations allowed
     */
    public String longestCommonSubsequence(String string1, String string2) {
        String solution = "";
        int[] str1 = new int[26]; // for every character in the alphabet
        int[] str2 = new int[26]; // for every character in the alphabet

        for(char character : string1.toCharArray()) {
            str1[character - 'a']++;
        }

        for(char character : string2.toCharArray()) {
            str2[character - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            for(int times = 1; times <= Math.min(str1[i], str2[i]); times++) // loop 0 or more times thru character
                solution += (char) ('a' + i);
        }

        return solution;
    }
}
