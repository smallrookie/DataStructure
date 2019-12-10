import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdjMatrix {

    // 顶点数
    private int V;
    // 边数
    private int E;
    // 邻接矩阵
    private int[][] adj;

    // 创建邻接矩阵
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
            int a = scanner.nextInt();
            validateVertex(a);

            int b = scanner.nextInt();
            validateVertex(b);

            if (a == b)
                throw new IllegalArgumentException("Self Loop is Detected.");

            if (adj[a][b] == 1)
                throw new IllegalArgumentException("Parallel Edges are Detected.");
            adj[a][b] = 1;
            adj[b][a] = 1;
        }
    }

    // 判断顶点是否合法
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + "is invalid.");
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    // 判断顶点v和顶点w是否连通
    public boolean hasEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return adj[v][w] == 1;
    }

    // 返回与顶点v连通的顶点列表
    public ArrayList<Integer> adj(int v) {
        validateVertex(v);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (adj[v][i] == 1)
                res.add(i);
        }
        return res;
    }

    // 返回顶点v的度
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
