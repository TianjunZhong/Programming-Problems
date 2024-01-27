class Solution(object):
    def containsDuplicate(self, nums):
        num_set = set()
        for x in nums:
            if x in num_set:
                return True
            else:
                num_set.add(x)