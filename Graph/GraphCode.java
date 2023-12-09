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
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                System.out.print("[" + e.src + "-" + e.dest + " " + e.wt + "], ");
            }
            System.out.println();
        }
    }

    public static void bfs(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                bfsUtil(graph, vis);
            }
        }
    }

    // Breadth First Search
    public static void bfsUtil(ArrayList<Edge>[] graph, boolean vis[]) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.length];

        q.add(0);
        while (q.size() > 0) {
            int rem = q.remove();
            if (visited[rem] == true) {
                continue;
            }
            visited[rem] = true;
            System.out.print(rem + " ");
            for (Edge e : graph[rem]) {
                if (visited[e.dest] == false) {
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int src) {
        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == false) {
                dfsUtil(graph, i, visited);
            }
        }
    }

    // Depth First Search
    public static void dfsUtil(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        visited[src] = true;
        System.out.print(src + " ");
        for (Edge e : graph[src]) {
            if (visited[e.dest] == false) {
                dfsUtil(graph, e.dest, visited);
            }
        }
    }

    // has path?
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {
        if (src == dest) {
            return true;
        }
        visited[src] = true;
        for (Edge e : graph[src]) {
            if (visited[e.dest] == false) {
                boolean res = hasPath(graph, e.dest, dest, visited);
                if (res == true) {
                    return true;
                }
            }
        }
        return false;
    }

    // detect cycle
    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == false) {
                boolean res = detectCycleUtil(graph, visited, i, -1);
                if (res == true) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int par) {
        vis[curr] = true;
        for (Edge e : graph[curr]) {
            if (vis[e.dest] == false) {
                boolean res = detectCycleUtil(graph, vis, e.dest, curr);
                if (res == true) {
                    return true;
                }
            } else if (e.dest != par) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int v = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
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
        bfs(graph);
        System.out.println("DFS");
        boolean[] visited = new boolean[v];
        dfs(graph, 0);

        System.out.println();
        System.out.println("Has Path?");
        System.out.println(hasPath(graph, 0, 6, visited));
        System.out.println("Has Path?");
        System.out.println(hasPath(graph, 0, 7, visited));
    }
}