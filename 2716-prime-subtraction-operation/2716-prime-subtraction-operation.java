class Solution {
    private static final boolean[] isPrime = new boolean[1001];
    private static final List<Integer> primes = new ArrayList<>();

    static {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= 1000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 1000; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= 1000; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
    }

    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        
        if (n == 1) {
            return true;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] >= nums[i + 1]) {
                int target = nums[i] - nums[i + 1] + 1;
                int primeToSubtract = findFirstLargerPrime(target, nums[i]);

                if (primeToSubtract == -1 || primeToSubtract >= nums[i]) {
                    return false;
                }
                nums[i] -= primeToSubtract;
            }
        }
        
        return true;
    }

    private int findFirstLargerPrime(int target, int maxVal) {
        int left = 0, right = primes.size() - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int prime = primes.get(mid);
            
            if (prime >= target) {
                result = prime;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return result < maxVal ? result : -1;
    }
}