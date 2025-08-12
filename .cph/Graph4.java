// //////// Bellman Algorithm \\ \\\\\


// import java.util.ArrayList;

// public class Graph4 {
//     static class Edge{
//         int src;
//         int dest;
//         int wt;
//         public Edge(int src,int dest,int wt){
//             this.src=src;
//             this.dest=dest;
//             this.wt=wt;
//         }
//     }
//     static void createGraph(ArrayList<Edge> graph[],int V){
//         for(int i=0;i<V;i++){
//             graph[i]=new ArrayList<>();
//         }
//         graph[0].add(new Edge(0, 1, 2));
//         graph[0].add(new Edge(0, 1, 2));

//         graph[1].add(new Edge(1, 2, -4));

//         graph[2].add(new Edge(2, 3, 2));

//         graph[3].add(new Edge(3, 4, 4));

//         graph[4].add(new Edge(4, 1, -1));
//     }

//     public static void bellmanFord(ArrayList<Edge> graph[],int src){
//         int dist[]=new int[graph.length];
//         for(int i=0;i<dist.length;i++){
//             if(i != src){
//                 dist[i]=Integer.MAX_VALUE;
//             }
//         }
//         // algo
//         int V=graph.length;
//         for(int i=0;i<V-1;i++){
//             // edges -> O(E) not O(n^3)
//             for(int j=0;j<graph.length;j++){   // for vertex
//                 for(int k=0;k<graph[j].size();k++){  // for all edges of vertex
//                     Edge e = graph[j].get(k);
//                     // u,v,wt
//                     int u=e.src;
//                     int v=e.dest;
//                     int wt=e.wt;
//                     // relaxation
//                     if(dist[u] != Integer.MAX_VALUE && dist[u]+wt < dist[v]){
//                         dist[v]=dist[u]+wt;
//                     }
//                 }
//             }
//         }
//         // print
//     for (int i = 0; i < dist.length; i++) {
//         if (dist[i] == Integer.MAX_VALUE) {
//         System.out.print("\nINFInite Value");
//          } else {
//         System.out.print(dist[i] + " ");
//          }
//     }
// System.out.println();

//     }
//     public static void main(String[] args) {
//         int V=6;
//         ArrayList<Edge> graph[]=new ArrayList[V];
//         createGraph(graph, V);
//         bellmanFord(graph, 0);
//     }
// }



// /////// Prim's Algorithm  \\ \\\\\


import java.util.ArrayList;
import java.util.PriorityQueue;

public class Graph4 {
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

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    static class Pair implements Comparable<Pair> {
        int vertex;
        int cost;
        int parent;

        Pair(int vertex, int cost, int parent) {
            this.vertex = vertex;
            this.cost = cost;
            this.parent = parent;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    public static void PrimsMST(ArrayList<Edge>[] graph, int V) {
        boolean[] visited = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(0, 0, -1)); // start from vertex 0
        int mstCost = 0;
        ArrayList<String> mstEdges = new ArrayList<>();

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (!visited[curr.vertex]) {
                visited[curr.vertex] = true;
                mstCost += curr.cost;

                if (curr.parent != -1) { // avoid adding the starting dummy edge
                    mstEdges.add(curr.parent + " - " + curr.vertex + " (" + curr.cost + ")");
                }

                for (Edge e : graph[curr.vertex]) {
                    if (!visited[e.dest]) {
                        pq.add(new Pair(e.dest, e.wt, curr.vertex));
                    }
                }
            }
        }

        System.out.println("MST Edges: " + mstEdges);
        System.out.println("Total MST Cost: " + mstCost);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph, V);
        PrimsMST(graph, V);
    }
}
