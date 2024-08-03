class Solution:
    def romanToInt(self, s: str) -> int:
        r_to_i = {'I':1, 'V':5, 'X':10, 'L':50, 'C':100, 'D':500, 'M':1000}
        if len(s) == 1:
            return r_to_i[s]
        rsum = 0
        i = 0
        while i<len(s)-1:
            first, second = r_to_i[s[i]], r_to_i[s[i+1]]
            if first < second:
                rsum += second-first
                i += 1
            else:
                rsum += first
            i += 1
        if i<len(s):
            rsum += r_to_i[s[i]]
        return rsum