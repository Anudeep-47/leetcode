class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum=0, left=0, n=nums.length, res=n+1;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            while(sum>=target){
                res = Math.min(res, i-left+1);
                sum -= nums[left++];
            }
        }
        return res%(n+1);
    }
}