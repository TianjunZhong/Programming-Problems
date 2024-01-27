import java.util.*;
import java.io.*;
import java.lang.Math;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        int n;
        String all;
        int i = 0;
        int correct = 1;
        int step = 1;

        public void solve(Scanner in, PrintStream out) {
            n = in.nextInt();
            all = in.next();
            
            while (i < all.length()) {
                String temp = correct + "";
                step = temp.length();

                if (correct != Integer.parseInt(all.substring(i, i + step))){
                    out.println(correct);
                    return;
                }

                correct++;
                i += step;
            }
            out.println(correct);
        }
    }
}
