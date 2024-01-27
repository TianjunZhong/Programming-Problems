
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.PrintStream;

public class DoublePassword {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        int ans = 1;
        int line1 = 0;
        int line2 = 0;
        int a;

        public void solve(Scanner in, PrintStream out) {
            line1 = in.nextInt();
            line2 = in.nextInt();
            
            for (int i = 0; i < 4; i++) {
                if ((line1 % 10) != (line2 % 10)) {
                    ans *= 2;
                }
                line1 /= 10;
                line2 /=10;
            }

            out.println(ans);
        }
    }

}