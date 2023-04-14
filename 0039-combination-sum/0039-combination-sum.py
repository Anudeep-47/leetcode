class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        results = []
        def recursiveCombinations(remain_target, combination, index):
            if remain_target == 0:
                results.append(list(combination))
                return
            elif remain_target < 0:
                return
            for i in range(index, len(candidates)):
                combination.append(candidates[i])
                recursiveCombinations(remain_target-candidates[i], combination, i)
                combination.pop()
            return
        recursiveCombinations(target, [], 0)
        return results