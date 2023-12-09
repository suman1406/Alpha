package Graph;

public class DisjointSetUnion {
    // Disjoint Set Union (DSU) is a data structure that keeps track of a set of elements partitioned into a number of disjoint (non-overlapping) subsets.
    // It supports two operations:
    // 1. Find: Determine which subset a particular element is in. This can be used for determining if two elements are in the same subset.
    // 2. Union: Join two subsets into a single subset.

    // DSU is used in Kruskal's algorithm to find the minimum spanning tree of a graph.
    // It is also used in the problem of finding the number of connected components in a graph.

    // The following implementation uses path compression and union by rank to achieve an amortized time complexity of O(α(n)) for each operation, where α(n) is the inverse Ackermann function.

    static class DSU {
        int parent[];
        int rank[];

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);

            if (xRoot == yRoot) {
                return;
            }

            if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
            } else if (rank[xRoot] > rank[yRoot]) {
                parent[yRoot] = xRoot;
            } else {
                parent[yRoot] = xRoot;
                rank[xRoot]++;
            }
        }
    }

    public static void main(String args[]) {
        DSU dsu = new DSU(5);

        dsu.union(0, 2);
        dsu.union(4, 2);
        dsu.union(3, 1);

        System.out.println(dsu.find(4));
        System.out.println(dsu.find(0));
        System.out.println(dsu.find(3));
        System.out.println(dsu.find(1));
        System.out.println(dsu.find(2));
    }
}
