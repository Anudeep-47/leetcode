class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        arr.add(nums[0]);
        for(int i=1; i<nums.length; i++){
            if(arr.get(arr.size()-1) < nums[i]){
                arr.add(nums[i]);
            }
            else {
                int index = binarySearch(arr, nums[i]);
                arr.set(index, nums[i]);
            }
        }
        return arr.size();
    }
    private int binarySearch(List<Integer> arr, int val){
        int low = 0, high = arr.size()-1;
        while(low<high){
            int mid = low + (high-low)/2;
            if(arr.get(mid)==val)return mid;
            if(arr.get(mid)<val){
                low = mid+1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }
}