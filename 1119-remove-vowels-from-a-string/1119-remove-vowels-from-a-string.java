class Solution {
    public String removeVowels(String s) {
        StringBuilder res = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c!='a'&&c!='e'&&c!='i'&&c!='o'&&c!='u'){
                res.append(c);
            }
        }
        return res.toString();
    }
}