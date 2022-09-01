class Solution {
    public int longestPalindromeSubseq(String s) {
        return recursiveLPS(s, 0, s.length()-1, new int[s.length()][s.length()]);
    }
    private int recursiveLPS(String s, int i, int j, int[][] memo){
        if(i>j)return 0;
        if(i==j) return 1;
        
        if(memo[i][j]!=0)return memo[i][j];
        if(s.charAt(i)==s.charAt(j)){
            memo[i][j] = 2 + recursiveLPS(s, i+1, j-1, memo);
        }
        else {
            memo[i][j] = Math.max(recursiveLPS(s, i+1, j, memo), recursiveLPS(s, i, j-1, memo));
        }
        return memo[i][j];
    }
}