class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            charCount.put(s.charAt(i), charCount.getOrDefault(s.charAt(i), 0)+1);
        }
        for(int i=0; i<s.length(); i++){
            if(charCount.get(s.charAt(i))==1) return i;
        }
        return -1;
    }
}