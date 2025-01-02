class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        String vowels = "aeiou";
        int n = words.length;
        int[] prefixSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (vowels.indexOf(words[i].charAt(0)) != -1 && vowels.indexOf(words[i].charAt(words[i].length() - 1)) != -1) {
                prefixSum[i + 1] = prefixSum[i] + 1;
            } else {
                prefixSum[i + 1] = prefixSum[i];
            }
        }

        int q = queries.length;
        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {
            int li = queries[i][0];
            int ri = queries[i][1];
            ans[i] = prefixSum[ri + 1] - prefixSum[li];
        }

        return ans;
    }
}