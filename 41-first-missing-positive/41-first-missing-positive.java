class Solution {
    public int firstMissingPositive(int[] nums) {
        int count=0;
        for(int n : nums){
            if(n==1){
                count++;
                break;
            }
        }
        if(count==0)return 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]<=0 || nums[i]>nums.length){
                nums[i] = 1;
            }
        }
        for(int i=0; i<nums.length; i++){
            int n = Math.abs(nums[i]);
            nums[n-1] = -Math.abs(nums[n-1]);
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0)return i+1;
        }
        return nums.length+1;
    }
}