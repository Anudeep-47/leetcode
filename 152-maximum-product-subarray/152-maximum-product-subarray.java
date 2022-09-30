class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int res = maxProd;
        for(int i=1; i<nums.length; i++){
            int temp = Math.max(nums[i], Math.max(maxProd*nums[i], minProd*nums[i]));
            minProd = Math.min(nums[i], Math.min(maxProd*nums[i], minProd*nums[i]));
            maxProd = temp;
            res = Math.max(res, maxProd);
        }
        return res;
    }
}