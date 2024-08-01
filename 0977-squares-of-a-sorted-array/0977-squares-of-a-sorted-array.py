class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = [0]*n
        i, j = 0, n-1
        for k in range(n-1, -1, -1):
            left, right = nums[i]*nums[i], nums[j]*nums[j]
            if left < right:
                res[k] = right
                j -= 1
            else:
                res[k] = left
                i += 1
        return res