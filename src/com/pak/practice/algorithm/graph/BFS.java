package com.pak.practice.algorithm.graph;

import java.util.LinkedList;

public class BFS {
    // No. of vertices;
    final int vertices;
    // Adjacent lists
    final LinkedList<Integer>[] adj;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public BFS(int vertices) {
        this.vertices = vertices;
        //noinspection unchecked
        adj = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void breadthFirstSearch(int s) {
        boolean[] visited = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for (int n : adj[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        int startingVertex = 2;
        BFS bfs = new BFS(6);

        /*
        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(1, 2);
        bfs.addEdge(2, 0);
        bfs.addEdge(2, 3);
        bfs.addEdge(3, 3);

         */

        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(1, 2);
        bfs.addEdge(2, 4);
        bfs.addEdge(0, 5);
        bfs.addEdge(2, 0);
        bfs.addEdge(2, 3);
        bfs.addEdge(3, 3);
        bfs.addEdge(4, 5);

        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex " + startingVertex + ")");

        bfs.breadthFirstSearch(startingVertex);
    }
}
