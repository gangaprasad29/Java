// //////// Topologival Sort Using BFS (Kahn's Algorithm)  \\ \\\\\\\
// leetcode 210 

// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.Queue;

// public class Graph3 {
//     static class Edge {
//         int src;
//         int dest;
//         public Edge(int src, int dest) {
//             this.src = src; 
//             this.dest = dest;
//         }
//     }

//     static void createGraph(ArrayList<Edge>[] graph, int V) {
//         for (int i = 0; i < V; i++) {
//             graph[i] = new ArrayList<>();
//         }
//         graph[2].add(new Edge(2, 3));
//         graph[3].add(new Edge(3, 1));
//         graph[4].add(new Edge(4, 0));
//         graph[4].add(new Edge(4, 1));
//         graph[5].add(new Edge(5, 0));
//         graph[5].add(new Edge(5, 2));
//     }

//     public static void topSort(ArrayList<Edge>[] graph) {
//         int inDegree[] = new int[graph.length];
//         topSortHelper(graph, inDegree); // calculate inDegree

//         Queue<Integer> q = new LinkedList<>();
//         for (int i = 0; i < inDegree.length; i++) {
//             if (inDegree[i] == 0) {
//                 q.add(i);
//             }
//         }

//         // BFS
//         while (!q.isEmpty()) {
//             int curr = q.remove();
//             System.out.print(curr + " ");

//             for (int i = 0; i < graph[curr].size(); i++) {
//                 Edge e = graph[curr].get(i);
//                 inDegree[e.dest]--;
//                 if (inDegree[e.dest] == 0) {
//                     q.add(e.dest);
//                 }
//             }
//         }
//         System.out.println();
//     }

//     // Calculate inDegree
//     public static void topSortHelper(ArrayList<Edge>[] graph, int inDegree[]) {
//         for (int i = 0; i < graph.length; i++) {
//             for (int j = 0; j < graph[i].size(); j++) {
//                 Edge e = graph[i].get(j);
//                 inDegree[e.dest]++;
//             }
//         }
//     }

//     public static void main(String[] args) {
//         int V = 6; 
//         ArrayList<Edge> graph[] = new ArrayList[V];
//         createGraph(graph, V);
//         topSort(graph);
//     } 
// }



// /////// All Paths From sorce to Target \\ \\\\\ 

// import java.util.*;
// import java.util.ArrayList;

// public class Graph3 {
//    static class Edge {
//         int src;
//         int dest;
//         public Edge(int src, int dest) {
//             this.src = src; 
//             this.dest = dest;
//         }
//     }

//     static void createGraph(ArrayList<Edge>[] graph, int V) {
//         for (int i = 0; i < V; i++) {
//             graph[i] = new ArrayList<>();
//         }
//         graph[0].add(new Edge(0, 3));
        
//         graph[2].add(new Edge(2, 3));

//         graph[3].add(new Edge(3, 1));

//         graph[4].add(new Edge(4, 0));
//         graph[4].add(new Edge(4, 1));

//         graph[5].add(new Edge(5, 0));
//         graph[5].add(new Edge(5, 2));
//     }

//     public static void printAllPath(ArrayList<Edge> graph[],int src,int dest,String path){
//         // base case
//         if(src == dest){
//             System.out.println(path+dest);
//             return;
//         }
//         for(int i=0;i<graph[src].size();i++){
//             Edge e =graph[src].get(i);
//             printAllPath(graph, e.dest, dest, path+src);
//         }
//     }
//     public static void main(String[] args) {
//         int V = 6; 
//         ArrayList<Edge> graph[] = new ArrayList[V];
//         createGraph(graph, V);

//         int src=5 ,dest=1;
//         printAllPath(graph, src, dest, " ");
//     }
// }



 // /////// Dijkstra's Algorithm \\ \\\\\\

import java.util.*;

public class Graph3 {
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

    static void createGraph(ArrayList<Edge>[] graph, int V) {
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    static class Pair implements Comparable<Pair> {
        int node;
        int path; // renamed from dist
        public Pair(int node, int path) {
            this.node = node;
            this.path = path;
        }
        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path; // sort by smallest path
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src) {
        int[] dist = new int[graph.length]; // dist[i] => src to i ka dist

        for(int i=0;i<graph.length;i++){
            if(i != src){
                dist[i]=Integer.MAX_VALUE; // +infinity to all vertices except src
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        boolean[] visited = new boolean[graph.length];

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!visited[curr.node]){
                visited[curr.node] = true;
            }
            
            for (int i=0; i<graph[curr.node].size(); i++) {
                Edge e = graph[curr.node].get(i);
                int u = e.src;
                int v = e.dest;
                int w = e.wt;

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new Pair(v, dist[v])); // using path value in Pair
                }
            }
        }

        // Print shortest distances
        System.out.println("Shortest distances from node " + src + ":");
        for (int i = 0; i < graph.length ; i++) {
            System.out.println("To " + i + " -> " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph, V);

        dijkstra(graph, 0); 
    }
}
