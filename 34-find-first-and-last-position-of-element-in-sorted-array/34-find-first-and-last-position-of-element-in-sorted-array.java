class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0)return new int[]{-1, -1};
        int start = findFirstOccurance(nums, target, 0, nums.length-1);
        int end = -1;
        if(start!=end){
            end = findLastOccurance(nums, target, 0, nums.length-1);
        }
        return new int[]{start, end};
    }
    private int findFirstOccurance(int[] nums, int target, int start, int end){
        while(start<end){
            int mid = start+(end-start)/2;
            if(nums[mid]>=target){
                end = mid;
            }
            else start = mid+1;
        }
        if(nums[start]==target)return start;
        return -1;
    }
    private int findLastOccurance(int[] nums, int target, int start, int end){
        while(start<end){
            int mid = start + (end-start)/2;
            if(nums[mid]<=target){
                start = mid+1;
            }
            else end = mid-1;
        }
        return nums[start]==target ? start : start-1;
    }
}