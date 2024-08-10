class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        unordered_map<char, int> char_count {};
        for (char c : magazine) {
            char_count[c]++;
        }
        for (char c : ransomNote) {
            if (char_count.find(c)!=char_count.end()) {
                char_count[c]--;
                if (char_count[c] == 0) char_count.erase(c);
            }
            else return false;
        }
        return true;
    }
};