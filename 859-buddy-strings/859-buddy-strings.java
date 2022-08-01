class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length()!=goal.length())return false;
        if(s.equals(goal)){
            int[] charCount = new int[26];
            for(int i=0; i<s.length(); i++){
                charCount[s.charAt(i)-'a']++;
            }
            for(int i=0; i<26; i++){
                if(charCount[i]>1)return true;
            }
            return false;
        }
        else {
            int index1=-1, index2=-1;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)!=goal.charAt(i)){
                    if(index1==-1)index1 = i;
                    else if(index2==-1)index2 = i;
                    else return false;
                }
            }
            return index2!=-1 && s.charAt(index1)==goal.charAt(index2) && s.charAt(index2)==goal.charAt(index1);
        }
    }
}