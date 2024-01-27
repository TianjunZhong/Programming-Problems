class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        for index1, num1 in enumerate(nums):
            for index2, num2 in enumerate(nums[index1 + 1 : ]):
                sum = num1 + num2
                if sum == target:
                    return [index1, index1 + 1 + index2]