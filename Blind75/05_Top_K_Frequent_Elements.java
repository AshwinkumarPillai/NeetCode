// TIME - O(n) - BUCKET-SORT
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();

        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> bucket = new ArrayList<>(nums.length + 1);
        for (int i = 0; i <= nums.length; i++) {
            bucket.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            bucket.get(entry.getValue()).add(entry.getKey());
        }

        int[] ans = new int[k];

        int j = 0;

        for (int i = bucket.size() - 1; i >= 0; i--) {
            for (int x : bucket.get(i)) {
                ans[j++] = x;
                if (j == k)
                    return ans;
            }
        }

        return ans;
    }
}

// TIME - O(klogn) - HEAP
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();

        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> pair : m.entrySet()) {
            minHeap.offer(pair);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = minHeap.poll().getKey();
        }

        return ans;
    }
}

// TIME - O(nlogn)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();

        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> pairs = new ArrayList<>(m.entrySet());

        pairs.sort((a, b) -> b.getValue() - a.getValue());

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pairs.get(i).getKey();
        }

        return ans;
    }
}