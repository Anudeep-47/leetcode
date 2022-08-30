class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==0)return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start=0, end=0;
        for(int i=0; i<s.length(); i++){
            dp[i][i] = true;
            if(i>0 && s.charAt(i)==s.charAt(i-1)){
                dp[i-1][i] = true;
                start = i-1;
                end = i;
            }
        }
        for(int i=s.length()-3; i>=0; i--){
            for(int j=i+2; j<s.length(); j++){
                if(!dp[i][j] && dp[i+1][j-1] && s.charAt(i)==s.charAt(j)){
                    dp[i][j] = true;
                }
                if(dp[i][j] && j-i>end-start){
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end+1);
    }
}