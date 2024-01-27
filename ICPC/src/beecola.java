
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.PrintStream;

public class beecola {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    static class Solution {
        int shops;
        int[] prices;
        int days;
        int[] money;
        int count;

        public void solve(Scanner in, PrintStream out) {
            shops = in.nextInt();
            prices = new int[shops];
            for (int i = 0; i < shops; i++) {
                prices[i] = in.nextInt();
            }
            Arrays.sort(prices);
            days = in.nextInt();

            int k = 0;
            int coin;

            for (int j = 0; j < days; j++) {
                coin = in.nextInt();
                for (int i = 20; i >= 0; i--) {
                    if (k + (1 << i) < shops && prices[k + (1 << i)] <= coin) k += (1 << i);
                }
                out.println(k);
            }
        }

        // public void solve(Scanner in, PrintStream out) {
        //     shops = in.nextInt();
        //     prices = new int[shops];
        //     for (int i = 0; i < shops; i++) {
        //         prices[i] = in.nextInt();
        //     }
        //     days = in.nextInt();
        //     money = new int[days];
        //     for (int i = 0; i < days; i++) {
        //         money[i] = in.nextInt();
        //     }

        //     for (int i = 0; i < days; i++) {
        //         count = 0;
        //         for (int k = 0; k < shops; k++) {
        //             if (money[i] >= prices[k]) count++;
        //         }
        //         out.println(count);
        //     }
        // }
    }

}