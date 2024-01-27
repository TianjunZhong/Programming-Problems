import java.util.*;
import java.io.*;
import java.lang.Math;

public class FearFactoring {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        long a, b;
        long ans = 0;

        public void solve(Scanner in, PrintStream out) {
            a = in.nextLong();
            b = in.nextLong();

            for (long i = a; i <= b; i++) {

                for (long j = 1; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        ans += j;
                        if (j != i/j) ans += (i / j);
                    }
                }
            }

            out.println(ans);
        }
    }
}
