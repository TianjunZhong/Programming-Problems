import java.util.*;
import java.io.*;

public class Sum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        int t, a, b, c;

        public void solve(Scanner in, PrintStream out) {
            t = in.nextInt();

            for (int i = 0; i < t; i++) {
                a = in.nextInt();
                b = in.nextInt();
                c = in.nextInt();

                if (a == b + c) out.println("Yes");
                else if (b == a + c) out.println("Yes");
                else if (c == a + b) out.println("Yes");
                else out.println("No");
            }
        }
    }
}