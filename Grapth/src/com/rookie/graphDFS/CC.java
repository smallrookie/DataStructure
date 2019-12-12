package com.rookie.graphDFS;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import com.rookie.graphDFS.Graph.*;

public class CC {

    private Graph G;
    private int[] visited;
    // 图的前序深度优先遍历
    private ArrayList<Integer> pre = new ArrayList<>();
    // 图的后序深度优先遍历
    private ArrayList<Integer> post = new ArrayList<>();
    // 图的连通分量个数
    private int cccount = 0;

    public CC(Graph G) {
        this.G = G;
        visited = new int[G.V()];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = -1;
        }
        for (int v = 0; v < G.V(); v++) {
            if (visited[v] == -1) {
                dfs(v, cccount);
                cccount++;
            }
        }
    }

    // 图的深度优先遍历，递归
    private void dfs(int v, int ccid) {
        visited[v] = ccid;
        pre.add(v);
        for (int w : G.adj(v)) {
            if (visited[w] == -1) {
                dfs(w, ccid);
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

    public boolean isConnected(int v, int w) {
        G.validateVertex(v);
        G.validateVertex(w);
        return visited[v] == visited[w];
    }

    public ArrayList<Integer>[] components() {
        ArrayList<Integer>[] res = new ArrayList[cccount];
        for (int i = 0; i < cccount; i++) {
            res[i] = new ArrayList<>();
        }

        for (int v = 0; v < G.V(); v++) {
            res[visited[v]].add(v);
        }
        return res;
    }

    public static void main(String[] args) throws FileNotFoundException {

        Graph g = new Graph("g.txt");
        CC cc = new CC(g);

        System.out.print("pre: ");
        System.out.println(cc.pre());

        System.out.print("post: ");
        System.out.println(cc.post);

        System.out.println(cc.count());
        System.out.println(cc.isConnected(0, 6));
        System.out.println(cc.isConnected(0, 5));

        ArrayList<Integer>[] comp = cc.components();
        for (int ccid = 0; ccid < comp.length; ccid++) {
            System.out.print(ccid + ": ");
            for (int w : comp[ccid])
                System.out.print(w + " ");
            System.out.println();
        }
    }

}
