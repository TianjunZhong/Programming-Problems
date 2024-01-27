
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.PrintStream;

public class KarenCoffee {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        int n, k, q;
        int[] recipe;
        int rec, count;
        int l, r;

        public void solve(Scanner in, PrintStream out) {
            n = in.nextInt();
            k = in.nextInt();
            q = in.nextInt();

            recipe = new int[2 * n];

            for (int i = 0; i < n; i++) {
                recipe[2 * i] = in.nextInt();
                recipe[2 * i + 1] = in.nextInt();
            }

            for (int i = 0; i < q; i++) {
                count = 0;
                l = in.nextInt();
                r = in.nextInt();

                for (int j = l; j <= r; j++) {
                    for (int k = 0; j < n; j++) {
                        if (j >= recipe[2 * k] && j <= recipe[2 * k + 1]) rec++;
                        if (rec >= 2) {
                            count++;
                            break;
                        }
                    }
                }

                out.println(count);
            }
        }
        
    }

}