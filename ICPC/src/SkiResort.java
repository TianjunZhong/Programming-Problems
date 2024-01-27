import java.util.Scanner;

public class SkiResort {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        int n, q, k;
        int temp;
        int currentChunkSize;
        long result;

        long[] prefixSum = new long[200000 + 5];
        prefixSum[0] = 0;
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + i;
        }

        for (int i = 0; i < t; i++) {
            n = in.nextInt();
            k = in.nextInt();
            q = in.nextInt();
            currentChunkSize = 0;
            result = 0;

            for (int j = 0; j < n; j++) {
                temp = in.nextInt();

                if (temp <= q)
                    currentChunkSize++;
                else {
                    if (currentChunkSize >= k) {
                            result += prefixSum[currentChunkSize - k + 1];
                    }
                    currentChunkSize = 0;
                }
            }
            if (currentChunkSize >= k) {
                result += prefixSum[currentChunkSize - k + 1];
            }

            System.out.println(result);
        }
    }
}
