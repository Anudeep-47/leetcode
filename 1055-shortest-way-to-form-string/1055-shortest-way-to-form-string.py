class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        # # O(ST) time and O(1) space
        # n = len(source)
        # i = 0
        # count = 0
        # for c in target:
        #     if i == 0:
        #         count += 1
        #     loop = n
        #     while source[i]!=c and loop>0:
        #         i = (i+1)%n
        #         if i == 0:
        #             count += 1
        #         loop -= 1
        #     if loop == 0:
        #         return -1
        #     i = (i+1)%n
        # return count

        # O(S+T) time and O(S) space
        n = len(source)
        next_occurance = [None for _ in range(n)]
        next_occurance[-1] = {source[-1]: n-1}
        for i in range(n-2, -1, -1):
            next_occurance[i] = next_occurance[i+1].copy()
            next_occurance[i][source[i]] = i
        print(next_occurance)
        i, count = 0, 1
        for c in target:
            if c not in next_occurance[0]:
                return -1
            if i == n or c not in next_occurance[i]:
                count += 1
                i = 0
            i = next_occurance[i][c] + 1
        return count
