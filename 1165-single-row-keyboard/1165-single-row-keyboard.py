class Solution:
    def calculateTime(self, keyboard: str, word: str) -> int:
        chat_map = {c: i for i, c in enumerate(keyboard)}
        i, time = 0, 0
        for c in word:
            time += abs(chat_map[c]-i)
            i = chat_map[c]
        return time