package Graph;

public class BipartiteGraphCode {

    public static boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0 && !bfs(graph, color, i, 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean bfs(int[][] graph, int[] color, int node, int c) {
        if (color[node] != 0) {
            return color[node] == c;
        }
        color[node] = c;
        for (int i = 0; i < graph.length; i++) {
            if (graph[node][i] == 1 && !bfs(graph, color, i, -c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };
        System.out.println(isBipartite(graph));
    }
}
