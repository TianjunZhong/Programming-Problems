from collections import deque

class Solution(object):
    def racecar(self, target):
        queue = deque([(0, 1, 0)])

        while queue:
            position, velocity, step = queue.popleft()
            if position == target:
                return step
            
            if position + velocity < target * 2:
                queue.append((position + velocity, velocity * 2, step + 1))

            if position + velocity > target and velocity > 0:
                queue.append((position, -velocity/velocity, step + 1))
            elif position + velocity < target and velocity < 0:
                queue.append((position, -velocity/abs(velocity), step + 1))

        return -1
    
solver = Solution()
print(solver.racecar(4))