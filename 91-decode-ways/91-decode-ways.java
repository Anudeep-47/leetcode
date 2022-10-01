class Solution {
    // public int numDecodings(String s) {
    //     int[] memo = new int[s.length()];
    //     return recursiveDecode(0, s, memo);
    // }
    // private int recursiveDecode(int i, String s, int[] memo){
    //     if(i==s.length())return 1;
    //     if(memo[i]>0)return memo[i];
    //     if(s.charAt(i)=='0')return 0;
    //     if(i==s.length()-1)return 1;
    //     memo[i] = recursiveDecode(i+1, s, memo);
    //     if(Integer.parseInt(s.substring(i, i+2))<=26){
    //         memo[i] += recursiveDecode(i+2, s, memo);
    //     }
    //     return memo[i];
    // }
    
    public int numDecodings(String s){
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0)=='0' ? 0 : 1;
        for(int i=2; i<dp.length; i++){
            dp[i] = s.charAt(i-1)!='0' ? dp[i-1] : dp[i];
            int val = Integer.parseInt(s.substring(i-2, i));
            if(val >= 10 && val <= 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }
}