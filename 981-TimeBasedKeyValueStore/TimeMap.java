import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeSet;

class TimeMap {

    LinkedHashMap<String, HashMap<Integer, String>> mp;
    LinkedHashMap<String, TreeSet<Integer>> keyTimestamps;

    public TimeMap() {
        mp = new LinkedHashMap<String, HashMap<Integer, String>>();
        keyTimestamps = new LinkedHashMap<String, TreeSet<Integer>>();
    }

    public void set(String key, String value, int timestamp) {
        if (!mp.containsKey(key)) {
            mp.put(key, new HashMap<>() {
                {
                    put(timestamp, value);
                }
            });

            keyTimestamps.put(key, new TreeSet<Integer>(){{
                add(timestamp);
            }});

            return;
        }

        mp.get(key).put(timestamp, value);
        keyTimestamps.get(key).add(timestamp);

    }

    public String get(String key, int timestamp) {
        if (mp.containsKey(key)) {
            Integer prevTimestamp = keyTimestamps.get(key).floor(timestamp);
            return prevTimestamp == null ? "" : mp.get(key).get(prevTimestamp);
        }

        return "";

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */