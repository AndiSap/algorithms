package greedy;

import java.util.ArrayList;

public class CoinChange {

    public ArrayList<Integer> calculateChange(int[] change, int amount) {
        ArrayList<Integer> solution = new ArrayList<>();
        change(change, amount, change.length - 1, solution);
        return solution;
    }

    public void change(int[] change, int amount, int end, ArrayList<Integer> solution) {
        if(end == 0) {
            if(change[0] == amount)
                solution.add(change[0]);

            return;
        }

        if(change[end] <= amount) {
            solution.add(change[end]);
            change(change, amount - change[end], end, solution);
        }
        else
            change(change, amount, --end, solution);
    }
}
