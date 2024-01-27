public class NO53_DP {
    static class Solution {
        public int maxSubArray(int[] nums) {
            int length = nums.length;
            int[] dp = new int[length];
            int sum, max = Integer.MIN_VALUE;

            dp[0] = nums[0];
            for (int i = 1; i < length; i++) {
                dp[i] = sum = ((dp[i - 1] > 0) ? dp[i - 1] + nums[i] : nums[i]);
                if (sum > max)
                    max = sum;
            }

            return max;
        }
    }
}
