import java.util.*;
import java.io.*;
import java.lang.Math;

public class ExamMunipulation { // using brute force is fine
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        int n, k;
        // String[] ans;
        int low = 0;
        // char current;
        String current;
        char[] ans;
        int score = 0;

        public void solve(Scanner in, PrintStream out) {
            n = in.nextInt();
            k = in.nextInt();
            // ans = new String[n];
            current = in.next();
            ans = new char[k];
            for (int i = 0; i < k; i++) {
                ans[i] = current.charAt(i);
            }
            low = k;
            int numChange = 0;

            for (int i = 1; i < n; i++) {
                current = in.next();
                score = 0;
                
                for (int j = 0; j < k; j++) {
                    if (ans[j] == current.charAt(j)) {
                        score++;
                    }
                }

                if (score < low) low = score;
                numChange = (low - score) / 2;

                while (numChange > 0) {
                    for (int j = 0; j < k; j++) {
                        if (ans[j] != current.charAt(j)) {
                            if (ans[j] == 'T') ans[j] = 'F';
                            else ans[j] = 'T';
                            low++;
                            numChange--;
                            break;
                        }
                    }
                }
            }

            out.println(low);
            

            // for (int i = 0; i < n; i++) {
            //     ans[i] = in.next();
            // }

            // for (int i = 0; i < k; i++) {
            //     current = ans[0].charAt(i);

            //     for (int j = 1; j < n; j++) {
            //         if (ans[j].charAt(i) != current) {
            //             break;
            //         }
            //         if (j == n - 1) low++;
            //     }
            // }

            // out.println(low);
        }
    }
}
