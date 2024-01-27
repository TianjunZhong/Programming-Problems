import java.util.*;
import java.io.*;
import java.lang.Math;

public class RatingProblem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        int n, k;
        double sum = 0;

        public void solve(Scanner in, PrintStream out) {
            n = in.nextInt();
            k = in.nextInt();

            for (int i = 0; i < k; i++) {
                sum += in.nextInt();
            }

            out.println((sum + (n - k) * (-3)) / n + " " + (sum + (n - k) * (3)) / n);
        }
    }
}
