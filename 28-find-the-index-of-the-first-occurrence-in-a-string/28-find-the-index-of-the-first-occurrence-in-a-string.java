class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length())return -1;
        for(int i=0; i<=haystack.length()-needle.length(); i++){
            if(startsWith(haystack, needle, i))return i;
        }
        return -1;
    }
    private boolean startsWith(String haystack, String needle, int index){
        for(int i=0; i<needle.length(); i++){
            if(haystack.charAt(i+index)!=needle.charAt(i))return false;
        }
        return true;
    }
}