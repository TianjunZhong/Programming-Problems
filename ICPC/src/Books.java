import java.util.*;
import java.io.*;

public class Books {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        int n, t, sum, read;
        int[] list;

        public void solve(Scanner in, PrintStream out) {
            n = in.nextInt();
            t = in.nextInt();
            sum = 0;
            read = 0;
            list = new int[n];

            for (int i = 0; i < n; i++) {
                list[i] = in.nextInt();
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < n - i; j++) {
                    sum = 0;
                    for (int k = j; k < i + j; k++) {
                        sum += list[k];
                    }
                    if (sum < t) {
                        read = i;
                        break;
                    }
                }
            }

            out.println(read);
        }
    }
}
