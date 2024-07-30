class Solution:
    def nextClosestTime(self, time: str) -> str:
        cur_time = int(time[:2])*60 + int(time[3:])
        digits = {int(d) for d in time if d!=':'}
        while True:
            cur_time = (cur_time+1) % (24*60)
            if all(d in digits for block in divmod(cur_time, 60) for d in divmod(block, 10)):
                hh, mm = divmod(cur_time, 60)
                return f"{hh:02}:{mm:02}"