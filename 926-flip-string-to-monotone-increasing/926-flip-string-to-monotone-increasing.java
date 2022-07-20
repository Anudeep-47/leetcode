class Solution {
    public int minFlipsMonoIncr(String s) {
        int ones[] = new int[s.length()+1];
        for(int i=0; i<s.length(); i++){
            ones[i+1] = ones[i] + (s.charAt(i) == '1' ? 1 : 0);
        }
        int min_flips=s.length();
        for(int i=0; i<ones.length; i++){
            min_flips = Math.min(min_flips, ones[i]+s.length()-i-(ones[s.length()]-ones[i]));
        }
        return min_flips;
    }
}