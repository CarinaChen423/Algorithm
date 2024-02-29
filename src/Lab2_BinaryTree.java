public class Lab2_BinaryTree {
    static class Node {
        int value;
        Node left, right;

        Node(int value){
            this.value = value;
            left = null;
            right = null;
        }
    }

    public void insert(Node node, int value) {
        if (value < node.value) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                System.out.println(" Inserted " + value + " to left of " + node.value);
                node.left = new Node(value);
            }
        } else if (value > node.value) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                System.out.println("  Inserted " + value + " to right of " + node.value);
                node.right = new Node(value);
            }
        }
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    public static void main(String args[]) {
        Lab2_BinaryTree tree = new Lab2_BinaryTree();
        Node root = new Node(45);
        System.out.println("Building Binary tree with root value: " + root.value);
        tree.insert(root, 27);
        tree.insert(root, 67);
        tree.insert(root, 36);
        tree.insert(root, 56);
        tree.insert(root, 15);
        tree.insert(root, 75);
        tree.insert(root, 31);
        tree.insert(root, 53);
        tree.insert(root, 39);
        tree.insert(root, 64);
        System.out.println();
        System.out.println("Traversing tree inorder: ");
        tree.traverseInOrder(root);
    }
}
