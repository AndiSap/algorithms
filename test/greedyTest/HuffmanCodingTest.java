package greedyTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import greedy.HuffmanCoding;

import java.util.Arrays;

public class HuffmanCodingTest {
    HuffmanCoding instance;
    char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
    int[] charfreq = { 5, 9, 12, 13, 16, 45 };

    public HuffmanCodingTest() {
    }

    @Before
    public void setUp() {
        instance = new HuffmanCoding();
    }

    @Test
    public void testCreateTree() {
        System.out.println("HuffmanCoding: Testing huffman encoding");
        String[] exptectedResult = {"1100", "1101", "100", "101", "111", "0"};

        Assert.assertEquals(Arrays.toString(exptectedResult), Arrays.toString(instance.encode(charArray, charfreq)));
    }
}
