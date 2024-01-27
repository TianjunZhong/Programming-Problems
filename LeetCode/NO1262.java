import java.util.HashMap;

public class NO1262 {
    public static void main(String[] args) {
        int[] input = {2,3,36,8,32,38,3,30,13,40};
        int output;
        Solution solver = new Solution();
        output = solver.maxSumDivThree(input);
        System.out.println(output);

    }

    static class Solution {
        public int maxSumDivThree(int[] nums) {
            int sum = 0, remainder, i, j, complement;
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
            // Calculate the sum of the integer array and hash the elements into a hash map
            // The key of hash map is the number itself; the value is the count of the number
            for (i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (map.get(nums[i]) == null)
                    map.put(nums[i], 1);
                else
                    map.put(nums[i], map.get(nums[i]) + 1);
            }
    
            if ((remainder = sum % 3) == 0)
                return sum;
    
            for (i = remainder; i < sum; i += 3) {
                if (map.get(i) != null)
                    return sum - i;
    
                for (j = 0; j < nums.length; j++) {
                    if (nums[j] < i) {
                        complement = i - nums[j];
                        if (complement == nums[j]) {
                            if (map.get(complement) >= 2)
                                return sum - i;
                        }
                        else if (map.get(complement) != null)
                            return sum - i;
                    }
                }
            }
    
            return 0;
        }
    }
}
