class Solution:
    def romanToInt(self, s: str) -> int:
        roman_to_int = {
            'M': 1000,
            'D': 500,
            'C': 100,
            'L': 50,
            'X': 10,
            'V': 5,
            'I': 1
        }
        size = len(s)
        i = 0
        value = 0
        while i<size-1:
            if roman_to_int[s[i]] >= roman_to_int[s[i+1]]:
                value += roman_to_int[s[i]]
            else:
                value += (roman_to_int[s[i+1]]-roman_to_int[s[i]])
                i += 1
            i += 1
        if i<size:
            value += roman_to_int[s[i]]
        return value