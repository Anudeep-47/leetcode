class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        return Math.max(simpleRob(nums, 0, nums.length-1), simpleRob(nums, 1, nums.length));
    }
    private int simpleRob(int[] nums, int start, int end){
        int first = 0;
        int second = nums[start];
        for(int i=start+1; i<end; i++){
            int third = Math.max(second, first+nums[i]);
            first = second;
            second = third;
        }
        return Math.max(first, second);
    }
}