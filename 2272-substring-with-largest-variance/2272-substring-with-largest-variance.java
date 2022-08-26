class Solution {
    public int largestVariance(String s) {
        int[] counts = new int[26];
        for(char c : s.toCharArray()){
            counts[c-'a']++;
        }
        int maxVariance = 0;
        for(int minc = 0; minc<26; minc++){
            for(int maxc = 0; maxc<26; maxc++){
                int mincRemain = counts[minc];
                int maxcRemain = counts[maxc];
                if(minc==maxc || mincRemain == 0 || maxcRemain == 0) continue;
                int mincCount = 0, maxcCount = 0;
                for(int i=0; i<s.length(); i++){
                    int c = s.charAt(i)-'a';
                    if(c == minc){
                        mincCount++;
                        mincRemain--;
                    }
                    if(c == maxc){
                        maxcCount++;
                    }
                    if(mincCount>0){
                        maxVariance = Math.max(maxVariance, maxcCount-mincCount);
                    }
                    if(mincCount>maxcCount && mincRemain>=1){
                        mincCount = 0;
                        maxcCount = 0;
                    }
                }
            }
        }
        return maxVariance;
    }
}