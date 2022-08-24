class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if(sentence1.length!=sentence2.length)return false;
        
        Map<String, List<String>> simMap = new HashMap<>();
        for(List<String> sims : similarPairs){
            simMap.putIfAbsent(sims.get(0), new ArrayList<>());
            simMap.putIfAbsent(sims.get(1), new ArrayList<>());
            List<String> lst = simMap.get(sims.get(0));
            lst.add(sims.get(1));
            lst = simMap.get(sims.get(1));
            lst.add(sims.get(0));
        }
        
        for(int i=0; i<sentence1.length; i++){
            String word1 = sentence1[i];
            String word2 = sentence2[i];
            if(word1.equals(word2))continue;
            Stack<String> stk = new Stack<>();
            HashSet<String> seen = new HashSet<>();
            stk.push(word1);
            seen.add(word1);
            boolean nomatch = true;
            while(!stk.isEmpty()){
                String word = stk.pop();
                if(word.equals(word2)){
                    nomatch = false;
                    break;
                };
                if(!simMap.containsKey(word))return false;
                for(String simWord : simMap.get(word)){
                    if(!seen.contains(simWord)){
                        stk.push(simWord);
                        seen.add(simWord);
                    }
                }
            }
            if(nomatch)return false;
        }
        return true;
    }
}