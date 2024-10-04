class Solution {
    public int stoneGameII(int[] piles) {
        int N = piles.length;
        // Suffix sum array to store the total stones from i to N-1
        int[] suffixSum = new int[N];
        suffixSum[N - 1] = piles[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        // Memoization table, dp[i][M] stores the maximum stones the current player can collect starting at index i with M
        int[][] dp = new int[N][N];
        return helper(piles, 0, 1, dp, suffixSum);
    }

    private int helper(int[] piles, int i, int M, int[][] dp, int[] suffixSum) {
        if (i == piles.length) return 0; // No more stones left
        if (2 * M >= piles.length - i) return suffixSum[i]; // Can take all remaining stones
        if (dp[i][M] > 0) return dp[i][M]; // Return memoized result

        int maxStones = 0;
        for (int x = 1; x <= 2 * M; x++) {
            if (i + x > piles.length) break; // Avoid out-of-bounds
            // The opponent will get piles[i + x] onwards, maximize the current player's stones
            maxStones = Math.max(maxStones, suffixSum[i] - helper(piles, i + x, Math.max(M, x), dp, suffixSum));
        }
        dp[i][M] = maxStones;
        return maxStones;
    }
}
