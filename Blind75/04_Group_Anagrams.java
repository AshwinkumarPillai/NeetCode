class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> m = new HashMap<>();

        for (String s : strs) {

            int[] bitMap = new int[26];

            for (char x : s.toCharArray()) {
                bitMap[x - 'a'] += 1;
            }

            StringBuilder keyB = new StringBuilder();
            for (int x : bitMap) {
                keyB.append(x).append("#"); // use '#' as separator
            }

            String key = keyB.toString();

            if (!m.containsKey(key)) {
                m.put(key, new ArrayList<>());
            }

            m.get(key).add(s);

        }

        List<List<String>> ans = new ArrayList<>(m.values());

        return ans;
    }
}