class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length()+1][text2.length()+1];
        for(int i=0; i<text1.length(); i++){
            for(int j=0; j<text2.length(); j++){
                memo[i][j] = -1;
            }
        }
        return memoization(text1, text2, 0, 0, memo);
    }
    private int memoization(String text1, String text2, int i, int j, int[][] memo){
        if(memo[i][j] != -1)return memo[i][j];
        if(text1.charAt(i)==text2.charAt(j)){
            memo[i][j] = 1 + memoization(text1, text2, i+1, j+1, memo);
        }
        else {
            memo[i][j] = Math.max(memoization(text1, text2, i+1, j, memo), memoization(text1, text2, i, j+1, memo));
        }
        return memo[i][j];
    }
}