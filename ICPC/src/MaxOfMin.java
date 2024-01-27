
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.PrintStream;

public class MaxOfMin {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        int n, k;
        int[] a;
        int i, j;

        public void solve(Scanner in, PrintStream out) {
            n = in.nextInt();
            k = in.nextInt();
            a = new int[n];

            for (i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            if (k == 1) {
                Arrays.sort(a);
                out.println(a[0]);
            } 
            else if (k >= 3) {
                Arrays.sort(a);
                out.println(a[n - 1]);
            }
            else if (k == 2) {
                if (a[0] > a[n - 1]) out.println(a[0]);
                else out.println(a[n - 1]);
            }
        }
    }

}