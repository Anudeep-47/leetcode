class Solution {
public:
    int romanToInt(string s) {
        unordered_map<char, int> r_to_i {
            {'I', 1}, {'V', 5}, {'X', 10}, {'L', 50}, 
            {'C', 100}, {'D', 500}, {'M', 1000}
        };
        int value {}, prev {}, cur {}, n { static_cast<int>(s.length()) };
        for (int i { n-1 }; i>=0; i--) {
            cur = r_to_i[s[i]];
            value += cur<prev ? -cur : cur;
            prev = cur;
        }
        return value;
    }
};