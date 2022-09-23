class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length())return -1;
        int[] arr = KMP(needle);
        int i=0, j=0;
        while(i<haystack.length() && j<needle.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }
            else if(j>0){
                j = arr[j-1];
            }
            else i++;
        }
        return j==needle.length() ? i-j : -1;
    }
    private int[] KMP(String needle){
        int[] arr = new int[needle.length()];
        for(int i=1, j=0; i<needle.length(); i++){
            if(needle.charAt(i)==needle.charAt(j)){
                arr[i] = j+1;
                j++;
            }
            else if(j>0){
                j = arr[j-1];
                i--;
            }
            else {
                arr[i] = 0;
            }
        }
        return arr;
    }
}