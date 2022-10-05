class Solution {
    // public int maxUncrossedLines(int[] nums1, int[] nums2) {
    //     int[][] dp = new int[nums1.length+1][nums2.length+1];
    //     for(int i=0; i<nums1.length; i++){
    //         for(int j=0; j<nums2.length; j++){
    //             if(nums1[i] == nums2[j]){
    //                 dp[i+1][j+1] = 1+dp[i][j];
    //             }
    //             else {
    //                 dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
    //             }
    //         }
    //     }
    //     return dp[nums1.length][nums2.length];
    // }
    
    public int maxUncrossedLines(int[] nums1, int[] nums2){
        if(nums1.length>nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int[] dp = new int[nums1.length+1];
        int cur=0;
        for(int i=0; i<nums2.length; i++){
            for(int j=0, prev=0; j<nums1.length; j++){
                cur = dp[j+1];
                if(nums1[j]==nums2[i]){
                    dp[j+1] = 1+prev;
                }
                else {
                    dp[j+1] = Math.max(dp[j+1], dp[j]);
                }
                prev = cur;
            }
        }
        return dp[nums1.length];
    }
}