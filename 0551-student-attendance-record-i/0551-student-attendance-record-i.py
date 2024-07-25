class Solution:
    def checkRecord(self, s: str) -> bool:
        is_absent = False
        for i in range(len(s)):
            if s[i] == 'A':
                if is_absent:
                    return False
                else:
                    is_absent = True
            elif s[i] == 'L' and i>0 and i<len(s)-1:
                if s[i-1] == s[i] == s[i+1]:
                    return False
        return True