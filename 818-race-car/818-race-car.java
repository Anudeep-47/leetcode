class Solution {
    public int racecar(int target) {
        int[] dp = new int[10001];
        return recursiveRace(target, dp);
    }
    private int recursiveRace(int target, int[] dp){
        if(dp[target]>0) return dp[target];
        int t = target;
        int n = (int)(Math.log(t)/Math.log(2))+1;
        if(1<<n == t+1){
            dp[t] = n;
        }
        else {
            dp[t] = n + 1 + recursiveRace((1<<n)-1-t, dp);
            for(int m=0; m<n-1; m++){
                dp[t] = Math.min(dp[t], n-1+1+m+1+recursiveRace(t-((1<<(n-1))-1)+((1<<m)-1), dp));
            }
        }
        return dp[t];
    }
}