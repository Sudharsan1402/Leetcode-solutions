import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canArrange(int[] arr, int k) {
        // Create a frequency map to count the remainders
        Map<Integer, Integer> remainderMap = new HashMap<>();
        
        // Fill the frequency map with remainder counts
        for (int num : arr) {
            int remainder = num % k;
            // Handling negative remainders
            if (remainder < 0) {
                remainder += k;
            }
            remainderMap.put(remainder, remainderMap.getOrDefault(remainder, 0) + 1);
        }
        
        // Check pairs
        for (int rem : remainderMap.keySet()) {
            int count = remainderMap.get(rem);
            if (rem == 0) {
                // Remainder 0 must have even count
                if (count % 2 != 0) {
                    return false;
                }
            } else {
                int complement = k - rem;
                if (remainderMap.getOrDefault(complement, 0) != count) {
                    return false;
                }
            }
        }
        return true;
    }
}
