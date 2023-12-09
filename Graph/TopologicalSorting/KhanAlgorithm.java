package Graph.TopologicalSorting;
import java.util.*;

public class KhanAlgorithm {
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

    public static void calcIndeg(ArrayList<Edge> graph[], int indeg[]) {
        for(int i= 0; i<graph.length; i++) {
            for(Edge edge : graph[i]) {
                indeg[edge.dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge> graph[]) {
        int n = graph.length;
        int indeg[] = new int[n];
        calcIndeg(graph, indeg);
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if(indeg[i] == 0) {
                queue.add(i);
            }
        }
        // bfs
        while(!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for(Edge edge : graph[node]) {
                indeg[edge.dest]--;
                if(indeg[edge.dest] == 0) {
                    queue.add(edge.dest);
                }
            }
        }

        System.out.println();
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
