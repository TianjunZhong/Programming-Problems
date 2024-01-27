import java.util.*;
import java.io.*;

public class Increasing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        int t, n;
        boolean done;

        public void solve(Scanner in, PrintStream out) {
            t = in.nextInt();

            for (int i = 0; i < t; i++) {
                done = false;
                
                n = in.nextInt();

                int[] numbers = new int[n];
                for (int j = 0; j < n; j++) {
                    numbers[j] = in.nextInt();
                }

                Arrays.sort(numbers);

                for (int j = 0; j < n - 1; j++) {
                    if (numbers[j] == numbers[j + 1]) {
                        out.println("NO");
                        done = true;
                        break;
                    }
                }
                if (!done) out.println("YES");
            }
        }
    }
}