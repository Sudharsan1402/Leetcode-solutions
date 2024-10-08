class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        int swap = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }
            else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    swap++;
                }

            }
        }
        return (swap+1)/2;
    }
}