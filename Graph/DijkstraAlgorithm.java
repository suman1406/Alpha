package Graph;
import java.util.*;

public class DijkstraAlgorithm {
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
        // https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 5));
        graph[1].add(new Edge(1, 3, 1));
        graph[1].add(new Edge(1, 4, 2));
        graph[2].add(new Edge(2, 3, 9));
        graph[3].add(new Edge(3, 5, 4));
        graph[4].add(new Edge(4, 5, 6));
    }

    public static void dijkstra(ArrayList<Edge> graph[], int src) {
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
                if(!visited[edge.dest] && dist[edge.dest] > dist[minIdx] + edge.wt) {
                    dist[edge.dest] = dist[minIdx] + edge.wt;
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
        dijkstra(graph, 0);
    }    
}
