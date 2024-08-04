# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
#class NestedInteger:
#    def __init__(self, value=None):
#        """
#        If value is not specified, initializes an empty list.
#        Otherwise initializes a single integer equal to value.
#        """
#
#    def isInteger(self):
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        :rtype bool
#        """
#
#    def add(self, elem):
#        """
#        Set this NestedInteger to hold a nested list and adds a nested integer elem to it.
#        :rtype void
#        """
#
#    def setInteger(self, value):
#        """
#        Set this NestedInteger to hold a single integer equal to value.
#        :rtype void
#        """
#
#    def getInteger(self):
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        :rtype int
#        """
#
#    def getList(self):
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        :rtype List[NestedInteger]
#        """

class Solution:
    def depthSumInverse(self, nestedList: List[NestedInteger]) -> int:
        # max_depth = 0
        # val_sum = 0
        # val_d_prod_sum = 0
        # cur_depth = 1
        # list_q = deque()
        # list_q.append(nestedList)
        # while len(list_q):
        #     level_size = len(list_q)
        #     max_depth = max(max_depth, cur_depth)
        #     for _ in range(level_size):
        #         nestList = list_q.popleft()
        #         for nestInt in nestList:
        #             if nestInt.isInteger():
        #                 val = nestInt.getInteger()
        #                 val_sum += val
        #                 val_d_prod_sum += val*cur_depth
        #             else:
        #                 if len(nestInt.getList()):
        #                     list_q.append(nestInt.getList())
        #     cur_depth += 1
        # return (max_depth + 1)*val_sum - val_d_prod_sum
        weighted, unweighted = 0, 0
        while nestedList:
            nextList = []
            for nestInt in nestedList:
                if nestInt.isInteger():
                    unweighted += nestInt.getInteger()
                else:
                    nextList.extend([val for val in nestInt.getList()])
            weighted += unweighted
            nestedList = nextList
        return weighted