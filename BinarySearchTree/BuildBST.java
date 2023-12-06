package BinarySearchTree;

public class BuildBST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    public static Node insert(Node root, int val) {
        if(root == null) {
            root =  new Node(val);
            return root;
        }

        if(root.data > val) {
            insert(root.left, val);
        } else {
            insert(root.right, val);
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

    public static boolean search(Node root, int key) {
        if(root == null) {
            return false;
        }

        if(root.data == key) {
            return true;
        }

        if(root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public static int minValue(Node root) {
        int min = root.data;

        while(root.left != null) {
            min = root.left.data;
            root = root.left;
        }

        return min;
    }

    // delete node
    public static Node delete(Node root, int key) {
        if(root == null) {
            return null;
        }

        if(root.data > key) {
            root.left = delete(root.left, key);
        } else if(root.data < key) {
            root.right = delete(root.right, key);
        } else {
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }

            root.data = minValue(root.right);
            root.right = delete(root.right, root.data);
        }

        return root;
    }

    //print in range
    public static void printInRange(Node root, int k1, int k2) {
        if(root == null) {
            return;
        }

        if(root.data > k1) {
            printInRange(root.left, k1, k2);
        }

        if(root.data >= k1 && root.data <= k2) {
            System.out.print(root.data + " ");
        }

        if(root.data < k2) {
            printInRange(root.right, k1, k2);
        }
    }

    // print array
    public static void printArray(int[] arr, int len) {
        for(int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // root to leaf path
    public static void printPath(Node root, int[] path, int pathLen) {
        if(root == null) {
            return;
        }

        path[pathLen] = root.data;
        pathLen++;

        if(root.left == null && root.right == null) {
            printArray(path, pathLen);
        } else {
            printPath(root.left, path, pathLen);
            printPath(root.right, path, pathLen);
        }
    }

    // print all paths
    public static void printAllPaths(Node root) {
        int[] path = new int[1000];
        printPath(root, path, 0);
    }

    // validate bst
    public static boolean isBST(Node root, int min, int max) {
        if(root == null) {
            return true;
        }

        if(root.data < min || root.data > max) {
            return false;
        }

        return isBST(root.left, min, root.data - 1) && isBST(root.right, root.data + 1, max);
    }

    // mirror a bst
    public static Node mirror(Node root) {
        if(root == null) {
            return null;
        }

        Node left = mirror(root.left);
        Node right = mirror(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 1, 3, 4, 2, 7 };
        Node root = null;

        for(int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }
        inorder(root);

        System.out.println();

        System.out.println(search(root, 4));

        root = delete(root, 4);

        inorder(root);

        System.out.println();

        printInRange(root, 2, 5);

        System.out.println();

        printAllPaths(root);
    }
}
