class Solution {
    public int findPeakElement(int[] nums) {
        int low=0, high=nums.length-1;
        while(low<high){
            int mid = low + (high-low)/2;
            if(nums[low]>nums[low+1])return low;
            if(nums[high]>nums[high-1])return high;
            if(nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1])return mid;
            if(nums[mid-1]>nums[mid]){
                high = mid-1;
            }
            else low = mid+1;
        }
        return low;
    }
}