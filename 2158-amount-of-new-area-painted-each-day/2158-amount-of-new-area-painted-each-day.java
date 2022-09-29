class Solution {
    // jump line solution
    public int[] amountPainted(int[][] paint) {
        int[] line = new int[50001];
        int[] res = new int[paint.length];
        for(int i=0; i<paint.length; i++){
            int start = paint[i][0];
            int end = paint[i][1];
            int amount = 0;
            while(start < end){
                int jump = Math.max(start+1, line[start]);
                amount += line[start] == 0 ? 1 : 0;
                line[start] = Math.max(line[start], end);
                start = jump;
            }
            res[i] = amount;
        }
        return res;
    }
}