package sorting;

public class InsertionSort {

    public void sort(int[] input) {
        for(int i = 1; i < input.length; i++) {
            for(int j = i; j > 0; j--) {
                if(input[j] < input[j-1]) {
                    int tmp = input[j-1];
                    input[j-1] = input[j];
                    input[j] = tmp;
                }
            }
        }
    }
}
