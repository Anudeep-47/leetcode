class Solution:
    def isZeroArray(self, nums: List[int], queries: List[List[int]]) -> bool:
        n = len(nums)
        freq_array = [0]*n
        for q in queries:
            start, end = q
            freq_array[start] += 1
            if end + 1 < n:
                freq_array[end+1] -= 1
        count = 0
        for i in range(n):
            count += freq_array[i]
            if count < nums[i]:
                return False
        return True