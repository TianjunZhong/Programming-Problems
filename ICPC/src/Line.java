import java.util.*;
import java.io.*;

public class Line {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        int t, n;
        long sum;
        boolean odd = false;
        char[] line;
        String temp;

        public void solve(Scanner in, PrintStream out) {
            t = in.nextInt();

            for (int i = 0; i < t; i++) {
                sum = 0;
                n = in.nextInt();
                line = new char[n];
                odd = (n % 2 == 1) ? true : false;
                temp = in.next();
                //String output = "";

                for (int j = 0; j < n; j++) line[j] = temp.charAt(j);

                for (int j = 0; j < n; j++) {
                    if (line[j] == 'L') sum += j;
                    else sum += (n - 1 - j);
                }


                int k = 0, l = n - 1, rep = 0;

                while (true) {
                    if (line[k++] == 'L') {
                        sum += n - k - k + 1;
                        out.print(sum + " ");
                        rep++;
                    }
                    if (k >= l) break;

                    if (line[l--] == 'R') {
                        sum += l + 1 - (n - 1 - l - 1);
                        out.print(sum + " ");
                        rep++;
                    }
                    if (k >= l) break;
                }

                if (!odd) if (line[n/2] == 'R') {
                    sum++;
                    out.print(sum + " ");
                    rep++;
                }

                int more = n - rep;

                for (int j = 0; j < more; j++) {
                    out.print(sum + " ");
                    rep++;
                }

                out.println();
            }
        }

    }
}
