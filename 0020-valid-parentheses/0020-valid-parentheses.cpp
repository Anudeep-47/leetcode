class Solution {
public:
    bool isValid(string s) {
        unordered_map<char, char> mappings {};
        mappings[')'] = '(';
        mappings['}'] = '{';
        mappings[']'] = '[';
        stack<char> stk {};
        for (char c : s) {
            if (c == '(' || c == '{' || c == '[') {
                stk.push(c);
            }
            else if (!stk.empty() && stk.top() == mappings[c]) {
                stk.pop();
            }
            else return false;
        }
        return stk.empty();
    }
};