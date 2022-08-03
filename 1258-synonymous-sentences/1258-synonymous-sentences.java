class Solution {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, List<String>> synMap = new HashMap<>();
        for(List<String> pair : synonyms){
            synMap.putIfAbsent(pair.get(0), new LinkedList<>());
            synMap.get(pair.get(0)).add(pair.get(1));
            synMap.putIfAbsent(pair.get(1), new LinkedList<>());
            synMap.get(pair.get(1)).add(pair.get(0));
        }
        TreeSet<String> res = new TreeSet<>();
        Queue<String> bfs = new ArrayDeque<>();
        bfs.add(text);
        while(!bfs.isEmpty()){
            String txt = bfs.poll();
            res.add(txt);
            String[] words = txt.split("\\s+");
            for(int i=0; i<words.length; i++){
                if(synMap.get(words[i])==null)continue;
                for(String word : synMap.get(words[i])){
                    words[i] = word;
                    String newText = String.join(" ", words);
                    if(!res.contains(newText))bfs.add(newText);
                }
            }
        }
        return new ArrayList<>(res);
    }
}