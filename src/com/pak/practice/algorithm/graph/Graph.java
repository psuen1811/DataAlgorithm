package com.pak.practice.algorithm.graph;

import java.util.ArrayList;

public class Graph {

    void addEdge(ArrayList<ArrayList<Integer>> arrayLists, int u, int v) {
        arrayLists.get(u).add(v);
        arrayLists.get(v).add(u);
    }

    void printGraph(ArrayList<ArrayList<Integer>> arrayLists) {
        for (int i = 0; i < arrayLists.size(); i++) {
            System.out.println("\nAdjacency list of vertex" + i);
            System.out.println("head");
            for (int j = 0; j < arrayLists.get(i).size(); j++) {
                System.out.print(" ->" + arrayLists.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++)
            arrayList.add(new ArrayList<>());

        Graph graph = new Graph();
        graph.addEdge(arrayList, 0, 1);
        graph.addEdge(arrayList, 0, 4);
        graph.addEdge(arrayList, 1, 2);
        graph.addEdge(arrayList, 1, 3);
        graph.addEdge(arrayList, 1, 4);
        graph.addEdge(arrayList, 2, 3);
        graph.addEdge(arrayList, 3, 4);
        graph.printGraph(arrayList);
    }
}
