class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text2.length() < text1.length()){
            String text = text1;
            text1 = text2;
            text2 = text;
        }
        int[] prev = new int[text1.length()+1];
        int[] cur = new int[text1.length()+1];
        for(int i=text2.length()-1; i>=0; i--){
            for(int j=text1.length()-1; j>=0; j--){
                if(text2.charAt(i)==text1.charAt(j)){
                    cur[j] = 1 + prev[j+1];
                }
                else{
                    cur[j] = Math.max(cur[j+1], prev[j]);
                }
            }
            int[] temp = cur;
            cur = prev;
            prev = temp;
        }
        return prev[0];
    }
}