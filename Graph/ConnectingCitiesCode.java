package Graph;

import java.util.*;

public class ConnectingCitiesCode {
    // connecting cities problem

    static class Edge implements Comparable<Edge> {
        int dest;
        int cost;

        Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e2) {
            return Integer.compare(this.cost, e2.cost);
        }
    }

    public static int connectCities(int cities[][]) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[cities.length];

        // Start with the first city
        pq.add(new Edge(0, 0));

        int cost = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.remove();
            int currCity = curr.dest;

            if (!vis[currCity]) {
                vis[currCity] = true;
                cost += curr.cost;

                for (int i = 0; i < cities[currCity].length; i++) {
                    if (cities[currCity][i] != 0) {
                        pq.add(new Edge(i, cities[currCity][i]));
                    }
                }
            }
        }

        return cost;
    }

    public static void main(String args[]) {
        int connections[][] = { { 1, 2, 5 }, { 1, 3, 6 }, { 2, 3, 1 } };
        System.out.println(connectCities(connections));
    }
}
