public class NO53_prefix {
    static class Solution {
        public int maxSubArray(int[] nums) {
            int length = nums.length;
            int[] prefixSum = new int[length + 1];
            int sum, max = Integer.MIN_VALUE;
    
            prefixSum[0] = 0;
            for (int i = 1; i <= length; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
            }
    
            for (int i = 1; i <= length; i++) {
                for (int j = 0; j + i <= length; j++) {
                    sum = prefixSum[j + i] - prefixSum[j];
                    if (sum > max)
                        max = sum;
                }
            }
    
            return max;
        }
    }
}
