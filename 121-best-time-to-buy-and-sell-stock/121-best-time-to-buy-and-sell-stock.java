class Solution {
    public int maxProfit(int[] prices) {
        int minBuy = prices[0];
        int maxProfit = 0;
        for(int p : prices){
            minBuy = Math.min(minBuy, p);
            maxProfit = Math.max(maxProfit, p-minBuy);
        }
        return maxProfit;
    }
}