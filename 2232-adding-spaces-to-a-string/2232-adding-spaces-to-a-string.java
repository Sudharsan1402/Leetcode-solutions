class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        Set<Integer> spaceSet = new HashSet<>();
        for (int space : spaces) {
            spaceSet.add(space);
        }
        for (int i = 0; i < s.length(); i++) {
            if (spaceSet.contains(i)) {
                sb.append(' ');
            }
            sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}
