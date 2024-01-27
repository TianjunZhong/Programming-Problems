class Solution(object):
    def earliestAcq(self, logs, n):
        uf  = UnionFind(n)
        logs.sort(key = lambda event: event[0])

        for i in range(len(logs)):
            event = logs[i]
            time = event[0]
            uf.union(event[1], event[2])

            if uf.count() == 1:
                return time
            
        return -1

class UnionFind:
    def __init__(self, n):
        self._root = []
        self._size = []
        self._count = n

        for i in range(n):
            self._root.append(i)
            self._size.append(1)

    def count(self):
        return self._count
    
    def __find(self, x):
        while x != self._root[x]:
            x = self._root[x]
        return x
    
    def union(self, x, y):
        rootX = self.__find(x)
        rootY = self.__find(y)
        if rootX == rootY:
            return
        
        if self._size[rootX] < self._size[rootY]:
            self._root[rootX] = rootY
            self._size[rootY] += self._size[rootX]
        else:
            self._root[rootY] = rootX
            self._size[rootX] += self._size[rootY]

        self._count -= 1