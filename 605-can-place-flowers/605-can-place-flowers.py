class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        left = -1
        count = 0
        i = 0
        while i<len(flowerbed):
            if flowerbed[i] == 1:
                count += i//2 if left == -1 else (i-left)//2-1
                left = i
            i += 1
        count += (i+1)//2 if left == -1 else (i-left-1)//2
        return n <= count