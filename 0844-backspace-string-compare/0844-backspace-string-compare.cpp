class Solution {
public:
    bool backspaceCompare(string s, string t) {
        int m { static_cast<int>(s.length())}, n { static_cast<int>(t.length())};
        int s_skip {}, t_skip {};
        int i { m-1 }, j { n-1 };
        while (i>=0 || j>=0) {
            while (i>=0) {
                if (s[i] == '#') s_skip++;
                else if (s_skip) s_skip--;
                else break;
                i--;
            }
            while (j>=0) {
                if (t[j] == '#') t_skip++;
                else if (t_skip) t_skip--;
                else break;
                j--;
            }
            if (i<0 != j<0) return false;
            if (i>=0 && s[i--]!=t[j--]) return false;
        }
        return true;
    }
};