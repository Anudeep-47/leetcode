class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        int longest = 1;
        Arrays.sort(words, (a, b) -> a.length()-b.length());
        for(String word : words){
            int maxChain = 1;
            for(int i=0; i<word.length(); i++){
                String prevWord = word.substring(0, i)+word.substring(i+1);
                maxChain = Math.max(maxChain, dp.getOrDefault(prevWord, 0)+1);
            }
            dp.put(word, maxChain);
            longest = Math.max(longest, maxChain);
        }
        return longest;
    }
}