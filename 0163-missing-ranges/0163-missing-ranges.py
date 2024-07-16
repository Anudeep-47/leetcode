class Solution:
    def findMissingRanges(self, nums: List[int], lower: int, upper: int) -> List[List[int]]:
        cur, result = lower, []
        for n in nums:
            if cur < n:
                result.append([cur, n-1])
            cur = n+1
        if cur<=upper:
            result.append([cur, upper])
        return result