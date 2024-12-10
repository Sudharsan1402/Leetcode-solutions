class Solution {

    public int maximumLength(String s) {

        HashMap<String, Integer> count = new HashMap<>();


        for (int start = 0; start < s.length(); start++) {
            StringBuilder currString = new StringBuilder();

            for (int end = start; end < s.length(); end++) {
        
                if (
                    currString.length() == 0 ||
                    currString.charAt(currString.length() - 1) == s.charAt(end)
                ) {
                    currString.append(s.charAt(end)); 
                    count.put(
                        currString.toString(),
                        count.getOrDefault(currString.toString(), 0) + 1
                    );
                } else {
                    break;
                }
            }
        }

  
        int ans = 0;
        for (String str : count.keySet()) {
            if (count.get(str) >= 3 && str.length() > ans) ans = str.length();
        }

        if (ans == 0) return -1;
        return ans;
    }
}