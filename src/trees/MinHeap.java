package trees;

public class MinHeap {

    public int[] heapArray;
    public int capacity;
    public int currenHeapSize;

    public MinHeap(int size) {
        heapArray = new int[size];
        capacity = size;
        currenHeapSize = 0;
    }

    public void swap(int index1, int index2) {
        int temp = heapArray[index1];
        heapArray[index1] = heapArray[index2];
        heapArray[index2] = temp;
    }

    public int getParent(int key) {
        return (key - 1) / 2;
    }

    public int getLeftChild(int key) {
        return (key * 2) + 1;
    }

    public int getRightChild(int key) {
        return (key * 2) + 2;
    }

    public void insertKey(int key) {
        if(currenHeapSize == capacity) return;

        int current = currenHeapSize;
        heapArray[current] = key;
        currenHeapSize++;

        while(current != 0 && heapArray[current] < heapArray[getParent(current)]) {
            swap(current, getParent(current));
            current = getParent(current);
        }
    }

    public void decreaseKey(int key, int newValue) {
        heapArray[key] = newValue;

        while(key != 0 && heapArray[key] < heapArray[getParent(key)]) {
            swap(key, getParent(key));
            key = getParent(key);
        }
    }

    public int getMin() {
        return heapArray[0];
    }

    public int extractMin() {
        if(currenHeapSize <= 0) return Integer.MAX_VALUE;
        if(currenHeapSize == 1) {
            currenHeapSize--;
            return heapArray[0];
        }

        int root = heapArray[0];
        heapArray[0] = heapArray[currenHeapSize - 1];
        currenHeapSize--;

        minHeapify(0);
        return root;
    }

    public void minHeapify(int root) {
        int smallest = root;
        int left = getLeftChild(root);
        int right = getRightChild(root);

        if(left < currenHeapSize && heapArray[left] < heapArray[smallest])
            smallest = left;

        if(right < currenHeapSize && heapArray[right] < heapArray[smallest])
            smallest = right;

        if(smallest != root) {
            swap(smallest, root);
            minHeapify(smallest);
        }
    }

    public int deleteKey(int key) {
        decreaseKey(key, Integer.MIN_VALUE);
        return extractMin();
    }

    public void increaseKey(int key, int newValue) {
        heapArray[key] = newValue;
        minHeapify(key);
    }

    public void changeValueOfKey(int key, int newValue) {
        if(heapArray[key] == newValue) return;
        if(heapArray[key] < newValue)
            increaseKey(key, newValue);
        else
            decreaseKey(key, newValue);
    }
}
