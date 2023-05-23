class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        unique_nums = set(nums)
        max_len = 0
        for n in unique_nums:
            if n-1 not in unique_nums:
                current_num = n
                seq_len = 1
                while current_num+1 in unique_nums:
                    seq_len += 1
                    current_num += 1
                max_len = max(max_len, seq_len)
        return max_len