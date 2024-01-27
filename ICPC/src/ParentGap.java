import java.util.*;
import java.io.*;

public class ParentGap {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solver = new Solution();
        solver.solve(in, System.out);
    }

    public static class Solution {
        int year, temp1, temp2, temp3, sun;

        // 2000 may first sun is 7 (need to be <= 3)

        public void solve(Scanner in, PrintStream out) {
            year = in.nextInt();
            temp1 = (year - 2000) % 28;
            temp2 = (year - 2000) / 100;
            temp3 = (year - 2000) / 400;

            int sun = (7 - (temp1 * 5 / 4) + temp2 - temp3) % 7;
            if (sun <= 0) sun += 7;
            //out.println(sun);
            if (sun <= 3) out.println("6 weeks");
            else out.println("5 weeks");

//            for (int i = 2000; i < 2200; i ++) {
//                temp1 = (i - 2000) % 28;
//                temp2 = (i - 2000) / 100;
//                temp3 = (i - 2000) / 400;
//                System.out.println(i + ": ");
//                System.out.println((7 - (temp1 * 5 / 4) + temp2 - temp3) % 7);
//            }
        }
    }
}


