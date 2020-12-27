package sorting;

public class SelectionSort {

    public void sort(int[] input) {
        for(int i = 0; i < input.length; i++) {
            int min = i;
            for(int j = i + 1; j < input.length; j++) {
                if(input[j] < input[min]) min = j;
            }

            int tmp = input[i];
            input[i] = input[min];
            input[min] = tmp;
        }
    }

    public void sortArray(String[] input) {
        for(int i = 0; i < input.length; i++) {
            int min = i;

            for (int j = i + 1; j < input.length; j++)
                if(input[j].compareTo(input[min]) < 0) min = j;

            String tmp = input[min];
            input[min] = input[i];
            input[i] = tmp;
        }
    }

    /**
     * No need, use built-in string comparison
     */
    public boolean isSmallerStringFirst(String first, String second, int position) {
        if(first.charAt(position) == second.charAt(position))
            return isSmallerStringFirst(first, second, position + 1);
        return first.charAt(position) < second.charAt(position);
    }
}
