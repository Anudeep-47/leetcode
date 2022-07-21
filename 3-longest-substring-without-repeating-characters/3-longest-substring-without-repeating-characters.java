class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        int start = 0;
        int maxLen = 0;
        for(int end=start; end<s.length(); end++){
            if(charMap.containsKey(s.charAt(end))){
                start = Math.max(start, charMap.get(s.charAt(end))+1);
            }
            charMap.put(s.charAt(end), end);
            maxLen = Math.max(maxLen, end-start+1);
        }
        return maxLen;
    }
}