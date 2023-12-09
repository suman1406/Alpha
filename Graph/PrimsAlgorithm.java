package Graph;
import java.util.*;

public class PrimsAlgorithm {

    static class Edge {
        int src, dest, wt;
        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {

        // graph diagram
        // https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 3, 6));
        graph[1].add(new Edge(1, 2, 3));
        graph[1].add(new Edge(1, 3, 8));
        graph[1].add(new Edge(1, 4, 5));
        graph[2].add(new Edge(2, 4, 7));
        graph[3].add(new Edge(3, 4, 9));
        graph[3].add(new Edge(3, 5, 3));
        graph[4].add(new Edge(4, 5, 1));
    }

    public static void prims(ArrayList<Edge> graph[], int src) {
        int n = graph.length;
        boolean visited[] = new boolean[n];
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for(int i=0; i<n; i++) {
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            for(int j=0; j<n; j++) {
                if(!visited[j] && dist[j] < min) {
                    min = dist[j];
                    minIdx = j;
                }
            }
            visited[minIdx] = true;
            for(Edge edge : graph[minIdx]) {
                if(!visited[edge.dest] && dist[edge.dest] > edge.wt) {
                    dist[edge.dest] = edge.wt;
                }
            }
        }
        for(int i=0; i<n; i++) {
            System.out.println(i + " " + dist[i]);
        }
    }

    public static void main(String args[]) {
        int n = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        createGraph(graph);
        prims(graph, 0);
    }
}
