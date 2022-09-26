class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(String str : strs){
            int i=0;
            while(i<str.length() && i<prefix.length() && str.charAt(i)==prefix.charAt(i)){
                i++;
            }
            prefix = prefix.substring(0, i);
        }
        return prefix;
    }
}