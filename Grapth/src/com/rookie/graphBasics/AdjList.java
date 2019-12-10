package com.rookie.graphBasics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class AdjList {

    private int V;
    private int E;
    private LinkedList<Integer>[] adj;

    // 创建邻接表
    public AdjList(String filename) throws FileNotFoundException {

        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        V = scanner.nextInt();
        if (V < 0)
            throw new IllegalArgumentException("V must be non-negative.");
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<Integer>();
        }

        E = scanner.nextInt();
        if (E < 0)
            throw new IllegalArgumentException("E must be non-negative");

        for (int i = 0; i < E; i++) {
            int a = scanner.nextInt();
            validateVertex(a);

            int b = scanner.nextInt();
            validateVertex(b);

            if (a == b)
                throw new IllegalArgumentException("Self Loop is Detected.");

            if (adj[a].contains(b))
                throw new IllegalArgumentException("Parallel Edges are Detected.");
            adj[a].add(b);
            adj[b].add(a);
        }
    }

    // 判断顶点是否合法
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + "is invalid.");
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    // 判断顶点v和顶点w是否连通
    public boolean hasEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return adj[v].contains(w);
    }

    // 返回与顶点v连通的顶点列表
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    // 返回顶点v的度
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("V: %d, E: %d\n", V, E));
        for (int v = 0; v < V; v++) {
            res.append(String.format("%d: ", v));
            for (int w : adj[v]) {
                res.append(String.format("%d ", w));
            }
            res.append("\n");
        }
        return res.toString();
    }
}
