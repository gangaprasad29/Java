// ////////  Connected Components \\ \\\\\\

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class Graph2 {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph(int V, ArrayList<Edge>[] graph) {
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 vertex
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        // 1 vertex
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));
        // 2 vertex
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
        // 3 vertex
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));
        // 4 vertex
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        // 5 vertex
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));
        // 6 vertex
        graph[6].add(new Edge(6, 5));
    }

    public static void Bfs(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                BfsHelper(graph, visited, i);
            }
        }
    }

    public static void BfsHelper(ArrayList<Edge>[] graph, boolean visited[], int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!visited[curr]) {
                System.out.print(curr + " ");
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void Dfs(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                DfsHelper(graph, visited, i);
            }
        }
    }

    public static void DfsHelper(ArrayList<Edge>[] graph, boolean[] visited, int curr) {
        System.out.print(curr + " ");
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                DfsHelper(graph, visited, e.dest);
            }
        }
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean visited[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                if(detectCycleHelper(graph,i,-1,visited)){
                    return true; // cycle is exist
                }
            }
        }
        return false;
    }
    public static boolean detectCycleHelper(ArrayList<Edge>[] graph,int curr, int parent,boolean visited[]){
        visited[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            //case 3:
            if(!visited[e.dest]){
                if(detectCycleHelper(graph, e.dest, curr, visited)){
                    return true;
                }
            }
            //case 1:
            else if(visited[e.dest] && e.dest != parent){
                return true;
            }
            // case 2: do nothing 
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(V, graph);

        System.out.print("BFS:");
        Bfs(graph);

        System.out.print("\nDFS:");
        Dfs(graph);

        System.out.println("\nCycle Exist:"+detectCycle(graph));
    }
}



