class MovingAverage:

    def __init__(self, size: int):
        self.num_q = collections.deque()
        self.max_size = size
        self.num_sum = 0

    def next(self, val: int) -> float:
        self.num_q.append(val)
        self.num_sum += val
        self.num_sum -= self.num_q.popleft() if len(self.num_q)>self.max_size else 0
        return self.num_sum/len(self.num_q)


# Your MovingAverage object will be instantiated and called as such:
# obj = MovingAverage(size)
# param_1 = obj.next(val)