class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left, right = 1, max(piles)
        while left<right:
            mid = left+(right-left)//2
            hours = 0
            for p in piles:
                hours += math.ceil(p/mid)
            if hours > h:
                left = mid+1
            else:
                right = mid
        return right
