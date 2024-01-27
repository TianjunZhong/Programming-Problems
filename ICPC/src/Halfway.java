import java.util.*;
import java.io.*;
import java.lang.Math;

public class Halfway {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        long n;
        long sum = 0;
        long half;
        long ans = 1;
        long a, b;
        long c;
        long temp = 0;

        public void solve(Scanner in, PrintStream out) {
            n = in.nextLong();
            sum = (n - 1) * n / 2;

            if (sum % 2 == 0) {
                half = sum / 2;
            }
            else half = sum / 2 + 1;


            a = 1;
            b = n / 2;

            while (a <= b) {
                temp = 0;
                c = (a + b) / 2;

                temp = (n - 1 + n - c) * c / 2;

                if (temp >= half){
                    ans = c;
                    b = c - 1;
                }
                else {
                    a = c + 1;
                }
            }

            out.println(ans);
        }
    }
}
