class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.length() != t.length()) return false;
        unordered_map<char, int> char_map {};
        for (char c : s) {
            if (char_map.find(c)!=char_map.end()) {
                char_map[c]++;
            }
            else {
                char_map[c] = 1;
            }
        }
        for (char c : t) {
            if (char_map.find(c)!=char_map.end()) {
                char_map[c]--;
                if (char_map[c] == 0) {
                    char_map.erase(c);
                }
            }
            else return false;
        }
        return true;
    }
};