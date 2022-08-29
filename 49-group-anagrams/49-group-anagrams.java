class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> strMap = new HashMap<>();
        for(String str : strs){
            int[] charMap = new int[26];
            for(char c : str.toCharArray()){
                charMap[c-'a']++;
            }
            StringBuilder key = new StringBuilder();
            int i=0;
            while(i<26){
                if(charMap[i]>0){
                    key.append(i+'a');
                    charMap[i]--;
                }
                else i++;
            }
            String keyStr = key.toString();
            strMap.putIfAbsent(keyStr, new ArrayList<String>());
            strMap.get(keyStr).add(str);
        }
        for(String keyStr : strMap.keySet()){
            List<String> strLst = strMap.get(keyStr);
            res.add(strLst);
        }
        return res;
    }
}