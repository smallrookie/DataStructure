import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdjMatrix {

    private int V;
    private int E;
    private int[][] adj;

    public AdjMatrix(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        V = scanner.nextInt();
        if (V < 0)
            throw new IllegalArgumentException("V must be non-negative.");
        adj = new int[V][V];

        E = scanner.nextInt();
        if (E < 0)
            throw new IllegalArgumentException("E must be non-negative.");
        for (int i = 0; i < E; i++) {
            int tmp_a = scanner.nextInt();
            vaildateVertex(tmp_a);

            int tmp_b = scanner.nextInt();
            vaildateVertex(tmp_b);

            if (tmp_a == tmp_b)
                throw new IllegalArgumentException("Self Loop is Detected.");

            if (adj[tmp_a][tmp_b] == 1)
                throw new IllegalArgumentException("Parallel Edges are Detected.");
            adj[tmp_a][tmp_b] = 1;
            adj[tmp_b][tmp_a] = 1;
        }
    }

    private void vaildateVertex(int v) {
        if (v < 0 || v > V)
            throw new IllegalArgumentException("vertex " + v + "is invalid.");
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public boolean hasEdge(int v, int w) {
        vaildateVertex(v);
        vaildateVertex(w);
        return adj[v][w] == 1;
    }

    public ArrayList<Integer> adj(int v) {
        vaildateVertex(v);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (adj[v][i] == 1)
                res.add(i);
        }
        return res;
    }

    public int degree(int v) {
        return adj(v).size();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("V: %d, E: %d\n", V, E));
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                res.append(String.format("%d ", adj[i][j]));
            }
            res.append("\n");
        }
        return res.toString();
    }
}
