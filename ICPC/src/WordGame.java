import java.util.*;
import java.io.*;

public class WordGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        int t, n;
        int[][][] count;
        String[][] words;
        String temp;

        public void solve(Scanner in, PrintStream out) {
            t = in.nextInt();
            for (int i = 0; i < t; i++) {
                count = new int[26][26][26];
                n = in.nextInt();
                words = new String[3][n];

                for (int k = 0; k < 3; k++) {
                    for (int j = 0; j < n; j++) {
                        temp = in.next();
                        count[temp.charAt(0) - 97][temp.charAt(1) - 97][temp.charAt(2) - 97]++;
                        words[k][j] = temp;
                    }
                }

                out.println(computeScore(0) + " " + computeScore(1) + " " + computeScore(2));
            }
        }

        public int computeScore(int who) {
            int score = 0;

            for (int i = 0; i < n; i++) {
                temp = words[who][i];
                int times = count[temp.charAt(0) - 97][temp.charAt(1) - 97][temp.charAt(2) - 97];

                if (times == 1) score += 3;
                else if (times == 2) score += 1;
            }

            return score;
        }
    }
}