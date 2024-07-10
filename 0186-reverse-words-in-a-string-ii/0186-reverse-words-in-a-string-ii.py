class Solution:
    def reverseWords(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        def reverse_word(start, end):
            while start<end:
                s[start], s[end] = s[end], s[start]
                start, end = start+1, end-1
            return
        i, n = 0, len(s)
        for j in range(n):
            if j+1 == n or s[j+1] == ' ':
                reverse_word(i, j)
                i = j+2
        reverse_word(0, n-1)