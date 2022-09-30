class Solution {
    public int rob(int[] nums) {
        int first = 0;
        int second = nums[0];
        for(int i=1; i<nums.length; i++){
            int third = Math.max(second, first+nums[i]);
            first = second;
            second = third;
        }
        return Math.max(first, second);
    }
}