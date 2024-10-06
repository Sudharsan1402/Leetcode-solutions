class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        Deque<String> d1 = new ArrayDeque<>(Arrays.asList(sentence1.split(" ")));
        Deque<String> d2 = new ArrayDeque<>(Arrays.asList(sentence2.split(" ")));
        while(!d1.isEmpty() && !d2.isEmpty() && d1.peek().equals(d2.peek())){
            d1.poll();
            d2.poll();
            
        }
        while(!d1.isEmpty() && !d2.isEmpty() && d1.peekLast().equals(d2.peekLast())){
            d1.pollLast();
            d2.pollLast();
            
        }
        return d1.isEmpty() || d2.isEmpty();

        
    }
}