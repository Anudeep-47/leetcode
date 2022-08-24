class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if(sentence1.length!=sentence2.length)return false;
        
        Map<String, HashSet<String>> simMap = new HashMap<>();
        for(List<String> sims : similarPairs){
            simMap.putIfAbsent(sims.get(0), new HashSet<>());
            simMap.putIfAbsent(sims.get(1), new HashSet<>());
            HashSet<String> set = simMap.get(sims.get(0));
            set.add(sims.get(1));
            set = simMap.get(sims.get(1));
            set.add(sims.get(0));
        }
        
        for(int i=0; i<sentence1.length; i++){
            String word1 = sentence1[i];
            String word2 = sentence2[i];
            if(!word1.equals(word2)){
                if(simMap.containsKey(word1)){
                    if(!simMap.get(word1).contains(word2))return false;
                }
                else if(simMap.containsKey(word2)){
                    if(!simMap.get(word2).contains(word1))return false;
                } 
                else return false;
            }
        }
        return true;
    }
}