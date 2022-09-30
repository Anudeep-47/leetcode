class Solution {
    public int maxProfit(int[] prices) {
        int minBuy = Integer.MAX_VALUE;
        int profit = 0;
        for(int p : prices){
            minBuy = Math.min(minBuy, p);
            profit = Math.max(profit, p-minBuy);
        }
        return profit;
    }
}