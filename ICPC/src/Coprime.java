import java.util.*;
import java.io.*;
import java.lang.Math;

public class Coprime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Stripes.Solution solver = new Stripes.Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        int t;
        public void solve(Scanner in, PrintStream out) {
            t = in.nextInt();
        }
    }
}
