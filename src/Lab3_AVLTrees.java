public class Lab3_AVLTrees {
    static class Node {
        int value;
        Node left, right;
        int height;

        Node(int value){
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }
    }

    int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    int getBalance(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    Node rotateRight(Node node) {
        Node newRoot = node.left;
        Node transfer = newRoot.right;

        newRoot.right = node;
        node.left = transfer;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        newRoot.height = Math.max(height(newRoot.left), height(newRoot.right)) + 1;

        return newRoot;
    }

    Node rotateLeft(Node node) {
        Node newRoot = node.right;
        Node transfer = newRoot.left;

        newRoot.left = node;
        node.right = transfer;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        newRoot.height = Math.max(height(newRoot.left), height(newRoot.right)) + 1;

        return newRoot;
    }

    public Node insert(Node node, int value) {
        if (node == null) {
            return (new Node(value));
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
            System.out.println(" Inserted " + value + " to left of " + node.value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
            System.out.println(" Inserted " + value + " to right of " + node.value);
        } else {
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && value < node.left.value) {
            return rotateRight(node);
        }

        if (balance < -1 && value > node.right.value) {
            return rotateLeft(node);
        }

        if (balance > 1 && value > node.left.value) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && value < node.right.value) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.value);
        }
    }

    public static void main(String args[]) {
        Lab3_AVLTrees tree = new Lab3_AVLTrees();
        Node root = new Node(45);

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

        System.out.println("Traversing tree inorder: ");
        tree.traverseInOrder(root);

        root = tree.insert(root, 32);
        root = tree.insert(root, 42);
        root = tree.insert(root, 52);
        root = tree.insert(root, 62);

        System.out.println("Traversing tree inorder after adding elements: ");
        tree.traverseInOrder(root);

        System.out.println("Traversing tree postorder after adding elements: ");
        tree.traversePostOrder(root);
    }
}
