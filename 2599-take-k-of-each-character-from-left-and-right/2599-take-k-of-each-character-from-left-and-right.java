class Solution {
    int minInArray(int[] numberArray, int numberCount) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numberCount; i++) {
            min = Math.min(min, numberArray[i]);
        }
        return min;
    }

    public int takeCharacters(String s, int k) {
        int[] count = {0, 0, 0}; 
        int minutes = Integer.MAX_VALUE;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            count[s.charAt(i) - 'a']++;
        }

        if (minInArray(count, 3) < k)
            return -1;

        for (int l = 0, r = 0; r < len; r++) {
            count[s.charAt(r) - 'a'] -= 1;

            while (minInArray(count, 3) < k) {
                count[s.charAt(l) - 'a']++;
                l++;
            }
            minutes = Math.min(minutes, len - (r - l + 1));
        }

        return minutes;
    }
}