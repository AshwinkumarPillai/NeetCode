# TIME - O(n) - BUCKET-SORT
class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        
        freqMap = {}
        for num in nums:
            freqMap[num] = freqMap.get(num, 0) + 1       
        
        # len(nums) + 1 because i starts from 0, the first index of bucket will always be empty
        bucket = [[] for i in range(len(nums) + 1)]

        for num, freq in freqMap.items():
            bucket[freq].append(num)

        ans = []

        for i in range(len(bucket) - 1, 0, -1):
            for num in bucket[i]:
                ans.append(num)

        return ans[:k]
        

# TIME - O(klogn) - HEAP
class Solution(object):

    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        
        freqMap = {}

        for num in nums:
            if num not in freqMap.keys():
                freqMap[num] = 0
            else:
                freqMap[num] += 1
        
        minHeap = []

        for num, freq in freqMap.items():
            heapq.heappush(minHeap, (freq, num))
            if len(minHeap) > k:
                heapq.heappop(minHeap)

        return [num for freq, num in minHeap]

        

    # EASY BUILT-IN METHOD FOR THE SAME
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        
        freqMap = {}

        for num in nums:
            if num not in freqMap.keys():
                freqMap[num] = 0
            else:
                freqMap[num] += 1
        
        pairs = [(num, freq) for num, freq in freqMap.items()]

        return [item for item, _ in nlargest(k, pairs, key=lambda x: x[1])] # kinda beats the point of solving the question

# TIME - O(nlogn)
class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        
        freqMap = {}

        for num in nums:
            if num not in freqMap.keys():
                freqMap[num] = 0
            else:
                freqMap[num] += 1
        
        pairs = []

        for num, freq in freqMap.items():
            pairs.append((num, freq))

        pairs.sort(key = lambda x: x[1], reverse=True)

        return [pair[0] for pair in pairs[:k]]