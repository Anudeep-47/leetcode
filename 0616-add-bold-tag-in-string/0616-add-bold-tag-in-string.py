class Solution:
    def addBoldTag(self, s: str, words: List[str]) -> str:
        n = len(s)
        bolds = [False]*n
        for word in words:
            start = s.find(word)
            while start != -1:
                for i in range(start, start+len(word)):
                    bolds[i] = True
                start = s.find(word, start+1)
        result = []
        for i in range(n):
            if bolds[i] and (i==0 or not bolds[i-1]):
                result.append('<b>')
            result.append(s[i])
            if bolds[i] and (i==n-1 or not bolds[i+1]):
                result.append('</b>')
        return ''.join(result)