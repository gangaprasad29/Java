// ///// Strongly Connected Component(SCC)   (Kosaraju's Algorithm)

// import java.util.*;

// public class Graph6 {
//     static class Edge {
//         int src;
//         int dest;

//         public Edge(int src, int dest) {
//             this.src = src;
//             this.dest = dest;
//         }
//     }

//     public static void createGraph(ArrayList<Edge> graph[]) {
//         for (int i = 0; i < graph.length; i++) {
//             graph[i] = new ArrayList<>();
//         }

//         graph[0].add(new Edge(0, 2));
//         graph[0].add(new Edge(0, 3));

//         graph[1].add(new Edge(1, 0));

//         graph[2].add(new Edge(2, 1));

//         graph[3].add(new Edge(3, 4));
//     }

//     public static void topSort(ArrayList<Edge> graph[], int curr, boolean visited[], Stack<Integer> s) {
//         visited[curr] = true;

//         for (int i = 0; i < graph[curr].size(); i++) {
//             Edge e = graph[curr].get(i);
//             if (!visited[e.dest]) {
//                 topSort(graph, e.dest, visited, s);
//             }
//         }
//         s.push(curr);
//     }

//     public static void dfs(ArrayList<Edge> graph[], int curr, boolean visited[]) {
//         visited[curr] = true;
//         System.out.print(curr + " ");

//         for (int i = 0; i < graph[curr].size(); i++) {
//             Edge e = graph[curr].get(i);
//             if (!visited[e.dest]) {
//                 dfs(graph, e.dest, visited);
//             }
//         }
//     }

//     public static void Kosaraju(ArrayList<Edge> graph[], int v) {
//         // Step 1: Topological Sort
//         Stack<Integer> s = new Stack<>();
//         boolean visited[] = new boolean[v];
//         for (int i = 0; i < v; i++) {
//             if (!visited[i]) {
//                 topSort(graph, i, visited, s);
//             }
//         }

//         // Step 2: Transpose Graph
//         ArrayList<Edge> transpose[] = new ArrayList[v];
//         for (int i = 0; i < v; i++) {
//             visited[i] = false;
//             transpose[i] = new ArrayList<>();
//         }

//         for (int i = 0; i < v; i++) {
//             for (int j = 0; j < graph[i].size(); j++) {
//                 Edge e = graph[i].get(j);
//                 transpose[e.dest].add(new Edge(e.dest, e.src)); // reverse edge
//             }
//         }

//         // Step 3: DFS on Transposed Graph
//         while (!s.isEmpty()) {
//             int curr = s.pop();
//             if (!visited[curr]) {
//                 System.out.print("SCC -> ");
//                 dfs(transpose, curr, visited);
//                 System.out.println();
//             }
//         }
//     }

//     public static void main(String[] args) {
//         int v = 5;
//         ArrayList<Edge> graph[] = new ArrayList[v];
//         createGraph(graph);

//         Kosaraju(graph, v);
//     }
// }




// /////// Bridge in Graph(Tarjans Algorithm) \\ \\\\\\

import java.util.*;
public class Graph6 {
    static class  Edge {
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
    }
    public static void dfs(ArrayList<Edge> graph[],int curr,int parent,int dt[],int low[],int time, boolean visited[]){
       visited[curr] = true;
       dt[curr]=low[curr]=++time;

       for(int i=0;i<graph[curr].size();i++){
        Edge e = graph[curr].get(i);
        int neighbor = e.dest;
        if(neighbor == parent){
            continue;
        }else if(!visited[neighbor]){
            dfs(graph, neighbor, curr, dt, low, time, visited);
            low[curr]=Math.min(low[curr],low[neighbor]);
            if(dt[curr]<low[neighbor]){
                System.out.println("Bridge : "+curr+"--->"+neighbor);
            }
        }else{
            low[curr]=Math.min(low[curr],dt[neighbor]);
        }
       }

    }

    public static void TarjansBridge(ArrayList<Edge> graph[],int v){
        int dt[]=new int[v];  // discovery time
        int low[]=new int[v];  // lowest discovery time
        int time=0;
        boolean visited[]=new boolean[v];

        for(int i=0;i<v;i++){
            if(!visited[i]){
                dfs(graph,i,-1,dt,low,time,visited);
            }
        }
    }
    public static void main(String[] args) {
        int v=6;
        ArrayList<Edge> graph[]=new ArrayList[v];
        createGraph(graph);
        TarjansBridge(graph,v);
    }
}