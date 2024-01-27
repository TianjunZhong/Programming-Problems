import java.util.*;
import java.io.*;

public class Frogger {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    public static class Solution {
        int n, s, m, current, step, hops;
        int[] squares;

        public void solve(Scanner in, PrintStream out) {
            n = in.nextInt();
            s = in.nextInt();
            m = in.nextInt();
            squares = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                squares[i] = in.nextInt();
            }
            squares[0] = -1;

            current = s;
            step = squares[s];

            while (true) {
                squares[s] = 0;
                hops++;
                if (squares[current + step] == m) {
                    out.println("magic");
                    out.println(hops);
                    break;
                }
                else if (current + step <= 0) {
                    out.println("left");
                    out.println(hops);
                    break;
                }
                else if (current + step > n) {
                    out.println("right");
                    out.println(hops);
                    break;
                }
                else if (squares[current + step] == 0) {
                    out.println("cycle");
                    out.println(hops);
                    break;
                }
                else {
                    current += step;
                    step = squares[current];
                    squares[current] = 0;
                }
            }

        }
    }
}
