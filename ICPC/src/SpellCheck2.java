import java.util.*;
import java.io.*;

public class SpellCheck2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        int size;
        String word = new String();
        char[] spell = new char[5];
        char[] name = {'T', 'i', 'm', 'r', 'u'};

        public void solve(Scanner in, PrintStream out) {
            size = in.nextInt();

            for(int i = 0; i < size; i++) {
                if (in.nextInt() != 5) {
                    in.next();
                    out.println("NO");
                }
                else {
                    word = in.next();
                    for (int j = 0; j < 5; j++) {
                        spell[j] = word.charAt(j);
                    }
                    Arrays.sort(spell);

                    for(int j = 0; j < 5; j++) {
                        if (spell[j] != name[j]) {
                            out.println("NO");
                            break;
                        }
                        if (j == 4) out.println("YES");
                    }
                }
            }
        }
    }
}