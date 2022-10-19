class Solution {
    public int shortestWay(String source, String target) {
        Map<Character, Integer[]> indexMap = new HashMap<>();
        char[] srcArr = source.toCharArray();
        for(int i=0; i<srcArr.length; i++){
            indexMap.putIfAbsent(srcArr[i], new Integer[srcArr.length]);
            indexMap.get(srcArr[i])[i] = i+1;
        }
        for(Character c : indexMap.keySet()){
            Integer[] temp = indexMap.get(c);
            for(int j=temp.length-1, next=0; j>=0; j--){
                if(temp[j]==null){
                    temp[j] = next;
                }
                else {
                    next = temp[j];
                }
            }
        }
        int count=1, j=0;
        char[] tarArr = target.toCharArray();
        for(int i=0; i<tarArr.length; i++){
            if(!indexMap.containsKey(tarArr[i]))return -1;
            if(j==srcArr.length){
                j = 0;
                count++;
            }
            j = indexMap.get(tarArr[i])[j];
            if(j==0){
                count++;
                i--;
            }
        }
        return count;
    }
}