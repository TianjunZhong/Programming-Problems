public class NO1262_DP {
    public static void main(String[] args) {
        int[] input = {2,3,36,8,32,38,3,30,13,40};
        int output;
        Solution solver = new Solution();
        output = solver.maxSumDivThree(input);
        System.out.println(output);

    }

    static class Solution {
        public int maxSumDivThree(int[] nums) {
            int[][] dp = new int[nums.length + 1][3];
            int element;
            
            for (int i = 0; i < nums.length; i++) {
                element = nums[i];
                if (element % 3 == 0) {
                    dp[i + 1][0] = dp[i][0] + element;

                    if (dp[i][1] != 0)
                        dp[i + 1][1] = dp[i][1] + element;

                    if (dp[i][2] != 0)
                        dp[i + 1][2] = dp[i][2] + element;
                }
                else if (element % 3 == 1) {
                    if (dp[i][2] != 0)
                        dp[i + 1][0] = Math.max(dp[i][0], dp[i][2] + element);
                    else
                        dp[i + 1][0] = dp[i][0];

                    dp[i + 1][1] = Math.max(dp[i][1], dp[i][0] + element);

                    if (dp[i][1] != 0)
                        dp[i + 1][2] = Math.max(dp[i][2], dp[i][1] + element);
                    else
                        dp[i + 1][2] = dp[i][2];
                }
                else {
                    if (dp[i][1] != 0)
                        dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + element);
                    else
                        dp[i + 1][0] = dp[i][0];

                    if (dp[i][2] != 0)
                        dp[i + 1][1] = Math.max(dp[i][1], dp[i][2] + element);
                    else
                        dp[i + 1][1] = dp[i][1];
                        
                    dp[i + 1][2] = Math.max(dp[i][2], dp[i][0] + element);
                }
            }

            return dp[nums.length][0];
        }
    }
}
