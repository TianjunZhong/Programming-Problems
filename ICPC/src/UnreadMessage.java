import java.util.*;
import java.io.*;
import java.lang.Math;

public class UnreadMessage {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        int n, m;
        int[] all;
        long sum = 0;
        int temp;
        int j;

        public void solve(Scanner in, PrintStream out) {
            n = in.nextInt();
            m = in.nextInt();
            all = new int[m + 5];
            

            for (int i = 1; i <= m; i++) {
                all[i] = in.nextInt();
            }

            for (int i = 1; i <= m; i++) {
                sum += n;
                
                temp = 0;
                j = i - 1;
                while (j >= 0) {
                    if (all[i] == all[j]) {
                        temp = j;
                        break;
                    }
                    j--;
                }

                sum -= i - temp;

                out.println(sum);
            }

        }
    }
}
