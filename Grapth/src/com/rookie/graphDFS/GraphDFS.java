package com.rookie.graphDFS;

import java.util.ArrayList;

public class GraphDFS {

    private Graph G;
    private boolean[] visited;
    private ArrayList<Integer> order = new ArrayList<>();

    public GraphDFS(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        dfs(0);
    }

    // 图的深度优先遍历，递归
    private void dfs(int v) {
        visited[v] = true;
        order.add(v);
        for (int w: G.adj(v))
            if (!visited[w])
                dfs(w);
    }

    // 返回深度优先遍历结果
    public Iterable<Integer> order() {
        return order;
    }
}
