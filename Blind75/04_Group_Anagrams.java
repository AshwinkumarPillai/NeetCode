class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();

        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);

            if (!m.containsKey(key)) {
                m.put(key, new ArrayList<>());
            }

            m.get(key).add(s);
        }

        List<List<String>> ans = new ArrayList<>();

        for (List<String> val : m.values()) {
            ans.add(val);
        }

        return ans;
    }
}