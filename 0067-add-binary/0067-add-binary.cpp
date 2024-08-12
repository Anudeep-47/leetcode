class Solution {
public:
    string addBinary(string a, string b) {
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }
        int n { static_cast<int>(a.length()) };
        int m { static_cast<int>(b.length()) };
        string result {};
        int carry {}, j { m-1 };
        for (int i { n-1 }; i>=0; i--) {
            if (a[i] == '1') carry++;
            if (j>=0 && b[j--] == '1') carry++;
            result.push_back(carry%2 ? '1' : '0');
            carry /= 2;
        }
        if (carry) result.push_back('1');
        reverse(result.begin(), result.end());
        return result;
    }
};