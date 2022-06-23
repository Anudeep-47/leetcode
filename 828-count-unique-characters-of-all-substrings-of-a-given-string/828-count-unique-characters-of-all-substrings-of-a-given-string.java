class Solution {
    public int uniqueLetterString(String s) {
        int subStrRange[][] = new int[s.length()][2];
        HashMap<Character, Integer> indexMap = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(indexMap.containsKey(c)){
                subStrRange[indexMap.get(c)][1] = i-1;
                subStrRange[i][0] = indexMap.get(c)+1;
            }
            else {
                subStrRange[i][0] = 0;
            }
            subStrRange[i][1] = s.length()-1;
            indexMap.put(c, i);
        }
        int count = 0;
        for(int i=0; i<s.length(); i++){
            count += (i-subStrRange[i][0]+1)*(subStrRange[i][1]-i+1);
        }
        return count;
    }
}