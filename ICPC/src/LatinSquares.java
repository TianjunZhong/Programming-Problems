import java.util.*;
import java.io.*;
import java.lang.Math;

public class LatinSquares {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        int[][] a;
        int n;
        boolean isLS = true;

        public void solve(Scanner in, PrintStream out) {
            n = in.nextInt();
            a = new int[n][n];

            for (int i = 0; i < n * n; i++) {
                a[i / n][i % n] = in.nextInt();
            }

            for (int i = 0; i < n; i++) {
                int[] checkR = new int[n];
                int[] checkC = new int[n];

                for (int j = 0; j < n; j++) {
                    checkR[a[i][j]]++;
                    if (checkR[a[i][j]] > 1) {
                        isLS = false;
                        break;
                    }
                    checkC[a[j][i]]++;
                    if (checkC[a[j][i]] > 1) {
                        isLS = false;
                        break;
                    }
                }
                if (!isLS) break;
            }

            out.println(isLS);
        }
    }
}
