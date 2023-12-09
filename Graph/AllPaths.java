package Graph;
import java.util.*;

public class AllPaths {
    static class Edge{
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

    // exponential
    public static void printAll(ArrayList<Edge> graph[], int src, int dest, String path) {
        if(src == dest) {
            System.out.println(path);
            return;
        }
        for(Edge edge : graph[src]) {
            printAll(graph, edge.dest, dest, path + edge.dest);
        }
    }

    public static void main(String[] args) {
        int n = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        createGraph(graph);
        printAll(graph, 0, 5, "0");
    }
}
