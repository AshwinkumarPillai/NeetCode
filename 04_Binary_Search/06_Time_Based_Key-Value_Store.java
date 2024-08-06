class TimeMap {

    Map<String, List<Pair<String, Integer>>> m;

    public TimeMap() {
        m = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!m.containsKey(key)) {
            m.put(key, new ArrayList<>());
        }
        m.get(key).add(new Pair<>(value, timestamp));
    }

    public String get(String key, int timestamp) {
        String ans = "";
        if (m.get(key) == null)
            return "";
        int l = 0, r = m.get(key).size() - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int tval = m.get(key).get(mid).getValue();
            if (tval == timestamp)
                return m.get(key).get(mid).getKey();
            if (tval < timestamp) {
                ans = m.get(key).get(mid).getKey();
                l = mid + 1;
            } else
                r = mid - 1;
        }

        return ans;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */