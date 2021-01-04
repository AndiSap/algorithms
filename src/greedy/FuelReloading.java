package greedy;

public class FuelReloading {

    public int[] refuel(int[] stations, int totalDistance, int tank) {
        int[] solution = new int[stations.length];
        int[] stops = new int[stations.length + 1];
        for(int i = 0; i < stations.length; i++) {
            stops[i] = stations[i];
        }
        stops[stations.length] = totalDistance;

        int lastStop = stops[0];
        for(int i = 1; i < stops.length; i++) {
            int distance = stops[i] - stops[i-1];
            lastStop += distance;
            if (lastStop > tank) {
                lastStop = distance;
                solution[i - 1] = 1;
            }
        }

        return solution;
    }
}
