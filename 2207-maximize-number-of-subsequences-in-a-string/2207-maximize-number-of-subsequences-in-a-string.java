class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        long res = 0, count1 = 0, count2 = 0;
        for(char c : text.toCharArray()){
            if(c == pattern.charAt(1)){
                res += count1;
                count2++;
            }
            if(c == pattern.charAt(0)){
                count1++;
            }
        }
        return res + Math.max(count1, count2);
    }
}