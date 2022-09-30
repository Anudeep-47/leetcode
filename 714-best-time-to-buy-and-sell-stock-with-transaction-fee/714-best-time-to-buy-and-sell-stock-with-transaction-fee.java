class Solution {
    public int maxProfit(int[] prices, int fee) {
        int profit=0, balance=-50001;
        for(int p : prices){
            profit = Math.max(profit, balance+p-fee);
            balance = Math.max(balance, profit-p);
        }
        return profit;
    }
}