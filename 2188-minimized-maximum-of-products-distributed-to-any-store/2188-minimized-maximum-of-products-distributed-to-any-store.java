class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1;
        int right = getMax(quantities);
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(mid, n, quantities)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private int getMax(int[] quantities) {
        int max = 0;
        for (int i = 0; i < quantities.length; i++) {
            int quantity = quantities[i];
            if (quantity > max) {
                max = quantity;
            }
        }
        return max;
    }
    private boolean canDistribute(int maxItemsPerStore, int n, int[] quantities) {
        int storesNeeded = 0;
        for (int i = 0; i < quantities.length; i++) {
            int quantity = quantities[i];
            int storesForThisProduct = (quantity + maxItemsPerStore - 1) / maxItemsPerStore;
            storesNeeded += storesForThisProduct;
            if (storesNeeded > n) {
                return false;
            }
        }
        return storesNeeded <= n;
    }
}