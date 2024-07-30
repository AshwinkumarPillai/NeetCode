class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            arr[s.toCharArray()[i] - 'a'] += 1;
            arr[t.toCharArray()[i] - 'a'] -= 1;
        }

        for (int x : arr) {
            if (x != 0)
                return false;
        }

        return true;
    }
}