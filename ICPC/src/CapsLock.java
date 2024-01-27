import java.util.*;
import java.io.*;

public class CapsLock {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        String word;
        char[] chars;
        boolean yes = true;
        char c;

        public void solve(Scanner in, PrintStream out) {
            word = in.next();
            chars = new char[word.length()];
            for (int i = 0; i < word.length(); i++) {
                chars[i] = word.charAt(i);
            }

            for (int i = 1; i < word.length(); i++) {
                c = chars[i];
                if (c >= 'a' && c <= 'z') {
                    yes = false;
                    break;
                }
            }

            if (yes) {
                c = word.charAt(0);
                if (c >= 'a' && c <= 'z') {
                    chars[0] -= 32;
                }
                else {
                    chars[0] += 32;
                }
                for (int i = 1; i < word.length(); i++) {
                    chars[i] += 32;
                }

                for (int i = 0; i < word.length(); i++)
                    out.print(chars[i]);
                out.println("\n");
            }
            else
                out.println(word);
        }
    }
}