package com.pak.practice.algorithm.graph;

import java.util.LinkedList;

@SuppressWarnings("unchecked")
public class DFS {
    // No. of vertices
    private final int vertices;

    // Array of lists for Adjacency List Representation
    private final LinkedList<Integer>[] adj;

    @SuppressWarnings("rawtypes")
    public DFS(int vertices) {
        this.vertices = vertices;
        adj = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        // Add w to v's list.
        adj[v].add(w);
    }

    void DFSUtil(int v, boolean[] visited) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this vertex
        for (int n : adj[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    void depthFirstSearch(int v) {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean[] visited = new boolean[vertices];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }

    public static void main(String[] args) {
        int startingVertex = 2;
        DFS dfs = new DFS(4);
        dfs.addEdge(2,0);
        dfs.addEdge(1,1);
        dfs.addEdge(0,2);
        dfs.addEdge(1,2);
        dfs.addEdge(2,3);
        dfs.addEdge(0,1);
        dfs.addEdge(3,3);
        dfs.addEdge(1,3);
        dfs.addEdge(2,2);
/*
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 4);
        dfs.addEdge(0, 5);
        dfs.addEdge(2, 0);
        dfs.addEdge(2, 3);
        dfs.addEdge(3, 3);
        dfs.addEdge(4, 5);

 */
        System.out.println("Following is Depth First Traversal " +
                "(starting from vertex " + startingVertex + ")");

        dfs.depthFirstSearch(startingVertex);
    }
}
