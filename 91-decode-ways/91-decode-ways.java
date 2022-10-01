class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        return recursiveDecode(0, s, memo);
    }
    private int recursiveDecode(int i, String s, int[] memo){
        if(i==s.length())return 1;
        if(memo[i]>0)return memo[i];
        if(s.charAt(i)=='0')return 0;
        if(i==s.length()-1)return 1;
        memo[i] = recursiveDecode(i+1, s, memo);
        if(Integer.parseInt(s.substring(i, i+2))<=26){
            memo[i] += recursiveDecode(i+2, s, memo);
        }
        return memo[i];
    }
}