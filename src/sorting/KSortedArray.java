package sorting;

import java.util.PriorityQueue;

public class KSortedArray {

    /**
     * Using insertion sort, this has running time of O(nk)
     */
    public void sort(int[] input, int k) {
        for(int i = 1; i < input.length; i++) {
            for (int j = i; j > 0; j--) {
                if(input[j-1] > input[j]) { // swap both elements
                    int tmp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = tmp;
                }
            }
        }
    }

    public void ksort(int[] input, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0; i <= k; i++)
            heap.add(input[i]);

        for(int i = 0; i < input.length; i++) {
            input[i] = heap.remove();
            heap.add(input[i+k+1]);
        }

    }

    private void heapify(int[] input, int size, int root) {
        int largest = size;
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;

        if(leftChild < size && input[leftChild] < input[largest])
            largest = leftChild;

        if(rightChild < size && input[rightChild] < input[largest])
            largest = rightChild;

        if(largest != root) {
            int tmp = input[largest];
            input[largest] = input[root];
            input[root] = tmp;
            heapify(input, size, largest);
        }
    }
}
