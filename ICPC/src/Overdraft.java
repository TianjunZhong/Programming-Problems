
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.PrintStream;

public class Overdraft {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        int n = 0;
        int ans = 0;
        int temp = 0;

        public void solve(Scanner in, PrintStream out) {
            n = in.nextInt();

            for (int i = 0; i < n; i++) {
                temp += in.nextInt();
                if (temp < ans) ans = temp;

            }

            out.println(-ans);

        }
    }

}