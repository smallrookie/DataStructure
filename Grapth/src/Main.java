import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        AdjMatrix adjMatrix = new AdjMatrix("g.txt");
        System.out.println(adjMatrix);

        AdjList adjList = new AdjList("g.txt");
        System.out.println(adjList);
    }
}
