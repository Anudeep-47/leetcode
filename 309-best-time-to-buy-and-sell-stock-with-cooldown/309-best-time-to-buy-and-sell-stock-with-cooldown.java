class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] dp = new int[n+2];
        for(int i=n-1; i>=0; i--){
            int profit1=0;
            for(int j=i+1; j<n; j++){
                profit1 = Math.max(profit1, prices[j]-prices[i]+dp[j+2]);
            }
            int profit2 = dp[i+1];
            dp[i] = Math.max(profit1, profit2);
        }
        return dp[0];
    }
}