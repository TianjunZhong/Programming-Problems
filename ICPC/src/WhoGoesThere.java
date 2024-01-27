import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.PrintStream;

public class WhoGoesThere {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        int n, m;
        int[] a;
        int[] ans;
        int avg;
        int left;
        int j = 0;
        

        public void solve(Scanner in, PrintStream out) {
            n = in.nextInt();
            m = in.nextInt();
            a = new int[m];
            ans = new int[m];
            int left = n;
            int j = 0;

            for (int i = 0; i < m; i++) {
                a[i] = in.nextInt();
            }

            while (left > 0) {
                if (ans[j] < a[j]) {
                    ans[j]++;
                    left--;
                }
                j = (j + 1) % m;
            }

            for (int i = 0; i < m; i++) {
                out.println(ans[i]);
            }

        }
    }

}