package Graph;
import java.util.*;

public class CycleDetection {

    public static boolean hasCycle(int[][] graph) {
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0 && dfs(graph, visited, i, -1)) {
                return true;
            }
        }
        return false;
    }

    private static boolean dfs(int[][] graph, int[] visited, int node, int parent) {
        visited[node] = 1;
        for (int i = 0; i < graph.length; i++) {
            if (graph[node][i] == 1) {
                if (visited[i] == 1 && i != parent) {
                    return true;
                }
                if (visited[i] == 0 && dfs(graph, visited, i, node)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasCycleDFS(int[][] graph) {
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0 && dfs(graph, visited, i, -1)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycleBFS(int[][] graph) {
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0 && bfs(graph, visited, i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean bfs(int[][] graph, int[] visited, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = 1;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i = 0; i < graph.length; i++) {
                if (graph[curr][i] == 1) {
                    if (visited[i] == 1 && i != curr) {
                        return true;
                    }
                    if (visited[i] == 0) {
                        queue.add(i);
                        visited[i] = 1;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // direct method
        int[][] graph = {
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };

        System.out.println(hasCycle(graph));
        // using DFS
        int[][] graph2 = {
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };

        System.out.println(hasCycleDFS(graph2));

        // using BFS

        int[][] graph3 = {
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };

        System.out.println(hasCycleBFS(graph3));

    }
}
