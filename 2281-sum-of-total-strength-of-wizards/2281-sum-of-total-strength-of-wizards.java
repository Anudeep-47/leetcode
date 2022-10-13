class Solution {
    public int totalStrength(int[] strength) {
        int n=strength.length;
        int mod = 1000000007;
        int[] prefix = new int[n+2];
        Stack<Integer> stk = new Stack<>();
        int sum=0;
        int total=0;
        for(int r=0; r<=n; r++){
            int num = r==n ? 0 : strength[r];
            sum = (sum+num)%mod;
            prefix[r+1] = (sum+prefix[r])%mod;
            while(!stk.isEmpty() && strength[stk.peek()]>num){
                int i = stk.pop();
                int l = stk.isEmpty() ? -1 : stk.peek();
                long lPrefix = l>=0 ? prefix[i]-prefix[l] : prefix[i];
                long rPrefix = prefix[r]-prefix[i];
                int ln = i-l;
                int rn = r-i;
                total = (int)(total + (rPrefix*ln-lPrefix*rn)%mod*strength[i]%mod)%mod;
            }
            stk.push(r);
        }
        return (total+mod)%mod;
    }
}