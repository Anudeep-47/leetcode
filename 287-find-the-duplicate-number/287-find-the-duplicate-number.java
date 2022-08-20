class Solution {
    public int findDuplicate(int[] nums) {
        for(int n : nums){
            int a = Math.abs(n);
            if(nums[a]<0)return a;
            nums[a] = -nums[a];
        }
        return -1;
    }
}