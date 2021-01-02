package greedy;

public class FractorialKnapsack {

    public double[] calculateKnapsack(int[] goods, int[] weights, int[] profit, int M) {
        int numOfGoods = goods.length;
        double[] density = new double[numOfGoods];
        double[] solution = new double[numOfGoods];
        int knapsack = 0;
        double totalProfit = 0;

        // calculate density
        for(int i = 0; i < numOfGoods; i++) {
            density[i] = (double)profit[i] / weights[i];
        }

        // loop x item times and pick the maximum density possible
        for(int i = 0; i < numOfGoods; i++) {
            int capacity = M - knapsack;
            if(capacity > 0) {
                int element = getMaxDensity(density);
                int usedWeight = weights[element];

                if(capacity < weights[element]) // if not 100% of max density item can be chosen, get fraction!
                    usedWeight = capacity;

                solution[element] = (double) usedWeight / weights[element];
                density[element] = 0;
                totalProfit += profit[element] * solution[element];
                knapsack += usedWeight;
            }
        }

        System.out.println("Fractorial Knapsack total profit earned: " + totalProfit);
        return solution;
    }

    public int getMaxDensity(double[] density) {
        double max = 0;
        int index = -1;
        for(int i = 0; i < density.length; i++) {
            if(density[i] > max) {
                max = density[i];
                index = i;
            }
        }
        return index;
    }
}
