// ////////  Connected Components \\ \\\\\\

// import java.util.*;
// import java.util.LinkedList;
// import java.util.Queue;

// public class Graph2 {
//     static class Edge {
//         int src;
//         int dest;

//         public Edge(int src, int dest) {
//             this.src = src;
//             this.dest = dest;
//         }
//     }

//     static void createGraph(int V, ArrayList<Edge>[] graph) {
//         for (int i = 0; i < V; i++) {
//             graph[i] = new ArrayList<>();
//         }

//         // 0 vertex
//         graph[0].add(new Edge(0, 1));
//         graph[0].add(new Edge(0, 2));
//         // 1 vertex
//         graph[1].add(new Edge(1, 0));
//         graph[1].add(new Edge(1, 3));
//         // 2 vertex
//         graph[2].add(new Edge(2, 0));
//         graph[2].add(new Edge(2, 4));
//         // 3 vertex
//         graph[3].add(new Edge(3, 1));
//         graph[3].add(new Edge(3, 4));
//         graph[3].add(new Edge(3, 5));
//         // 4 vertex
//         graph[4].add(new Edge(4, 2));
//         graph[4].add(new Edge(4, 3));
//         graph[4].add(new Edge(4, 5));
//         // 5 vertex
//         graph[5].add(new Edge(5, 3));
//         graph[5].add(new Edge(5, 4));
//         graph[5].add(new Edge(5, 6));
//         // 6 vertex
//         graph[6].add(new Edge(6, 5));
//     }

//     public static void Bfs(ArrayList<Edge>[] graph) {
//         boolean visited[] = new boolean[graph.length];
//         for (int i = 0; i < graph.length; i++) {
//             if (!visited[i]) {
//                 BfsHelper(graph, visited, i);
//             }
//         }
//     }

//     public static void BfsHelper(ArrayList<Edge>[] graph, boolean visited[], int start) {
//         Queue<Integer> q = new LinkedList<>();
//         q.add(start);

//         while (!q.isEmpty()) {
//             int curr = q.remove();

//             if (!visited[curr]) {
//                 System.out.print(curr + " ");
//                 visited[curr] = true;
//                 for (int i = 0; i < graph[curr].size(); i++) {
//                     Edge e = graph[curr].get(i);
//                     q.add(e.dest);
//                 }
//             }
//         }
//     }

//     public static void Dfs(ArrayList<Edge>[] graph) {
//         boolean visited[] = new boolean[graph.length];
//         for (int i = 0; i < graph.length; i++) {
//             if (!visited[i]) {
//                 DfsHelper(graph, visited, i);
//             }
//         }
//     }

//     public static void DfsHelper(ArrayList<Edge>[] graph, boolean[] visited, int curr) {
//         System.out.print(curr + " ");
//         visited[curr] = true;

//         for (int i = 0; i < graph[curr].size(); i++) {
//             Edge e = graph[curr].get(i);
//             if (!visited[e.dest]) {
//                 DfsHelper(graph, visited, e.dest);
//             }
//         }
//     }

//     public static boolean detectCycle(ArrayList<Edge>[] graph){
//         boolean visited[]=new boolean[graph.length];
//         for(int i=0;i<graph.length;i++){
//             if(!visited[i]){
//                 if(detectCycleHelper(graph,i,-1,visited)){
//                     return true; // cycle is exist
//                 }
//             }
//         }
//         return false;
//     }
//     public static boolean detectCycleHelper(ArrayList<Edge>[] graph,int curr, int parent,boolean visited[]){
//         visited[curr]=true;

//         for(int i=0;i<graph[curr].size();i++){
//             Edge e = graph[curr].get(i);
//             //case 3:
//             if(!visited[e.dest]){
//                 if(detectCycleHelper(graph, e.dest, curr, visited)){
//                     return true;
//                 }
//             }
//             //case 1:
//             else if(visited[e.dest] && e.dest != parent){
//                 return true;
//             }
//             // case 2: do nothing 
//         }
//         return false;
//     }
//     public static void main(String[] args) {
//         int V = 7;
//         ArrayList<Edge>[] graph = new ArrayList[V];
//         createGraph(V, graph);

//         System.out.print("BFS:");
//         Bfs(graph);

//         System.out.print("\nDFS:");
//         Dfs(graph);

//         System.out.println("\nCycle Exist:"+detectCycle(graph));
//     }
// }




// ////// Bipartite Graph \\ \\\\\

// import java.util.*;
// import java.util.LinkedList;
// import java.util.Queue;

// public class Graph2 {
//     static class Edge {
//         int src;
//         int dest;

//         public Edge(int src, int dest) {
//             this.src = src;
//             this.dest = dest;
//         }
//     }

