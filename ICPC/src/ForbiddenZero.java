import java.util.*;
import java.io.*;
import java.lang.Math;

public class ForbiddenZero {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        int n;
        int[] a =  new int[7];
        int i = 0;
        int j = 0;
        boolean done = false;
        int ans = 0;

        public void solve(Scanner in, PrintStream out) {
            n = in.nextInt();

            while (n > 0) {
                a[i++] = n % 10;
                n /= 10;
            }

            for (j = 0; j < i; j++) {
                if (a[j] < 9) {
                    a[j]++;
                    for (int k = 0; k < j; k++) {
                        a[k] = 1;
                    }
                    done = true;
                    break;
                }
            }
            if (!done) {
                for (int k = 0; k <= i; k++) a[k] = 1;
            }

            for (int k = 0; k <= i; k++) ans += a[k] * Math.pow(10, k);

            out.println(ans);
        }
    }
}
