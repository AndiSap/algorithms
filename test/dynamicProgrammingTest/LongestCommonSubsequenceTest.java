package dynamicProgrammingTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import dynamicProgramming.LongestCommonSubsequence;

public class LongestCommonSubsequenceTest {
    LongestCommonSubsequence instance;
    String word1 = "asdgtwestslkjkt";
    String word2 = "qtestq";

    public LongestCommonSubsequenceTest() {
    }

    @Before
    public void setUp() {
        instance = new LongestCommonSubsequence();
    }

    @Test
    public void testLCSNonContiguous() {
        System.out.println("LongestCommonSubsequence: Testing LCS recursive non-contiguous");
        Assert.assertEquals(4, instance.calculcateLCS(word1, word2, word1.length() - 1, word2.length() -1));
    }

    @Test
    public void testLCSContiguous() {
        System.out.println("LongestCommonSubsequence: Testing LCS recursive contiguous");
        word1 = "asdgtwestslkjet";
        word2 = "qtestq";
        Assert.assertEquals(3, instance.calculcateLCSCon(word1, word2, word1.length() - 1, word2.length() -1, 0));
    }

    @Test
    public void testLCSDP() {
        System.out.println("LongestCommonSubsequence: Testing LCS dp non-contiguous");
        word1 = "asdgtwestslkjet";
        word2 = "qtestq";
        Assert.assertEquals(4, instance.createMatrix(word1, word2)[word1.length() -1][word2.length() - 1]);
        instance.printLCS(instance.createMatrix(word1, word2), word1.length() - 1, word2.length() -1, word1);
    }

}
