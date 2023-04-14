class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        total_gas, cur_gas = 0, 0
        start = 0
        for i in range(len(gas)):
            total_gas += gas[i]-cost[i]
            cur_gas += gas[i]-cost[i]
            if cur_gas < 0:
                cur_gas, start = 0, i + 1
        return start if total_gas >= 0 else -1
