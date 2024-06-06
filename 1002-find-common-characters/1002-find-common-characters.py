class Solution:
    def commonChars(self, words: List[str]) -> List[str]:
        char_count = collections.Counter(words[0])
        for word in words[1:]:
            char_count &= collections.Counter(word)
        return list(char_count.elements())