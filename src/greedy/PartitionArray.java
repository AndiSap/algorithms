package greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class PartitionArray {

    /**
     * Iterative
     */
    public void partitionArrayEqually(int[] array) {
        Arrays.sort(array);
        int A = 0;
        int B = 0;

        A = array[array.length - 1];
        for(int i = array.length - 2; i >= 0; i--) {
            if(A > B)
                B += array[i];
            else
                A += array[i];
        }

        System.out.println("Set Splitting iterative, A: " + A + " and B: " + B);
    }

    /**
     * Recursive
     */
    public void paritionArray(int[] array) {
        Arrays.sort(array);
        int A = array[array.length - 1];
        int B = 0;
        paritionArrayRecursive(array, A, B, array.length - 2);
    }

    private void paritionArrayRecursive(int[] array, int A, int B, int position) {
        if(position == -1) {
            System.out.println("Set Splitting recursive, A: " + A + " and B: " + B);
            return;
        }
        if(A > B)
            paritionArrayRecursive(array, A, B + array[position], --position);
        else
            paritionArrayRecursive(array, A + array[position], B, --position);

    }

    /**
     * Check if array can be partitioned into 2 equal subarrays O(2^n) because of OR ||
     */
    private boolean isSubsetSum(int[] array, int sum, int position) {
        if(position == 0) {
            return array[position] == sum;
        }

        if(array[position] > sum)
            return isSubsetSum(array, sum, position - 1); // ignore current element if bigger than sum

        return isSubsetSum(array, sum, position -1) || isSubsetSum(array, sum - array[position], position -1 );

    }

    public boolean canPartition(int[] array) {
        int sum = 0;
        for(int element : array)
            sum += element;

        if(sum % 2 != 0)
            return false;
        return  isSubsetSum(array, sum/2, array.length - 1);
    }

    /**
     * Calculates set A and set B
     */
    public void getPartitionElements(int[] array) {
        ArrayList<Integer> completeSet = new ArrayList<>();
        for(int element : array)
            completeSet.add(element);

        int indexA = completeSet.size();
        int indexB = indexA + 1;
        completeSet.add(0); // setA
        completeSet.add(0); // setB
        ArrayList<Integer> setA = new ArrayList<>();
        ArrayList<Integer> setB = new ArrayList<>();

        for(int i = 0; i < array.length; i++) {
            int element = completeSet.get(i);
            completeSet.set(i, 0);
            int currentSetA = completeSet.get(indexA);
            completeSet.set(indexA, currentSetA + element);

            if(canPartition(completeSet.stream().mapToInt(Integer::valueOf).toArray()))
                setA.add(array[i]);
            else {
                completeSet.set(indexA, currentSetA);
                completeSet.set(indexB, completeSet.get(indexB) + element);
                setB.add(array[i]);
            }
        }

        System.out.println("SET A: " + setA.toString());
        System.out.println("SET B: " + setB.toString());
    }
}
