package sorting;

public class QuickSort {

    public void sort(int[] input, int low, int high) {
        if (low < high) {
            int pivotIndex = partitioning(input, low, high);
            sort(input, low, pivotIndex - 1);
            sort(input, pivotIndex + 1, high);
        }
    }

    /**
     * Partitions using last element of array
     * @todo: use median of 3 statistics
     */
    private int partitioning(int[] input, int low, int high) {
        int pivot = input[high];
        int i = low - 1; // index of smallest element
        for(int j = low; j < high; j++) {
            if(input[j] <= pivot) {
                i++;
                int tmp = input[i];
                input[i] = input[j];
                input[j] = tmp;
            }
        }
        /**
         * Swap pivot (last element) with current i
         */
        int tmp = input[i+1];
        input[i+1] = input[high];
        input[high] = tmp;
        return i+1;
    }
}
