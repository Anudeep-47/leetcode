class Solution:
    def groupStrings(self, strings: List[str]) -> List[List[str]]:
        def hash(string):
            dif_chars = []
            for i in range(len(string)-1):
                dif_chars.append(chr((ord(string[i+1])-ord(string[i]))%26+ord('a')))
            return ''.join(dif_chars)
        groups = defaultdict(list)
        for string in strings:
            groups[hash(string)].append(string)
        return list(groups.values())