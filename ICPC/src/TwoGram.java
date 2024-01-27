import java.util.*;
import java.io.*;

public class TwoGram {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        int m;
        int n;
        int b = 97;

        public void solve(Scanner in, PrintStream out) {
            m = in.nextInt();
        }

        public long hash(char a, char b) {
            return a * 97 + b * 97 * 97;
        }
    }
}