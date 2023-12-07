package BinarySearchTree;

public class AVLTrees {
    static class Node {
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.height = 1;
            this.left = null;
            this.right = null;
        }
    }

    public static Node root;

    public static int height(Node root) {
        if(root == null) {
            return 0;
        }

        return root.height;
    }

    public static int getBalance(Node root) {
        if(root == null) {
            return 0;
        }

        return height(root.left) - height(root.right);
    }

    public static Node rightRotate(Node root) {
        Node x = root.left;
        Node y = x.right;

        x.right = root;
        root.left = y;

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    public static Node leftRotate(Node root) {
        Node x = root.right;
        Node y = x.left;

        x.left = root;
        root.right = y;

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    public static Node insert(Node root, int val) {
        if(root == null) {
            root = new Node(val);
            return root;
        }

        if(root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);

        if(balance > 1 && val < root.left.data) {
            return rightRotate(root);
        }

        if(balance < -1 && val > root.right.data) {
            return leftRotate(root);
        }

        if(balance > 1 && val > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if(balance < -1 && val < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public static void inorder(Node root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        System.out.println("Inorder traversal of the constructed AVL tree is: ");
        inorder(root);
    }
}
