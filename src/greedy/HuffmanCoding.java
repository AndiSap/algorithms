package greedy;

import java.util.PriorityQueue;

public class HuffmanCoding {

    public String[] encode(char[] charArray, int[] frequency) {
        PriorityQueue<Node> queue = new PriorityQueue<Node>((o1, o2) -> o1.frequency - o2.frequency);

        for(int i = 0; i < charArray.length; i++) {
            queue.add(new Node(frequency[i], "" + charArray[i]));
        }

        /**
         * Creates huffman tree
         */
        Node parent = new Node(0, "null");
        while(queue.size() > 1) {
            parent = new Node(queue.poll(), queue.poll());
            queue.add(parent);
        }

        String[] encoding = new String[frequency.length];
        assignCoding(parent, "", encoding);
        return encoding;
    }

    public void assignCoding(Node root, String prefix, String[] encoding) {
        if(root == null) return;
        assignCoding(root.left, prefix + "0", encoding);
        if(root.symbol.length() == 1) {
            System.out.println("Node " + root.symbol + " with coding: " + prefix);
            encoding[root.symbol.charAt(0) - 'a'] = prefix;
        }
        assignCoding(root.right, prefix + "1", encoding);
    }


    public class Node {
        public int frequency;
        public String symbol;
        public Node left;
        public Node right;

        /**
         * Parent node
         */
        public Node(Node left, Node right) {
            this.frequency = left.frequency + right.frequency;
            this.symbol = left.symbol + right.symbol;
            this.left = left;
            this.right = right;
        }

        /**
         * Leaft node
         */
        public Node(int frequency, String symbol) {
            this.frequency = frequency;
            this.symbol = symbol;
        }
    }
}
