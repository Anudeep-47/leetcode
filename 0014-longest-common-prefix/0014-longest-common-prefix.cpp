class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        int min_len { static_cast<int>(strs[0].length()) };
        for (int i=0; i<min_len; i++) {
            char c { strs[0][i] };
            for (int j=1; j<strs.size(); j++) {
                if (i == strs[j].length() || strs[j][i]!=c) {
                    return strs[0].substr(0, i);
                }
            }
        }
        return strs[0];
    }
};