class Solution:
    def areSentencesSimilar(self, sentence1: List[str], sentence2: List[str], similarPairs: List[List[str]]) -> bool:
        if len(sentence1)!=len(sentence2):
            return False
        sim_map = defaultdict(set)
        for word1, word2 in similarPairs:
            sim_map[word1].add(word2)
            sim_map[word2].add(word1)
        for i, word1 in enumerate(sentence1):
            word2 = sentence2[i]
            if word1 != word2 and word2 not in sim_map.get(word1, set()):
                return False
        return True
                