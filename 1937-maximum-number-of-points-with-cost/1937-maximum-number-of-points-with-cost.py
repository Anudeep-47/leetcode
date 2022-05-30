class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        def left_sum(arr):
            left = [arr[0]] + [0]*(n-1)
            for j in range(1, n):
                left[j] = max(left[j-1]-1, arr[j])
            return left
        def right_sum(arr):
            right = [0]*(n-1) + [arr[-1]]
            for j in range(n-2, -1, -1):
                right[j] = max(right[j+1]-1, arr[j])
            return right
        
        m, n = len(points), len(points[0])
        prev = points[0]
        for i in range(1, m):
            left_row, right_row, cur = left_sum(prev), right_sum(prev), [0]*n
            for j in range(n):
                cur[j] = points[i][j] + max(left_row[j], right_row[j])
            prev = cur[:]
        return max(prev)