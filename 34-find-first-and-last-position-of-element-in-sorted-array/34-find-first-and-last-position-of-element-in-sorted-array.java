class Solution {
    public int[] searchRange(int[] nums, int target) {
        int starting = binarySearch(nums, target, true);
        if(starting==-1){
            return new int[]{-1,-1};
        }
        int ending = binarySearch(nums, target, false);
        return new int[]{starting, ending};
    }
    
    private int binarySearch(int[] nums, int target, boolean first){
        int low=0, high=nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]<target){
                low = mid+1;
            }
            else if(nums[mid]>target){
                high = mid-1;
            }
            else {
                if(first){
                    if(mid==low || nums[mid-1]!=target){
                        return mid;
                    }
                    high = mid-1;
                }
                else {
                    if(mid==high || nums[mid+1]!=target){
                        return mid;
                    }
                    low = mid+1;
                }
            }
        }
        return -1;
    }
}