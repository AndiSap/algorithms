package searching;

public class BinarySearch {

    public int search(int[] input, int target, int left, int right) {
        if(left == right)
            if(input[left] == target)
                return left;
            else
                return -1;

        int mid = left + (right - left) / 2;

        if(input[mid] == target)
            return mid;

        if(input[mid] < target)
            return search(input, target, mid + 1, right);
        else
            return search(input, target, left, mid - 1);
    }
}
