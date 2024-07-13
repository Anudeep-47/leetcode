class Solution:
    def countElements(self, arr: List[int]) -> int:
        count = 0
        counter = collections.Counter(arr)
        for key, val in counter.items():
            if key+1 in counter:
                count += val
        return count