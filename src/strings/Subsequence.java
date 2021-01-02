package strings;

import java.util.*;

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

    /**
     * Anagram Substring Search (Or Search for all permutations)
     */
    public String anagram(String text, String pattern, int t, ArrayList<Integer> solution, HashMap<Character, Integer> pat) {
        if(pat.size() == 0) {
            solution.add(t);
            pat = createHashMap(pattern);
            if(t == 0)  {
                Collections.sort(solution);
                return solution.toString();
            }
            t += pat.size() - 1; // time complexity here O(pn) // look at O(n) solution
        }

        if(t == 0) return solution.toString();
        if(pat.containsKey(text.charAt(t - 1))) {
            if(pat.get(text.charAt(t - 1)) > 1) {
                pat.put(text.charAt(t - 1), pat.get(text.charAt(t - 1)) - 1);
            }
            else
                pat.remove(text.charAt(t - 1));
            return anagram(text, pattern, t - 1, solution, pat);
        }
        else
            return anagram(text, pattern, t - 1, solution, createHashMap(pattern));
    }

    public String anagram(String text, String pattern) {
        ArrayList<Integer> solution = new ArrayList<>();
        return anagram(text, pattern, text.length(), solution, createHashMap(pattern));
    }

    public HashMap<Character, Integer> createHashMap(String text) {
        HashMap<Character, Integer> pat = new HashMap<>();
        for(Character character : text.toCharArray()) {
            if(pat.containsKey(character))
                pat.put(character, pat.get(character) + 1);
            else
                pat.put(character, 1);
        }
        return  pat;
    }

    public boolean compare(char[] first, char[] second) {
        for(int i = 0; i < 256; i++) {
            if(first[i] != second[i])
                return false;
        }
        return true;
    }

    /**
     * Searches for all permutations of pattern in text
     */
    public String searchAnagram(String text, String pattern) {
        ArrayList<Integer> solution = new ArrayList<>();

        char[] pat = new char[256];
        char[] currentWindow = new char[256];

        /**
         * Initial characters
         */
        for(int i = 0; i < pattern.length(); i++) {
            pat[pattern.charAt(i)]++;
            currentWindow[text.charAt(i)]++;
        }

        /**
         * remaining characters
         */
        for(int i = pattern.length(); i < text.length(); i++) {
            if(compare(pat, currentWindow)) {
                System.out.println("Found pattern at: " + (i - pattern.length()));
                solution.add(i - pattern.length());
            }

            currentWindow[text.charAt(i)]++; // add current character to current window
            currentWindow[text.charAt(i - pattern.length())]--; // remove first window character
        }

        if(compare(pat, currentWindow)) {
            System.out.println("Found pattern at: " + (text.length() - pattern.length()));
            solution.add(text.length() - pattern.length());
        }

        return solution.toString();
    }
}
