package searching;

public class LinearSearch {

    public int search(int[] input, int target) {
        for(int i = 0; i < input.length; i++) {
            if(input[i] == target)
                return i;
        }

        return -1;
    }

    public int recursiveSearch(int[] input, int target, int end) {
        if(input[end] != target && end == 0) return -1;

        if(input[end] == target)
            return end;
        return recursiveSearch(input, target, end - 1);
    }
}
