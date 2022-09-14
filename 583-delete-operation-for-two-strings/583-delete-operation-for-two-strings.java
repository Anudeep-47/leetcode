class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length()>word2.length()){
            String word = word1;
            word1 = word2;
            word2 = word;
        }
        int[] prev = new int[word1.length()+1];
        int[] cur = new int[word1.length()+1];
        for(int i=0; i<=word2.length(); i++){
            for(int j=0; j<=word1.length(); j++){
                if(i==0 || j==0){
                    cur[j] = Math.max(i, j);
                }
                else {
                    cur[j] = word1.charAt(j-1)==word2.charAt(i-1) ? prev[j-1] : 1 + Math.min(cur[j-1], prev[j]);
                }
            }
            int[] temp = cur;
            cur = prev;
            prev = temp;
        }
        return prev[word1.length()];
    }
}