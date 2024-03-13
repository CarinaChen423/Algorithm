public class Lab3_AVLTrees {
    static class Node {
        int value;
        Node left, right;
        int height;

        Node(int value){
            this.value = value;
            left = null;
            right = null;
            height = 1; // New node is initially added at leaf
        }
    }

    private int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    private int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    public Node insert(Node node, int value) {
        if (node == null)
            return (new Node(value));

        if (value < node.value)
            node.left = insert(node.left, value);
        else if (value > node.value)
            node.right = insert(node.right, value);
        else // Duplicate values not allowed
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && value < node.left.value)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && value > node.right.value)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && value > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && value < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(" " + node.value);
        }
    }
    public static void main(String args[]) {
        Lab3_AVLTrees tree = new Lab3_AVLTrees();
        Node root = null;
        root = tree.insert(root, 45);
        root = tree.insert(root, 27);
        root = tree.insert(root, 67);
        root = tree.insert(root, 36);
        root = tree.insert(root, 56);
        root = tree.insert(root, 15);
        root = tree.insert(root, 75);
        root = tree.insert(root, 31);
        root = tree.insert(root, 53);
        root = tree.insert(root, 39);
        root = tree.insert(root, 64);

        System.out.println("Postorder traversal before adding unbalanced nodes:");
        tree.postOrderTraversal(root);

        root = tree.insert(root, 32);
        root = tree.insert(root, 42);
        root = tree.insert(root, 52);
        root = tree.insert(root, 62);

        System.out.println("\nPostorder traversal after adding nodes and rebalancing:");
        tree.postOrderTraversal(root);
    }
}
