class Solution {
    public int kSimilarity(String s1, String s2) {
        Deque<String> q = new ArrayDeque<>();
        Set<String> seen = new HashSet<>();
        int swaps = 0;
        q.offer(s1);
        seen.add(s1);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                String s = q.poll();
                if(s.equals(s2))return swaps;
                for(String str : getNextStrings(s, s2)){
                    if(!seen.contains(str)){
                        q.offer(str);
                        seen.add(str);
                    }
                }
            }
            swaps++;
        }
        return -1;
    }
    private List<String> getNextStrings(String a, String b){
        List<String> strLst = new ArrayList<>();
        char[] achars = a.toCharArray();
        int i=0;
        while(i<achars.length && achars[i]==b.charAt(i)){
            i++;
        }
        for(int j=i+1; j<achars.length; j++){
            if(achars[j]==b.charAt(j) || achars[j]!=b.charAt(i))continue;
            swap(achars, i, j);
            strLst.add(new String(achars));
            swap(achars, i, j);
        }
        return strLst;
    }
    private void swap(char[] achars, int i, int j){
        char temp = achars[i];
        achars[i] = achars[j];
        achars[j] = temp;
    }
}