
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.PrintStream;

public class GregArray {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        int n, m, k;
        int[] a;

        public void solve(Scanner in, PrintStream out) {
            n = in.nextInt();
            m = in.nextInt();
            k = in.nextInt();

            for (int i = 0; i < n; i ++) {
                a[i] = in.nextInt();
            }
        }
    }

}