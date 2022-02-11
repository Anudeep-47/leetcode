class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> char_pos;
        int max_len=0;
        for(int i=0, j=0; j<s.length(); j++){
            if(char_pos.find(s[j])!=char_pos.end() && char_pos[s[j]]>=i){
                i = char_pos[s[j]]+1;
            }
            char_pos[s[j]] = j;
            max_len = max(max_len, j-i+1);
        }
        return max_len;
    }
};