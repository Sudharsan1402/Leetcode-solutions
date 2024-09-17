class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String s = s1 + " " + s2;
        Map<String, Integer> map = new HashMap<>();
        String[] words = s.split(" ");

        for(String word: words){
            map.put(word, map.getOrDefault(word,0)+1);
        }

        List<String> result = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1){
                result.add(entry.getKey());
            }
        }
        return result.toArray(new String[0]);
        
    }
    
}