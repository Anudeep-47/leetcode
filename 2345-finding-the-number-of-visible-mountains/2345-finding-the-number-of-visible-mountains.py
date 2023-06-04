class Solution:
    def visibleMountains(self, peaks: List[List[int]]) -> int:
        n = len(peaks)
        peaks.sort(key=lambda p: (p[0]-p[1], -p[0]-p[1]))
        count = 0
        max_end = -float('inf')
        for i, (x, y) in enumerate(peaks):
            if x+y > max_end:
                max_end = x+y
                if i<n-1 and peaks[i]==peaks[i+1]:
                    continue
                count += 1
        return count