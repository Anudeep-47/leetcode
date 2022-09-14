class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        for(int i=0; i<word1.length(); i++){
            for(int j=0; j<word2.length(); j++){
                memo[i][j] = -1;
            }
        }
        return memoization(word1, word2, word1.length()-1, word2.length()-1, memo);
    }
    private int memoization(String word1, String word2, int i, int j, int[][] memo){
        if(i<0)return j+1;
        if(j<0)return i+1;
        if(memo[i][j]!=-1)return memo[i][j];
        if(word1.charAt(i)==word2.charAt(j)){
            memo[i][j] = memoization(word1, word2, i-1, j-1, memo);
        }
        else{
            memo[i][j] = 1 + Math.min(memoization(word1, word2, i-1, j, memo), memoization(word1, word2, i, j-1, memo));
        }
        return memo[i][j];
    }
}