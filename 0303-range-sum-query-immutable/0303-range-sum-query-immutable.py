class NumArray:

    def __init__(self, nums: List[int]):
        self.prefix_sum = []
        num_sum = 0
        for n in nums:
            num_sum += n
            self.prefix_sum.append(num_sum)
        

    def sumRange(self, left: int, right: int) -> int:
        return self.prefix_sum[right] - (0 if left==0 else self.prefix_sum[left-1])


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(left,right)