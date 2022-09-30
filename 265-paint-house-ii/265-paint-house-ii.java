class Solution {
    public int minCostII(int[][] costs) {
        int[] prev = costs[0];
        for(int i=1; i<costs.length; i++){
            int[] cur = new int[prev.length];
            cur[0] = Integer.MAX_VALUE;
            for(int j=1; j<prev.length; j++){
                cur[j] = Math.min(cur[j-1], prev[j-1]);
            }
            int rightMin = Integer.MAX_VALUE;
            for(int j=prev.length-1; j>=0; j--){
                cur[j] = Math.min(cur[j], rightMin)+costs[i][j];
                rightMin = Math.min(rightMin, prev[j]);
            }
            prev = cur;
        }
        int minCost = Integer.MAX_VALUE;
        for(int cost : prev)minCost = Math.min(minCost, cost);
        return minCost;
    }
}