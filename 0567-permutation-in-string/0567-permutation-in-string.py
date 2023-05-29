from collections import Counter

class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False
        count1 = Counter()
        count2 = Counter()
        for i in range(len(s1)):
            count1[s1[i]] += 1
            count2[s2[i]] += 1
        matches = 0
        for c in count1:
            matches += int(count1[c]==count2[c])
        for i in range(len(s2)-len(s1)):
            # print(count1, count2, matches)
            left, right = s2[i], s2[i+len(s1)]
            if len(count1) == matches:
                return True
            count2[right] += 1
            if count1[right] > 0:
                if count1[right] == count2[right]:
                    matches += 1
                elif count1[right] == count2[right]-1:
                    matches -= 1
            count2[left] -= 1
            if count2[left] == 0:
                count2.pop(left)
            if count1[left] > 0:
                if count1[left] == count2[left]:
                    matches += 1
                elif count1[left] == count2[left]+1:
                    matches -= 1
        return len(count1) == matches