package com.pak.practice.algorithm.graph;

import java.util.*;

public class DFSWithStack {
    final int vertices;
    final LinkedList<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public DFSWithStack(int vertices) {
        this.vertices = vertices;
        adj = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++)
            adj[i] = new LinkedList<>();
    }


    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // prints all not yet visited vertices reachable from s
    void DFS(int s) {
        // Initially mark all vertices as not visited
        ArrayList<Boolean> visited = new ArrayList<>(vertices);
        for( int i = 0; i < vertices; i++ )
            visited.add(false);

        // Create a stack for DFS
        Stack<Integer> stack = new Stack<>();
        stack.push(s);

        while( !stack.empty() ) {
            // Pop a vertex from stack and print it
            s = stack.peek();
            stack.pop();

            // Stack may contain same vertex twice. So
            // we need to print the popped item only
            // if it is not visited.
            if( !visited.get(s) ) {
                System.out.print(s + " ");
                visited.set(s, true);
            }

            // Get all adjacent vertices of the popped vertex s
            // If a adjacent has not been visited, then push it
            // to the stack.

            for (int v : adj[s]) {
                if (!visited.get(v))
                    stack.push(v);
            }
        }
    }

    public static void main(String[] args) {
        int start = 2;
        DFSWithStack dfs = new DFSWithStack(4);
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
        System.out.println("Following is the Depth First Traversal");
        dfs.DFS(start);
    }
}
