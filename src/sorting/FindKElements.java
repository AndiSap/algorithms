package sorting;

import java.util.Arrays;

public class FindKElements {

    public int[] findKelements(int[] input, int k, int low, int high) {
        int index = partitioning(input, low, high);

        if(input.length - index == k) {
            return Arrays.copyOfRange(input, input.length - k, input.length);
        }

        if(input.length - index < k)
            return findKelements(input, k, low, index - 1);
        else
            return findKelements(input, k, index + 1, high);
    }

    public int partitioning(int[] input, int low, int high) {
        int pivot = input[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if(input[j] < pivot) {
                i++;
                int tmp = input[j];
                input[j] = input[i];
                input[i] = tmp;
            }
        }

        int tmp = input[high];
        input[high] = input[i+1];
        input[i+1] = tmp;
        return i + 1;
    }
}
