class Solution {
    public char findKthBit(int n, int k) {
        int point = 1;
        for (int i = 1; i < n && point < k; i++) {
            point = point * 2 + 1;
        }
        int op = 0;
        while (point > 1) {
            int c = (point - 1) / 2;
            if (k == c + 1)
                return op % 2 == 0 ? '1' : '0';
            else if (k > c + 1) {
                k = point - k + 1;
                op++;
            }
            point = c;
        }
        return op % 2 == 0 ? '0' : '1';
    }
}