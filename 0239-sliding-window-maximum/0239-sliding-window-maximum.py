from collections import deque

class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        res = []
        max_q = deque()
        for i in range(len(nums)):
            while max_q and nums[max_q[-1]] < nums[i]:
                max_q.pop()
            max_q.append(i)
            if i-k >= max_q[0]:
                max_q.popleft()
            if i+1>=k:
                res.append(nums[max_q[0]])
        return res