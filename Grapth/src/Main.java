import com.rookie.graphBasics.AdjList;
import com.rookie.graphBasics.AdjMatrix;
import com.rookie.graphBasics.AdjSet;

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
    }
}
