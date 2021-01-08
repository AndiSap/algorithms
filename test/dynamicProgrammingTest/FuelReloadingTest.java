package dynamicProgrammingTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import dynamicProgramming.FuelReloading;

public class FuelReloadingTest {
    FuelReloading instance;
    int[] stations = {4, 7, 11, 13, 18, 20, 23, 25};
    int tank = 6;

    public FuelReloadingTest() {
    }

    @Before
    public void setUp() {
        instance = new FuelReloading();
    }

    @Test
    public void testRefuel() {
        System.out.println("FuelReloading dp: Testing refuel recursive");
        int exptectedResult = 5;

        Assert.assertEquals(exptectedResult, instance.calculateStops(stations, stations.length - 1, 0, tank));
    }

    @Test
    public void testMatrix() {
        System.out.println("FuelReloading dp: Testing refuel dp");
        int exptectedResult = 5;

        Assert.assertEquals(exptectedResult, instance.calculateMatrix(stations, tank)[stations.length][stations[stations.length - 1]]);
    }
}
