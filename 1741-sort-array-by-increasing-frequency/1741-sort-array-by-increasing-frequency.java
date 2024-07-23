class Solution {
    public int[] frequencySort(int[] nums) {
	Map<Integer, Integer> res = new HashMap<>();
	
	Arrays.stream(nums).forEach(n -> res.put(n, res.getOrDefault(n, 0) + 1));
	
	return Arrays.stream(nums).boxed()
			.sorted((a,b) -> res.get(a) != res.get(b) ? res.get(a) - res.get(b) : b - a)
			.mapToInt(n -> n)
			.toArray();
}
}