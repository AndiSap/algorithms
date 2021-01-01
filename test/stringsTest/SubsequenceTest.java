package stringsTest;

import strings.Subsequence;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SubsequenceTest {
    Subsequence instance;

    public SubsequenceTest() {}

    @Before
    public void setUp() {
        instance = new Subsequence();
    }

    @Test
    public void testIsSubsequence() {
        System.out.println("Subsequence: Testing isSubsequence");
        String text = "asdgtestslkjkt";
        String pattern = "test";
        String pattern2 = "testg";
        Assert.assertTrue(instance.isSubsequence(text, pattern, text.length() -1, pattern.length() - 1));
        Assert.assertFalse(instance.isSubsequence(text, pattern2, text.length() -1, pattern2.length() - 1));

    }

    @Test
    public void testSubsequence() {
        System.out.println("Subsequence: Testing subsequence with k");
        String text = "abctestdfghtestpqw";
        String expectedResult = "testtest";
        int k = 2;
        Assert.assertEquals(expectedResult, instance.subsequence(text, k));
    }

    @Test
    public void testLongestCommonSubsequence() {
        System.out.println("Subsequence: Testing longest common subsequence");
        String string1 = "working";
        String string2 = "women";
        String expectedResult = "now";
        Assert.assertEquals(expectedResult, instance.longestCommonSubsequence(string1, string2));
    }
}