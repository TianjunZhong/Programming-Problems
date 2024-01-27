import java.util.Scanner;

public class LongLong {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        int n;
        // int[] array;
        int numOps, temp;
        long sum;
        boolean isNeg;

        for (int i = 0; i < t; i++) {
            n = in.nextInt();
            // array = new int[n];
            sum = 0;
            numOps = 0;
            isNeg = false;

            for (int j = 0; j < n; j++) {
                temp = in.nextInt();
                sum += Math.abs(temp);

                if (temp < 0) {
                    if (!isNeg) {
                        isNeg = true;
                        numOps++;
                    }
                }
                else if (temp > 0) {
                    if (isNeg) {
                        isNeg = false;
                    }
                }

            }

            System.out.println(sum + " " + numOps);
        }

    }
}
