class Solution {
    public int maxProfit(int[] prices) {
        int profit=0, balance=Integer.MIN_VALUE, sold=Integer.MIN_VALUE, prevSold=Integer.MIN_VALUE;
        for(int p : prices){
            int oldSold = prevSold;
            prevSold = sold;
            sold = balance+p;
            profit = Math.max(profit, oldSold);
            balance = Math.max(balance, profit-p);
        }
        return Math.max(profit, Math.max(sold, prevSold));
    }
}