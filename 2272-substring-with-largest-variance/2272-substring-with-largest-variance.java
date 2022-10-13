class Solution {
    public int largestVariance(String s) {
        int[] counts = new int[26];
        for(char c : s.toCharArray()){
            counts[c-'a']++;
        }
        int maxVariance = 0;
        for(int first=0; first<26; first++){
            for(int second=0; second<26; second++){
                int remainingFirst = counts[first];
                int remainingSecond = counts[second];
                if(first==second || remainingFirst==0 || remainingSecond==0)continue;
                int firstCount=0, secondCount=0;
                for(char c : s.toCharArray()){
                    int temp = c-'a';
                    if(temp == first){
                        firstCount++;
                        remainingFirst--;
                    }
                    if(temp == second){
                        secondCount++;
                    }
                    if(firstCount>0){
                        maxVariance = Math.max(maxVariance, secondCount-firstCount);
                    }
                    if(firstCount>secondCount && remainingFirst>=1){
                        firstCount=0;
                        secondCount=0;
                    }
                }
            }
        }
        return maxVariance;
    }
}