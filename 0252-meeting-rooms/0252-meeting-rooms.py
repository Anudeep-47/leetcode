class Solution:
    def canAttendMeetings(self, intervals: List[List[int]]) -> bool:
        sorted_intervals = sorted(intervals, key=lambda k: k[0])
        for i in range(len(intervals)-1):
            if sorted_intervals[i][1] > sorted_intervals[i+1][0]:
                return False
        return True