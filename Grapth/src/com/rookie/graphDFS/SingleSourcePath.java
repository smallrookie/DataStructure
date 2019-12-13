package com.rookie.graphDFS;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

// 单源路径问题
public class SingleSourcePath {
    private Graph G;
    private int s;
    private boolean[] visited;
    private int[] pre;

    public SingleSourcePath(Graph G, int s) {
        this.G = G;
        visited = new boolean[G.V()];
        pre = new int[G.V()];
        dfs(s, s);
    }

    // 图的深度优先遍历，递归
    private void dfs(int v, int parent) {
        visited[v] = true;
        pre[v] = parent;
        for (int w : G.adj(v)) {
            if (!visited[w]) {
                dfs(w, v);
            }
        }
    }

    public boolean isConnectedTo(int t) {
        G.validateVertex(t);
        return visited[t];
    }

    public Iterable<Integer> path(int t) {
        ArrayList<Integer> res = new ArrayList<>();
        if (!isConnectedTo(t))
            return res;

        int cur = t;
        while (cur != s) {
            res.add(cur);
            cur = pre[cur];
        }
        res.add(s);

        Collections.reverse(res);
        return res;
    }


    public static void main(String[] args) throws FileNotFoundException {

        Graph g = new Graph("g.txt");
        SingleSourcePath sspath = new SingleSourcePath(g, 0);
        System.out.println("0 -> 6: " + sspath.path(6));
        System.out.println("0 -> 5: " + sspath.path(5));
    }
}
