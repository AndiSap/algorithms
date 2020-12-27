package sorting;

public class MergeSort {
    /**
     * Merges 2 halves of the array in ascending order
     */
    private void merge(int[] input, int left, int middle, int right) {
        /**
         * Calculate sizes of both subarrays
         */
        int sizeLeft = middle - left + 1;
        int sizeRight = right - middle;

        /**
         * Initialize and copy data to both subarrays
         */
        int[] leftHalf = new int[sizeLeft];
        int[] rightHalf = new int[sizeRight];

        for(int i = 0; i < sizeLeft; ++i)
            leftHalf[i] = input[left + i];
        for(int j = 0; j < sizeRight; ++j)
            rightHalf[j] = input[middle + 1 + j];

        /**
         * Merge both halves in ascending order
         */
        int leftPosition = 0;
        int rightPosition = 0;
        int current = left;

        while(leftPosition < sizeLeft && rightPosition < sizeRight) {
            if(leftHalf[leftPosition] <= rightHalf[rightPosition]) {
                input[current] = leftHalf[leftPosition];
                leftPosition++;
            } else {
                input[current] = rightHalf[rightPosition];
                rightPosition++;
            }
            current++;
        }

        // leftHalf leftovers
        while(leftPosition < sizeLeft) {
            input[current] = leftHalf[leftPosition];
            leftPosition++;
            current++;
        }

        // rightHalf leftovers
        while(rightPosition < sizeRight) {
            input[current] = rightHalf[rightPosition];
            rightPosition++;
            current++;
        }
    }

    /**
     * Sorts array recursively
     */
    public void sort(int[] input, int left, int right) {
        if(left < right) {
            int middle = (right + left) / 2; // calculate middle of array
            /**
             * Recursively call sort on both halves
             */
            sort(input, left, middle);
            sort(input, middle + 1, right);

            merge(input, left, middle, right); // merge sorted halves
        }
    }
}
