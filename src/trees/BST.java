package trees;

import java.util.ArrayList;

public class BST {
    public Node root;

    public BST() {
        root = null;
    }

    /**
     * Returns node which contains given key
     */
    public Node search(BST.Node root, int key) {
        if(root == null || root.key == key)
            return root;

        if(root.key < key)
            return search(root.right, key);
        else
            return search(root.left, key);
    }

    /**
     * Inserts new node with given key into BST
     */
    public void insert(int key) {
        root = insertRecursive(root, key);
    }

    /**
     * Performs insertion recursively
     */
    private Node insertRecursive(Node root, int key) {
        if(root == null)
            return new Node(key);

        // find current key by traversing the BST
        if(root.key < key)
            root.right = insertRecursive(root.right, key);
        else
            root.left = insertRecursive(root.left, key);

        return root;
    }

    /**
     * Inorder traversal of BST which return int array of elements
     */
    public Integer[] inorder() {
        ArrayList<Integer> result = new ArrayList<>();
        inorderRecursive(root, result);
        Integer[] solution = new Integer[result.size()];
        return result.toArray(solution);
    }

    /**
     * Performs inorder traversal recursively
     */
    private void inorderRecursive(Node root, ArrayList<Integer> result) {
        if(root != null) {
            inorderRecursive(root.left, result);
            result.add(root.key);
//            System.out.println(root.key);
            inorderRecursive(root.right, result);
        }
    }

    /**
     * Deletes given key from BST
     */
    public void delete(int key) {
        root = deleteRecursive(root, key);
    }

    /**
     * Performs deletion recursively. 3 cases:
     * 1: node has no children
     * 2: node has 1 child
     * 3: node has 2 children
     */
    private Node deleteRecursive(Node root, int key) {
        if(root == null)
            return root;

        // find current key by traversing the BST
        if(root.key < key)
            root.right = deleteRecursive(root.right, key);
        else if (root.key > key)
            root.left = deleteRecursive(root.left, key);
        else { // current key is the key to be deleted
            if(root.left == null)
                return root.right; // only 1 child
            else if (root.right == null)
                return root.left; // only 1 child

            root.key = minValue(root.right);
            root.right = deleteRecursive(root.right, root.key);
        }

        return root;
    }

    /**
     * Find minimum value of current (sub)tree
     */
    private int minValue(Node root) {
        int minVal = root.key;
        while(root.left != null) {
            minVal = root.left.key;
            root = root.left;
        }
        return minVal;
    }

    public int depth() {
        return depthRecursive(root);
    }

    /**
     * Performs depth calculation of BST recursively
     */
    private int depthRecursive(Node root) {
        if(root == null)
            return -1;

        else {
            int left = depthRecursive(root.left);
            int right = depthRecursive(root.right);

            if (left > right)
                return left + 1;
            else
                return right + 1;
        }
    }

    /**
     * Finds max diameter of BST
     */
    public int diameter() {
        return diameterRecursive(root);
    }

    public int diameterRecursive(Node root) {
        if(root == null)
            return 0;
        int leftDepth = depthRecursive(root.left) + 1;
        int rightDepth = depthRecursive(root.right) + 1;

        int diamLeft = diameterRecursive(root.left);
        int diamRight = diameterRecursive(root.right);
        return Math.max(1 + leftDepth + rightDepth, Math.max(diamLeft, diamRight));
    }

    static public class Node {
        public int key;
        public boolean visited;
        public Node left;
        public Node right;

        public Node(int key) {
            this.key = key;
            this.visited = false;
        }
    }
}
