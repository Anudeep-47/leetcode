class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2) return 1;
        int diff = nums[1]-nums[0];
        int max_length = diff==0 ? 1 : 2;
        for(int i=2; i<nums.length; i++){
            if((nums[i]-nums[i-1]>0 && diff<=0) || (nums[i]-nums[i-1]<0 && diff>=0)){
                max_length++;
                diff = nums[i]-nums[i-1];
            }
        }
        return max_length;
    }
}