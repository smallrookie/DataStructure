package com.rookie.graphDFS;

import com.rookie.graphBasics.AdjList;
import com.rookie.graphBasics.AdjMatrix;
import com.rookie.graphBasics.AdjSet;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Graph g = new Graph("g.txt");
        GraphDFS graphDFS = new GraphDFS(g);
        System.out.println(graphDFS.order());
    }
}
