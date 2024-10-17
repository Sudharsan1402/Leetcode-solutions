class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int n = digits.length;
        int[] rightMaxIdx = new int[n];
        rightMaxIdx[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (digits[i] > digits[rightMaxIdx[i + 1]]) {
                rightMaxIdx[i] = i;
            } else {
                rightMaxIdx[i] = rightMaxIdx[i + 1];
            }
        }
        for (int i = 0; i < n; i++) {
            if (digits[i] != digits[rightMaxIdx[i]]) {
                swap(digits, i, rightMaxIdx[i]);
                break;
            }
        }
        return Integer.parseInt(new String(digits));
    }

    private void swap(char[] digits, int i, int j) {
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }
}