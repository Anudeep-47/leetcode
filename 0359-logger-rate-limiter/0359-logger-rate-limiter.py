class Logger:

    def __init__(self):
        self.log_map = {}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if (message in self.log_map and self.log_map[message]+10 <= timestamp) or message not in self.log_map:
            self.log_map[message] = timestamp
            return True
        return False


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)