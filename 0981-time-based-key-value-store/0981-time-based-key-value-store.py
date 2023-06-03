class TimeMap:

    def __init__(self):
        self.time_map = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key in self.time_map:
            self.time_map[key].append([timestamp, value])
        else:
            self.time_map[key] = [[timestamp, value]]

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.time_map:
            return ""
        if timestamp<self.time_map[key][0][0]:
            return ""
        left, right = 0, len(self.time_map[key])
        while left<right:
            mid = left+(right-left)//2
            if self.time_map[key][mid][0]<=timestamp:
                left = mid+1
            else:
                right = mid
        return "" if left==0 else self.time_map[key][left-1][1]


# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)