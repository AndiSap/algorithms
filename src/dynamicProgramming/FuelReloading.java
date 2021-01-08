package dynamicProgramming;

public class FuelReloading {

    /**
     * Minimize stops recursive
     */
    public int calculateStops(int[] stations, int position, int travelled, int distance) {
        if(position == 0) {
            if(stations[0] <= travelled)
                return 0;
            return 1;
        }

        if(travelled + (stations[position] - stations[position -1]) >= distance) // have to refuel at previous station to reach current station
            return calculateStops(stations, position - 1, distance, distance) + 1;

        return Math.min(calculateStops(stations, position - 1, distance, distance) + 1,
                calculateStops(stations, position -1, travelled + (stations[position] - stations[position -1]), distance));
    }

    /**
     * Maximize distance per stop
     */
    public int[] calculateStopsDp(int[] stations, int distance) {
        int[] dp = new int[stations.length + 1];
        dp[0] = distance;
        for(int i = 0; i < stations.length; i++) {
            for(int t = i; t >= 0; --t)
                if(dp[t] >= stations[i])
                        if(i == 0)
                            dp[t+1] = Math.max(dp[t+1], dp[t] + stations[i]);
                        else
                            dp[t+1] = Math.max(dp[t+1], dp[t] + (stations[i] - stations[i - 1]));
        }

        return dp;
    }

    /**
     * Minimize stops per distance travelled
     */
    public int[][] calculateMatrix(int[] stations, int distance) {
        int target = stations[stations.length - 1];
        int[][] stopMatrix = new int[stations.length + 1][target + 1];
        for(int i = 1; i <= stations.length; i++) {
            for(int j = 1; j <= target;j++) {
                stopMatrix[i][j] = stopMatrix[i-1][j];
                if(j > stations[i-1] && j <= stations[i-1] + distance) {
                    if (i > 1)
                        stopMatrix[i][j] = min(stopMatrix[i - 1][j], stopMatrix[i][j - (stations[i - 1] - stations[i - 2])] + 1);
                    else
                        stopMatrix[i][j] = 1;
                }

            }
        }

        return stopMatrix;
    }

    public int min(int a, int b) {
        if(a == 0)
            return b;
        if(b == 0)
            return a;
        return Math.min(a, b);
    }
}
