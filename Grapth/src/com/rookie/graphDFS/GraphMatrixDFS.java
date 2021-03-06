package com.rookie.graphDFS;

import com.rookie.graphBasics.AdjMatrix;

import java.util.ArrayList;

public class GraphMatrixDFS {

    private AdjMatrix G;
    private boolean[] visited;
    // 图的前序深度优先遍历
    private ArrayList<Integer> pre = new ArrayList<>();
    // 图的后序深度优先遍历
    private ArrayList<Integer> post = new ArrayList<>();

    public GraphMatrixDFS(AdjMatrix G) {
        this.G = G;
        visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!visited[v])
                dfs(v);
        }
    }

    // 图的深度优先遍历，递归
    private void dfs(int v) {
        visited[v] = true;
        pre.add(v);
        for (int w: G.adj(v)) {
            if (!visited[w]) {
                dfs(w);
            }
        }
        post.add(v);
    }

    // 返回图的前序深度优先遍历结果
    public Iterable<Integer> pre() {
        return pre;
    }

    // 返回图的后序深度优先遍历结果
    public Iterable<Integer> post() {
        return post;
    }

}
