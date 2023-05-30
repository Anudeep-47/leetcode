class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        times = [float(target - p) / s for p, s in sorted(zip(position, speed))]
        fleets = max_time = 0
        for t in times[::-1]:
            if t > max_time:
                fleets += 1
                max_time = t
        return fleets