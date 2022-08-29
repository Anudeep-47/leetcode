class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new ArrayList<String>();
        }
        Map<Character, String> digitMap = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
        List<String> res = new ArrayList<>();
        backtrack(digits, 0, new StringBuilder(), digitMap, res);
        return res;
    }
    private void backtrack(String digits, int index, StringBuilder str, Map<Character, String> digitMap, List<String> res){
        if(str.length()==digits.length()){
            res.add(str.toString());
            return;
        }
        for(char c : digitMap.get(digits.charAt(index)).toCharArray()){
            str.append(c);
            backtrack(digits, index+1, str, digitMap, res);
            str.deleteCharAt(str.length()-1);
        }
    }
}