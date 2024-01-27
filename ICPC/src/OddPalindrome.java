import java.util.*;
import java.io.*;
import java.lang.Math;

public class OddPalindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        String line;
        int s = 1;
        boolean odd = true;

        public void solve(Scanner in, PrintStream out) {
            line = in.next();

            while (s < line.length()) {
                for (int i = 0; i + s < line.length(); i++) {
                    if (isPalindrome(i, i + s)) {
                        odd = false;
                        break;
                    }
                }
                if (!odd) break;
                s += 2;
            }

            if (odd) out.println("Odd.");
            else out.println("Or not.");
        }

        public boolean isPalindrome( int a, int b) {
            int x = a;
            int y = b;

            while (x < y) {
                if (line.charAt(x) != line.charAt(y)) return false;
                x++;
                y--;
            }
            return true;
        }
    }
}
