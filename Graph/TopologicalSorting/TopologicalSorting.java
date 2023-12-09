package Graph.TopologicalSorting;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSorting {
    static class Edge {
        int src, dest;
        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 3));
        graph[1].add(new Edge(1, 4));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 5));
        graph[4].add(new Edge(4, 5));
    }

    public static void topSort(ArrayList<Edge>[] graph) {
        int n = graph.length;
        boolean visited[] = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                topSortUtil(graph, i, visited, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void topSortUtil(ArrayList<Edge>[] graph, int src, boolean visited[], Stack<Integer> stack) {
        visited[src] = true;
        for (Edge edge : graph[src]) {
            if (!visited[edge.dest]) {
                topSortUtil(graph, edge.dest, visited, stack);
            }
        }
        stack.push(src);
    }

    public static void main(String[] args) {
        int n = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        createGraph(graph);
        topSort(graph);
    }
}
