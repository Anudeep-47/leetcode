class Solution:
    def removeInterval(self, intervals: List[List[int]], toBeRemoved: List[int]) -> List[List[int]]:
        # res = []
        # for inter in intervals:
        #     if inter[0] < toBeRemoved[0]:
        #         res.append([inter[0], min(inter[1], toBeRemoved[0])])
        #         if inter[1] > toBeRemoved[1]:
        #             res.append([toBeRemoved[1], inter[1]])
        #     elif inter[0] < toBeRemoved[1]:
        #         if toBeRemoved[1] < inter[1]:
        #             res.append([toBeRemoved[1], inter[1]])
        #     else:
        #         res.append([inter[0], inter[1]])
        # return res
        
        remove_start, remove_end = toBeRemoved
        res = []
        for start, end in intervals:
            if end < remove_start or start > remove_end:
                res.append([start, end])
            else:
                if start < remove_start:
                    res.append([start, remove_start])
                if end > remove_end:
                    res.append([remove_end, end])
        return res