package Graph;

import java.util.*;

public class GraphCode {
    
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

    }

    public static void display(ArrayList<Edge>[] graph) {
        for(int i = 0; i < graph.length; i++) {
            System.out.print(i + " -> ");
            for(int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                System.out.print("[" + e.src + "-" + e.dest + " " + e.wt + "], ");
            }
            System.out.println();
        }
    }

    // Breadth First Search
    public static void bfs(ArrayList<Edge>[] graph, int src) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.length];

        q.add(src);
        while(q.size() > 0) {
            int rem = q.remove();
            if(visited[rem] == true) {
                continue;
            }
            visited[rem] = true;
            System.out.print(rem + " ");
            for(Edge e : graph[rem]) {
                if(visited[e.dest] == false) {
                    q.add(e.dest);
                }
            }
        }
    }

    // Depth First Search
    public static void dfs(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        visited[src] = true;
        System.out.print(src + " ");
        for(Edge e : graph[src]) {
            if(visited[e.dest] == false) {
                dfs(graph, e.dest, visited);
            }
        }
    }

    // has path?
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {
        if(src == dest) {
            return true;
        }
        visited[src] = true;
        for(Edge e : graph[src]) {
            if(visited[e.dest] == false) {
                boolean res = hasPath(graph, e.dest, dest, visited);
                if(res == true) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        
        int v = 7;
        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 3, 40));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 2, 10));

        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, 10));

        graph[3].add(new Edge(3, 0, 40));
        graph[3].add(new Edge(3, 2, 10));
        graph[3].add(new Edge(3, 4, 2));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 3));
        graph[4].add(new Edge(4, 6, 8));

        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6, 3));

        graph[6].add(new Edge(6, 4, 8));
        graph[6].add(new Edge(6, 5, 3));

        display(graph);

        System.out.println("BFS");
        bfs(graph, 0);
        System.out.println("DFS");
        boolean[] visited = new boolean[v];
        dfs(graph, 0, visited);

        System.out.println();
        System.out.println("Has Path?");
        System.out.println(hasPath(graph, 0, 6, visited));
        System.out.println("Has Path?");
        System.out.println(hasPath(graph, 0, 7, visited));
    }
}