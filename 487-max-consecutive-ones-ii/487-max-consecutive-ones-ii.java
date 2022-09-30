class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // int maxOnes = 0;
        // for(int start=0, end=0, zero=-1; end<nums.length; end++){
        //     if(nums[end]==0){
        //         start = zero+1;
        //         zero = end;
        //     }
        //     maxOnes = Math.max(maxOnes, end-start+1);
        // }
        // return maxOnes;
        int maxOnes=0, prevSum=0, sum=0;
        for(int n : nums){
            sum++;
            if(n==0){
                prevSum = sum;
                sum=0;
            }
            maxOnes = Math.max(maxOnes, prevSum+sum);
        }
        return maxOnes;
    }
}