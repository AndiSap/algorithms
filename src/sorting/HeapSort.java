package sorting;

public class HeapSort {
    /**
     * Recursively heapifies subtree of size {size} at root {root}
     */
    private void heapify(int[] input, int size, int root) {
        int largest = root;
        int left = 2 * root + 1; // left child of root from array
        int right = 2 * root + 2; // right child of root from array

        if (left < size && input[left] > input[largest])
            largest = left;

        if (right < size && input[right] > input[largest])
            largest = right;

        if(largest != root) {
            int tmp = input[root];
            input[root] = input[largest];
            input[largest] = tmp;

            heapify(input, size, largest); // recursively heapify subarray with root of largest element to max heap
        }
    }

    public void sort(int[] input) {
        for(int i = input.length/2 - 1; i >= 0; i--) {
            heapify(input, input.length , i); // build max heap and rearrange array accordingly
        }

        /**
         * sort array using heapfiy by swapping greatest (root) and last element
         */
        for(int i = input.length - 1; i > 0; i--) {
            int tmp = input[0];
            input[0] = input[i];
            input[i] = tmp;

            heapify(input, i, 0); // heapify subarray with last element removed
        }
    }
}
