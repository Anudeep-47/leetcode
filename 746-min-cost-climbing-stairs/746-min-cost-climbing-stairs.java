class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int first=0, second=0;
        for(int i=2; i<=cost.length; i++){
            int temp = Math.min(first+cost[i-2], second+cost[i-1]);
            first = second;
            second = temp;
        }
        return second;
    }
}