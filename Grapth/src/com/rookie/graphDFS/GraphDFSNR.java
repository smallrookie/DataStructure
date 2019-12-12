package com.rookie.graphDFS;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Stack;

public class GraphDFSNR {
    private Graph G;
    private boolean[] visited;
    // 图的前序深度优先遍历
    private ArrayList<Integer> pre = new ArrayList<>();

    public GraphDFSNR(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!visited[v])
                dfsNR(v);
        }
    }

    // 图的深度优先遍历，非递归
    private void dfsNR(int v) {
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        visited[v] = true;
        while (!stack.empty()) {
            int cur = stack.pop();
            pre.add(cur);
            for (int w : G.adj(cur)) {
                if (!visited[w]) {
                    stack.push(w);
                    visited[w] = true;
                }
            }
        }
    }

    // 返回图的前序深度优先遍历结果
    public Iterable<Integer> pre() {
        return pre;
    }


    public static void main(String[] args) throws FileNotFoundException {

        Graph g = new Graph("g.txt");
        GraphDFSNR graphDFSNR = new GraphDFSNR(g);

        System.out.print("pre: ");
        System.out.println(graphDFSNR.pre());
    }
}
