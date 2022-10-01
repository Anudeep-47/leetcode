class Solution {
    public boolean equalFrequency(String word) {
        int[] charMap = new int[26];
        
        // counting frequency
        for(char c : word.toCharArray()){
            charMap[c-'a']++;
        }
        
        // finding first max frequency and second max frequency (not same as first)
        int firstMax=0, secondMax=0;
        for(int i=0; i<charMap.length; i++){
            if(charMap[i]>firstMax){
                secondMax = firstMax;
                firstMax = charMap[i];
            }
            else if(charMap[i]!=firstMax && charMap[i]>secondMax)secondMax = charMap[i];
        }
        
        // counting how many times first max frequency and second max frequency occurs
        // return false if any other third value occurs except 0
        int firstCount=0, secondCount=0;
        for(int i=0; i<charMap.length; i++){
            int val = charMap[i];
            if(val==0)continue;
            if(val==firstMax)firstCount++;
            else if(val==secondMax)secondCount++;
            else return false;
        }
        
        // we may delete from characters having first max frequency or second max frequency
        // 1. if no second max freq that means either first max frequency should be 1 
        //     or only 1 character with first max frequency
        // 2. if deleting characters having second max frequency then only one case where 
        //     second max frequency is 1 and also number of characters having that frequency is 1
        // 3. if deleting characters having first max frequency then there can only be 1 character 
        //     having first max frequency and after deleting it should match second max frequency
        return (secondMax==0 && (firstMax==1 || firstCount==1)) || (secondMax==1 && secondCount==1) || (firstCount==1 && firstMax-1==secondMax);
    }
}