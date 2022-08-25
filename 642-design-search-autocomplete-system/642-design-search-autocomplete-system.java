class AutocompleteSystem {
    private class TrieNode {
        private List<String> hot;
        private TrieNode[] children;
        TrieNode(){
            hot = new ArrayList<>();
            children = new TrieNode[27];
        }
        private void addSentence(String sentence, int index){
            if(!hot.contains(sentence)){
                hot.add(sentence);
            }
            hot.sort((a,b) -> {
                if(count.get(a)==count.get(b))return a.compareTo(b);
                return count.get(b)-count.get(a);
            });
            if(hot.size()>3)hot.remove(hot.size()-1);
            if(index==sentence.length())return;
            getNext(sentence.charAt(index)).addSentence(sentence, index+1);
        }
        private TrieNode getNext(char c){
            int i = c == ' ' ? 26 : c-'a';
            if(children[i]==null){
                children[i] = new TrieNode();
            }
            return children[i];
        }
    }
    private Map<String, Integer> count;
    private StringBuilder str;
    private TrieNode root, cur;
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        count = new HashMap<>();
        str = new StringBuilder();
        root = new TrieNode();
        cur = root;
        for(int i=0; i<sentences.length; i++){
            count.put(sentences[i], times[i]);
            root.addSentence(sentences[i], 0);
        }
    }
    
    public List<String> input(char c) {
        if(c=='#'){
            String sentence = str.toString();
            count.put(sentence, count.getOrDefault(sentence, 0)+1);
            root.addSentence(sentence, 0);
            str = new StringBuilder();
            cur = root;
            return new ArrayList<>();
        }
        str.append(c);
        cur = cur.getNext(c);
        return cur.hot;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */