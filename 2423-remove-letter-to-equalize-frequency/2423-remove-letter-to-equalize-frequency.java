class Solution {
    public boolean equalFrequency(String word) {
        int[] charMap = new int[26];
        for(char c : word.toCharArray()){
            charMap[c-'a']++;
        }
        int firstMax=0, secondMax=0;
        for(int i=0; i<charMap.length; i++){
            if(charMap[i]>firstMax){
                secondMax = firstMax;
                firstMax = charMap[i];
            }
            else if(charMap[i]!=firstMax && charMap[i]>secondMax)secondMax = charMap[i];
        }
        int firstCount=0, secondCount=0;
        for(int i=0; i<charMap.length; i++){
            int val = charMap[i];
            if(val==0)continue;
            if(val==firstMax)firstCount++;
            else if(val==secondMax)secondCount++;
            else return false;
        }
        return (secondMax==0 && (firstMax==1 || firstCount==1)) || (firstCount==1 && firstMax-1==secondMax) || (secondMax==1 && secondCount==1);
    }
}