class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        mem = {}
        for i, n in enumerate(nums):
            if target-n in mem:
                return [i, mem[target-n]]
            mem[n] = i
        return []