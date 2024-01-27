import java.util.*;
import java.io.*;

public class Stripes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        int t;
        String[] table = new String[8];
        boolean diff;

        public void solve(Scanner in, PrintStream out) {
            t = in.nextInt();

            for (int i = 0; i < t; i++) {
                in.nextLine();
                for (int j = 0; j < 8; j++) {
                    table[j] = in.nextLine();
                }

                for (int j = 0; j < 8; j++) {
                    diff = false;
                    String current = table[j];
                    char temp = current.charAt(0);

                    for (int k = 1; k < 7; k++) {
                        if (temp != current.charAt(k)) {
                            diff = true;
                            break;
                        }
                    }
                    if (!diff) out.println(temp);
                }
            }
        }
    }
}