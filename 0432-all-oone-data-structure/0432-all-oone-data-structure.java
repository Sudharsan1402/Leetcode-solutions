import java.util.*;

class AllOne {
    private Map<String, Integer> keyCount;        // Stores key -> count
    private TreeMap<Integer, Set<String>> countMap; // Stores count -> set of keys with that count

    public AllOne() {
        keyCount = new HashMap<>();
        countMap = new TreeMap<>();
    }

    // Method to increment the count of a given key
    public void inc(String key) {
        int count = keyCount.getOrDefault(key, 0);
        // Remove the key from the current count set
        if (count > 0) {
            removeKeyFromCountMap(count, key);
        }
        // Update key count in keyCount map
        keyCount.put(key, count + 1);
        // Add the key to the new count set
        countMap.computeIfAbsent(count + 1, k -> new HashSet<>()).add(key);
    }

    // Method to decrement the count of a given key
    public void dec(String key) {
        int count = keyCount.getOrDefault(key, 0);
        if (count == 0) return; // If the key does not exist, return
        
        // Remove the key from the current count set
        removeKeyFromCountMap(count, key);
        
        if (count == 1) {
            keyCount.remove(key); // Remove the key from keyCount map if its count becomes 0
        } else {
            keyCount.put(key, count - 1); // Update the count in keyCount map
            // Add the key to the new count set
            countMap.computeIfAbsent(count - 1, k -> new HashSet<>()).add(key);
        }
    }

    // Method to get the key with the maximum count
    public String getMaxKey() {
        if (countMap.isEmpty()) return "";
        // Get the last entry (max count) in the TreeMap and return any key from the set
        return countMap.lastEntry().getValue().iterator().next();
    }

    // Method to get the key with the minimum positive count
    public String getMinKey() {
        if (countMap.isEmpty()) return "";
        // Get the first entry (min count) in the TreeMap and return any key from the set
        return countMap.firstEntry().getValue().iterator().next();
    }

    // Helper method to remove a key from the countMap
    private void removeKeyFromCountMap(int count, String key) {
        Set<String> keys = countMap.get(count);
        keys.remove(key);
        if (keys.isEmpty()) {
            countMap.remove(count); // Remove the entry if no keys remain for this count
        }
    }
}
