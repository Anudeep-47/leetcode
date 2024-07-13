class Solution:
    def largestUniqueNumber(self, nums: List[int]) -> int:
        max_num = -1
        counter = collections.Counter(nums)
        for key, val in counter.items():
            if val==1:
                max_num = max(max_num, key)
        return max_num