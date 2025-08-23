// import java.util.*;
// import java.util.Queue;
// import java.util.LinkedList;

// public class Graph5 {
//     static class Edge {
//         int src;
//         int dest;
//         int wt;
//         public Edge(int src, int dest, int wt) {
//             this.src = src;
//             this.dest = dest;
//             this.wt = wt;
//         }
//     }

//     static void createGraph(ArrayList<Edge>[] graph, int[][] flights) {
//         for (int i = 0; i < graph.length; i++) {
//             graph[i] = new ArrayList<>();
//         }
//         for (int i = 0; i < flights.length; i++) {
//             int src = flights[i][0];
//             int dest = flights[i][1];
//             int wt = flights[i][2];
//             graph[src].add(new Edge(src, dest, wt));
//         }
//     }

//     static class Pair {
//         int node;
//         int cost;
//         int stops;
//         public Pair(int node, int cost, int stops) {
//             this.node = node;
//             this.cost = cost;
//             this.stops = stops;
//         }
//     }

//     public static int cheapestFlight(ArrayList<Edge>[] graph, int src, int dest, int k) {
//         int[] dist = new int[graph.length];
//         Arrays.fill(dist, Integer.MAX_VALUE);
//         dist[src] = 0;

//         Queue<Pair> q = new LinkedList<>();
//         q.add(new Pair(src, 0, 0));

//         while (!q.isEmpty()) {
//             Pair curr = q.remove();

//             if (curr.stops > k) continue;

//             for (Edge e : graph[curr.node]) {
//                 int newCost = curr.cost + e.wt;
//                 if (newCost < dist[e.dest] && curr.stops <= k) {
//                     dist[e.dest] = newCost;
//                     q.add(new Pair(e.dest, newCost, curr.stops + 1));
//                 }
//             }
//         }

//         if(dist[dest] == Integer.MAX_VALUE){
//             return -1;
//         }else{
//             return dist[dest];
//         }
//     }

//     public static void main(String[] args) {
//         int n = 4;
//         int[][] flights = {
//             {0, 1, 100},
//             {0, 2, 500},
//             {1, 2, 100},
//             {1, 3, 600},
//             {2, 3, 200}
//         };

//         ArrayList<Edge>[] graph = new ArrayList[n];
//         createGraph(graph, flights);

//         int src = 0, dest = 3, k = 1;
//         int result = cheapestFlight(graph, src, dest, k);

//         System.out.println(result); 
//     }
// }





// ////// Connecting Cities with minimum cost 

// import java.util.PriorityQueue;

// public class Graph5 {
//     static class Edge implements Comparable<Edge> {
//         int dest;
//         int cost;

//         public Edge(int dest, int cost) {
//             this.dest = dest;
//             this.cost = cost;
//         }

//         @Override
//         public int compareTo(Edge e2) {
//             return this.cost - e2.cost;   // ascending order by cost
//         }
//     }

//     public static int connectCities(int cities[][]) {
//         PriorityQueue<Edge> pq = new PriorityQueue<>();
//         boolean visited[] = new boolean[cities.length];

//         pq.add(new Edge(0, 0));
//         int finalCost = 0;

//         while (!pq.isEmpty()) {
//             Edge curr = pq.remove();
//             if (!visited[curr.dest]) {
//                 visited[curr.dest] = true;
//                 finalCost += curr.cost;

//                 for (int i = 0; i < cities[curr.dest].length; i++) {
//                     if (cities[curr.dest][i] != 0 && !visited[i]) {
//                         pq.add(new Edge(i, cities[curr.dest][i]));
//                     }
//                 }
//             }
//         }
//         return finalCost;
//     }

//     public static void main(String[] args) {
//         int cities[][] = {
//             {0, 1, 2, 3, 4},
//             {1, 0, 5, 0, 7},
//             {2, 5, 0, 6, 0},
//             {3, 0, 6, 0, 0},
//             {4, 7, 0, 0, 0}
//         };
//         System.out.println(connectCities(cities));  
//     }
// }




// /////// Disjoint Set Data Structure(implementation)

// import java.util.*;
// public class Graph5 {
//     static int n=7;
//     static int parent[]=new int[n];
//     static int rank[]=new int[n];

//     public static void init(){
//         for(int i=0;i<n;i++){
//             parent[i]=i;
//         }
//     }

//     public static int find(int x){
//         if(x == parent[x]){
//             return x;
//         }
//         return parent[x] = find(parent[x]); // recursive call
//     }

//     public static void Union(int a ,int b){
//         int parA=find(a);
//         int parB=find(b);

//         if(rank[parA]==rank[parB]){
//             parent[parB]=parA;
//             rank[parA]++;
//         }else if(rank[parA] < rank[parB]){
//             parent[parA]=parB;
//         }else{
//             parent[parB]=parA;
//         }
//     }
//     public static void main(String[] args) {
//         init();

//         System.out.println(find(3));
//         Union(1,3);
//         System.out.println(find(3));
//         Union(2,4);
//         Union(3,6);
//         Union(1,4);
//         System.out.println(find(3));
//         System.out.println(find(4));
//         Union(1,5);
//     }
// }





// //////// Kruskal's Algorithm 

import java.util.ArrayList;
import java.util.Collections;

public class Graph5 {
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt; // sort by weight ascending
        }
    }

    static int n = 4; // vertices
    static int parent[] = new int[n];
    static int rank[] = new int[n];

    static void createGraph(ArrayList<Edge> edges) {
        // edges
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    public static void init() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0; // initialize rank as 0
        }
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]); // path compression
    }

    public static void Union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (parA == parB) return;

        if (rank[parA] == rank[parB]) {
            parent[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            parent[parA] = parB;
        } else {
            parent[parB] = parA;
        }
    }

    public static void KruskalMST(ArrayList<Edge> edges, int v) {
        Collections.sort(edges);
        init(); // initialize DSU

        int mstCost = 0;
        int count = 0;

        for (int i = 0; i < edges.size() && count < v - 1; i++) {
            Edge e = edges.get(i);

            int parA = find(e.src);
            int parB = find(e.dest);

            if (parA != parB) {
                Union(e.src, e.dest);
                mstCost += e.wt;
                count++;
                System.out.println("Edge chosen: " + e.src + " - " + e.dest + " wt=" + e.wt);
            }
        }
        System.out.println("MST cost = " + mstCost);
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        KruskalMST(edges, v);
    }
}
