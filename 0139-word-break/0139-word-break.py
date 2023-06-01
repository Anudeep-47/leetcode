from collections import deque

class Solution:
    # # recursion with memoization
    # def wordBreak(self, s: str, wordDict: List[str]) -> bool:
    #     def recursive(start, word_set, mem):
    #         if start == len(s):
    #             return True
    #         if mem[start] != None:
    #             return mem[start]
    #         for end in range(start+1, len(s)+1):
    #             if s[start:end] in word_set and recursive(end, word_set, mem):
    #                 mem[start] = True
    #                 return True
    #         mem[start] = False
    #         return False
    #     return recursive(0, frozenset(wordDict), [None]*len(s))

    # # dp O(n) space
    # def wordBreak(self, s: str, wordDict: List[str]) -> bool:
    #     word_set = frozenset(wordDict)
    #     dp = [False]*(len(s)+1)
    #     dp[0] = True
    #     for end in range(1, len(s)+1):
    #         for start in range(end):
    #             if dp[start] and s[start:end] in word_set:
    #                 dp[end] = True
    #                 break
    #     return dp[len(s)]

    # bfs
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        word_set = frozenset(wordDict)
        start_q = deque()
        visited = set()
        start_q.append(0)
        while start_q:
            start = start_q.popleft()
            if start in visited:
                continue
            for end in range(start+1, len(s)+1):
                if s[start:end] in word_set:
                    start_q.append(end)
                    if end == len(s):
                        return True
            visited.add(start)
        return False






