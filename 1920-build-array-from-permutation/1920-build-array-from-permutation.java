class Solution {
    public int[] buildArray(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(nums[i]<=0 || i == nums[i])continue;
            nums[i] = -nums[i];
            nums[i] = recursiveBuild(nums, -nums[i]);
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]<0) nums[i] = -nums[i];
        }
        return nums;
    }
    private int recursiveBuild(int[] nums, int index){
        if(nums[index]<0)return nums[index];
        nums[index] = -nums[index];
        int temp = nums[index];
        nums[index] = recursiveBuild(nums, -nums[index]);
        return temp;
    }
}