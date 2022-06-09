class Solution:
    def maxDistToClosest(self, seats: List[int]) -> int:
        left_index = -1
        size = len(seats)
        i = 0
        max_nearest = 1
        while i<size:
            if seats[i]==1:
                max_nearest = max(max_nearest, i-0 if left_index==-1 else (i-left_index)//2)
                left_index = i
            i += 1
        max_nearest = max(max_nearest, i-left_index-1)
        return max_nearest