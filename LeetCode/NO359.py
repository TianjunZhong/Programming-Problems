class Logger(object):

    def __init__(self):
        self.log_times = dict()

    def shouldPrintMessage(self, timestamp, message):
        """
        :type timestamp: int
        :type message: str
        :rtype: bool
        """
        last_time = self.log_times.get(message)
        if last_time != None and timestamp - last_time < 10:
            return False
        else:
            self.log_times.update({message: timestamp})
            return True            



# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)

obj = Logger()
print(obj.shouldPrintMessage(100, "bug"))
print(obj.shouldPrintMessage(105, "bug"))
print(obj.shouldPrintMessage(111, "bug"))