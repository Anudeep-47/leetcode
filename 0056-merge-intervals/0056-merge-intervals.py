class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda k: k[0])
        results = [intervals[0]]
        for i in range(1, len(intervals)):
            if results[-1][1] < intervals[i][0]:
                results.append(intervals[i])
            else:
                results[-1][1] = max(results[-1][1], intervals[i][1])
        return results