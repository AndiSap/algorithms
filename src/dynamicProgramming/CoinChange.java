package dynamicProgramming;

public class CoinChange {

    /**
     * Coin change recursively in O(n*AMOUNT)
     */
    public int calculateChange(int[] change, int amount, int position) {
        if(position == 0) {
            if (change[position] == amount)
                return 1;
            return 0;
        }

        if(amount > change[position])
            return calculateChange(change, amount - change[position], position) + 1;
        else
            return calculateChange(change, amount, position - 1);
    }

    /**
     * How many ways to make the coin change
     */
    public int change(int[] change, int amount, int position) {
        if(amount == 0)
            return 1;

        if(amount < 0 || position < 0)
            return 0;

        return change(change, amount - change[position], position) // take change
                + change(change, amount, position - 1); // don't use change
    }

    public int[] changeDp(int[] change, int amount) {
        int[] changeArray = new int[amount + 1];
        changeArray[0] = 1;
        for(int i = 0; i < change.length; i++) {
            for(int j = change[i]; j <= amount; j++)
                changeArray[j] += changeArray[j - change[i]];
        }

        return changeArray;
    }
}
