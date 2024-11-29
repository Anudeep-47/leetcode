class Solution:
    def minZeroArray(self, nums: List[int], queries: List[List[int]]) -> int:
        n, m = len(nums), len(queries)
        freq_array = [0]*(n+1)
        count = 0
        j = 0
        for i in range(n):
            while count+freq_array[i] < nums[i]:
                if j == m:
                    return -1
                l, r, val = queries[j]
                j += 1
                if r < i:
                    continue
                freq_array[max(l, i)] += val
                freq_array[r+1] -= val
            count += freq_array[i]
        return j