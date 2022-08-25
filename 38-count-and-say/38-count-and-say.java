class Solution {
    public String countAndSay(int n) {
        String res = "1";
        while(--n > 0){
            StringBuilder str = new StringBuilder();
            int count = 0;
            char c = res.charAt(0);
            for(int i=0; i<res.length(); i++){
                if(c != res.charAt(i)){
                    str.append(count);
                    str.append(c);
                    count = 0;
                    c = res.charAt(i);
                }
                count++;
            }
            str.append(count);
            str.append(c);
            res = str.toString();
        }
        return res;
    }
}