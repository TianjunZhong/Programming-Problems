class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        hash_map = dict()
        for index, num in enumerate(nums):
            complement = target - num

            if hash_map.get(complement) != None:
                return [hash_map.get(complement), index]
            elif hash_map.get(num) == None:
                hash_map.update({num: index})

        print(hash_map)