import java.util.*;
import java.io.*;

public class Rumor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        int n, m;
        int[] g = new int[n + 1];
        boolean[][] adj = new boolean[n][n];
        int u, v;

        public void solve(Scanner in, PrintStream out) {
            n = in.nextInt();
            m = in.nextInt();
            for (int i = 1; i < n + 1; i++) {
                g[i] = in.nextInt();
            }
            for (int i = 0; i < m; i++) {
                u = in.nextInt();
                v = in.nextInt();

                adj[u][v] = true;
                adj[v][u] = true;
            }
        }
    }
}