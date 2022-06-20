class Solution {
    public void createMap(String str, HashMap<Character, Integer> str_map){
        for(char c : str.toCharArray()){
            if(str_map.containsKey(c)){
                str_map.put(c, str_map.get(c)+1);
            }
            else str_map.put(c, 1);
        }
        return;
    }
    public int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> char_map = new HashMap<Character, Integer>();
        createMap(chars, char_map);
        int word_sum = 0;
        for(String word : words){
            HashMap<Character, Integer> word_map = new HashMap<Character, Integer>();
            createMap(word, word_map);
            int flag = 1;
            for(char c : word.toCharArray()){
                if(!char_map.containsKey(c) || char_map.get(c)<word_map.get(c)){
                    flag = 0;
                    break;
                }
            }
            if(flag==1){
                word_sum += word.length();
            }
        }
        return word_sum;
    }
}