package sorting;
public class BubbleSort {

    /**
     * Iterative bubble sort
     */
    public void sort(int[] input) {

        for(int times = 0; times < input.length; times++) {
            for(int i = 0; i < input.length -1; i++) {
                if(input[i] > input[i+1]) {
                    int temp = input[i+1];
                    input[i+1] = input[i];
                    input[i] = temp;
                }
            }
        }
    }

    /**
     * Recursive bubble sort
     */
    public void recursiveSort(int[] input, int size) {
        if(size == 1) return; // base case

        for(int i = 0; i < size -1; i++) {
            if(input[i] > input[i+1]) {
                int temp = input[i+1];
                input[i+1] = input[i];
                input[i] = temp;
            }
        }
        recursiveSort(input, size - 1 ); // reduce max size of array by 1
    }

}