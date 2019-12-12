package com.rookie.graphBasics;

public interface Graph {
    int V();
    int E();

    // 判断顶点v和顶点w是否连通
    boolean hasEdge(int v, int w);

    // 返回与顶点v连通的顶点列表
    Iterable<Integer> adj(int v);

    // 返回顶点v的度
    int degree(int v);
}
