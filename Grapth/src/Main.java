import com.rookie.graphBasics.AdjList;
import com.rookie.graphBasics.AdjMatrix;
import com.rookie.graphBasics.AdjSet;
import com.rookie.graphDFS.Graph;
import com.rookie.graphDFS.GraphDFS;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        AdjMatrix adjMatrix = new AdjMatrix("g.txt");
        System.out.println(adjMatrix);

        System.out.println();

        AdjList adjList = new AdjList("g.txt");
        System.out.println(adjList);

        System.out.println();

        AdjSet adjSet = new AdjSet("g.txt");
        System.out.println(adjSet);

        System.out.println();

        Graph g = new Graph("g.txt");
        GraphDFS graphDFS = new GraphDFS(g);
        System.out.println(graphDFS.order());
    }
}
