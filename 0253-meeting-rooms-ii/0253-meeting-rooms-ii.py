class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        starts = sorted([inter[0] for inter in intervals])
        ends = sorted([inter[1] for inter in intervals])
        n = len(intervals)
        i, j = 0, 0
        rooms, max_rooms = 0, 0
        while i<n:
            if starts[i]<ends[j]:
                rooms += 1
                max_rooms = max(max_rooms, rooms)
                i += 1
            else:
                rooms -= 1
                j += 1
        return max_rooms