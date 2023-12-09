package Graph;
import java.util.*;

public class BellmanFordAlgorithm {
    // for shortest paths from the source
    static class Edge{
        int src, dest, wt;
        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {

        // graph diagram
        // https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/
        graph[0].add(new Edge(0, 1, 4));
        graph[0].add(new Edge(0, 2, 5));
        graph[1].add(new Edge(1, 2, -3));
        graph[1].add(new Edge(1, 3, 3));
        graph[1].add(new Edge(1, 4, 2));
        graph[2].add(new Edge(2, 4, 4));
        graph[2].add(new Edge(2, 5, 1));
        graph[3].add(new Edge(3, 4, 5));
        graph[3].add(new Edge(3, 5, -2));
        graph[4].add(new Edge(4, 6, 3));
        graph[5].add(new Edge(5, 6, 2));
    }

    public static void bellmanFord(ArrayList<Edge> graph[], int src) {
        int n = graph.length; // Corrected: use the length of the array
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n; j++) {
                for(Edge edge : graph[j]) {
                    if(dist[j] != Integer.MAX_VALUE && dist[edge.dest] > dist[j] + edge.wt) {
                        dist[edge.dest] = dist[j] + edge.wt;
                    }
                }
            }
        }
        for(int i=0; i<n; i++) {
            System.out.println(i + " " + dist[i]);
        }
    }

    public static void main(String args[]) {
        int n = 7; // Corrected: number of vertices
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        createGraph(graph);
        bellmanFord(graph, 0);
    }
}
