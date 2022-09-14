class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if(n==0)return new ArrayList<>();
        int[] dp = new int[n];
        Arrays.sort(nums);
        int maxSubsetSize = -1, maxSubsetIndex = -1;
        for(int i=0; i<n; i++){
            int subsetSize = 0;
            for(int k=0; k<i; k++){
                if(nums[i]%nums[k]==0 && subsetSize < dp[k]){
                    subsetSize = dp[k];
                }
            }
            dp[i] = subsetSize+1;
            if(maxSubsetSize < dp[i]){
                maxSubsetSize = dp[i];
                maxSubsetIndex = i;
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        int curSize = maxSubsetSize;
        int cur = nums[maxSubsetIndex];
        for(int i=maxSubsetIndex; i>=0; i--){
            if(curSize==0)break;
            if(cur%nums[i]==0 && curSize == dp[i]){
                res.addFirst(nums[i]);
                cur = nums[i];
                curSize--;
            }
        }
        return res;
    }
}