import java.util.*;
import java.io.*;
import java.lang.Math;

public class MagicTrick {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        String s;
        int i = 0;
        char temp;

        public void solve(Scanner in, PrintStream out) {
            s = in.next();

            while(i < s.length()) {
                temp = s.charAt(i);

                for (int j = i + 1; j < s.length(); j++) {
                    if (temp == s.charAt(j)) {
                        out.println(0);
                        return;
                    }
                }
                i++;
            }
            out.println(1);
        }
    }
}
