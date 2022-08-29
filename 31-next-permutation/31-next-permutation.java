class Solution {
    public void nextPermutation(int[] nums) {
        int i;
        for(i=nums.length-1; i>0; i--){
            if(nums[i-1]<nums[i])break;
        }
        if(i>0){
            int j;
            for(j=nums.length-1; j>=i; j--){
                if(nums[j]>nums[i-1]){
                    swap(nums, i-1, j);
                    break;
                }
            }
        }
        reverse(nums, i);
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int start){
        int end = nums.length-1;
        while(start<end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}