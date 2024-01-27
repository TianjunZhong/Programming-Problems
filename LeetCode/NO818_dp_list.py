import math

class Solution(object):
    def __init__(self):
        self.__dp = [0] * 10001

    def racecar(self, target):
        if self.__dp[target] > 0:
            return self.__dp[target]
        
        num_digit = int(math.log(target, 2)) + 1
        if 2 ** num_digit - 1 == target:
            self.__dp[target] = num_digit
        else:
            step = num_digit + 1 + self.racecar(2 ** num_digit - 1 - target)
            i = 0
            while i < num_digit - 1:
                temp = (num_digit - 1) + 1 + i + 1 + self.racecar(target - (2 ** (num_digit - 1) - 1) + (2 ** i - 1))
                if temp < step:
                    step = temp
                i += 1
            self.__dp[target] = step

        return self.__dp[target]