//     static void createGraph(int V, ArrayList<Edge>[] graph) {
//         for (int i = 0; i < V; i++) {
//             graph[i] = new ArrayList<>();
//         }
//         // 0 vertex
//         graph[0].add(new Edge(0, 1));
//         graph[0].add(new Edge(0, 2));
//         // 1 vertex
//         graph[1].add(new Edge(1, 0));
//         graph[1].add(new Edge(1, 3));
//         // 2 vertex
//         graph[2].add(new Edge(2, 0));
//         graph[2].add(new Edge(2, 4));
//         // 3 vertex
//         graph[3].add(new Edge(3, 1));
//         graph[3].add(new Edge(3, 4));
//         // 4 vertex
//         graph[4].add(new Edge(4, 2));
//         graph[4].add(new Edge(4, 3));
//     }

//     public static boolean isByPartite(ArrayList<Edge>[] graph) {
//         int color[] = new int[graph.length];
//         for (int i = 0; i < color.length; i++) {
//             color[i] = -1; // no color
//         }

//         Queue<Integer> q = new LinkedList<>();

//         for (int i = 0; i < graph.length; i++) {
//             if (color[i] == -1) { // BFS
//                 q.add(i);
//                 color[i] = 0; // yellow
//                 while (!q.isEmpty()) {
//                     int curr = q.remove();
//                     for (int j = 0; j < graph[curr].size(); j++) { 
//                         Edge e = graph[curr].get(j);
//                         if (color[e.dest] == -1) { // we have to assign the color
//                             int nextColor = color[curr] == 0 ? 1 : 0; 
//                             color[e.dest] = nextColor;
//                             q.add(e.dest);
//                         } else if (color[e.dest] == color[curr]) {
//                             return false; // not a bipartite graph
//                         }
//                     }
//                 }
//             }
//         }
//         return true;
//     }

//     public static void main(String[] args) {
//         /*
//          Graph Structure:
         
//          0 -- 1
//          |    |
//          2    3
//           \  /
//            4
//          */

//         int V = 5;
//         ArrayList<Edge> graph[] = new ArrayList[V];
//         createGraph(V, graph);

//         System.out.println(isByPartite(graph));
//     }
// }



// //////// Detect Cycle For Directed Graph \\ \\\\\

// import java.util.*;
// import java.util.Queue;
// import java.util.ArrayList;

// public class Graph2 {
//     static class Edge{
//         int src;
//         int dest;
//         public Edge(int src,int dest){
//             this.src=src;
//             this.dest=dest;
//         }
//     }
//     static void createGraph(ArrayList<Edge>[] graph,int V){
//         for(int i=0;i<V;i++){
//             graph[i]=new ArrayList<>();
//         } 
//         graph[0].add(new Edge(0, 2));
//         graph[1].add(new Edge(1, 0));
//         graph[2].add(new Edge(2, 3));
//         graph[3].add(new Edge(3, 0));
//     }

//     public static boolean isCycle(ArrayList<Edge>[] graph){
//         boolean visited[]=new boolean[graph.length];
//         boolean stack[]=new boolean[graph.length];

//         for(int i=0;i<graph.length;i++){
//             if(!visited[i]){
//                 if(isCyclicHelper(graph,i,visited,stack)){
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
//     public static boolean isCyclicHelper(ArrayList<Edge> graph[],int curr,boolean visited[],boolean stack[]){
//         visited[curr]=true;
//         stack[curr]=true;
        
//         for(int i=0;i<graph[curr].size();i++){
//             Edge e = graph[curr].get(i);
//             if(stack[e.dest]){ // cycle exist
//                 return true;
//             }
//             if(!visited[e.dest] && isCyclicHelper(graph, e.dest, visited, stack)){
//                 return true;
//             }
//         }
//         stack[curr]=false;
//         return false;
//     }
//     public static void main(String[] args) {
//         int V=4;
//         ArrayList<Edge> graph[]=new ArrayList[V];
//         createGraph(graph,V);

//         System.out.println(isCycle(graph));
//     }
// }




// ////// Topological Sorting \\ \\\\\\\  (this can be a topic or a seperate question)

import java.util.ArrayList;
import java.util.Stack;

public class Graph2 {
    static class Edge {
        int src;
        int dest;
        public Edge(int src, int dest) {
            this.src = src; 
            this.dest = dest;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph, int V) {
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void topSort(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                topSortHelper(graph, i, visited, s);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop()+" ");
        }
    }

    public static void topSortHelper(ArrayList<Edge>[] graph, int curr, boolean[] visited, Stack<Integer> s) {
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                topSortHelper(graph, e.dest, visited, s);
            }
        }
        s.push(curr);
    }

    public static void main(String[] args) {
        int V = 6; 
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph, V);
        topSort(graph);
    }
}
