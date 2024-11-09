class Solution {
    public long minEnd(int n, int x) {
        n--;  
        int[] xBits = new int[64];
        int[] nBits = new int[64];
        
        for (int i = 0; i < 32; i++) {
            xBits[i] = (x >> i) & 1;
            nBits[i] = (n >> i) & 1;
        }
        
        int j = 0;
        for (int i = 0; i < 64 && j < 64; i++) {
            if (xBits[i] == 0) {
                xBits[i] = nBits[j++];
            }
        }
        
        long result = 0;
        for (int i = 0; i < 64; i++) {
            result |= ((long)xBits[i] << i);
        }
        
        return result;
    }
}