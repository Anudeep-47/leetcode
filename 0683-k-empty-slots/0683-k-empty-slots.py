class Solution:
    def kEmptySlots(self, bulbs: List[int], k: int) -> int:
        positions = [0]*len(bulbs)
        for i, pos in enumerate(bulbs):
            positions[pos-1] = i+1
        ans = float('inf')
        left, right = 0, k+1
        while right < len(positions):
            for i in range(left+1, right):
                if positions[left] > positions[i] or positions[i] < positions[right]:
                    left, right = i, i+k+1
                    break
            else:
                ans = min(ans, max(positions[left], positions[right]))
                left, right = right, right+k+1
        return ans if ans < float('inf') else -1