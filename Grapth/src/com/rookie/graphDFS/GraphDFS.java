package com.rookie.graphDFS;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GraphDFS {

    private Graph G;
    private boolean[] visited;
    // 图的前序深度优先遍历
    private ArrayList<Integer> pre = new ArrayList<>();
    // 图的后序深度优先遍历
    private ArrayList<Integer> post = new ArrayList<>();
    // 图的连通分量个数
    private int cccount = 0;

    public GraphDFS(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!visited[v]) {
                dfs(v);
                cccount++;
            }
        }
    }

    // 图的深度优先遍历，递归
    private void dfs(int v) {
        visited[v] = true;
        pre.add(v);
        for (int w : G.adj(v)) {
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

    // 返回图的连通分量个数
    public int count() {
        return cccount;
    }

    public static void main(String[] args) throws FileNotFoundException {

        Graph g = new Graph("g.txt");
        GraphDFS graphDFS = new GraphDFS(g);

        System.out.print("pre: ");
        System.out.println(graphDFS.pre());

        System.out.print("post: ");
        System.out.println(graphDFS.post);

        System.out.println(graphDFS.count());
    }

}
