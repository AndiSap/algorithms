package greedyTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import greedy.LRU;

import java.util.Arrays;

public class LRUTest {
    LRU instance;
    int capacity = 4;

    public LRUTest() {
    }

    @Before
    public void setUp() {
        instance = new LRU(capacity);
    }

    @Test
    public void testAdd() {
        System.out.println("LRU: Testing add");
        Character exptectedResult = 'a';
        instance.add('a');
        instance.add('b');
        instance.add('c');
        Assert.assertEquals(exptectedResult, instance.getFirst());
    }

    @Test
    public void testRemove() {
        System.out.println("LRU: Testing remove");
        Character exptectedResult = 'b';
        instance.add('a');
        instance.add('b');
        instance.add('c');
        instance.remove('a');
        Assert.assertEquals(exptectedResult, instance.getFirst());
    }

    @Test
    public void testPeek() {
        System.out.println("LRU: Testing peek");
        Character exptectedResult = 'b';
        instance.add('a');
        instance.add('b');
        instance.add('c');
        instance.peek('a');
        Assert.assertEquals(exptectedResult, instance.getFirst());
    }

    @Test
    public void testLRU() {
        System.out.println("LRU: Testing lru");
        Character exptectedResult = 'a';
        instance.add('a');
        instance.add('b');
        instance.add('c');
        instance.peek('a');
        instance.add('d');
        instance.add('e');
        instance.add('f');
        Assert.assertEquals(exptectedResult, instance.getFirst());
    }
}
