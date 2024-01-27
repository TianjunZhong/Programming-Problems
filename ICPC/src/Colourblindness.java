import java.util.*;
import java.io.*;

public class Colourblindness {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        int t, n, index;
        String row;
        boolean[] row1, row2;

        void solve (Scanner in, PrintStream out) {
            t = in.nextInt();
            for (int i = 0; i < t; i++) {
                n = in.nextInt();
                row1 = new boolean[n];
                row2 = new boolean[n];

                row = in.next();
                index = 0;
                for (int j = 0; j < n; j++) {
                    row1[index++] = !(row.charAt(j) == 'R');
                }

                row = in.next();
                index = 0;
                for (int j = 0; j < n; j++) {
                    row2[index++] = !(row.charAt(j) == 'R');
                }

                for (int j = 0; j < n; j++) {
                    if (row1[j] ^ row2[j]) {
                        out.println("NO");
                        break;
                    }
                    if (j == n - 1) out.println("YES");
                }
            }
        }
    }
}
