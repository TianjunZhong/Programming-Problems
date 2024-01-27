import java.util.*;
import java.io.*;

public class NewYearTransportation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        int n, t;
        int current = 1;

        public void solve(Scanner in, PrintStream out) {
            n = in.nextInt();
            t = in.nextInt();
            int[] a = new int[n];

            for (int i = 1; i < n; i++) {
                a[i] = in.nextInt();
            }

            while (current < t) {
                current += a[current];
            }

            if (current == t) out.println("YES");
            else out.println("NO");
        }
    }
}