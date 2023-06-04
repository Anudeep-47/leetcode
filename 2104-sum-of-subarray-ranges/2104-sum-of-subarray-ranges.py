class Solution:
    def subArrayRanges(self, nums: List[int]) -> int:
        n = len(nums)
        res = 0
        stack = []
        for right in range(n+1):
            while stack and (right==n or nums[stack[-1]]>=nums[right]):
                mid = stack.pop()
                left = stack[-1] if stack else -1
                res -= nums[mid]*(mid-left)*(right-mid)
            stack.append(right)
        stack.clear()
        for right in range(n+1):
            while stack and (right==n or nums[stack[-1]]<=nums[right]):
                mid = stack.pop()
                left = stack[-1] if stack else -1
                res += nums[mid]*(mid-left)*(right-mid)
            stack.append(right)
        return res