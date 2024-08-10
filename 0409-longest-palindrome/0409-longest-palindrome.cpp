class Solution {
public:
    int longestPalindrome(string s) {
        unordered_set<char> char_set {};
        int max_len {};
        for (char c : s) {
            if (char_set.find(c)!=char_set.end()) {
                char_set.erase(c);
                max_len += 2;
            }
            else char_set.insert(c);
        }
        return max_len + (char_set.size()>0 ? 1 : 0);
    }
};