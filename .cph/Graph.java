// Implementation of Graph Using Adjacency List  \\ 

// import java.util.*;
// public class Graph {
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

//     static void createGraph(int V, ArrayList<Edge>[] graph){ 
//         /*
//                       (5)
//                   0-------1
//                          / \
//                      (1)/   \ (3)
//                        /     \
//                       2-------3
//                       |  (1)
//                   (2) |
//                       |
//                       4
//          */
//         for(int i=0;i<V;i++){
//             graph[i]=new ArrayList<>();
//         }

//         // 0 vertex
//         graph[0].add(new Edge(0, 1, 5));
//         // 1 vertex
//         graph[1].add(new Edge(1, 0, 5));
//         graph[1].add(new Edge(1, 2, 1));
//         graph[1].add(new Edge(1, 3, 3));
//         // 2 vertex
//         graph[2].add(new Edge(2, 1, 1));
//         graph[2].add(new Edge(2, 3, 1));
//         graph[2].add(new Edge(2, 4, 2));
//         // 3 vertex
//         graph[3].add(new Edge(3, 1, 3));
//         graph[3].add(new Edge(3, 2, 1));
//         // 4 vertex
//         graph[4].add(new Edge(4, 2, 2));

//         // 2's neighbours
//         for(int i=0;i<graph[2].size();i++){
//             Edge e = graph[2].get(i);
//             System.out.println("Source: " + e.src + ", Destination: " + e.dest + ", Weight: " + e.wt);
//         }
//     }

//     public static void main(String[] args) {
//         int V = 5;
//         ArrayList<Edge>[] graph = new ArrayList[V];
//         createGraph(V, graph);
//     }
// }



// //// Depth First Search (DFS) Implementation in Graph Using Adjacency List \\ \\\\

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class Graph {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }
    static void createGraph(int V, ArrayList<Edge>[] graph){ 
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }

        // 0 vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        // 1 vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        // 2 vertex
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        // 3 vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        // 4 vertex
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        // 5 vertex
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        // 6 vertex
        graph[6].add(new Edge(6, 5, 1));

    }

    public static void bfs(ArrayList<Edge>[] graph){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];
        q.add(0); // starting from vertex 0

        while(!q.isEmpty()){
            int curr = q.remove();

            if(!visited[curr]){ // visit current
                System.out.print(curr+" ");
                visited[curr] = true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] visited) {
        System.out.print(curr + " ");
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                dfs(graph, e.dest, visited);
            }
        }
    }


    // ////// Q} Has Path \\ \\\\\\
        public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {
        if (src == dest) {
            return true; // Found the destination
        }
        
        visited[src] = true; // Mark the current node as visited
        
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!visited[e.dest]) { // If the destination of the edge is not visited
                if (hasPath(graph, e.dest, dest, visited)) {
                    return true; // Path found in the recursive call
                }
            }
        }
        
        return false; // No path found
    }
    
    public static void main(String[] args) {
        /*
                  0
                /   \
               1     2
               |     |
               3-----4
                \   /
                  5
                  |
                  6
         */
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(V, graph);

        bfs(graph);
        System.out.println();
        
        boolean[] visited = new boolean[V];
        dfs(graph, 0, visited); // Starting DFS from vertex 0

        System.out.println();
        // Check if there's a path from vertex 0 to vertex 5
        System.out.println(hasPath(graph, 0, 5, new boolean[V])); // Check if there's a path from 0 to 5
        
    }
}



