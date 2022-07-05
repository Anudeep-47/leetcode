class Trie {
    class Node {
        boolean isWord = false;
        List<Node> children = Arrays.asList(new Node[26]);
    }
    Node root, cur;
    List<String> suggestions;
    Trie(){
        root = new Node();
    }
    void insert(String str){
        cur = root;
        for(char c : str.toCharArray()){
            if(cur.children.get(c-'a')==null){
                cur.children.set(c-'a', new Node());
            }
            cur = cur.children.get(c-'a');
        }
        cur.isWord = true;
    }
    void dfs(Node cur, String word){
        if(suggestions.size()==3)return;
        if(cur.isWord){
            suggestions.add(word);
        }
        for(char c = 'a'; c<='z'; c++){
            if(cur.children.get(c-'a') != null){
                dfs(cur.children.get(c-'a'), word+c);
            }
        }
    }
    List<String> getWordsWith(String prefix){
        cur = root;
        suggestions = new ArrayList<String>();
        for(char c : prefix.toCharArray()){
            if(cur.children.get(c-'a')==null) return suggestions;
            cur = cur.children.get(c-'a');
        }
        dfs(cur, prefix);
        return suggestions;
    }
}

class Solution {
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        Trie trie = new Trie();
        for(String prod : products)trie.insert(prod);
        String prefix = new String();
        for(char c : searchWord.toCharArray()){
            prefix += c;
            result.add(trie.getWordsWith(prefix));
        }
        return result;
    }
}