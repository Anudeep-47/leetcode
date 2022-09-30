class Solution {
    public int maxSubArray(int[] nums) {
        return divideAndConquer(nums, 0, nums.length-1);
    }
    private int divideAndConquer(int[] nums, int left, int right){
        if(left>right)return Integer.MIN_VALUE;
        int mid = left + (right-left)/2;
        int maxLeftSum = 0;
        int maxRightSum = 0;
        for(int i=mid-1, sum=0; i>=left; i--){
            sum += nums[i];
            maxLeftSum = Math.max(maxLeftSum, sum);
        }
        for(int i=mid+1, sum=0; i<=right; i++){
            sum += nums[i];
            maxRightSum = Math.max(maxRightSum, sum);
        }
        int curSum = maxLeftSum + nums[mid] + maxRightSum;
        int leftSum = divideAndConquer(nums, left, mid-1);
        int rightSum = divideAndConquer(nums, mid+1, right);
        return Math.max(curSum, Math.max(leftSum, rightSum));
    }
}