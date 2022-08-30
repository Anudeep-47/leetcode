class NumArray {
    int[] nums;
    int[] dp;
    
    public NumArray(int[] nums) {
        this.nums = nums;
        dp = new int[nums.length+1];
        for(int i=0; i<nums.length; i++){
            dp[i+1] = dp[i]+nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return dp[right+1]-dp[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */