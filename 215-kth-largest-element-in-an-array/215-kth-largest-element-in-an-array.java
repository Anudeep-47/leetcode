class Solution {
    public int findKthLargest(int[] nums, int k) {
        int low=0, high=nums.length-1;
        k = nums.length-k;
        while(low<high){
            int partitionIndex = partition(nums, low, high);
            if(k<partitionIndex){
                high = partitionIndex-1;
            }
            else if(partitionIndex<k){
                low = partitionIndex+1;
            }
            else return nums[k];
        }
        return nums[low];
    }
    
    private int partition(int[] nums, int low, int high){
        int pivot = low;
        while(low<=high){
            while(low<=high && nums[low]<=nums[pivot])low++;
            while(low<=high && nums[high]>nums[pivot])high--;
            if(low>high)break;
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
        }
        int temp = nums[high];
        nums[high] = nums[pivot];
        nums[pivot] = temp;
        return high;
    }
}