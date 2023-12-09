package Graph;

import java.util.*;

public class KruskalsAlgorithm {
    // Kruskal's algorithm is a greedy algorithm that finds a minimum spanning tree
    // for a weighted undirected graph.
    // It finds a subset of the edges that forms a tree that includes every vertex,
    // where the total weight of all the edges in the tree is minimized.
    // If the graph is not connected, then it finds a minimum spanning forest (a
    // minimum spanning tree for each connected component).
    // Kruskal's algorithm is an example of a matroid greedy algorithm.

    // The following implementation uses a disjoint set union data structure to keep
    // track of the connected components in the graph.
    // It has a time complexity of O(E log V), where E is the number of edges and V
    // is the number of vertices.

    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        public int compareTo(Edge edge) {
            return this.weight - edge.weight;
        }
    }

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

        int find(int i) {
            if (parent[i] == i) {
                return i;
            }

            return parent[i] = find(parent[i]);
        }

        void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);

            if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
            } else if (rank[yRoot] < rank[xRoot]) {
                parent[yRoot] = xRoot;
            } else {
                parent[yRoot] = xRoot;
                rank[xRoot]++;
            }
        }
    }

    static class Graph {
        int V;
        int E;
        Edge edges[];

        Graph(int V, int E) {
            this.V = V;
            this.E = E;
            edges = new Edge[E];
        }

        void addEdge(int i, int src, int dest, int weight) {
            edges[i] = new Edge(src, dest, weight);
        }

        void kruskalMST() {
            Edge result[] = new Edge[V];
            int e = 0;
            int i = 0;

            for (i = 0; i < V; i++) {
                result[i] = new Edge(0, 0, 0);
            }

            Arrays.sort(edges);

            DSU dsu = new DSU(V);

            i = 0;

            while (e < V - 1) {
                Edge nextEdge = edges[i++];

                int x = dsu.find(nextEdge.src);
                int y = dsu.find(nextEdge.dest);

                if (x != y) {
                    result[e++] = nextEdge;
                    dsu.union(x, y);
                }
            }

            System.out.println("Following are the edges in the constructed MST");

            for (i = 0; i < e; i++) {
                System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
            }
        }
    }

    public static void main(String args[]) {
        int V = 4;
        int E = 5;
        Graph graph = new Graph(V, E);

        graph.addEdge(0, 0, 1, 10);
        graph.addEdge(1, 0, 2, 6);
        graph.addEdge(2, 0, 3, 5);
        graph.addEdge(3, 1, 3, 15);
        graph.addEdge(4, 2, 3, 4);

        graph.kruskalMST();
    }

}
