package dynamicProgramming;

import java.util.ArrayList;

public class TaskScheduling {

    /**
     * Recursive approach which uses exponential time
     */
    public int calculateMaxProfit(int[] start, int[] finish, int[] profit) {
        ArrayList<Task> list = new ArrayList<>(); // can also use PriorityQueue
        for(int i = 0; i < start.length; i++)
            list.add(new Task(start[i], finish[i], profit[i]));

        list.sort((o1, o2) -> o1.finish - o2.finish);
        return findMaxProfit(list, list.size() - 1);
    }

    public int findMaxProfit(ArrayList<Task> list, int position) {
        if(position == 0)
            return list.get(position).profit;

        if(position == -1)
            return 0;

        // either take element and add profit
        return Math.max(findMaxProfit(list, position - 1),
                findMaxProfit(list, findNextTask(list, position)) + list.get(position).profit);
//                findMaxProfit(list, findNextTaskBin(list, position, 0, position)) + list.get(position).profit);
        // or pass element
    }

    /**
     * Linear search for next element closest to last start time
     */
    public int findNextTask(ArrayList<Task> list, int lastStartIdx) {
        for(int i = lastStartIdx; i >= 0; i--)
            if(list.get(i).finish <= list.get(lastStartIdx).start)
                return i;

        return -1;
    }

    /**
     * Binary search for next element closest to last start time
     */
    public int findNextTaskBin(ArrayList<Task> list, int lastStartIdx, int left, int right) {
        int middle = (left + right) / 2;
        if(list.get(middle).finish <= list.get(lastStartIdx).start) { // check right side
            if(list.get(middle + 1).finish <= list.get(lastStartIdx).start)
                return findNextTaskBin(list, lastStartIdx, middle + 1, right);
            return middle; // if middle + 1 > lastStartIdx.start -> this is next element in line
        }

        return findNextTaskBin(list, lastStartIdx, left, middle - 1); // can only be left side

    }

    /**
     * Dynamic Programming task scheduling in O(nlogn) due to Binary search instead of linear search
     */
    public int calculateMaxProfitDp(int[] start, int[] finish, int[] profit) {
        int[] profitMatrix = new int[start.length];

        ArrayList<Task> list = new ArrayList<>();
        for(int i = 0; i < start.length; i++)
            list.add(new Task(start[i], finish[i], profit[i]));

        list.sort((o1, o2) -> o1.finish - o2.finish);

        profitMatrix[0] = list.get(0).profit;
        for(int i = 1; i < start.length; i++) {
            profitMatrix[i] = list.get(i).profit;
            if(list.get(i-1).finish >= list.get(i).start)
                profitMatrix[i] = Math.max(profitMatrix[i],
                        list.get(i).profit + profitMatrix[findNextTaskBin(list, i, 0, i)]);
        }

        return profitMatrix[start.length - 1];
    }


    public class Task{
        int start;
        int finish;
        int profit;

        public Task(int start, int finish, int profit) {
            this.start = start;
            this.finish = finish;
            this.profit = profit;
        }
    }

}
