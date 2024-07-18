class Solution:
    def findPermutation(self, s: str) -> List[int]:
        # stack = []
        # res = []
        # for i in range(1, len(s)+1):
        #     stack.append(i)
        #     if s[i-1] == 'I':
        #         while len(stack)>0:
        #             res.append(stack.pop())
        # stack.append(len(s)+1)
        # while len(stack)>0:
        #     res.append(stack.pop())
        # return res

        res = []
        j = 0
        for i in range(1, len(s)+2):
            if i-1 == len(s) or s[i-1] == 'I':
                for k in range(i, j, -1):
                    res.append(k)
                j = i
        return res
        