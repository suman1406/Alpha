package Graph;
import java.util.*;

public class CheapestFlightsKstops {
    // dijkstras method
    // https://leetcode.com/problems/cheapest-flights-within-k-stops/discuss/115541/JavaPython-Priority-Queue-Solution

    // bellman ford method
    // https://leetcode.com/problems/cheapest-flights-within-k-stops/discuss/115541/JavaPython-Priority-Queue-Solution/116949

    static class Edge {
        int src, dest, wt;
        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static void createGraph(int flights[][], ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];
            graph[src].add(new Edge(src, dest, wt));
        }
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for(int i=0; i<=K; i++) {
            int temp[] = Arrays.copyOf(dist, n);
            for(int j=0; j<n; j++) {
                for(Edge edge : graph[j]) {
                    if(dist[j] != Integer.MAX_VALUE && temp[edge.dest] > dist[j] + edge.wt) {
                        temp[edge.dest] = dist[j] + edge.wt;
                    }
                }
            }
            dist = temp;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public static void main(String args[]) {
        int n = 3;
        int flights[][] = {{0,1,100},{1,2,100},{0,2,500}};
        int src = 0;
        int dst = 2;
        int K = 1;
        System.out.println(findCheapestPrice(n, flights, src, dst, K));
    }
}
