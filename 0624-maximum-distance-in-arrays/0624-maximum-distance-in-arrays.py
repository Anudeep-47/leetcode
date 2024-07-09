class Solution:
    def maxDistance(self, arrays: List[List[int]]) -> int:
        res = 0
        min_val, max_val = arrays[0][0], arrays[0][-1]
        for i in range(1, len(arrays)):
            res = max(res, max(abs(min_val-arrays[i][-1]), abs(max_val-arrays[i][0])))
            min_val, max_val = min(min_val, arrays[i][0]), max(max_val, arrays[i][-1])
        return res
