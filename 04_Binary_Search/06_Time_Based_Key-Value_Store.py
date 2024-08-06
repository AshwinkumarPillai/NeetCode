class TimeMap(object):

    def __init__(self):
        self.map = {}

    def set(self, key, value, timestamp):
        """
        :type key: str
        :type value: str
        :type timestamp: int
        :rtype: None
        """

        if key not in self.map:
            self.map[key] = []
        self.map[key].append([value, timestamp])


    def get(self, key, timestamp):
        """
        :type key: str
        :type timestamp: int
        :rtype: str
        """
        ans = ""
        vals = self.map.get(key, [])
        l, r = 0, len(vals) - 1

        while l <= r:
            mid = l + (r - l) / 2
            tval = vals[mid][1]
            if tval == timestamp:
                return vals[mid][0]
            if timestamp > tval:
                ans = vals[mid][0]
                l = mid + 1
            else:
                r = mid - 1
                
        return ans
        

# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)