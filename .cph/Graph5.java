import java.util.*;
import java.util.Queue;
import java.util.LinkedList;

public class Graph5 {
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

    static void createGraph(ArrayList<Edge>[] graph, int[][] flights) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];
            graph[src].add(new Edge(src, dest, wt));
        }
    }

    static class Pair {
        int node;
        int cost;
        int stops;
        public Pair(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public static int cheapestFlight(ArrayList<Edge>[] graph, int src, int dest, int k) {
        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0, 0));

        while (!q.isEmpty()) {
            Pair curr = q.remove();

            if (curr.stops > k) continue;

            for (Edge e : graph[curr.node]) {
                int newCost = curr.cost + e.wt;
                if (newCost < dist[e.dest] && curr.stops <= k) {
                    dist[e.dest] = newCost;
                    q.add(new Pair(e.dest, newCost, curr.stops + 1));
                }
            }
        }

        if(dist[dest] == Integer.MAX_VALUE){
            return -1;
        }else{
            return dist[dest];
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {
            {0, 1, 100},
            {0, 2, 500},
            {1, 2, 100},
            {1, 3, 600},
            {2, 3, 200}
        };

        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(graph, flights);

        int src = 0, dest = 3, k = 1;
        int result = cheapestFlight(graph, src, dest, k);

        System.out.println(result); 
    }
}
