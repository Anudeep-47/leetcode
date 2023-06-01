class Solution:
    # # dp O(n^2) time
    # def lengthOfLIS(self, nums: List[int]) -> int:
    #     dp = [1]*len(nums)
    #     for i in range(1, len(nums)):
    #         for j in range(i):
    #             if nums[j]<nums[i]:
    #                 dp[i] = max(dp[i], dp[j]+1)
    #     return max(dp)

    # # building sequence O(n^2) time
    # def lengthOfLIS(self, nums: List[int]) -> int:
    #     seq = [nums[0]]
    #     for i in range(1, len(nums)):
    #         if nums[i]>seq[-1]:
    #             seq.append(nums[i])
    #         else:
    #             j = 0
    #             while seq[j] < nums[i]:
    #                 j += 1
    #             seq[j] = nums[i]
    #     return len(seq)

    # using binary search to find and build seq
    # O(nlogn) time
    def lengthOfLIS(self, nums: List[int]) -> int:
        seq = []
        for num in nums:
            index = bisect_left(seq, num)
            if index == len(seq):
                seq.append(num)
            else:
                seq[index] = num
        return len(seq)


