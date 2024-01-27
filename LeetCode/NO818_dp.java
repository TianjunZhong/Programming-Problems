public class NO818_dp {
    static class Solution {
        int[] dp = new int[10001];

        public int racecar(int target) {
            if (dp[target] > 0) return dp[target];

            int numDigit = (int)(Math.log(target) / Math.log(2) + 1);
            if (Math.pow(2, numDigit) - 1 == target) dp[target] = numDigit;
            else {
                int step = numDigit + 1 + racecar((int)Math.pow(2, numDigit) - 1 - target);
                int i = 0;
                while (i < numDigit - 1) {
                    int temp = (numDigit - 1) + 1 + i + 1 + racecar(target - (int)(Math.pow(2, numDigit - 1) - 1) + (int)(Math.pow(2, i) - 1));
                    if (temp < step) step = temp;
                    i++;
                }
                dp[target] = step;
            }

            return dp[target];
        }
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        System.out.println(solver.racecar(5));
    }
}
