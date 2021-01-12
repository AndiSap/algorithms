package dynamicProgrammingTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import dynamicProgramming.EggDrop;

public class EggDropTest {
    EggDrop instance;
    int eggs = 2;
    int floors = 36;

    @Before
    public void setUp() {
        instance = new EggDrop();
    }

    @Test
    public void testEggDropRecursive() {
        System.out.println("EggDrop: Testing minimum tries recursive");
        int expectedResult = 4;
        Assert.assertEquals(expectedResult, instance.calculateMinTries(eggs, 10));
    }

    @Test
    public void testEggDropDp() {
        System.out.println("EggDrop: Testing minimum tries dynamic programming");
        int expectedResult = 8;
        Assert.assertEquals(expectedResult, instance.calculateMinTriesDp(eggs, floors));
    }
}
