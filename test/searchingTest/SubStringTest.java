package searchingTest;

import searching.SubString;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SubStringTest {
    SubString instance;

    public SubStringTest() {}

    @Before
    public void setUp() {
        instance = new SubString();
    }

    @Test
    public void testSearch() {
        System.out.println("SubString: Testing search");
        String text = "asdgtasdeslkjkt";
        String pattern = "test";
        Assert.assertTrue(instance.contains(text, pattern, text.length() -1, pattern.length() - 1));
    }

    @Test
    public void testSearchContinous() {
        System.out.println("SubString: Testing search continuous");
        String text = "asdgtestslkjkt";
        String pattern = "test";
        Assert.assertTrue(instance.containsContinuous(text, pattern, text.length() -1, pattern.length() - 1));

        text = "asdfsdflestdgd";
        Assert.assertFalse(instance.containsContinuous(text, pattern, text.length() -1, pattern.length() - 1));
    }
}