package SegmentTrees;

public class Queries {

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
    
    // Range Sum Queries
    static int query(int[] tree, int start, int end, int treeNode, int left, int right) {
        // completely outside
        if (start > right || end < left)
            return 0;
        // completely inside
        if (start >= left && end <= right)
            return tree[treeNode];
        // partially inside and partially outside
        int mid = (start + end) / 2;
        int ans1 = query(tree, start, mid, 2 * treeNode, left, right);
        int ans2 = query(tree, mid + 1, end, 2 * treeNode + 1, left, right);
        return ans1 + ans2;
    }

    // Update Queries
    static void update(int[] arr, int[] tree, int start, int end, int treeNode, int idx, int value) {
        if (start == end) {
            arr[idx] = value;
            tree[treeNode] = value;
            return;
        }
        int mid = (start + end) / 2;
        if (idx > mid)
            update(arr, tree, mid + 1, end, 2 * treeNode + 1, idx, value);
        else
            update(arr, tree, start, mid, 2 * treeNode, idx, value);
        tree[treeNode] = tree[2 * treeNode] + tree[2 * treeNode + 1];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] tree = new int[10];
        buildTree(arr, tree, 0, 4, 1);
        for (int i = 1; i < 10; i++)
            System.out.print(tree[i] + " ");
        System.out.println();
        System.out.println(query(tree, 0, 4, 1, 2, 4));
        update(arr, tree, 0, 4, 1, 2, 10);
        for (int i = 1; i < 10; i++)
            System.out.print(tree[i] + " ");
    }
}
