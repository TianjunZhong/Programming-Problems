
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.PrintStream;

public class AverageCharacter {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        String line = new String();
        int a = 0;

        public void solve(Scanner in, PrintStream out) {
            line = in.nextLine();
            
            for (int i = 0; i < line.length(); i++) {
                a += line.charAt(i);
            }

            a /= line.length();

            out.println((char)a);
        }
    }

}