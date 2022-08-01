class Solution {
    public void sortColors(int[] nums) {
        int p0, p1, p2;
        p0 = p1 = 0;
        p2 = nums.length-1;
        while(p1<=p2){
            if(nums[p1]==2){
                swap(nums, p1, p2);
                p2--;
            }
            else if(nums[p1]==0){
                swap(nums, p1, p0);
                p0++;
                p1++;
            }
            else p1++;
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}