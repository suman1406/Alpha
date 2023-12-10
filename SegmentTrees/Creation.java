package SegmentTrees;

public class Creation {
    // Creation of Segment Trees
    static void buildTree(int[] arr, int[] tree, int start, int end, int treeNode) {
        if (start == end) {
            tree[treeNode] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        buildTree(arr, tree, start, mid, 2 * treeNode);
        buildTree(arr, tree, mid + 1, end, 2 * treeNode + 1);
        tree[treeNode] = tree[2 * treeNode] + tree[2 * treeNode + 1];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] tree = new int[10];
        buildTree(arr, tree, 0, 4, 1);
        for (int i = 1; i < 10; i++)
            System.out.print(tree[i] + " ");
    }
}
