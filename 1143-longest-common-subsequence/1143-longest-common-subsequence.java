class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length()>text2.length()){
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }
        int[] prev = new int[text1.length()+1];
        int[] cur = new int[text1.length()+1];
        for(int i=0; i<text2.length(); i++){
            for(int j=0; j<text1.length(); j++){
                if(text1.charAt(j)==text2.charAt(i)){
                    cur[j+1] = 1 + prev[j];
                }
                else {
                    cur[j+1] = Math.max(cur[j], prev[j+1]);
                }
            }
            int[] temp = prev;
            prev = cur;
            cur = temp;
        }
        return prev[text1.length()];
    }
}