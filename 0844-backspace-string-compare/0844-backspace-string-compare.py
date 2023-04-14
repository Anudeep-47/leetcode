class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        i, j = len(s)-1, len(t)-1
        back_s, back_t = 0, 0
        while True:
          while i>=0 and (s[i]=='#' or back_s):
            back_s += 1 if s[i]=='#' else -1
            i -= 1
          while j>=0 and (t[j]=='#' or back_t):
            back_t += 1 if t[j]=='#' else -1
            j -= 1
          if not (i>=0 and j>=0 and s[i]==t[j]):
            return i == -1 and j == -1
          i, j = i-1, j-1
        return True