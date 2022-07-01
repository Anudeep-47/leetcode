class Solution {
    public int minCost(int[][] costs) {
        int red = costs[0][0];
        int blue = costs[0][1];
        int green = costs[0][2];
        for(int i=1; i<costs.length; i++){
            int temp1 = Math.min(blue, green)+costs[i][0];
            int temp2 = Math.min(red, green)+costs[i][1];
            int temp3 = Math.min(red, blue)+costs[i][2];
            red = temp1;
            blue = temp2;
            green = temp3;
        }
        return Math.min(Math.min(red, blue), green);
    }
}