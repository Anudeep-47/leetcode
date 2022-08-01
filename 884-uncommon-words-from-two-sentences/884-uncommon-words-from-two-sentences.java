class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] words1 = s1.split("\\s+");
        String[] words2 = s2.split("\\s+");
        HashMap<String, Integer> wordCount = new HashMap<>();
        for(String w : words1){
            wordCount.put(w, wordCount.getOrDefault(w, 0)+1);
        }
        for(String w : words2){
            wordCount.put(w, wordCount.getOrDefault(w, 0)+1);
        }
        List<String> res = new ArrayList<>();
        for(String key : wordCount.keySet()){
            if(wordCount.get(key) == 1){
                res.add(key);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}