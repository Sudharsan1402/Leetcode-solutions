class Solution {

    public int numWays(String[] words, String target) {
        int wordLength = words[0].length();
        int targetLength = target.length();

        final int MOD = 1_000_000_007;
        int[][] charFrequency = new int[wordLength][26];
        for (String word : words) {
            for (int j = 0; j < wordLength; j++) {
                charFrequency[j][word.charAt(j) - 'a']++;
            }
        }
        long[] prevCount = new long[targetLength + 1];
        long[] currCount = new long[targetLength + 1];
        prevCount[0] = 1;
        for (int currWord = 1; currWord <= wordLength; currWord++) {
            System.arraycopy(prevCount, 0, currCount, 0, currCount.length);
            for (int currTarget = 1; currTarget <= targetLength; currTarget++) {
                int curPos = target.charAt(currTarget - 1) - 'a';
                currCount[currTarget] +=
                    (1L *
                        charFrequency[currWord - 1][curPos] *
                        prevCount[currTarget - 1]) %
                    MOD;
                currCount[currTarget] %= MOD;
            }
            System.arraycopy(currCount, 0, prevCount, 0, prevCount.length);
        }
        return (int) prevCount[targetLength];
    }
}