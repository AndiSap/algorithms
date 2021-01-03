package greedy;

import java.util.HashMap;
import java.util.LinkedList;

public class LRU {
    HashMap<Character, Integer> map = new HashMap<>();
    LinkedList<Character> queue = new LinkedList<>();
    int capacity = 0;

    public LRU(int capacity) {
        this.capacity = capacity;
    }

    public void add(Character a) {
        if(queue.size() == capacity) {
            Character remove = queue.poll();
            map.remove(remove);
        }
        queue.add(a);
        map.put(a, queue.size() -1);
//        System.out.println();
    }

    public void peek(Character a) {
        int location = map.get(a);
        queue.remove(location);
        queue.add(a);
        map.put(a, queue.size() -1);
//        System.out.println();
    }

    public void remove(Character a) {
        int location = map.get(a);
        map.remove(a);
        queue.remove(location);
    }

    public Character getFirst() {
        return queue.peekFirst();
    }
}
