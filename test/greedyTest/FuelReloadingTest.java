package greedyTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import greedy.FuelReloading;

import java.util.Arrays;

public class FuelReloadingTest {
    FuelReloading instance;
    int[] stations = {4, 7, 11, 13, 18, 20, 23};
    int distance = 25;
    int tank = 6;

    public FuelReloadingTest() {
    }

    @Before
    public void setUp() {
        instance = new FuelReloading();
    }

    @Test
    public void testRefuel() {
        System.out.println("FuelReloading: Testing refuel iterative");
        int[] exptectedResult = {1, 1, 0, 1, 1, 0, 1};

        Assert.assertEquals(Arrays.toString(exptectedResult), Arrays.toString(instance.refuel(stations, distance, tank)));
    }
}
