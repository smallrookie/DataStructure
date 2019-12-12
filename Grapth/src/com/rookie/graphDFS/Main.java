package com.rookie.graphDFS;

import com.rookie.graphBasics.AdjList;
import com.rookie.graphBasics.AdjMatrix;
import com.rookie.graphBasics.AdjSet;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Graph g = new Graph("g.txt");
        GraphDFS graphDFS = new GraphDFS(g);

        System.out.print("pre: ");
        System.out.println(graphDFS.pre());

        System.out.print("post: ");
        System.out.println(graphDFS.post());
    }
}
