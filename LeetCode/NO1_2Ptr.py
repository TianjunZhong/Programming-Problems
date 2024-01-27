class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        num_list = []
        for index, num in enumerate(nums):
            num_list.append((num, index))
        num_list.sort()

        i = 0
        j = len(num_list) - 1
        while True:
            sum = num_list[i][0] + num_list[j][0]
            
            if sum < target:
                i += 1
            elif sum > target:
                j -= 1
            else:
                return [num_list[i][1], num_list[j][1]]