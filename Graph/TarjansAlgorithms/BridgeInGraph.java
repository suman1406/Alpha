package Graph.TarjansAlgorithms;

import java.util.*;

public class BridgeInGraph { //Bridge in graph
    // Tarjan's Algorithm Notes
    // 1. Tarjan's Algorithm is used to find the number of strongly connected
    // components in a graph.
    // 2. A strongly connected component is a component in a graph where every
    // vertex is reachable from every other vertex.
    // 3. Tarjan's Algorithm is a two step process:
    // a. Find the topological sort of the graph.
    // b. Reverse the graph.
    // c. Do a DFS on the reversed graph in the order of the topological sort.
    // d. The number of DFS calls made in the second step is the number of strongly
    // connected components in the graph.
    // 4. Time Complexity: O(V + E)
    // 5. Space Complexity: O(V)
    // 6. The graph should be a DAG (Directed Acyclic Graph)
    // 7. The graph should be a directed graph.
    // 8. The graph should be a connected graph.
    // 9. The graph should be a weighted graph.
    // 10. The graph should be an unweighted graph.
    // 11. The graph should be a cyclic graph.
    // 12. The graph should be an undirected graph.
    // 13. The graph should be a disconnected graph.
    // 14. The graph should be a bipartite graph.

    // Function to find the number of strongly connected components in a graph.
    public static int tarjansAlgorithm(ArrayList<ArrayList<Integer>> graph, int n) {
        // Step 1: Find the topological sort of the graph.
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                topologicalSort(graph, i, visited, stack);
            }
        }

        // Step 2: Reverse the graph.
        ArrayList<ArrayList<Integer>> reverseGraph = reverseGraph(graph, n);

        // Step 3: Do a DFS on the reversed graph in the order of the topological sort.
        int count = 0;
        Arrays.fill(visited, false);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                dfs(reverseGraph, node, visited);
                count++;
            }
        }

        // Step 4: Return the number of strongly connected components in the graph.
        return count;
    }

    // Function to find the topological sort of the graph.
    public static void topologicalSort(ArrayList<ArrayList<Integer>> graph, int node, boolean[] visited,
            Stack<Integer> stack) {
        visited[node] = true;
        for (int neighbour : graph.get(node)) {
            if (!visited[neighbour]) {
                topologicalSort(graph, neighbour, visited, stack);
            }
        }
        stack.push(node);
    }

    // Function to reverse the graph.
    public static ArrayList<ArrayList<Integer>> reverseGraph(ArrayList<ArrayList<Integer>> graph, int n) {
        ArrayList<ArrayList<Integer>> reverseGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int neighbour : graph.get(i)) {
                reverseGraph.get(neighbour).add(i);
            }
        }
        return reverseGraph;
    }

    // Function to do a DFS on the graph.
    public static void dfs(ArrayList<ArrayList<Integer>> graph, int node, boolean[] visited) {
        visited[node] = true;
        for (int neighbour : graph.get(node)) {
            if (!visited[neighbour]) {
                dfs(graph, neighbour, visited);
            }
        }
    }

    // Bridge in graph
    static int time = 0; // Global variable to keep track of discovery time

    // Function to find bridges in the graph
    public static List<int[]> findBridges(ArrayList<ArrayList<Integer>> graph, int n) {
        List<int[]> bridges = new ArrayList<>();
        int[] disc = new int[n]; // Discovery time of each vertex
        int[] low = new int[n]; // Lowest discovery time reachable from the vertex
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1, disc, low, visited, graph, bridges);
            }
        }

        return bridges;
    }

    // DFS traversal to find bridges
    private static void dfs(int u, int parent, int[] disc, int[] low, boolean[] visited,
            ArrayList<ArrayList<Integer>> graph, List<int[]> bridges) {
        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (int v : graph.get(u)) {
            if (!visited[v]) {
                dfs(v, u, disc, low, visited, graph, bridges);

                low[u] = Math.min(low[u], low[v]);

                // If the lowest discovery time reachable from v is greater than the
                // discovery time of u, then (u, v) is a bridge
                if (low[v] > disc[u]) {
                    bridges.add(new int[] { u, v });
                }
            } else if (v != parent) {
                // Update the lowest discovery time of u with the discovery time of v
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    // Driver Code
    public static void main(String args[]) {
        // Create a graph.
        int n = 5;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges.
        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(0);
        graph.get(1).add(3);
        graph.get(3).add(4);

        // Print the number of strongly connected components in the graph.
        System.out.println(tarjansAlgorithm(graph, n));

        // Find and print bridges in the graph.
        List<int[]> bridges = findBridges(graph, n);
        System.out.println("Bridges in the graph:");
        for (int[] bridge : bridges) {
            System.out.println(bridge[0] + " - " + bridge[1]);
        }
    }

}
