class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        int prevMin=-1, prevMinColor=-1, prevSecondMin=-1;
        for(int i=0; i<k; i++){
            int cost = costs[0][i];
            if(prevMin==-1 || cost<prevMin){
                prevSecondMin = prevMin;
                prevMin = cost;
                prevMinColor = i;
            }
            else if(prevSecondMin==-1 || cost<prevSecondMin){
                prevSecondMin = cost;
            }
        }
        for(int i=1; i<n; i++){
            int minCost=-1, minColor=-1, secondMinCost=-1;
            for(int j=0; j<k; j++){
                int cost = costs[i][j];
                if(j==prevMinColor){
                    cost += prevSecondMin;
                }
                else {
                    cost += prevMin;
                }
                if(minCost==-1 || cost<minCost){
                    secondMinCost = minCost;
                    minCost = cost;
                    minColor = j;
                }
                else if(secondMinCost==-1 || cost<secondMinCost){
                    secondMinCost = cost;
                }
            }
            prevMin = minCost;
            prevMinColor = minColor;
            prevSecondMin = secondMinCost;
        }
        return prevMin;
    }
}